/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class LocalVariableCapturer implements IJvmTypeReferenceProvider {

	private boolean captured = true;
	private final JvmTypeReference equivalent;
	
	protected LocalVariableCapturer(JvmTypeReference equivalent) {
		this.equivalent = equivalent;
	}
	
	protected static <R extends LocalVariableCapturer> R findLocalClassSupertype(JvmDeclaredType type) {
		List<JvmTypeReference> superTypes = type.getSuperTypes();
		if (superTypes.size() != 1) {
			return null;
		}
		return findLocalClassSupertype(superTypes.get(0));
	}

	protected static <R extends LocalVariableCapturer> R findLocalClassSupertype(JvmTypeReference typeReference) {
		if (InferredTypeIndicator.isInferred(typeReference)) {
			JvmTypeReference equivalent = ((XComputedTypeReference) typeReference).getEquivalent();
			return findLocalClassSupertype(equivalent);
		}
		if (typeReference instanceof XComputedTypeReference) {
			IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) typeReference).getTypeProvider();
			if (typeProvider instanceof LocalVariableCapturer) {
				@SuppressWarnings("unchecked")
				R result = (R) typeProvider;
				return result;
			}
		}
		return null;
	}
	
	public static void captureLocalVariables(JvmDeclaredType localType, ITypeComputationState state) {
		captureLocalVariables(localType.getSuperTypes().get(0), state);
	}
	
	public static void captureLocalVariables(JvmTypeReference typeReference, ITypeComputationState state) {
		LocalVariableCapturer localClassSupertype = findLocalClassSupertype(typeReference);
		if (localClassSupertype != null) {
			if (!localClassSupertype.captured) {
				localClassSupertype.captured = true;
				localClassSupertype.capture(state);
			}
			return;
		}
		throw new IllegalStateException("Unexpected typeReference: " + typeReference);
	}
	
	protected void awaitCapturing() {
		captured = false;
	}
	
	protected abstract void capture(ITypeComputationState state);
	
	public JvmTypeReference getTypeReference(@NonNull XComputedTypeReferenceImplCustom context) {
		if (!captured) {
			throw new IllegalStateException("Not yet captured but navigated: " + this);
		}
		return equivalent;
	}
	
	public JvmTypeReference getEquivalent() {
		return equivalent;
	}
	
	@Override
	public String toString() {
		return String.format("LocalClassSupertype[captured=%s, equivalent=%s]", captured, equivalent);
	}
	
}

