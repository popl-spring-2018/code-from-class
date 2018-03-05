(ns class-code.infinite-sequences)

;; From last week

(defn prime?
  "Returns true if x is prime, false otherwise."
  [x]
  (if (< x 2)
    false
    (empty?
     (filter (fn [divisor] (zero? (mod x divisor)))
             (range 2 x)))))

;;;;;;;
;; Infinite sequences


(take 5 (filter even? (range 1000000)))

(first (filter (fn [x] (> x 1000))
               (range)))

(take 10 (map #(* % %)
              (range)))

(def primes (filter prime? (range)))


(first (filter (fn [x] (> x 1000000))
               (map #(* % %) (range))))

; repeat

(take 5 (repeat :hi))

(repeat 5 :hi)

(take 5 (repeat '()))

; repeatedly

(take 5 (repeatedly rand))

(repeatedly 5 rand)

(repeatedly 5 list)

(take 5 (map #(+ 100 %)
             (repeatedly rand)))

(take 5 (repeatedly #(+ 100 (rand))))

; iterate
; creates an infinite sequence of:
; (x, f(x), f(f(x)), f(f(f(x))), etc.

(take 5 (iterate inc 10))

(take 8 (iterate list 9))

(take 10 (iterate #(* 2 %) 1))

(nth (iterate #(*' 2 %) 1) 100)

(def infinite-foobar
  (iterate (fn [s] (str s "bar"))
           "foo"))

(take 6 infinite-foobar)

(first (filter #(> (count %) 40) infinite-foobar))


(defn next-fib
  [[x y]]
  [y (+' x y)])

(next-fib [0 1])
(next-fib [1 1])
(next-fib [1 2])

(def fib-sequence
  (map first
       (iterate next-fib [0 1])))

(take 10 fib-sequence)

(defn fast-fib
  [n]
  (nth fib-sequence n))

(fast-fib 10000)

(fast-fib 9000)

(drop 50 (take 100 fib-sequence))

(map fast-fib (range 50 100))
