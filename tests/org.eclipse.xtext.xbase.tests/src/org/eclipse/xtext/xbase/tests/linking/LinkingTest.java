/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XClass;
import org.eclipse.xtext.xbase.XFile;
import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xpression.XBinaryOperation;
import org.eclipse.xtext.xpression.XBlockExpression;
import org.eclipse.xtext.xpression.XClosure;
import org.eclipse.xtext.xpression.XExpression;
import org.eclipse.xtext.xpression.XFeatureCall;
import org.eclipse.xtext.xpression.XMemberFeatureCall;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @author Sven Efftinge
 *
 */
public class LinkingTest extends AbstractXbaseTestCase {
	
	
	public void testTypeReference_withImport() throws Exception {
		XFunction func = (XFunction) file("import java.lang.* class X { (String)=>Boolean foo() : |true;}").getClasses().get(0).getMembers().get(0);
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getType().getCanonicalName());
		JvmTypeReference paramType = type.getParamTypes().get(0);
		assertEquals("java.lang.String", paramType.getType().getCanonicalName());
	}
	
	public void testTypeReference_0() throws Exception {
		XFunction func = function("=>java.lang.Boolean foo() : |true;");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getType().getCanonicalName());
	}
	
	public void testTypeParameterReference() throws Exception {
		XFunction func = function("<X> X foo(X x) : x;");
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("X", typeParamDecl.getCanonicalName());
		assertEquals("X", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_0() throws Exception {
		XFunction func = (XFunction) file("import java.lang.* class X { <String> String foo(String x) : x;}").getClasses().get(0).getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_1() throws Exception {
		XFunction func = (XFunction) file("import java.lang.* class X { <String> String foo(java.lang.String x) : x;}")
				.getClasses().get(0).getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertNotSame(typeParamDecl,paramType.getType());
	}
	
	public void testFeatureScope_0() throws Exception {
		XFile file = file ("import java.lang.String class X { String foo() : 'hello world'; String bar(String param) : foo()+param;}");
		XClass xClass = file.getClasses().get(0);
		XFunction func  = (XFunction) xClass.getMembers().get(1);
		XBinaryOperation expression = (XBinaryOperation) func.getExpression();
		EList<XExpression> list = expression.getParams();
		XFeatureCall featureCall1 = (XFeatureCall) list.get(0);
		XFeatureCall featureCall2 = (XFeatureCall) list.get(1);
		assertEquals(featureCall1.getFeatureName(), xClass.getMembers().get(0), featureCall1.getFeature());
		assertEquals(func.getParameters().get(0), featureCall2.getFeature());
	}
	
	public void testFeatureScope_1() throws Exception {
		XFile file = file ("import java.lang.String class X { String foo() : 'hello world'; String bar(String foo) : foo;}");
		XClass xClass = file.getClasses().get(0);
		XFunction func  = (XFunction) xClass.getMembers().get(1);
		XFeatureCall featureCall1 = (XFeatureCall) func.getExpression();
		assertEquals(func.getParameters().get(0), featureCall1.getFeature());
	}
	
	public void testFeatureScope_2() throws Exception {
		XFile file = file ("import java.lang.String class X { String foo() : 'hello world'; String bar(String foo) { String foo = 'holla'; foo;}}");
		XClass xClass = file.getClasses().get(0);
		XFunction func  = (XFunction) xClass.getMembers().get(1);
		XBlockExpression block = (XBlockExpression) func.getExpression();
		XFeatureCall featureCall1 = (XFeatureCall) block.getExpressions().get(1);
		assertEquals(block.getExpressions().get(0), featureCall1.getFeature());
	}
	
	public void testFeatureScope_3() throws Exception {
		XFile file = file ("import java.lang.String class X { String foo(String foo) : String foo|foo;}");
		XClass xClass = file.getClasses().get(0);
		XFunction func  = (XFunction) xClass.getMembers().get(0);
		XClosure closure = (XClosure) func.getExpression();
		XFeatureCall featureCall1 = (XFeatureCall) closure.getExpression();
		assertEquals(closure.getParams().get(0), featureCall1.getFeature());
	}
	
	public void testMemberFeatureScope_0() throws Exception {
		XFile file = file ("import java.lang.String class X { String foo(String foo) : foo.length();}");
		XClass xClass = file.getClasses().get(0);
		XFunction func  = (XFunction) xClass.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall) func.getExpression();
		assertEquals("length", ((JvmOperation)call.getFeature()).getSimpleName());
	}
	
	public void testOperatorOverloading_1() throws Exception {
		XFile file = file ("import java.util.List class X { foo(List<String> foo) : foo += 'bar';}");
		XClass xClass = file.getClasses().get(0);
		XFunction func  = (XFunction) xClass.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall) func.getExpression();
		assertEquals("add", ((JvmOperation)call.getFeature()).getSimpleName());
	}
	
}
