/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ExpressionsTypeResolver;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XSimpleTypeRef;
import org.eclipse.xtext.xtype.XTypeRef;
import org.eclipse.xtext.xtype.XWildcardParam;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 *
 */
public class TypeResolverTest extends AbstractXbaseTestCase {
	
	@Inject
	private ExpressionsTypeResolver typeResolver;
	
	public void testNullLiteral() throws Exception {
		assertResolvedReturnType(ExpressionsTypeResolver.VOID_TYPE_NAME, "null");
	}
	
	public void testBooleanLiteral() throws Exception {
		assertResolvedReturnType(ExpressionsTypeResolver.BOOLEAN_TYPE_NAME, "true");
		assertResolvedReturnType(ExpressionsTypeResolver.BOOLEAN_TYPE_NAME, "false");
	}
	
	public void testStringLiteral() throws Exception {
		assertResolvedReturnType(ExpressionsTypeResolver.STRING_TYPE_NAME, "'foo'");
		assertResolvedReturnType(ExpressionsTypeResolver.STRING_TYPE_NAME, "\"foo\"");
	}
	
	public void testRichStringLiteral() throws Exception {
		assertResolvedReturnType(ExpressionsTypeResolver.STRING_TYPE_NAME, "»foo«");
		assertResolvedReturnType(ExpressionsTypeResolver.STRING_TYPE_NAME, "»foo«bar»baz«");
	}
	
	public void testIntLiteral() throws Exception {
		assertResolvedReturnType(ExpressionsTypeResolver.INTEGER_TYPE_NAME, "3");
	}
	
	public void testConstructorCall() throws Exception {
		assertResolvedReturnType("java.util.ArrayList", "new java.util.ArrayList");
		assertResolvedReturnType("java.util.ArrayList<java.lang.String>", "new java.util.ArrayList<java.lang.String>");
		assertResolvedReturnType("java.util.ArrayList<java.lang.String,java.lang.Boolean>", "new java.util.ArrayList<java.lang.String, java.lang.Boolean>");
		assertResolvedReturnType("java.util.ArrayList<? extends java.lang.String,? super java.lang.Boolean>", "new java.util.ArrayList<? extends java.lang.String, ? super java.lang.Boolean>");
	}
	
	
	public void testBlockExpression() throws Exception {
		assertResolvedReturnType(ExpressionsTypeResolver.INTEGER_TYPE_NAME, "{true;4;}");
	}
	
	public void testSwitchExpression() throws Exception {
		//TODO
	}
	
	public void testClosure() throws Exception {
		assertResolvedReturnType("(java.lang.String)=>java.lang.Boolean", "java.lang.String x| true");
	}
	
	
	public void assertResolvedReturnType(String type, String expression) throws Exception {
		XTypeRef typeRef = typeResolver.doSwitch(expression(expression));
		assertEquals(type,toString(typeRef));
	}
	
	
	protected String toString(XTypeRef typeref) {
		if (typeref instanceof XSimpleTypeRef) {
			XSimpleTypeRef xSimpleTypeRef = (XSimpleTypeRef) typeref;
			String name = xSimpleTypeRef.getType().getCanonicalName();
			EList<XTypeRef> typeParams = xSimpleTypeRef.getTypeParams();
			int size = typeParams.size();
			for (int i=0;i<size;i++) {
				if (i==0)
					name+="<";
				name+=toString(typeParams.get(i));
				if (i+1<size) {
					name+=",";
				} else {
					name+=">";
				}
			}
			return name;
		} else if (typeref instanceof XFunctionTypeRef) {
			XFunctionTypeRef funcType = (XFunctionTypeRef) typeref;
			EList<XTypeRef> paramTypes = funcType.getParamTypes();
			String name = "";
			int size = paramTypes.size();
			for (int i=0;i<size;i++) {
				if (i==0)
					name+="(";
				name+=toString(paramTypes.get(i));
				if (i+1<size) {
					name+=",";
				} else {
					name+=")";
				}
			}
			return name+"=>"+toString(funcType.getReturnType());
		} else if (typeref instanceof XWildcardParam) {
			XWildcardParam wcType = (XWildcardParam) typeref;
			String name="?";
			if (wcType.getExtends()!=null) {
				name+= " extends "+toString(wcType.getExtends());
			}
			if (wcType.getSuper()!=null) {
				name+= " super "+toString(wcType.getSuper());
			}
			return name;
		}
		throw new IllegalStateException();
	}
	
	
}
