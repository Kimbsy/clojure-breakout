(ns breakout.sprite.paddle
  (:require [quil.core :as q]
            [breakout.utils :as u]))

(defn ->paddle
  []
  {:pos {:x 180 :y 400}
   :w   50
   :h   10})

(defn draw-paddle
  [{:keys [paddle]}]
  (let [x (:x (:pos paddle))
        y (:y (:pos paddle))
        w (:w paddle)
        h (:h paddle)]
    (q/fill u/grey)
    (q/rect x y 50 10)))

(defn mouse-moved-handler
  [state e]
  (assoc-in state [:paddle :pos :x] (- (:x e) 25)))
