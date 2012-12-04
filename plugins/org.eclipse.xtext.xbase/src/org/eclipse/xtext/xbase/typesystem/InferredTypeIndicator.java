/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InferredTypeIndicator implements IJvmTypeReferenceProvider {

	private boolean voidAllowed;
	private boolean resolved = false;

	public InferredTypeIndicator(boolean voidAllowed) {
		this.voidAllowed = voidAllowed;
	}

	public static boolean isInferred(JvmTypeReference typeReference) {
		if (typeReference instanceof XComputedTypeReference) {
			IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) typeReference).getTypeProvider();
			if (typeProvider instanceof InferredTypeIndicator && !((InferredTypeIndicator)typeProvider).resolved) {
				return true;
			}
		}
		return false;
	}
	
	public static void resolveTo(JvmTypeReference inferred, JvmTypeReference resolved) {
		if (isInferred(inferred)) {
			XComputedTypeReference casted = (XComputedTypeReference) inferred;
			casted.setEquivalent(resolved);
			((InferredTypeIndicator)casted.getTypeProvider()).resolved = true;
		} else {
			throw new IllegalStateException("Cannot resolve a reference that is not inferred");
		}
	}
	
	public JvmTypeReference getTypeReference(@NonNull XComputedTypeReferenceImplCustom context) {
		Resource resource = context.eResource();
		if (resource instanceof XtextResource) {
			IBatchTypeResolver typeResolver = ((XtextResource) resource).getResourceServiceProvider().get(IBatchTypeResolver.class);
			if (typeResolver == null) {
				throw new IllegalStateException("typeResolver may not be null");
			}
			typeResolver.resolveTypes(context);
		}
		if (context.eIsSet(TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT)) {
			return context.getEquivalent();
		}
		throw new IllegalStateException("equivalent could not be computed");
	}
	
	public boolean isVoidAllowed() {
		return voidAllowed;
	}
	
}
