%%% A graph is a structue composed of nodes, which may be connected by edges
%%% Useful for describing relationships between things
%%% Ex: friends on Facebook

%%% (draw example on board)

%%% Start with directed edges
dirEdge(a,b). dirEdge(a,c).
dirEdge(b,c). dirEdge(b,d). dirEdge(b,e).
dirEdge(c,d).

dirEdge(f,g). dirEdge(f,h).
dirEdge(g,h).

%%% Want to make directed edges go both ways
% dirEdge(A,B) :- dirEdge(B,A).
% Q: dirEdge(a, X).   % Infinite recursion!

% No recursion, works great.
edge(X,Y) :- dirEdge(X,Y).
edge(X,Y) :- dirEdge(Y,X).

% Q: edge(b, X).

%%% A path is a series of nodes that are consecutively connected by edges
%%% Works for directed graph...
dirPath(X,X).
dirPath(X,Y) :- dirEdge(X,Z), dirPath(Z,Y).

%%% ...infinite loop for undirected graph. Can go between two nodes forever
% pathBad(X,X).
% pathBad(X,Y) :- edge(X,Z), pathBad(Z,Y).

%%% We need to check and not visit any edge more than once in a path.
%%% We still get an answer for every path between two nodes, but not multiples
path(X,Y) :- pathNoRepeats(X,Y,[X]).

pathNoRepeats(X,X,_).
pathNoRepeats(X,Y,Visited) :- edge(X,Z),
			      \+member(Z,Visited),
			      pathNoRepeats(Z,Y,[Z|Visited]).
