# Simple documentation
## Introduction

This project contains classes for managing some polish (and not only) feast and days off.

## Usage

### Maven
### Easter class

This class counts Easter date for given year using updated Gauss algorithm.

```java
Easter.of(2020).getDate();
```
```java
IntStream.range(2020, 2030)
         .mapToObj(y -> (y + " " + Easter.of(y).getDate()))
         .forEach(System.out::println);
```
