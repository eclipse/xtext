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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.JvmTypes;
import org.eclipse.xtext.typing.AbstractTypeProvider;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XFeatureCall;
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
public class ExpressionsTypeResolver extends AbstractTypeProvider<JvmTypeReference> {

	public static final String JAVA_LANG_CLASS = Class.class.getName();
	public static final String INTEGER_TYPE_NAME = Long.class.getName();
	public static final String VOID_TYPE_NAME = Void.class.getName();
	public static final String BOOLEAN_TYPE_NAME = Boolean.class.getName();
	public static final String STRING_TYPE_NAME = String.class.getName();
	public static final String OBJECT_TYPE_NAME = Object.class.getName();

	@Inject
	private TypesService typesService;
	
	@Inject
	private JvmTypes jvmTypes;

	@Inject
	private ICallableFeatureFacade callableFeatureFacade;
	
	@Inject
	private TypeConverter typeConverter;
	
	
	@Override
	protected JvmTypeReference dispatch_type(EObject expression, JvmTypeReference expected) {
		JvmTypeReference dispatch_type = super.dispatch_type(expression, expected);
		return typeConverter.convert(dispatch_type,expected, expression);
	}
	
	protected JvmTypeReference _type(XIntLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(INTEGER_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XBlockExpression object, JvmTypeReference expected) {
		return internalGetType(object.getExpressions().get(object.getExpressions().size() - 1), expected);
	}

	protected JvmTypeReference _type(XSwitchExpression object, JvmTypeReference expected) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			returnTypes.add(internalGetType(xCasePart, expected));
		}
		if (object.getDefault() != null)
			returnTypes.add(internalGetType(object.getDefault(), expected));
		return typesService.getCommonType(returnTypes);
	}

	protected JvmTypeReference _type(XCasePart object, JvmTypeReference expected) {
		return internalGetType(object.getThen(), expected);
	}

	protected JvmTypeReference _type(XVariableDeclaration object, JvmTypeReference expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XFeatureCall object, JvmTypeReference expected) {
		return callableFeatureFacade.getReturnType(object.getFeature());
	}

	protected JvmTypeReference _type(XConstructorCall object, JvmTypeReference expected) {
		return object.getType();
	}

	protected JvmTypeReference _type(XBooleanLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XNullLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XStringLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(STRING_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XClosure object, JvmTypeReference expected) {
		JvmTypeReference returnType = internalGetType(object.getExpression(), expected);
		List<JvmTypeReference> parameterTypes = Lists.newArrayList();
		EList<JvmFormalParameter> params = object.getParams();
		for (JvmFormalParameter param : params) {
			if (param.getParameterType() != null) {
				parameterTypes.add(param.getParameterType());
			} else {
				throw new IllegalStateException("Type inference for closure params is not yet supported.");
			}
		}
		return typesService.createFunctionTypeRef(parameterTypes, returnType);
	}

	protected JvmTypeReference _type(XCastedExpression object) {
		return object.getType();
	}

	protected JvmTypeReference _type(XAbstractWhileExpression object, JvmTypeReference expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XTypeLiteral object, JvmTypeReference expected) {
		JvmTypeReference paramType = jvmTypes.createJvmTypeReference(object.getType());
		return typesService.getTypeForName(JAVA_LANG_CLASS, object, paramType);
	}

	protected JvmTypeReference _type(XInstanceOfExpression object, JvmTypeReference expected) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

}
