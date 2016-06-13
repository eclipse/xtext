package org.eclipse.xtext.idea.sdomain.idea.tests.structureview

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.junit.Ignore

/**
 * Fails in new Gradle build.
 * TODO Reactivate these tests
 */
@Ignore
class OutlineTest extends LightToolingTest {

	new() {
		super(SDomainFileType.INSTANCE)
	}

	def void testEmpty() {
		testStructureView('', '''
			aaa.sdomain
		''')
	}

	def void testNamespace() {
		testStructureView('''
			a.b.c {
			}
		''', '''
			aaa.sdomain
			 aaa
			  a.b.c
		''')
	}

	def void testEntity() {
		testStructureView('''
			Foo {
			}
			Bar {
			}
		''', '''
			aaa.sdomain
			 aaa
			  Foo
			  Bar
		''')
	}

	def void testDatatype() {
		testStructureView('''
			datatype Long
			datatype String
		''', '''
			aaa.sdomain
			 aaa
			  Long
			  String
		''')
	}

	def void testImport() {
		testStructureView('''
			foo {
				import java.lang.*
				entity Foo {
					String name
					Long age
				}
			}
			java.lang {
				datatype Long
				datatype String
			}
		''', '''
			aaa.sdomain
			 aaa
			  foo
			   java.lang.*
			   Foo
			    name
			    age
			  java.lang
			   Long
			   String
		''')
	}
	
}




