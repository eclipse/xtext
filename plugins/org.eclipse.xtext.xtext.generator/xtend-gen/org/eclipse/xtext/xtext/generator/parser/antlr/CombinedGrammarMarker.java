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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@EmfAdaptable
@Data
@SuppressWarnings("all")
public class CombinedGrammarMarker {
  public static class CombinedGrammarMarkerAdapter extends AdapterImpl {
    private CombinedGrammarMarker element;
    
    public CombinedGrammarMarkerAdapter(final CombinedGrammarMarker element) {
      this.element = element;
    }
    
    public CombinedGrammarMarker get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == CombinedGrammarMarker.class;
    }
  }
  
  private final boolean isCombinedGrammar;
  
  public static CombinedGrammarMarker findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof CombinedGrammarMarker.CombinedGrammarMarkerAdapter) {
    		return ((CombinedGrammarMarker.CombinedGrammarMarkerAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static CombinedGrammarMarker removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof CombinedGrammarMarker.CombinedGrammarMarkerAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((CombinedGrammarMarker.CombinedGrammarMarkerAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    CombinedGrammarMarker result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for CombinedGrammarMarker");
    CombinedGrammarMarker.CombinedGrammarMarkerAdapter adapter = new CombinedGrammarMarker.CombinedGrammarMarkerAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  public CombinedGrammarMarker(final boolean isCombinedGrammar) {
    super();
    this.isCombinedGrammar = isCombinedGrammar;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (this.isCombinedGrammar ? 1231 : 1237);
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
    CombinedGrammarMarker other = (CombinedGrammarMarker) obj;
    if (other.isCombinedGrammar != this.isCombinedGrammar)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("isCombinedGrammar", this.isCombinedGrammar);
    return b.toString();
  }
  
  @Pure
  public boolean isCombinedGrammar() {
    return this.isCombinedGrammar;
  }
}
