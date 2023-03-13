/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.outline;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.jvmmodel.XtendJvmModelInferrer;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
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
      boolean _tripleNotEquals = (_createExtensionInfo != null);
      if (_tripleNotEquals) {
        final Function1<JvmFeature, Boolean> _function = (JvmFeature it) -> {
          return Boolean.valueOf((!Objects.equal(it, member)));
        };
        final Function1<JvmFeature, Boolean> _function_1 = (JvmFeature it) -> {
          return Boolean.valueOf((it.getSimpleName().startsWith(XtendJvmModelInferrer.CREATE_CHACHE_VARIABLE_PREFIX) || 
            it.getSimpleName().startsWith(XtendJvmModelInferrer.CREATE_INITIALIZER_PREFIX)));
        };
        Iterable<JvmFeature> _filter = IterableExtensions.<JvmFeature>filter(IterableExtensions.<JvmFeature>filter(Iterables.<JvmFeature>filter(this._iXtendJvmAssociations.getJvmElements(function), JvmFeature.class), _function), _function_1);
        for (final JvmFeature jvmFeature : _filter) {
          super.markAsProcessed(jvmFeature);
        }
      }
    }
  }

  @Override
  protected EclipseXtendOutlineContext cloneContext() {
    return this.cloneContext(this.xtendOutlineContextProvider.get());
  }
}
