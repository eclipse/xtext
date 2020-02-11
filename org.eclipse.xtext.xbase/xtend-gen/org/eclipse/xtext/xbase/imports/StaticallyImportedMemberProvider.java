/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.imports;

import com.google.inject.Inject;
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
      if (((!it.isStatic()) || (importedType == null))) {
        return CollectionLiterals.<JvmFeature>emptyList();
      }
      final IVisibilityHelper visibilityHelper = this.getVisibilityHelper(it.eResource());
      final IResolvedFeatures resolvedFeatures = this._provider.getResolvedFeatures(importedType);
      final Function1<JvmFeature, Boolean> _function = (JvmFeature feature) -> {
        return Boolean.valueOf(((feature.isStatic() && visibilityHelper.isVisible(feature)) && ((it.getMemberName() == null) || feature.getSimpleName().startsWith(it.getMemberName()))));
      };
      _xblockexpression = IterableExtensions.<JvmFeature>filter(resolvedFeatures.getAllFeatures(), _function);
    }
    return _xblockexpression;
  }
  
  public Iterable<JvmFeature> getAllFeatures(final XImportDeclaration it) {
    return this.getAllFeatures(it.eResource(), it.getImportedType(), it.isStatic(), it.isExtension(), it.getMemberName());
  }
  
  public Iterable<JvmFeature> getAllFeatures(final Resource resource, final JvmDeclaredType importedType, final boolean static_, final boolean extension, final String memberName) {
    Iterable<JvmFeature> _xblockexpression = null;
    {
      if (((!static_) || (importedType == null))) {
        return CollectionLiterals.<JvmFeature>emptyList();
      }
      final IVisibilityHelper visibilityHelper = this.getVisibilityHelper(resource);
      final IResolvedFeatures resolvedFeatures = this._provider.getResolvedFeatures(importedType);
      final Function1<JvmFeature, Boolean> _function = (JvmFeature feature) -> {
        return Boolean.valueOf((feature.isStatic() && visibilityHelper.isVisible(feature)));
      };
      _xblockexpression = IterableExtensions.<JvmFeature>filter(resolvedFeatures.getAllFeatures(memberName), _function);
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
        if ((packageName == null)) {
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
