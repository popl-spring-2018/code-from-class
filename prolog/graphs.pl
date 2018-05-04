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
pathNoRepeats(X,Y,Checked) :- edge(X,Z),
			      \+member(Z,Checked),
			      pathNoRepeats(Z,Y,[Z|Checked]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% Working with the interpreter

% ?- listing.  % Gives all of the axioms defined so far.
% ?- trace.    % When running a query, allows you to see the resolution process
               %  - Lots of useful tools, see with ?
% ?- path(a,c).
% ?- notrace.  % Turns tracing off
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%% A graph is complete if every node in the graph is directly connected
%%% to every other node
complete([]).
complete([N|V]) :- edgeEvery(N,V), complete(V).

edgeEvery(_, []).
edgeEvery(N, [Q|T]) :- edge(N,Q), edgeEvery(N,T).

%%% Findall
%%% findall(Object, Condition, List)
%%% Creates List of all of Objects that satisfy the Condition

% List all vertices that have been defined:

% ?- findall(X, edge(X, _), Verts).

vertices(VertsSorted) :-
    findall(X, edge(X, _), Verts),
    sort(Verts, VertsSorted). % Note: sort removes duplicate items

% List all edges connected to a given vertex:
edgesBad(V, Edges) :-
    findall(X, edge(V, X), Edges).

% findall is a bit weird in that it won't tell you individual unifications
% for the first two arguments:

% ?- edgesBad(X, E).

% bagof is similar, except will give you separate unifications for arguments
edges(V, Edges) :-
    bagof(X, edge(V,X), Edges).

% Practice:
% Degree of a vertex: number of edges connected to that vertex.
degree(V, D) :-
    edges(V, Edges),
    length(Edges, D).

% A subgraph of a graph is a subset of the vertices in the graph and any
% edges that connect those vertices. Let's define subset/2, which tells whether
% second argument is a subset of the first.

% If empty, the only subset is the empty list
subset([], []).
% We can either not include the first element...
subset([_|T], S) :- subset(T, S).
% Or include the first element
subset([H|T], [H|S]) :- subset(T, S).

% Practice:
% How would we get a list of all subsets of a list?
allSubsets(List, SubsetsList) :-
    findall(S, subset(List, S), SubsetsList).


pathList(X, Y, Path) :- pathNoRepeatsList(X, Y, [X], Path).

pathNoRepeatsList(X, X, _, [X]).
pathNoRepeatsList(X, Y, Visited, [X|Path]) :-
    edge(X, Z),
    \+ member(Z, Visited),
    pathNoRepeatsList(Z, Y, [Z | Visited], Path).

% Shortest path from one node to another

allPaths(X, Y, Paths) :-
    findall(Path, pathList(X, Y, Path), Paths).

shortestList(Lists, LengthShortest) :-
    maplist(length, Lists, LengthOfLists),
    min_list(LengthOfLists, LengthShortest).

shortestPath(X, Y, ShortestPath) :-
    allPaths(X, Y, Paths),
    shortestList(Paths, ShortestLength),
    member(ShortestPath, Paths),
    length(ShortestPath, ShortestLength).
