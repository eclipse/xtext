/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;

/**
 * Superclass for services that support caching their results in the document. Such a service is
 * not necessarily precomputed automatically after a document change; this happens only if the
 * service is registered in the {@link PrecomputedServiceRegistry}.
 */
@SuppressWarnings("all")
public abstract class AbstractCachedService<T extends IServiceResult> {
  /**
   * If a cached result is available, that instance is returned. Otherwise a new result
   * is obtained with {@link #compute(IXtextWebDocument, CancelIndicator)}.
   */
  public T getResult(final XtextWebDocumentAccess it) {
    return it.<T>getCachedServiceResult(this, true);
  }
  
  /**
   * Perform the actual computations to obtain a result. This method should not be called
   * directly from the service dispatcher; use {@link #getResult(XtextWebDocumentAccess)} instead
   * in order to avoid duplicate computations.
   */
  public abstract T compute(final IXtextWebDocument it, final CancelIndicator cancelIndicator);
}
