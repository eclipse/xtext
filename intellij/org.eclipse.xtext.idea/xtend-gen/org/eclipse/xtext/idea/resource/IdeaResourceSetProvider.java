/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.common.types.StubTypeProviderFactory;
import org.eclipse.xtext.idea.resource.ProjectDescriptionProvider;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Singleton
@Log
@SuppressWarnings("all")
public class IdeaResourceSetProvider {
  public static class VirtualFileBasedUriHandler implements URIHandler {
    public static IdeaResourceSetProvider.VirtualFileBasedUriHandler find(final Notifier notifier) {
      ResourceSet _resourceSet = EcoreUtil2.getResourceSet(notifier);
      URIConverter _uRIConverter = _resourceSet.getURIConverter();
      EList<URIHandler> _uRIHandlers = _uRIConverter.getURIHandlers();
      Iterable<IdeaResourceSetProvider.VirtualFileBasedUriHandler> _filter = Iterables.<IdeaResourceSetProvider.VirtualFileBasedUriHandler>filter(_uRIHandlers, IdeaResourceSetProvider.VirtualFileBasedUriHandler.class);
      return IterableExtensions.<IdeaResourceSetProvider.VirtualFileBasedUriHandler>head(_filter);
    }
    
    @Accessors
    private Map<URI, byte[]> writtenContents = CollectionLiterals.<URI, byte[]>newHashMap();
    
    @Accessors
    private Set<URI> deleted = CollectionLiterals.<URI>newHashSet();
    
    @Override
    public boolean canHandle(final URI uri) {
      return true;
    }
    
    public void flushToDisk() {
      boolean _isDebugEnabled = IdeaResourceSetProvider.LOG.isDebugEnabled();
      if (_isDebugEnabled) {
        Set<URI> _keySet = this.writtenContents.keySet();
        String _join = IterableExtensions.join(_keySet, ", ");
        String _plus = ("writing : " + _join);
        IdeaResourceSetProvider.LOG.debug(_plus);
        String _join_1 = IterableExtensions.join(this.deleted, ", ");
        String _plus_1 = ("deleting: " + _join_1);
        IdeaResourceSetProvider.LOG.debug(_plus_1);
      }
      final Map<URI, byte[]> localWritten = this.writtenContents;
      HashMap<URI, byte[]> _newHashMap = CollectionLiterals.<URI, byte[]>newHashMap();
      this.writtenContents = _newHashMap;
      final Set<URI> localDeleted = this.deleted;
      HashSet<URI> _newHashSet = CollectionLiterals.<URI>newHashSet();
      this.deleted = _newHashSet;
      boolean _and = false;
      boolean _isEmpty = localDeleted.isEmpty();
      if (!_isEmpty) {
        _and = false;
      } else {
        boolean _isEmpty_1 = localWritten.isEmpty();
        _and = _isEmpty_1;
      }
      if (_and) {
        return;
      }
      Application _application = ApplicationManager.getApplication();
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          try {
            final long timeStamp = System.currentTimeMillis();
            Set<URI> _keySet = localWritten.keySet();
            for (final URI uri : _keySet) {
              {
                VirtualFile file = VirtualFileURIUtil.getOrCreateVirtualFile(uri);
                final byte[] newContent = localWritten.get(uri);
                final byte[] oldContent = file.contentsToByteArray();
                boolean _equals = Arrays.equals(newContent, oldContent);
                boolean _not = (!_equals);
                if (_not) {
                  Object _requestor = VirtualFileBasedUriHandler.this.getRequestor();
                  file.setBinaryContent(newContent, (-1), timeStamp, _requestor);
                }
              }
            }
            for (final URI uri_1 : localDeleted) {
              {
                final VirtualFile file = VirtualFileURIUtil.getVirtualFile(uri_1);
                boolean _and = false;
                boolean _notEquals = (!Objects.equal(file, null));
                if (!_notEquals) {
                  _and = false;
                } else {
                  boolean _exists = file.exists();
                  _and = _exists;
                }
                if (_and) {
                  Object _requestor = VirtualFileBasedUriHandler.this.getRequestor();
                  file.delete(_requestor);
                }
              }
            }
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      _application.runWriteAction(_function);
    }
    
    @Override
    public Map<String, ?> contentDescription(final URI uri, final Map<?, ?> options) throws IOException {
      return CollectionLiterals.<String, Object>emptyMap();
    }
    
    @Override
    public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException {
      boolean _contains = this.deleted.contains(uri);
      if (_contains) {
        throw new IOException((("resource " + uri) + " is deleted."));
      }
      boolean _containsKey = this.writtenContents.containsKey(uri);
      if (_containsKey) {
        byte[] _get = this.writtenContents.get(uri);
        return new ByteArrayInputStream(_get);
      }
      final VirtualFile virtualFile = VirtualFileURIUtil.getVirtualFile(uri);
      boolean _equals = Objects.equal(virtualFile, null);
      if (_equals) {
        throw new FileNotFoundException(("Couldn\'t find virtual file for " + uri));
      }
      Application _application = ApplicationManager.getApplication();
      final Computable<InputStream> _function = new Computable<InputStream>() {
        @Override
        public InputStream compute() {
          try {
            byte[] _contentsToByteArray = virtualFile.contentsToByteArray();
            return new ByteArrayInputStream(_contentsToByteArray);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      return _application.<InputStream>runReadAction(_function);
    }
    
    @Override
    public OutputStream createOutputStream(final URI uri, final Map<?, ?> options) throws IOException {
      return new ByteArrayOutputStream() {
        @Override
        public void close() throws IOException {
          super.close();
          final byte[] bytes = this.toByteArray();
          VirtualFileBasedUriHandler.this.deleted.remove(uri);
          VirtualFileBasedUriHandler.this.writtenContents.put(uri, bytes);
        }
      };
    }
    
    @Override
    public void delete(final URI uri, final Map<?, ?> options) throws IOException {
      this.writtenContents.remove(uri);
      this.deleted.add(uri);
    }
    
    public Object getRequestor() {
      return null;
    }
    
    @Override
    public boolean exists(final URI uri, final Map<?, ?> options) {
      boolean _contains = this.deleted.contains(uri);
      if (_contains) {
        return false;
      }
      boolean _containsKey = this.writtenContents.containsKey(uri);
      if (_containsKey) {
        return true;
      }
      VirtualFile _virtualFile = VirtualFileURIUtil.getVirtualFile(uri);
      boolean _exists = false;
      if (_virtualFile!=null) {
        _exists=_virtualFile.exists();
      }
      return _exists;
    }
    
    @Override
    public Map<String, ?> getAttributes(final URI uri, final Map<?, ?> options) {
      return CollectionLiterals.<String, Object>emptyMap();
    }
    
    @Override
    public void setAttributes(final URI uri, final Map<String, ?> attributes, final Map<?, ?> options) throws IOException {
    }
    
    @Pure
    public Map<URI, byte[]> getWrittenContents() {
      return this.writtenContents;
    }
    
    public void setWrittenContents(final Map<URI, byte[]> writtenContents) {
      this.writtenContents = writtenContents;
    }
    
    @Pure
    public Set<URI> getDeleted() {
      return this.deleted;
    }
    
    public void setDeleted(final Set<URI> deleted) {
      this.deleted = deleted;
    }
  }
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private StubTypeProviderFactory stubTypeProviderFactory;
  
  @Inject
  private ProjectDescriptionProvider projectDescriptionProvider;
  
  public XtextResourceSet get(final Module module) {
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    resourceSet.setClasspathURIContext(module);
    URIConverter _uRIConverter = resourceSet.getURIConverter();
    EList<URIHandler> _uRIHandlers = _uRIConverter.getURIHandlers();
    _uRIHandlers.clear();
    URIConverter _uRIConverter_1 = resourceSet.getURIConverter();
    EList<URIHandler> _uRIHandlers_1 = _uRIConverter_1.getURIHandlers();
    IdeaResourceSetProvider.VirtualFileBasedUriHandler _virtualFileBasedUriHandler = new IdeaResourceSetProvider.VirtualFileBasedUriHandler();
    _uRIHandlers_1.add(_virtualFileBasedUriHandler);
    final ProjectDescription desc = this.projectDescriptionProvider.getProjectDescription(module);
    desc.attachToEmfObject(resourceSet);
    Project _project = module.getProject();
    final XtextAutoBuilderComponent builder = _project.<XtextAutoBuilderComponent>getComponent(XtextAutoBuilderComponent.class);
    builder.installCopyOfResourceDescriptions(resourceSet);
    this.stubTypeProviderFactory.createTypeProvider(resourceSet);
    return resourceSet;
  }
  
  private final static Logger LOG = Logger.getLogger(IdeaResourceSetProvider.class);
}
