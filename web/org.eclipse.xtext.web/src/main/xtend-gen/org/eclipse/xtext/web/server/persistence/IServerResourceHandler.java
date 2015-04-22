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
import org.eclipse.xtext.web.server.model.XtextDocument;

@ImplementedBy(IServerResourceHandler.NullImpl.class)
@SuppressWarnings("all")
public interface IServerResourceHandler {
  public static class NullImpl implements IServerResourceHandler {
    @Override
    public XtextDocument get(final String resourceId) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
    
    @Override
    public void put(final XtextDocument.ReadAccess documentAccess) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
  }
  
  public abstract XtextDocument get(final String resourceId) throws IOException;
  
  public abstract void put(final XtextDocument.ReadAccess documentAccess) throws IOException;
}
