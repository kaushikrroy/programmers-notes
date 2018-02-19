# Longest Common Subsequence
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, 'abc', 'abg', 'bdf', 'aeg', 'acefg', .. etc are sub-sequences of 'abcdefg'. So a string of length n has 2<sup>n</sup> different possible sub-sequences.

## Defintion
It differs from the longest common substring problem: unlike substrings, subsequences are not required to occupy consecutive positions within the original sequences. The longest common subsequence problem is a classic computer science problem, the basis of data comparison programs such as the diff utility, and has applications in bioinformatics. It is also widely used by revision control systems such as Git for reconciling multiple changes made to a revision-controlled collection of files. The problem is to for given two sequences, finding the length of longest sub-sequence present in both of them.

### Example
LCS for input Sequences <b>'ABCDGH'</b> and <b>'AEDFHR'</b> is <b>'ADH'</b> of length 3.

LCS for input Sequences <b>'AGGTAB'</b> and <b>'GXTXAYB'</b> is <b>'GTAB'</b> of length 4.