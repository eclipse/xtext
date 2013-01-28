package org.eclipse.xtend.core.tests.validation

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.junit.Test
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import com.google.inject.Inject

import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class ModifierValidationTest2 extends ModifierValidationTest {
	
	@Inject extension ValidationTestHelper
	 
	@Test override void testMethodInInterfaceAllowedModifiers() {
		memberInInterface('''private def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''package def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''protected def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
		memberInInterface('''public def foo() {}''').assertNoError(INVALID_MODIFIER)
		memberInInterface('''static def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)	
		memberInInterface('''abstract def int foo()''').assertNoErrors	
		// TODO: this one fails in the proxy resolution phase prior to validation:
		// Cannot locate dispatcher for operation Foo._foo(int)
		// at org.eclipse.xtend.core.typesystem.DispatchAndExtensionAwareReentrantTypeResolver._computeTypes(DispatchAndExtensionAwareReentrantTypeResolver.java:262)
		// memberInInterface('''dispatch def foo (int i){}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)		
		memberInInterface('''final def foo() {}''').assertError(XTEND_FUNCTION, INVALID_MODIFIER)
	}
}