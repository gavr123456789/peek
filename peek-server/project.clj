(defproject peek-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring "1.10.0"]
                 [ring/ring-jetty-adapter "1.10.0"]
                 [compojure "1.7.0"]
                 [org.clojure/data.json "2.4.0"]
                 ;; The underlying driver -- any newer version can also be used
                 [org.mongodb/mongodb-driver-sync "4.11.1"]
                 ;; This wrapper library
                 [mongo-driver-3 "0.8.0"]]
  :repositories [["datomic-free" {:url "https://my.datomic.com/repo"}]]
  :main ^:skip-aot peek-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.4.0"]]}})


