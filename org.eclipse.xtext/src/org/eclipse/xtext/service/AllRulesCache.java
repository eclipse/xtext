/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.service;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;

import com.google.common.collect.Maps;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
public class AllRulesCache {
	public static class AllRulesCacheAdapter extends AdapterImpl {
		private final AllRulesCache element;

		public AllRulesCacheAdapter(AllRulesCache element) {
			this.element = element;
		}

		public AllRulesCache get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == AllRulesCache.class;
		}
	}

	private final Map<String, AbstractRule> allRulesCache;

	public AllRulesCache(Grammar grammar) {
		allRulesCache = Maps.newHashMap();
		List<AbstractRule> allRules = GrammarUtil.allRules(grammar);
		for (AbstractRule rule : allRules) {
			if (rule instanceof TerminalRule) {
				allRulesCache.put(rule.getName().toUpperCase(), rule);
			} else {
				allRulesCache.put(rule.getName(), rule);
			}
		}
	}

	public static AllRulesCache findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof AllRulesCacheAdapter) {
				return ((AllRulesCacheAdapter) adapter).get();
			}
		}
		return null;
	}

	public static AllRulesCache removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof AllRulesCacheAdapter) {
				emfObject.eAdapters().remove(i);
				return ((AllRulesCacheAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		AllRulesCache result = findInEmfObject(emfObject);
		if (result != null) {
			throw new IllegalStateException("The given EMF object already contains an adapter for AllRulesCache");
		}
		AllRulesCacheAdapter adapter = new AllRulesCacheAdapter(this);
		emfObject.eAdapters().add(adapter);
	}

	public Map<String, AbstractRule> getAllRules() {
		return allRulesCache;
	}
}
