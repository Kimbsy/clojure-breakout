(ns breakout.sprite.ball
  (:require [quil.core :as q]
            [breakout.utils :as u]))

(defn ->ball
  "Create a ball."
  []
  {:pos     {:x 200
             :y 385}
   :vel     {:x 0
             :y 0}
   :w       10
   :h       10
   :active? false})

(defn draw-ball
  [{:keys [ball]}]
  (let [x (:x (:pos ball))
        y (:y (:pos ball))
        w (:w ball)
        h (:h ball)]
    (q/fill u/white)
    (q/rect x y w h)))

(defn move-ball
  [{:keys [ball] :as state}]
  (let [vel-x (:x (:vel ball))
        vel-y (:y (:vel ball))]
    (assoc state :ball
           (-> ball
               (update-in [:pos :x] #(+ % vel-x))
               (update-in [:pos :y] #(+ % vel-y))))))

(defn side-wall-bounce
  [{:keys [ball] :as state}]
  (let [x (:x (:pos ball))]
    (assoc state :ball
           (if (or (> 0 x)
                   (< 500 x))
             (update-in ball [:vel :x] #(* % -1))
             ball))))

(defn top-wall-bounce
  [{:keys [ball] :as state}]
  (let [y (:y (:pos ball))]
    (assoc state :ball
           (if (> 0 y)
             (update-in ball [:vel :y] #(* % -1))
             ball))))

(defn paddle-bounce
  [{:keys [ball paddle] :as state}]
  (let [ball-x   (:x (:pos ball))
        ball-y   (:y (:pos ball))
        vel (:vel ball)
        paddle-x (:x (:pos paddle))
        paddle-y (:y (:pos paddle))]
    (assoc state :ball
           (if (and (u/overlapping-x paddle ball)
                    (u/overlapping-y paddle ball))
             (update-in ball [:vel :y] #(* % -1))
             ball))))

(defn break-bricks
  [{:keys [ball bricks] :as state}]
  (let [groups       (group-by #(u/touching % ball) bricks)
        touching     (get groups true)
        not-touching (get groups false)]
    (-> state
        (assoc :ball (if (not-empty touching)
                       (update-in ball [:vel :y] #(* % -1))
                       ball))
        (assoc :bricks not-touching))))

(defn update-state
  [{:keys [ball paddle bricks] :as state}]
  (-> state
      move-ball
      side-wall-bounce
      top-wall-bounce
      paddle-bounce
      break-bricks))

(defn activate
  [ball]
  (-> ball
      (assoc :vel {:x 3 :y -3})
      (assoc :active? true)))

(defn mouse-clicked-handler
  [state e]
  (if-not (:active? (:ball state))
    (update state :ball activate)
    state))
