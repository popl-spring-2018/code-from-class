(ns class-code.functions)

; let: allows you to assign values to symbols within a lexical context
; let is your friend and you should use it often!
; note: assigned in order, so later assignments can reference earlier
(let [nums '(7 2 3 3 1)
      the-first (first nums)]
  (* the-first the-first))

; note that no pure functions change values associated with symbols!
; also: let returns last thing evaluated; nothing else matters
; unless it has side effects like printing
(let [nums '(7 2 8 1 0)]
  (println nums)
  (println (conj nums 100))
  (println nums)
  (rest nums))

; defn
; define function
(defn square
  "Squares the input x; this is a docstring"
  [x] ; this is the parameter
  (* x x)) ; functions return the last (or only) thing they evaluate

(square 5)
(square 3.6)
(square (/ 2 3))
;(square "hi") ;error! multiplication can't take a string

(defn print-strings-and-concatenate
  "Like with let, defn can do multiple steps and then return last
  thing evaluated. Only last thing is returned!"
  [string1 string2]
  (println string1)
  (println string2)
  (str string1 string2))

(print-strings-and-concatenate "hi" "there")
(print-strings-and-concatenate "helloooo" "there")

(defn sphere-volume
  "Calculates volume of a sphere. Example of using let"
  [radius]
  (let [r-cubed (* radius radius radius)
        volume (* 4/3 Math/PI r-cubed)]
    volume))
