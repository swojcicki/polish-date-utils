# polish-date-utils ![Java CI with Maven](https://github.com/swojcicki/polish-date-utils/workflows/Java%20CI%20with%20Maven/badge.svg)
## About

This project contains classes for managing some polish (and not only) feast and days off.

## Usage

### Maven

#### Clone and install
```bash
git clone https://github.com/swojcicki/polish-date-utils.git
cd polish-date-utils
mvn clean install
```

#### Add Maven dependency
```maven
<dependency>
  <groupId>io.github.swojcicki</groupId>
  <artifactId>polish-date-utils</artifactId>
  <version>2.0</version>
</dependency>
```

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

### Feast class

### PolishFeast class

### DayOff class

### PolishDayOff class

### PolishDayOffUtils class