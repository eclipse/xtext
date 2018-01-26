/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.service;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
@EmfAdaptable
@Accessors
@SuppressWarnings("all")
public class AllRulesCache {
  public static class AllRulesCacheAdapter extends AdapterImpl {
    private AllRulesCache element;
    
    public AllRulesCacheAdapter(final AllRulesCache element) {
      this.element = element;
    }
    
    public AllRulesCache get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == AllRulesCache.class;
    }
  }
  
  private final Map<String, AbstractRule> allRules;
  
  public AllRulesCache(final Grammar grammar) {
    this.allRules = Maps.<String, AbstractRule>newHashMap();
    List<AbstractRule> _allRules = GrammarUtil.allRules(grammar);
    for (final AbstractRule rule : _allRules) {
      if ((rule instanceof TerminalRule)) {
        this.allRules.put(((TerminalRule)rule).getName().toUpperCase(), rule);
      } else {
        this.allRules.put(rule.getName(), rule);
      }
    }
  }
  
  public static AllRulesCache findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof AllRulesCache.AllRulesCacheAdapter) {
    		return ((AllRulesCache.AllRulesCacheAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static AllRulesCache removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof AllRulesCache.AllRulesCacheAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((AllRulesCache.AllRulesCacheAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    AllRulesCache result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for AllRulesCache");
    AllRulesCache.AllRulesCacheAdapter adapter = new AllRulesCache.AllRulesCacheAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  @Pure
  public Map<String, AbstractRule> getAllRules() {
    return this.allRules;
  }
}
