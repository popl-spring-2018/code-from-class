(ns class-code.data-types)

; Basic function application (REPL and board)
(+ 2 3)

; Board:
; Every function application is a list, where the first element
; is treated as a function, and the rest arguments
;  - (fn arg1 arg2 arg3 ...)
;  - Note: no commas between args - whitespace sufficient
;  - If an arg is a function application, it is evaluated before
;    being passed to the function
;  - Ex: (+ (* 2 3) (- 9 4)) => (+ 6 5) => 11

; basic arithmetic
(* 1 2 3 4 5)
(* 4)
(/ 6 27)
(+ 3 7.31)
(+ 1 2 (* 9 3) 8 (/ 34 11))

; basic numeric types
2999  ; integer
4.51  ; float
5/27  ; ratio

; comparisons
(< 1 4)
(= 3 9)
(< 2 4 6 8 10)

; booleans
true
false
nil ; not a boolean: represents "nothing".
    ; evaluates to false in conditionals

; keywords
; always evaluate to themselves
; like symbols in Ruby
:kiwis
:avocados

; strings
; always double quotes; can go on multiple lines
"Hi there"

"This string
has multiple lines"

; str function converts arguments to strings and concatenates
(str "Hello" "World")
(str "hi " (+ 3 2))

; printing: multiple ways to print, most common being println
; note: returns nil
(println "cat")
(println "Why" "do" "you" "have" 5 "cats?")

; Clojure: Better to use small number of common data structures with
; many functions each, instead of defining many classes

; sequences: lists and vectors
; lists: look a lot like code!
'(1 2 3)
'(+ 2 3)
'(1 (+ 2 3) 4)

(quote (1 2 3)) ; equal to first method
(list 1 (+ 2 3) 4)   ; makes a list, but evaluates args first

; vectors: faster indexed access, slower other ways
[1 2 3]
(vector 1 2 3)

; we can mix types in lists and vectors (parametric polymorphism):
'(5 :a "hi" ("a" "list"))

; sequence functions:
(first '(:a :b :c :d :e))
(rest '(:a :b :c :d :e))
(count '(:a :b :c :d :e))
(nth '(:a :b :c :d :e) 3)

; conjoin
(conj '(10 11 12) 4)
(conj [10 11 12] 4) ; note difference!!!

; concatenate
(concat '(1 2 3) '(:a :b :c))
(concat [1 2 3] [:a :b :c]) ; also returns list
