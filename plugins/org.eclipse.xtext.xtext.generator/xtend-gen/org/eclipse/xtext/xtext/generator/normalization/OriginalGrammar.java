/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.normalization;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@EmfAdaptable
@Data
@SuppressWarnings("all")
public class OriginalGrammar {
  public static class OriginalGrammarAdapter extends AdapterImpl {
    private OriginalGrammar element;
    
    public OriginalGrammarAdapter(final OriginalGrammar element) {
      this.element = element;
    }
    
    public OriginalGrammar get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == OriginalGrammar.class;
    }
  }
  
  private final Grammar original;
  
  public static OriginalGrammar findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof OriginalGrammar.OriginalGrammarAdapter) {
    		return ((OriginalGrammar.OriginalGrammarAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static OriginalGrammar removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof OriginalGrammar.OriginalGrammarAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((OriginalGrammar.OriginalGrammarAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    OriginalGrammar result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for OriginalGrammar");
    OriginalGrammar.OriginalGrammarAdapter adapter = new OriginalGrammar.OriginalGrammarAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  public OriginalGrammar(final Grammar original) {
    super();
    this.original = original;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.original== null) ? 0 : this.original.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OriginalGrammar other = (OriginalGrammar) obj;
    if (this.original == null) {
      if (other.original != null)
        return false;
    } else if (!this.original.equals(other.original))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("original", this.original);
    return b.toString();
  }
  
  @Pure
  public Grammar getOriginal() {
    return this.original;
  }
}
