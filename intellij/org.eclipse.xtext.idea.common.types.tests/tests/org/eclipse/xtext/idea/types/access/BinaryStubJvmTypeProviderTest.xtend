package org.eclipse.xtext.idea.types.access

import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.testFramework.PsiTestCase
import com.intellij.testFramework.PsiTestUtil
import org.eclipse.xtext.idea.tests.TestDecorator

@TestDecorator
class BinaryStubJvmTypeProviderTest extends PsiTestCase {

	val StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate

	override void setUp() throws Exception {
		super.setUp
		PsiTestUtil.addLibrary(module, "Guava", "/Users/kosyakov/.p2/pool/plugins", "com.google.guava_15.0.0.v201403281430.jar")
		PsiTestUtil.addLibrary(module, "TestData", "/Users/kosyakov/oomph/xtext/master/git/xtext/tests/org.eclipse.xtext.common.types.tests/testdata/org/eclipse/xtext/common/types/testSetups", "testData.jar")
		delegate.setUp(project)
	}
	
	override protected getTestProjectJdk() {
		JavaAwareProjectJdkTableImpl.instanceEx.internalJdk
	}

	override void tearDown() throws Exception {
		delegate.tearDown
		super.tearDown
	}

}
