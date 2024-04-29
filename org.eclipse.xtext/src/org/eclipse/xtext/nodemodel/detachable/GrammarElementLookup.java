/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @since 2.35
 */
@Singleton
public class GrammarElementLookup {

	private final IGrammarAccess grammarAccess;
	private Tabulated<EObject> lookup;
	
	@Inject
	public GrammarElementLookup(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	protected Tabulated<EObject> delegate() {
		Tabulated<EObject> result = lookup;
		if (result == null) {
			synchronized (this) {
				result = lookup;
				if (result == null) {
					ImmutableMap.Builder<EObject, Integer> mapBuilder = ImmutableMap.builder();
					ImmutableList.Builder<EObject> listBuilder = ImmutableList.builder();

					int counter = 0;
					Grammar grammar = grammarAccess.getGrammar();
					while (grammar != null) {
						TreeIterator<EObject> iterator = EcoreUtil2.eAll(grammar);
						while (iterator.hasNext()) {
							EObject grammarElement = iterator.next();
							mapBuilder.put(grammarElement, counter);
							listBuilder.add(grammarElement);
							counter++;
						}
						if (grammar.getUsedGrammars().isEmpty()) {
							grammar = null;
						} else {
							grammar = grammar.getUsedGrammars().get(0);
						}
					}
					result = new Tabulated<>(mapBuilder.build(), listBuilder.build());
					this.lookup = result;
				}
			}
		}
		return result;
	}

	public int getId(EObject object) {
		return delegate().getId(object);
	}
	
	public int size() {
		return delegate().size();
	}

	public EObject getGrammarElement(int id) {
		return delegate().getObject(id);
	}
}
