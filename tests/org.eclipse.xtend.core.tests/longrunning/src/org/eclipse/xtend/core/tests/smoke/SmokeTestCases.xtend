/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.junit.Test
import org.eclipse.xtext.junit4.smoketest.IgnoredBySmokeTest

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SmokeTestCases extends AbstractXtendTestCase {
	
	@Test def void test_00() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			@Data
			class Case_0 {
				int id
			
				def String foo(String a, String b) {
					var list = newArrayList()
					for(i: 0..list.size - 1) {
						println(i.toString + " " + list.get(i))
					}
					if (isUpper(a)) {
						another(a,b+'holla')
					} else {
						var x = a;
						for (y : b.toCharArray) {
							x = x+y
						}
						x
					}
				}
				
				def isUpper(String s) {
					s.toUpperCase == s
				}
					
				def another(String x, String y) { 
					y+x
				}
				
			
			}
		''')
	}
	
	@Test def void test_00_b() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			import org.eclipse.xtend.lib.annotations.Data
			
			@Data
			class Case_0 {
				int id
			
				def String foo(String a, String b) {
					var list = newArrayList()
					for(i: 0..list.size - 1) {
						println(i.toString + " " + list.get(i))
					}
					if (isUpper(a)) {
						another(a,b+'holla')
					} else {
						var x = a;
						for (y : b.toCharArray) {
							x = x+y
						}
						x
					}
				}
				
				def isUpper(String s) {
					s.toUpperCase == s
				}
					
				def another(String x, String y) { 
					y+x
				}
				
			
			}
		''')
	}
	
	@Test def void test_01() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			import org.eclipse.xtend.lib.Property
			
			class Case_1 {
				@Property
				int id
			
				def testFunction1() {
					42
				}
				
				def testFunction2() {
					42
				} 
					
				def Integer testFunction3() {
					42
				} 
					
			}
		''')
	}
	
	@Test def void test_02() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_2 {
			
				def aOrB(String a, String b) {
					if (a.isNullOrEmpty()) 
						b
					else
						a 
				}
				
				def returnInIf() {
					if ('x'!='x') return 'xx' else return 'yy'
				}
			
			}
		''')
	}
	
	@Test def void test_03() {
		file('''
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
		''')
	}
	
	@IgnoredBySmokeTest("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
	@Test def void test_04() {
		file("
			package org.eclipse.xtend.core.tests.smoke
			
			class Case_4 {
				def richStrings_01() {
					'''foobar'''
				}
				def richStrings_02()
					'''«'start'»
					  first line
					  second line
				    		'''
				def richStrings_03() {
					'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''
				}
				def richStrings_04() {
					'''  «FOR a:'1'.toCharArray»«FOR a2:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''
				}
				def richStrings_05() {
					'''
						«FOR a:'1'.toCharArray»
						  «FOR a2:'12'.toCharArray»foobar«ENDFOR»
						«ENDFOR»
					'''
				}
			}
		")
	}
	
	@Test def void test_05() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			import com.google.inject.Inject
			import java.util.ArrayList
			
			import static java.util.Arrays.*
			
			import static extension java.util.Collections.*
			
			class Case_5 {
			
				@Inject
				ArrayList myList
			//	ArrayList as list
				
				@Inject extension
				String s
			
				def boolean something(int i) {
				  if (i.indexOf() == 0) {
			//	    return list.contains(i)
				    return myList.contains(i)
				  } 
				  asList(i)
				  i.singletonList()
				  false
				}
				
			
			}
		''')
	}
	
	@Test def void test_06() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			import org.eclipse.emf.ecore.EClass
			import org.eclipse.emf.ecore.EObject
			import org.eclipse.emf.ecore.EPackage
			import org.eclipse.emf.ecore.EStructuralFeature
			
			class Case_6 {
				
				def dispatch transform(EPackage packageDecl) {
					packageDecl.eContents.map(e | transform(e as EStructuralFeature))
				}
				
				def dispatch transform(EStructuralFeature entity) {
					val inferredType = null
					newArrayList(inferredType as EObject) 	 
				}
				
				def dispatch transform(EClass model) {
					model.ETypeParameters.map(e| transform(e))
				}
			
			}
		''')
	}
	
	@Test def void test_07() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			import java.util.Map
			import java.util.List
			
			class Case_7 {
			
				def bug345449() {
					val result = <Map$Entry<String, List<String>>>newArrayList()
					result?.head
				}
			
				def Object bug345452() {
					var CharSequence x = null
					if(x instanceof Map$Entry)
						null
				}
			}
		''')
	}
	
	@Test def void test_08() {
		file('''
			package org.eclipse.xtend.core.tests.smoke

			import com.google.inject.Inject
			import java.util.List
			import org.eclipse.emf.ecore.EObject
			import org.eclipse.emf.ecore.util.EcoreUtil
			import org.eclipse.xtext.junit4.util.ParseHelper
			import org.eclipse.xtext.naming.IQualifiedNameProvider
			
			import static org.junit.Assert.*
			
			@SuppressWarnings("all")
			class Case_8 {
			
			    @Inject
			    extension ParseHelper<EObject> helper
			
			    @Inject
			    extension IQualifiedNameProvider qualifiedNameProvider
			
			    def getErrors(EObject obj) {
			        obj.eResource.errors
			    }
			
			    def resolve(EObject obj) {
			        EcoreUtil::resolveAll(obj.eResource)
			    }
			
			    def parseAcme(CharSequence seq) {
			        seq.parse.eContents.head
			    }
			
			    @Inject
			    def explicitName() {
			        val element = '«»''
			            com.acme.SimpleElement as FooBar {}
			        ''«»'.parseAcme
			        assertEquals("FooBar", element.fullyQualifiedName.toString)
			    }
			
				def <T1  extends  Object> List<List<T1>> foo(T1 t) {
			        return null
			    }
			}
		''')
	}
	
	@Test def void test_09() {
		file('''
			/*
			 * generated by Xtext
			 */
			package org.eclipse.xtend.core.tests.smoke
			
			import org.eclipse.emf.ecore.ENamedElement
			import org.eclipse.emf.ecore.EObject
			import java.util.List
			
			class Case_9 extends Case_8 {
				
				def dispatch CharSequence generateTypeRef(ENamedElement c) {
					  if (c.eContainer != null)
					    c.eContainer.generateTypeRef
					  else if (c.eIsProxy)
					    ''«»'«'«'»c.name»'«»''
					  else
					    ''«»''«»''
					}
			
				def dispatch CharSequence generateTypeRef(EObject o) {
				  	o.eContainer.generateTypeRef
				}  
				
				override <T1> /*List<List<T1>>*/ foo(T1 t) {
			        val List<List<T1>> x = super.foo(t)
			        return null
			    }
					
			}
		''')
	}
	
	@Test def void test_14() {
		file('''
			package org.eclipse.xtend.core.tests.smoke
			
			import com.google.inject.Inject
			import org.eclipse.emf.common.util.URI
			import org.eclipse.emf.ecore.EcoreFactory
			import org.eclipse.xtend.core.tests.AbstractXtendTestCase
			import org.eclipse.xtext.common.types.JvmConstructor
			import org.eclipse.xtext.common.types.JvmDeclaredType
			import org.eclipse.xtext.common.types.JvmGenericType
			import org.eclipse.xtext.resource.DerivedStateAwareResource
			import org.eclipse.xtext.resource.XtextResourceSet
			import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
			import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
			import org.junit.Test
			import org.junit.Ignore
			
			@Ignore
			class Case_14 extends AbstractXtendTestCase {
			
			       @Inject extension JvmTypesBuilder
			       @Inject JvmModelAssociator assoc
			       @Inject XtextResourceSet resourceSet
			       @Inject DerivedStateAwareResource resource
			
			       @Test
			       def void testInference() {
			               assoc.inferrer = [obj, acceptor, preIndexing|
			                       val firstType = obj.toClass('foo.Bar')
			                       val secondType = obj.toClass('foo.Baz')
			                       assertNull(secondType.eResource)
			                       acceptor.accept(firstType).initializeLater[
			                               ^abstract = true
			                               assertNotNull(firstType.eResource)
			                               assertNotNull(secondType.eResource)
			                       ]
			                       acceptor.accept(secondType).initializeLater[
			                               ^abstract = true
			                               assertNotNull(firstType.eResource)
			                       ]
			               ]
			               resource.setDerivedStateComputer(null)
			               resource.URI = URI::createURI('foo.txt')
			               resourceSet.classpathURIContext = getClass()
			               resourceSet.resources += resource
			               resource.contents += EcoreFactory::eINSTANCE.createEClass
			               assoc.installDerivedState(resource,true)
			               assertFalse((resource.contents.get(1) as JvmDeclaredType).^abstract)
			
			               resource.contents.clear
			               resource.contents += EcoreFactory::eINSTANCE.createEClass
			               assoc.installDerivedState(resource,false)
			               val type = (resource.contents.get(1) as JvmGenericType)
			               assertTrue(type.^abstract)
			
			               // test extends object and default constructor
			               assertEquals(1, type.members.filter(typeof(JvmConstructor)).size)
			               assertEquals("java.lang.Object", type.superTypes.head?.qualifiedName)
			       }
			
			
			}
		''')
	}
	
}