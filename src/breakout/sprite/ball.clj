(ns breakout.sprite.ball
  (:require [quil.core :as q]
            [breakout.utils :as u]))

(defn ->ball
  "Create a ball."
  []
  {:pos     [250 400]
   :vel     [0 0]
   :active? false})

(defn draw-ball
  [{:keys [ball]}]
  (let [x (first (:pos ball))
        y (second (:pos ball))]
    (q/fill u/white)
    (q/rect x y 10 10)))
