/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MethodOverrideService {

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	protected MethodOverrideService() {}
	public MethodOverrideService(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
	}
	
	public Iterable<JvmOperation> getAllMethods(JvmDeclaredType type, TypeArgumentContext ctx) {
		Iterable<JvmOperation> result = type.getDeclaredOperations();
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(type);
		for (JvmTypeReference jvmTypeReference : types) {
			JvmType jvmType = jvmTypeReference.getType();
			if (jvmType instanceof JvmDeclaredType) {
				Iterable<JvmOperation> declaredOperations = ((JvmDeclaredType) jvmType).getDeclaredOperations();
				result = Iterables.concat(result, Iterables.filter(declaredOperations, new Predicate<JvmOperation>() {
					public boolean apply(JvmOperation input) {
						return isVisible(input);
					}
				}));
			}
		}
		return removeOverridden(result, ctx);
	}

	protected Iterable<JvmOperation> removeOverridden(Iterable<JvmOperation> result, TypeArgumentContext ctx) {
		Set<JvmOperation> operation = Sets.newHashSet(result);
		for (JvmOperation op1 : result) {
			for (JvmOperation op2 : result) {
				if (isOverridden(op1, op2, ctx))
					operation.remove(op2);
			}
		}
		return operation;
	}

	protected Set<JvmOperation> collectOperations(JvmType type) {
		Set<JvmOperation> allOps = Sets.newHashSet();
		if (type instanceof JvmDeclaredType) {
			EList<JvmMember> members = ((JvmDeclaredType) type).getMembers();
			for (JvmMember jvmMember : members) {
				if (jvmMember instanceof JvmOperation) {
					allOps.add((JvmOperation) jvmMember);
				}
			}
		}
		return allOps;
	}

	public boolean isOverridden(JvmOperation overriding, JvmOperation overridden, TypeArgumentContext context) {
		if (!isNameEqual(overriding, overridden))
			return false;
		if (!isSameNumberOfArguments(overriding, overridden))
			return false;
		if (!isInheritanceRelation(overriding, overridden))
			return false;
		if (!isSameArgumentTypes(overriding, overridden, context))
			return false;
		return true;
	}

	protected boolean isVisible(JvmOperation overridden) {
		return overridden.getVisibility() != JvmVisibility.PRIVATE;
	}
	
	protected boolean isNameEqual(JvmOperation overriding, JvmOperation overridden) {
		return overriding.getSimpleName().equals(overridden.getSimpleName());
	}

	protected boolean isSameNumberOfArguments(JvmOperation overriding, JvmOperation overridden) {
		return overriding.getParameters().size() == overridden.getParameters().size();
	}
	
	protected boolean isSameArgumentTypes(JvmOperation overriding, JvmOperation overridden, TypeArgumentContext context) {
		for (int i = 0; i < overriding.getParameters().size(); i++) {
			JvmFormalParameter overridingParam = overriding.getParameters().get(i);
			JvmFormalParameter overriddenParam = overridden.getParameters().get(i);
			if (!EcoreUtil.equals(context.resolve(overridingParam.getParameterType()), context.resolve(overriddenParam.getParameterType())))
				return false;
		}
		return true;
	}

	protected boolean isInheritanceRelation(JvmOperation overriding, JvmOperation overridden) {
		return superTypeCollector.isSuperType(overriding.getDeclaringType(), overridden.getDeclaringType());
	}
}
