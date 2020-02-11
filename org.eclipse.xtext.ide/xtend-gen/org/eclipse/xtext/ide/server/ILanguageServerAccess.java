/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * API for interacting with a running language server.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public interface ILanguageServerAccess {
  @Data
  class Context {
    private final Resource resource;
    
    private final Document document;
    
    private final boolean isDocumentOpen;
    
    private final CancelIndicator cancelChecker;
    
    public Context(final Resource resource, final Document document, final boolean isDocumentOpen, final CancelIndicator cancelChecker) {
      super();
      this.resource = resource;
      this.document = document;
      this.isDocumentOpen = isDocumentOpen;
      this.cancelChecker = cancelChecker;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.resource== null) ? 0 : this.resource.hashCode());
      result = prime * result + ((this.document== null) ? 0 : this.document.hashCode());
      result = prime * result + (this.isDocumentOpen ? 1231 : 1237);
      return prime * result + ((this.cancelChecker== null) ? 0 : this.cancelChecker.hashCode());
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
      ILanguageServerAccess.Context other = (ILanguageServerAccess.Context) obj;
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
      if (other.isDocumentOpen != this.isDocumentOpen)
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
      b.add("isDocumentOpen", this.isDocumentOpen);
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
    public boolean isDocumentOpen() {
      return this.isDocumentOpen;
    }
    
    @Pure
    public CancelIndicator getCancelChecker() {
      return this.cancelChecker;
    }
  }
  
  @Data
  class IndexContext {
    private final IResourceDescriptions index;
    
    private final CancelIndicator cancelChecker;
    
    public IndexContext(final IResourceDescriptions index, final CancelIndicator cancelChecker) {
      super();
      this.index = index;
      this.cancelChecker = cancelChecker;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.index== null) ? 0 : this.index.hashCode());
      return prime * result + ((this.cancelChecker== null) ? 0 : this.cancelChecker.hashCode());
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
      ILanguageServerAccess.IndexContext other = (ILanguageServerAccess.IndexContext) obj;
      if (this.index == null) {
        if (other.index != null)
          return false;
      } else if (!this.index.equals(other.index))
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
      b.add("index", this.index);
      b.add("cancelChecker", this.cancelChecker);
      return b.toString();
    }
    
    @Pure
    public IResourceDescriptions getIndex() {
      return this.index;
    }
    
    @Pure
    public CancelIndicator getCancelChecker() {
      return this.cancelChecker;
    }
  }
  
  interface IBuildListener {
    void afterBuild(final List<IResourceDescription.Delta> deltas);
  }
  
  /**
   * provides read access to a fully resolved resource and Document.
   */
  <T extends Object> CompletableFuture<T> doRead(final String uri, final Function<ILanguageServerAccess.Context, T> function);
  
  /**
   * Provides read access to the Xtext index.
   * 
   * @since 2.18
   */
  <T extends Object> CompletableFuture<T> doReadIndex(final Function<? super ILanguageServerAccess.IndexContext, ? extends T> function);
  
  /**
   * registers a build listener on the this language server
   */
  void addBuildListener(final ILanguageServerAccess.IBuildListener listener);
  
  /**
   * @return the language client facade. It usually also implements Endpoint, which can be used to
   * call non-standard extensions to the LSP.
   */
  LanguageClient getLanguageClient();
  
  /**
   * Creates a new {@link ResourceSet} to be used with the {@link IChangeSerializer} API.
   * 
   * The {@link IChangeSerializer} allows to calculate text edits from model changes.
   * In order not to mess up the originals, the resp. models should be loaded into a
   * new resource set which this method provides.
   * 
   * @param uri a file URI used to detect the project to configure the scope of the resource set.
   * @return a new empty resource set, configured with the project the <code>uri</code>
   *   belongs to and the {@link ResourceDescriptionsProvider#LIVE_SCOPE} in order to
   *   reflect model changes immediately.
   * @since 2.18
   */
  ResourceSet newLiveScopeResourceSet(final URI uri);
  
  /**
   * @return the parameters as negotiated during client and server on initialization.
   * @since 2.18
   */
  InitializeParams getInitializeParams();
  
  /**
   * Returns with the {@link InitializeResult} of the LS.
   * 
   * @since 2.18
   */
  InitializeResult getInitializeResult();
}
