package org.eclipse.xtend.core.tests.performance

import java.util.Map

class XtendFileGenerator {
	
	def getContents(GeneratorConfig conf) '''
		«IF !conf.packageName.nullOrEmpty»
			package «conf.packageName»
		«ENDIF»
		
		import java.util.Collections
		import java.util.List
		import org.junit.Assert
		import xtend.tutorial.util.Amount
		import xtend.tutorial.util.Circle
		import xtend.tutorial.util.NetNode
		import xtend.tutorial.util.Person
		import xtend.tutorial.util.Rectangle
		import xtend.tutorial.util.Shape
		
		import static extension java.util.Collections.*
		«FOR staticImport : conf.staticImportTypes»
			import static extension «staticImport».*
		«ENDFOR»
		
		@Deprecated
		class «conf.className» {
			
			«FOR injectedExt : conf.injectedExtensionTypes»
				@com.google.inject.Inject
				extension «injectedExt» ext«conf.injectedExtensionTypes.indexOf(injectedExt)»
			«ENDFOR»
			
			/**
			 * Xtend supports the Java syntax
			 */
			@com.google.inject.Inject
			def «IF conf.noTypeInference»String «ENDIF»simpleMethodCall_01(Object myObject) {
				myObject.toString()
			}
			
			/**
			 * if a method does not take arguments you can leave out the parenthesis
			 */
			@Deprecated
			def «IF conf.noTypeInference»String «ENDIF»simpleMethodCall_02(Object myObject) {
				myObject.toString
			}
			
			/**
			 * Static property or method access is done using th
			 */
			def «IF conf.noTypeInference»void «ENDIF»staticProperties() {
				System::out.println("Hello World!")
				
				//Note: there is a preferred built in library for this
				println("Hello World!")
			}
			
			/**
			 * properties (i.e. getter and setter) can be accessed using the more readable property-syntax
			 */
			def «IF conf.noTypeInference»String «ENDIF»propertAccess(Person person) {
				person.forename = 'Joe'
				person.name = 'Developer'
				return person.forename+" "+person.name
			}
			
			/**
			 * Xtend supports operator overloading.
			 * An operator is just a mapping to a method with a special name (starting with the prefix 'operator_') and the correct number of arguments.
			 * A table of supported operators and their precedence can be found in the Xbase language reference (see Help->Help Contents).
			 * 
			 * (Tip: Hover or use F3 over an operator to go to its declaration)
			 */
			def «IF conf.noTypeInference»Amount «ENDIF»operatorOverloading(Amount a, Amount b) {
				return (a + b) * 2
			}
			
			/**
			 * Extension methods are a special Xtend feature.
			 * They allow for adding functions to existing types withot modifying them.
			 * Local functions within Xtend classes can be used using the extension syntax by default.
			 */
			def «IF conf.noTypeInference»List<String> «ENDIF»extensionMethods(String string) {
				string.splitOnUnderscore
			}
			
			def «IF conf.noTypeInference»List<String> «ENDIF»splitOnUnderscore(String s) {
				return s.split('_')
			}
			
			/**
			 * If you put the keyword 'extension' in a 'static' import, the imported static functions
			 * can be accessed using the extension syntax as well.
			 */
			def «IF conf.noTypeInference»List<String> «ENDIF» staticExtensionMethods(String string) {
				'foo'.singletonList
			}
			/**
			 * Xbase (and so soed Xtend) supports closures.
			 * A closure is very similar to Java's anonymous classes, but has 
			 * a much more convenient and readable syntax.
			 * 
			 */
			def «IF conf.noTypeInference»List<String> «ENDIF» closures_01(List<Person> persons) {
				persons.personsToString(«IF conf.noTypeInference»Person «ENDIF»p | p.name+", "+p.forename )
			}
			
			/**
			 * a function accepting a closure
			 * (Person)=>String is a synonym for org.eclipse.xtext.xbase.lib.Functions.Function1<Person,String>
			 * The general syntax if
			 * (typeParam1 ,... typeParamN) => returnType
			 */
			def «IF conf.noTypeInference»List<String> «ENDIF»personsToString(List<Person> persons, (Person)=>String toString) {
				val result = «IF conf.noTypeInference»<String> «ENDIF»newArrayList()
				for («IF conf.noTypeInference»Person «ENDIF»p : persons) 
					result += toString.apply(p)
				return result
			}
			
			/**
			 * Xtend can coerce function types into any other type, 
			 * as long as such a type has only one method defined 
			 * (in addition to the methods inherited from java.lang.Object)
			 * 
			 * In the following example java.util.Collections#sort(List<T>, Comparator<T>) is invoked.
			 * Where a closure is passed in as second parameter and automatically 
			 * converted to an instance of Comparator<Person>.
			 * 
			 * Note also that you have to put a closure into square brackets is it isn't the only argument to a function.
			 */
			def «IF conf.noTypeInference»void «ENDIF»closures_02(List<Person> persons) {
				// sort by name 
				Collections::sort(persons, [«IF conf.noTypeInference»Person «ENDIF» a,«IF conf.noTypeInference»Person «ENDIF» b | a.name.compareTo( b.name ) ] )
			}
			
			/**
			 * sometimes one need to explicitly specify the parameter types, 
			 * because there is no context to they can be inferred from. 
			 */
			def «IF conf.noTypeInference»(String)=>String «ENDIF» closures_withoutTypeInference() {
				return [String s | s.toUpperCase]
			}
			
			def void testCreateFunctions() {
				val «IF conf.noTypeInference»NetNode «ENDIF»nodeA = new NetNode()
				nodeA.name = "A"
				val «IF conf.noTypeInference»NetNode «ENDIF»nodeB = new NetNode()
				nodeB.name = "B"
				val «IF conf.noTypeInference»NetNode «ENDIF»nodeC = new NetNode()
				nodeC.name = "C"
				val «IF conf.noTypeInference»NetNode «ENDIF»nodeD = new NetNode()
				nodeD.name = "D"
				
				nodeA.references = «IF conf.noTypeInference»<NetNode>«ENDIF»newArrayList(nodeD,nodeC)
				nodeB.references = «IF conf.noTypeInference»<NetNode>«ENDIF»newArrayList(nodeA,nodeB)
				nodeC.references = «IF conf.noTypeInference»<NetNode>«ENDIF»newArrayList(nodeA,nodeB, nodeD)
				nodeD.references = «IF conf.noTypeInference»<NetNode>«ENDIF»newArrayList(nodeB,nodeC)
				
				val «IF conf.noTypeInference»NetNode «ENDIF»copyOfNodeA = copyNet(nodeA)
				val «IF conf.noTypeInference»NetNode «ENDIF»copyOfNodeB = copyNet(nodeB)
				Assert::assertNotSame(nodeA, copyOfNodeA)
				Assert::assertSame(copyOfNodeB.references.head, copyOfNodeA)		
				Assert::assertSame(copyOfNodeB.references.tail.head, copyOfNodeB)		
			}
			
			/**
			 * create a copy of the given NetNode
			 * initializes the fields lazily
			 */
			def create result : new NetNode() copyNet(NetNode toCopy) {
				result.name = toCopy.name
				result.references = toCopy.references.map( «IF conf.noTypeInference»NetNode «ENDIF»node | node.copyNet)
			}
			
			/**
			 * if expressions look exactly like Java's if statements.
			 */
			def «IF conf.noTypeInference»int «ENDIF»ifExpression(String param) {
				if (param!=null) {
					param.length
				} else {
					0
				} 
			}
			
			/**
			 * ... but note that they are expression so they are more like Java's
			 * ternary operator.
			 */
			def «IF conf.noTypeInference»int «ENDIF»ifExpression_01(String param) {
				ifExpression(if (param=='foo') 'bar' else 'baz') 
			}
			
			/**
			 * ... but the else branch is optional and if not specified defaults to 'else null'
			 */
			def «IF conf.noTypeInference»int «ENDIF»ifExpression_02(String param) {
				ifExpression_01(if (param=='bar') 'foo') 
			}
			
			/**
			 * The switch expression is very different to the one from Java
			 * It supports dispatching over types, it has no fall through, and it uses a first match wins strategy.
			 */
			def «IF conf.noTypeInference»String «ENDIF»switchExpression_01(Shape shape) {
				switch (shape) {
					Circle 	: 
						'a circle : diameter='+shape.diameter
					Rectangle case shape.height == shape.width : 
						'a square : size='+shape.width
					Rectangle : 
						'a rectangle : width='+shape.width+', height='+shape.height
				}
			}
			
			/**
			 * switch can also be used more traditionally (without any type guards)
			 */
			def «IF conf.noTypeInference»String «ENDIF»switchExpression_02(String value) {
				switch(value) {
					case 'foo' : "it's foo"
					case 'bar' : 'a bar'
					default : "don't know"
				}	
			}
			
			def void testRichStrings() {
				println(new Person("Joe", "Developer").writeLetterTo)
			}
			
			/**
			 * Rich strings are a special feature for readable code concatenation.
			 * It supports a unique automatic indentation handling, which is also refelected tooling-wise
			 * Note the indentation before the call to signature.
			 */
			@Deprecated
			def «IF conf.noTypeInference»CharSequence «ENDIF»writeLetterTo(Person p) «TQ()»
				Dear «GO()»p.forename«GC()»,
				
				bla bla foo
				
				Yours sincerely,
				
				Joe Developer
				
					«GO()»signature«GC()»
			«TQ()»
			
			def «IF conf.noTypeInference»CharSequence «ENDIF»signature() «TQ()»
				Bla bla Foo Bar
				(c) 2011 - all rights reserved
				 - note the multiline, and the correct indentation -
			«TQ()»
		}
	'''
		
	def TQ() {"'''"}
	def GO() {"«"}
	def GC() {"»"}
	
	
	def Map<String,? extends CharSequence> getDependencies(){
		newHashMap(amount, circle, netNode, person, rectangle, shape)
	}
	
	def getAmount() {
		"xtend/tutorial/util/Amount.xtend"->'''
			package xtend.tutorial.util;
			
			import java.math.BigDecimal;
			
			public class Amount {
				
				BigDecimal value
			
				new(BigDecimal value) {
					this.value = value
				}
				
				new(String value) {
					this.value = new BigDecimal(value)
				}
				
				override toString() {
					return value.setScale(2, BigDecimal::ROUND_HALF_UP).toString();
				}
				
				def public Amount operator_plus(Amount other) {
					return new Amount(this.value.add(other.value));
				}
				
				def public Amount operator_minus(Amount other) {
					return new Amount(this.value.subtract(other.value));
				}
				
				def public Amount operator_multiply(int factor) {
					return new Amount(this.value.multiply(new BigDecimal(factor)));
				}
				
				def public Amount operator_divide(int divisor) {
					return new Amount(this.value.divide(new BigDecimal(divisor)));
				}
				
			}
		'''
	}
	
	def getCircle() {
		"xtend/tutorial/util/Circle.xtend" -> '''
			package xtend.tutorial.util;
			
			public class Circle extends Shape {
				public int diameter;
			
				new(int diameter) {
					super();
					this.diameter = diameter;
				}
				
			}
		'''
	}
	
	def getNetNode() {
		"xtend/tutorial/util/NetNode.xtend" -> '''
			package xtend.tutorial.util;
			
			import static java.util.Collections.*;
			
			public class NetNode {
				private String name;
				private Iterable<NetNode> references = emptySet();
				
				def public String getName() {
					return name;
				}
				
				def public void setName(String name) {
					this.name = name;
				}
				
				def public Iterable<NetNode> getReferences() {
					return references;
				}
				
				def public void setReferences(Iterable<NetNode> references) {
					this.references = references;
				}
				
			}
		'''
	}
	
	def getPerson() {
		"xtend/tutorial/util/Person.xtend" -> '''
			package xtend.tutorial.util;
			
			import java.util.Set;
			
			public class Person {
				
				private String forename;
				private String name;
				private Set<Person> friends;
				
				new(String forename, String name) {
					super();
					this.forename = forename;
					this.name = name;
				}
				
				new() {
				}
				
				def public Set<Person> getFriends() {
					return friends;
				}
				
				def public void setFriends(Set<Person> friends) {
					this.friends = friends;
				}
			
				def public String getForename() {
					return forename;
				}
				
				def public void setForename(String forename) {
					this.forename = forename;
				}
				
				def public String getName() {
					return name;
				}
				
				def public void setName(String name) {
					this.name = name;
				}
				
			}
		'''
	}
	
	def getRectangle() {
		"xtend/tutorial/util/Rectangle.xtend" -> '''
			package xtend.tutorial.util;
			
			public class Rectangle extends Shape {
				
				public int height;
				public int width;
			
				new(int height, int width) {
					super();
					this.height = height;
					this.width = width;
				}
				
			}
		'''
	}
	def getShape() {
		"xtend/tutorial/util/Shape.xtend" -> '''
			package xtend.tutorial.util;
			
			public class Shape {
			}
		'''
	}
}