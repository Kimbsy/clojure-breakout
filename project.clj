(defproject breakout "0.1.0"
  :description "A simplified version of Atari Breakout"
  :url "https://github.com/Kimbsy/clojure-breakout"
  :license {:name "GNU General Public License v3.0"
            :url  "https://choosealicense.com/licenses/gpl-3.0"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [quil "3.1.0"]]
  :aot [breakout.core]
  :main breakout.core)
