package org.eclipse.xtext.xtend2.tests.smoke

class Case_3 {
	def testReturnExpression_06() {
	    val closure = [Integer i| return i]
	    for (x : 1..100) closure.apply(x)
	}
	def testOverriddenLocalVariable() {
	  val x = 3
	  var y = 2
	  {
	    var x2 = y
	    val y2 = 1
	    x2+y2
	  }
	}
	def testFeatureCall_03() {
		{ 
			var java.util.List<Character> x = ('abc'.toCharArray as Iterable<Character>).toList() 
			x 
		}
	}
}