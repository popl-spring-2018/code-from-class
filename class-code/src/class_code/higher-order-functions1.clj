(ns clojure-for-class.higher-order-functions1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Range gives a list of numbers in a range
(def nums (range 4 12))
nums

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;  Higher Order Functions
;; Functions that take functions as arguments or
;; return functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; --Apply--
(+ nums) ; not what we want
(apply + nums) ;yay

(str nums) ; probably not what we want
(apply str nums)

(max nums) ; not what we want
(apply max nums)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; --Map-- applies a function to every element of a list
(inc 5)

(map inc nums)

; We can use our own functions
(defn square
  [x]
  (* x x))

(map square nums)

; We can use anonymous functions!
(map (fn [x] (* x 5))
     nums)

; Special form for simple anonymous functions:
(map #(* % 5) nums)

; Find the lengths of each word in a list
(map count '("what" "is" "this" "nonsense"))

; Write function that tests whether a list of words is sorted by length
(defn sorted-by-length?
  [words]
  (apply < (map count words)))

(sorted-by-length? '("hi" "there" "wednesday"))
(sorted-by-length? '("zombie" "invasion" "now"))

; In a list of maps, get a list of the :name values from each map
(def people '({:name "Kelly" :age 22}
               {:name "Francis" :age 34}
               {:name "Olivia" :age 19}))

(map #(get % :name) people)
(map :name people) ; this is the same

; Apply a bunch of functions to arguments 5 and 8
(map (fn [function]
       (function 5 8))
     [+ - * / mod < str vector])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; --Filter-- applies a function to each element, and
;    returns the ones for which that function returns true
(filter even? nums)

(filter (fn [x] (> x 8)) nums)

(filter #(> % 8) nums) ;Same with different syntax

; How would we take a list of words and only retain those of length > 5?
(filter #(> (count %) 5) '("only" "the" "longest" "words" "will" "survive"))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; --Reduce-- interposes function calls between elements of
;            a list
(reduce + nums)
(apply + nums) ;another way

(reduce + 100 nums) ; can provide initial "left" argument

(reduce (fn [x y] (str x ", " y)) nums)
(reduce #(str %1 ", " %2) nums)
(apply str (interpose ", " nums)) ;another way

(reduce conj '() nums)
(reverse nums) ;another way

(reduce list nums)
(reduce list '() nums) ;NO OTHER WAY

; Let's say you have a list of things (keywords in this example)
; You want to say how often each appears in the list, by creating
; a map of key/count pairs.
(def letters '(:a :b :c :a :a :b :a :a :c :c :a :c :d :a :b))

(defn inc-count-in-map
  [count-map k]
  (assoc count-map
         k
         (inc (get count-map k 0))))

(reduce inc-count {} letters)
(frequencies letters) ;another way

(reduce #((rand-nth [+ - * /]) %1 %2) nums) ;NO OTHER WAY
