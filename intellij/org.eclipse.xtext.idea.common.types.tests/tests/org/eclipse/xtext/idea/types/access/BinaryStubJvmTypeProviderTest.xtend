/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.types.access

import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.testFramework.PsiTestCase
import org.eclipse.xtext.common.types.testSetups.AbstractMethods
import org.eclipse.xtext.common.types.testSetups.Bug347739ThreeTypeParamsSuperSuper
import org.eclipse.xtext.idea.tests.TestDecorator

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

@TestDecorator
class BinaryStubJvmTypeProviderTest extends PsiTestCase {

	val StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate(){
		
		override testParameterNames_01() {
			// IDEA defaults the param names to the first char of the type name
			doTestParameterName(Bug347739ThreeTypeParamsSuperSuper, "getToken(A)", "a");
		}
		
		override testParameterNames_02() {
			// IDEA defaults the param names to the first char of the type name
			doTestParameterName(AbstractMethods, "abstractMethodWithParameter(java.lang.String)", "s");
		}
		
	}

	override void setUp() throws Exception {
		super.setUp
		module.addGuavaLibrary
		module.addLibrary("org.eclipse.xtext.common.types.tests.testData", AbstractMethods)
		delegate.setUp(myModule)
	}
	
	override protected getTestProjectJdk() {
		JavaAwareProjectJdkTableImpl.instanceEx.internalJdk
	}

	override void tearDown() throws Exception {
		delegate.tearDown
		super.tearDown
	}

}
