package org.eclipse.xtext.idea.types.access

import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.testFramework.PsiTestCase
import org.eclipse.xtext.common.types.testSetups.AbstractMethods
import org.eclipse.xtext.idea.tests.TestDecorator
import org.junit.Ignore

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

@TestDecorator
class BinaryStubJvmTypeProviderTest extends PsiTestCase {

	val StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate(){}

	override void setUp() throws Exception {
		super.setUp
		module.addGuavaLibrary
		module.addLibrary("org.eclipse.xtext.common.types.tests.testData", AbstractMethods)
		delegate.setUp(project)
	}
	
	override protected getTestProjectJdk() {
		JavaAwareProjectJdkTableImpl.instanceEx.internalJdk
	}

	override void tearDown() throws Exception {
		delegate.tearDown
		super.tearDown
	}
	
	@Ignore def void testCharAnnotationValue_01() {}

	@Ignore def void testCharAnnotationValue_02() {}

	@Ignore def void testCharAnnotationValue_03() {}

	@Ignore def void testDefaultCharArrayAnnotationValue_01() {}

	@Ignore def void testConstantValue_07() {}

	@Ignore def void testConstantValue_08() {}

	@Ignore def void testParameterNames_01() {}

	@Ignore def void testParameterNames_02() {}

	@Ignore def void test_ParameterizedTypes_inner_return_02() {}

}
