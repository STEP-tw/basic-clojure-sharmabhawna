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

(deftest conditions-apply-test
  (testing "collection has 1 and 3 in order"
           (is (= :wonder-woman (conditions-apply [2 1 4 3]))))
  (testing "collection has :a, :b and :c in order"
           (is (= :durga (conditions-apply [:a :d :b :e :c]))))
  (testing "collection has [2 3] and [4 5] in order"
           (is (= :cleopatra (conditions-apply [[2 3] 1 [8] 6 [4 5]]))))
  (testing "collection has no pattern mentioned above"
           (is (= :tantan (conditions-apply [2 4 3 1]))))
  )

(deftest repeatition-and-truncation
  (testing "repeatition and truncation both are false"
           (is (= [1 2 3] (repeat-and-truncate [1 2 3] false false 2))))
  (testing "repeatition is false and truncation is true"
           (is (= [1 2] (repeat-and-truncate [1 2 3] false true 2))))
  (testing "repeatition is true and truncation is false"
           (is (= [1 2 3 1 2 3] (repeat-and-truncate [1 2 3] true false 5))))
  (testing "repeatition and truncation both are true"
           (is (= [1 2 3 1 2] (repeat-and-truncate [1 2 3] true true 5))))
  )