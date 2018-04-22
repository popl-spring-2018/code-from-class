
%% These are my implementations of the lab problems.
%% There are certainly other ways to implement these!

%% Occurs twice
occursTwice(X, [X | T]) :- member(X, T).
occursTwice(X, [_ | T]) :- occursTwice(X, T).

%% Last element of a list
lastElement(List, Element) :- append(_, [Element], List).

%% All elements besides the last one
allButLast(List, AllBut) :- append(AllBut, [_], List).
