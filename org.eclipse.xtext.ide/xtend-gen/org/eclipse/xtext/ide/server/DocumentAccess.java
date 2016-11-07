/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public interface DocumentAccess {
  @Data
  public static class Context {
    private final Resource resource;
    
    private final Document document;
    
    private final CancelIndicator cancelChecker;
    
    public Context(final Resource resource, final Document document, final CancelIndicator cancelChecker) {
      super();
      this.resource = resource;
      this.document = document;
      this.cancelChecker = cancelChecker;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.resource== null) ? 0 : this.resource.hashCode());
      result = prime * result + ((this.document== null) ? 0 : this.document.hashCode());
      result = prime * result + ((this.cancelChecker== null) ? 0 : this.cancelChecker.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      DocumentAccess.Context other = (DocumentAccess.Context) obj;
      if (this.resource == null) {
        if (other.resource != null)
          return false;
      } else if (!this.resource.equals(other.resource))
        return false;
      if (this.document == null) {
        if (other.document != null)
          return false;
      } else if (!this.document.equals(other.document))
        return false;
      if (this.cancelChecker == null) {
        if (other.cancelChecker != null)
          return false;
      } else if (!this.cancelChecker.equals(other.cancelChecker))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("resource", this.resource);
      b.add("document", this.document);
      b.add("cancelChecker", this.cancelChecker);
      return b.toString();
    }
    
    @Pure
    public Resource getResource() {
      return this.resource;
    }
    
    @Pure
    public Document getDocument() {
      return this.document;
    }
    
    @Pure
    public CancelIndicator getCancelChecker() {
      return this.cancelChecker;
    }
  }
  
  public abstract <T extends Object> CompletableFuture<T> doRead(final String uri, final Function<DocumentAccess.Context, T> function);
  
  public static DocumentAccess create(final Supplier<RequestManager> requestManagerSupplier, final Supplier<WorkspaceManager> workspaceManagerSupplier, final Function1<? super String, ? extends URI> uriFactory) {
    return new DocumentAccess() {
      @Override
      public <T extends Object> CompletableFuture<T> doRead(final String uri, final Function<DocumentAccess.Context, T> function) {
        RequestManager _get = requestManagerSupplier.get();
        final Function1<CancelIndicator, T> _function = (CancelIndicator cancelIndicator) -> {
          WorkspaceManager _get_1 = workspaceManagerSupplier.get();
          URI _apply = uriFactory.apply(uri);
          final Function2<Document, XtextResource, T> _function_1 = (Document document, XtextResource resource) -> {
            final DocumentAccess.Context ctx = new DocumentAccess.Context(resource, document, cancelIndicator);
            return function.apply(ctx);
          };
          return _get_1.<T>doRead(_apply, _function_1);
        };
        return _get.<T>runRead(_function);
      }
    };
  }
}
