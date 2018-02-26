(ns class-code.lab1.problem-5)

(defn first-middle-last 
  [[x]]
  (let [first_nus (first x)
        length (count x)
        ;middle (nth x  (+ 1 count/2))
        ])  
  ())


(defn function-123
  takes a list returns first, middle, last
  [list]
  ;return conj (+ (first list) (if )  (/ (lastIndex)) ))
  )


(defn jack_caius_sam
  "Hello. POPL peeps."
  [list1]
  '((first list1)
    (nth list1 (/ (count list1) 2))
    (last list1)))


(defn george
  [ls]
  (first ls))


(defn triad
  "returns the first middle and last elements of a list"
  [lst]
  ((first lst)
   (nth lst (int (quot (count lst) 2 )))
   (last lst))
  )
