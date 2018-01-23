/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.builder.impl.IQueuedBuildDataContribution;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.common.types.ui.notification.JavaBuilderState;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class JdtQueuedBuildData implements IQueuedBuildDataContribution {
  private Map<String, JavaBuilderState> javaBuildState;
  
  private Map<String, JavaBuilderState> javaBuildStateCopy;
  
  private Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltas;
  
  private Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltasCopy;
  
  @Override
  public void reset() {
    this.javaBuildState = CollectionLiterals.<String, JavaBuilderState>newHashMap();
    this.unconfirmedDeltas = CollectionLiterals.<UnconfirmedStructuralChangesDelta>newArrayList();
  }
  
  @Override
  public void reset(final IProject project) {
    this.javaBuildState.remove(project.getName());
  }
  
  /**
   * Public for testing purpose
   */
  public Collection<UnconfirmedStructuralChangesDelta> getUnconfirmedDeltas() {
    return Collections.<UnconfirmedStructuralChangesDelta>unmodifiableCollection(this.unconfirmedDeltas);
  }
  
  @Override
  public boolean queueChange(final IResourceDescription.Delta delta) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (delta instanceof UnconfirmedStructuralChangesDelta) {
      _matched=true;
      boolean _xblockexpression = false;
      {
        final IProject project = ((UnconfirmedStructuralChangesDelta)delta).getProject();
        JavaBuilderState state = this.javaBuildState.get(project.getName());
        if ((state == null)) {
          this.javaBuildState.put(project.getName(), state = JavaBuilderState.getLastBuiltState(project));
        }
        ((UnconfirmedStructuralChangesDelta)delta).setBuildNumber((state.getBuildNumber()).intValue());
        this.unconfirmedDeltas.add(((UnconfirmedStructuralChangesDelta)delta));
        _xblockexpression = true;
      }
      _switchResult = _xblockexpression;
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  @Override
  public boolean needsRebuild(final IProject it, final Collection<IResourceDescription.Delta> deltas) {
    boolean _xblockexpression = false;
    {
      final JavaBuilderState oldState = this.javaBuildState.get(it.getName());
      final JavaBuilderState newState = JavaBuilderState.getLastBuiltState(it);
      Procedure1<UnconfirmedStructuralChangesDelta> _xifexpression = null;
      if (((oldState == null) || (!Objects.equal(oldState.getLastStructuralBuildTime(), newState.getLastStructuralBuildTime())))) {
        final Procedure1<UnconfirmedStructuralChangesDelta> _function = (UnconfirmedStructuralChangesDelta it_1) -> {
          final Set<QualifiedName> structurallyChangedTypes = newState.getStructurallyChangedTypes();
          if ((this.namesIntersect(it_1.getNew(), structurallyChangedTypes) || this.namesIntersect(it_1.getOld(), structurallyChangedTypes))) {
            deltas.add(it_1);
          }
        };
        _xifexpression = _function;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = this.doNeedRebuild(newState, _xifexpression);
    }
    return _xblockexpression;
  }
  
  protected boolean doNeedRebuild(final JavaBuilderState it, final Procedure1<? super UnconfirmedStructuralChangesDelta> processor) {
    boolean _xblockexpression = false;
    {
      final Iterator<UnconfirmedStructuralChangesDelta> i = this.unconfirmedDeltas.iterator();
      while (i.hasNext()) {
        {
          final UnconfirmedStructuralChangesDelta unconfirmed = i.next();
          if (((unconfirmed.getBuildNumber() < (it.getBuildNumber()).intValue()) && unconfirmed.getProject().equals(it.getProject()))) {
            i.remove();
            if ((processor != null)) {
              processor.apply(unconfirmed);
            }
          }
        }
      }
      int _size = this.unconfirmedDeltas.size();
      _xblockexpression = (_size != 0);
    }
    return _xblockexpression;
  }
  
  protected boolean namesIntersect(final IResourceDescription resourceDescription, final Set<QualifiedName> names) {
    boolean _xblockexpression = false;
    {
      if ((resourceDescription == null)) {
        return false;
      }
      Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
      for (final IEObjectDescription objectDescription : _exportedObjects) {
        boolean _contains = names.contains(objectDescription.getQualifiedName());
        if (_contains) {
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  @Override
  public void createCheckpoint() {
    HashMap<String, JavaBuilderState> _hashMap = new HashMap<String, JavaBuilderState>(this.javaBuildState);
    this.javaBuildStateCopy = _hashMap;
    ArrayList<UnconfirmedStructuralChangesDelta> _arrayList = new ArrayList<UnconfirmedStructuralChangesDelta>(this.unconfirmedDeltas);
    this.unconfirmedDeltasCopy = _arrayList;
  }
  
  @Override
  public void discardCheckpoint() {
    this.javaBuildStateCopy = null;
    this.unconfirmedDeltasCopy = null;
  }
  
  @Override
  public void rollback() {
    this.javaBuildState.clear();
    this.javaBuildState.putAll(this.javaBuildStateCopy);
    this.unconfirmedDeltas.clear();
    this.unconfirmedDeltas.addAll(this.unconfirmedDeltasCopy);
  }
}
