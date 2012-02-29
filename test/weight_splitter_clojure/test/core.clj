(ns weight-splitter-clojure.test.core
  (:use [weight-splitter-clojure.core])
  (:use [clojure.test]))

(deftest split-1-1
  (is (= (split-weight (list 1 1)) (list (list 1) (list 1)))))

(deftest split-2-1-1
  (is (= (split-weight (list 2 1 1)) (list (list 2) (list 1 1)))))

(deftest split-5-1-1-3
  (is (= (split-weight (list 5 1 1 3)) (list (list 5) (list 1 1 3)))))

(deftest split-5-2-2-6-5
  (is (= (split-weight (list 5 2 2 6 5)) (list (list 2 2 6) (list 5 5)))))
