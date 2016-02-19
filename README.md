# Domain-Driven Design annotations

This project includes a set of useful annotation for Java based Domain-Driven Design projects.

It also provides a Java Annotation Processor to enable compile-time structure verification of Java Code.

Of course it would be easy to create a Unit Test or whatever to enforce such rules, but hey? Why write a Unit Test if the same check can also be enforced at compile time? Fail early, fail fast :-)

[![Build Status](https://travis-ci.org/mirkosertic/DDDCompileTimeValidator.svg?branch=master)](https://travis-ci.org/mirkosertic/DDDCompileTimeValidator)

# Available Annotations

| Annotation | Description |
| ---------- | ----------- |
| de.mirkosertic.ddd.annotation.Aggregate | Used to annotate Aggregates |
| de.mirkosertic.ddd.annotation.Entity | Used to annotate Entities |
| de.mirkosertic.ddd.annotation.Events | Used to annotate Events |
| de.mirkosertic.ddd.annotation.Factory | Used to annotate Factories |
| de.mirkosertic.ddd.annotation.Repository | Used to annotate Repositories |
| de.mirkosertic.ddd.annotation.Service | Used to annotate Services |
| de.mirkosertic.ddd.annotation.ValueObject | Used to annotate Value Objects |

# Implemented compile time validation

## Value Objects

* Fields of Value Objects must be final
* Only classes can be Value Objects
* Only fields of type java.*, enums or other Value Objects are allowed
