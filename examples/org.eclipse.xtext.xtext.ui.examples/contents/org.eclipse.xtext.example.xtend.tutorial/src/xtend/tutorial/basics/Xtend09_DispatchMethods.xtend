package xtend.tutorial.basics

import junit.framework.TestCase
import xtend.tutorial.util.Circle
import xtend.tutorial.util.Rectangle
import xtend.tutorial.util.Shape

class Xtend09_DispatchMethods extends TestCase {
	
	/**
	 * In addition to the switch expression the dispatch keyword for
	 * overloaded functions can be used to enable dynamic polymorphic 
	 * dispatching.
	 * 
	 * Have a look at the generated Java code to understand how it is 
	 * mapped to Java.
	 */
	 
	 def dispatch toLabel(Rectangle rectangle) {
	 	if (rectangle.height == rectangle.width) {
	 		'''It's a square (x : «rectangle.height»)'''
	 	} else {
	 		'''It's a rectangle (x : «rectangle.height», y : «rectangle.width»)'''
	 	}
	 }
	 
	 def dispatch toLabel(Circle circle) 
	 	'''It's a circle (diameter : «circle.diameter»)'''
	 
	 def void testDispatchMethods() {
	 	val list = newArrayList(
	 		new Rectangle( 3, 4 ), 
	 		new Circle( 3 ), 
	 		new Rectangle( 5, 5 )
	 	)
	 	for (Shape shape : list) {
	 		println(shape.toLabel)
	 	}
	 }
}