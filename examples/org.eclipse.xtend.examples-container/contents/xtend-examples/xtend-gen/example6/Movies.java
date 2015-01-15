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
    final Function1<Movie, Boolean> _function = new Function1<Movie, Boolean>() {
      @Override
      public Boolean apply(final Movie it) {
        Set<String> _categories = it.getCategories();
        return Boolean.valueOf(_categories.contains("Action"));
      }
    };
    Iterable<Movie> _filter = IterableExtensions.<Movie>filter(this.movies, _function);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(828, _size);
  }
  
  /**
   * @return the year the best rated movie of 80ies (1980-1989) was released.
   */
  @Test
  public void yearOfBestMovieFrom80ies() {
    final Function1<Movie, Boolean> _function = new Function1<Movie, Boolean>() {
      @Override
      public Boolean apply(final Movie it) {
        IntegerRange _upTo = new IntegerRange(1980, 1989);
        int _year = it.getYear();
        return Boolean.valueOf(_upTo.contains(_year));
      }
    };
    Iterable<Movie> _filter = IterableExtensions.<Movie>filter(this.movies, _function);
    final Function1<Movie, Double> _function_1 = new Function1<Movie, Double>() {
      @Override
      public Double apply(final Movie it) {
        return Double.valueOf(it.getRating());
      }
    };
    Movie _maxBy = IterableExtensions.<Movie, Double>maxBy(_filter, _function_1);
    int _year = _maxBy.getYear();
    Assert.assertEquals(1989, _year);
  }
  
  /**
   * @return the sum of the number of votes of the two top rated movies.
   */
  @Test
  public void sumOfVotesOfTop2() {
    final Function1<Movie, Double> _function = new Function1<Movie, Double>() {
      @Override
      public Double apply(final Movie it) {
        double _rating = it.getRating();
        return Double.valueOf((-_rating));
      }
    };
    List<Movie> _sortBy = IterableExtensions.<Movie, Double>sortBy(this.movies, _function);
    Iterable<Movie> _take = IterableExtensions.<Movie>take(_sortBy, 2);
    final Function1<Movie, Long> _function_1 = new Function1<Movie, Long>() {
      @Override
      public Long apply(final Movie it) {
        return Long.valueOf(it.getNumberOfVotes());
      }
    };
    Iterable<Long> _map = IterableExtensions.<Movie, Long>map(_take, _function_1);
    final Function2<Long, Long, Long> _function_2 = new Function2<Long, Long, Long>() {
      @Override
      public Long apply(final Long a, final Long b) {
        return Long.valueOf(((a).longValue() + (b).longValue()));
      }
    };
    final long movies = (long) IterableExtensions.<Long>reduce(_map, _function_2);
    Assert.assertEquals(47229, movies);
  }
  
  private final List<Movie> movies = new Function0<List<Movie>>() {
    public List<Movie> apply() {
      try {
        FileReader _fileReader = new FileReader("data.csv");
        List<String> _readLines = CharStreams.readLines(_fileReader);
        final Function1<String, Movie> _function = new Function1<String, Movie>() {
          @Override
          public Movie apply(final String line) {
            String[] _split = line.split("  ");
            final Iterator<String> segments = ((List<String>)Conversions.doWrapArray(_split)).iterator();
            String _next = segments.next();
            String _next_1 = segments.next();
            int _parseInt = Integer.parseInt(_next_1);
            String _next_2 = segments.next();
            double _parseDouble = Double.parseDouble(_next_2);
            String _next_3 = segments.next();
            long _parseLong = Long.parseLong(_next_3);
            Set<String> _set = IteratorExtensions.<String>toSet(segments);
            return new Movie(_next, _parseInt, _parseDouble, _parseLong, _set);
          }
        };
        List<Movie> _map = ListExtensions.<String, Movie>map(_readLines, _function);
        return _map;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
}
