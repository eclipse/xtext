/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.validator;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.validation.CachingResourceValidatorImpl;
import org.eclipse.xtext.resource.ResourceSetContext;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendResourceValidator extends CachingResourceValidatorImpl {
  @Override
  public List<Issue> validate(final Resource resource, final CheckMode mode, final CancelIndicator mon) throws OperationCanceledError {
    List<Issue> _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = super.validate(resource, mode, mon);
    } finally {
      boolean _isEditor = ResourceSetContext.get(resource).isEditor();
      if (_isEditor) {
        final ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter adapter = IterableExtensions.<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter>head(Iterables.<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter>filter(resource.eAdapters(), ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter.class));
        resource.eAdapters().remove(adapter);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
