package org.eclipse.xtext.idea.types.access

import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.testFramework.PsiTestCase
import org.eclipse.xtext.common.types.testSetups.AbstractMethods
import org.eclipse.xtext.idea.tests.TestDecorator

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

@TestDecorator
class BinaryStubJvmTypeProviderTest extends PsiTestCase {

	val StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate

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

}
