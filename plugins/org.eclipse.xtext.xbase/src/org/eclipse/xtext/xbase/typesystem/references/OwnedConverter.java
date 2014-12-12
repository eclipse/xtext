/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.lang.reflect.WildcardType;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use the {@link ITypeReferenceOwner owner's API} or the {@link LightweightTypeReferenceFactory} instead. 
 */
@Deprecated
public class OwnedConverter extends LightweightTypeReferenceFactory implements Function<JvmTypeReference, LightweightTypeReference> {

	/**
.	 * Creates a new owned converter with proper substitution of unbound wildcards.
	 * Equivalent to <code>new OwnedConverter(owner, false)</code>.
	 */
	public OwnedConverter(ITypeReferenceOwner owner) {
		this(owner, false);
	}
	
	/**
	 * @param keepUnboundWildcards <code>true</code> if unbound wildcards should be converted to <code>? extends Object</code>.
	 *   Unbound information is required to do proper cast validation. In other cases, the compiler should
	 *   add the upper bound object.
	 *   
	 * @see WildcardType#getUpperBounds()
	 * 
	 */
	public OwnedConverter(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		super(owner, keepUnboundWildcards);
	}
	
	@Override
	public LightweightTypeReference apply(JvmTypeReference reference) {
		return toLightweightReference(reference);
	}
	
	public LightweightTypeReference toRawLightweightReference(JvmType type) {
		return toPlainTypeReference(type);
	}
	
}

