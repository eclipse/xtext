package org.eclipse.xtend.ide.tests.refactoring

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.ide.refactoring.DispatchRenameSupport
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.JvmOperation
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

import static extension com.google.common.collect.Iterables.*

class DispatchRenameSupportTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper testHelper;
	
	@Inject DispatchRenameSupport dispatchRenameSupport;
	
	override tearDown() throws Exception {
		testHelper.tearDown
		super.tearDown()
	}
	
	@Test
	def testSimple() {
		val fooFile = createFile("Foo", '''
			class Foo {
				def dispatch foo(String x) {}
				def dispatch foo(Integer x) {}
			}
		''')
		checkDispatchOperations(fooFile, 
			'Foo._foo(String)', 'Foo._foo(Integer)', 'Foo.foo(Object)')
	}
	
	@Test
	def testSubClass() {
		createFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		val subFile = createFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(String x) {}
				def dispatch foo(Integer x) {}
			}
		''')
		checkDispatchOperations(subFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub._foo(String)', 'Sub._foo(Integer)', 'Sub.foo(Object)')
	}
	
	@Test
	def testSuperClass() {
		val superFile = createFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		createFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(String x) {}
				def dispatch foo(Integer x) {}
			}
		''')
		checkDispatchOperations(superFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub._foo(String)', 'Sub._foo(Integer)', 'Sub.foo(Object)')
	}
	
	@Test
	def testDisconnectedJavaSubClass() {
		val superFile = createFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		createFile("Sub", '''
			public class Sub extends Super {
				public void _foo(Integer x) {}
			}
		''')
		checkDispatchOperations(superFile, 
			'Super._foo(Double)', 'Super.foo(Double)')
	}
	
	@Test
	def testJavaSuperClass() {
		createFile('Super.java', '''
			public class Super {
				public void _foo(Double x) {}
			}
		''')
		val subFile = createFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		checkDispatchOperations(subFile, 
			'Super._foo(Double)',
			'Sub._foo(Integer)',
			'Sub.foo(Number)')
	}
	
	@Test
	def testSubClassOverride() {
		createFile('Super', '''
			class Super {
				def dispatch foo(Double x) {}
			}
		''')
		val subFile = createFile("Sub", '''
			class Sub extends Super {
				def dispatch foo(String x) {}
				override dispatch foo(Double x) {}
			}
		''')
		checkDispatchOperations(subFile, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(String)', 'Sub._foo(Double)', 'Sub.foo(Object)')
	}
	
	@Test
	def testSuperClassOverride() {
		val superFile = createFile('Super', '''
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
		checkDispatchOperations(superFile, 
			'Super.foo(Double)', 'Super._foo(Double)',
			'Sub._foo(String)', 'Sub._foo(Double)', 'Sub.foo(Object)')
	}
	
	@Test
	def testSubSubClass_0() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		createFile('Sub', '''
			class Sub extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		val subSubFile = createFile("SubSub", '''
			class SubSub extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subSubFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub._foo(Integer)', 'Sub.foo(Object)',
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testSubSubClass_1() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		val subFile = createFile('Sub', '''
			class Sub extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("SubSub", '''
			class SubSub extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub._foo(Integer)', 'Sub.foo(Object)',
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testSubSubClass_2() {
		val superFile = createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
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
		checkDispatchOperations(superFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub._foo(Integer)', 'Sub.foo(Object)',
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testJavaInTheMiddle_0() {
		val superFile = createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		createFile('Sub.java', '''
			public class Sub extends Super {
				public void _foo(Integer x) {}
			}
		''')
		createFile("SubSub", '''
			class SubSub extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(superFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub._foo(Integer)', 
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testJavaInTheMiddle_1() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		createFile('Sub.java', '''
			public class Sub extends Super {
				public void _foo(Integer x) {}
			}
		''')
		val subsubFile = createFile("SubSub", '''
			class SubSub extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subsubFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub._foo(Integer)', 
			'SubSub._foo(String)', 'SubSub.foo(Object)')
	}
	
	@Test
	def testConnectedSubclasses_0() {
		val superFile = createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
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
		checkDispatchOperations(superFile, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub0._foo(Integer)', 'Sub0.foo(Object)',
			'Sub1._foo(String)', 'Sub1.foo(Object)')
	}

	@Test
	def testConnectedSubclasses_1() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		val sub0File = createFile('Sub0', '''
			class Sub0 extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(sub0File, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'Sub0._foo(Integer)', 'Sub0.foo(Object)',
			'Sub1._foo(String)', 'Sub1.foo(Object)')
	}

	@Test
	def testJavaConnectedSubclasses() {
		createFile('Super.java', '''
			class Super {
				public void _foo(Double x) {}
			}
		''')
		val sub0File = createFile('Sub0', '''
			class Sub0 extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(sub0File, 
			'Super._foo(Double)',
			'Sub0._foo(Integer)', 'Sub0.foo(Number)',
			'Sub1._foo(String)', 'Sub1.foo(Object)')
	}

	@Test
	def testUnconnectedSubclasses_0() {
		createFile('Super.xtend', '''
			class Super {
			}
		''')
		val sub0File = createFile('Sub0', '''
			class Sub0 extends Super {
				def dispatch foo(Integer x) {}
			}
		''')
		createFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(sub0File, 
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
		val sub1File = createFile("Sub1", '''
			class Sub1 extends Super {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(sub1File, 
			'Sub1._foo(String)', 'Sub1.foo(String)')
	}

	@Test
	def testTreeConnected() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		createFile('Sub', '''
			class Sub extends Super {
			}
		''')
		createFile("SubSub0", '''
			class SubSub0 extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		val subsub1File = createFile("SubSub1", '''
			class SubSub1 extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subsub1File, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'SubSub1._foo(String)', 'SubSub1.foo(Object)',
			'SubSub0._foo(String)', 'SubSub0.foo(Object)')
	}
	
	@Test
	def testTreeConnected_1() {
		createFile('Super.xtend', '''
			class Super {
				def dispatch foo(Double x) {}
				def dispatch foo(Object x) {}
			}
		''')
		createFile('Sub.java', '''
			public class Sub extends Super {
			}
		''')
		createFile("SubSub0", '''
			class SubSub0 extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		val subsub1File = createFile("SubSub1", '''
			class SubSub1 extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subsub1File, 
			'Super.foo(Object)', 'Super._foo(Double)', 'Super._foo(Object)',
			'SubSub1._foo(String)', 'SubSub1.foo(Object)',
			'SubSub0._foo(String)', 'SubSub0.foo(Object)')
	}
	
	@Test
	def testTreeConnected_2() {
		createFile('Super.java', '''
			public class Super {
				public void _foo(Double x) {}
			}
		''')
		createFile('Sub', '''
			class Sub extends Super {
			}
		''')
		createFile("SubSub0", '''
			class SubSub0 extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		val subsub1File = createFile("SubSub1", '''
			class SubSub1 extends Sub {
				def dispatch foo(String x) {}
			}
		''')
		checkDispatchOperations(subsub1File, 
			'Super._foo(Double)',
			'SubSub1._foo(String)', 'SubSub1.foo(Object)',
			'SubSub0._foo(String)', 'SubSub0.foo(Object)')
	}
	
	def firstMethod(IFile targetFile) {
		val resource = resourceSet.getResource(targetFile.uri, true)
		val createFile = resource.contents.get(0)
		assertTrue(createFile instanceof XtendFile)
		val xtendClass = (createFile as XtendFile).xtendTypes.get(0) as XtendClass
		xtendClass.members.filter(typeof(XtendFunction)).get(0)
	}
	
	def checkDispatchOperations(IFile targetFile, String... signatures) {
		waitForAutoBuild
		val dispatchOperations = dispatchRenameSupport.getAllDispatchOperations(targetFile.firstMethod).map[signature]
		for(signature: signatures) {
			assertTrue(signature + " not found. Only got " + dispatchOperations.join('\n'), dispatchOperations.contains(signature))
		}
		assertEquals("Expected " + signatures.join('\n') + 'but got '+dispatchOperations.join('\n'), 
			signatures.size, dispatchOperations.size
		)
	}
	
	def signature(JvmOperation it) {
		'''«qualifiedName»(«FOR p:parameters SEPARATOR ','»«p.parameterType.type.simpleName»«ENDFOR»)'''.toString
	}
}