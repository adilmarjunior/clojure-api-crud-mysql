(ns crud-mysql-example-api.database
  (:require [korma.db :as korma]))

(def db-connection-info 
    (korma/mysql 
        {:db "crud-mysql-example"
         :user "root"
         :password "root"}))
; set up korma
(korma/defdb db db-connection-info)