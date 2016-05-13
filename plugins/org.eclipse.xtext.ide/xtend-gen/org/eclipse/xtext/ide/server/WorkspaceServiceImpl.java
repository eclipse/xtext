/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.typefox.lsapi.DidChangeConfigurationParams;
import io.typefox.lsapi.DidChangeWatchedFilesParams;
import io.typefox.lsapi.InitializeParams;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.WorkspaceService;
import io.typefox.lsapi.WorkspaceSymbolParams;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.ide.server.IFileSystemScanner;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceServiceImpl implements WorkspaceService {
  @Inject
  protected IncrementalBuilder incrementalBuilder;
  
  @Inject
  protected IndexState indexState;
  
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  protected IResourceServiceProvider.Registry languagesRegistry;
  
  @Inject
  private IFileSystemScanner fileSystemScanner;
  
  public void initialize(final InitializeParams params, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor) {
    final ArrayList<URI> uris = CollectionLiterals.<URI>newArrayList();
    String _rootPath = params.getRootPath();
    URI _createFileURI = URI.createFileURI(_rootPath);
    final IAcceptor<URI> _function = new IAcceptor<URI>() {
      @Override
      public void accept(final URI it) {
        uris.add(it);
      }
    };
    this.fileSystemScanner.scan(_createFileURI, _function);
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function_1 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        String _rootPath = params.getRootPath();
        URI _createFileURI = URI.createFileURI(_rootPath);
        it.setBaseDir(_createFileURI);
        XtextResourceSet _get = WorkspaceServiceImpl.this.resourceSetProvider.get();
        it.setResourceSet(_get);
        it.setDirtyFiles(uris);
        final BuildRequest.IPostValidationCallback _function = new BuildRequest.IPostValidationCallback() {
          @Override
          public boolean afterValidate(final URI uri, final Iterable<Issue> issues) {
            boolean _isEmpty = IterableExtensions.isEmpty(issues);
            boolean _not = (!_isEmpty);
            if (_not) {
              acceptor.apply(uri, issues);
            }
            return true;
          }
        };
        it.setAfterValidate(_function);
      }
    };
    BuildRequest _doubleArrow = ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function_1);
    final Function1<URI, IResourceServiceProvider> _function_2 = new Function1<URI, IResourceServiceProvider>() {
      @Override
      public IResourceServiceProvider apply(final URI it) {
        return WorkspaceServiceImpl.this.languagesRegistry.getResourceServiceProvider(it);
      }
    };
    this.incrementalBuilder.build(_doubleArrow, _function_2);
  }
  
  @Override
  public void didChangeConfiguraton(final DidChangeConfigurationParams param) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void didChangeWatchedFiles(final DidChangeWatchedFilesParams param) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends SymbolInformation> symbol(final WorkspaceSymbolParams param) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
