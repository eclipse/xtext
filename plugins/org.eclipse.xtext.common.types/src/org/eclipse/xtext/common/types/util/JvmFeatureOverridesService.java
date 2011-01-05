/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Iterables.*;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureOverridesService {

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private TypeArgumentContext.Provider contextProvider;
	
	protected JvmFeatureOverridesService() {}
	public JvmFeatureOverridesService(SuperTypeCollector superTypeCollector, TypeArgumentContext.Provider contextProvider) {
		this.superTypeCollector = superTypeCollector;
		this.contextProvider = contextProvider;
	}
	
	public Iterable<JvmFeature> getAllJvmFeatures(JvmTypeReference type) {
		TypeArgumentContext context = contextProvider.get(type);
		return getAllJvmFeatures((JvmDeclaredType)type.getType(), context);
	}
	
	public Iterable<JvmFeature> getAllJvmFeatures(JvmDeclaredType type, TypeArgumentContext ctx) {
		Iterable<JvmFeature> result = filter(type.getMembers(),JvmFeature.class);
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(type);
		for (JvmTypeReference jvmTypeReference : types) {
			JvmType jvmType = jvmTypeReference.getType();
			if (jvmType instanceof JvmDeclaredType) {
				Iterable<JvmFeature> declaredMembers = filter(((JvmDeclaredType) jvmType).getMembers(),JvmFeature.class);
				result = Iterables.concat(result, declaredMembers);
			}
		}
		return removeOverridden(result, ctx);
	}

	protected Iterable<JvmFeature> removeOverridden(Iterable<JvmFeature> result, TypeArgumentContext ctx) {
		Set<JvmFeature> operation = Sets.newHashSet(result);
		for (JvmFeature op1 : result) {
			for (JvmFeature op2 : result) {
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

	public boolean isOverridden(JvmFeature overriding, JvmFeature overridden, TypeArgumentContext context) {
		if (overridden.getClass() != overriding.getClass())
			return false;
		if (!isNameEqual(overriding, overridden))
			return false;
		if (!isInheritanceRelation(overriding, overridden))
			return false;
		if (overriding instanceof JvmOperation && overridden instanceof JvmOperation) {
			JvmOperation overridingOp = (JvmOperation) overriding;
			JvmOperation overriddenOp = (JvmOperation) overridden;
			if (!isSameNumberOfArguments(overridingOp, overriddenOp))
				return false;
			if (!isSameArgumentTypes(overridingOp, overriddenOp, context))
				return false;
		}
		if (overriding instanceof JvmField && overridden instanceof JvmField) {
			JvmField overridingField = (JvmField) overriding;
			JvmField overriddenField = (JvmField) overridden;
			if (overridingField.isStatic() != overriddenField.isStatic())
				return false;
		}
		return true;
	}

	protected boolean isNameEqual(JvmFeature overriding, JvmFeature overridden) {
		return overriding.getSimpleName().equals(overridden.getSimpleName());
	}

	protected boolean isSameNumberOfArguments(JvmOperation overriding, JvmOperation overridden) {
		return overriding.getParameters().size() == overridden.getParameters().size();
	}
	
	protected boolean isSameArgumentTypes(JvmOperation overriding, JvmOperation overridden, TypeArgumentContext context) {
		for (int i = 0; i < overriding.getParameters().size(); i++) {
			JvmFormalParameter overridingParam = overriding.getParameters().get(i);
			JvmFormalParameter overriddenParam = overridden.getParameters().get(i);
			JvmTypeReference overridingType = context.resolveContravariant(overridingParam.getParameterType());
			JvmTypeReference overriddenType = context.resolveContravariant(overriddenParam.getParameterType());
			if (!EcoreUtil.equals(overridingType, overriddenType))
				return false;
		}
		return true;
	}

	protected boolean isInheritanceRelation(JvmMember overriding, JvmMember overridden) {
		return superTypeCollector.isSuperType(overriding.getDeclaringType(), overridden.getDeclaringType());
	}
}
