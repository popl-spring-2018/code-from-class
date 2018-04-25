
mother(arlene, charlotte).
mother(arlene, becca).
mother(becca, sarah).

ancestor(A, D, 1) :- mother(A, D).
ancestor(A, D, G) :- mother(A, Z), ancestor(Z, D, GensFromZ), G is GensFromZ + 1.

count([], 0).
count([_|T], C) :- count(T, CountTail), C is CountTail + 1.
