/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.model.DocumentSynchronizer;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * Provider for document instances.
 */
@ImplementedBy(IWebDocumentProvider.DefaultImpl.class)
@SuppressWarnings("all")
public interface IWebDocumentProvider {
  /**
   * The default implementation creates one document synchronizer per session. If stateless
   * mode is requested, each document gets its own synchronizer.
   */
  public static class DefaultImpl implements IWebDocumentProvider {
    @Inject
    private Provider<DocumentSynchronizer> synchronizerProvider;
    
    @Override
    public XtextWebDocument get(final String resourceId, final IServiceContext serviceContext) {
      XtextWebDocument _xblockexpression = null;
      {
        DocumentSynchronizer _xifexpression = null;
        if ((resourceId == null)) {
          _xifexpression = this.synchronizerProvider.get();
        } else {
          ISession _session = serviceContext.getSession();
          final Function0<DocumentSynchronizer> _function = new Function0<DocumentSynchronizer>() {
            @Override
            public DocumentSynchronizer apply() {
              return DefaultImpl.this.synchronizerProvider.get();
            }
          };
          _xifexpression = _session.<DocumentSynchronizer>get(DocumentSynchronizer.class, _function);
        }
        final DocumentSynchronizer synchronizer = _xifexpression;
        _xblockexpression = new XtextWebDocument(resourceId, synchronizer);
      }
      return _xblockexpression;
    }
  }
  
  /**
   * Creates and configures a document. The resourceId may be {@code null}, which means that
   * the request should be processed in stateless mode. Fetching the session from the service
   * context should be avoided in this case.
   */
  public abstract XtextWebDocument get(final String resourceId, final IServiceContext serviceContext);
}
