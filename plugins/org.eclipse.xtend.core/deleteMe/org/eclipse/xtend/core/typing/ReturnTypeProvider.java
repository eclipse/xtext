/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typing;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * 
 * Computes the return type for {@link org.eclipse.xtend.core.xtend.XtendFunction}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class ReturnTypeProvider {
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private TypeConformanceComputer typeConformanceComputer;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private XtendOverridesService overridesService;
	
	public JvmTypeReference getDeclaredOrOverriddenReturnType(XtendFunction func) {
		if (func.getReturnType() != null)
			return func.getReturnType();
		if (func.isOverride()) {
			JvmTypeReference overridden = overridesService.getOverriddenReturnType(func);
			if (overridden != null)
				return overridden;
		}
		if (func.getCreateExtensionInfo()!=null) {
			return typeProvider.getType(func.getCreateExtensionInfo().getCreateExpression());
		}
		return null;
	}
	
	public JvmTypeReference computeReturnType(XtendFunction function) {
		JvmTypeReference declaredOrInferredReturnType = getDeclaredOrOverriddenReturnType(function);
		if (declaredOrInferredReturnType != null)
			return declaredOrInferredReturnType;
		
		XExpression returnTypeRelevantExpression = function.getCreateExtensionInfo() != null 
				? function.getCreateExtensionInfo().getCreateExpression()
				: function.getExpression();
		JvmTypeReference returnType =  typeProvider.getCommonReturnType(returnTypeRelevantExpression, true);
		
		if (returnType!=null && returnType.getType() != null) {
			JvmOperation operation = associations.getDirectlyInferredOperation(function);
			if (operation == null)
				return null;
			JvmDeclaredType declaringType = operation.getDeclaringType();
			for(JvmTypeReference reference: Iterables.filter(EcoreUtil2.eAllContents(returnType), JvmTypeReference.class)) {
				if (reference.getType() instanceof JvmTypeParameter) {
					JvmTypeParameter parameter = (JvmTypeParameter) reference.getType();
					if (parameter.getDeclarator() != declaringType && parameter.getDeclarator() != operation) {
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
							} else if (replaceMe.eContainer() != null) {
								JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
								JvmWildcardTypeReference wildCard = typeReferences.wildCard();
								for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
									wildCard.getConstraints().add(EcoreUtil2.clone(constraint));
								}
								EcoreUtil.replace(replaceMe, wildCard);
							} else {
								JvmConstraintOwner constraintOwner = (JvmConstraintOwner) replaceMe.getType();
								List<JvmTypeReference> superTypes = Lists.newArrayListWithExpectedSize(constraintOwner.getConstraints().size());
								for(JvmTypeConstraint constraint: constraintOwner.getConstraints()) {
									if (constraint instanceof JvmUpperBound) {
										superTypes.add(constraint.getTypeReference());
									}
								}
								if (superTypes.isEmpty())
									return typeReferences.getTypeForName(Object.class, function);
								return typeConformanceComputer.getCommonSuperType(superTypes);
							}
						}
						return returnType;
					}
				}
			}
			return returnType;
		}
		return typeReferences.getTypeForName(Object.class, function);
	}
}
