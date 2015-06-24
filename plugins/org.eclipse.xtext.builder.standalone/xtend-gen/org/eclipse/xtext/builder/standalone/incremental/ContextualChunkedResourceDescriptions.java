/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.standalone.incremental.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.internal.EmfAdaptable;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@EmfAdaptable
@SuppressWarnings("all")
public class ContextualChunkedResourceDescriptions extends ChunkedResourceDescriptions implements IResourceDescriptions.IContextAware {
  public static class ContextualChunkedResourceDescriptionsAdapter extends AdapterImpl {
    private ContextualChunkedResourceDescriptions element;
    
    public ContextualChunkedResourceDescriptionsAdapter(final ContextualChunkedResourceDescriptions element) {
      this.element = element;
    }
    
    public ContextualChunkedResourceDescriptions get() {
      return this.element;
    }
    
    public boolean isAdapterForType(final Object object) {
      return object == ContextualChunkedResourceDescriptions.class;
    }
  }
  
  private Notifier context;
  
  @Override
  public void setContext(final Notifier context) {
    this.context = context;
  }
  
  public ResourceSet getResourceSet() {
    return EcoreUtil2.getResourceSet(this.context);
  }
  
  public ContextualChunkedResourceDescriptions() {
  }
  
  public ContextualChunkedResourceDescriptions(final ChunkedResourceDescriptions toBeCopied) {
    super(toBeCopied.chunk2resourceDescriptions);
  }
  
  public static ContextualChunkedResourceDescriptions findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof org.eclipse.xtext.builder.standalone.incremental.ContextualChunkedResourceDescriptions.ContextualChunkedResourceDescriptionsAdapter) {
    		return ((org.eclipse.xtext.builder.standalone.incremental.ContextualChunkedResourceDescriptions.ContextualChunkedResourceDescriptionsAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    ContextualChunkedResourceDescriptions result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for ContextualChunkedResourceDescriptions");
    org.eclipse.xtext.builder.standalone.incremental.ContextualChunkedResourceDescriptions.ContextualChunkedResourceDescriptionsAdapter adapter = new org.eclipse.xtext.builder.standalone.incremental.ContextualChunkedResourceDescriptions.ContextualChunkedResourceDescriptionsAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
}
