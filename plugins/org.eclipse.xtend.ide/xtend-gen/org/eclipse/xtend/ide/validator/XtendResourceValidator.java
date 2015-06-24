/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.validator;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
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
      ResourceSetContext _get = ResourceSetContext.get(resource);
      boolean _isEditor = _get.isEditor();
      if (_isEditor) {
        EList<Adapter> _eAdapters = resource.eAdapters();
        Iterable<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter> _filter = Iterables.<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter>filter(_eAdapters, ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter.class);
        final ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter adapter = IterableExtensions.<ProcessorInstanceForJvmTypeProvider.ProcessorClassloaderAdapter>head(_filter);
        EList<Adapter> _eAdapters_1 = resource.eAdapters();
        _eAdapters_1.remove(adapter);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
