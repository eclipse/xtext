/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
    HashMap<String, JavaBuilderState> _newHashMap = CollectionLiterals.<String, JavaBuilderState>newHashMap();
    this.javaBuildState = _newHashMap;
    ArrayList<UnconfirmedStructuralChangesDelta> _newArrayList = CollectionLiterals.<UnconfirmedStructuralChangesDelta>newArrayList();
    this.unconfirmedDeltas = _newArrayList;
  }
  
  @Override
  public void reset(final IProject project) {
    String _name = project.getName();
    this.javaBuildState.remove(_name);
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
        String _name = project.getName();
        JavaBuilderState state = this.javaBuildState.get(_name);
        boolean _equals = Objects.equal(state, null);
        if (_equals) {
          String _name_1 = project.getName();
          JavaBuilderState _lastBuiltState = JavaBuilderState.getLastBuiltState(project);
          JavaBuilderState _state = state = _lastBuiltState;
          this.javaBuildState.put(_name_1, _state);
        }
        Integer _buildNumber = state.getBuildNumber();
        ((UnconfirmedStructuralChangesDelta)delta).setBuildNumber((_buildNumber).intValue());
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
      String _name = it.getName();
      final JavaBuilderState oldState = this.javaBuildState.get(_name);
      final JavaBuilderState newState = JavaBuilderState.getLastBuiltState(it);
      Procedure1<UnconfirmedStructuralChangesDelta> _xifexpression = null;
      boolean _or = false;
      boolean _equals = Objects.equal(oldState, null);
      if (_equals) {
        _or = true;
      } else {
        Long _lastStructuralBuildTime = oldState.getLastStructuralBuildTime();
        Long _lastStructuralBuildTime_1 = newState.getLastStructuralBuildTime();
        boolean _notEquals = (!Objects.equal(_lastStructuralBuildTime, _lastStructuralBuildTime_1));
        _or = _notEquals;
      }
      if (_or) {
        final Procedure1<UnconfirmedStructuralChangesDelta> _function = new Procedure1<UnconfirmedStructuralChangesDelta>() {
          @Override
          public void apply(final UnconfirmedStructuralChangesDelta it) {
            final Set<QualifiedName> structurallyChangedTypes = newState.getStructurallyChangedTypes();
            boolean _or = false;
            IResourceDescription _new = it.getNew();
            boolean _namesIntersect = JdtQueuedBuildData.this.namesIntersect(_new, structurallyChangedTypes);
            if (_namesIntersect) {
              _or = true;
            } else {
              IResourceDescription _old = it.getOld();
              boolean _namesIntersect_1 = JdtQueuedBuildData.this.namesIntersect(_old, structurallyChangedTypes);
              _or = _namesIntersect_1;
            }
            if (_or) {
              deltas.add(it);
            }
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
          boolean _and = false;
          int _buildNumber = unconfirmed.getBuildNumber();
          Integer _buildNumber_1 = it.getBuildNumber();
          boolean _lessThan = (_buildNumber < (_buildNumber_1).intValue());
          if (!_lessThan) {
            _and = false;
          } else {
            IProject _project = unconfirmed.getProject();
            IProject _project_1 = it.getProject();
            boolean _equals = _project.equals(_project_1);
            _and = _equals;
          }
          if (_and) {
            i.remove();
            boolean _notEquals = (!Objects.equal(processor, null));
            if (_notEquals) {
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
      boolean _equals = Objects.equal(resourceDescription, null);
      if (_equals) {
        return false;
      }
      Iterable<IEObjectDescription> _exportedObjects = resourceDescription.getExportedObjects();
      for (final IEObjectDescription objectDescription : _exportedObjects) {
        QualifiedName _qualifiedName = objectDescription.getQualifiedName();
        boolean _contains = names.contains(_qualifiedName);
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
