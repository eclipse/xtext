/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeArgument;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ExpressionsTypeResolver;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 *
 */
public class ExpressionsTypeResolverTest extends AbstractXbaseTestCase {
	
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
		assertResolvedReturnType(ExpressionsTypeResolver.STRING_TYPE_NAME,"switch { case true : 's' case false : 'foo' default: 'bar'}");
//		assertResolvedReturnType(ExpressionsTypeResolver.OBJECT_TYPE_NAME,"switch { case true : 's' case false : new java.lang.Object default: 'bar'}");
	}
	
	public void testClosure() throws Exception {
		assertResolvedReturnType("(java.lang.String)=>java.lang.Boolean", "java.lang.String x| true");
	}
	
	
	public void assertResolvedReturnType(String type, String expression) throws Exception {
		JvmTypeReference typeRef = typeResolver.doSwitch(expression(expression));
		assertEquals(type,toString(typeRef));
	}
	
	
	protected String toString(JvmTypeArgument arg) {
		if (arg instanceof JvmReferenceTypeArgument) {
			return toString(((JvmReferenceTypeArgument)arg).getTypeReference());
		} else if (arg instanceof JvmWildcardTypeArgument) {
			JvmWildcardTypeArgument wcType = (JvmWildcardTypeArgument) arg;
			String name="?";
			EList<JvmTypeConstraint> constraints = wcType.getConstraints();
			for (JvmTypeConstraint jvmTypeConstraint : constraints) {
				if (jvmTypeConstraint instanceof JvmUpperBound) {
					name+= " extends "+toString(jvmTypeConstraint.getTypeReference());
				} else {
					name+= " super "+toString(jvmTypeConstraint.getTypeReference());
				}
			}
			return name;
		}
		throw new IllegalArgumentException();
	}
	protected String toString(JvmTypeReference typeref) {
		if (typeref instanceof XFunctionTypeRef) {
			XFunctionTypeRef funcType = (XFunctionTypeRef) typeref;
			EList<JvmTypeReference> paramTypes = funcType.getParamTypes();
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
		} else if (typeref instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference xSimpleTypeRef = (JvmParameterizedTypeReference) typeref;
			String name = xSimpleTypeRef.getType().getCanonicalName();
			EList<JvmTypeArgument> typeParams = xSimpleTypeRef.getArguments();
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
		} 
		throw new IllegalArgumentException();
	}
	
	
}
