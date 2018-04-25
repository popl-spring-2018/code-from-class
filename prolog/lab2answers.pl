
%% Pre-lab

even(X) :- 0 =:= mod(X, 2).

even2(X) :- 0 is mod(X, 2).

even3(X) :- 0 is X mod 2.

squareList([], []).
squareList([H|T], [HSquared|TailResult]) :-
    squareList(T, TailResult),
    HSquared is H * H.

%% In Lab

% For both groups
sum([], 0).
sum([H|T], S) :- sum(T, TailSum), S is TailSum + H.

% Red group

average([], 0).
average(List, A) :- sum(List, S), length(List, C), A is S / C.

% Practice: halves/3
% Requires length/2
% If odd-lengthed, make first half have 1 extra element

halves(List, Half1, Half2) :-
    append(Half1, Half2, List),
    length(Half1, Len),
    length(Half2, Len).
halves(List, Half1, Half2) :-
    append(Half1, Half2, List),
    length(Half1, Len1),
    length(Half2, Len2),
    Len1 =:= Len2 + 1.

factorial(1, 1).
factorial(N, X) :- NMinus1 is N - 1, factorial(NMinus1, Xm1fact), X is Xm1fact * N.


% Black group

multLists([], [], []).
multLists([H1|T1], [H2|T2], [Heads|Tails]) :-
    multLists(T1, T2, Tails),
    Heads is H1 * H2.

dotProduct([], [], 0).
dotProduct(L1, L2, DP) :-
    multLists(L1, L2, Result),
    sum(Result, DP).

abs(X, X) :- X >= 0.
abs(X, NegX) :- X < 0, NegX is -X.
