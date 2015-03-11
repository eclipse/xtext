/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ActiveAnnotationContexts extends AdapterImpl {
  public enum AnnotationCallback {
    INDEXING,
    
    INFERENCE,
    
    VALIDATION,
    
    GENERATION;
  }
  
  @Accessors
  private final Map<JvmAnnotationType, ActiveAnnotationContext> contexts = CollectionLiterals.<JvmAnnotationType, ActiveAnnotationContext>newLinkedHashMap();
  
  protected CompilationUnitImpl compilationUnit;
  
  private boolean running;
  
  public void before(final ActiveAnnotationContexts.AnnotationCallback phase) {
    this.compilationUnit.before(phase);
    this.running = true;
  }
  
  public void after(final ActiveAnnotationContexts.AnnotationCallback phase) {
    this.running = false;
    this.compilationUnit.after(phase);
  }
  
  public static ActiveAnnotationContexts installNew(final Resource resource) {
    EList<Adapter> _eAdapters = resource.eAdapters();
    Iterable<ActiveAnnotationContexts> _filter = Iterables.<ActiveAnnotationContexts>filter(_eAdapters, ActiveAnnotationContexts.class);
    ActiveAnnotationContexts result = IterableExtensions.<ActiveAnnotationContexts>head(_filter);
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      result.contexts.clear();
    } else {
      ActiveAnnotationContexts _activeAnnotationContexts = new ActiveAnnotationContexts();
      result = _activeAnnotationContexts;
      EList<Adapter> _eAdapters_1 = resource.eAdapters();
      _eAdapters_1.add(result);
    }
    return result;
  }
  
  @Override
  public void notifyChanged(final Notification msg) {
    boolean _and = false;
    boolean _and_1 = false;
    if (!(!this.running)) {
      _and_1 = false;
    } else {
      boolean _isTouch = msg.isTouch();
      boolean _not = (!_isTouch);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _featureID = msg.getFeatureID(Resource.class);
      boolean _equals = (Resource.RESOURCE__CONTENTS == _featureID);
      _and = _equals;
    }
    if (_and) {
      Object _notifier = msg.getNotifier();
      final Resource resource = ((Resource) _notifier);
      EList<Adapter> _eAdapters = resource.eAdapters();
      _eAdapters.remove(this);
      this.contexts.clear();
      this.compilationUnit = null;
    }
  }
  
  public static ActiveAnnotationContexts find(final Resource resource) {
    EList<Adapter> _eAdapters = resource.eAdapters();
    Iterable<ActiveAnnotationContexts> _filter = Iterables.<ActiveAnnotationContexts>filter(_eAdapters, ActiveAnnotationContexts.class);
    return IterableExtensions.<ActiveAnnotationContexts>head(_filter);
  }
  
  @Pure
  public Map<JvmAnnotationType, ActiveAnnotationContext> getContexts() {
    return this.contexts;
  }
}
