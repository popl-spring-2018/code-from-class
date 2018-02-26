(ns class-code.lab1.problem-3)

(defn jack_sam_caius
  [list_str]
  (map (fn [word] (nth word 1)) list_str))


(defn second_char
  "Takes a list of strings and return second char of each string"
  [list]
  (map #(nth % 1) list))


(defn secChar
  "returns a list of the second character in each string of a given list"
  [list]
  (nth (map list) 2))


(defn secondChar
  "this is a function that takes a list of strings, and rteturns a list of the second character in each of those strings"
  [strings]
  (map (fn [string] nth string 1) strings))
