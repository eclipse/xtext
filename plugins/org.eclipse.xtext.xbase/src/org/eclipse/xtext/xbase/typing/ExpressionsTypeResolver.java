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
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xpression.XAssignment;
import org.eclipse.xtext.xpression.XBlockExpression;
import org.eclipse.xtext.xpression.XBooleanLiteral;
import org.eclipse.xtext.xpression.XCasePart;
import org.eclipse.xtext.xpression.XCastedExpression;
import org.eclipse.xtext.xpression.XClosure;
import org.eclipse.xtext.xpression.XConstructorCall;
import org.eclipse.xtext.xpression.XFeatureCall;
import org.eclipse.xtext.xpression.XInstanceOfExpression;
import org.eclipse.xtext.xpression.XIntLiteral;
import org.eclipse.xtext.xpression.XNullLiteral;
import org.eclipse.xtext.xpression.XRichString;
import org.eclipse.xtext.xpression.XStringLiteral;
import org.eclipse.xtext.xpression.XSwitchExpression;
import org.eclipse.xtext.xpression.XTypeLiteral;
import org.eclipse.xtext.xpression.XVariableDeclaration;
import org.eclipse.xtext.xpression.XWhileExpression;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge
 */
public class ExpressionsTypeResolver {
	
	static interface ExpectedTypesProvider extends Provider<Set<JvmTypeReference>>{}
	static final ExpectedTypesProvider NO_EXPECTED_TYPES = new ExpectedTypesProvider() {
		public Set<JvmTypeReference> get() {
			return Collections.emptySet();
		}
	};
	
	public static final String JAVA_LANG_CLASS = Class.class.getName();
	public static final String INTEGER_TYPE_NAME = Long.class.getName();
	public static final String VOID_TYPE_NAME = Void.class.getName();
	public static final String BOOLEAN_TYPE_NAME = Boolean.class.getName();
	public static final String STRING_TYPE_NAME = String.class.getName();
	public static final String OBJECT_TYPE_NAME = Object.class.getName();
	
	private final PolymorphicDispatcher<JvmTypeReference> dispatcher = PolymorphicDispatcher.createForSingleTarget("_case", 2,2, this);

	@Inject
	private TypesService typesService;
	
	@Inject
	private ICallableFeatureFacade callableFeatureFacade;
	
	/**
	 * the main dispatching method
	 * @param exprNode - the Expression AST node for which to compute the return type - never null
	 * @param expected - the expected return type, used for type inference - can be null
	 */
	public JvmTypeReference doSwitch(EObject exprNode, ExpectedTypesProvider expected) {
		return dispatcher.invoke(exprNode,expected==null?NO_EXPECTED_TYPES:expected);
	}

	
	protected JvmTypeReference _case(XIntLiteral object, ExpectedTypesProvider expected) {
		return typesService.getTypeForName(INTEGER_TYPE_NAME, object);
	}

	
	protected JvmTypeReference _case(XBlockExpression object, ExpectedTypesProvider expected) {
		return doSwitch(object.getExpressions().get(
				object.getExpressions().size() - 1), expected);
	}

	
	protected JvmTypeReference _case(XSwitchExpression object, ExpectedTypesProvider expected) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			returnTypes.add(doSwitch(xCasePart,expected));
		}
		if (object.getDefault() != null)
			returnTypes.add(doSwitch(object.getDefault(),expected));
		return typesService.getCommonType(returnTypes);
	}

	
	protected JvmTypeReference _case(XCasePart object, ExpectedTypesProvider expected) {
		return doSwitch(object.getThen(), expected);
	}

	
	protected JvmTypeReference _case(XVariableDeclaration object, ExpectedTypesProvider expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _case(XFeatureCall object, ExpectedTypesProvider expected) {
		return callableFeatureFacade.getReturnType(object.getFeature());
	}
	
	protected JvmTypeReference _case(XConstructorCall object, ExpectedTypesProvider expected) {
		return object.getType();
	}

	protected JvmTypeReference _case(XBooleanLiteral object, ExpectedTypesProvider expected) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

	
	protected JvmTypeReference _case(XNullLiteral object, ExpectedTypesProvider expected) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	
	protected JvmTypeReference _case(XStringLiteral object, ExpectedTypesProvider expected) {
		return typesService.getTypeForName(STRING_TYPE_NAME, object);
	}

	
	protected JvmTypeReference _case(XRichString object, ExpectedTypesProvider expected) {
		return typesService.getTypeForName(STRING_TYPE_NAME, object);
	}

	
	protected JvmTypeReference _case(XClosure object, ExpectedTypesProvider expected) {
		JvmTypeReference returnType = doSwitch(object.getExpression(), expected);
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

	
	protected JvmTypeReference _case(XAssignment object) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	
	protected JvmTypeReference _case(XWhileExpression object) {
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}

	
	protected JvmTypeReference _case(XTypeLiteral object) {
		JvmTypeReference paramType = typesService.createJvmTypeReference(object.getType());
		return typesService.getTypeForName(JAVA_LANG_CLASS, object,paramType);
	}

	
	protected JvmTypeReference _case(XInstanceOfExpression object) {
		return typesService.getTypeForName(BOOLEAN_TYPE_NAME, object);
	}

}
