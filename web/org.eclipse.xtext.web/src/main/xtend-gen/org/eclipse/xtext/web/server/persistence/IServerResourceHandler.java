/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import java.io.IOException;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.web.server.model.XtextDocument;

@SuppressWarnings("all")
public interface IServerResourceHandler {
  public static class NullImpl implements IServerResourceHandler {
    @Override
    public XtextDocument get(final String resourceId, final XtextResourceSet resourceSet) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
    
    @Override
    public void put(final XtextDocument.ReadAccess documentAccess, final IEncodingProvider encodingProvider) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
  }
  
  public abstract XtextDocument get(final String resourceId, final XtextResourceSet resourceSet) throws IOException;
  
  public abstract void put(final XtextDocument.ReadAccess documentAccess, final IEncodingProvider encodingProvider) throws IOException;
}
