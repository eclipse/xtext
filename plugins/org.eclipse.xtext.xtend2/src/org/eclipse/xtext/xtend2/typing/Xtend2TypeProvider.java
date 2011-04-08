/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.typing;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo;
import org.eclipse.xtext.xtend2.xtend2.DeclaredDependency;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendClassSuperCallReferable;
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
	private XtendOverridesService overridesService;
	
	protected JvmTypeReference _expectedType(XtendFunction function, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.XTEND_FUNCTION__EXPRESSION) {
			if (function.getCreateExtensionInfo()!=null)
				return getTypeReferences().getTypeForName(Void.TYPE, function);
			JvmTypeReference declaredOrInferredReturnType = getDeclaredOrOverriddenReturnType(function);
			if (declaredOrInferredReturnType == null || getTypeReferences().is(declaredOrInferredReturnType, Void.TYPE))
				return null;
			return declaredOrInferredReturnType;
		}
		return null;
	}
	
	@Override
	protected JvmTypeReference _expectedType(XReturnExpression expr, EReference reference, int index, boolean rawType) {
		if (EcoreUtil2.getContainerOfType(expr, XClosure.class)!=null)
			return super._expectedType(expr, reference, index, rawType);
		XtendFunction function = EcoreUtil2.getContainerOfType(expr, XtendFunction.class);
		if (function==null)
			return null;
		if (function.getCreateExtensionInfo()!=null) {
			if (EcoreUtil.isAncestor(function.getCreateExtensionInfo().getCreateExpression(), expr))
				return null;
		}
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
		return getTypeReferences().getTypeForName(StringConcatenation.class, richStringIf);
	}
	
	protected JvmTypeReference _type(RichStringForLoop richStringFor, boolean rawType) {
		return getTypeReferences().getTypeForName(StringConcatenation.class, richStringFor);
	}
	
	protected JvmTypeReference _expectedType(RichStringIf container, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.TYPE, container);
		}
		return getTypeReferences().getTypeForName(StringConcatenation.class, container);
	}
	
	protected JvmTypeReference _expectedType(RichStringElseIf container, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF) {
			return getTypeReferences().getTypeForName(Boolean.TYPE, container);
		}
		return getTypeReferences().getTypeForName(StringConcatenation.class, container);
	}

	protected JvmTypeReference _expectedType(RichStringForLoop expr, EReference reference, int index, boolean rawType) {
		if (reference == Xtend2Package.Literals.RICH_STRING_FOR_LOOP__BEFORE
				|| reference == Xtend2Package.Literals.RICH_STRING_FOR_LOOP__SEPARATOR
				|| reference == Xtend2Package.Literals.RICH_STRING_FOR_LOOP__AFTER)
			return getTypeReferences().getTypeForName(Object.class, expr);
		return _expectedType((XForLoopExpression)expr, reference, index, rawType);
	}

	protected JvmTypeReference _typeForIdentifiable(XtendClass clazz, boolean rawType) {
		JvmParameterizedTypeReference typeReference = getTypesFactory().createJvmParameterizedTypeReference();
		typeReference.setType(xtend2jvmAssociations.getInferredType(clazz));
		return typeReference;
	}
	
	protected JvmTypeReference _typeForIdentifiable(XtendClassSuperCallReferable referable, boolean rawType) {
		final XtendClass xtendClass = referable.getXtendClass();
		JvmTypeReference superType = xtendClass.getExtends();
		if (superType!=null) {
			return superType;
		}
		return getTypeReferences().getTypeForName(Object.class, xtendClass);
	}
	
	protected JvmTypeReference _typeForIdentifiable(CreateExtensionInfo info, boolean rawType) {
		return getType(info.getCreateExpression(),rawType);
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
		if (func.getCreateExtensionInfo()!=null) {
			return getType(func.getCreateExtensionInfo().getCreateExpression());
		}
		if (func.getReturnType() != null)
			return func.getReturnType();
		return overridesService.getOverriddenReturnType(func);
	}

	protected JvmTypeReference _typeForIdentifiable(JvmGenericType type, boolean rawType) {
		XtendClass xtendClass = xtend2jvmAssociations.getXtendClass(type);
		return (xtendClass != null) ? _typeForIdentifiable(xtendClass, rawType) : null;
	}
	
	@Override
	public Iterable<JvmTypeReference> getThrownExceptionForIdentifiable(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmOperation) {
			final Set<EObject> associatedElements = xtend2jvmAssociations.getAssociatedElements(identifiable);
			if (associatedElements == null || associatedElements.isEmpty()) {
				return super.getThrownExceptionForIdentifiable(identifiable);
			}
			Iterable<JvmTypeReference> result = emptySet();
			for (EObject assocEle : associatedElements) {
				final XtendFunction xtendFunction = (XtendFunction) assocEle;
				final Iterable<JvmTypeReference> thrownExceptions = getThrownExceptions(xtendFunction);
				result = concat(result,thrownExceptions);
			}
			return result;
		}
		return super.getThrownExceptionForIdentifiable(identifiable);
	}

	protected Iterable<JvmTypeReference> getThrownExceptions(final XtendFunction xtendFunction) {
		Iterable<JvmTypeReference> thrownExceptionTypes = getThrownExceptionTypes(xtendFunction.getExpression());
		if (xtendFunction.getCreateExtensionInfo()==null) {
			return thrownExceptionTypes;
		}
		Iterable<JvmTypeReference> thrownExceptionTypesInCreateExpression = getThrownExceptionTypes(xtendFunction.getCreateExtensionInfo().getCreateExpression());
		return concat(thrownExceptionTypes,thrownExceptionTypesInCreateExpression);
	}
	
}
