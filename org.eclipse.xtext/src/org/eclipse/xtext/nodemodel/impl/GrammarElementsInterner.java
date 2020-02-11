/*******************************************************************************
 * Copyright (c) 2019 Sigasi NV (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;

/**
 * Interner of arrays of grammar elements stored in the node model.
 * 
 * The node model contains nodes derived from {@link AbstractNode}.  An {@link AbstractNode} has an array describing its grammar 
 * elements.  This array is often identical for many {@link AbstractNode}s.  There can be millions of nodes in a node model
 * so it makes sense to remove the duplicate arrays.  This {@link GrammarElementsInterner} tries to reuse an interned version of such an array
 * wherever possible
 */

public class GrammarElementsInterner {

	private static class InternKey {
		final EObject grammarElement;
		final Object grammarElements;
		
		int hashCode = -1;

		InternKey(EObject grammarElement, Object grammarElements) {
			this.grammarElement = grammarElement;
			this.grammarElements = grammarElements;
		}
		
		EObject[] prependedGrammarElements() {
			if(grammarElements instanceof EObject) {
				return new EObject[] {grammarElement, (EObject) grammarElements};
			} else {
				return ObjectArrays.concat(grammarElement, (EObject[]) grammarElements);
			}
		}
		
		EObject[] appendedGrammarElements() {
			if(grammarElements instanceof EObject) {
				return new EObject[] {(EObject) grammarElements, grammarElement };
			} else {
				return ObjectArrays.concat((EObject[]) grammarElements, grammarElement);
			}
		}


		@Override
		public int hashCode() {
			if (hashCode == -1)
				hashCode = Objects.hash(grammarElement, grammarElements);
			return hashCode;
		}

		@Override
		public boolean equals(Object o) {
			if(o instanceof GrammarElementsInterner.InternKey) {
				GrammarElementsInterner.InternKey interned = (GrammarElementsInterner.InternKey) o;
				return Objects.equals(this.grammarElement, interned.grammarElement) 
						&& Objects.equals(this.grammarElements, interned.grammarElements);
			}
			
			return false;
		}
	}

	private final Map<GrammarElementsInterner.InternKey, EObject[]> interningMap = Maps.newHashMap();
	
	/**
	 * Take a list of grammar elements and add an additional grammar element to the front.  If this
	 * list has already been produced in the past, return an interned version.  Note that 
	 * this code will only function efficiently if repeated invocation uses the same grammar element
	 * objects and arrays or else a new concatenated array will be created every time.
	 */
	EObject[] prependAndIntern(EObject grammarElement, Object grammarElements) {
		GrammarElementsInterner.InternKey internKey = new InternKey(grammarElement, grammarElements);
		return interningMap.computeIfAbsent(internKey, key -> key.prependedGrammarElements());
	}
	
	/**
	 * Take a list of grammar elements and add an additional grammar element at the back.  If this
	 * list has already been produced in the past, return an interned version.  Note that 
	 * this code will only function efficiently if repeated invocation uses the same grammar element
	 * objects and arrays or else a new concatenated array will be created every time.
	 */
	EObject[] appendAndIntern(Object grammarElements, EObject grammarElement) {
		GrammarElementsInterner.InternKey internKey = new InternKey(grammarElement, grammarElements);
		return interningMap.computeIfAbsent(internKey, key -> key.appendedGrammarElements());
	}
	
}