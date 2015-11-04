package org.eclipse.xtend.web

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.formatting2.FormatterFacade
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider
import org.eclipse.xtext.web.server.model.IXtextWebDocument
import org.eclipse.xtext.web.server.model.XtextWebDocument
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

class ExampleResourceHandler implements IServerResourceHandler {

	@Inject IWebResourceSetProvider resourceSetProvider
	
	@Inject Provider<XtextWebDocument> documentProvider
	
	@Inject FormatterFacade formatter
	
	
	val examples = #{
		'helloWorld.xtend' -> '''
			class HelloWorld {
			  def static void main(String[] args) {
			    println("Hello World")
			  }
			}
		''',
		'BasicExpressions.xtend' -> '''
			import org.junit.Test
			import static org.junit.Assert.*
			
			
			class BasicExpressions {
				
				@Test def void literals() {
					// string literals work with single or double quotes
					assertEquals('Hello', "Hello")
					
					// number literals (big decimals in this case)
					assertEquals(42, 20 + 20 + 1 * 2)
					assertEquals(42.00bd, 0.00bd + 42bd)
					
					// boolean literals
					assertEquals(true, !false)
					
					// class literals
					assertEquals(getClass(), BasicExpressions)
				}
				
				@Test def void operators() {
					// infix Operators 
					var i = 5
					
					// all Java infix operators are supported
					
					// additive
					assertEquals(6, i + 1)
					assertEquals(4, i - 1)
					
					// multiplicative
					assertEquals(1, i / 5)
					assertEquals(15, i * 3)
					assertEquals(0, i % 5)
					
					// assignment operators
					assertEquals(10, i *= 2)
					
					// relational operators
					assertFalse(i < 0)
					
					// shift operators
					assertEquals(5, i >> 1)
					
					// postfix operators are also the same as in Java
					var j = 4
					assertEquals(4, j--)
					assertEquals(3, j)
					assertEquals(3, j++)
					assertEquals(4, j)
					
					// More operators in Xtend described here http://www.eclipse.org/xtend/documentation.html?operators#operators
				}
				
				@Test def void collections() {
					// There are literals for lists, sets and maps
					// and numerous extension methods which make working with them
					// convenient.
					val list = #['Hello', 'World']
					assertEquals('HELLO', list.map[toUpperCase].head)
					
					val set  = #{1, 3, 5}
					assertEquals(2, set.filter[ it >= 3].size)
					
					val map  = #{'one' -> 1, 'two' -> 2, 'three' -> 3}
					assertEquals( 2 , map.get('two'))
					
					/*the literals produce immutable collections. 
					* There are also factory methods to produce mutable ones
					* Note that their type (seen when hovering over the name)
					* is inferred from the control flow
					*/
					val mutableList = newArrayList
					mutableList.add("Foo")
					val mutableSet = newHashSet
					mutableSet.add("Bar")
					val mutableMap = newHashMap
					mutableMap.put("Fizz", "Buzz")
				}
				
				@Test def void controlStructures() {
					// 'if' looks like in Java
					if ('text'.length == 4) {
						// but it's an expression so it can be used in more flexible ways:
						assertEquals( 42 , if ('foo' != 'BAR'.toLowerCase) 42 else -24 )
					} else {
						fail('Never happens!')
					}
					
					// in a switch the first match wins
					switch (t : 'text') {
						// use predicates
						case t.length > 8 :
							fail('Never happens!')
						// use equals
						case 'text' :
							assertTrue(true)
						default :
							fail('never happens!')
					}
					
					// switch also supports type guards, which provide a safe 
					// and convenient alternative to Java's 'instanceof'-cascades.
					val Object someValue = 'a string typed to Object'
					assertEquals('string', 
						switch someValue {
							Number : 'number'
							String : 'string' 
						})
					
					//there also is an explicit fallthrough syntax
					val num = 3
					assertEquals('not a divisor of 4', switch num {
						case 1,
						case 2,
						case 4: 'divisor of 4'
						default: 'not a divisor of 4'
					})	
				}
				
				@Test def void loops() {
					// for loop
					var counter = 1
					for (i : 1 .. 10) {
						assertEquals(counter, i)
						counter = counter + 1
					}
					
					//traditional for loop
					for(var i = 11; i > 0; i--) {
						assertEquals(counter, i)
						counter -=  1 //compound assignment
					}
					
					// while loop
					val iterator = #[1,2,3,4,5].iterator
					counter = 1
					while(iterator.hasNext) {
						val i = iterator.next
						assertEquals(counter, i)
						counter = counter + 1
					}
				}
			}
		''',
		'BottleSong.xtend' -> "
		package example3
		import static extension example3.BottleSupport.*
		import org.junit.Test
		
		/**
		 * Prints the lyrics of the song \"99 bottles of beer\"
		 * See http://99-bottles-of-beer.net/
		 * 
		 * Uses template expressions and extension methods.
		 */
		class BottleSong {
			
			@Test def void singIt() {
				println(singTheSong(99))
			}
			
			def singTheSong(int all) '''
				«FOR i : all .. 1»
					«i.Bottles» of beer on the wall, «i.bottles» of beer.
					Take one down and pass it around, «(i - 1).bottles» of beer on the wall.
					
				«ENDFOR»
				No more bottles of beer on the wall, no more bottles of beer.
				Go to the store and buy some more, «all.bottles» of beer on the wall.
			'''
		
		}
		
		class BottleSupport {
			
			def static bottles(int i) {
				switch i {
					case 0 : 'no more bottles'
					case 1 : 'one bottle'
					default : '''«i» bottles'''
				}.toString
			}
			
			def static Bottles(int i) {
				bottles(i).toFirstUpper
			}
		}",
		"HtmlBuilder.xtend"->"
		package example4

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Data
import org.junit.Test

/**
 * This examples shows 
 *  - the usage and declaration of a builder API.
 *  - usage of @Data annotation
 *  - non-static extension methods
 */
class DomExample {
	
	extension DomBuilder db = new DomBuilder
	extension DomSerializer ds = new DomSerializer
	
	@Test
	def void processDom() {
		val dom = buildDom
		println(dom.toText)
	}
	
	def buildDom() {
		new Html => [
		  head [
		    it.title [$(\"HTML with Xtend\")]
		  ]
		  body [
		    h1 [$(\"HTML with Xtend\")]
		    p [$(\"this format can be used as an alternative to templates.\")]
		
		    // an element with attributes and text content
		    a(\"http://www.xtend-lang.org\") [$(\"Xtend\")]
		
		    // mixed content
		    p [
		      $(\"This is some \") 
		      b[$(\"mixed\")] 
		      $(\" text. For more see the \") 
		      a(\"http://www.xtend-lang.org\")[$(\"Xtend\")] 
		      $(\" project\")
		    ]
		    p [$(\"More text.\")]
		  ]
		]
	}

}

class DomBuilder {
	
	def $(Node it, CharSequence contents) {
		val text = new Contents(contents)
		it.contents += text
	}
	
	def head(Html it, (Head)=>void init) {
		addAndApply(it, new Head, init)
	}
	def title(Head it, (Title)=>void init) {
		addAndApply(it, new Title, init)
	}
	
	def body(Html it, (Body)=>void init) {
		addAndApply(it, new Body, init)
	}
	
	def b(Node it, (B)=>void init) {
		addAndApply(it, new B, init)
	}
	def p(Node it, (P)=>void init) {
		addAndApply(it, new P, init)
	}
	
	def a(Node it, String href, (A)=>void init) {
		val a = new A(href)
		addAndApply(it, a, init)
	}
	
	def h1(Node it, (H1)=>void init) {
		addAndApply(it, new H1, init)
	}
	
	def h2(Node it, (H2)=>void init) {
		addAndApply(it, new H2, init)
	}
	
	def private <T extends Node> void addAndApply(Node parent, T t, (T)=>void init) {
		parent.contents += t
		init.apply(t)
	}
}

class DomSerializer {
	
	def CharSequence toText(Node n) {
		switch n {
			Contents : 
				n.text
				
			A : 
				'''<a href=\"«n.href»\">«n.applyContents»</a>'''
				
			default : '''
				<«n.tagName»>
					«n.applyContents»
				</«n.tagName»>
			'''
		}
	}
	
	def private applyContents(Node n) {
		n.contents?.map[ toText ]?.join
	}
}

@Data class Node {
	ArrayList<Node> contents = newArrayList
	def String tagName() {
		getClass.simpleName.toLowerCase
	}
}

@Data class Html extends Node {
}
@Data class Head extends Node {}
@Data class Title extends Node {}

@Data class ContentNode extends Node {}
@Data class Body extends ContentNode {}
@Data class P extends ContentNode {}
@Data class B extends ContentNode {}
@Data class H1 extends ContentNode {}
@Data class H2 extends ContentNode {}
@Data class A extends ContentNode {
	String href
}
@Data class Contents extends ContentNode {
	CharSequence text
}",
		'Movies.xtend'->'''
		package example6
		
		import java.io.FileReader
		import java.util.Set
		import org.eclipse.xtend.lib.annotations.Data
		import org.junit.Test
		
		import static org.junit.Assert.*
		
		import static extension com.google.common.io.CharStreams.*
		
		class Movies {
			
			/**
			 * @return the total number of action movies
			 */ 
			@Test def void numberOfActionMovies() {
				assertEquals(828, movies.filter[categories.contains('Action')].size)
			}
			
			/**
			 * @return the year the best rated movie of 80ies (1980-1989) was released.
			 */
			@Test def void yearOfBestMovieFrom80ies() {
				assertEquals(1989, movies.filter[(1980..1989).contains(year)].maxBy[rating].year)
			}
			
			/**
			 * @return the sum of the number of votes of the two top rated movies.
			 */
			@Test def void sumOfVotesOfTop2() {
				val long movies = movies.sortBy[-rating].take(2).map[numberOfVotes].reduce[a, b| a + b]
				assertEquals(47_229, movies)
			}
			
			val movies = new FileReader('data.csv').readLines.map[ line |
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
		
		@Data class Movie {
			String title
			int year
			double rating
			long numberOfVotes
			Set<String> categories 
		}
		''',
		'java.xtend' -> '''
		class Example {
						
		}
		'''	
	}

	override get(String resourceId) throws IOException {
		val result = documentProvider.get
		val resourceSet = resourceSetProvider.get(resourceId)
		val resource = resourceSet.createResource(URI.createURI(resourceId)) as XtextResource
		result.setInput(resource,resourceId)
		result.text = formatter.format(examples.get(resourceId) ?: '')
		return result
	}
	
	override put(IXtextWebDocument document) throws IOException {
	/* 	try {
			val uri = document.resource.URI//URI.getFileURI(document.resourceId)
			if (uri.fileExtension.equals("xtend")){
				return
			}
			val outputStream = document.resource.resourceSet.URIConverter.createOutputStream(uri)
			val writer = new OutputStreamWriter(outputStream, encodingProvider.getEncoding(uri))
			writer.write(document.text)
			writer.close
		} catch (WrappedException exception) {
			throw exception.cause
		}
		* 
		*/
	}

	

}