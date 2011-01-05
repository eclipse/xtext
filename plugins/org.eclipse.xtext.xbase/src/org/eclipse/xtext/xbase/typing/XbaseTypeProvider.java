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
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.common.types.util.JvmTypesTypeProvider;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
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

	@Inject
	private TypesService typesService;
	
	@Inject
	private IJvmTypeConformanceComputer typeConformanceComputer;

	@Inject
	private TypesFactory factory;

	@Inject
	private TypeConverter typeConverter;

	@Inject
	private TypeArgumentContext.Provider typeArgCtxProvider;

	@Override
	protected JvmTypeReference doConversion(JvmTypeReference actualType, EObject context) {
		return typeConverter.convert(actualType, context);
	}

	protected JvmTypeReference _type(XIfExpression object) {
		if (object.getElse() != null)
			return typeConformanceComputer.getCommonSuperType(Lists.newArrayList(getType(object.getThen()),
					getType(object.getElse())));
		else
			return getType(object.getThen());
	}

	protected JvmTypeReference _type(XSwitchExpression object) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			returnTypes.add(getType(xCasePart));
		}
		if (object.getDefault() != null)
			returnTypes.add(getType(object.getDefault()));
		return typeConformanceComputer.getCommonSuperType(returnTypes);
	}

	protected JvmTypeReference _type(XCasePart object) {
		return getType(object.getThen());
	}

	protected JvmTypeReference _type(XBlockExpression object) {
		return getType(object.getExpressions().get(object.getExpressions().size()-1));
	}

	protected JvmTypeReference _type(XVariableDeclaration object) {
		if (object.getType() != null)
			return object.getType();
		return getType(object.getRight());
	}

	protected JvmTypeReference _type(XAbstractFeatureCall object) {
		//TODO use expectedType to infer type args
		JvmIdentifyableElement eobject = object.getFeature();
		JvmTypeReference featureType = getType(eobject);
		if (object instanceof XMemberFeatureCall) {
			JvmTypeReference targetType = getType(((XMemberFeatureCall) object).getMemberCallTarget());
			return typeArgCtxProvider.get(targetType).resolveCovariant(featureType);
		}
		return featureType;
	}

	protected JvmTypeReference _type(XConstructorCall object) {
		JvmConstructor constructor = object.getConstructor();
		if (constructor.eIsProxy())
			return null;
		final JvmParameterizedTypeReference type = (JvmParameterizedTypeReference) getType(object.getConstructor());
		for (JvmTypeReference typeArg : object.getTypeArguments()) {
			JvmTypeReference copy = EcoreUtil2.clone(typeArg);
			type.getArguments().add(copy);
		}
		return type;
	}

	protected JvmTypeReference _type(XBooleanLiteral object) {
		return typesService.getTypeForName(TypesService.BOOLEAN_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XNullLiteral object) {
		return typesService.getTypeForName(TypesService.VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XIntLiteral object) {
		return typesService.getTypeForName(TypesService.INTEGER_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XStringLiteral object) {
		return typesService.getTypeForName(TypesService.STRING_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XClosure object) {
		JvmTypeReference returnType = getType(object.getExpression());
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

	protected JvmTypeReference _type(XCastedExpression object) {
		return object.getType();
	}

	protected JvmTypeReference _type(XForLoopExpression object) {
		return typesService.getTypeForName(TypesService.VOID_TYPE_NAME, object);		
	}

	protected JvmTypeReference _type(XAbstractWhileExpression object) {
		return typesService.getTypeForName(TypesService.VOID_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XTypeLiteral object) {
		JvmParameterizedTypeReference typeRef = factory.createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		return typesService.getTypeForName(TypesService.JAVA_LANG_CLASS, object, typeRef);
	}

	protected JvmTypeReference _type(XInstanceOfExpression object) {
		return typesService.getTypeForName(TypesService.BOOLEAN_TYPE_NAME, object);
	}

	protected JvmTypeReference _type(XThrowExpression object) {
		return typesService.getTypeForName(TypesService.VOID_TYPE_NAME, object);
	}
	
	protected JvmTypeReference _type(XTryCatchFinallyExpression object) {
		return getType(object.getExpression());
	}

	protected JvmTypeReference _type(XCatchClause object) {
		return getType(object.getExpression());
	}
	
	@Override
	protected JvmTypeReference _type(JvmFormalParameter parameter) {
		if (parameter.getParameterType()==null) {
			if (parameter.eContainer() instanceof XForLoopExpression) {
				//TODO infer type from iterable
//				XForLoopExpression forLoop = (XForLoopExpression) parameter.eContainer();
//				JvmParameterizedTypeReference reference = (JvmParameterizedTypeReference) internalGetType(forLoop.getForExpression());
//				reference.getArguments()
			}
		}
		return super._type(parameter);
	}
	
	public TypesFactory getTypesFactory() {
		return factory;
	}

	public TypesService getTypesService() {
		return typesService;
	}
	
}
