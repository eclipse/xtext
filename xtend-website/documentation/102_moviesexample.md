---
layout: documentation
title: The Movies Example
part: Getting Started
---

# {{page.title}} {#movies-example}

The movies example is included in the example project *Xtend Introductory Examples* (src/examples6/Movies.xtend) and is about reading a file with data about movies and doing some analysis on it.

## The Data

The movie database is a plain text file (data.csv) with data sets describing movies. Here is an example data set: 

```
Naked Lunch  1991  6.9  16578  Biography  Comedy  Drama  Fantasy
```

The values are separated by two spaces. The columns are : 

1.  title
1.  year
1.  rating
1.  numberOfVotes
1.  categories

Let us define a data type `Movie` representing a data set:

```xtend
@Data class Movie {
  String title
  int year
  double rating
  long numberOfVotes
  Set<String> categories 
}
```

A movie is a POJO with a strongly typed field for each column in the data sets. The [@Data](204_activeannotations.html#data-annotation) annotation will turn the class into an immutable value class, that is it will get 

*   a getter-method for each field,
*   a `hashCode()`/`equals()` implementation,
*   implementation of `Object.toString(),`
*   a constructor accepting values for all fields in the declared order.

## Parsing The Data

Let us now add another class to the same file and initialize a field called movies with a list of movies. For the initialization we parse the text file and turn the data records into `Movie`s:

```xtend
import java.io.FileReader
import java.util.Set
import static extension com.google.common.io.CharStreams.*

class Movies {
  
  val movies = new FileReader('data.csv').readLines.map [ line |
    val segments = line.split('  ').iterator
    return new Movie(
      segments.next, 
      Integer.parseInt(segments.next), 
      Double.parseDouble(segments.next), 
      Long.parseLong(segments.next), 
      segments.toSet
    )
  ]
}
```

A [field's type](202_xtend_classes_members.html#fields) can be inferred from the expression on the right hand-side. That is called local type inference and is supported everywhere in Xtend. We want the field to be final, so we declare it as a value using the keyword `val`.

The initialization on the right hand side first creates a new [FileReader]({{site.javadoc.java}}/java/io/FileReader.html). Then the method `readLines()` is invoked on that instance. But if you have a look at `FileReader` you will not find such a method. In fact `readLines()` is a static method from Google Guava's [CharStreams]({{site.javadoc.guava}}/com/google/common/io/CharStreams.html) which was imported as an [extension](202_xtend_classes_members.html#extension-imports). Extensions allow us to use this readable syntax.

```xtend
import static extension com.google.common.io.CharStreams.*
```

[`CharStreams.readLines(Reader)`]({{site.javadoc.guava}}/com/google/common/io/CharStreams.html) returns a [`List<String>`]({{site.javadoc.java}}/java/util/List.html) on which we call another extension method `map`. This one is defined in the runtime library ([ListExtensions.map(...)]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/ListExtensions.java)) and is automatically imported and therefore available on all lists. The `map` extension expects a function as a parameter. It basically invokes that function for each value in the list and returns another list containing the results of the function invocations. Actually this mapping is performed lazily so if you never access the values of the result list, the mapping function is never executed.

Function objects are created using [lambda expressions](203_xtend_expressions.html#lambdas) (the code in squared brackets). Within the lambda we process a single line from the text file and turn it into a movie by splitting the string using two whitespace characters as the separator. On the result of the split operation, the method `iterator()` is invoked. As you might know [String.split(String)]({{site.javadoc.java}}/java/lang/String.html) returns a string array (`String[]`), which Xtend [auto-converts to a list](201_types.html#conversion-rules) when we call [`Iterable.iterator()`]({{site.javadoc.java}}/java/lang/Iterable.html) on it.

```xtend
val segments = line.split('  ').iterator
```

Now we use the iterator to create an instance of `Movie` for each String that it yields. The data type conversion (e.g. `String` to `int`) is done by calling [static methods](203_xtend_expressions.html#static-access) from the wrapper types. The rest of the [Iterable]({{site.javadoc.java}}/java/lang/Iterable.html) is turned into a set of categories. Therefore, the extension method [`IteratorExtensions.toSet(Iterator<T>)`]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IteratorExtensions.java) is invoked on the iterator to consume its remaining values.

```xtend
return new Movie (
  segments.next, 
  Integer.parseInt(segments.next), 
  Double.parseDouble(segments.next), 
  Long.parseLong(segments.next), 
  segments.toSet
)
```

## Answering Some Questions

Now that we have parsed the text file into a `List<Movie>`, we are ready to execute some queries against it. We use *JUnit* to make the individual queries executable and to confirm their results.

### Question 1 : What Is The Number Of Action Movies? {#question1}

```xtend
@Test def numberOfActionMovies() {
  assertEquals(828, 
    movies.filter[ categories.contains('Action') ].size)
}
```

First the movies are `filter`ed. The lambda expression checks whether the current movie's categories contain the entry `'Action'`. Note that unlike the lambda we used to turn the lines in the file into movies, we have not declared a parameter name this time. We could have written 

```xtend
movies.filter[ movie | movie.categories.contains('Action') ].size
```

but since we left out the name and the vertical bar the variable is automatically named `it`. `it` is an [implicit variable](203_xtend_expressions.html#implicit-variables). It's uses are similar to the implicit variable `this`. We can write either

```xtend
movies.filter[ it.categories.contains('Action') ].size
```

or even more compact 

```xtend
movies.filter[ categories.contains('Action') ].size
```

Eventually we call `size` on the resulting iterable which is an extension method, too. It is defined in the utility class [IterableExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IterableExtensions.java).

### Question 2 : What Is The Year The Best Movie From The 80's Was Released? {#question2}

```xtend
@Test def void yearOfBestMovieFrom80s() {
  assertEquals(1989, 
    movies.filter[ (1980..1989).contains(year) ].sortBy[ rating ].last.year)
}
```

Here we `filter` for all movies whose year is included in the range from 1980 to 1989 (the 80's). The `..` operator is again an extension defined in [IntegerExtensions]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IntegerExtensions.java) and returns an instance of [IntegerRange]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IntegerRange.java). Operator overloading is explained in [section](203_xtend_expressions.html#operators).

The resulting iterable is sorted ([`IterableExtensions.sortBy`]({{site.src.xtext}}/plugins/org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/IterableExtensions.java)) by the `rating` of the movies. Since it is sorted in ascending order, we take the last movie from the list and return its `year`. 

We could have sorted descending and take the head of the list as well: 

```xtend
movies.filter[ (1980..1989).contains(year) ].sortBy[ -rating ].head.year
```

Another possible solution would be to reverse the order of the sorted list: 

```xtend
movies.filter[ (1980..1989).contains(year) ].sortBy[ rating ].reverseView.head.year
```

Note that first sorting and then taking the last or first is slightly more expensive than needed. We could have used the method `reduce` instead to find the best movie which would be more efficient. Maybe you want to try it on your own?

The calls to `movie.year` as well as `movie.categories` in the previous example in fact access the corresponding [getter methods](203_xtend_expressions.html#property-access).

### Question 3 : What Is The The Sum Of All Votes Of The Top Two Movies? {#question3}

```xtend
@Test def void sumOfVotesOfTop2() {
  val long sum = movies.sortBy[ -rating ].take(2).map[ numberOfVotes ].reduce[ a, b | a + b ]
  assertEquals(47_229L, sum)
}
```

First the movies are sorted by rating, then we take the best two. Next the list of movies is turned into a list of their `numberOfVotes` using the `map` function. Now we have a [`List<Long>`]({{site.javadoc.java}}/java/util/List.html) which can be reduced to a single [Long]({{site.javadoc.java}}/java/lang/Long.html) by adding the values.

You could also use `reduce` instead of `map` and `reduce`. Do you know how?

---

**[Next Chapter: Java Interoperability](201_types.html)**