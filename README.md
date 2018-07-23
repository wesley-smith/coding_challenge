# Stealthwatch coding challenge

## Questions 1 and 2 - Directed Acyclic Graph (DAG) in Java

* This code is based in the `DAG` subdirectory
* Written in JDK 8 (1.8.0_131)
* The two functions are implemented as static methods of the `GNodeFunctions` class, located in the `DAG/src/com/cisco/wessm/GNodeFunctions.java` file
* I created a simple implementation of the `GNode` interface for testing purposes with the `MyGNode` class
* Several JUnit tests are included in `DAG/test/com/cisco/wessm/GNodeTest.java`
    * They use the `MyGNode` class to test the functions on a few different graphs

Note that neither of the functions guarantee output to be ordered in any way.

## Question 3 - Word Count Program

* Written in Python 3.6.1
* You can run the `word_count.py` module as a script or import the `word_count()` function
* `pytest` can be used to run the unit test in `test_word_count.py`