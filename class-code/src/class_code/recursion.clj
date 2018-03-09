(ns class-code.recursion)

(def nums (range 4 12))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; --Recursion--
(defn my-count
  [lst]
  (if (empty? lst)
    0
    (inc (my-count (rest lst)))))

(my-count nums)

(my-count (range 100000))
;; Error, stack overflow
;; Recursive calls in Clojure consume stack space, and Java
;; isn't very friendly to this recursion. More later.

(defn fib
  "The nth Fibonacci number"
  [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else  (+ (fib (dec n))
              (fib (dec (dec n))))))

(fib 5)

(map fib (range 10))

(fib 100) ; Don't do -- will take a long time!

(defn my-reduce
  ([function coll]
    (my-reduce function (first coll) (rest coll)))
  ([function start-val coll]
    (if (empty? coll)
      start-val
      (my-reduce function
                 (function start-val
                           (first coll))
                 (rest coll)))))

(my-reduce + nums)

(my-reduce list '() nums)


; Tail recursion
; By using recur instead of a recursive call, and not doing anything
; besides returning the recursive result, Clojure doesn't have to track
; the recursive calls and can be more efficient

; With recur, can't do anything with the result of the recursive call

(defn first-positive-in-list
  [numbers]
  (cond
    (empty? numbers) nil
    (< 0 (first numbers)) (first numbers)
    :else (recur (rest numbers))))

(first-positive-in-list '(-3 -2 -6 4 -2 77))

; This would stack overflow without recur
(first-positive-in-list (range -1000000 5))

; loop simply sets the recursion point for recur, and declares
; parameters with their initial values.
; Note: it is not a loop, it is recursion.

(defn my-tail-count
  [in-lst]
  (loop [lst in-lst
         c 0]
    (if (empty? lst)
      c
      (recur (rest lst)
             (inc c)))))

(my-tail-count '(1 2 3 4 5 6 7))

(my-tail-count (range 100000))


(defn my-tail-fib
  [n]
  (loop [n n
         x 0
         y 1]
    (if (<= n 0)
      x
      (recur (dec n)
             y
             (+' x y)))))

(map my-tail-fib (range 10))

(my-tail-fib 100)

(my-tail-fib 100000)
