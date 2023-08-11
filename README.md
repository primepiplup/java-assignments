# Java Assignments Sogyo

This repo contains several java assignments completed during the introduction to programming at Sogyo. Each individual assignment can be found in a separate branch. 

During coding I have been reading Clean Code by Robert C Martin, which advice I have been trying to apply increasingly throughout the assignments as I progressed. Code readability has been made a priority as well as adherence to the "One function does one thing, and does it well" philosophy.

## A short description of projects:

### Leapyear
This program takes a year, and outputs whether the year is a leapyear based on the rule that every fourth year is a leapyear and for every century only the years that are divisible by 400 are leapyears.

### Lists
Generates a list of random integers and performs several operations on said list such as: Finding the largest number, finding the two smallest numbers, finding all even values, creating lists of numbers divible by 2, 3 and 5 and the remaining numbers, and implementing bubble sort to then run over the generated list.

### Hangman
Implemented the hangman guessing game for a random list of several words. 

### Quote of the day
Given a list of quotes and authors - output a quote to stdout based on the day of the year it is currently.

### Roborally
Object oriented programming revolving around robots that are created and can be given instructions. Implemented a functional interface which is used to store function calls until an execute() operation is called for the robot. Used Enums for direction management.

### Fractional calculation
Created a Fraction class which stores a fraction as a numerator and denominator. Implemented several methods for this class which are used to do calculations with either whole numbers or other fractions. Fractions that are reducible are reduced by finding the greatest common factor which uses a prime number generator on the back-end.

### Decision tree
Assignment for understanding and working with tree data structures. Created node and edge objects which are generated while reading in an input text file. The starting node is found by searching for a node with no edges running to it and ending nodes are determined as having no edges running from them. The whole tree is contained as references within objects and can be traversed by having access to the starting node.

### Exceptional users
Created a mock user creation system. Uses several operations to ensure correct username and password input. Subtly handles incorrect input.

### Raytracer
Implemented a raytracer with a basic Lambertian shader. Uses self-defined Vector class with implemented vector math functions. Sphere-line intersections have been implemented, as well as Plane-Line intersections. A material class has been implemented which houses the diffusion coefficient for the Lambertian shader, a reflection amount for reflection calculations and a color for color rendering of Shape objects. The output file location is hard-coded and should be changed within the main function within Raytracer.java to receive an output image file in the desired location.
