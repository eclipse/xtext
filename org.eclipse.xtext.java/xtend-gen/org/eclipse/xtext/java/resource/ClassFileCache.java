/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.java.resource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.internal.EmfAdaptable;

/**
 * A cache for parsed class or java source file content. It is bound to the
 * lifecycle of a resource set.
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.15
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
  
  private final static Object NULL = new Object();
  
  private final Map<QualifiedName, Object> cache = new ConcurrentHashMap<QualifiedName, Object>();
  
  public boolean containsKey(final QualifiedName qualifiedName) {
    return this.cache.containsKey(qualifiedName);
  }
  
  public IBinaryType get(final QualifiedName qualifiedName) {
    final Object result = this.cache.get(qualifiedName);
    if ((result == ClassFileCache.NULL)) {
      return null;
    }
    return ((IBinaryType) result);
  }
  
  public void put(final QualifiedName qualifiedName, final IBinaryType answer) {
    if ((answer == null)) {
      this.cache.put(qualifiedName, ClassFileCache.NULL);
    } else {
      this.cache.put(qualifiedName, answer);
    }
  }
  
  public IBinaryType computeIfAbsent(final QualifiedName qualifiedName, final Function<? super QualifiedName, ? extends IBinaryType> fun) {
    final Function<QualifiedName, Object> _function = (QualifiedName it) -> {
      Object _elvis = null;
      IBinaryType _apply = fun.apply(it);
      if (_apply != null) {
        _elvis = _apply;
      } else {
        _elvis = ClassFileCache.NULL;
      }
      return _elvis;
    };
    final Object result = this.cache.computeIfAbsent(qualifiedName, _function);
    if ((result instanceof IBinaryType)) {
      return ((IBinaryType)result);
    }
    return null;
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
