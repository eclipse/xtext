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
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
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
	public static final QualifiedName JAVA_LANG_THROWABLE;
	public static final QualifiedName JAVA_UTIL_ITERABLE;

	static {
		IQualifiedNameConverter.DefaultImpl nameConverter = new IQualifiedNameConverter.DefaultImpl();
		JAVA_LANG_CLASS = nameConverter.toQualifiedName(Class.class.getName());
		INTEGER_TYPE_NAME = nameConverter.toQualifiedName(Integer.class.getName());
		VOID_TYPE_NAME = nameConverter.toQualifiedName(Void.class.getName());
		BOOLEAN_TYPE_NAME = nameConverter.toQualifiedName(Boolean.class.getName());
		STRING_TYPE_NAME = nameConverter.toQualifiedName(String.class.getName());
		OBJECT_TYPE_NAME = nameConverter.toQualifiedName(Object.class.getName());
		JAVA_LANG_THROWABLE = nameConverter.toQualifiedName(Throwable.class.getName());
		JAVA_UTIL_ITERABLE = nameConverter.toQualifiedName(Iterable.class.getName());
	}

	@Inject
	private TypesService typesService;

	@Inject
	private TypesFactory factory;

	@Inject
	private TypeConverter typeConverter;

	@Inject
	private TypeArgumentContext.Provider typeArgCtxProvider;

	@Override
	protected JvmTypeReference dispatch_type(EObject expression, Context<JvmTypeReference> context) {
		JvmTypeReference dispatch_type = super.dispatch_type(expression, context);
		return typeConverter.convert(dispatch_type, expression);
	}

	protected JvmTypeReference _type(XIfExpression object, Context<JvmTypeReference> context) {
		internalGetType(object.getIf(), Context.newCtx(typesService.getTypeForName(BOOLEAN_TYPE_NAME, object), context));
		if (object.getElse() != null)
			return typesService.getCommonType(Lists.newArrayList(internalGetType(object.getThen(), context),
					internalGetType(object.getElse(), context)));
		else
			return internalGetType(object.getThen(), context);
	}

	protected JvmTypeReference _type(XSwitchExpression object, Context<JvmTypeReference> context) {
		if(object.getSwitch() != null)
			checkType(object.getSwitch(), context);
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
		checkType(object.getCase(), context);
		return internalGetType(object.getThen(), context);
	}

	protected JvmTypeReference _type(XBlockExpression object, Context<JvmTypeReference> context) {
		for(int i=0; i<object.getExpressions().size()-2; ++i) {
			checkType(object.getExpressions().get(i), context);
		}
		return internalGetType(object.getExpressions().get(object.getExpressions().size()-1), context);
	}

	protected JvmTypeReference _type(XVariableDeclaration object, Context<JvmTypeReference> context) {
		JvmTypeReference rightType = checkConformance(object.getType(), object.getRight(), context);
		if (object.getType() != null)
			return object.getType();
		return rightType;
	}

	protected JvmTypeReference _type(XAbstractFeatureCall object, Context<JvmTypeReference> context) {
		for(XExpression argument : object.getArguments()) {
			checkType(argument, context);
		}
		JvmIdentifyableElement eobject = object.getFeature();
		JvmTypeReference featureType = internalGetType(eobject, context);
		if (object instanceof XMemberFeatureCall) {
			JvmTypeReference targetType = dispatch_type(((XMemberFeatureCall) object).getMemberCallTarget(), context);
			return typeArgCtxProvider.get(targetType).resolve(featureType);
		}
		return featureType;
	}

	protected JvmTypeReference _type(XConstructorCall object, Context<JvmTypeReference> context) {
		for(XExpression argument : object.getArguments()) {
			checkType(argument, context);
		}
		JvmConstructor constructor = object.getConstructor();
		JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
		result.setType(constructor.getDeclaringType());
		for (JvmTypeReference argument : object.getTypeArguments()) {
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

	protected JvmTypeReference _type(XIntLiteral object, Context<JvmTypeReference> context) {
		return typesService.getTypeForName(INTEGER_TYPE_NAME, object);
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
		checkConformance(object.getType(), object.getTarget(), context);
		return object.getType();
	}

	protected JvmTypeReference _type(XForLoopExpression object, Context<JvmTypeReference> context) {
		checkConformance(typesService.getTypeForName(JAVA_UTIL_ITERABLE, object), object.getForExpression(), context);
		// TODO type parameters and variable
		checkType(object.getEachExpression(), context);
		return typesService.getTypeForName(VOID_TYPE_NAME, object);		
	}

	protected JvmTypeReference _type(XAbstractWhileExpression object, Context<JvmTypeReference> context) {
		checkType(object.getBody(), context);
		internalGetType(object.getPredicate(), Context.newCtx(typesService.getTypeForName(BOOLEAN_TYPE_NAME, object), context));
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

	protected JvmTypeReference _type(XThrowExpression object, Context<JvmTypeReference> context) {
		checkConformance(typesService.getTypeForName(JAVA_LANG_THROWABLE, object), object.getExpression(), context);
		return typesService.getTypeForName(VOID_TYPE_NAME, object);
	}
	
	protected JvmTypeReference _type(XTryCatchFinallyExpression object, Context<JvmTypeReference> context) {
		checkType(object.getExpression(), context);
		for(XCatchClause catchClause: object.getCatchClauses())
			checkType(catchClause, context);
		XExpression finallyExpression = object.getFinallyExpression();
		if(finallyExpression != null)
			checkType(finallyExpression, context);
		return internalGetType(object.getExpression(), context);
	}

	protected JvmTypeReference _type(XCatchClause object, Context<JvmTypeReference> context) {
		checkType(object.getExpression(), context);
		checkConformance(object.getDeclaredParam(), Context.newCtx(typesService.getTypeForName(JAVA_LANG_THROWABLE, object), context), object.getDeclaredParam().getParameterType());
		return internalGetType(object.getExpression(), context);
	}
	
	public TypesFactory getTypesFactory() {
		return factory;
	}

	public TypesService getTypesService() {
		return typesService;
	}
	
	protected JvmTypeReference checkConformance(JvmTypeReference expectedType, XExpression expression, Context<JvmTypeReference> context) {
		JvmTypeReference actualType = internalGetType(expression, context);
		checkConformance(expression, Context.newCtx(expectedType, context), actualType);
		return actualType;
	}

	protected JvmTypeReference checkType(EObject object, Context<JvmTypeReference> context) {
		return internalGetType(object, Context.<JvmTypeReference>newCtx(context));
	}

}
