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
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.xbase.scoping.XbaseTypeProvider;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 *
 */
public class XbaseTypeProviderTest extends AbstractXbaseTestCase {
	
	@Inject
	private ITypeProvider<JvmTypeReference> typeResolver;
	
	public void testNullLiteral() throws Exception {
		assertResolvedReturnType(XbaseTypeProvider.VOID_TYPE_NAME, "null");
	}
	
	public void testBooleanLiteral() throws Exception {
		assertResolvedReturnType(XbaseTypeProvider.BOOLEAN_TYPE_NAME, "true");
		assertResolvedReturnType(XbaseTypeProvider.BOOLEAN_TYPE_NAME, "false");
	}
	
	public void testStringLiteral() throws Exception {
		assertResolvedReturnType(XbaseTypeProvider.STRING_TYPE_NAME, "'foo'");
		assertResolvedReturnType(XbaseTypeProvider.STRING_TYPE_NAME, "\"foo\"");
	}
	
	public void testIntLiteral() throws Exception {
		assertResolvedReturnType(XbaseTypeProvider.INTEGER_TYPE_NAME, "3");
	}
	
	public void testConstructorCall() throws Exception {
		assertResolvedReturnType("java.util.ArrayList", "new java.util.ArrayList()");
		assertResolvedReturnType("java.util.ArrayList<java.lang.String>", 
								"new java.util.ArrayList<java.lang.String>()");
		assertResolvedReturnType("java.util.HashMap<java.lang.String,java.lang.Boolean>", 
								"new java.util.HashMap<java.lang.String, java.lang.Boolean>()");
		assertResolvedReturnType("java.util.HashMap<? extends java.lang.String,? super java.lang.Boolean>", 
							"new java.util.HashMap<? extends java.lang.String, ? super java.lang.Boolean>()");
	}
	
	public void testBlockExpression() throws Exception {
		assertResolvedReturnType(XbaseTypeProvider.INTEGER_TYPE_NAME, "{true;4;}");
		assertResolvedReturnType(XbaseTypeProvider.BOOLEAN_TYPE_NAME, "{4;true;}");
		assertResolvedReturnType(XbaseTypeProvider.VOID_TYPE_NAME, "{null;}");
	}
	
	public void testSwitchExpression() throws Exception {
		assertResolvedReturnType(XbaseTypeProvider.STRING_TYPE_NAME,"switch { case true : 's'; case false : 'foo'; default: 'bar';}");
		assertResolvedReturnType(XbaseTypeProvider.OBJECT_TYPE_NAME,"switch { case true : 's'; case false : new java.lang.Object(); default: 'bar';}");
	}
	
	public void testClosure() throws Exception {
		assertResolvedReturnType("(java.lang.String)=>java.lang.Boolean", "java.lang.String x| true");
	}
	
	public void testFeatureCall() throws Exception {
		assertResolvedReturnType("java.lang.Integer", "'foo'.length");
	}
	
	public void testFeatureCall_1() throws Exception {
		assertResolvedReturnType("java.util.List<java.lang.Byte>", "'foo'.getBytes()");
		assertResolvedReturnType("java.lang.Boolean", "'foo'.getBytes().add(null)");
//		assertResolvedReturnType("java.lang.String", "new java.util.ArrayList<java.lang.String>().get(23)");
	}
	
	public void testFeatureCallWithOperatorOverloading2() throws Exception {
		assertResolvedReturnType("java.lang.Boolean", "'foo'.getBytes() += null");
		assertResolvedReturnType("java.lang.Boolean", "'foo'.getBytes() += 'x'.getBytes().get(0)");
	}
	
	public void testFeatureCallOnThis() throws Exception {
		assertResolvedReturnType("java.lang.Boolean", "{ val this = 'foo'; getBytes() += null;}");
		assertResolvedReturnType("java.lang.Boolean", "{ var this = 'foo'; this.getBytes() += getBytes().get(0);}");
	}
	
	public void assertResolvedReturnType(String type, String expression) throws Exception {
		JvmTypeReference typeRef = typeResolver.getType(expression(expression,true),null);
		assertNotNull("type ref was null for "+expression,typeRef);
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
		throw new IllegalArgumentException(typeref.toString());
	}
	
	
}
