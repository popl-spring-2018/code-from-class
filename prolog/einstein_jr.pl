
% Facts:
% 1. Two people live in 2 houses with 2 colors and 2 pets.
% 2. The person in the red house has a giraffe
% 3. The first house is blue
% 4. One person owns an elephant as a pet

einstein_jr(Solution) :-
    Solution = [house(h1, _, _),
		house(h2, _, _)],
    member(house(_, red, giraffe), Solution),
    member(house(h1, blue, _), Solution),
    member(house(_, _, elephant), Solution).
