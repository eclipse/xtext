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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.Property;
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
  
  @Property
  private final Map<JvmAnnotationType, ActiveAnnotationContext> _contexts = CollectionLiterals.<JvmAnnotationType, ActiveAnnotationContext>newLinkedHashMap();
  
  protected CompilationUnitImpl compilationUnit;
  
  public void before(final ActiveAnnotationContexts.AnnotationCallback phase) {
    this.compilationUnit.before(phase);
  }
  
  public void after(final ActiveAnnotationContexts.AnnotationCallback phase) {
    this.compilationUnit.after(phase);
  }
  
  public static ActiveAnnotationContexts installNew(final Resource resource) {
    EList<Adapter> _eAdapters = resource.eAdapters();
    Iterable<ActiveAnnotationContexts> _filter = Iterables.<ActiveAnnotationContexts>filter(_eAdapters, ActiveAnnotationContexts.class);
    ActiveAnnotationContexts result = IterableExtensions.<ActiveAnnotationContexts>head(_filter);
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      Map<JvmAnnotationType, ActiveAnnotationContext> _contexts = result.getContexts();
      _contexts.clear();
    } else {
      ActiveAnnotationContexts _activeAnnotationContexts = new ActiveAnnotationContexts();
      result = _activeAnnotationContexts;
      EList<Adapter> _eAdapters_1 = resource.eAdapters();
      _eAdapters_1.add(result);
    }
    return result;
  }
  
  public static ActiveAnnotationContexts find(final Resource resource) {
    EList<Adapter> _eAdapters = resource.eAdapters();
    Iterable<ActiveAnnotationContexts> _filter = Iterables.<ActiveAnnotationContexts>filter(_eAdapters, ActiveAnnotationContexts.class);
    return IterableExtensions.<ActiveAnnotationContexts>head(_filter);
  }
  
  @Pure
  public Map<JvmAnnotationType, ActiveAnnotationContext> getContexts() {
    return this._contexts;
  }
}
