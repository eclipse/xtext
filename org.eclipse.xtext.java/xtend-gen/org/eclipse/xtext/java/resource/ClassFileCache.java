/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.java.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.internal.EmfAdaptable;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
@EmfAdaptable
@SuppressWarnings("all")
public class ClassFileCache {
  public static class ClassFileCacheAdapter extends AdapterImpl {
    private ClassFileCache element;
    
    public ClassFileCacheAdapter(final ClassFileCache element) {
      this.element = element;
    }
    
    public ClassFileCache get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == ClassFileCache.class;
    }
  }
  
  private final Map<QualifiedName, IBinaryType> cache = new HashMap<QualifiedName, IBinaryType>();
  
  public boolean containsKey(final QualifiedName qualifiedName) {
    return this.cache.containsKey(qualifiedName);
  }
  
  public IBinaryType get(final QualifiedName qualifiedName) {
    return this.cache.get(qualifiedName);
  }
  
  public void put(final QualifiedName qualifiedName, final IBinaryType answer) {
    this.cache.put(qualifiedName, answer);
  }
  
  public void clear() {
    this.cache.clear();
  }
  
  public static ClassFileCache findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof ClassFileCache.ClassFileCacheAdapter) {
    		return ((ClassFileCache.ClassFileCacheAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static ClassFileCache removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof ClassFileCache.ClassFileCacheAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((ClassFileCache.ClassFileCacheAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    ClassFileCache result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for ClassFileCache");
    ClassFileCache.ClassFileCacheAdapter adapter = new ClassFileCache.ClassFileCacheAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
}
