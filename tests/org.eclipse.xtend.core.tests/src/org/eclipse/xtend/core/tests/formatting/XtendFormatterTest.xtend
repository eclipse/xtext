package org.eclipse.xtend.core.tests.formatting

import org.junit.Test
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys
import com.google.inject.Inject

class XtendFormatterTest extends AbstractFormatterTest {
	
	@Inject extension XtendFormatterConfigKeys
	
	@Test def formatClass1() {
		assertFormatted('''
			package foo
			
			class bar {
			}
		''', '''
			package  foo  class  bar  {  }
		''')	
	}
	
	@Test def formatClass11() {
		assertFormatted('''
			package foo
			
			class bar {
			}
		''', '''   package  foo  class  bar  {  }''')	
	}
	
	@Test def formatClass2() {
		assertFormatted('''
			class bar {
			}
		''', '''
			class bar{}
		''')	
	}
	
	@Test def formatClass3() {
		assertFormatted('''
			class bar {
				int member1
				int member2
			
				def meth1() {
				}
			
				def meth2() {
				}
			
				int member3
			}
		''', '''
			class bar{ int member1 int member2 def meth1() {} def meth2(){} int member3 }
		''')	
	}
	
	@Test def formatClass31() {
		assertFormatted('''
			class bar {
			
				def meth1() {
				}
			
			}
		''', '''
			class bar{
			

				def meth1() {} 


			}
		''')	
	}
	
	@Test def formatClass4() {
		assertFormatted('''
			class bar {

				int member1

				int member2
			
				def meth1() {
				}
			
				def meth2() {
				}
			
				int member3
			}
		''', '''
			class bar{
				
				
				int member1 
				
				
				int member2 
				
				
				def meth1() {} 
				
				
				def meth2(){} 
				
				
				int member3
			}
		''')	
	}
	
	@Test def formatClasses1() {
		assertFormatted('''
			package foo
			
			class bar {
			}
			
			class baz {
			}
		''', '''
			package foo class bar{} class baz{}
		''')	
	}
	
	@Test def formatClasses2() {
		assertFormatted('''
			package foo
			
			class bar {
			}
			
			class baz {
			}
		''', '''
			package foo 
			
			
			
			class bar{} 
			
			
			
			class baz{}
		''')	
	}
	
	@Test def formatImports1() {
		assertFormatted('''
			package foo
			
			import java.util.Map
			import java.util.Set
			
			class bar {
				def baz() {
				}
			}
		''')	
	}
	
	@Test def formatImports2() {
		assertFormatted('''
			package foo
			
			import java.util.Map
			
			import java.util.Set
			
			class bar {
			}
		''', '''
			package foo
			
			import java.util.Map

			
			import java.util.Set


			
			class bar {
			}
		''')	
	}
	
	@Test def formatConstructor() {
		assertFormatted('''
			class bar {
				new() {
				}
			}
		''')	
	}
	
	@Test def formatConstructor1() {
		assertFormatted('''
			class bar {
				new() {
					super()
				}
			}
		''')	
	}
	
	@Test def formatConstructor2() {
		assertFormatted('''
			class bar {
				new(String x) {
					super(x)
				}
			}
		''')	
	}
	
	@Test def formatConstructor3() {
		assertFormatted('''
			class bar {
				new(String x, String y) {
					super(x, y)
				}
			}
		''')	
	}
	
	@Test def formatMethod() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz() {
				}
			}
		''')	
	}
	
	@Test def formatMethod1() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(String x) {
				}
			}
		''')	
	}
	
	@Test def formatMethod2() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(String x, String y) {
				}
			}
		''')	
	}
	
	@Test def formatMethod3() {
		assertFormatted('''
			package foo

			class bar {
				def baz(String p1, String p2, String p3, String p4, String p5, String p6,
					String p7, String p8, String p9, String p10, String p11, String p12,
					String p13, String p14) {
				}
			}
		''')	
	}
	
	@Test def formatMethodMultiline() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(
					String x,
					String y
				) {
				}
			}
		''', '''
			package foo
			
			class bar {
				def baz(String x, String y
				) {
				}
			}
		''')	
	}
	
	
	@Test def formatMethodAnnotation() {
		assertFormatted('''
			package foo
			
			class bar {
				@Deprecated def baz() {
				}
			}
		''')	
	}
	
	
	@Test def formatGenerics() {
		assertFormattedExpression('''
			val x = <Pair<String, String>>newArrayList()
		''')	
	}
	
	@Test def formatBlockExpression() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b");
			val y = 'foo';
			x.join
		''', '''
			val x = newArrayList("A", "b") ; val y = 'foo' ; x.join
		''')	
	}
	
	@Test def formatBlockExpressionPreserveNewLines() {
		assertFormatted('''
			class Foo {
				def bar() {

					val x = newArrayList("A", "b");

					val y = 'foo'

					x.join

				}
			}
		''', '''
			class Foo {
				def bar() {


			val x = newArrayList("A", "b") ;


			val y = 'foo'


			 x.join


			  }}
		''')	
	}
	
	@Test def formatClosures() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[toUpperCase == it]
			y.join
		''')	
	}
	
	@Test def formatClosuresSemicolon() {
		assertFormattedExpression('''
			newArrayList("A", "b").filter[val b = it; b.toUpperCase == b]
		''', '''
			newArrayList("A", "b").filter[ val b = it  ;   b.toUpperCase == b ]
		''')	
	}
	
	@Test def formatClosuresEmpty() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter[   ] y.join
		''')	
	}
	
	@Test def formatClosuresParam() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[z|z.toUpperCase == z]
			y.join
		''')	
	}
	
	@Test def formatClosuresMultiLine() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter [
				val z = it
				z.toUpperCase == z
			]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter [
				val z = it z.toUpperCase == z 
			] y.join
		''')
	}
	
	@Test def formatClosuresMultiLine_02() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter [
				val z = it
				z.toUpperCase == z
			]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter[
				val z = it z.toUpperCase == z 
			] y.join
		''')
	}
	
	@Test def formatClosuresMultiLineSemicolon() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter [
				val z = it;
				z.toUpperCase == z;
			]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter [
				val z = it  ;   z.toUpperCase == z  ;   
			] y.join
		''')	
	}
	
	@Test def formatClosuresWrapIfNeeded() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[val z = it z.toUpperCase == z z.toUpperCase == z
				z.toUpperCase == z]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter [ val z = it z.toUpperCase == z z.toUpperCase == z z.toUpperCase == z ] y.join
		''')	
	}
	
	@Test def formatClosuresParamMultiLine() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter [ z |
				val w = z
				w.toUpperCase == w
			]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter[ z |
				val w = z w.toUpperCase == w
			] y.join
		''')	
	}
	
	@Test def formatClosuresWithOperator() {
		assertFormattedExpression('''
			val x = new StringBuffer() => [
				append("x")
				append("y")
			]
		''', '''
			val x = new StringBuffer() => [
				append("x")
				append("y")
			]
		''')	
	}
	
	@Test def formatMultiLineClosureWithAssignment() {
		assertFormattedExpression('''
			x += foo.myBuilder [
				foo
				bar
			]
		''', '''
			x += foo.myBuilder [
				foo bar
			]
		''')	
	}
	
	@Test def formatIf1SL1() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisSL, true)
		],'''
			if (true) println("foo")
		''')	
	}
	
	@Test def formatIf1SL2() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisSL, false)
		],'''
			if(true) println("foo")
		''')	
	}
	
	@Test def formatIf1ML1() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, true)
		],'''
			if (true)
				println("foo")
		''')	
	}
	
	@Test def formatIf1ML2() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, false)
		],'''
			if(true)
				println("foo")
		''')	
	}
	
	@Test def formatIf1MLVar() {
		assertFormattedExpression('''
			var x = if (true)
					println("foo")
				else
					println("bar")
		''', '''
			var x = if(true)
			println("foo") else println("bar")
		''')	
	}
	
	@Test def formatIf1MLSemicolon1() {
		assertFormattedExpression('''
			if (true)
				println("foo");
		''', '''
			if(true)
			println("foo");
		''')	
	}
	
	@Test def formatIf1MLSemicolon2() {
		assertFormattedExpression('''
			if (true)
				println("foo");
			println("bar")
		''', '''
			if(true)
			println("foo");
			println("bar")
		''')	
	}
	
	@Test def formatIf2() {
		assertFormattedExpression('''
			if (true) {
				println("foo")
			}
		''')	
	}
	
	@Test def formatIfElse1SL() {
		assertFormattedExpression('''
			if(true) println("foo") else println("bar")
		''', '''
			if(true)println("foo")else  println("bar")
		''')	
	}
	
	@Test def formatIfElse1ML() {
		assertFormattedExpression('''
			if (true)
				println("foo")
			else
				println("bar")
		''', '''
			if(true)
			println("foo")
			else
			println("bar")
		''')	
	}
	
	@Test def formatIfElse2() {
		assertFormattedExpression('''
			if (true) {
				println("foo")
			} else {
				println("bar")
			}
		''')
	}
	
	@Test def formatIfElseIf1() {
		assertFormattedExpression('''
			if (true)
				println("foo")
			else if (false)
				println("bar")
		''', '''
			if(true)
			println("foo")
			else if(false)
			println("bar")
		''')
	}
	
	@Test def formatIfElseIf2() {
		assertFormattedExpression('''
			if (true) {
				println("foo")
			} else if (false) {
				println("bar")
			}
		''', '''
			if(true) {
			println("foo")
			} else if(false) {
			println("bar")
			}
		''')
	}
	
	@Test def formatIfElseIf3() {
		assertFormattedExpression('''
			if (true) {
				println("foo")
			} else if (false)
				println("bar")
		''', '''
			if(true) {
			println("foo")
			} else if(false)
			println("bar")
		''')
	}
			
	@Test def formatFor1() {
		assertFormattedExpression('''
			for (i : 1 .. 2)
				println(i)
		''', '''
			for  (  i  :  1 .. 2  )  println(i)
		''')	
	}
	
	@Test def formatFor2() {
		assertFormattedExpression('''
			for (i : 1 .. 2) {
				println(i)
			}
		''', '''
			for  (  i  :  1   ..   2  )   {   println(i)  }
		''')	
	}
	
	@Test def formatWhile11() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, true)
		],'''
			while (true)
				println("x")
		''')	
	}
	
	@Test def formatWhile12() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, false)
		],'''
			while(true)
				println("x")
		''')	
	}
	
	@Test def formatWhile2() {
		assertFormattedExpression('''
			while (true) {
				println("x")
			}
		''', '''
			while  (  true  )   {   println("x")  }
		''')	
	}
	
	@Test def formatDoWhile11() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, true)
		],'''
			do
				println("x")
			while (true)
		''')	
	}
	
	@Test def formatDoWhile12() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, false)
		],'''
			do
				println("x")
			while(true)
		''')	
	}
	
	@Test def formatDoWhile2() {
		assertFormattedExpression('''
			do {
				println("x")
			} while (true)
		''', '''
			do  {  println("x")   } while  (  true  ) 
		''')		
	}
	
	@Test def formatSwitchSL() {
		assertFormattedExpression('''
			switch 'x' { case 'x': println('x') case 'y': println('y') }
		''', '''
			switch 'x'  {   case 'x':   println('x')   case   'y':    println('y')    }
		''')	
	}
	
	@Test def formatSwitchSLParenthesis() {
		assertFormattedExpression('''
			switch 'x' { case 'x': println('x') case 'y': println('y') }
		''', '''
			switch  'x'  {   case 'x':   println('x')   case   'y':    println('y')    }
		''')	
	}
	
	@Test def formatSwitchCaseSL() {
		assertFormattedExpression('''
			switch 'x' {
				case 'x': println('x')
				case 'y': println('y')
			}
		''', '''
			switch 'x'  {   
				case 'x':   println('x')   case   'y':    println('y')
			}
		''')	
	}
	
	@Test def formatSwitchCaseSLParenthesis() {
		assertFormattedExpression('''
			switch 'x' {
				case 'x': println('x')
				case 'y': println('y')
			}
		''', '''
			switch   'x'  {   
				case 'x':   println('x')   case   'y':    println('y')
			}
		''')	
	}
	
	@Test def formatSwitchML() {
		assertFormattedExpression('''
			switch 'x' {
				case 'x':
					println('x')
				case 'y':
					println('y')
			}
		''', '''
			switch 'x'  {   
				case 'x':   
					println('x')   case   'y':    println('y')
			}
		''')	
	}
	
	@Test def formatSwitchMLBlock() {
		assertFormattedExpression('''
			switch 'x' {
				case 'x': {
					println('x')
				}
				case 'y': {
					println('y')
				}
			}
		''', '''
			switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } }
		''')	
	}
	
	@Test def formatFeatureCall1() {
		assertFormattedExpression('''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4),
				newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12),
				newArrayList(13, 14, 15, 16))
		''', '''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
		''')	
	}
	
	@Test def formatFeatureCall2() {
		assertFormattedExpression('''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4),
				newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,
					110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
				newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
		''', '''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
		''')	
	}
	
	@Test def formatFeatureCallMultiline() {
		assertFormattedExpression('''
			val ML2 = newArrayList(
				newArrayList(1, 2, 3, 4),
				newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,
					110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
				newArrayList(9),
				newArrayList(10)
			)
		''', '''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9), newArrayList(10)
			)
		''')	
	}
	
	@Test def formatConstructorCall1() {
		assertFormattedExpression('''
			val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4),
				new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12),
				new ArrayList(13, 14, 15, 16))
		''', '''
			val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))
		''')	
	}
	
	@Test def formatConstructorCall2() {
		assertFormattedExpression('''
			val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4),
				new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108,
					109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
				new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))
		''', '''
			val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))
		''')	
	}
	
	@Test def formatConstructorCallMultiline() {
		assertFormattedExpression('''
			val ML2 = new ArrayList(
				new ArrayList(1, 2, 3, 4),
				new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108,
					109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
				new ArrayList(9, 10, 11, 12),
				new ArrayList(13, 14, 15, 16)
			)
		''', '''
			val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16)
			)
		''')	
	}
	
	@Test def formatMemberFeatureCall1() {
		assertFormattedExpression('''
			val ML1 = "x".substring(0).substring(1).substring(2).substring(3).
				substring(4).substring(5).substring(6).substring(7).substring(8).
				substring(9).substring(10).substring(11)
		''', '''
			val ML1 = "x".substring(0).substring(1).substring(2).substring(3).substring(4).substring(5).substring(6).substring(7).substring(8).substring(9).substring(10).substring(11)
		''')	
	}
	
	@Test def formatMemberFeatureCall2() {
		assertFormattedExpression('''
			val ML1 = "x".substring(0).substring(1)
		''', '''
			val ML1 = "x"
			.
			substring(0)
			.
			substring(1)
		''')	
	}
	
	@Test def formatMemberFeatureCall21() {
		assertFormattedExpression('''
			val ML1 = "x".toString.toString
		''', '''
			val ML1 = "x"
			.
			toString
			.
			toString
		''')	
	}
	
	@Test def formatMemberFeatureCall3() {
		assertFormattedExpression('''
			val ML1 = "x".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)
		''', '''
			val ML1 = "x".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)
		''')	
	}
	
	@Test def formatMemberFeatureCall4() {
		assertFormattedExpression('''
			val ML1 = "x".substring(0, 1, 2)
		''', '''
			val ML1 = "x".substring (
			
			0, 
			
			1, 
			
			2)
		''')	
	}
	
	@Test def formatMemberFeatureCallMultiline() {
		assertFormattedExpression('''
			val ML1 = "x".substring(
				0,
				1,
				2
			)
		''', '''
			val ML1 = "x".substring (
			
			0, 
			
			1, 
			
			2
			)
		''')	
	}
	
	@Test def formatMemberFeatureCallBuilder1() {
		assertFormattedExpression('''
			newArrayList("x").map()[]
		''', '''
			newArrayList("x")  .  map  (  )  [  ]
		''')	
	}
	
	@Test def formatMemberFeatureCallBuilder2() {
		assertFormattedExpression('''
			newArrayList("x").map()[lenght]
		''', '''
			newArrayList("x")  .  map  (  )  [  lenght  ]
		''')	
	}
	
	@Test def formatMemberFeatureCallBuilderMultiline1() {
		assertFormattedExpression('''
			newArrayList("x").map(
				length
			)[lenght]
		''', '''
			newArrayList("x")  .  map  (  length  
			)  [  lenght  ]
		''')	
	}
	
	@Test def formatMemberFeatureCallBuilderMultiline2() {
		assertFormattedExpression('''
			newArrayList("x").map(length) [
				length
			]
		''', '''
			newArrayList("x")  .  map  (  length   )  [  length  
			]
		''')	
	}
	
	@Test def formatBinaryExpression1() {
		assertFormattedExpression('''
			val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 +
				15 + 16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 +
				29 + 30 + 31 + 32 + 33 + 34 + 35 + 36
		''', '''
			val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 
		''')	
	}
	
	@Test def formatBinaryExpression2() {
		assertFormattedExpression('''
			val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 +
				11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 +
				25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36
		''', '''
			val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 
		''')	
	}
	
	@Test def formatXTypeLiteral() {
		assertFormattedExpression('''
			typeof(String)
		''', '''
			typeof  (  String  )
		''')	
	}
	
	@Test def formatXTypeLiteralArray1() {
		assertFormattedExpression('''
			typeof(String[])
		''', '''
			typeof  (  String  [  ])
		''')	
	}
	
	@Test def formatXTypeLiteralArray2() {
		assertFormattedExpression('''
			typeof(String[][])
		''', '''
			typeof  (  String  [  ] [ ] )
		''')	
	}
	
	@Test def formatXThrowExpression() {
		assertFormattedExpression('''
			throw new RuntimeException()
		''', '''
			throw  new  RuntimeException()
		''')	
	}
	
	@Test def formatXReturnExpression1() {
		assertFormattedExpression('''
			return "foo"
		''', '''
			return   "foo"
		''')	
	}
	
	@Test def formatXReturnExpression2() {
		assertFormattedExpression('''
			"foo"
			return
		''', '''
			"foo"  return
		''')	
	}
	
	@Test def formatXReturnExpression3() {
		assertFormattedExpression('''
			return;
		''', '''
			return   ;
		''')	
	}
	
	@Test def formatTryFinallyExpression1() {
		assertFormattedExpression('''
			try
				println("x")
			finally
				println("y")
		''', '''
			try   println("x")   finally   println("y")
		''')	
	}
	
	@Test def formatTryFinallyExpression2() {
		assertFormattedExpression('''
			try {
				println("x")
			} finally {
				println("y")
			}
		''', '''
			try  {   println("x")  }  finally  {  println("y")  }
		''')	
	}
	
	@Test def formatTryCatchExpression11() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, true)
		],'''
			try
				println("x")
			catch (Exception e)
				println("y")
		''')	
	}
	
	@Test def formatTryCatchExpression12() {
		assertFormattedExpression([
			put(whitespaceBetweenKeywordAndParenthesisML, false)
		],'''
			try
				println("x")
			catch(Exception e)
				println("y")
		''')	
	}
	
	@Test def formatTryCatchExpression2() {
		assertFormattedExpression('''
			try {
				println("x")
			} catch (Exception e) {
				println("y")
			}
		''', '''
			try  {   println("x")  }  catch (  Exception   e  )  {  println("y")  }
		''')	
	}
	
	@Test def formatTryCatchFinallyExpression1() {
		assertFormattedExpression('''
			try
				println("x")
			catch (Exception e)
				println("y")
			finally
				println("z")
		''', '''
			try   println("x")  catch   (   Exception   e   )   println("y")  finally   println("z")
		''')	
	}
	
	@Test def formatTryCatchFinallyExpression2() {
		assertFormattedExpression('''
			try {
				println("x")
			} catch (Exception e) {
				println("y")
			} finally {
				println("z")
			}
		''', '''
			try  {   println("x")  }   catch   (   Exception   e   )  {  println("y")  } finally  {  println("z")  }
		''')	
	}
	
	@Test def formatTryCatchCatchFinallyExpression1() {
		assertFormattedExpression('''
			try
				println("x")
			catch (Exception e)
				println("y")
			catch (Exception f)
				println("z")
			finally
				println("a")
		''', '''
			try   println("x")  catch   (   Exception   e   )   println("y")  catch   (   Exception   f  )   println("z")  finally   println("a")
		''')	
	}
	
	@Test def formatTryCatchCatchFinallyExpression2() {
		assertFormattedExpression('''
			try {
				println("x")
			} catch (Exception e) {
				println("y")
			} catch (Exception f) {
				println("z")
			} finally {
				println("a")
			}
		''', '''
			try  {   println("x")  }   catch   (   Exception   e   )  {  println("y")  } catch   (   Exception   f  )  {  println("z")  } finally  {  println("a")  }
		''')	
	}
	
	@Test def formatPreferencesExample() {
		assertFormatted('''
			class Movies {
				def settings(XtendFormatterConfig config) {
					val List<FormatterSetting> settings = newArrayList()
					for (entry : config.namedProperties.entrySet) {
						val key = entry.key
						val category = key.split(".").head
						var catEnum = Category::byName(category)
						if (catEnum == null)
							catEnum = Category::OTHER
						settings.add(
							createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD,
								key, key.toFirstUpper, newArrayList(entry.value.name)))
					}
					return settings
				}
			}
		''')	
	}
	
}