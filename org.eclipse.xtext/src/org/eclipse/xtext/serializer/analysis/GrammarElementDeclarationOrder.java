/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarElementDeclarationOrder extends AdapterImpl implements Comparator<EObject> {

	public static GrammarElementDeclarationOrder get(Grammar grammar) {
		for (Adapter a : grammar.eAdapters())
			if (a instanceof GrammarElementDeclarationOrder)
				return (GrammarElementDeclarationOrder) a;
		GrammarElementDeclarationOrder result = new GrammarElementDeclarationOrder(grammar);
		grammar.eAdapters().add(result);
		for (Grammar g : GrammarUtil.allUsedGrammars(grammar)) {
			EList<Adapter> adapters = g.eAdapters();
			Iterator<Adapter> it = adapters.iterator();
			while (it.hasNext())
				if (it.next() instanceof GrammarElementDeclarationOrder)
					it.remove();
			adapters.add(result);
		}
		return result;
	}

	protected Map<EObject, Integer> elementIDCache;

	protected GrammarElementDeclarationOrder(Grammar grammar) {
		elementIDCache = Maps.newHashMap();
		List<Grammar> grammars = Lists.newArrayList(grammar);
		grammars.addAll(GrammarUtil.allUsedGrammars(grammar));
		int counter = 0;
		for (Grammar g : grammars) {
			elementIDCache.put(g, counter++);
			for (AbstractRule rule : g.getRules()) {
				elementIDCache.put(rule, counter++);
				TreeIterator<EObject> iterator = rule.eAllContents();
				while (iterator.hasNext()) {
					elementIDCache.put(iterator.next(), counter++);
				}
			}
		}
	}

	@Override
	public int compare(EObject o1, EObject o2) {
		if (o1 == null && o2 == null)
			return 0;
		if (o1 == null)
			return 1;
		if (o2 == null)
			return -1;
		Integer i1 = elementIDCache.get(o1);
		Integer i2 = elementIDCache.get(o2);
		return i1.compareTo(i2);
	}

	public int getElementID(EObject ele) {
		Integer result = elementIDCache.get(ele);
		if (result == null) {
			Grammar grammar = GrammarUtil.getGrammar(ele);
			if (!elementIDCache.containsKey(grammar)) {
				String grammarName = grammar.getName() + "#" + System.identityHashCode(grammar);
				List<String> indexed = Lists.newArrayList();
				for (EObject o : elementIDCache.keySet())
					if (o instanceof Grammar)
						indexed.add(((Grammar) o).getName() + "#" + System.identityHashCode(o));
				throw new IllegalStateException("No ID found. Wrong grammar. \nRequested: " + grammarName
						+ "\nAvailable: " + Joiner.on(", ").join(indexed));
			} else
				throw new IllegalStateException("No ID found. Not indexed. \nElement: " + EmfFormatter.objPath(ele));
		}
		return result;
	}

	public <T> Comparator<T> toComparator(final Function<T, EObject> elementAccess) {
		return new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return GrammarElementDeclarationOrder.this.compare(elementAccess.apply(o1), elementAccess.apply(o2));
			}
		};

	}
}
