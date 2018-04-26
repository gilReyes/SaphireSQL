# SaphireSQL

##### ICOM 4036 Class Project
##### Prof. Wilson Rivera
##### Fall Semester 2015

### Developers

1. Joanette Rosario    joanette.rosario@upr.edu
2. Gil Reyes           gil.reyes@upr.edu
3. Jahannie Torres     jahannie.torres@upr.edu
4. Rafael Vissepo      rafael.vissepo@upr.edu

## Introduction
 The purpose of the language  is to automatize the process of query testing a database. The name of the language is SapphireSQL. The query language to be used is SQL because it’s the most common and most widely used query language in the world. The motivation of this project is to optimize the process of testing and releasing a database system for client use. Another purpose of the language is to enable a person, that doesn’t have any knowledge of SQL, to test his or her database easily.

The testing process would involve the user in taking note of all the attributes in the table, making all possible query combination and listing expected values. This process will be automatized by receiving only an array with attributes and table names. The language will have a feature that will return a series of strings with all SQL query combinations.Right now the only way to test queries is through unit testing. One disadvantage in these methods is that you have to write test cases for each of your tables. This language aims to facilitate this process and instead of writing the same lines of code repetitively, you just have to write one and apply it to all the tables. An advantage of using this tool is time efficiency of your database based projects by optimizing the testing phase and reducing human error. The programming language should be fast, readable and easily writeable. The syntax of the language will be similar to python. 



## Software Requirements and specifications
1.1 Purpose
This software requirements are intended to define the project that will be used as an evaluation method in the programming languages course.

1.2 Scope
* Name: Sapphire SQL 
* The product will:
Help database tester with an object oriented programming tactic 
Allow user to generate quicker queries.

2.1 Functional Requirements
To process the code from the SQL query tester language there will be a lexical analyzer and syntax analyzer. For the lexical analyzer the tool used for producing a scanner will be PLY because the language chosen for the development of the language is Python. The syntax analyzer tool used will be parsing simulator. The parsing strategy for the language will be bottom up parser LR (left-to-right, rightmost derivation) type. The query language used to process the code will be SQL because it is the most widely used query language in the world.

2.2 Outputs: 
The possible outputs will be all the possible queries possible regarding the table or tables specified. 
