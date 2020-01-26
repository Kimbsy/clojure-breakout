(ns breakout.core
  (:gen-class)
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup
  "This function is called once when the game starts, it should
  configure settings and return the starting game state."
  []
  ;; just an empty map for now
  {})

(defn draw-state
  "This function is called every frame, it takes the game state for the
  current frame and should do all of our drawing to the screen and
  return nil."
  [state]
  ;; draw a black background
  (q/background 0))

(defn update-state
  "This function is also called every frame, it takes the game state for
  the current frame and shoud return the new game state for the next
  frame."
  [state]
  ;; not modifying the state, nothing will change between frames
  state)

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
   :middleware [m/fun-mode]))
