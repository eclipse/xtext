/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnboundReference extends LightweightTypeReference {

	private LightweightTypeReference resolvedTo;
	private final JvmTypeParameter typeParameter;
	private final Object handle;
	
	protected UnboundReference(TypeReferenceOwner owner, JvmTypeParameter typeParameter, Object handle) {
		super(owner);
		this.typeParameter = typeParameter;
		this.handle = handle;
	}

	@Override
	public JvmTypeReference toTypeReference() {
		if (resolvedTo != null) {
			return resolvedTo.toTypeReference();
		}
		XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
		result.setTypeProvider(new AbstractReentrantTypeReferenceProvider() {
			@Override
			protected JvmTypeReference doGetTypeReference() {
				if (resolvedTo != null) {
					resolve();
				}
				return resolvedTo.toTypeReference();
			}
		});
		return result;
	}
	
	protected void resolve() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Always copies the reference since we want to reduce the nesting iff the
	 * reference was resolved and we have to copy it if the reference is not 
	 * yet resolved.
	 */
	@Override
	protected LightweightTypeReference copyInto(TypeReferenceOwner owner) {
		return doCopyInto(owner);
	}
	
	@Override
	public boolean isResolved() {
		if (resolvedTo != null) {
			return resolvedTo.isResolved();
		}
		return false;
	}

	@Override
	protected LightweightTypeReference doCopyInto(TypeReferenceOwner owner) {
		if (resolvedTo != null) {
			return resolvedTo.copyInto(owner);
		}
		UnboundReference result = new UnboundReference(owner, typeParameter, handle);
		return result;
	}

	@Override
	public String toString() {
		if (resolvedTo != null) {
			return resolvedTo.toString();
		}
		return "Unbound <" + typeParameter + ">";
	}

}
