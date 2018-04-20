
%%% Unification through equality:

% a = a.
% X = a.
% a = b.

% foo(a, b) = foo(A, B).
% foo(a, B) = foo(A, b).
% foo(a, b) = bar(A, B).

% A = B, B = zanzibar.

%%% Tuples: like functors without a name

% (X, truck, van) = (car, Y, Z).
% (X, truck, Y) = (car, Y, Z).

%%% Lists
% Can get head and tail, similar to Haskell

% L = [a,b,c].
% L = [a | [b,c]].
% L = [a,b | [c]].

% [a,b,c,d] = [a|T].

% member(b, [a,b,c,d]).
% member(X, [a,b,c,d]).
% member(a, List). % Dangerous!

%% Member is easy to write!

myMember(X, [X|_]).
myMember(X, [_|T]) :- myMember(X, T).


% append([a,b], [c,d], [a,b,c,d]).
% append([a,b], [c,d], L).
% append(X, [c,d], [a,b,c,d]).
% append([a,b], Y, [a,b,c,d]).
% append(X, Y, [a,b,c,d]).      % Whoa, cool.

%% Append is easy to write!

myAppend([], A, A).
myAppend([H|T], A, [H|L]) :- myAppend(T, A, L).


%% Combining append and pattern matching can be very useful:
%% Find the middle element of an odd-length list

middleElement(List, Middle) :- append(Start, [Middle | End], List),
			       length(Start, SLength),
			       length(End, SLength).
