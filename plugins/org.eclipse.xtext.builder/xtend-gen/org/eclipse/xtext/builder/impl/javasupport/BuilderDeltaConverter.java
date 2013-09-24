/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.builder.impl.javasupport.RollbackResourceDescriptionDelta;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.builder.impl.javasupport.UnsubmittedResourceDescriptionDelta;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuilderDeltaConverter extends DeltaConverter {
  @Inject
  public BuilderDeltaConverter(final IQualifiedNameConverter nameConverter, final TypeURIHelper uriHelper) {
    super(nameConverter, uriHelper);
  }
  
  protected void convertCompilationUnit(final IJavaElementDelta delta, final List<Delta> result) {
    super.convertCompilationUnit(delta, result);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _isPrimaryWorkingCopy = this.isPrimaryWorkingCopy(delta);
    if (!_isPrimaryWorkingCopy) {
      _and_1 = false;
    } else {
      boolean _isFineGrainedDelta = this.isFineGrainedDelta(delta);
      boolean _not = (!_isFineGrainedDelta);
      _and_1 = (_isPrimaryWorkingCopy && _not);
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isCoarseGrainedDelta = this.isCoarseGrainedDelta(delta);
      boolean _not_1 = (!_isCoarseGrainedDelta);
      _and = (_and_1 && _not_1);
    }
    if (_and) {
      IJavaElement _element = delta.getElement();
      final IType type = this.getPrimaryTypeFrom(((ICompilationUnit) _element));
      boolean _notEquals = (!Objects.equal(type, null));
      if (_notEquals) {
        RollbackResourceDescriptionDelta _rollbackResourceDescriptionDelta = new RollbackResourceDescriptionDelta(type);
        result.add(_rollbackResourceDescriptionDelta);
      }
    }
  }
  
  private boolean isPrimaryWorkingCopy(final IJavaElementDelta delta) {
    int _flags = delta.getFlags();
    int _bitwiseAnd = (_flags & IJavaElementDelta.F_PRIMARY_WORKING_COPY);
    boolean _notEquals = (_bitwiseAnd != 0);
    return _notEquals;
  }
  
  protected Delta createResourceDescriptionDelta(final IProject project, final String primaryTypeName, final IResourceDescription oldDescription, final IResourceDescription newDescription) {
    boolean _or = false;
    boolean _equals = Objects.equal(oldDescription, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(newDescription, null);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      UnsubmittedResourceDescriptionDelta _unsubmittedResourceDescriptionDelta = new UnsubmittedResourceDescriptionDelta(primaryTypeName, oldDescription, newDescription);
      return _unsubmittedResourceDescriptionDelta;
    }
    UnconfirmedStructuralChangesDelta _unconfirmedStructuralChangesDelta = new UnconfirmedStructuralChangesDelta(project, primaryTypeName, oldDescription, newDescription);
    return _unconfirmedStructuralChangesDelta;
  }
}
