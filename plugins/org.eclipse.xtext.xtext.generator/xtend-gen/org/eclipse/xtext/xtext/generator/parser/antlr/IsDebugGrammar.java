/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.util.internal.EmfAdaptable;

/**
 * Attach to a flattened grammar to indicate that we want to produce a debug grammar file.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@EmfAdaptable
@SuppressWarnings("all")
public class IsDebugGrammar {
  public static class IsDebugGrammarAdapter extends AdapterImpl {
    private IsDebugGrammar element;
    
    public IsDebugGrammarAdapter(final IsDebugGrammar element) {
      this.element = element;
    }
    
    public IsDebugGrammar get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == IsDebugGrammar.class;
    }
  }
  
  public static IsDebugGrammar findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof IsDebugGrammar.IsDebugGrammarAdapter) {
    		return ((IsDebugGrammar.IsDebugGrammarAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static IsDebugGrammar removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof IsDebugGrammar.IsDebugGrammarAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((IsDebugGrammar.IsDebugGrammarAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    IsDebugGrammar result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for IsDebugGrammar");
    IsDebugGrammar.IsDebugGrammarAdapter adapter = new IsDebugGrammar.IsDebugGrammarAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
}
