# Optimal Patrol Path Around Machines

## Overview

This program calculates the shortest patrol path that encircles all rectangles. It uses **Andrew's Monotone Chain Algorithm** to compute the convex hull and then calculates its perimeter.

---

## How to Run

### 1. Compile the Program

```powershell
javac main.java
```

### 2. Run the Program

```powershell
java main
```

Then enter your input manually or use the pipe method below.

### 3. Using PowerShell Pipe (Recommended)

```powershell
@"
<number of rectangles>
<rectangle 1: x1 y1 x2 y2>
<rectangle 2: x1 y1 x2 y2>
...
"@ | java main
```

---

## Input Format

**First line:** `N` — number of rectangles

**Next N lines:** `x1 y1 x2 y2` — two opposite corners of each rectangle

- `(x1, y1)` and `(x2, y2)` are any two opposite corners
- Coordinates can be integers or decimals
- No requirement that x1 < x2 or y1 < y2 (program normalizes them)

---

## Example Test Cases

### Example 1: Two Non-Overlapping Rectangles

```powershell
@"
2
0 0 2 2
3 1 5 3
"@ | java main
```

**Expected Output:**

```
14.3245553203367590
```

---

### Example 2: Three Overlapping Rectangles

```powershell
@"
3
0 0 1 1
0.5 0.5 1.5 1.5
1 1 2 2
"@ | java main
```
