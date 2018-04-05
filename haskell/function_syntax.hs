module Main where

import Data.List

------------------------------------------------------
-- Pattern Matching --

-- Base cases
smallInt 1 = "Your number is one!"
smallInt 2 = "Your number is two!"
smallInt x = "Your number isn't one or two :("

safeDiv x 0 = 1
safeDiv x y = div x y

-- Recursion
fact 0 = 1
fact x = x * fact (x-1)

-- Pattern matching isn't always about base cases
-- It can work on tuples
addPoints (x,y) (z,w) = (x+z,y+w)

-- First, Second, and Third for 3-tuples
-- _ means "don't care what it is"
first (x,_,_) = x
second (_,y,_) = y
third (_,_,z) = z

-- Pattern matching on lists
tell [] = "The list is empty"
tell (x:[]) = "The list has one element: " ++ show x
tell (x:y:[]) = "The list has two elements: " ++ show x ++ " and " ++ show y
tell (x:y:_) = "This list is long. The first two elements are: " ++ show x ++ " and " ++ show y

-- Break a list apart into elements before 5...
listUntil5 [] = []
listUntil5 (5:_) = []
listUntil5 (x:t) = x:(listUntil5 t)

-- ... and after 5
listAfter5 [] = []
listAfter5 (5:t) = t
listAfter5 (_:t) = listAfter5 t

---- Practice
-- Write a subseq function, which takes a start index, an end index, and a list
-- and gives the subsequence starting with start and ending just before end.
-- Should handle correctly: an empty list; end > list length.
subseq :: Integer -> Integer -> [a] -> [a]
subseq _ _ [] = []
subseq _ 0 _ = []
subseq 0 end (h:t) = h:subseq 0 (pred end) t
subseq start end (h:t) = subseq (pred start) (pred end) t

subseq' start end list = take (end - start) (drop start list)

------------------------------------------------------
-- Guards --

-- Similar to if-elif statements in Python, cond in Clojure.
-- More general than pattern matching.
numSize x
  | x < 0 = "negative"
  | x < 10 = "one digit"
  | x < 100 = "two digits"
  | even x = "large and even"
  | otherwise = "large and odd"

squareSmallNums x
  | x*x < 100 = x*x
  | otherwise = x

nextCollatz x
  | even x = div x 2
  | otherwise = (x*3)+1

collatzSeq 1 = [1]
collatzSeq x = x:collatzSeq (nextCollatz x)
          
------------------------------------------------------
-- Where --
-- Define function or value to only be used in one function
-- Great for helper functions or calculating reused values

cubeSmallNums x
  | cube x < 100 = cube x
  | otherwise = x
  where cube x = x*x*x
        
bigSlope x y
  | slope > 10 = True
  | otherwise = False
  where slope = x / y

---- Practice
-- Write function convertTime:
-- Takes a number of seconds, and prints "x hours y minutes z seconds".
-- Leaves off minutes if 0, and leaves off hours if 0.
convertTime :: Integer -> String
convertTime seconds
  | seconds < 60 = (show seconds) ++ " seconds"
  | seconds < 60 * 60 = (show min) ++ " minutes " ++ (show sec) ++ " seconds"
  | otherwise = (show hr) ++ " hours " ++ (show min) ++ " minutes " ++ (show sec) ++ " seconds"
  where sec = seconds `mod` 60
        min = (seconds `div` 60) `mod` 60
        hr = seconds `div` (60 * 60)

------------------------------------------------------
-- Let 
-- Similar to where
---- Where only used in functions
---- Let is an expression that can be used anywhere
---- Let does not work across guards

-- temps :: (Num a) => [a]
temps = [-40.0, 0, 33, 75, 100, 212]

tempsToKelvin temps =
  let toC f = (f - 32.0) * (5/9)
      toK f = (toC f) + 273.15
  in  map toK temps

-- (let toC f = (f - 32.0) * (5/9) in (toC 32, toC 0, toC 212))
-- (let a = 5; b = 10; c = 15 in a*b*c)

-- Can be used in list comprehensions

tempsToCelciusAbove0 temps = [toC f | f <- temps, let toC x = (x - 32.0) * (5/9), toC f > 0.0]

-- To define functions in GHCI, we've used "let function...". This leaves
-- off the "in" part, and makes the function available in the session.

------------------------------------------------------
-- Case
-- Similar to case and switch statements in other languages

caps c = case c of
  'a' -> 'A'
  'b' -> 'B'
  'c' -> 'C'
  _ -> '!'

-- caps 'a'
-- caps 't'

-- Uses pattern matching

add100toHeadThenAdd1000toAll list = map (+ 1000) (case list of
  [] -> [100]
  (x:xs) -> (x + 100 : xs))

--import Data.List

-- findIndex (>= 10) [0..20]
-- findIndex (== 'c') "abcdefg"
-- findIndex (== 'c') "WHAT"
-- :t findIndex

findIndexNeg1 pred list = case findIndex pred list of
  Nothing -> -1
  Just index -> index


---- Practice
-- Define infinite sequence of squares
infiniteSquares = map (^ 2) [0..]

-- Find index of first integer whose square is > x
firstIntSquareGTx x = case findIndex (> x) infiniteSquares of
  Nothing -> -1
  Just index -> index
