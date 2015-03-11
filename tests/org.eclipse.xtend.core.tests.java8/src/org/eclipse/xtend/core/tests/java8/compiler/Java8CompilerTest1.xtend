/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.CompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class Java8CompilerTest1 extends CompilerTest {
	
	@Test def testJava8Reduce() {
		invokeAndExpect2(36, '''
			def test() {
				val intArray = #[1, 2, 3, 4, 5, 6, 7, 8]
			    intArray.stream.reduce[Integer.sum($0, $1)].get
			}
		''', 'test')
	}
	
	@Test def testJava8StreamExample1() {
		invokeAndExpect2(27.0, '''
			static class Person {
			    enum Sex {
			        MALE, FEMALE
			    }
			    String name
			    int age
			    Sex gender
			}
			
			def test() {
				val roster = #[
					new Person => [name='Carl'     age=19 gender=Person.Sex.MALE],
					new Person => [name='Carla'    age=37 gender=Person.Sex.FEMALE],
					new Person => [name='Rocco'    age=12 gender=Person.Sex.MALE],
					new Person => [name='Frederic' age=50 gender=Person.Sex.MALE]
				]
				roster.stream
				    .filter[gender == Person.Sex.MALE]
				    .mapToInt[age]
				    .average
				    .getAsDouble
			}
		''', 'test')
	}
	
	@Test def testJava8StreamExample2() {
		invokeAndExpect2(27.0, '''
			static class Person {
			    enum Sex {
			        MALE, FEMALE
			    }
			    String name
			    int age
			    Sex gender
			}
			
			static class Averager implements java.util.function.IntConsumer {
			    int total = 0
			    int count = 0
			    
			    def average() {
			        if (count > 0) (total as double)/count else 0
			    }
			    
			    override accept(int i) {
			    	total += i
			    	count++
			    }
			    
			    def combine(Averager other) {
			        total += other.total
			        count += other.count
			    }
			}
			
			def test() {
				val roster = #[
					new Person => [name='Carl'     age=19 gender=Person.Sex.MALE],
					new Person => [name='Carla'    age=37 gender=Person.Sex.FEMALE],
					new Person => [name='Rocco'    age=12 gender=Person.Sex.MALE],
					new Person => [name='Frederic' age=50 gender=Person.Sex.MALE]
				]
				val averageCollect = roster.stream
				    .filter[gender == Person.Sex.MALE]
				    .map[age]
				    .collect([new Averager], [av, i | av.accept(i)], [av1, av2 | av1.combine(av2)])
				averageCollect.average
			}
		''', 'test')
	}
	
	@Test def testJava8StreamExample3() {
		invokeAndExpect2(#['Carla', 'Brunhild'], '''
			static class Person {
			    enum Sex {
			        MALE, FEMALE
			    }
			    String name
			    int age
			    Sex gender
			}
			
			def test() {
				val roster = #[
					new Person => [name='Carl'     age=19 gender=Person.Sex.MALE],
					new Person => [name='Carla'    age=37 gender=Person.Sex.FEMALE],
					new Person => [name='Rocco'    age=12 gender=Person.Sex.MALE],
					new Person => [name='Frederic' age=50 gender=Person.Sex.MALE],
					new Person => [name='Brunhild' age=96 gender=Person.Sex.FEMALE]
				]
				val namesByGender = roster.stream
			        .collect(java.util.stream.Collectors.groupingBy(
			                [Person p | p.gender],
			                java.util.stream.Collectors.mapping(
			                    [Person p | p.name],
			                    java.util.stream.Collectors.toList)))
			    namesByGender.get(Person.Sex.FEMALE)
			}
		''', 'test')
	}
	
	@Test def testJava8StreamExample3b() {
		invokeAndExpect2(#['Carla', 'Brunhild'], '''
			static class Person {
			    enum Sex {
			        MALE, FEMALE
			    }
			    String name
			    int age
			    Sex gender
			}
			
			def test() {
				val roster = #[
					new Person => [name='Carl'     age=19 gender=Person.Sex.MALE],
					new Person => [name='Carla'    age=37 gender=Person.Sex.FEMALE],
					new Person => [name='Rocco'    age=12 gender=Person.Sex.MALE],
					new Person => [name='Frederic' age=50 gender=Person.Sex.MALE],
					new Person => [name='Brunhild' age=96 gender=Person.Sex.FEMALE]
				]
				val namesByGender = roster.stream
			        .collect(java.util.stream.Collectors.groupingBy(
			                [gender],
			                java.util.stream.Collectors.mapping(
			                    [name],
			                    java.util.stream.Collectors.toList)))
			    namesByGender.get(Person.Sex.FEMALE)
			}
		''', 'test')
	}
	
	@Test def testJava8StreamExample4() {
		invokeAndExpect2(133, '''
			static class Person {
			    enum Sex {
			        MALE, FEMALE
			    }
			    String name
			    int age
			    Sex gender
			}
			
			def test() {
				val roster = #[
					new Person => [name='Carl'     age=19 gender=Person.Sex.MALE],
					new Person => [name='Carla'    age=37 gender=Person.Sex.FEMALE],
					new Person => [name='Rocco'    age=12 gender=Person.Sex.MALE],
					new Person => [name='Frederic' age=50 gender=Person.Sex.MALE],
					new Person => [name='Brunhild' age=96 gender=Person.Sex.FEMALE]
				]
				val totalAgeByGender = roster.stream
				        .collect(java.util.stream.Collectors.groupingBy(
				                [Person p | p.gender],
				                java.util.stream.Collectors.reducing(
				                    0,
				                    [Person p | p.age],
				                    [$0, $1 | Integer.sum($0, $1)])))
				totalAgeByGender.get(Person.Sex.FEMALE)
			}
		''', 'test')
	}
	
	@Test def testJava8StreamExample4b() {
		invokeAndExpect2(133, '''
			static class Person {
			    enum Sex {
			        MALE, FEMALE
			    }
			    String name
			    int age
			    Sex gender
			}
			
			def test() {
				val roster = #[
					new Person => [name='Carl'     age=19 gender=Person.Sex.MALE],
					new Person => [name='Carla'    age=37 gender=Person.Sex.FEMALE],
					new Person => [name='Rocco'    age=12 gender=Person.Sex.MALE],
					new Person => [name='Frederic' age=50 gender=Person.Sex.MALE],
					new Person => [name='Brunhild' age=96 gender=Person.Sex.FEMALE]
				]
				val totalAgeByGender = roster.stream
				        .collect(java.util.stream.Collectors.groupingBy(
				                [gender],
				                java.util.stream.Collectors.reducing(
				                    0,
				                    [age],
				                    [$0 + $1])))
				totalAgeByGender.get(Person.Sex.FEMALE)
			}
		''', 'test')
	}
	
	@Test def testJava8CalculatorExample() {
		invokeAndExpect2(32, '''
			interface IntegerMath {
				def int operation(int a, int b)   
			}
			
			def operateBinary(int a, int b, IntegerMath op) {
				op.operation(a, b)
			}
			
			def test() {
				val IntegerMath addition = [$0 + $1]
				val IntegerMath subtraction = [$0 - $1]
				40.operateBinary(2, addition).operateBinary(10, subtraction)
			}
		''', 'test')
	}
	
}