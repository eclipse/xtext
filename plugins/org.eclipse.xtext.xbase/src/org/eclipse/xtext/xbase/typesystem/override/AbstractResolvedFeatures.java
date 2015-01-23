/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collection;
import java.util.LinkedList;

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
	
	protected boolean isOverridden(JvmOperation operation, Collection<AbstractResolvedOperation> processedOperations) {
		for(AbstractResolvedOperation processed: processedOperations) {
			if (overrideTester.isSubsignature(processed, operation, false).isOverridingOrImplementing()) {
				return true;
			}
		}
		return false;
	}
	
	protected AbstractResolvedOperation getConflictingDefault(IResolvedOperation operation,
			Collection<AbstractResolvedOperation> processedOperations) {
		String operationSignature = operation.getResolvedErasureSignature();
		for (AbstractResolvedOperation processed : processedOperations) {
			if (operationSignature.equals(processed.getResolvedErasureSignature())
					&& isConflictingDefaultImplementation(operation.getDeclaration(), processed.getDeclaration())) {
				return processed;
			}
		}
		return null;
	}
	
	private boolean isConflictingDefaultImplementation(JvmOperation operation1, JvmOperation operation2) {
		return isInterface(operation1.getDeclaringType()) && isInterface(operation2.getDeclaringType())
			&& (!operation1.isAbstract() || !operation2.isAbstract())
			&& !isSameOrSuper(operation2.getDeclaringType(), operation1.getDeclaringType())
			&& !isSameOrSuper(operation1.getDeclaringType(), operation2.getDeclaringType());
	}
	
	private boolean isSameOrSuper(JvmDeclaredType subType, JvmDeclaredType superType) {
		LinkedList<JvmDeclaredType> typeQueue = new LinkedList<JvmDeclaredType>();
		typeQueue.add(subType);
		do {
			JvmDeclaredType type = typeQueue.removeFirst();
			if (type == superType)
				return true;
			for (JvmTypeReference typeRef : type.getSuperTypes()) {
				if (typeRef.getType() instanceof JvmDeclaredType)
					typeQueue.add((JvmDeclaredType) typeRef.getType());
			}
		} while (!typeQueue.isEmpty());
		return false;
	}

	private boolean isInterface(JvmDeclaredType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
	}
	
	protected BottomResolvedOperation createResolvedOperation(JvmOperation operation) {
		return new BottomResolvedOperation(operation, type, overrideTester);
	}
	
	protected DefaultConflictResolvedOperation createResolvedOperation(JvmOperation operation, IResolvedOperation conflictingOperation) {
		return new DefaultConflictResolvedOperation(operation, type, overrideTester, conflictingOperation);
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
