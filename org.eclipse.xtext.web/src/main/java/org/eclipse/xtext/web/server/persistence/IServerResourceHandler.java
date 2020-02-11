/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
public interface IServerResourceHandler {
  class NullImpl implements IServerResourceHandler {
    @Override
    public XtextWebDocument get(String resourceId, IServiceContext serviceContext) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
    
    @Override
    public void put(IXtextWebDocument document, IServiceContext serviceContext) throws IOException {
      throw new IOException("This server does not support resource handling.");
    }
  }
  
  XtextWebDocument get(String resourceId, IServiceContext serviceContext) throws IOException;
  
  void put(IXtextWebDocument document, IServiceContext serviceContext) throws IOException;
}
