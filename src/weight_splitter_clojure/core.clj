(ns weight-splitter-clojure.core
  (:gen-class))

(defn first-half-greater? [split]
  (> (reduce + (first split)) (reduce + (second split))))

(defn add-in [split weight]
  (if (first-half-greater? split)
    (list (first split) (conj (second split) weight))
    (list (conj (first split) weight) (second split))))

(defn split-in [split collection]
  (if (> (count collection) 0) 
    (split-in (add-in split (first collection)) (rest collection))
    split))

(defn split-weight [collection]
  (split-in (list) (reverse (sort collection))))

(defn is-evenly-splitted? [collection]
  (== (reduce + (first collection)) (reduce + (second collection))))

(defn split-weight-evenly [collection]
  (let [split (split-weight collection)]
    (if (is-evenly-splitted? split) split nil)))

(defn -main [& args] 
  (println (split-weight-evenly (map read-string args))))
