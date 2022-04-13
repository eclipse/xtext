/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
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
    ActiveAnnotationContexts result = IterableExtensions.<ActiveAnnotationContexts>head(Iterables.<ActiveAnnotationContexts>filter(resource.eAdapters(), ActiveAnnotationContexts.class));
    if ((result != null)) {
      result.contexts.clear();
    } else {
      ActiveAnnotationContexts _activeAnnotationContexts = new ActiveAnnotationContexts();
      result = _activeAnnotationContexts;
      EList<Adapter> _eAdapters = resource.eAdapters();
      _eAdapters.add(result);
    }
    return result;
  }

  @Override
  public void notifyChanged(final Notification msg) {
    if ((((!this.running) && (!msg.isTouch())) && (Resource.RESOURCE__CONTENTS == msg.getFeatureID(Resource.class)))) {
      Object _notifier = msg.getNotifier();
      final Resource resource = ((Resource) _notifier);
      resource.eAdapters().remove(this);
      this.contexts.clear();
      this.compilationUnit = null;
    }
  }

  public static ActiveAnnotationContexts find(final Resource resource) {
    return IterableExtensions.<ActiveAnnotationContexts>head(Iterables.<ActiveAnnotationContexts>filter(resource.eAdapters(), ActiveAnnotationContexts.class));
  }

  @Pure
  public Map<JvmAnnotationType, ActiveAnnotationContext> getContexts() {
    return this.contexts;
  }
}
