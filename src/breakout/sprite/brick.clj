(ns breakout.sprite.brick
  (:require [quil.core :as q]
            [breakout.utils :as u]))

(defn brick-column
  [x-offset]
  [{:pos [x-offset 40]  :color u/purple}
   {:pos [x-offset 60]  :color u/blue}
   {:pos [x-offset 80]  :color u/green}
   {:pos [x-offset 100] :color u/yellow}
   {:pos [x-offset 120] :color u/orange}
   {:pos [x-offset 140] :color u/red}])

(defn initial-bricks
  []
  (apply concat (map brick-column [50 100 150 200 250 300 350 400])))

(defn draw-brick
  [{:keys [pos color]}]
  (let [x (first pos)
        y (second pos)]
    (q/fill color)
    (q/rect x y 40 15)))

(defn draw-bricks
  [{:keys [bricks]}]
  (mapv draw-brick bricks))
