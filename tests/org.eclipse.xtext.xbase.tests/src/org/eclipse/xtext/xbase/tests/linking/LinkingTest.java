/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

/**
 * @author Sven Efftinge
 *
 */
public class LinkingTest extends AbstractXbaseTestCase {
	
	
	public void testTypeReference_withImport() throws Exception {
		XFunction func = file("import java.lang.* class X { (String)=>Boolean foo() : |true;}").getClasses().get(0).getFunctions().get(0);
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
		
		JvmTypeReference paramType = func.getDeclaredParams().get(0).getType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_0() throws Exception {
		XFunction func = file("import java.lang.* class X { <String> String foo(String x) : x;}").getClasses().get(0).getFunctions().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getDeclaredParams().get(0).getType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	public void testTypeParameterReference_1() throws Exception {
		XFunction func = file("import java.lang.* class X { <String> String foo(java.lang.String x) : x;}").getClasses().get(0).getFunctions().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getCanonicalName());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getDeclaredParams().get(0).getType();
		assertNotSame(typeParamDecl,paramType.getType());
	}
	
}
