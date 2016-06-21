package org.eclipse.xtext.xbase.tests.formatting

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseFormatterTestInjectorProvider))
class XbaseFormatterTest {

	@Inject extension XbaseFormatterTester

	@Test def formatGenerics() {
		assertFormattedExpression [
			toBeFormatted = '''
				val x = <Pair<String, String>>newArrayList()
			'''
		]
	}

	@Test def formatBlockExpression() {
		assertFormattedExpression [
			expectation = '''
				val x = newArrayList("A", "b");
				val y = 'foo';
				x.join
			'''
			toBeFormatted = '''
				val x = newArrayList("A", "b") ; val y = 'foo' ; x.join
			'''
		]
	}

	@Test def formatBlockExpressionPreserveNewLines() {
		assertFormatted[
			expectation = '''
				{
				
					val x = newArrayList("A", "b");
				
					val y = 'foo'
				
					x.join
				
				}
			'''.toString.trim
			toBeFormatted = '''
				  {  
				
				
				val x = newArrayList("A", "b") ;
				
				
				val y = 'foo'
				
				
				 x.join
				
				
				 }
			'''
		]
	}

	@Test def formatClosures() {
		assertFormattedExpression [
			toBeFormatted = '''
				val x = newArrayList("A", "b")
				val y = x.filter[toUpperCase == it]
				y.join
			'''
		]
	}

	@Test def formatClosuresParenthesis() {
		assertFormattedExpression [
			toBeFormatted = '''
				val x = newArrayList("A", "b")
				val y = x.filter(toUpperCase == it)
				y.join
			'''
		]
	}

	@Test def formatClosuresParenthesis2() {
		assertFormattedExpression [
			toBeFormatted = '''
				val x = newArrayList("A", "b")
				val y = x.filter(foo|foo.toUpperCase == foo)
				y.join
			'''
		]
	}

	@Test def formatClosuresSemicolon() {
		assertFormattedExpression [
			expectation = '''
				newArrayList("A", "b").filter[val b = it; b.toUpperCase == b]
			'''
			toBeFormatted = '''
				newArrayList("A", "b").filter[ val b = it  ;   b.toUpperCase == b ]
			'''
		]
	}

	@Test def formatClosuresEmpty() {
		assertFormattedExpression [
			expectation = '''
				val x = newArrayList("A", "b")
				val y = x.filter[]
				y.join
			'''
			toBeFormatted = '''
				val x = newArrayList("A", "b") val y = x.filter[   ] y.join
			'''
		]
	}

	@Test def formatClosuresParam() {
		assertFormattedExpression [
			toBeFormatted = '''
				val x = newArrayList("A", "b")
				val y = x.filter[z|z.toUpperCase == z]
				y.join
			'''
		]
	}

	@Test def formatClosuresEmptyParam() {
		assertFormattedExpression [
			toBeFormatted = '''
				val Iterable<Object> x = [|#[].iterator]
			'''
		]
	}

	@Test def formatClosuresMultiLine() {
		assertFormattedExpression [
			expectation = '''
				val x = newArrayList("A", "b")
				val y = x.filter [
					val z = it
					z.toUpperCase == z
				]
				y.join
			'''
			toBeFormatted = '''
				val x = newArrayList("A", "b") val y = x.filter [
					val z = it z.toUpperCase == z 
				] y.join
			'''
		]
	}

	@Test def formatClosuresMultiLine_02() {
		assertFormattedExpression [
			expectation = '''
				val x = newArrayList("A", "b")
				val y = x.filter [
					val z = it
					z.toUpperCase == z
				]
				y.join
			'''
			toBeFormatted = '''
				val x = newArrayList("A", "b") val y = x.filter[
					val z = it z.toUpperCase == z 
				] y.join
			'''
		]
	}

	@Test def formatClosuresMultiLine03() {
		assertFormattedExpression [
			expectation = '''
				new Thread [|
					println("foo")
				]
			'''
			toBeFormatted = '''
				new Thread[  | println("foo")
				]
			'''
		]
	}

	@Test def formatClosuresMultiLineSemicolon() {
		assertFormattedExpression [
			expectation = '''
				val x = newArrayList("A", "b")
				val y = x.filter [
					val z = it;
					z.toUpperCase == z;
				]
				y.join
			'''
			toBeFormatted = '''
				val x = newArrayList("A", "b") val y = x.filter [
					val z = it  ;   z.toUpperCase == z  ;   
				] y.join
			'''
		]

	}

	@Test def formatClosuresWrapIfNeeded() {
		assertFormattedExpression [
			expectation = '''
				val x = newArrayList("A", "b")
				val y = x.filter [
					val z = it
					z.toUpperCase == z
					z.toUpperCase == z
					z.toUpperCase == z
				]
				y.join
			'''
			toBeFormatted = '''
				val x = newArrayList("A", "b") val y = x.filter [ val z = it z.toUpperCase == z z.toUpperCase == z z.toUpperCase == z ] y.join
			'''
		]
	}

	@Test def formatClosuresParamMultiLine() {
		assertFormattedExpression [
			expectation = '''
				val x = newArrayList("A", "b")
				val y = x.filter [ z |
					val w = z
					w.toUpperCase == w
				]
				y.join
			'''
			toBeFormatted = '''
				val x = newArrayList("A", "b") val y = x.filter[ z |
					val w = z w.toUpperCase == w
				] y.join
			'''
		]
	}

	@Test def formatClosuresWithOperator() {
		assertFormattedExpression [
			expectation = '''
				val x = new StringBuffer() => [
					append("x")
					append("y")
				]
			'''
			toBeFormatted = '''
				val x = new StringBuffer() => [
					append("x")
					append("y")
				]
			'''
		]
	}

	@Test def formatMultiLineClosureWithAssignment() {
		assertFormattedExpression [
			expectation = '''
				x += foo.myBuilder [
					foo
					bar
				]
			'''
			toBeFormatted = '''
				x += foo.myBuilder [
					foo bar
				]
			'''
		]
	}

	@Test def formatSynchronizedBlock_1() {
		assertFormattedExpression [
			expectation = '''
				synchronized (new Object) {
				}
			'''
			toBeFormatted = '''
				synchronized(new Object){}
			'''
		]
	}

	@Test def formatSynchronizedBlock_2() {
		assertFormattedExpression [
			expectation = '''
				synchronized (new Object) {
				}
			'''
			toBeFormatted = '''
				synchronized         (          new            Object           )        {        }
			'''
		]
	}

	@Test def formatIf1SL1() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisSL, true)
			]
			toBeFormatted = '''
				if (true) println("foo")
			'''
		]
	}

	@Test def formatIf1SL2() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisSL, false)
			]
			toBeFormatted = '''
				if(true) println("foo")
			'''
		]
	}

	@Test def formatIf1ML1() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisML, true)
			]
			toBeFormatted = '''
				if (true)
					println("foo")
			'''
		]
	}

	@Test def formatIf1ML2() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisML, false)
			]
			toBeFormatted = '''
				if(true)
					println("foo")
			'''
		]
	}

	@Test def formatIf1MLVar() {
		assertFormattedExpression [
			expectation = '''
				var x = if (true)
						println("foo")
					else
						println("bar")
			'''
			toBeFormatted = '''
				var x = if(true)
				println("foo") else println("bar")
			'''
		]
	}

	@Test def formatIf1MLSemicolon1() {
		assertFormattedExpression [
			expectation = '''
				if (true)
					println("foo");
			'''
			toBeFormatted = '''
				if(true)
				println("foo");
			'''
		]
	}

	@Test def formatIf1MLSemicolon2() {
		assertFormattedExpression [
			expectation = '''
				if (true)
					println("foo");
				println("bar")
			'''
			toBeFormatted = '''
				if(true)
				println("foo");
				println("bar")
			'''
		]
	}

	@Test def formatIf2() {
		assertFormattedExpression [
			toBeFormatted = '''
				if (true) {
					println("foo")
				}
			'''
		]
	}

	@Test def formatIfElse1SL() {
		assertFormattedExpression [
			expectation = '''
				if(true) println("foo") else println("bar")
			'''
			toBeFormatted = '''
				if(true)println("foo")else  println("bar")
			'''
		]
	}

	@Test def formatIfElse1ML() {
		assertFormattedExpression [
			expectation = '''
				if (true)
					println("foo")
				else
					println("bar")
			'''
			toBeFormatted = '''
				if(true)
				println("foo")
				else
				println("bar")
			'''
		]
	}

	@Test def formatIfElse2() {
		assertFormattedExpression [
			toBeFormatted = '''
				if (true) {
					println("foo")
				} else {
					println("bar")
				}
			'''
		]
	}

	@Test def formatIfElse3() {
		assertFormattedExpression [
			preferences[
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				if (true)
				{
					println("foo")
				}
				else
				{
					println("bar")
				}
			'''
		]
	}

	@Test def formatIfElseIf1() {
		assertFormattedExpression [
			expectation = '''
				if (true)
					println("foo")
				else if (false)
					println("bar")
			'''
			toBeFormatted = '''
				if(true)
				println("foo")
				else if(false)
				println("bar")
			'''
		]
	}

	@Test def formatIfElseIf2() {
		assertFormattedExpression [
			expectation = '''
				if (true) {
					println("foo")
				} else if (false) {
					println("bar")
				}
			'''
			toBeFormatted = '''
				if(true) {
				println("foo")
				} else if(false) {
				println("bar")
				}
			'''
		]
	}

	@Test def formatIfElseIf3() {
		assertFormattedExpression [
			expectation = '''
				if (true) {
					println("foo")
				} else if (false)
					println("bar")
			'''
			toBeFormatted = '''
				if(true) {
				println("foo")
				} else if(false)
				println("bar")
			'''
		]
	}

	@Test def formatFor1() {
		assertFormattedExpression [
			expectation = '''
				for (i : 1 .. 2)
					println(i)
			'''
			toBeFormatted = '''
				for  (  i  :  1 .. 2  )  println(i)
			'''
		]
	}

	@Test def formatFor2() {
		assertFormattedExpression [
			preferences[
				put(bracesInNewLine, false)
			]
			toBeFormatted = '''
				for (i : 1 .. 2) {
					println(i)
				}
			'''
		]
	}

	@Test def formatFor3() {
		assertFormattedExpression [
			preferences[
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				for (i : 1 .. 2)
				{
					println(i)
				}
			'''
		]
	}

	@Test def formatBasicFor() {
		assertFormattedExpression [
			expectation = '''
				for (var i = 1; i < 10; i = i + 1)
					println(i)
			'''
			toBeFormatted = '''
				for  (  var    i  =   1  ;   i   <   10;   i    =  i    +  1  )  println(i)
			'''
		]
	}

	@Test def formatBasicFor2() {
		assertFormattedExpression [
			expectation = '''
				for (;;) {
					return true
				}
			'''
			toBeFormatted = '''
				for  (      ;     ;      )  {     return     true }
			'''
		]
	}

	@Test def formatBasicFor3() {
		assertFormattedExpression [
			expectation = '''
				var int x
				var int y
				for (x = 1, y = 2;;) {
					return x + y
				}
			'''
			toBeFormatted = '''
				var   int     x
				var   int    y 
				for  (       x   = 1    ,   y     =   2 ;     ;      )  {     return     x  +  y }
			'''
		]
	}

	@Test def formatBasicFor4() {
		assertFormattedExpression [
			expectation = '''
				val x = 1
				for (; x < 10;)
					println(x)
			'''
			toBeFormatted = '''
				val x = 1
				for  (       ;     x     <    10      ;      )       println(x)
			'''
		]
	}

	@Test def formatBasicFor5() {
		assertFormattedExpression [
			expectation = '''
				val x = 1
				for (;; x = x + 1, x = x + 2)
					println(x)
			'''
			toBeFormatted = '''
				val x = 1
				for  (       ;     ;     x     =      x 	+      1  ,  x  =   x   +    2 )          println(x)
			'''
		]
	}

	@Test def formatBasicFor6() {
		assertFormattedExpression [
			expectation = '''
				for (val x = 1;; x = x + 1, x = x + 2)
					println(x)
			'''
			toBeFormatted = '''
				for  (			val 		x 		= 		1		;     ;     x     =      x 	+      1  ,  x  =   x   +    2 )          println(x)
			'''
		]
	}

	@Test def formatWhile11() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisML, true)
			]
			toBeFormatted = '''
				while (true)
					println("x")
			'''
		]
	}

	@Test def formatWhile12() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisML, false)
			]
			toBeFormatted = '''
				while(true)
					println("x")
			'''
		]
	}

	@Test def formatWhile2() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, false)
			]
			toBeFormatted = '''
				while (true) {
					println("x")
				}
			'''
		]
	}

	@Test def formatWhile21() {
		assertFormattedExpression [
			preferences[
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				while (true)
				{
					println("x")
				}
			'''
		]
	}

	@Test def formatDoWhile11() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisML, true)
			]
			toBeFormatted = '''
				do
					println("x")
				while (true)
			'''
		]
	}

	@Test def formatDoWhile12() {
		assertFormattedExpression [
			preferences[
				put(whitespaceBetweenKeywordAndParenthesisML, false)
			]
			toBeFormatted = '''
				do
					println("x")
				while(true)
			'''
		]
	}

	@Test def formatDoWhile2() {
		assertFormattedExpression [
			preferences[
				put(bracesInNewLine, false)
			]
			toBeFormatted = '''
				do {
					println("x")
				} while (true)
			'''
		]
	}

	@Test def formatDoWhile3() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				do
				{
					println("x")
				}
				while (true)
			'''
		]
	}

	@Test def formatSwitchSL() {
		assertFormattedExpression [
			preferences  [
				put(bracesInNewLine, false)
			]
			toBeFormatted = '''
				switch 'x' { case 'x': println('x') case 'y': println('y') }
			'''
		]
	}

	@Test def formatSwitchSL1() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				switch 'x' { case 'x': println('x') case 'y': println('y') }
			'''
		]
	}

	@Test def formatSwitchDefaultSL() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, false)
			]
			toBeFormatted = '''
				switch 'x' { case 'y': println('y') default: println('z') }
			'''
		]
	}

	@Test def formatSwitchDefaultSL1() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				switch 'x' { case 'y': println('y') default: println('z') }
			'''
		]
	}

	@Test def formatSwitchCaseSL1() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				switch 'x'
				{
					case 'x': println('x')
					case 'y': println('y')
				}
			'''
		]
	}

	@Test def formatSwitchCaseSLParenthesis() {
		assertFormattedExpression [
			expectation = '''
				switch 'x' {
					case 'x': println('x')
					case 'y': println('y')
				}
			'''
			toBeFormatted = '''
				switch   'x'  {   
					case 'x':   println('x')   case   'y':    println('y')
				}
			'''
		]
	}

	@Test def formatSwitchCaseDefaultSL1() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, true)
			]
			toBeFormatted = '''
				switch 'x'
				{
					case 'x': println('x')
					case 'y': println('y')
					default: println('z')
				}
			'''
		]
	}

	@Test def formatSwitchCaseDefaultSLParenthesis() {
		assertFormattedExpression [
			expectation = '''
				switch 'x' {
					case 'x': println('x')
					case 'y': println('y')
					default: println('z')
				}
			'''
			toBeFormatted = '''
				switch   'x'  {   
					case 'x':   println('x')   case   'y':    println('y')  default  :    println('z')
				}
			'''
		]
	}

	@Test def formatSwitchML() {
		assertFormattedExpression [
			expectation = '''
				switch 'x' {
					case 'x':
						println('x')
					case 'y':
						println('y')
				}
			'''
			toBeFormatted = '''
				switch 'x'  {   
					case 'x':   
						println('x')   case   'y':    println('y')
				}
			'''
		]
	}

	@Test def formatSwitchDefaultML() {
		assertFormattedExpression [
			expectation = '''
				switch 'x' {
					case 'x':
						println('x')
					case 'y':
						println('y')
					default:
						println('z')
				}
			'''
			toBeFormatted = '''
				switch 'x'  {   
					case 'x':   
						println('x')   case   'y':    println('y')     default  :    println('z')
				}
			'''
		]
	}

	@Test def formatSwitchDefault2ML() {
		assertFormattedExpression [
			expectation = '''
				switch 'x' {
					case 'x':
						println('x')
					case 'y':
						println('y')
					default:
						println('z')
				}
			'''
			toBeFormatted = '''
				switch 'x'  {   
					case 'x': println('x')   case   'y':    println('y')     
					default  :    
						println('z')
				}
			'''
		]
	}

	@Test def formatSwitchDefault2MLFallThrough() {
		assertFormattedExpression [
			expectation = '''
				switch 'x' {
					case 'x',
					case 'y':
						println('y')
					default:
						println('z')
				}
			'''
			toBeFormatted = '''
				switch 'x'  {   
					case 'x'  ,   case   'y':    println('y')     
					default  :    
						println('z')
				}
			'''
		]
	}

	@Test def formatSwitchMLBlock() {
		assertFormattedExpression [
			preferences [
				it.put(bracesInNewLine, false)
			]
			expectation = '''
				switch 'x' {
					case 'x': {
						println('x')
					}
					case 'y': {
						println('y')
					}
				}
			'''
			toBeFormatted = '''
				switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } }
			'''
		]
	}

	@Test def formatSwitchDefaultMLBlock() {
		assertFormattedExpression [
			preferences  [
				put(bracesInNewLine, false)
			]
			expectation = '''
				switch 'x' {
					case 'x': {
						println('x')
					}
					case 'y': {
						println('y')
					}
					default: {
						println('z')
					}
				}
			'''
			toBeFormatted = '''
				switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } default: { println('z') } }
			'''
		]
	}

	@Test def formatSwitchMLBlock1() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, true)
			]
			expectation = '''
				switch 'x'
				{
					case 'x':
					{
						println('x')
					}
					case 'y':
					{
						println('y')
					}
				}
			'''
			toBeFormatted = '''
				switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } }
			'''
		]
	}

	@Test def formatFeatureCallNoParenthesis() {
		assertFormattedExpression [
			toBeFormatted = '''
				val v1 = newArrayList
				val v2 = newArrayList
			'''
		]
	}

	@Test def formatFeatureCallNoParams() {
		assertFormattedExpression [
			toBeFormatted = '''
				val v1 = newArrayList()
				val v2 = newArrayList()
			'''
		]
	}

	@Test def formatFeatureCall1() {
		assertFormattedExpression [
			expectation = '''
				val ML2 = newArrayList(newArrayList(1, 2, 3, 4, 5, 6),
					newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12),
					newArrayList(13, 14, 15, 16))
			'''
			toBeFormatted = '''
				val ML2 = newArrayList(newArrayList(1, 2, 3, 4, 5, 6), newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
			'''
		]
	}

	@Test def formatFeatureCall2() {
		assertFormattedExpression [
			expectation = '''
				val ML2 = newArrayList(newArrayList(1, 2, 3, 4),
					newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,
						110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
					newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
			'''
			toBeFormatted = '''
				val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
			'''
		]
	}

	@Test def formatFeatureCallMultiline() {
		assertFormattedExpression [
			expectation = '''
				val ML2 = newArrayList(
					newArrayList(1, 2, 3, 4),
					newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,
						110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
					newArrayList(9),
					newArrayList(10)
				)
			'''
			toBeFormatted = '''
				val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9), newArrayList(10)
				)
			'''
		]
	}

	@Test def formatConstructorCallNoParenthesis() {
		assertFormattedExpression [
			toBeFormatted = '''
				val v1 = new ArrayList
				val v2 = new ArrayList
			'''
		]
	}

	@Test def formatConstructorCallClosure() {
		assertFormattedExpression [
			toBeFormatted = '''
				new Thread[|println("foo")]
			'''
		]
	}

	@Test def formatConstructorCallNoParams() {
		assertFormattedExpression [
			toBeFormatted = '''
				val v1 = new ArrayList()
				val v2 = new ArrayList()
			'''
		]
	}

	@Test def formatConstructorCall1() {
		assertFormattedExpression [
			expectation = '''
				val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4, 5, 6),
					new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12),
					new ArrayList(13, 14, 15, 16))
			'''
			toBeFormatted = '''
				val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4, 5, 6), new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))
			'''
		]
	}

	@Test def formatConstructorCall2() {
		assertFormattedExpression [
			expectation = '''
				val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4),
					new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,
						110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
					new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))
			'''
			toBeFormatted = '''
				val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))
			'''
		]
	}

	@Test def formatConstructorCallMultiline() {
		assertFormattedExpression [
			expectation = '''
				val ML2 = new ArrayList(
					new ArrayList(1, 2, 3, 4),
					new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,
						110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
					new ArrayList(9, 10, 11, 12),
					new ArrayList(13, 14, 15, 16)
				)
			'''
			toBeFormatted = '''
				val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16)
				)
			'''
		]
	}

	@Test def formatMemberFeatureCallNoParenthesis() {
		assertFormattedExpression [
			toBeFormatted = '''
				val v1 = "x".toString
				val v2 = "x".toString
			'''
		]
	}

	@Test def formatMemberFeatureCallNoParams() {
		assertFormattedExpression [
			toBeFormatted = '''
				val v1 = "x".toString()
				val v2 = "x".toString()
			'''
		]
	}

	@Test def formatMemberFeatureCall1() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = "x".substring(0).substring(1).substring(2).substring(3).
					substring(4).substring(5).substring(6).substring(7).substring(8).
					substring(9).substring(10).substring(11)
			'''
			toBeFormatted = '''
				val ML1 = "x".substring(0).substring(1).substring(2).substring(3).substring(4).substring(5).substring(6).substring(7).substring(8).substring(9).substring(10).substring(11)
			'''
		]
	}

	@Test def formatMemberFeatureCall2() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = "x".substring(0).substring(1)
			'''
			toBeFormatted = '''
				val ML1 = "x"
				.
				substring(0)
				.
				substring(1)
			'''
		]
	}

	@Test def formatMemberFeatureCall21() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = "x".toString.toString
			'''
			toBeFormatted = '''
				val ML1 = "x"
				.
				toString
				.
				toString
			'''
		]
	}

	@Test def formatMemberFeatureCall3() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = "x".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
					15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)
			'''
			toBeFormatted = '''
				val ML1 = "x".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)
			'''
		]
	}

	@Test def formatMemberFeatureCall4() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = "x".substring(0, 1, 2)
			'''
			toBeFormatted = '''
				val ML1 = "x".substring (
				
				0, 
				
				1, 
				
				2)
			'''
		]
	}

	@Test def formatMemberFeatureCallMultiline() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = "x".substring(
					0,
					1,
					2
				)
			'''
			toBeFormatted = '''
				val ML1 = "x".substring (
				
				0, 
				
				1, 
				
				2
				)
			'''
		]
	}

	@Test def formatMemberFeatureCallBuilder1() {
		assertFormattedExpression [
			expectation = '''
				newArrayList("x").map()[]
			'''
			toBeFormatted = '''
				newArrayList("x")  .  map  (  )  [  ]
			'''
		]
	}

	@Test def formatMemberFeatureCallBuilder2() {
		assertFormattedExpression [
			expectation = '''
				newArrayList("x").map()[lenght]
			'''
			toBeFormatted = '''
				newArrayList("x")  .  map  (  )  [  lenght  ]
			'''
		]
	}

	@Test def formatMemberFeatureCallBuilderMultiline1() {
		assertFormattedExpression [
			expectation = '''
				newArrayList("x").map(
					length
				)[lenght]
			'''
			toBeFormatted = '''
				newArrayList("x")  .  map  (  length  
				)  [  lenght  ]
			'''
		]
	}

	@Test def formatMemberFeatureCallBuilderMultiline2() {
		assertFormattedExpression [
			expectation = '''
				newArrayList("x").map(length) [
					length
				]
			'''
			toBeFormatted = '''
				newArrayList("x")  .  map  (  length   )  [  length  
				]
			'''
		]
	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=461033
	 */
	@Test def formatMemberFeatureCallParenthesized() {
		assertFormattedExpression [
			expectation = '''
				val s = ("a" + "b").substring(1)
			'''
			toBeFormatted = '''
				val  s  =  ("a"  +  "b") . substring(1)
			'''
		]
	}

	@Test def formatBinaryExpression1() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 +
					16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 +
					30 + 31 + 32 + 33 + 34 + 35 + 36
			'''
			toBeFormatted = '''
				val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 
			'''
		]
	}

	@Test def formatBinaryExpression2() {
		assertFormattedExpression [
			expectation = '''
				val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 +
					11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 +
					25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36
			'''
			toBeFormatted = '''
				val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 
			'''
		]
	}

	@Test def formatXTypeLiteral() {
		assertFormattedExpression [
			expectation = '''
				typeof(String)
			'''
			toBeFormatted = '''
				typeof  (  String  )
			'''
		]
	}

	@Test def formatXTypeLiteralArray1() {
		assertFormattedExpression [
			expectation = '''
				typeof(String[])
			'''
			toBeFormatted = '''
				typeof  (  String  [  ])
			'''
		]
	}

	@Test def formatXTypeLiteralArray2() {
		assertFormattedExpression [
			expectation = '''
				typeof(String[][])
			'''
			toBeFormatted = '''
				typeof  (  String  [  ] [ ] )
			'''
		]
	}

	@Test def formatXThrowExpression() {
		assertFormattedExpression [
			expectation = '''
				throw new RuntimeException()
			'''
			toBeFormatted = '''
				throw  new  RuntimeException()
			'''
		]
	}

	@Test def formatXReturnExpression1() {
		assertFormattedExpression [
			expectation = '''
				return "foo"
			'''
			toBeFormatted = '''
				return   "foo"
			'''
		]
	}

	@Test def formatXReturnExpression2() {
		assertFormattedExpression [
			expectation = '''
				"foo"
				return
			'''
			toBeFormatted = '''
				"foo"  return
			'''
		]
	}

	@Test def formatXReturnExpression3() {
		assertFormattedExpression [
			expectation = '''
				return;
			'''
			toBeFormatted = '''
				return   ;
			'''
		]
	}

	@Test def formatTryFinallyExpression1() {
		assertFormattedExpression [
			expectation = '''
				try
					println("x")
				finally
					println("y")
			'''
			toBeFormatted = '''
				try   println("x")   finally   println("y")
			'''
		]
	}

	@Test def formatTryFinallyExpression2() {
		assertFormattedExpression [
			expectation = '''
				try {
					println("x")
				} finally {
					println("y")
				}
			'''
			toBeFormatted = '''
				try  {   println("x")  }  finally  {  println("y")  }
			'''
		]
	}

	@Test def formatTryCatchExpression11() {
		assertFormattedExpression [
			preferences [
				put(whitespaceBetweenKeywordAndParenthesisML, true)
			]
			toBeFormatted = '''
				try
					println("x")
				catch (Exception e)
					println("y")
			'''
		]
	}

	@Test def formatTryCatchExpression12() {
		assertFormattedExpression [
			preferences [
				put(whitespaceBetweenKeywordAndParenthesisML, false)
			]
			toBeFormatted = '''
				try
					println("x")
				catch(Exception e)
					println("y")
			'''
		]
	}

	@Test def formatTryCatchExpression2() {
		assertFormattedExpression [
			expectation = '''
				try {
					println("x")
				} catch (Exception e) {
					println("y")
				}
			'''
			toBeFormatted = '''
				try  {   println("x")  }  catch (  Exception   e  )  {  println("y")  }
			'''
		]
	}

	@Test def formatTryCatchFinallyExpression1() {
		assertFormattedExpression [
			expectation = '''
				try
					println("x")
				catch (Exception e)
					println("y")
				finally
					println("z")
			'''
			toBeFormatted = '''
				try   println("x")  catch   (   Exception   e   )   println("y")  finally   println("z")
			'''
		]
	}

	@Test def formatTryCatchFinallyExpression2() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, false)
			]
			expectation = '''
				try {
					println("x")
				} catch (Exception e) {
					println("y")
				} finally {
					println("z")
				}
			'''
			toBeFormatted = '''
				try  {   println("x")  }   catch   (   Exception   e   )  {  println("y")  } finally  {  println("z")  }
			'''
		]
	}

	@Test def formatTryCatchFinallyExpression3() {
		assertFormattedExpression [
			preferences [
				put(bracesInNewLine, true)
			]
			expectation = '''
				try
				{
					println("x")
				}
				catch (Exception e)
				{
					println("y")
				}
				finally
				{
					println("z")
				}
			'''
			toBeFormatted = '''
				try  {   println("x")  }   catch   (   Exception   e   )  {  println("y")  } finally  {  println("z")  }
			'''
		]
	}

	@Test def formatTryCatchCatchFinallyExpression1() {
		assertFormattedExpression [
			expectation = '''
				try
					println("x")
				catch (Exception e)
					println("y")
				catch (Exception f)
					println("z")
				finally
					println("a")
			'''
			toBeFormatted = '''
				try   println("x")  catch   (   Exception   e   )   println("y")  catch   (   Exception   f  )   println("z")  finally   println("a")
			'''
		]
	}

	@Test def formatTryCatchCatchFinallyExpression2() {
		assertFormattedExpression [
			expectation = '''
				try {
					println("x")
				} catch (Exception e) {
					println("y")
				} catch (Exception f) {
					println("z")
				} finally {
					println("a")
				}
			'''
			toBeFormatted = '''
				try  {   println("x")  }   catch   (   Exception   e   )  {  println("y")  } catch   (   Exception   f  )  {  println("z")  } finally  {  println("a")  }
			'''
		]
	}

	@Test def formatListLiteral1() {
		assertFormattedExpression [
			expectation = '''
				#[12, 13, 14]
			'''
			toBeFormatted = '''
				#[12,     13  ,	14		]
			'''
		]
	}

	@Test def formatListLiteral3() {
		assertFormattedExpression [
			expectation = '''
				#[
					12,
					13,
					14
				]
			'''
			toBeFormatted = '''
				#[12,     13  ,	14		
				]
			'''
		]
	}

	@Test def formatEmptySwitchSL() {
		assertFormattedExpression [
			expectation = '''
				switch null { }
			'''
			toBeFormatted = '''
				switch   null    {      }
			'''
		]
	}

	@Test def formatEmptySwitchSL_2() {
		assertFormattedExpression [
			expectation = '''
				switch null { default: 1 }
			'''
			toBeFormatted = '''
				switch   null    {    default    :  1  }
			'''
		]
	}

	@Test def formatEmptySwitchML() {
		assertFormattedExpression [
			expectation = '''
				switch null {
				}
			'''
			toBeFormatted = '''
				switch   null    {      
					
					
					
				}
			'''
		]
	}

	@Test def formatEmptySwitchML_2() {
		assertFormattedExpression [
			expectation = '''
				switch null {
					default: 1
				}
			'''
			toBeFormatted = '''
				switch   null    {      
					
					
					
					default : 1
					
				}
			'''
		]
	}
	
	@Test def formatInstanceOf() {
		assertFormattedExpression [
			expectation = '''
				"x".toString instanceof String
			'''
			toBeFormatted = '''
				"x".toString  instanceof  String
			'''
		]
	}

	@Test def formatCast() {
		assertFormattedExpression [
			expectation = '''
				"x" as String
			'''
			toBeFormatted = '''
				"x"  as  String
			'''
		]
	}

	@Test def formatPostfix() {
		assertFormattedExpression [
			expectation = '''
				val i = j++
			'''
			toBeFormatted = '''
				val i = j ++
			'''
		]
	}
}
