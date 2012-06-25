/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO move this one to tests if everything worked out as expected
 */
public class RootResolvedTypes extends ResolvedTypes {

	protected RootResolvedTypes(DefaultReentrantTypeResolver resolver) {
		super(resolver);
	}

	@Override
	protected Multimap<XExpression, TypeData> createExpressionTypesMap() {
		final Multimap<XExpression, TypeData> result = super.createExpressionTypesMap();
		return new ForwardingMultimap<XExpression, TypeData>() {
			@Override
			protected Multimap<XExpression, TypeData> delegate() {
				return result;
			}
			
			protected void assertOwner(LightweightTypeReference typeReference) {
				if (typeReference != null) {
					if (!typeReference.isOwnedBy(RootResolvedTypes.this)) {
						throw new IllegalArgumentException("type is associated with an incompatible owner");
					}
				}
			}
			
			@Override
			public boolean put(XExpression key, TypeData value) {
				assertOwner(value);
				return super.put(key, value);
			}

			protected void assertOwner(TypeData typeData) {
				assertOwner(typeData.getActualType());
				if (typeData.getExpectation() != null)
					assertOwner(typeData.getExpectation().internalGetExpectedType());
			}
			
			@Override
			public boolean putAll(Multimap<? extends XExpression, ? extends TypeData> multimap) {
				for(TypeData typeData: multimap.values()) {
					assertOwner(typeData);
				}
				return super.putAll(multimap);
			}
			
			@Override
			public boolean putAll(XExpression key, Iterable<? extends TypeData> values) {
				for(TypeData typeData: values) {
					assertOwner(typeData);
				}
				return super.putAll(key, values);
			}
		};
	}
	
	@Override
	@NonNull
	protected RootUnboundTypeReference getUnboundTypeReference(@NonNull Object handle) {
		return (RootUnboundTypeReference) super.getUnboundTypeReference(handle);
	}

}
