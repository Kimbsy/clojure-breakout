(ns breakout.core
  (:gen-class)
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [breakout.sprite.ball :as ball]
            [breakout.sprite.brick :as brick]
            [breakout.sprite.paddle :as paddle]))

(defn setup
  "This function is called once when the game starts, it should
  configure settings and return the starting game state."
  []
  ;; just an empty map for now
  {:bricks (brick/initial-bricks)
   :paddle (paddle/->paddle)
   :ball (ball/->ball)
   :remaining-balls 3
   :score 0})

(defn draw-state
  "This function is called every frame, it takes the game state for the
  current frame and should do all of our drawing to the screen and
  return nil."
  [state]
  ;; draw a black background
  (q/background 0)

  ;; draw the sprites
  (brick/draw-bricks state)
  (paddle/draw-paddle state)
  (ball/draw-ball state))

(defn update-state
  "This function is also called every frame, it takes the game state for
  the current frame and shoud return the new game state for the next
  frame."
  [state]
  (some-> state
          (ball/update-state)))

(defn mouse-moved-handler
  "In this function we can pass the mouse-moved event to any handlers
  that might want to act on it by updating the game state."
  [state e]
  ;; only the paddle reacts to mouse movements
  (paddle/mouse-moved-handler state e))

(defn mouse-clicked-handler
  "In this function we can pass the mouse-clicked event to any handlers
  that might want to act on it by updating the game state."
  [state e]
  ;; only the ball reacts to mouse clicks
  (ball/mouse-clicked-handler state e))

(defn -main
  "This is the entry point to our game where we define and run our
  sketch."
  [& args]
  (q/sketch
   :title "Breakout!"
   :size [500 500]
   :setup setup
   :draw draw-state
   :update update-state
   :mouse-moved mouse-moved-handler
   :mouse-clicked mouse-clicked-handler
   :middleware [m/fun-mode]))
