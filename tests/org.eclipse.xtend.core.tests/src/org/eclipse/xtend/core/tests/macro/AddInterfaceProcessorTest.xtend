package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.junit.Test

class AddInterfaceProcessorTest extends AbstractActiveAnnotationTest {
	
	@Test def void testAddInterface() {
		'''
			@org.eclipse.xtend.core.tests.macro.AddInterface class Foo {}
		'''.assertCompilesTo('''
			MULTIPLE FILES WERE GENERATED
			
			File 1 : Foo.java
			
			import org.eclipse.xtend.core.tests.macro.AddInterface;
			
			@AddInterface
			@SuppressWarnings("all")
			public class Foo {
			}
			
			File 2 : de/test/Test.java
			
			package de.test;
			
			@SuppressWarnings("all")
			public interface Test {
			}
			
		''')
	}
}

@Active(typeof(AddInterfaceProcessor))
annotation AddInterface {}
class AddInterfaceProcessor extends AbstractClassProcessor {
	
	override doRegisterGlobals(ClassDeclaration annotatedClass, RegisterGlobalsContext context) {
		context.registerInterface('de.test.Test')
	}
	
}