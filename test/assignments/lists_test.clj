(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

;(deftest lists
;  (testing "map"
;    (testing "identity with single coll"
;      (is (= [1 2 3] (map' identity [1 2 3]))))))

(deftest count-test
  (testing "with empty list"
           (is (zero? (count' []))))
  (testing "with integer elements in list"
           (is (= 4 (count' [4 2 6 2]))))
  (testing "list containing multiple data types"
           (is (= 5 (count' [1 \a "string" [1 2] {:foo :bar}]))))
  (testing "with map"
           (is (= 2 (count' {:one 1 :two 2})))))

(deftest reverse-test
  (testing "with empty list"
           (is (= () (reverse' []))))
  (testing "with elements in list"
           (is (= '(3 2 1) (reverse' [1 2 3]))))
  (testing "with string"
           (is (= '(\e \r \u \j \o \l \c) (reverse' "clojure"))))
  (testing "with non-seqable"
           (is (nil? (reverse' true)))))

(deftest every?-test
  (testing "with empty list"
           (is (true? (every?' odd? []))))
  (testing "all elements satisfy the predicate"
           (is (true? (every?' odd? [1 3 5]))))
  (testing "at least one element does not satisfy the predicate"
           (is (false? (every?' odd? [1 2 3]))))
  (testing "no element satisfy the predicate"
           (is (false? (every?' odd? [2 4 6])))))

(deftest some?-test
  (testing "with empty list"
    (is (false? (some?' odd? []))))
  (testing "all elements satisfy the predicate"
    (is (true? (some?' odd? [1 3 5]))))
  (testing "at least one element satisfies the predicate"
    (is (true? (some?' odd? [2 3 4]))))
  (testing "no element satisfy the predicate"
    (is (false? (some?' odd? [2 4 6])))))

(deftest ascending?-test
  (testing "with correct sequence"
    (is (true? (ascending? [1 2 3]))))
  (testing "with incorrect sequence"
    (is (false? (ascending? [1 4 3])))))

(deftest sum-of-adjacent-digits-test
  (testing "with empty collection and single collection"
    (are [x y] (= x y)
               [] (sum-of-adjacent-digits [])
               [] (sum-of-adjacent-digits [1])))
  (testing "with collection containing more than single element"
    (is (= [1 4 3] (sum-of-adjacent-digits [0 1 3 0])))))

(deftest max-three-digit-sequence-test
  (testing "with less than three numbers"
    (is (= [1 2] (max-three-digit-sequence [1 2]))))
  (testing "with more than three numbers"
    (is (= [2 -1 2] (max-three-digit-sequence [1 2 -1 2 0])))))

(deftest transpose-test
  (testing "with empty sequence"
    (is (= [] (transpose [[] []]))))
  (testing "with not-empty sequence"
    (is (= [[1 2 3] [4 5 6]] (transpose [[1 4] [2 5] [3 6]])))))

(deftest difference-test
  (testing "with empty collections"
    (is (= [] (difference [] []))))
  (testing "second collection having all elements common with first collection"
    (is (= [] (difference [1 2 3] [2 3]))))
  (testing "second collection having some elements common with first collection"
    (is (= [4] (difference [1 2 3] [2 3 4]))))
  (testing "second collection having no element common with first collection"
    (is (= [4 5 6] (difference [1 2 3] [4 5 6])))))

(deftest union-test
  (testing "with empty collections"
    (is (= [] (union [] []))))
  (testing "with no common elements"
    (is (= [1 2 3 4 5 6] (union [1 2 3] [ 4 5 6]))))
  (testing "with common elements but elements doesn't repeat"
    (is (= [1 2 3 4 5] (union [1 2 3] [3 4 5]))))
  (testing "with common element and elements repeat"
    (is (= [1 2 3 1 4 5 6 4] (union [1 2 3 1] [4 5 6 3 2 4])))))

(deftest points-around-origin-test
  (testing "points around origin"
    (is (= '([-1 -1]
             [-1 0]
             [-1 1]
             [0 -1]
             [0 1]
             [1 -1]
             [1 0]
             [1 1]) points-around-origin))))

(deftest cross-product-test
  (testing "with empty sequence"
    (is (= [] (cross-product [] []))))
  (testing "with 2 sequences"
    (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]]
           (cross-product [1 2 3] [4 3 5])))))

(deftest double-up-test
  (testing "with empty sequence"
    (is (= [] (double-up []))))
  (testing "with integer sequence"
    (is (= [1 1 2 2 3 3] (double-up [1 2 3]))))
  (testing "with string sequence"
    (is (= ["I" "I" "love" "love" "clojure" "clojure"]
           (double-up ["I" "love" "clojure"])))))

(deftest third-or-fifth-test
  (testing "with single item"
    (is (= ["I"] (third-or-fifth ["I"]))))
  (testing "with collection containing last index as 3"
    (is (= [1 4] (third-or-fifth [1 2 3 4]))))
  (testing "with collection containing last index as 5"
    (is (= [1 4 6] (third-or-fifth [1 2 3 4 5 6]))))
  (testing "with collection containing last index as 6"
    (is (= [1 4 6 7] (third-or-fifth [1 2 3 4 5 6 7])))))