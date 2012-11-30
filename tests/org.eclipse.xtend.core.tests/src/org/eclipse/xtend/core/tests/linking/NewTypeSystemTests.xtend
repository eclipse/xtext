/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider
import org.junit.Test
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.junit.Ignore
import org.eclipse.emf.ecore.EClass

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
public class AssignmentLinkingTest2 extends AssignmentLinkingTest {
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class InferredJvmModelShadowingJavaLinkingTests2 extends InferredJvmModelShadowingJavaLinkingTests {
    
    @Test
    @Ignore("TODO")
    override testLinkInferredJvmOperationWithSyntaxError() throws Exception {
        super.testLinkInferredJvmOperationWithSyntaxError()
    }
    
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
abstract class InferredJvmModelTest2 extends InferredJvmModelTest {
    // TODO fix the dispatch case and create stuff
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
    @Ignore("TODO")
    override testField_noConflicts_publicStaticExtension() throws Exception {
        super.testField_noConflicts_publicStaticExtension()
    }
    
    @Test
    @Ignore("TODO")
    override testField_noConflicts_protectedStaticExtension() throws Exception {
        super.testField_noConflicts_protectedStaticExtension()
    }
    
    @Test
    @Ignore("TODO")
    override testField_staticExtension_shadows_sugarOnIt() throws Exception {
        super.testField_staticExtension_shadows_sugarOnIt()
    }
    
    @Test
    @Ignore("TODO")
    override testStaticImport_overloaded() throws Exception {
        super.testStaticImport_overloaded()
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
class LinkingTest2 extends LinkingTest {
    
    @Test
    @Ignore("TODO")
    override testCreateExtension_00() throws Exception {
        fail('Implement create extensions properly')
    }
    
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
    
}

