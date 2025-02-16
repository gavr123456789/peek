;; (ns peek-server.core
;;   (:gen-class))

;; (defn -main
;;   "I don't do a whole lot ... yet."
;;   [& args]
;;   (println "Hello, World!"))
(ns peek-server.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [ring.util.response :as response]
            [clojure.data.json :as json]
            [mongo-driver-3.client :as mcl]
            [mongo-driver-3.collection :as mc])
  (:import [java.util Date])
  (:gen-class))

;; --- Подключение к MongoDB ---
(def mongo-uri "mongodb://gavr:1111@localhost:27017/sasss")
(def conn (mcl/connect-to-db mongo-uri))
(def db (:db conn))

(def collection "notes")

;; --- Handlers ---
(defn handle-ping [_]
  (response/response (json/write-str {:status "ok"})))

(defn handle-post-note [req]
  (let [body (slurp (:body req))
        {:strs [text date]} (json/read-str body)
        note {:text text :date (Long/parseLong date)}]
    (prn note)
    (mc/insert-one db collection note)
    (response/response (json/write-str {:status "saved"}))))

(defn handle-get-notes [_]
  (let [notes (mapv #(dissoc % :_id) (mc/find db collection {} {}))
        count-all (mc/count-documents db collection)]
    (prn notes)
    (prn count-all)
    (response/response (json/write-str notes))))

;; --- Routes ---
(defroutes app
  (GET "/ping" [] handle-ping)
  (POST "/note" req (handle-post-note req))
  (GET "/notes" [] handle-get-notes)
  (route/not-found "Not Found"))

;; --- Запуск сервера ---
(defn -main []
  (run-jetty app {:port 3000 :join? false}))
