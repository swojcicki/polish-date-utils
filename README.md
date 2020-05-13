# polish-date-utils ![Java CI with Maven](https://github.com/swojcicki/polish-date-utils/workflows/Java%20CI%20with%20Maven/badge.svg)
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
