(ns class-code.homoiconicity)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Homoiconicity, Evaluation

; read-string
; returns the data structure represented by the string
(read-string "(+ 3 2)")

(type (read-string "(+ 3 2)")) ; This read-string returns a list

(read-string "[3 4 5]")

(read-string "(quote (2 3 4))")
(read-string "'(2 3 4)") ; Expands "reader macros" into actual forms

(read-string "#(+ % %)") ; Another reader macro

(read-string "(+ 1 2); this is a comment") ;Ignores comments!

(read-string "variable") ; Just the symbol 'variable'

; eval
(eval 5)

(let [x 45]
  (eval x))

(+ 3 2)

'(+ 3 2)

(eval '(+ 3 2))

; Define our own REPL
;(read-line) ; Reads line from standard input

(defn repl
  "A Clojure REPL. Works best from command line with `lein run`"
  []
  (print "H]=> ")
  (flush)
  (let [line (read-line)]
    (when (not (empty? line))
      (println (eval (read-string line)))
      (recur)))) 

(defn -main
  "Called when `lein run` is run in this project."
  []
  (repl))

; (repl)

; lein run

; (+ 2 5)
; :hi
; (if true 5 100)
; (map inc [3 1 9])
; {:a 2 :b 6}
; (apply + (range 25))
; (def abc 49)
; abc

