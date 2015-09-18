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
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
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
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import org.eclipse.xtext.idea.resource.IdeaClasspathURIResolver;
import org.eclipse.xtext.idea.resource.ProjectDescriptionProvider;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Singleton
@Log
@SuppressWarnings("all")
public class IdeaResourceSetProvider {
  public static class VirtualFileBasedUriHandler implements URIHandler {
    @Accessors
    public static class ContentDescriptor {
      private byte[] content;
      
      private long timeStamp;
      
      @Pure
      public byte[] getContent() {
        return this.content;
      }
      
      public void setContent(final byte[] content) {
        this.content = content;
      }
      
      @Pure
      public long getTimeStamp() {
        return this.timeStamp;
      }
      
      public void setTimeStamp(final long timeStamp) {
        this.timeStamp = timeStamp;
      }
    }
    
    public static IdeaResourceSetProvider.VirtualFileBasedUriHandler find(final Notifier notifier) {
      ResourceSet _resourceSet = EcoreUtil2.getResourceSet(notifier);
      URIConverter _uRIConverter = _resourceSet.getURIConverter();
      EList<URIHandler> _uRIHandlers = _uRIConverter.getURIHandlers();
      Iterable<IdeaResourceSetProvider.VirtualFileBasedUriHandler> _filter = Iterables.<IdeaResourceSetProvider.VirtualFileBasedUriHandler>filter(_uRIHandlers, IdeaResourceSetProvider.VirtualFileBasedUriHandler.class);
      return IterableExtensions.<IdeaResourceSetProvider.VirtualFileBasedUriHandler>head(_filter);
    }
    
    @Accessors
    private Map<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor> writtenContents = CollectionLiterals.<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>newHashMap();
    
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
      final Map<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor> localWritten = this.writtenContents;
      HashMap<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor> _newHashMap = CollectionLiterals.<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>newHashMap();
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
            FileDocumentManager _instance = FileDocumentManager.getInstance();
            _instance.saveAllDocuments();
            Set<URI> _keySet = localWritten.keySet();
            for (final URI uri : _keySet) {
              {
                VirtualFile file = VirtualFileURIUtil.getOrCreateVirtualFile(uri);
                final IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor contentDescriptor = localWritten.get(uri);
                final byte[] newContent = contentDescriptor.content;
                final byte[] oldContent = file.contentsToByteArray();
                boolean _equals = Arrays.equals(newContent, oldContent);
                boolean _not = (!_equals);
                if (_not) {
                  Object _requestor = VirtualFileBasedUriHandler.this.getRequestor();
                  file.setBinaryContent(newContent, (-1), contentDescriptor.timeStamp, _requestor);
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
        IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor _get = this.writtenContents.get(uri);
        return new ByteArrayInputStream(_get.content);
      }
      final VirtualFile virtualFile = VirtualFileURIUtil.getVirtualFile(uri);
      boolean _equals = Objects.equal(virtualFile, null);
      if (_equals) {
        throw new FileNotFoundException(("Couldn\'t find virtual file for " + uri));
      }
      FileDocumentManager _instance = FileDocumentManager.getInstance();
      final Document cachedDocument = _instance.getCachedDocument(virtualFile);
      boolean _notEquals = (!Objects.equal(cachedDocument, null));
      if (_notEquals) {
        String _text = cachedDocument.getText();
        Charset _charset = virtualFile.getCharset();
        return new LazyStringInputStream(_text, _charset);
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
          final IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor contentDescriptor = new IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor();
          contentDescriptor.content = bytes;
          long _currentTimeMillis = System.currentTimeMillis();
          contentDescriptor.timeStamp = _currentTimeMillis;
          VirtualFileBasedUriHandler.this.writtenContents.put(uri, contentDescriptor);
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
      IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor _folderDescriptor = this.getFolderDescriptor(uri);
      boolean _notEquals = (!Objects.equal(_folderDescriptor, null));
      if (_notEquals) {
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
      boolean _contains = this.deleted.contains(uri);
      if (_contains) {
        return CollectionLiterals.<String, Object>emptyMap();
      }
      Object _get = options.get(URIConverter.OPTION_REQUESTED_ATTRIBUTES);
      final Set<String> requestedAttributes = ((Set<String>) _get);
      boolean _or = false;
      boolean _equals = Objects.equal(requestedAttributes, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _isEmpty = requestedAttributes.isEmpty();
        _or = _isEmpty;
      }
      if (_or) {
        return CollectionLiterals.<String, Object>emptyMap();
      }
      final IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor fileDescriptor = this.writtenContents.get(uri);
      boolean _notEquals = (!Objects.equal(fileDescriptor, null));
      if (_notEquals) {
        final HashMap<String, Object> attributes = CollectionLiterals.<String, Object>newHashMap();
        boolean _contains_1 = requestedAttributes.contains(URIConverter.ATTRIBUTE_DIRECTORY);
        if (_contains_1) {
          attributes.put(URIConverter.ATTRIBUTE_DIRECTORY, Boolean.valueOf(false));
        }
        boolean _contains_2 = requestedAttributes.contains(URIConverter.ATTRIBUTE_TIME_STAMP);
        if (_contains_2) {
          attributes.put(URIConverter.ATTRIBUTE_TIME_STAMP, Long.valueOf(fileDescriptor.timeStamp));
        }
        return attributes;
      }
      final IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor folderDescriptor = this.getFolderDescriptor(uri);
      boolean _notEquals_1 = (!Objects.equal(folderDescriptor, null));
      if (_notEquals_1) {
        final HashMap<String, Object> attributes_1 = CollectionLiterals.<String, Object>newHashMap();
        boolean _contains_3 = requestedAttributes.contains(URIConverter.ATTRIBUTE_DIRECTORY);
        if (_contains_3) {
          attributes_1.put(URIConverter.ATTRIBUTE_DIRECTORY, Boolean.valueOf(true));
        }
        boolean _contains_4 = requestedAttributes.contains(URIConverter.ATTRIBUTE_TIME_STAMP);
        if (_contains_4) {
          attributes_1.put(URIConverter.ATTRIBUTE_TIME_STAMP, Long.valueOf(folderDescriptor.timeStamp));
        }
        return attributes_1;
      }
      final VirtualFile file = VirtualFileURIUtil.getVirtualFile(uri);
      boolean _notEquals_2 = (!Objects.equal(file, null));
      if (_notEquals_2) {
        final HashMap<String, Object> attributes_2 = CollectionLiterals.<String, Object>newHashMap();
        boolean _contains_5 = requestedAttributes.contains(URIConverter.ATTRIBUTE_DIRECTORY);
        if (_contains_5) {
          boolean _isDirectory = file.isDirectory();
          attributes_2.put(URIConverter.ATTRIBUTE_DIRECTORY, Boolean.valueOf(_isDirectory));
        }
        boolean _contains_6 = requestedAttributes.contains(URIConverter.ATTRIBUTE_TIME_STAMP);
        if (_contains_6) {
          long _timeStamp = file.getTimeStamp();
          attributes_2.put(URIConverter.ATTRIBUTE_TIME_STAMP, Long.valueOf(_timeStamp));
        }
        return attributes_2;
      }
      return CollectionLiterals.<String, Object>emptyMap();
    }
    
    protected IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor getFolderDescriptor(final URI uri) {
      Set<Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>> _entrySet = this.writtenContents.entrySet();
      final Function1<Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>, Boolean> _function = new Function1<Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>, Boolean>() {
        @Override
        public Boolean apply(final Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor> fileDescriptor) {
          boolean _xblockexpression = false;
          {
            URI _key = fileDescriptor.getKey();
            final URI relativeURI = _key.deresolve(uri);
            URI _key_1 = fileDescriptor.getKey();
            _xblockexpression = (!Objects.equal(relativeURI, _key_1));
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      Iterable<Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>> _filter = IterableExtensions.<Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>>filter(_entrySet, _function);
      Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor> _head = IterableExtensions.<Map.Entry<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor>>head(_filter);
      IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor _value = null;
      if (_head!=null) {
        _value=_head.getValue();
      }
      return _value;
    }
    
    @Override
    public void setAttributes(final URI uri, final Map<String, ?> attributes, final Map<?, ?> options) throws IOException {
    }
    
    public Set<URI> getChildren(final URI uri) {
      Set<URI> _xblockexpression = null;
      {
        final VirtualFile file = VirtualFileURIUtil.getVirtualFile(uri);
        Set<URI> _xifexpression = null;
        boolean _notEquals = (!Objects.equal(file, null));
        if (_notEquals) {
          VirtualFile[] _children = file.getChildren();
          final Function1<VirtualFile, URI> _function = new Function1<VirtualFile, URI>() {
            @Override
            public URI apply(final VirtualFile it) {
              return VirtualFileURIUtil.getURI(it);
            }
          };
          List<URI> _map = ListExtensions.<VirtualFile, URI>map(((List<VirtualFile>)Conversions.doWrapArray(_children)), _function);
          _xifexpression = IterableExtensions.<URI>toSet(_map);
        } else {
          _xifexpression = CollectionLiterals.<URI>newLinkedHashSet();
        }
        final Set<URI> children = _xifexpression;
        Set<URI> _keySet = this.writtenContents.keySet();
        final Function1<URI, URI> _function_1 = new Function1<URI, URI>() {
          @Override
          public URI apply(final URI uriToWrite) {
            URI _xblockexpression = null;
            {
              final URI relativeURI = uriToWrite.deresolve(uri);
              URI _xifexpression = null;
              boolean _and = false;
              boolean _isEmpty = relativeURI.isEmpty();
              boolean _not = (!_isEmpty);
              if (!_not) {
                _and = false;
              } else {
                boolean _notEquals = (!Objects.equal(relativeURI, uriToWrite));
                _and = _notEquals;
              }
              if (_and) {
                int _segmentCount = relativeURI.segmentCount();
                int _minus = (_segmentCount - 1);
                URI _trimSegments = relativeURI.trimSegments(_minus);
                _xifexpression = _trimSegments.resolve(uri);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          }
        };
        Iterable<URI> _map_1 = IterableExtensions.<URI, URI>map(_keySet, _function_1);
        Iterable<URI> _filterNull = IterableExtensions.<URI>filterNull(_map_1);
        Iterables.<URI>addAll(children, _filterNull);
        Iterables.removeAll(children, this.deleted);
        _xblockexpression = children;
      }
      return _xblockexpression;
    }
    
    @Pure
    public Map<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor> getWrittenContents() {
      return this.writtenContents;
    }
    
    public void setWrittenContents(final Map<URI, IdeaResourceSetProvider.VirtualFileBasedUriHandler.ContentDescriptor> writtenContents) {
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
  
  @Inject
  private Provider<IdeaClasspathURIResolver> classpathURIResolverProvider;
  
  public XtextResourceSet get(final Module module) {
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    resourceSet.setClasspathURIContext(module);
    IdeaClasspathURIResolver _get = this.classpathURIResolverProvider.get();
    resourceSet.setClasspathUriResolver(_get);
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
