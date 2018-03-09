(ns class-code.my-repl)

; What if we want to write a REPL without using eval
; We need to write our own eval
; eval does two main things:
; - evaluates data structure (code) and returns result
; - may define global variables or functions. This adds the defined
;   variable/function to the global environment as a side-effect.

; If we want to write my-eval, we will need it to be able to do both
; things above. We will write my-eval in a pure functional style, so that
; it does not have side-effects on the global environment. Instead, we will
; store a map of the environment and its bindings, and have my-eval
; return both the result of the code and the new environment.

; support: integer literals, +, nested calls, def, defed symbols

(defn my-eval
  "Evaluates expression, changes environment, and returns resulting state
  with :return set to returned value.
    - state should be a map with a :environment key that stores all bindings,
      and a :return key that stores the result of evaluation
    - expression is the Clojure expression given to the REPL"
  [state expression]
  (if (not (seq? expression))
    (if (symbol? expression)
      (assoc state :return (get (:environment state) expression))
      (assoc state :return expression))
    (let [env (:environment state)
          f (first expression)]
      (cond
        (= f '+) (assoc state :return (apply + (map #(:return (my-eval state %))
                                                    (rest expression))))
        (= f 'def) {:environment (assoc env
                                        (second expression)
                                        (:return (my-eval state
                                                          (nth expression 2))))
                    :return (second expression)}
        :else (assoc state :return "Error: That function is not defined.")))))

(defn repl
  "Implements a REPL without using eval"
  ([] (repl {:environment {}}))
  ([state]
   (print "H]=> ")
   (flush)
   (let [line (read-line)]
     (when (not (empty? line))
       (let [new-state (my-eval state
                                (read-string line))]
         ;; (println "Environment:" (:environment new-state))
         (println (:return new-state))
         (recur new-state))))))

(defn -main
  []
  (repl))

;; H]=> 72
;; H]=> (+ 2 3)
;; H]=> (+ (+ 3 2) 100)
;; H]=> (def a (+ 2 3))
;; H]=> a
;; H]=> (+ a 1000)
;; H]=> (+ (+ a a) a)
;; H]=> (+ a a a)
;; H]=> (def b (+ 100 a))
;; H]=> b
