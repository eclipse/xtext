package org.eclipse.xtend.core.tests.smoke

class Case_3 {
	def testReturnExpression_06() {
	    val (Integer) => Integer closure = [Integer i| return i]
	    for (x : 1..100) closure.apply(x)
	}
	def testReturnExpression_07() {
		if (typeof(Case_3) != null) {
		    val (int)=>int closure = [Integer i| return i]
		    for (x : 1..100) closure.apply(x)
		}
	}
	
	def testOverriddenLocalVariable() {
	  val x = 3
	  var y = 2
	  {
	  	x.toString // just to get rid of the unused warning
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