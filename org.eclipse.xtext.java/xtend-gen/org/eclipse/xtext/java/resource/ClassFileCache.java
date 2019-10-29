/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.java.resource;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

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
  
  private static final Object NULL = new Object();
  
  private final Map<QualifiedName, Object> cache = new ConcurrentHashMap<QualifiedName, Object>();
  
  private final Set<Resource> resourcesToCompile = Collections.<Resource>newSetFromMap(new ConcurrentHashMap<Resource, Boolean>());
  
  private final Map<char[], List<String>> allTopLevelTypes = new ConcurrentHashMap<char[], List<String>>();
  
  private final Map<char[], Map<String, byte[]>> allClassMaps = new ConcurrentHashMap<char[], Map<String, byte[]>>();
  
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
    this.resourcesToCompile.clear();
  }
  
  public void addResourceToCompile(final Resource resource) {
    this.resourcesToCompile.add(resource);
  }
  
  public Set<Resource> drainResourcesToCompile() {
    final HashSet<Resource> result = new HashSet<Resource>(this.resourcesToCompile);
    this.resourcesToCompile.clear();
    return result;
  }
  
  public boolean popCompileResult(final char[] fileName, final Procedure2<? super List<String>, ? super Map<String, byte[]>> consumer) {
    boolean _containsKey = this.allTopLevelTypes.containsKey(fileName);
    if (_containsKey) {
      consumer.apply(this.allTopLevelTypes.remove(fileName), this.allClassMaps.remove(fileName));
      return true;
    }
    return false;
  }
  
  public void addCompileResult(final char[] fileName, final List<String> topLevelTypes, final Map<String, byte[]> classMap) {
    this.allTopLevelTypes.put(fileName, topLevelTypes);
    this.allClassMaps.put(fileName, classMap);
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
