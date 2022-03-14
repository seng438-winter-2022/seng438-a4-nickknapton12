**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |  5  |
| -------------- | --- |
| Student Names: |  Nicholas Knapton   |
|                |  Jacob Artuso   |
|                |  Brian Kramer  |
|                |  Colin Christophe   |

# Introduction


# Analysis of 10 Mutants of the Range class

getLowerBound : replaced double return with 0.0d for org/jfree/data/Range::getLowerBound -> KILLED

getCentralValue : Substituted 2.0 with 1.0 -> KILLED 
<br/>This mutant changes the 'this.lower / 2.0' to 'this.lower / 1.0'. We can see that our original test suite tests this function using a range of -1 to 1. Thus, the statement will originally give -0.5 but the mutant will make it -1. This is the improper value and will be killed.  

getCentralValue : Replaced double addition with subtraction -> KILLED

shift : removed call to org/jfree/data/util/ParamChecks::nullNotPermitted -> SURVIVED

contains : greater than to less or equal -> KILLED
<br/>This mutant changes the boolean return from 'return (value >= this.lower && value <= this.upper);' to 'return (value <= this.lower && value <= this.upper);'. This mutant will be killed by our test case that has range or -1 to 1 with value equal to 0 because originally this retrurn will be true but with the mutant value <= this.lower will be false. Since the mutant will be false and not the expected true it will be killed. 

min : removed conditional - replaced equality check with false -> SURVIVED
<br/>This mutant will replace the 'Double.isNaN(d1)' with false. Since we did not explicitly test this function in our assignment 3 test suite the mutant survived. However, if we created a test where d1 is not a number then this mutant would be killed. 

shift : negated conditional -> SURVIVED
<br/>This mutant will negate the allowZeroCrossing boolean. i.e if the boolean is false it will make it true and vice versa. Since we did not test the shift function extensively this mutant was not killed. 

expand : removed call to org/jfree/data/Range::getLength -> KILLED

shiftWithNoZeroCrossing : Substituted 0.0 with 1.0 -> SURVIVED

equals : replaced boolean return with false for org/jfree/data/Range::equals -> KILLED
<br/> This mutant will change the 'return true' statement to 'return false'. This will cause the mutant to be killed for any test cases that reaches that line of the equals(Object obj) function. 


# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process
Our test case design process involved identifying key functionalities of the system, such as longing in and purchasing items, then writing test which verify the system is running properly.


# Explain the use of assertions and checkpoints
Assertions are used to make sure the system ends in the correct state. Checkpoints are used for when longer paths must be taken, ensuring that the correct paths are being taken prior to running specified tests.

# how did you test each functionaity with different test data


# Discuss advantages and disadvantages of Selenium vs. Sikulix


# How the team work/effort was divided and managed
Each of us created 2 test cases using selenium.

# Difficulties encountered, challenges overcome, and lessons learned


# Comments/feedback on the lab itself
Interesting lab in which we explore how to use mutation testing in order to improve our test suite. Also, selenium seems like a powerful tool that can be even used outside of testing when needing to automate website interactions.