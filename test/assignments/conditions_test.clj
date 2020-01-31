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

(deftest five-point-someone-test
  (testing "first argument is 5"
           (is (= :satan-bhagat (five-point-someone 5 3))))
  (testing "second argument is 5"
           (is (= :chetan-bhagat (five-point-someone 3 5))))
  (testing "first argument is greater than second argument"
           (is (= :greece (five-point-someone 6 3))))
  (testing "neither any argument is 5 nor first argument is greater than second"
           (is (= :universe (five-point-someone 3 6))))
  )