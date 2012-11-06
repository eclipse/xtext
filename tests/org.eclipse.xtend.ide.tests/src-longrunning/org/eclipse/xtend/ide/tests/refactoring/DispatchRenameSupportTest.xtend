package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.refactoring.DispatchRenameSupport
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFunction
import org.junit.Test
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtend.core.xtend.XtendFile

import static extension com.google.common.collect.Iterables.*
import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

class DispatchRenameSupportTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper testHelper;
	
	@Inject DispatchRenameSupport dispatchRenameSupport;
	
	override tearDown() throws Exception {
		testHelper.tearDown
		super.tearDown()
	}
	
	@Test
	def testSimple() {
		val fooFile = xtendFile("Foo", '''
			class Foo {
				def dispatch foo(String x) {}
				def dispatch foo(Integer x) {}
			}
		''')
		checkDispatchOperations(fooFile.firstMethod, 
			'Foo._foo(String)', 'Foo._foo(Integer)', 'Foo.foo(Object)')
	}
	
	@Test
	def testSubClass() {
		createFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		val subFile = xtendFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(String x) {}
				def dispatch foo(Integer x) {}
			}
		''')
		checkDispatchOperations(subFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(String)', 'Sub._foo(Integer)', 'Sub.foo(Object)')
	}
	
	@Test
	def testSuperClass() {
		val superFile = xtendFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		createFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(String x) {}
				def dispatch foo(Integer x) {}
			}
		''')
		checkDispatchOperations(superFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(String)', 'Sub._foo(Integer)', 'Sub.foo(Object)')
	}
	
	@Test
	def testSubClassOverride() {
		createFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		val subFile = xtendFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(String x) {}
				override dispatch foo(Double x) {}
			}
		''')
		checkDispatchOperations(subFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(String)', 'Sub._foo(Double)', 'Sub.foo(Object)')
	}
	
	@Test
	def testSuperClassOverride() {
		val superFile = xtendFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		createFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(String x) {}
				override dispatch foo(Double x) {}
			}
		''')
		checkDispatchOperations(superFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(String)', 'Sub._foo(Double)', 'Sub.foo(Object)')
	}
	
	@Test
	def testSubSubClass_0() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		createFile('Sub', '''
			class Sub extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		val subSubFile = xtendFile("SubSub", '''
			class SubSub extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subSubFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(Integer)', 'Sub.foo(Object)',
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testSubSubClass_1() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		val subFile = xtendFile('Sub', '''
			class Sub extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("SubSub", '''
			class SubSub extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(Integer)', 'Sub.foo(Object)',
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testSubSubClass_2() {
		val superFile = xtendFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		createFile('Sub', '''
			class Sub extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("SubSub", '''
			class SubSub extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(superFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(Integer)', 'Sub.foo(Object)',
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testConnectedSubclasses_0() {
		val superFile = xtendFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		createFile('Sub0', '''
			class Sub0 extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(superFile.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub0._foo(Integer)', 'Sub0.foo(Object)',
			'Sub1._foo(String)', 'Sub1.foo(Object)')
	}

	@Test
	def testConnectedSubclasses_1() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		val sub0File = xtendFile('Sub0', '''
			class Sub0 extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(sub0File.firstMethod, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub0._foo(Integer)', 'Sub0.foo(Object)',
			'Sub1._foo(String)', 'Sub1.foo(Object)')
	}

	@Test
	def testUnconnectedSubclasses_0() {
		createFile('Super.xtend', '''
			class Super {
			}
		''')
		val sub0File = xtendFile('Sub0', '''
			class Sub0 extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(sub0File.firstMethod, 
			'Sub0._foo(Integer)', 'Sub0.foo(Integer)')
	}

	@Test
	def testUnconnectedSubclasses_1() {
		createFile('Super.xtend', '''
			class Super {
			}
		''')
		createFile('Sub0', '''
			class Sub0 extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		val sub1File = xtendFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(sub1File.firstMethod, 
			'Sub1._foo(String)', 'Sub1.foo(String)')
	}


	def firstMethod(XtendFile file) {
		val xtendClass = file.xtendTypes.get(0) as XtendClass
		xtendClass.members.get(0) as XtendFunction
	}
	
	def checkDispatchOperations(XtendFunction targetMethod, String... signatures) {
		waitForAutoBuild
		val dispatchOperations = dispatchRenameSupport.getAllDispatchOperations(targetMethod).map[signature]
		assertEquals(signatures.size, dispatchOperations.size)
		for(signature: signatures) {
			assertTrue(signature + " not found. Only got" + dispatchOperations.join('\n'), dispatchOperations.contains(signature))
		}
	}
	
	def signature(JvmOperation it) {
		'''«qualifiedName»(«FOR p:parameters SEPARATOR ','»«p.parameterType.type.simpleName»«ENDFOR»)'''.toString
	}
}