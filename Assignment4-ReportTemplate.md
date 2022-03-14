**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:       |   |
|-----------------|---|
| Student Names:  |   |
|                 |   |
|                 |   |
|                 |   |

# Introduction


# Analysis of 10 Mutants of the Range class

getLowerBound : replaced double return with 0.0d for org/jfree/data/Range::getLowerBound -> KILLED

getCentralValue : Substituted 2.0 with 1.0 -> KILLED 
<br/>This mutant was killed because  

getCentralValue : Replaced double addition with subtraction -> KILLED

shift : removed call to org/jfree/data/util/ParamChecks::nullNotPermitted -> SURVIVED

contains : greater than to less or equal -> KILLED

min : removed conditional - replaced equality check with false -> SURVIVED

expandToInclude : greater or equal to greater than -> SURVIVED

expand : removed call to org/jfree/data/Range::getLength -> KILLED

shiftWithNoZeroCrossing : Substituted 0.0 with 1.0 -> SURVIVED

equals : replaced boolena return with false for org/jfree/data/Range::equals -> KILLED


# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
