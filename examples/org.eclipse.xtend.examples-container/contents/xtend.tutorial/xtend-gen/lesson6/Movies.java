package lesson6;

import com.google.common.io.CharStreams;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lesson6.Movie;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class Movies {
  @Test
  public void findBestMovie() {
    List<Movie> _movies = this.getMovies();
    final Function1<Movie,Double> _function = new Function1<Movie,Double>() {
        public Double apply(final Movie it) {
          double _rating = it.getRating();
          int _minus = (-1);
          double _multiply = (_rating * _minus);
          return Double.valueOf(_multiply);
        }
      };
    List<Movie> _sortBy = IterableExtensions.<Movie, Double>sortBy(_movies, _function);
    Movie _head = IterableExtensions.<Movie>head(_sortBy);
    String _title = _head.getTitle();
    Assert.assertEquals("\"Planet Earth\"", _title);
  }
  
  @Test
  public void numberOfMoviesBetterRatingThanFive() {
    List<Movie> _movies = this.getMovies();
    final Function1<Movie,Boolean> _function = new Function1<Movie,Boolean>() {
        public Boolean apply(final Movie it) {
          double _rating = it.getRating();
          boolean _greaterThan = (_rating > 5.0);
          return Boolean.valueOf(_greaterThan);
        }
      };
    Iterable<Movie> _filter = IterableExtensions.<Movie>filter(_movies, _function);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(3139, _size);
  }
  
  public List<Movie> getMovies() {
    try {
      FileReader _fileReader = new FileReader("movies.csv");
      List<String> _readLines = CharStreams.readLines(_fileReader);
      final Function1<String,Movie> _function = new Function1<String,Movie>() {
          public Movie apply(final String it) {
            Movie _movie = Movies.this.toMovie(it);
            return _movie;
          }
        };
      List<Movie> _map = ListExtensions.<String, Movie>map(_readLines, _function);
      return _map;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Movie toMovie(final String line) {
    String[] _split = line.split("  ");
    final Iterator<String> segments = ((List<String>)Conversions.doWrapArray(_split)).iterator();
    String _next = segments.next();
    String _next_1 = segments.next();
    String _next_2 = segments.next();
    double _parseDouble = Double.parseDouble(_next_2);
    String _next_3 = segments.next();
    int _parseInt = Integer.parseInt(_next_3);
    Set<String> _set = IteratorExtensions.<String>toSet(segments);
    Movie _movie = new Movie(_next, _next_1, _parseDouble, _parseInt, _set);
    return _movie;
  }
}
