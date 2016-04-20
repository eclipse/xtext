/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.outline;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.jvmmodel.XtendJvmModelInferrer;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtend.ide.outline.EclipseXtendOutlineContext;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseXtendOutlineSourceContext extends EclipseXtendOutlineContext {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private Provider<EclipseXtendOutlineSourceContext> xtendOutlineContextProvider;
  
  @Override
  public IXtendOutlineContext markAsProcessed(final JvmMember member) {
    EclipseXtendOutlineSourceContext _xblockexpression = null;
    {
      super.markAsProcessed(member);
      this.markCreateExtensionJvmFeaturesAsProcessed(member);
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  protected void markCreateExtensionJvmFeaturesAsProcessed(final JvmMember member) {
    final EObject function = this._iXtendJvmAssociations.getPrimarySourceElement(member);
    if ((function instanceof XtendFunction)) {
      CreateExtensionInfo _createExtensionInfo = ((XtendFunction)function).getCreateExtensionInfo();
      boolean _notEquals = (!Objects.equal(_createExtensionInfo, null));
      if (_notEquals) {
        Set<EObject> _jvmElements = this._iXtendJvmAssociations.getJvmElements(function);
        Iterable<JvmFeature> _filter = Iterables.<JvmFeature>filter(_jvmElements, JvmFeature.class);
        final Function1<JvmFeature, Boolean> _function = new Function1<JvmFeature, Boolean>() {
          @Override
          public Boolean apply(final JvmFeature it) {
            return Boolean.valueOf((!Objects.equal(it, member)));
          }
        };
        Iterable<JvmFeature> _filter_1 = IterableExtensions.<JvmFeature>filter(_filter, _function);
        final Function1<JvmFeature, Boolean> _function_1 = new Function1<JvmFeature, Boolean>() {
          @Override
          public Boolean apply(final JvmFeature it) {
            return Boolean.valueOf((it.getSimpleName().startsWith(XtendJvmModelInferrer.CREATE_CHACHE_VARIABLE_PREFIX) || 
              it.getSimpleName().startsWith(XtendJvmModelInferrer.CREATE_INITIALIZER_PREFIX)));
          }
        };
        Iterable<JvmFeature> _filter_2 = IterableExtensions.<JvmFeature>filter(_filter_1, _function_1);
        for (final JvmFeature jvmFeature : _filter_2) {
          super.markAsProcessed(jvmFeature);
        }
      }
    }
  }
  
  @Override
  protected EclipseXtendOutlineContext cloneContext() {
    EclipseXtendOutlineSourceContext _get = this.xtendOutlineContextProvider.get();
    return this.cloneContext(_get);
  }
}
