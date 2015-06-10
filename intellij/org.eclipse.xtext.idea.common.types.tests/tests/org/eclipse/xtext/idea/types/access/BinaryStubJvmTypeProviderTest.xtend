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
import org.eclipse.xtext.common.types.JvmCharAnnotationValue
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmInnerTypeReference
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.testSetups.AbstractMethods
import org.eclipse.xtext.common.types.testSetups.Bug347739ThreeTypeParamsSuperSuper
import org.eclipse.xtext.common.types.testSetups.ParameterizedTypes
import org.eclipse.xtext.common.types.testSetups.ParameterizedTypes2
import org.eclipse.xtext.idea.tests.TestDecorator

import static junit.framework.TestCase.*

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

@TestDecorator
class BinaryStubJvmTypeProviderTest extends PsiTestCase {

	val StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate(){
		
		override testCharAnnotationValue_01() throws Exception {
			val JvmCharAnnotationValue value = getAnnotationValue("charValue") as JvmCharAnnotationValue
			// https://youtrack.jetbrains.com/issue/IDEA-141133
			assertEquals(0, value.getValues().size())
		}
		
		override testCharAnnotationValue_02() throws Exception {
			val JvmCharAnnotationValue value = getMethodParameterAnnotationValue("charValue") as JvmCharAnnotationValue
			// https://youtrack.jetbrains.com/issue/IDEA-141133
			assertEquals(0, value.getValues().size())
		}
		
		override testCharAnnotationValue_03() throws Exception {
			val JvmCharAnnotationValue value = getConstructorParameterAnnotationValue("charValue") as JvmCharAnnotationValue
			// https://youtrack.jetbrains.com/issue/IDEA-141133
			assertEquals(0, value.getValues().size())
		}
		
		override testDefaultCharArrayAnnotationValue_01() throws Exception {
			val JvmCharAnnotationValue value = getDefaultAnnotationValue("charArrayValue") as JvmCharAnnotationValue
			// https://youtrack.jetbrains.com/issue/IDEA-141133
			assertEquals(0, value.getValues().size())
		}
		
		override testParameterNames_01() {
			// IDEA defaults the param names to the first char of the type name
			doTestParameterName(Bug347739ThreeTypeParamsSuperSuper, "getToken(A)", "a");
		}
		
		override testParameterNames_02() {
			// IDEA defaults the param names to the first char of the type name
			doTestParameterName(AbstractMethods, "abstractMethodWithParameter(java.lang.String)", "s");
		}
		
		override test_ParameterizedTypes2_inner_return_02() {
			var String typeName=ParameterizedTypes2.getName() 
			var JvmGenericType type=getTypeProvider().findTypeByName(typeName) as JvmGenericType 
			var JvmOperation operation=getMethodFromType(type, ParameterizedTypes2, "concreteInner()") 
			var JvmTypeReference returnType=operation.getReturnType()
			// https://youtrack.jetbrains.com/issue/IDEA-141230
			assertTrue(returnType.getIdentifier(), returnType instanceof JvmInnerTypeReference) assertEquals("ParameterizedTypes2<P>$Inner<String>", returnType.getSimpleName()) 
		}
		
		override test_ParameterizedTypes_inner_return_02() {
			var String typeName=ParameterizedTypes.getName() 
			var JvmGenericType type=getTypeProvider().findTypeByName(typeName) as JvmGenericType 
			var JvmOperation operation=getMethodFromType(type, ParameterizedTypes, "concreteInner()") 
			var JvmTypeReference returnType=operation.getReturnType() 
			// https://youtrack.jetbrains.com/issue/IDEA-141230
			assertTrue(returnType.getIdentifier(), returnType instanceof JvmInnerTypeReference) assertEquals("ParameterizedTypes<S, T, U, V, W>$Inner<String, List<String>, List<String>>", returnType.getSimpleName()) 
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
