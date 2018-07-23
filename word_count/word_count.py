"""Python script to count all the different words in a text file

I define a word as any number of consecutive word characters. In ASCII, these characters include a-z, A-Z, 0-9, and _.
In unicode, this includes most characters that can be part of a word in any language.

Python's regex module provides two metacharacters that help achieve this task.
* \w matches any unicode word character
* \b matches the boundary between a word character and a non-word character
"""

from collections import defaultdict
from pprint import pprint
import re


def word_count(filename):
    word_counts = defaultdict(int)

    with open(filename, 'r', errors='ignore') as file:
        for line in file:
            for match in re.finditer(r'\b(\w+?)\b', line):
                word = match.group(1)
                word_counts[word] += 1

    return dict(word_counts)


if __name__ == '__main__':
    pprint(word_count('testfile.txt'))