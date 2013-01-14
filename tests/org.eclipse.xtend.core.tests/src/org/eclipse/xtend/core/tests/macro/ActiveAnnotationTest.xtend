package org.eclipse.xtend.core.tests.macro

import java.util.List
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.ModifyContext
import org.eclipse.xtend.lib.macro.ModifyProcessor
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.junit.Test
import org.junit.Ignore

class ActiveAnnotationTest extends AbstractXtendTestCase {
	
	@Ignore
	@Test def void testSimpleModification() {
		val file = file('''
			@org.eclipse.xtend.core.tests.macro.Abstract
			class MyClass {
				
			}
		''', true)
		assertTrue((file.eResource.contents.get(1) as JvmDeclaredType).isAbstract)
	}
}

@Active(typeof(AbstractProcessor))
annotation Abstract { }
class AbstractProcessor implements ModifyProcessor<MutableClassDeclaration> {
	
	extension ModifyContext ctx
	
	override modify(List<? extends MutableClassDeclaration> annotatedSourceClasses, ModifyContext context) {
		ctx = context
		annotatedSourceClasses.forEach [
			^abstract = true
		]
	}
	
}
