/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SynonymTypesProvider {
	
	@Inject
	private TypeReferences typeReferences;

	@NonNullByDefault
	public static abstract class Acceptor {
		/**
		 * @return <code>true</code> if the client is interested in more synonyms. <code>false</code> to skip
		 *   further computation.
		 */
		protected boolean accept(LightweightTypeReference synonym, ConformanceHint hint) {
			return accept(synonym, EnumSet.of(hint));
		}
		/**
		 * @return <code>true</code> if the client is interested in more synonyms. <code>false</code> to skip
		 *   further computation.
		 */
		protected abstract boolean accept(LightweightTypeReference synonym, Set<ConformanceHint> hints);
	}
	
	public void collectSynonymTypes(@Nullable LightweightTypeReference type, @NonNull Acceptor acceptor) {
		if (type == null || type.isPrimitiveVoid() || type.isType(Void.class)) {
			return;
		}
		if (type.isWrapper()) {
			if (!acceptor.accept(type.getPrimitiveIfWrapperType(), ConformanceHint.UNBOXING)) {
				return;
			}
		} else if (type.isPrimitive()) {
			if (!acceptor.accept(type.getWrapperTypeIfPrimitive(), ConformanceHint.BOXING)) {
				return;
			}
		}
		addArrayAndListSynonyms(type, acceptor);
	}

	@NonNullByDefault
	protected void addArrayAndListSynonyms(LightweightTypeReference type, Acceptor acceptor) {
		if (type.isArray()) {
			LightweightTypeReference listType = type.tryConvertToListType();
			if (listType != null) {
				LightweightTypeReference componentType = type.getComponentType();
				if (componentType == null) {
					throw new IllegalStateException("Component type of an array may not be null");
				}
				if (componentType.isPrimitive()) {
					if (!acceptor.accept(listType, EnumSet.of(ConformanceHint.DEMAND_CONVERSION, ConformanceHint.BOXING))) {
						return;
					}
				} else {
					if (!acceptor.accept(listType, ConformanceHint.DEMAND_CONVERSION)) {
						return;
					}
				}
			}
		} else if (type instanceof ParameterizedTypeReference) {
			ArrayTypeReference arrayType = type.tryConvertToArray();
			if (arrayType != null) {
				LightweightTypeReference componentType = arrayType.getComponentType();
				if (componentType.isWrapper()) {
					LightweightTypeReference primitiveComponentType = componentType.getPrimitiveIfWrapperType();
					ArrayTypeReference primitiveArray = new ArrayTypeReference(type.getOwner(), primitiveComponentType);
					if (!acceptor.accept(primitiveArray, EnumSet.of(ConformanceHint.DEMAND_CONVERSION, ConformanceHint.UNBOXING))) {
						return;
					}
				}
				if (!acceptor.accept(arrayType, ConformanceHint.DEMAND_CONVERSION)) {
					return;
				}
			}
		}
	}
	
}
