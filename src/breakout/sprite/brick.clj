(ns breakout.sprite.brick
  (:require [quil.core :as q]
            [breakout.utils :as u]))

(defn ->brick
  [x y color]
  {:pos   {:x x
           :y y}
   :w     40
   :h     15
   :color color})

(defn brick-column
  [x-offset]
  [(->brick x-offset 40 u/purple)
   (->brick x-offset 60 u/blue)
   (->brick x-offset 80 u/green)
   (->brick x-offset 100 u/yellow)
   (->brick x-offset 120 u/orange)
   (->brick x-offset 140 u/red)])

(defn initial-bricks
  []
  (apply concat (map brick-column [50 100 150 200 250 300 350 400])))

(defn draw-brick
  [{:keys [pos color] :as brick}]
  (q/fill color)
  (q/rect (:x pos) (:y pos) (:w brick) (:h brick)))

(defn draw-bricks
  [{:keys [bricks]}]
  (mapv draw-brick bricks))
