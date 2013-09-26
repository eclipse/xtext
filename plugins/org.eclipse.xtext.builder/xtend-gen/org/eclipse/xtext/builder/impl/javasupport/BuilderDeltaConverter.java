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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.impl.javasupport.CommitResourceDescriptionDelta;
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
  
  protected void convertChangedCompilationUnit(final IJavaElementDelta it, final List<Delta> result) {
    boolean _isPrimaryWorkingCopy = this.isPrimaryWorkingCopy(it);
    if (_isPrimaryWorkingCopy) {
      RollbackResourceDescriptionDelta _rollback = this.rollback(it);
      result.add(_rollback);
    }
    super.convertChangedCompilationUnit(it, result);
    boolean _isPrimaryResource = this.isPrimaryResource(it);
    if (_isPrimaryResource) {
      CommitResourceDescriptionDelta _commit = this.commit(it);
      result.add(_commit);
    }
  }
  
  private boolean isPrimaryWorkingCopy(final IJavaElementDelta delta) {
    int _flags = delta.getFlags();
    int _bitwiseAnd = (_flags & IJavaElementDelta.F_PRIMARY_WORKING_COPY);
    boolean _notEquals = (_bitwiseAnd != 0);
    return _notEquals;
  }
  
  private boolean isPrimaryResource(final IJavaElementDelta delta) {
    int _flags = delta.getFlags();
    int _bitwiseAnd = (_flags & IJavaElementDelta.F_PRIMARY_RESOURCE);
    boolean _notEquals = (_bitwiseAnd != 0);
    return _notEquals;
  }
  
  protected Delta createContentChangeDelta(final ICompilationUnit it, final IResourceDescription oldDescription, final IResourceDescription newDescription) {
    String _compilationUnitName = this.getCompilationUnitName(it);
    UnsubmittedResourceDescriptionDelta _unsubmittedResourceDescriptionDelta = new UnsubmittedResourceDescriptionDelta(_compilationUnitName, oldDescription, newDescription);
    return _unsubmittedResourceDescriptionDelta;
  }
  
  protected Delta createStructureChangeDelta(final ICompilationUnit it, final IResourceDescription oldDescription, final IResourceDescription newDescription) {
    IProject _project = this.getProject(it);
    String _compilationUnitName = this.getCompilationUnitName(it);
    UnconfirmedStructuralChangesDelta _unconfirmedStructuralChangesDelta = new UnconfirmedStructuralChangesDelta(_project, _compilationUnitName, oldDescription, newDescription);
    return _unconfirmedStructuralChangesDelta;
  }
  
  public RollbackResourceDescriptionDelta rollback(final IJavaElementDelta it) {
    String _compilationUnitName = this.getCompilationUnitName(it);
    RollbackResourceDescriptionDelta _rollbackResourceDescriptionDelta = new RollbackResourceDescriptionDelta(_compilationUnitName);
    return _rollbackResourceDescriptionDelta;
  }
  
  public CommitResourceDescriptionDelta commit(final IJavaElementDelta it) {
    String _compilationUnitName = this.getCompilationUnitName(it);
    CommitResourceDescriptionDelta _commitResourceDescriptionDelta = new CommitResourceDescriptionDelta(_compilationUnitName);
    return _commitResourceDescriptionDelta;
  }
  
  public String getCompilationUnitName(final IJavaElementDelta it) {
    String _switchResult = null;
    IJavaElement _element = it.getElement();
    final IJavaElement element = _element;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof ICompilationUnit) {
        _matched=true;
        String _compilationUnitName = this.getCompilationUnitName(((ICompilationUnit)element));
        _switchResult = _compilationUnitName;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public String getCompilationUnitName(final ICompilationUnit compilationUnit) {
    final String fileName = compilationUnit.getElementName();
    IJavaElement _parent = compilationUnit.getParent();
    final IPackageFragment packageFragment = ((IPackageFragment) _parent);
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isDefaultPackage = packageFragment.isDefaultPackage();
      boolean _not = (!_isDefaultPackage);
      if (_not) {
        String _elementName = packageFragment.getElementName();
        _builder.append(_elementName, "");
        _builder.append(".");
      }
    }
    _builder.append(fileName, "");
    return _builder.toString();
  }
  
  public IProject getProject(final ICompilationUnit it) {
    IProject _xblockexpression = null;
    {
      final IJavaProject javaProject = it.getJavaProject();
      boolean _equals = Objects.equal(javaProject, null);
      if (_equals) {
        return null;
      }
      IProject _project = javaProject.getProject();
      _xblockexpression = (_project);
    }
    return _xblockexpression;
  }
}
