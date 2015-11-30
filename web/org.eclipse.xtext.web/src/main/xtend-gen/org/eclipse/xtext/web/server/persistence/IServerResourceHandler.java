/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import com.google.inject.ImplementedBy;
import java.io.IOException;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocument;

/**
 * Interface for <em>get</em> and <em>put</em> operations on documents. Implementations can
 * use arbitrary persistence technology for performing these operations.
 */
@ImplementedBy(IServerResourceHandler.NullImpl.class)
@SuppressWarnings("all")
public interface IServerResourceHandler {
  public static class NullImpl implements IServerResourceHandler {
    @Override
    public XtextWebDocument get(final String resourceId, final IServiceContext serviceContext) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
    
    @Override
    public void put(final IXtextWebDocument document, final IServiceContext serviceContext) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
  }
  
  public abstract XtextWebDocument get(final String resourceId, final IServiceContext serviceContext) throws IOException;
  
  public abstract void put(final IXtextWebDocument document, final IServiceContext serviceContext) throws IOException;
}
