/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.normalization;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@EmfAdaptable
@Data
@SuppressWarnings("all")
public class OriginalElement {
  public static class OriginalElementAdapter extends AdapterImpl {
    private OriginalElement element;
    
    public OriginalElementAdapter(final OriginalElement element) {
      this.element = element;
    }
    
    public OriginalElement get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == OriginalElement.class;
    }
  }
  
  private final AbstractElement original;
  
  public static OriginalElement findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof OriginalElement.OriginalElementAdapter) {
    		return ((OriginalElement.OriginalElementAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static OriginalElement removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof OriginalElement.OriginalElementAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((OriginalElement.OriginalElementAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    OriginalElement result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for OriginalElement");
    OriginalElement.OriginalElementAdapter adapter = new OriginalElement.OriginalElementAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  public OriginalElement(final AbstractElement original) {
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
    OriginalElement other = (OriginalElement) obj;
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
  public AbstractElement getOriginal() {
    return this.original;
  }
}
