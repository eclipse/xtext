/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 */
package example6;

import com.google.common.io.CharStreams;
import example6.Movie;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class Movies {
  /**
   * @return the total number of action movies
   */
  @Test
  public void numberOfActionMovies() {
    final Function1<Movie, Boolean> _function = (Movie it) -> {
      return Boolean.valueOf(it.getCategories().contains("Action"));
    };
    Assert.assertEquals(828, IterableExtensions.size(IterableExtensions.<Movie>filter(this.movies, _function)));
  }
  
  /**
   * @return the year the best rated movie of 80ies (1980-1989) was released.
   */
  @Test
  public void yearOfBestMovieFrom80ies() {
    final Function1<Movie, Boolean> _function = (Movie it) -> {
      return Boolean.valueOf(new IntegerRange(1980, 1989).contains(it.getYear()));
    };
    final Function1<Movie, Double> _function_1 = (Movie it) -> {
      return Double.valueOf(it.getRating());
    };
    Assert.assertEquals(1989, IterableExtensions.<Movie, Double>maxBy(IterableExtensions.<Movie>filter(this.movies, _function), _function_1).getYear());
  }
  
  /**
   * @return the sum of the number of votes of the two top rated movies.
   */
  @Test
  public void sumOfVotesOfTop2() {
    final Function1<Movie, Double> _function = (Movie it) -> {
      double _rating = it.getRating();
      return Double.valueOf((-_rating));
    };
    final Function1<Movie, Long> _function_1 = (Movie it) -> {
      return Long.valueOf(it.getNumberOfVotes());
    };
    final Function2<Long, Long, Long> _function_2 = (Long a, Long b) -> {
      return Long.valueOf(((a).longValue() + (b).longValue()));
    };
    final long movies = (long) IterableExtensions.<Long>reduce(IterableExtensions.<Movie, Long>map(IterableExtensions.<Movie>take(IterableExtensions.<Movie, Double>sortBy(this.movies, _function), 2), _function_1), _function_2);
    Assert.assertEquals(47_229, movies);
  }
  
  private final List<Movie> movies = new Function0<List<Movie>>() {
    @Override
    public List<Movie> apply() {
      try {
        final Function1<String, Movie> _function = (String line) -> {
          final Iterator<String> segments = ((List<String>)Conversions.doWrapArray(line.split("  "))).iterator();
          String _next = segments.next();
          int _parseInt = Integer.parseInt(segments.next());
          double _parseDouble = Double.parseDouble(segments.next());
          long _parseLong = Long.parseLong(segments.next());
          Set<String> _set = IteratorExtensions.<String>toSet(segments);
          return new Movie(_next, _parseInt, _parseDouble, _parseLong, _set);
        };
        List<Movie> _map = ListExtensions.<String, Movie>map(CharStreams.readLines(new FileReader("data.csv")), _function);
        return _map;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
}
