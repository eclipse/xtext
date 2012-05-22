package lesson6

import org.junit.Test
import static org.junit.Assert.*
import java.io.FileReader
import java.util.Set
import static extension com.google.common.io.CharStreams.*

class Movies {
	
	@Test def void findBestMovie() {
		assertEquals('"Planet Earth"', movies.sortBy[rating * -1].head.title )
	}
	
	@Test def void numberOfMoviesBetterRatingThanFive() {
		assertEquals(3139, movies.filter[ rating > 5.0 ].size )
	}
	
	def getMovies() {
		new FileReader('movies.csv').readLines.map[toMovie]	
	}
	
	def Movie toMovie(String line) {
		val segments = line.split('  ').iterator
		return new Movie(
			segments.next, 
			segments.next, 
			Double::parseDouble(segments.next), 
			Integer::parseInt(segments.next), 
			segments.toSet
		)
	}
}

@Data class Movie {
	String title
	String year
	double rating
	int numberOfVotes
	Set<String> categories 
}