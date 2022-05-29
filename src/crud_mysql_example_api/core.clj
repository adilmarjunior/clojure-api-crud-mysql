(ns crud-mysql-example-api.core
  (:gen-class) 
  (:require [crud-mysql-example-api.server :as server]))

(defn -main [& _]
  (server/start))