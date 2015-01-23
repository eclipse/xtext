/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collection;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractResolvedFeatures {

	private final LightweightTypeReference type;
	private final OverrideTester overrideTester;

	protected AbstractResolvedFeatures(LightweightTypeReference type, OverrideTester overrideTester) {
		this.type = type;
		this.overrideTester = overrideTester;
	}
	
	/**
	 * Determine whether the given {@code operation} is overridden by any of the {@code processedOperations}.
	 * The {@code operation} must not belong to a subtype of any declaring type of the {@code processedOperations},
	 * but the types declaring the {@code processedOperations} may be subtypes of the type declaring {@code operation}.
	 */
	protected boolean isOverridden(JvmOperation operation, Collection<AbstractResolvedOperation> processedOperations) {
		for(AbstractResolvedOperation processed: processedOperations) {
			if (!isConflictingDefaultImplementation(operation, processed.getDeclaration())
					&& overrideTester.isSubsignature(processed, operation, false).isOverridingOrImplementing()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Generally it is ok for superinterfaces to declare the same methods. But if any of these methods with equal
	 * signature have a default implementation, that leads to a conflict for the inheriting type. In such a case
	 * the conflicting methods should not be marked as overriding each other.
	 */
	private boolean isConflictingDefaultImplementation(JvmOperation operation1, JvmOperation operation2) {
		return isInterface(operation1.getDeclaringType()) && isInterface(operation2.getDeclaringType())
			&& (!operation1.isAbstract() || !operation2.isAbstract())
			&& !isSameOrSuper(operation2.getDeclaringType(), operation1.getDeclaringType());
	}
	
	private boolean isSameOrSuper(JvmDeclaredType subType, JvmDeclaredType superType) {
		if (subType == superType)
			return true;
		for (JvmTypeReference typeRef : subType.getSuperTypes()) {
			if (typeRef.getType() instanceof JvmDeclaredType
					&& isSameOrSuper((JvmDeclaredType) typeRef.getType(), superType))
				return true;
		}
		return false;
	}

	private boolean isInterface(JvmDeclaredType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}
	
	protected BottomResolvedOperation createResolvedOperation(JvmOperation operation) {
		return new BottomResolvedOperation(operation, type, overrideTester);
	}
	
	protected BottomResolvedOperation createResolvedOperation(JvmOperation operation, LightweightTypeReference context) {
		return new BottomResolvedOperation(operation, context, overrideTester);
	}

	public LightweightTypeReference getType() {
		return type;
	}
	
	protected JvmType getRawType() {
		return type.getType();
	}

}
