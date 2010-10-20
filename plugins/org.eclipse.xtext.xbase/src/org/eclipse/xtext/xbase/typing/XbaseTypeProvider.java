/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.JvmTypesTypeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class XbaseTypeProvider extends JvmTypesTypeProvider {

	public static final QualifiedName JAVA_LANG_CLASS;
	public static final QualifiedName INTEGER_TYPE_NAME;
	public static final QualifiedName VOID_TYPE_NAME;
	public static final QualifiedName BOOLEAN_TYPE_NAME;
	public static final QualifiedName STRING_TYPE_NAME;
	public static final QualifiedName OBJECT_TYPE_NAME;

	static {
		IQualifiedNameConverter.DefaultImpl nameConverter = new IQualifiedNameConverter.DefaultImpl();
		JAVA_LANG_CLASS = nameConverter.toQualifiedName(Class.class.getName());
		INTEGER_TYPE_NAME = nameConverter.toQualifiedName(Long.class.getName());
		VOID_TYPE_NAME = nameConverter.toQualifiedName(Void.class.getName());
		BOOLEAN_TYPE_NAME = nameConverter.toQualifiedName(Boolean.class.getName());
		STRING_TYPE_NAME = nameConverter.toQualifiedName(String.class.getName());
		OBJECT_TYPE_NAME = nameConverter.toQualifiedName(Object.class.getName());
	}

	@Inject
	private TypesService typesService;

	@Inject
	private TypesFactory factory;

	@Inject
	private TypeConverter typeConverter;

	@Override
	protected JvmTypeReference dispatch_type(EObject expression, Context<JvmTypeReference> context) {
		JvmTypeReference dispatch_type = super.dispatch_type(expression, context);
		return typeConverter.convert(dispatch_type, context.getExpectedType(), expression);
	}

	protected JvmTypeReference _type(XIntLiteral object, Context<JvmTypeReference> context) {
		return typesService.getTypeForName(INTEGER_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XBlockExpression object, Context<JvmTypeReference> context) {
		return internalGetType(object.getExpressions().get(object.getExpressions().size() - 1), context);
	}

	protected JvmTypeReference _type(XSwitchExpression object, Context<JvmTypeReference> context) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			returnTypes.add(internalGetType(xCasePart, context));
		}
		if (object.getDefault() != null)
			returnTypes.add(internalGetType(object.getDefault(), context));
		return typesService.getCommonType(returnTypes);
	}

	protected JvmTypeReference _type(XCasePart object, Context<JvmTypeReference> context) {
		return internalGetType(object.getThen(), context);
	}

	protected JvmTypeReference _type(XVariableDeclaration object, Context<JvmTypeReference> context) {
		return internalGetType(object.getRight(), Context.newCtx(object.getType(), context));
	}

	protected JvmTypeReference _type(XAbstractFeatureCall object, Context<JvmTypeReference> context) {
		JvmIdentifyableElement eobject = object.getFeature();
		return internalGetType(eobject, context);
	}

	protected JvmTypeReference _type(XConstructorCall object, Context<JvmTypeReference> context) {
		JvmConstructor constructor = object.getConstructor();
		JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
		result.setType(constructor.getDeclaringType());
		for(JvmTypeReference argument: object.getTypeArguments()) {
			result.getArguments().add(EcoreUtil2.clone(argument));
		}
		return result;
	}

	protected JvmTypeReference _type(XBooleanLiteral object, Context<JvmTypeReference> context) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XNullLiteral object, Context<JvmTypeReference> context) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XStringLiteral object, Context<JvmTypeReference> context) {
		return typesService.getTypeForName(STRING_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XClosure object, Context<JvmTypeReference> context) {
		JvmTypeReference returnType = internalGetType(object.getExpression(), context);
		List<JvmTypeReference> parameterTypes = Lists.newArrayList();
		EList<JvmFormalParameter> params = object.getFormalParameters();
		for (JvmFormalParameter param : params) {
			if (param.getParameterType() != null) {
				parameterTypes.add(param.getParameterType());
			} else {
				throw new IllegalStateException("Type inference for closure params is not yet supported.");
			}
		}
		return typesService.createFunctionTypeRef(parameterTypes, returnType);
	}

	protected JvmTypeReference _type(XCastedExpression object, Context<JvmTypeReference> context) {
		return object.getType();
	}

	protected JvmTypeReference _type(XAbstractWhileExpression object, Context<JvmTypeReference> context) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XTypeLiteral object, Context<JvmTypeReference> context) {
		JvmParameterizedTypeReference typeRef = factory.createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		return typesService.getTypeForName(JAVA_LANG_CLASS, object, typeRef);
	}

	protected JvmTypeReference _type(XInstanceOfExpression object, Context<JvmTypeReference> context) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

}
