(ns class-code.lab1.problem-6)

(defn problem_6
  "Problem 6"
  [ints]
  nil
  #_(map (fn [num] )) )


(defn ones
  "Hi"
  [x]
  #_(let [y (map last x)
        
        ]y))


(defn onesDigit
  [listOfPositive]
  (map last
       (map str listOfPositive)))


(defn caius_jack_sam
  [list1]
  (map (fn [item] (mod item 10)) list1))
