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
