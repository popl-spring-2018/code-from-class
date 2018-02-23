(ns class-code.lab1.bonus-2)


(defn group_names
  " Ayoo "
  [names]
  (map names '("Emma" "Geo" "Peter")))


(defn bonus_cjs
  [f]
  (map (fn [person] (f person)) ["Sam", "Caius", "Jack"])) 
