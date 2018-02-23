(ns class-code.lab1.problem-2)

(defn three-copies
  ""
  [ls other]
  (concat ls (other other other)))


(defn three 
  "This method adds three of the same arg to the beginning of a list"
  [list arg]
  (conj (conj (conj list arg) arg) arg)
  )


(defn triple
  " This adds the other arg to the beginning of the lst three times
  "
  [lst other]
  (conj
   (conj (conj lst other) other) other)
  )


(defn threeCopies
  "copies 3 times and blablabla"
  [list thing]
  (dotimes [thing 3]
                 (conj list thing))
  list
  )
