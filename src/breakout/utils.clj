(ns breakout.utils)

(def white  [255 255 255])
(def black  [0   0   0  ])
(def grey   [127 127 127])
(def red    [255 0   0  ])
(def orange [255 127 0  ])
(def yellow [255 255 0  ])
(def green  [0   255 0  ])
(def blue   [0   0   255])
(def purple [255 0   255])

(defn overlapping-x
  [a b]
  (or (< (:x (:pos a))
         (:x (:pos b))
         (+ (:x (:pos a)) (:w a)))
      (< (:x (:pos b))
         (:x (:pos a))
         (+ (:x (:pos b)) (:w b)))))

(defn overlapping-y
  [a b]
  (or (< (:y (:pos a))
         (:y (:pos b))
         (+ (:y (:pos a)) (:h a)))
      (< (:y (:pos b))
         (:y (:pos a))
         (+ (:y (:pos b)) (:h b)))))

(defn touching
  [a b]
  (and (overlapping-x a b)
       (overlapping-y a b)))
