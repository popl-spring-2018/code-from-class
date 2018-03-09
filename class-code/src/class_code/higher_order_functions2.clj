(ns class-code.higher-order-functions2)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Practice as a class:
;; Function that finds all prime numbers less than input upper-bound

(defn prime?
  "Returns true if x is prime, false otherwise."
  [x]
  (if (< x 2)
    false
    (empty?
     (filter (fn [divisor] (zero? (mod x divisor)))
             (range 2 x)))))

(defn primes
  "Returns list of all prime numbers less than upper-bound."
  [upper-bound]
  (filter prime? (range upper-bound)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; --Higher-order function-- that returns a function
(defn square-old [x] (* x x))
(defn cube-old [x] (* x x x))

(defn powerer
  "Returns a function that raises argument to exponent power"
  [exponent]
  (fn [argument] ; NOTE: returns an anonymous function
    (apply * (repeat exponent argument))))

(def cube (powerer 3))

(cube 5)

(def to-the-tenth (powerer 10))

(to-the-tenth 2)
(to-the-tenth 3.7)

((powerer 10) 2)

; This is a _closure_ - a function with an environment,
; which gives each free variable a value at the time
; the function was created
; The free variable in this case is exponent


(defn concat-string-with
  "Returns a function that takes a string and concats it
  onto start-string"
  [start-string]
  (fn [s]
    (str start-string s)))

(def say-hello (concat-string-with "hello "))

(say-hello "Susan")
(say-hello "Bill")

(def t-minus (concat-string-with "T-minus "))

(t-minus 10)
(map t-minus (reverse (range 10)))

;; Another closure example

(defn log-fn-then-execute
  "Logs (prints) the function and then executes it.
  Note: this function takes a function as an argument, and also
  returns a function."
  [f]
  (fn [& args]
    (println (conj args f))
    (apply f args)))

(def logged+ (log-fn-then-execute +))
(logged+ 4 3)
(logged+ 1 2 3 4 5)

(def logged-str (log-fn-then-execute str))
(logged-str "hi" "there")
(map logged-str (range 5))

(defn square
  [x]
  (* x x))

(def logged-square (log-fn-then-execute square))
(logged-square 5)

(def logged-anon-square (log-fn-then-execute #(* % %)))
(logged-anon-square 3)
