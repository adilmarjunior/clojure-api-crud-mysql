(ns crud-mysql-example-api.query
  (:require [crud-mysql-example-api.database]
            [korma.core :refer :all]))

(defentity items)

(defn get-items []
  (select items))

(defn add-item [title description]
  (insert items
          (values {:title title :description description})))

(defn delete-item [id]
  (delete items
          (where {:id [= id]})))

(defn update-item [id title description]
  (update items
          (set-fields {:title title
                       :description description})
          (where {:id [= id]})))

(defn get-item [id]
  (first
   (select items
           (where {:id [= id]}))))


(comment
  (def addTestFunc (add-item "Testing" "My First Item"))
  (def idInserted (:generated_key addTestFunc))
  (get-todos)
  (get-item idInserted)
  (update-item idInserted "title updated" "description updated")
  (delete-item idInserted)
  )
  
  