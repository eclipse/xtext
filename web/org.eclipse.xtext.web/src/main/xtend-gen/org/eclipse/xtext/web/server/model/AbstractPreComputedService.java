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

@SuppressWarnings("all")
public abstract class AbstractPreComputedService<T extends IServiceResult> {
  public T getResult(final XtextWebDocumentAccess it) {
    return it.<T>getCachedResult(this, true);
  }
  
  public abstract T compute(final IXtextWebDocument it, final CancelIndicator cancelIndicator);
}
