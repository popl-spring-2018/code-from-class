(ns class-code.lab1.problem-4)

(defn caius_sam_jack
  [[x1 y1] [x2 y2]]
  ((Math/sqrt (+ ( * (- x2 x1) (- x2 x1)) (* (- y2 y1) (- y2 y1))))))


(defn dista
  "Takes two [x y] vectors and returns Euclidian distance between them"
  [[x1 y1] [x2 y2]]
  (Math/sqrt (+ (* (- x2 x1) (- x2 x1)) (* (- y2 y1) (- y2 y1)))))


(defn hypotenuse
  "returns the Euclidean distance between two points in two-space"
  [[a b] [c d]]
  (Math/sqrt (+ (* (- a c) (- a c)) (* (- b d) (- b d)))))

