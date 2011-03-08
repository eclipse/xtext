/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.typing;

import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.xtend2.DeclaredDependency;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Xtend2TypeProvider extends XbaseTypeProvider {

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Inject
	private FeatureOverridesService featureOverridesService;

	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION) {
			JvmTypeReference declaredOrInferredReturnType = getDeclaredOrOverriddenReturnType(function);
			if (declaredOrInferredReturnType == null || getTypeReferences().is(declaredOrInferredReturnType, Void.TYPE))
				return null;
			return function.getReturnType();
		}
		return null;
	}
	
	@Override
	protected JvmTypeReference _expectedType(XReturnExpression expr, EReference reference, int index, boolean rawType) {
		XtendFunction function = EcoreUtil2.getContainerOfType(expr, XtendFunction.class);
		if (function==null)
			return null;
		return _expectedType(function, Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION,0,rawType);
	}
	
	@Override
	protected JvmTypeReference _type(XAbstractFeatureCall featureCall, boolean rawType) {
		// This is to prevent resolution of local TypeParameters, because they should be treated as resolved.
		if (featureCall.getFeature() instanceof JvmFormalParameter) {
			return getTypeForIdentifiable(featureCall.getFeature(), rawType);
		}
		return super._type(featureCall, rawType);
	}

	protected JvmTypeReference _type(RichString richString, boolean rawType) {
		return getTypeReferences().getTypeForName(StringConcatenation.class, richString);
	}

	protected JvmTypeReference _type(RichStringLiteral stringLiteral, boolean rawType) {
		return getTypeReferences().getTypeForName(String.class, stringLiteral);
	}
	
	protected JvmTypeReference _type(RichStringIf richStringIf, boolean rawType) {
		return getTypeReferences().getTypeForName(String.class, richStringIf);
	}
	
	protected JvmTypeReference _type(RichStringForLoop richStringFor, boolean rawType) {
		return getTypeReferences().getTypeForName(String.class, richStringFor);
	}
	
	protected JvmTypeReference _expectedType(RichStringIf container, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.class, container);
		}
		return getTypeReferences().getTypeForName(StringConcatenation.class, container);
	}
	
	protected JvmTypeReference _expectedType(RichStringElseIf container, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.class, container);
		}
		return getTypeReferences().getTypeForName(StringConcatenation.class, container);
	}

	protected JvmTypeReference _expectedType(RichStringForLoop expr, EReference reference, int index, boolean rawType) {
		// see also _expectedType(XForLoop..)
		// Unless we can have multiple possible expected types (i.e. array and iterable), we shouldn't expect anything here
		// The conformance test is done explicitly in the validator.
		return null; // no expectations
	}

	protected JvmTypeReference _typeForIdentifiable(XtendClass clazz, boolean rawType) {
		JvmParameterizedTypeReference typeReference = getTypesFactory().createJvmParameterizedTypeReference();
		typeReference.setType(xtend2jvmAssociations.getInferredType(clazz));
		return typeReference;
	}

	protected JvmTypeReference _typeForIdentifiable(XtendFunction func, boolean rawType) {
		JvmTypeReference declaredOrInferredReturnType = getDeclaredOrOverriddenReturnType(func);
		if (declaredOrInferredReturnType != null)
			return declaredOrInferredReturnType;
		JvmTypeReference returnType = getCommonReturnType(func.getExpression(), true);
		if (returnType!=null) {
			JvmOperation operation = xtend2jvmAssociations.getDirectlyInferredOperation(func);
			if (operation == null)
				return null;
			JvmDeclaredType type = operation.getDeclaringType();
			for(JvmTypeReference reference: Iterables.filter(EcoreUtil2.eAllContents(returnType), JvmTypeReference.class)) {
				if (reference.getType() instanceof JvmTypeParameter) {
					JvmTypeParameter parameter = (JvmTypeParameter) reference.getType();
					if (!EcoreUtil.isAncestor(type, parameter)) {
						returnType = EcoreUtil2.cloneIfContained(returnType);
						Set<JvmTypeReference> replaceUs = Sets.newHashSet();
						for(JvmTypeReference containerOfReplaced: Iterables.filter(EcoreUtil2.eAllContents(returnType), JvmTypeReference.class)) {
							if (containerOfReplaced.getType() instanceof JvmTypeParameter)
								replaceUs.add(containerOfReplaced);
						}
						for(JvmTypeReference replaceMe: replaceUs) {
							if (replaceMe.eContainer() instanceof JvmTypeConstraint) {
								JvmTypeConstraint containerConstraint = (JvmTypeConstraint) replaceMe.eContainer();
								JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
								for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
									if (constraint.eClass() == containerConstraint.eClass()) {
										containerConstraint.setTypeReference(EcoreUtil2.clone(constraint.getTypeReference()));
										break;
									}
								}
							} else {
								JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
								JvmWildcardTypeReference wildCard = getTypeReferences().wildCard();
								for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
									wildCard.getConstraints().add(EcoreUtil2.clone(constraint));
								}
								EcoreUtil.replace(replaceMe, wildCard);
							}
						}
						return returnType;
					}
				}
			}
			return returnType;
		}
		return getTypeReferences().getTypeForName(Object.class, func);
	}
	
	protected JvmTypeReference _typeForIdentifiable(DeclaredDependency dependency, boolean rawType) {
		return dependency.getType();
	}

	protected JvmTypeReference getDeclaredOrOverriddenReturnType(XtendFunction func) {
		if (func.getReturnType() != null)
			return func.getReturnType();
		if (func.isOverride()) {
			JvmOperation inferredOperation = xtend2jvmAssociations.getDirectlyInferredOperation(func);
			if (inferredOperation == null)
				return null;
			JvmDeclaredType inferredType = inferredOperation.getDeclaringType();
			TypeArgumentContext typeArgumentContext = getTypeArgumentContextProvider().getReceiverContext(getTypeReferences()
					.createTypeRef(inferredType));
			JvmTypeReference superType = func.getDeclaringType().getExtends();
			if (superType != null) {
				for (JvmFeature superFeature : featureOverridesService.getAllJvmFeatures(superType)) {
					if (superFeature instanceof JvmOperation) {
						JvmOperation superOperation = (JvmOperation) superFeature;
						if (featureOverridesService.isOverridden(inferredOperation, superOperation,
								typeArgumentContext, false))
							return superOperation.getReturnType();
					}
				}
			}
		}
		return null;
	}

	protected JvmTypeReference _typeForIdentifiable(JvmGenericType type, boolean rawType) {
		XtendClass xtendClass = xtend2jvmAssociations.getXtendClass(type);
		return (xtendClass != null) ? _typeForIdentifiable(xtendClass, rawType) : null;
	}
	
}
