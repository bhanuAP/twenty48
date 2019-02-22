(ns twenty48.core
  (:gen-class))

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  grid)

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  grid)

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)



(def add-front-zeros (comp (partial take-last 4) (partial concat '(0 0 0 0))))

(def combine-tiles (partial map (partial apply +)))

(def get-tiles-to-be-merged (partial mapcat (partial partition-all 2)))

(def partition-by-identity (partial partition-by identity))

(def filter-zeros (partial remove zero?))

(def add-trailing-zeros (comp reverse add-front-zeros))

; start

(def move-right (comp
                 add-front-zeros
                 combine-tiles
                 get-tiles-to-be-merged
                 partition-by-identity
                 filter-zeros))

(def move-left (comp
                add-trailing-zeros
                combine-tiles
                get-tiles-to-be-merged
                partition-by-identity
                filter-zeros))

(move-right '(0 2 0 2))
(move-left '(0 2 0 2))