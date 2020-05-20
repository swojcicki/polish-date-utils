# Simple documentation
## Introduction

This project contains classes for managing some polish (and not only) feast and days off.

## Usage

### Maven
### Easter class

This class counts Easter date for given year using updated Gauss algorithm.

```java
Easter.of(2020).getDate(); // returns 2020-04-12, Easter date
```
```java
IntStream.range(2020, 2030)
         .mapToObj(year -> (year + " " + Easter.of(year).getDate()))
         .forEach(System.out::println);
```

### MoveableFeast class

This class contains moveable feast dates for given year or given Easter object. Feast dates depends on Easter date.

```java
MoveableFeast moveableFeast = MoveableFeast.of(2020);
moveableFeast.getAshWednesday(); // returns date 46 days before Easter
```