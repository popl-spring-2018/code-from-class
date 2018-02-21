(ns clojure-for-class.conditionals-def-maps)

; if: if first argument is true, does first thing; otherwise, do second thing
(if (< 1 4)
  (str 1 " is smaller")
  (str 4 " is smaller"))

; when: just does true part of if; if condition false, returns nil
(when true
  (println "yay"))
(when false
  (println "boo"))

; cond: takes multiple condition/what to do pairs:
(defn how-big
  "Tells how big a number is"
  [num]
  (cond
    (<= num 0) "Is so negative"
    (< num 10) "Single digit"
    (< num 100) "A bit bigger"
    :else (str "OMG " num " IS SO BIG"))) 

(how-big -4)
(how-big 4)
(how-big 40)
(how-big 400)

; def: used to GLOBALLY assign a constant value to a symbol
;      that will not change
(def more-nums '(1 2 3 4 5))
more-nums
(rest more-nums) ; doesn't change the value, just returns different value
more-nums

; note: NEVER use def inside other code; just at outermost level
; if you find yourself using def to change values of variables, stop!
; you should rarely need to use def in your programs at all

; turns out, defn is just shorthand for (def name (fn ...))
; (fn ...) defines an anonymous function!
(def cube
  (fn [x]
    (* x x x)))

(cube 5)

; you can define locally-scoped functions using anonymous functions:
(let [local-cube (fn [x] (* x x x))]
  (local-cube 4))

; (local-cube 4) ;error!


;; Maps: like dictionaries in Python, hashes in Ruby
{} ;empty map

{:apples 4
 :bananas 6
 :cantaloupes 10}

(def room-colors {:dining-room :taupe
                  :kitchen :mauve
                  :living-room :mint
                  :bedroom :lavendar})
room-colors

; Adds a key-value pair to a map and returns the resulting map
(assoc room-colors :bathroom :cerulean)
(assoc room-colors :office :cranberry)
room-colors ; Note that no state is changed!

; Retrieves a value
(get room-colors :kitchen)
(get room-colors :den)
(get room-colors :den :DEFAULT)

; Get the keys or values
(keys room-colors)
(vals room-colors)

; Can use maps or keywords as functions
; either one is same as get
(room-colors :kitchen)
(:bedroom room-colors)
