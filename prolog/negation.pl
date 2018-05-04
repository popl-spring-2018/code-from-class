
%%% Negation

% X \== Y is the same as \+(X == Y)

% \+ P
% This is assumed to be true if P cannot be proved.
% Note that this isn't logical negation.
% Instead, called "negation as failure".

% Ex:

inNewYork(clinton).

% | ?- inNewYork(clinton).
% | ?- \+ inNewYork(clinton).
% | ?- inNewYork(syracuse).    
% | ?- \+ inNewYork(syracuse).

inNewYork(utica).

outsideNewYork(X) :- \+ inNewYork(X).

% | ?- outsideNewYork(syracuse).

% Negation as failure is simply a result of the Closed World Assumption
%  - Everything that is true can be proven from the program.
%  - Everything that cannot be proven must be false.


% A negated goal might not do the right thing if it contains unbound variables
% Ex:
hamiltonLocation(clinton).

% | ?- inNewYork(X), \+ hamiltonLocation(X).
% | ?- \+ hamiltonLocation(X), inNewYork(X).

% Why does this happen? These should give the same thing!
% What Prolog does:
% - Whaen a goal that it is trying to meet fails, it backtracks the search
% - It undoes any variable instantiations
% - For (\+ P) to succeed, P must fail, which undoes any substitutions it did

% How to use negation:
% 1. Substitutions can be communicated from a positive goal into a negated goal
% 2. Substitutions cannot be communicated out of a negated goal
% This means the order of subgoals is important!
