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
  private Map<String,JavaBuilderState> javaBuildState;
  
  private Collection<UnconfirmedStructuralChangesDelta> unconfirmedDeltas;
  
  public void reset() {
    HashMap<String,JavaBuilderState> _newHashMap = CollectionLiterals.<String, JavaBuilderState>newHashMap();
    this.javaBuildState = _newHashMap;
    ArrayList<UnconfirmedStructuralChangesDelta> _newArrayList = CollectionLiterals.<UnconfirmedStructuralChangesDelta>newArrayList();
    this.unconfirmedDeltas = _newArrayList;
  }
  
  /**
   * Public for testing purpose
   */
  public Collection<UnconfirmedStructuralChangesDelta> getUnconfirmedDeltas() {
    Collection<UnconfirmedStructuralChangesDelta> _unmodifiableCollection = Collections.<UnconfirmedStructuralChangesDelta>unmodifiableCollection(this.unconfirmedDeltas);
    return _unmodifiableCollection;
  }
  
  public boolean queueChange(final IResourceDescription.Delta delta) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
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
          _xblockexpression = (true);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public boolean needsRebuild(final IProject it, final Collection<IResourceDescription.Delta> deltas) {
    boolean _xblockexpression = false;
    {
      String _name = it.getName();
      final JavaBuilderState oldState = this.javaBuildState.get(_name);
      final JavaBuilderState newState = JavaBuilderState.getLastBuiltState(it);
      Procedure1<IResourceDescription.Delta> _xifexpression = null;
      boolean _or = false;
      boolean _equals = Objects.equal(oldState, null);
      if (_equals) {
        _or = true;
      } else {
        Long _lastStructuralBuildTime = oldState.getLastStructuralBuildTime();
        Long _lastStructuralBuildTime_1 = newState.getLastStructuralBuildTime();
        boolean _notEquals = (!Objects.equal(_lastStructuralBuildTime, _lastStructuralBuildTime_1));
        _or = (_equals || _notEquals);
      }
      if (_or) {
        final Procedure1<IResourceDescription.Delta> _function = new Procedure1<IResourceDescription.Delta>() {
          public void apply(final IResourceDescription.Delta it) {
            final Set<QualifiedName> structurallyChangedTypes = newState.getStructurallyChangedTypes();
            boolean _or = false;
            IResourceDescription _new = it.getNew();
            boolean _namesIntersect = JdtQueuedBuildData.this.namesIntersect(_new, structurallyChangedTypes);
            if (_namesIntersect) {
              _or = true;
            } else {
              IResourceDescription _old = it.getOld();
              boolean _namesIntersect_1 = JdtQueuedBuildData.this.namesIntersect(_old, structurallyChangedTypes);
              _or = (_namesIntersect || _namesIntersect_1);
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
      boolean _doNeedRebuild = this.doNeedRebuild(newState, _xifexpression);
      _xblockexpression = (_doNeedRebuild);
    }
    return _xblockexpression;
  }
  
  protected boolean doNeedRebuild(final JavaBuilderState it, final Procedure1<? super UnconfirmedStructuralChangesDelta> processor) {
    boolean _xblockexpression = false;
    {
      final Iterator<UnconfirmedStructuralChangesDelta> i = this.unconfirmedDeltas.iterator();
      boolean _hasNext = i.hasNext();
      boolean _while = _hasNext;
      while (_while) {
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
            _and = (_lessThan && _equals);
          }
          if (_and) {
            i.remove();
            boolean _notEquals = (!Objects.equal(processor, null));
            if (_notEquals) {
              processor.apply(unconfirmed);
            }
          }
        }
        boolean _hasNext_1 = i.hasNext();
        _while = _hasNext_1;
      }
      int _size = this.unconfirmedDeltas.size();
      boolean _notEquals = (_size != 0);
      _xblockexpression = (_notEquals);
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
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
}
