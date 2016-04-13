/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.imports;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xtype.XImportDeclaration;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class StaticallyImportedMemberProvider {
  @Inject
  @Extension
  private IImportsConfiguration _iImportsConfiguration;
  
  @Inject
  @Extension
  private IResolvedFeatures.Provider _provider;
  
  @Inject
  private IVisibilityHelper visibilityHelper;
  
  public Iterable<JvmFeature> findAllFeatures(final XImportDeclaration it) {
    Iterable<JvmFeature> _xblockexpression = null;
    {
      final JvmDeclaredType importedType = it.getImportedType();
      boolean _or = false;
      boolean _isStatic = it.isStatic();
      boolean _not = (!_isStatic);
      if (_not) {
        _or = true;
      } else {
        boolean _equals = Objects.equal(importedType, null);
        _or = _equals;
      }
      if (_or) {
        return CollectionLiterals.<JvmFeature>emptyList();
      }
      Resource _eResource = it.eResource();
      final IVisibilityHelper visibilityHelper = this.getVisibilityHelper(_eResource);
      final IResolvedFeatures resolvedFeatures = this._provider.getResolvedFeatures(importedType);
      List<JvmFeature> _allFeatures = resolvedFeatures.getAllFeatures();
      final Function1<JvmFeature, Boolean> _function = new Function1<JvmFeature, Boolean>() {
        @Override
        public Boolean apply(final JvmFeature feature) {
          boolean _and = false;
          boolean _and_1 = false;
          boolean _isStatic = feature.isStatic();
          if (!_isStatic) {
            _and_1 = false;
          } else {
            boolean _isVisible = visibilityHelper.isVisible(feature);
            _and_1 = _isVisible;
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _or = false;
            String _memberName = it.getMemberName();
            boolean _equals = Objects.equal(_memberName, null);
            if (_equals) {
              _or = true;
            } else {
              String _simpleName = feature.getSimpleName();
              String _memberName_1 = it.getMemberName();
              boolean _startsWith = _simpleName.startsWith(_memberName_1);
              _or = _startsWith;
            }
            _and = _or;
          }
          return Boolean.valueOf(_and);
        }
      };
      _xblockexpression = IterableExtensions.<JvmFeature>filter(_allFeatures, _function);
    }
    return _xblockexpression;
  }
  
  public Iterable<JvmFeature> getAllFeatures(final XImportDeclaration it) {
    Resource _eResource = it.eResource();
    JvmDeclaredType _importedType = it.getImportedType();
    boolean _isStatic = it.isStatic();
    boolean _isExtension = it.isExtension();
    String _memberName = it.getMemberName();
    return this.getAllFeatures(_eResource, _importedType, _isStatic, _isExtension, _memberName);
  }
  
  public Iterable<JvmFeature> getAllFeatures(final Resource resource, final JvmDeclaredType importedType, final boolean static_, final boolean extension, final String memberName) {
    Iterable<JvmFeature> _xblockexpression = null;
    {
      boolean _or = false;
      if ((!static_)) {
        _or = true;
      } else {
        boolean _equals = Objects.equal(importedType, null);
        _or = _equals;
      }
      if (_or) {
        return CollectionLiterals.<JvmFeature>emptyList();
      }
      final IVisibilityHelper visibilityHelper = this.getVisibilityHelper(resource);
      final IResolvedFeatures resolvedFeatures = this._provider.getResolvedFeatures(importedType);
      List<JvmFeature> _allFeatures = resolvedFeatures.getAllFeatures(memberName);
      final Function1<JvmFeature, Boolean> _function = new Function1<JvmFeature, Boolean>() {
        @Override
        public Boolean apply(final JvmFeature feature) {
          boolean _and = false;
          boolean _isStatic = feature.isStatic();
          if (!_isStatic) {
            _and = false;
          } else {
            boolean _isVisible = visibilityHelper.isVisible(feature);
            _and = _isVisible;
          }
          return Boolean.valueOf(_and);
        }
      };
      _xblockexpression = IterableExtensions.<JvmFeature>filter(_allFeatures, _function);
    }
    return _xblockexpression;
  }
  
  public IVisibilityHelper getVisibilityHelper(final Resource resource) {
    IVisibilityHelper _switchResult = null;
    boolean _matched = false;
    if (resource instanceof XtextResource) {
      _matched=true;
      IVisibilityHelper _xblockexpression = null;
      {
        final String packageName = this._iImportsConfiguration.getPackageName(((XtextResource)resource));
        IVisibilityHelper _xifexpression = null;
        boolean _equals = Objects.equal(packageName, null);
        if (_equals) {
          _xifexpression = this.visibilityHelper;
        } else {
          _xifexpression = new ContextualVisibilityHelper(this.visibilityHelper, packageName);
        }
        _xblockexpression = _xifexpression;
      }
      _switchResult = _xblockexpression;
    }
    if (!_matched) {
      _switchResult = this.visibilityHelper;
    }
    return _switchResult;
  }
}
