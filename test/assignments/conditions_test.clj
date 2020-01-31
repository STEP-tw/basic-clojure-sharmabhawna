(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
           (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
           (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandra-test
  (testing "truthy values"
           (is (= 2 (harishchandra 2))))
  (testing "falsy values"
           (is (nil? (harishchandra false)))))

(deftest yudishtira-test
  (testing "truthy values"
           (is (= 2 (yudishtira 2))))
  (testing "falsy values"
           (is (= :ashwathama (yudishtira false)))))

(deftest first-duplication
  (testing "non-empty collection"
           (is (= [2 2 4 5] (duplicate-first [2 4 5]))))
  (testing "empty collection"
           (is (nil? (duplicate-first [])))))