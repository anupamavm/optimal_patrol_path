# Programming Test: Optimal Patrol Path Around Machines

## Problem Statement

A factory floor contains N rectangular machines, each aligned with the coordinate axes. A security robot must patrol around them along a simple closed polygonal path (a loop).

The path:

- Must not pass through the interior of any rectangle
- Must enclose all rectangles (each rectangle must lie entirely inside the loop or on its edges)

Among all such paths, the factory wants the shortest possible path length.

### Assumptions

- Rectangles can touch each other but do not overlap in their interior
- The optimal path is the boundary of the convex hull of all rectangle corners

## Input Format

- An integer N with $1 \leq N \leq 2 \times 10^5$
- Then N lines follow. Each line contains four numbers: $x_1, y_1, x_2, y_2$
  - Representing the opposite corners of one axis-aligned rectangle
  - Coordinates are real numbers or integers with absolute value up to $10^6$

## Output Format

Output a single real number: the minimum possible path length, with absolute or relative error at most $10^{-6}$.

## Tasks for the Candidate

### 1. Mathematical Explanation

**a)** Explain how to transform the rectangle problem into a problem on points (for example, by considering the corners of each rectangle).

**b)** Explain why it is valid to consider the convex hull of all rectangle corners as the optimal patrol path.

**c)** Describe the algorithm you will use to compute this convex hull (for example, Andrew's monotone chain or Graham scan), including:

- Why sorting the points is needed
- How cross products / orientation tests are used to build the hull
- The overall time complexity in terms of N

### 2. Mathematical Details (Formulas)

In your explanation, clearly state and use:

- The formula for the cross product / orientation test of three points O, A, B
- The Euclidean distance between two points
- The formula for the perimeter as the sum of distances along the convex hull

### 3. Code Solution

**a)** Implement a program that:

- Reads N rectangles
- Constructs all their corner points
- Computes the convex hull of this set of points
- Computes and outputs the perimeter of the convex hull with precision at least $10^{-6}$

**b)** The expected time complexity of your solution is $O(N \log N)$.

**c)** Use clear data structures and function decomposition (for example, separate functions for cross product, distance, convex hull construction, and the main procedure).
