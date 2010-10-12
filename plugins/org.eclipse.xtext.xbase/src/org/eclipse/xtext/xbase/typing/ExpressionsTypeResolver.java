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
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
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

	private TypesService typesService;

	private ICallableFeatureFacade callableFeatureFacade;

	@Inject
	public ExpressionsTypeResolver(TypesService typesService, ICallableFeatureFacade callableFeatureFacade) {
		this.typesService = typesService;
		this.callableFeatureFacade = callableFeatureFacade;
	}

	protected JvmTypeReference _case(XIntLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(INTEGER_TYPE_NAME, object);
	}

	protected JvmTypeReference _case(XBlockExpression object, JvmTypeReference expected) {
		return internalGetType(object.getExpressions().get(object.getExpressions().size() - 1), expected);
	}

	protected JvmTypeReference _case(XSwitchExpression object, JvmTypeReference expected) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			returnTypes.add(internalGetType(xCasePart, expected));
		}
		if (object.getDefault() != null)
			returnTypes.add(internalGetType(object.getDefault(), expected));
		return typesService.getCommonType(returnTypes);
	}

	protected JvmTypeReference _case(XCasePart object, JvmTypeReference expected) {
		return internalGetType(object.getThen(), expected);
	}

	protected JvmTypeReference _case(XVariableDeclaration object, JvmTypeReference expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _case(XFeatureCall object, JvmTypeReference expected) {
		return callableFeatureFacade.getReturnType(object.getFeature());
	}

	protected JvmTypeReference _case(XConstructorCall object, JvmTypeReference expected) {
		return object.getType();
	}

	protected JvmTypeReference _case(XBooleanLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

	protected JvmTypeReference _case(XNullLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _case(XStringLiteral object, JvmTypeReference expected) {
		return typesService.getTypeForName(STRING_TYPE_NAME, object);
	}

	protected JvmTypeReference _case(XClosure object, JvmTypeReference expected) {
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

	protected JvmTypeReference _case(XCastedExpression object) {
		return object.getType();
	}

	protected JvmTypeReference _case(XAbstractWhileExpression object, JvmTypeReference expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _case(XTypeLiteral object, JvmTypeReference expected) {
		JvmTypeReference paramType = typesService.createJvmTypeReference(object.getType());
		return typesService.getTypeForName(JAVA_LANG_CLASS, object, paramType);
	}

	protected JvmTypeReference _case(XInstanceOfExpression object, JvmTypeReference expected) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

}
