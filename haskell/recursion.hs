---- Recursion Review ----

-- Ex: Our own sum function
sum' :: Num p => [p] -> p
sum' [] = 0
sum' (x:xs) = x + sum' xs

-- sum' [1..10]
-- 55


-- Ex: Our own filter function
filter' :: (a -> Bool) -> [a] -> [a]
filter' fn [] = []
filter' fn (x:xs)
  | fn x = x : filter' fn xs
  | otherwise = filter' fn xs

-- filter' even [1..10]
-- [2,4,6,8,10]
