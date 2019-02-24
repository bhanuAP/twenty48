(ns twenty48.core
  (:gen-class))

(def add-front-zeros (comp (partial take-last 4) (partial concat '(0 0 0 0))))

(def combine-tiles (partial map (partial apply +)))

(def get-tiles-to-be-merged (partial mapcat (partial partition-all 2)))

(def partition-by-identity (partial partition-by identity))

(def filter-zeros (partial remove zero?))

(def add-trailing-zeros (comp reverse add-front-zeros reverse))

(def transpose (partial apply map list))

(def move-right (comp add-front-zeros combine-tiles get-tiles-to-be-merged partition-by-identity filter-zeros))

(def move-left (comp add-trailing-zeros combine-tiles get-tiles-to-be-merged partition-by-identity filter-zeros))

(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  (map move-right grid))

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  (map move-left grid))

(def move-grid-down
  "Moves an entire grid down"
  (comp transpose move-grid-right transpose))

(def move-grid-up
  "Moves an entire grid up"
  (comp transpose move-grid-left transpose))
