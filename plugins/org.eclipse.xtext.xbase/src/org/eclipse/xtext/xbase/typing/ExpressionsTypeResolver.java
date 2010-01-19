/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xpression.XAssignment;
import org.eclipse.xtext.xpression.XBinaryOperation;
import org.eclipse.xtext.xpression.XBlockExpression;
import org.eclipse.xtext.xpression.XBooleanLiteral;
import org.eclipse.xtext.xpression.XCasePart;
import org.eclipse.xtext.xpression.XCastedExpression;
import org.eclipse.xtext.xpression.XClosure;
import org.eclipse.xtext.xpression.XConstructorCall;
import org.eclipse.xtext.xpression.XDeclaredParameter;
import org.eclipse.xtext.xpression.XExpression;
import org.eclipse.xtext.xpression.XFeatureCall;
import org.eclipse.xtext.xpression.XInstanceOfExpression;
import org.eclipse.xtext.xpression.XIntLiteral;
import org.eclipse.xtext.xpression.XNullLiteral;
import org.eclipse.xtext.xpression.XRichString;
import org.eclipse.xtext.xpression.XStringLiteral;
import org.eclipse.xtext.xpression.XSwitchExpression;
import org.eclipse.xtext.xpression.XTypeLiteral;
import org.eclipse.xtext.xpression.XUnaryOperation;
import org.eclipse.xtext.xpression.XVariableDeclaration;
import org.eclipse.xtext.xpression.XWhileExpression;
import org.eclipse.xtext.xpression.util.XpressionSwitch;
import org.eclipse.xtext.xtype.XTypeRef;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class ExpressionsTypeResolver extends XpressionSwitch<XTypeRef> {
	public static final String INTEGER_TYPE_NAME = Long.class.getName();
	public static final String VOID_TYPE_NAME = Void.class.getName();
	public static final String BOOLEAN_TYPE_NAME = Boolean.class.getName();
	public static final String STRING_TYPE_NAME = String.class.getName();
	public static final String OBJECT_TYPE_NAME = Object.class.getName();

	@Inject
	private TypesService typesService;
	
	@Inject
	private OperatorMapping operatorMapping;

	@Override
	public XTypeRef caseXIntLiteral(XIntLiteral object) {
		return typesService.getTypeForName(INTEGER_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXBlockExpression(XBlockExpression object) {
		return doSwitch(object.getExpressions().get(
				object.getExpressions().size() - 1));
	}

	@Override
	public XTypeRef caseXSwitchExpression(XSwitchExpression object) {
		List<XTypeRef> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			returnTypes.add(doSwitch(xCasePart));
		}
		if (object.getDefault() != null)
			returnTypes.add(doSwitch(object.getDefault()));
		return typesService.getCommonType(returnTypes);
	}

	@Override
	public XTypeRef caseXCasePart(XCasePart object) {
		return doSwitch(object.getThen());
	}

	@Override
	public XTypeRef caseXVariableDeclaration(XVariableDeclaration object) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXFeatureCall(XFeatureCall object) {
		return getReturnType(object.getTarget(), object.getName(), object.getParams(), object);
	}
	
	private XTypeRef getReturnType(XExpression target, String name,
			List<XExpression> params, XExpression context) {
		
		return null;
	}

	@Override
	public XTypeRef caseXBinaryOperation(XBinaryOperation object) {
		return getReturnType(object.getLeft(), operatorMapping.getMethodName(object.getOperator()), Collections.singletonList(object.getRight()), object);
	}

	@Override
	public XTypeRef caseXUnaryOperation(XUnaryOperation object) {
		return getReturnType(object.getTarget(), operatorMapping.getMethodName(object.getOperator()), Collections.<XExpression>emptyList(), object);
	}

	@Override
	public XTypeRef caseXConstructorCall(XConstructorCall object) {
		return object.getType();
	}

	@Override
	public XTypeRef caseXBooleanLiteral(XBooleanLiteral object) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXNullLiteral(XNullLiteral object) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXStringLiteral(XStringLiteral object) {
		return typesService.getTypeForName(STRING_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXRichString(XRichString object) {
		return typesService.getTypeForName(STRING_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXClosure(XClosure object) {
		XTypeRef returnType = doSwitch(object.getExpression());
		List<XTypeRef> parameterTypes = Lists.newArrayList();
		EList<XDeclaredParameter> params = object.getParams();
		for (XDeclaredParameter xDeclaredParameter : params) {
			if (xDeclaredParameter.getType() != null) {
				parameterTypes.add(xDeclaredParameter.getType());
			} else {
				parameterTypes.add(inferTypeFromContext(xDeclaredParameter,
						object));
			}
		}
		return typesService.createFunctionTypeRef(parameterTypes, returnType);
	}

	protected XTypeRef inferTypeFromContext(
			XDeclaredParameter xDeclaredParameter, XClosure object) {
		if (object.eContainer() instanceof XBinaryOperation) {
			//TODO
		} else if (object.eContainer() instanceof XAssignment) {
			//TODO

		} else if (object.eContainer() instanceof XVariableDeclaration) {
			XVariableDeclaration dec = (XVariableDeclaration) object
					.eContainer();
			if (dec.getType() != null)
				return dec.getType();
		} else if (object.eContainer() instanceof XFeatureCall) {
			//TODO

		} else if (object.eContainer() instanceof XCastedExpression) {
			//TODO

		}
		return typesService.getTypeForName(OBJECT_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXCastedExpression(XCastedExpression object) {
		return object.getType();
	}

	@Override
	public XTypeRef caseXAssignment(XAssignment object) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXWhileExpression(XWhileExpression object) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	@Override
	public XTypeRef caseXTypeLiteral(XTypeLiteral object) {
		XTypeRef paramType = typesService.createSimpleTypeRef(object.getType());
		return typesService.getTypeForName("java.lang.Class", object,paramType);
	}

	@Override
	public XTypeRef caseXInstanceOfExpression(XInstanceOfExpression object) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

}
