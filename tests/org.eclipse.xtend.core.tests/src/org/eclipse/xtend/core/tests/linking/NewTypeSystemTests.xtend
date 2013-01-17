/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking

import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Ignore

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class AssignmentLinkingTest2 extends AssignmentLinkingTest {
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class InferredJvmModelShadowingJavaLinkingTests2 extends InferredJvmModelShadowingJavaLinkingTests {
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class InferredJvmModelTest2 extends InferredJvmModelTest {
    
    @Ignore("TODO: implement solution for recursive functions, e.g. doStuff in this test case")
    @Test override testDispatchFunction_03() throws Exception {
        super.testDispatchFunction_03()
    }
    
    @Test override testDispatchFunction_04() throws Exception {
        val xtendFile = file("class Foo { def dispatch foo(Integer x) {x} def dispatch foo(Double x) {x}}")
        val inferredType = getInferredType(xtendFile)
        
        // one main dispatch
        val operations = inferredType.getDeclaredOperations()
        val dispatcher = findByNameAndFirstParameterType(operations, "foo", typeof(Object))
        // return type is specialized
        assertEquals("java.lang.Object", dispatcher.getReturnType().getIdentifier())
        
        // two internal case methods
        var internal = findByNameAndFirstParameterType(operations, "_foo", typeof(Double))
        assertEquals(dispatcher.getReturnType().getIdentifier(), internal.getReturnType().getIdentifier());
        
        internal = findByNameAndFirstParameterType(operations, "_foo", typeof(Integer))
        assertEquals(dispatcher.getReturnType().getIdentifier(), internal.getReturnType().getIdentifier());
    }
    
    @Test override testInferredFunctionWithReturnType_04() throws Exception {
        val xtendFile = file("class Foo { def bar() { if (true) null as Double else null as Integer } }")
        val inferredType = getInferredType(xtendFile)
        val jvmOperation = inferredType.getMembers().get(1) as JvmOperation
        assertEquals("java.lang.Object", jvmOperation.getReturnType().getIdentifier());
    }
    
    @Test override testInferredFunctionWithReturnType_05() throws Exception {
        val xtendFile = file("class Foo { def bar() { newArrayList(if (true) null as Double else null as Integer) } }");
        val inferredType = getInferredType(xtendFile);
        val jvmOperation = inferredType.getMembers().get(1) as JvmOperation
        assertEquals("java.util.ArrayList<java.lang.Object>", jvmOperation.getReturnType().getIdentifier());
    }
    
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class LinkingShadowingTest2 extends LinkingShadowingTest {
    
    override protected assertLinksTo(String identifier, EClass type, XAbstractFeatureCall featureCall, boolean withIssues) {
        assertNotNull("feature is available", featureCall.getFeature());
        val linked = featureCall.getFeature();
        assertFalse("is resolved", linked.eIsProxy());
        assertEquals(identifier, linked.getIdentifier());
        assertTrue(type.isInstance(linked));
    }
    
    @Test 
    override testOperation_implicitArgumentOnStatic() throws Exception {
        val clazz = clazz(
                "import static testdata.LinkingStaticTypeEquallyNamed.*
                class SomeClass {
                  def void method(Object it) { 
                    withArgument 
                  }
                }");
        val featureCall = getFirstFeatureCall(clazz);
        assertNotNull("feature is available", featureCall.getFeature());
        val linked = featureCall.getFeature();
        assertFalse("is resolved", linked.eIsProxy());
        assertTrue(
                "testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object)".equals(linked.getIdentifier()) ||
                "testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object,int,int)".equals(linked.getIdentifier()));
//        assertNotNull("Expected issues", featureCall.getInvalidFeatureIssueCode());
    }
    
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class LinkingTest2 extends AbstractLinkingTest {
    
    @Test 
    override testImplicitFirstArgument_07() throws Exception {
        val clazz = clazz(
                "import static extension test.ImplicitFirstArgumentStatics.*
                class MyXtendClass {
                  def testExtensionMethods(CharSequence it) { 
                    withCharSequence 
                  }
                }")
        val func= clazz.getMembers().get(0) as XtendFunction
        
        val seventh = (func.getExpression() as XBlockExpression).getExpressions().get(0) as XFeatureCall
        val seventhFeature = seventh.getFeature() as JvmOperation
        assertEquals("test.ImplicitFirstArgumentStatics.withCharSequence(java.lang.CharSequence)", 
                seventhFeature.getIdentifier());
        // static methods don't have receiver but an implicit argument
        assertNull(seventh.getImplicitReceiver());
        assertNotNull(seventh.getImplicitFirstArgument());
        assertNull(seventh.getInvalidFeatureIssueCode(), seventh.getInvalidFeatureIssueCode());
        assertEquals("it", (seventh.getImplicitFirstArgument() as XAbstractFeatureCall).getFeature().getSimpleName());
    }
    
    @Test 
	override testBug345827_03() throws Exception {
		val function = function(
				"def String name(String param) { 
				   var name = ''
				   name() 
				}")
		val block = function.getExpression() as XBlockExpression
		val featureCall = block.getExpressions().last as XFeatureCall
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
    @Test 
	override testBug345827_05() throws Exception {
		val function = function(
				"def String name(String name) { 
				   name() 
				}")
		val block = function.getExpression() as XBlockExpression
		val featureCall = block.getExpressions().head as XFeatureCall
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
    
}

