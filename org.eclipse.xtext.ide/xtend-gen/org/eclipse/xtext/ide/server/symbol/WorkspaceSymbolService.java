/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.symbol;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class WorkspaceSymbolService {
  @Inject
  @Extension
  private IResourceServiceProvider.Registry _registry;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  public List<? extends SymbolInformation> getSymbols(final String query, final IReferenceFinder.IResourceAccess resourceAccess, final IResourceDescriptions indexData, final CancelIndicator cancelIndicator) {
    final LinkedList<SymbolInformation> result = CollectionLiterals.<SymbolInformation>newLinkedList();
    Iterable<IResourceDescription> _allResourceDescriptions = indexData.getAllResourceDescriptions();
    for (final IResourceDescription resourceDescription : _allResourceDescriptions) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        final IResourceServiceProvider resourceServiceProvider = this._registry.getResourceServiceProvider(resourceDescription.getURI());
        DocumentSymbolService _get = null;
        if (resourceServiceProvider!=null) {
          _get=resourceServiceProvider.<DocumentSymbolService>get(DocumentSymbolService.class);
        }
        final DocumentSymbolService documentSymbolService = _get;
        if ((documentSymbolService != null)) {
          List<? extends SymbolInformation> _symbols = documentSymbolService.getSymbols(resourceDescription, query, resourceAccess, cancelIndicator);
          Iterables.<SymbolInformation>addAll(result, _symbols);
        }
      }
    }
    return result;
  }
}
