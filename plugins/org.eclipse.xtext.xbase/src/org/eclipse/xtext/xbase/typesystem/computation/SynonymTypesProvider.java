/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.EnumSet;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * The {@link SynonymTypesProvider} allows to define automatic conversion rules
 * for specific types. 
 * 
 * By default, {@link Iterable iterables} are compatible to arrays, arrays are compatible to {@link List},
 * and boxing / unboxing semantics are applied.
 * 
 * Clients who specialize this service, should announce synonym types by means of
 * {@link #announceSynonym(LightweightTypeReference, ConformanceHint, Acceptor)} or
 * {@link #announceSynonym(LightweightTypeReference, EnumSet, Acceptor)}. 
 * {@link #collectCustomSynonymTypes(LightweightTypeReference, Acceptor)} should be implemented
 * to announce custom synonyms. Implementations should respect the acceptor return values.
 * 
 * @see ArrayTypes
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SynonymTypesProvider {
	
	/**
	 * Clients of the {@link SynonymTypesProvider} may use a custom acceptor
	 * to handle the available synonym types.
	 * 
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	@NonNullByDefault
	public static abstract class Acceptor {
		/**
		 * @return <code>true</code> if the client is interested in more synonyms. <code>false</code> to skip
		 *   further computation.
		 */
		protected boolean accept(LightweightTypeReference synonym, ConformanceHint hint) {
			return accept(synonym, EnumSet.of(hint, ConformanceHint.SUCCESS, ConformanceHint.CHECKED));
		}
		/**
		 * @return <code>true</code> if the client is interested in more synonyms. <code>false</code> to skip
		 *   further computation.
		 */
		protected abstract boolean accept(LightweightTypeReference synonym, EnumSet<ConformanceHint> hints);
	}
	
	public void collectSynonymTypes(@Nullable LightweightTypeReference type, @NonNull Acceptor acceptor) {
		if (type == null || type.isPrimitiveVoid() || type.isType(Void.class)) {
			return;
		}
		if (type.isWrapper()) {
			if (!acceptor.accept(type.getPrimitiveIfWrapperType(), ConformanceHint.UNBOXING)) {
				return;
			}
			// a primitive type is never an array or list
			collectCustomSynonymTypes(type, acceptor);
			return;
		} else if (type.isPrimitive()) {
			if (!acceptor.accept(type.getWrapperTypeIfPrimitive(), ConformanceHint.BOXING)) {
				return;
			}
			// a primitive type is never an array or list
			collectCustomSynonymTypes(type, acceptor);
			return;
		}
		if (addArrayAndListSynonyms(type, acceptor)) {
			collectCustomSynonymTypes(type, acceptor);
		}
	}

	/**
	 * This is the hook to announce more synonym types.
	 * @param type the original type
	 * @param acceptor the acceptor to announce the synonyms
	 */
	protected boolean collectCustomSynonymTypes(LightweightTypeReference type, Acceptor acceptor) {
		return true;
	}

	/**
	 * @param type never a primitive or a wrapper type
	 */
	@NonNullByDefault
	protected boolean addArrayAndListSynonyms(LightweightTypeReference type, Acceptor acceptor) {
		if (type.isArray()) {
			LightweightTypeReference listType = type.tryConvertToListType();
			if (listType != null) {
				LightweightTypeReference componentType = type.getComponentType();
				if (componentType == null) {
					throw new IllegalStateException("Component type of an array may not be null");
				}
				if (componentType.isPrimitive()) {
					if (!acceptor.accept(listType, EnumSet.of(ConformanceHint.DEMAND_CONVERSION, ConformanceHint.BOXING))) {
						return false;
					}
				} else {
					if (!acceptor.accept(listType, ConformanceHint.DEMAND_CONVERSION)) {
						return false;
					}
				}
			}
		} else {
			ArrayTypeReference arrayType = type.tryConvertToArray();
			if (arrayType != null) {
				LightweightTypeReference componentType = arrayType.getComponentType();
				LightweightTypeReference primitiveComponentType = componentType.getPrimitiveIfWrapperType();
				if (primitiveComponentType != componentType) {
					ArrayTypeReference primitiveArray = new ArrayTypeReference(type.getOwner(), primitiveComponentType);
					if (!acceptor.accept(primitiveArray, EnumSet.of(ConformanceHint.DEMAND_CONVERSION, ConformanceHint.UNBOXING))) {
						return false;
					}
				}
				if (!acceptor.accept(arrayType, ConformanceHint.DEMAND_CONVERSION)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Announce a synonym type with the given conformance hint.
	 */
	protected final boolean announceSynonym(LightweightTypeReference synonym, ConformanceHint hint, Acceptor acceptor) {
		return acceptor.accept(synonym, hint);
	}
	
	/**
	 * Announce a synonym type with the given conformance hints.
	 */
	protected final boolean announceSynonym(LightweightTypeReference synonym, EnumSet<ConformanceHint> hints, Acceptor acceptor) {
		return acceptor.accept(synonym, hints);
	}
	
}
