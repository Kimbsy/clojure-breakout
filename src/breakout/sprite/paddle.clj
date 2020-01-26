(ns breakout.sprite.paddle
  (:require [quil.core :as q]
            [breakout.utils :as u]))

(defn ->paddle
  []
  {:pos [230 410]})

(defn draw-paddle
  [{:keys [paddle]}]
  (let [x (first (:pos paddle))
        y (second (:pos paddle))]
    (q/fill u/grey)
    (q/rect x y 50 10)))
