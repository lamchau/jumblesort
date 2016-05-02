# Jumble Sort

Write a program that takes a list of strings containing integers and words
as standard input and returns a sorted version of that list as standard output.

But there's a twist!

You must sort the list in such a way that all words are in alphabetical
order, and all integers are in numerical order, but **if the nth element of the input list is an integer it must remain an integer, and if it is a word it must remain a word**

Or if you prefer a more pseudo-codish specification

```
For all i, 0 < i < list.length
  if list[i] is INT
    then jumblesort(list)[i] is INT
  if list[i] is STRING
    then jumblesort(list)[i] is STRING
```

See examples below.


Input:
------

The input will contain a single, possibly empty, line containing a
space-separated list of strings to be sorted. Words will not contain
spaces, will contain only the lower-case letters a-z. Integers will be
in the range -999999 to 999999, inclusive. The line will be at most 1000
characters long.


Output:
-------

The program must output the list of strings, sorted per the requirements
above. Strings must be separated by a single space, with no leading
space at the beginning of the line or trailing space at the end of the
line.


Example 1:
----------
Input:

```
./jumblesort 1
```

Output:

```
1
```


Example 2:
----------
Input:

```
./jumblesort car truck bus
```

Output:

```
bus car truck
```


Example 3:
----------

Input:

```
./jumblesort 8 4 6 1 -2 9 5
```

Output:

```
-2 1 4 5 6 8 9
```


Example 4:
----------
Input:

```
./jumblesort car truck 8 4 bus 6 1
```

Output:

```
bus car 1 4 truck 6 8
```
