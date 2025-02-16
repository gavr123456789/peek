# peek-server
Not ready yet  
  

## Run
### Start ferret db
`ferretdb --handler="sqlite" --setup-database="sasss" --setup-username="gavr" --setup-password="1111" --test-enable-new-auth --sqlite-url="file:///home/gavr/Documents/ferretdb/"`

`mongosh --authenticationDatabase "sasss" -u "gavr" -p "1111" `


## Test
`> curl -X GET http://localhost:3000/ping`
`> curl -X GET http://localhost:3000/notes`

`> curl -X POST http://localhost:3000/note -H "Content-Type: application/json" -d '{"text": "Hello, Clojure!", "date": "1700000000000"}'`


## License

Copyright © 2025 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
