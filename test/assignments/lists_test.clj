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
