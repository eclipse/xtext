/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.model;

import org.eclipse.xtext.web.server.IServiceContext;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Provider for document instances.
 */
@ImplementedBy(IWebDocumentProvider.DefaultImpl.class)
public interface IWebDocumentProvider {
  /**
   * The default implementation creates one document synchronizer per session. If stateless
   * mode is requested, each document gets its own synchronizer.
   */
  class DefaultImpl implements IWebDocumentProvider {
    @Inject
    private Provider<DocumentSynchronizer> synchronizerProvider;
    
    @Override
    public XtextWebDocument get(String resourceId, IServiceContext serviceContext) {
      if (resourceId == null) {
        return new XtextWebDocument(resourceId, synchronizerProvider.get());
      } else {
        return new XtextWebDocument(resourceId, serviceContext.getSession().get(DocumentSynchronizer.class,  () -> this.synchronizerProvider.get()));
      }
    }
  }
  
  /**
   * Creates and configures a document. The resourceId may be {@code null}, which means that
   * the request should be processed in stateless mode. Fetching the session from the service
   * context should be avoided in this case.
   */
  XtextWebDocument get(String resourceId, IServiceContext serviceContext);
}
