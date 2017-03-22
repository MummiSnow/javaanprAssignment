# javaanprAssignment

This is an assignment given in a Test course on Copenhagen Business Academys Software Development professional bachelors degree programme.

it includes a parameterized test for the project found at https://github.com/oskopek/javaanpr.git.

Additional requirements are answers to a few questions.
___
* Explain the purpose of the Test (what the original test exposed, and what your test expose)

The original tests is a collection of two tests testing a single image for numberplate recognition and another doing checks based on a number of pictures and a results file.
The single file in it's own right is a good test. The second test however, assumes a known number of correct plates written in the results file. While this may be known, it would be better to simple have them all read as correct by humans, put in to the results file and thus passing those that are correctly recognised. 
___
* Explain about Parameterized Tests in JUnit and how you have used it in this exercise.

Parameterized tests is the concept of allowing several inputs to a single test method. Allowing quicker checks for errors in a simpler way compared to copying the same method several times.

Consider testing a method with 8 boolean inputs is it easier making 256 methods for teseting every single input or adding all the different possibilites to a collection and let the JUnit api do the work and output exactly what kind of input fails any of the tests
___
* Explain the topic Data Driven Testing, and why it often makes a lot of sense to read test-data from a file.

Data Driven tests is uses paramterized tests to automate data given by customers in a specific order to be read and automatically put into our tests cases. 

Consider a .csv file with a couple of thousand different lines of possible inputs. You want to test them all and we have the opportunity to make it all into a parameterized test allowing us to create very few lines of code compared to having a single test for each case. Reading the data from this .csv file will make our lives faster as no one then has to copy all the data into our test cases.
___
* Your answers to the question; whether what you implemented was a Unit Test or a JUnit Test, the problems you might have discovered with the test and, your suggestions for ways this could have been fixed.

What is implemented I feel is a JUnit test. As I consider a Unit test a test for the entire Unit that is Automatic Number Plate Recognition, and while I haven't looked in the code of the implementation at all. I have no real way of knowing whether I have implemented a test for the entire unit. Also the entire thing is automated to any changes as simple as adding a new image to the folder with snapshots and adding the results to this image in the corresponding results file.
___
* The steps you took to include Hamcrest matchers in the project, and the difference they made for the test

IntelliJ IDEA, the IDE I use can automatically import stuff it knows to be from a specific package, in this case Hamcrests matchers - specifically the is() matcher, and this did the import lines itself after I told it which package it was from (There are several known is() methods)
