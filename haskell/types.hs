---- Types ----

-- :t True
-- True :: Bool

-- :t 'z'
-- 'z' :: Char

-- :t head
-- head :: [a] -> a
---- a is a type variable, meaning head takes a list of any type and
---- returns something of that type

-- :t length
-- length :: [a] -> Int
---- length takes a list of any type, and returns an Int
---- Be careful, Int's are limited and can do weird things!
-- 1000000000000000000000000000 + length [42, 32]
-- -6930898827444486142
-- 1000000000000000000000000000 + fromIntegral (length [42, 32])
-- 1000000000000000000000000002


---- Typeclasses ----

-- (At this point, draw typeclass hierarchy)
-- typeclasses: Eq, Integral, Num, Integral, Floating

-- :t 5
-- 5 :: Num a => a
---- Says that 5 can be any type 'a', as long as 'a' is in the typeclass Num

-- :t 5.2
-- 5.2 :: Fractional a => a

-- :t pi
-- pi :: Floating a => a

---- Type coersion:
-- 5 :: Integer
-- 5 :: Float
-- pi :: Float
-- pi :: Double

-- square :: Num a => a -> a
square x = x * x

-- :t even
-- even :: Integral a => a -> Bool
---- => is a class constraint. It says that the type of the value passed to
----    "even" must be a type within the typeclass Integral.
---- Integral - acts like an integer - types Int and Integer

-- :t (==)
-- (==) :: Eq a => a -> a -> Bool
---- Eq - can test for equality (==, /=)
---- This is the first time we've seen 2 arguments
---- - Last thing is the return value, all prior are arguments
---- - More on this later

-- :t (+)
-- (+) :: Num a => a -> a -> a
---- Num - can act like numbers (+, -, *, etc.)
