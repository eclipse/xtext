/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @author Sven Efftinge
 *
 */
public class LinkingTest extends AbstractXtend2TestCase {
	
	public void testTypeReference_withImport() throws Exception {
		XtendFunction func = (XtendFunction) clazz("import java.lang.* class X { (String)=>Boolean foo() [|true] }").getMembers().get(0);
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = (JvmTypeReference) type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getCanonicalName());
		JvmTypeReference paramType = (JvmTypeReference) type.getParamTypes().get(0);
		assertEquals("java.lang.String", paramType.getCanonicalName());
	}
	
	public void testTypeReference_0() throws Exception {
		XtendFunction func = function("=>java.lang.Boolean foo() [|true]");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = (JvmTypeReference) type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getCanonicalName());
	}
	
	public void testTypeParameterReference() throws Exception {
		XtendFunction func = function("<X> X foo(X x) x");
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("X", typeParamDecl.getCanonicalName());
		assertEquals("X", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_0() throws Exception {
		XtendFunction func = (XtendFunction) file("import java.lang.* class X { <String> String foo(String x) x}").getClasses().get(0).getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_1() throws Exception {
		XtendFunction func = (XtendFunction) file("import java.lang.* class X { <String> String foo(java.lang.String x) x}")
				.getClasses().get(0).getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertNotSame(typeParamDecl,paramType.getType());
	}
//TODO	
//	public void testFeatureScope_0() throws Exception {
//		XtendFile file = file ("import java.lang.String class X { String foo() : 'hello world'; String bar(String param) : foo()+param;}");
//		XtendClass xClass = file.getClasses().get(0);
//		XtendFunction func  = (XtendFunction) xClass.getMembers().get(1);
//		XBinaryOperation expression = (XBinaryOperation) func.getExpression();
//		EList<XExpression> list = expression.getParams();
//		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) list.get(0);
//		XAbstractFeatureCall featureCall2 = (XAbstractFeatureCall) list.get(1);
//		assertEquals(featureCall1.getFeatureName(), xClass.getMembers().get(0), featureCall1.getFeature());
//		assertEquals(func.getParameters().get(0), featureCall2.getFeature());
//	}
	
	public void testFeatureScope_1() throws Exception {
		XtendFile file = file ("class X { String foo() 'hello world' String bar(String foo) foo}");
		XtendClass xClass = file.getClasses().get(0);
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(1);
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) func.getExpression();
		assertEquals(func.getParameters().get(0), featureCall1.getFeature());
	}
//TODO	
//	public void testFeatureScope_2() throws Exception {
//		XtendFile file = file ("import java.lang.String class X { String foo() : 'hello world'; String bar(String foo) { String foo = 'holla'; foo;}}");
//		XtendClass xClass = file.getClasses().get(0);
//		XtendFunction func  = (XtendFunction) xClass.getMembers().get(1);
//		XBlockExpression block = (XBlockExpression) func.getExpression();
//		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) block.getExpressions().get(1);
//		assertEquals(block.getExpressions().get(0), featureCall1.getFeature());
//	}
	
	public void testFeatureScope_3() throws Exception {
		XtendFile file = file ("import java.lang.String class X { String foo(String foo) [String foo|foo]}");
		XtendClass xClass = file.getClasses().get(0);
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XClosure closure = (XClosure) func.getExpression();
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) closure.getExpression();
		assertEquals(closure.getFormalParameters().get(0), featureCall1.getFeature());
	}
	
	public void testMemberFeatureScope_0() throws Exception {
		XtendFile file = file ("import java.lang.String class X { String foo(String foo) foo.length()}");
		XtendClass xClass = file.getClasses().get(0);
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall) func.getExpression();
		assertEquals("length", ((JvmOperation)call.getFeature()).getSimpleName());
	}
	
//TODO should be tested in Xbase
//	public void testOperatorOverloading_1() throws Exception {
//		XtendFile file = file ("import java.util.List class X { foo(List<String> foo) : foo += 'bar';}");
//		XtendClass xClass = file.getClasses().get(0);
//		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
//		XBinaryOperation call = (XBinaryOperation) func.getExpression();
//		assertEquals("add", ((JvmOperation)call.getFeature()).getSimpleName());
//	}
	
}
