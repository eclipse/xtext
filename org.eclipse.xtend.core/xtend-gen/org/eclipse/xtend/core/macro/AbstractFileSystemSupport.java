/**
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {
  @Inject
  @Accessors
  private IEncodingProvider encodingProvider;

  @Inject(optional = true)
  @Accessors
  private IFilePostProcessor postProcessor;

  @Inject
  @Accessors
  @Extension
  private IProjectConfigProvider projectConfigProvider;

  @Accessors
  private ResourceSet context;

  @Override
  public CharSequence getContents(final Path path) {
    try {
      InputStream _contentsAsStream = this.getContentsAsStream(path);
      String _charset = this.getCharset(path);
      final InputStreamReader reader = new InputStreamReader(_contentsAsStream, _charset);
      IOException threw = null;
      try {
        return CharStreams.toString(reader);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          threw = e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        try {
          reader.close();
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof IOException) {
            final IOException e_1 = (IOException)_t_1;
            if ((threw == null)) {
              threw = e_1;
            }
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
      if ((threw == null)) {
        throw new AssertionError("threw cannot be null here");
      }
      throw threw;
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException exc = (IOException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Override
  public void setContents(final Path path, final CharSequence contents) {
    final URI uri = this.getURI(path);
    if ((uri == null)) {
      throw new IllegalArgumentException(("The file cannot be found: " + path));
    }
    CharSequence _elvis = null;
    CharSequence _postProcess = null;
    if (this.postProcessor!=null) {
      _postProcess=this.postProcessor.postProcess(uri, contents);
    }
    if (_postProcess != null) {
      _elvis = _postProcess;
    } else {
      _elvis = contents;
    }
    final CharSequence processedContents = _elvis;
    try {
      String _string = processedContents.toString();
      String _charset = this.getCharset(path);
      StringInputStream _stringInputStream = new StringInputStream(_string, _charset);
      this.setContentsAsStream(path, _stringInputStream);
    } catch (final Throwable _t) {
      if (_t instanceof UnsupportedEncodingException) {
        final UnsupportedEncodingException exc = (UnsupportedEncodingException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Override
  public void setContentsAsStream(final Path path, final InputStream source) {
    final URI uri = this.getURI(path);
    if ((uri == null)) {
      throw new IllegalArgumentException(("The file cannot be found: " + path));
    }
    try {
      if ((this.exists(uri) && this.isFile(uri))) {
        boolean _markSupported = source.markSupported();
        if (_markSupported) {
          boolean _hasContentsChanged = this.hasContentsChanged(source, this.getContentsAsStream(path));
          boolean _not = (!_hasContentsChanged);
          if (_not) {
            return;
          }
          source.reset();
        }
      }
      final OutputStream out = this.getURIConverter().createOutputStream(uri);
      try {
        ByteStreams.copy(source, out);
      } finally {
        out.close();
      }
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException exc = (IOException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  protected boolean hasContentsChanged(final InputStream newContent, final InputStream oldContent) {
    boolean contentChanged = false;
    try {
      int newByte = newContent.read();
      int oldByte = oldContent.read();
      while ((((newByte != (-1)) && (oldByte != (-1))) && (newByte == oldByte))) {
        {
          newByte = newContent.read();
          oldByte = oldContent.read();
        }
      }
      contentChanged = (newByte != oldByte);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        contentChanged = true;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      if ((oldContent != null)) {
        try {
          oldContent.close();
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof IOException) {
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
    }
    return contentChanged;
  }

  @Override
  public Iterable<? extends Path> getChildren(final Path path) {
    boolean _equals = Objects.equal(path, Path.ROOT);
    if (_equals) {
      Path _absolutePath = path.getAbsolutePath(this.projectConfigProvider.getProjectConfig(this.context).getName());
      return Collections.<Path>unmodifiableList(CollectionLiterals.<Path>newArrayList(_absolutePath));
    }
    final URI uri = this.getURI(path);
    if ((((uri == null) || (!this.exists(uri))) || (!(this.isFolder(uri)).booleanValue()))) {
      return CollectionLiterals.<Path>emptyList();
    }
    return this.getChildren(uri, path);
  }

  protected abstract Iterable<? extends Path> getChildren(final URI uri, final Path path);

  @Override
  public void mkdir(final Path path) {
  }

  @Override
  public InputStream getContentsAsStream(final Path path) {
    final URI uri = this.getURI(path);
    if ((((uri == null) || (!this.exists(uri))) || (!this.isFile(uri)))) {
      throw new IllegalArgumentException(("The file cannot be found: " + path));
    }
    try {
      return this.getURIConverter().createInputStream(uri);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException exc = (IOException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Override
  public void delete(final Path path) {
    final URI uri = this.getURI(path);
    if ((uri == null)) {
      return;
    }
    if (((this.isFolder(uri)).booleanValue() && (!IterableExtensions.isEmpty(this.getChildren(uri, path))))) {
      return;
    }
    try {
      this.getURIConverter().delete(uri, null);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException exc = (IOException)_t;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Override
  public boolean exists(final Path path) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(path, Path.ROOT);
      if (_equals) {
        return true;
      }
      _xblockexpression = this.exists(this.getURI(path));
    }
    return _xblockexpression;
  }

  protected boolean exists(final URI uri) {
    boolean _xifexpression = false;
    if ((uri == null)) {
      _xifexpression = false;
    } else {
      _xifexpression = this.getURIConverter().exists(uri, null);
    }
    return _xifexpression;
  }

  @Override
  public String getCharset(final Path path) {
    return this.getCharset(this.getURI(path));
  }

  protected String getCharset(final URI uri) {
    return this.encodingProvider.getEncoding(uri);
  }

  @Override
  public long getLastModification(final Path path) {
    return (this.getLastModification(this.getURI(path))).longValue();
  }

  protected Long getLastModification(final URI uri) {
    Long _xblockexpression = null;
    {
      final Object timeStamp = this.getAttribute(uri, URIConverter.ATTRIBUTE_TIME_STAMP);
      Long _xifexpression = null;
      if ((timeStamp instanceof Long)) {
        _xifexpression = ((Long)timeStamp);
      } else {
        _xifexpression = Long.valueOf(0L);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  @Override
  public boolean isFile(final Path path) {
    return this.isFile(this.getURI(path));
  }

  protected boolean isFile(final URI uri) {
    boolean _xblockexpression = false;
    {
      final Object directory = this.getAttribute(uri, URIConverter.ATTRIBUTE_DIRECTORY);
      boolean _xifexpression = false;
      if ((directory instanceof Boolean)) {
        _xifexpression = (!((Boolean) directory).booleanValue());
      } else {
        _xifexpression = false;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  @Override
  public boolean isFolder(final Path path) {
    Boolean _xblockexpression = null;
    {
      boolean _equals = Objects.equal(path, Path.ROOT);
      if (_equals) {
        return true;
      }
      _xblockexpression = this.isFolder(this.getURI(path));
    }
    return (_xblockexpression).booleanValue();
  }

  protected Boolean isFolder(final URI uri) {
    Boolean _xblockexpression = null;
    {
      final Object directory = this.getAttribute(uri, URIConverter.ATTRIBUTE_DIRECTORY);
      Boolean _xifexpression = null;
      if ((directory instanceof Boolean)) {
        _xifexpression = ((Boolean)directory);
      } else {
        _xifexpression = Boolean.valueOf(false);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  @Override
  public java.net.URI toURI(final Path path) {
    java.net.URI _xblockexpression = null;
    {
      final URI uri = this.getURI(path);
      java.net.URI _xifexpression = null;
      if ((uri != null)) {
        _xifexpression = this.toURI(uri);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * Converts an EMF URI to a {@code java.net.URI}.
   */
  protected java.net.URI toURI(final URI uri) {
    java.net.URI _xtrycatchfinallyexpression = null;
    try {
      String _string = uri.toString();
      _xtrycatchfinallyexpression = new URL(_string).toURI();
    } catch (final Throwable _t) {
      if (_t instanceof MalformedURLException) {
        final MalformedURLException e = (MalformedURLException)_t;
        String _message = e.getMessage();
        throw new IllegalArgumentException(_message, e);
      } else if (_t instanceof URISyntaxException) {
        final URISyntaxException e_1 = (URISyntaxException)_t;
        String _message_1 = e_1.getMessage();
        throw new IllegalArgumentException(_message_1, e_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }

  protected URI getURI(final Path path) {
    if (((path == null) || Objects.equal(path, Path.ROOT))) {
      return null;
    }
    final IProjectConfig projectConfig = this.projectConfigProvider.getProjectConfig(this.context);
    if ((projectConfig == null)) {
      return null;
    }
    final URI projectURI = projectConfig.getPath();
    final String projectName = IterableExtensions.<String>head(path.getSegments());
    String _name = projectConfig.getName();
    boolean _notEquals = (!Objects.equal(projectName, _name));
    if (_notEquals) {
      return null;
    }
    final Iterable<String> segments = IterableExtensions.<String>tail(path.getSegments());
    boolean _isEmpty = IterableExtensions.isEmpty(segments);
    if (_isEmpty) {
      return projectURI;
    }
    final URI relativeURI = URI.createURI(IterableExtensions.<String>head(segments)).appendSegments(((String[])Conversions.unwrapArray(IterableExtensions.<String>tail(segments), String.class)));
    final URI uri = relativeURI.resolve(projectURI);
    Boolean _isFolder = this.isFolder(uri);
    if ((_isFolder).booleanValue()) {
      return UriUtil.toFolderURI(uri);
    }
    return uri;
  }

  protected Object getAttribute(final URI uri, final String attributeName) {
    Object _xblockexpression = null;
    {
      if ((uri == null)) {
        return null;
      }
      final HashMap<String, Set<String>> options = CollectionLiterals.<String, Set<String>>newHashMap();
      options.put(URIConverter.OPTION_REQUESTED_ATTRIBUTES, Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(attributeName)));
      _xblockexpression = this.getURIConverter().getAttributes(uri, options).get(attributeName);
    }
    return _xblockexpression;
  }

  protected URIConverter getURIConverter() {
    return this.context.getURIConverter();
  }

  public Path getPath(final Resource res) {
    return this.getPath(res.getURI(), res.getResourceSet());
  }

  protected Path getPath(final URI uri, final ResourceSet context) {
    final IProjectConfig projectConfig = this.projectConfigProvider.getProjectConfig(context);
    if ((projectConfig == null)) {
      return null;
    }
    return this.getPath(uri, projectConfig.getPath(), Path.ROOT.append(projectConfig.getName()));
  }

  protected Path getPath(final URI absoluteURI, final URI baseURI, final Path basePath) {
    Path _xblockexpression = null;
    {
      URI _xifexpression = null;
      if ((baseURI.isPlatformResource() && absoluteURI.isPlatformResource())) {
        URI _xifexpression_1 = null;
        String _segment = baseURI.segment(1);
        String _segment_1 = absoluteURI.segment(1);
        boolean _notEquals = (!Objects.equal(_segment, _segment_1));
        if (_notEquals) {
          URI _xblockexpression_1 = null;
          {
            String _platformString = absoluteURI.toPlatformString(true);
            final org.eclipse.core.runtime.Path p = new org.eclipse.core.runtime.Path(_platformString);
            String _string = p.toString();
            String _plus = (".." + _string);
            _xblockexpression_1 = URI.createURI(_plus);
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          _xifexpression_1 = absoluteURI.deresolve(baseURI);
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = absoluteURI.deresolve(baseURI);
      }
      final URI relativeURI = _xifexpression;
      if ((relativeURI.isEmpty() || Objects.equal(relativeURI, absoluteURI))) {
        return null;
      }
      _xblockexpression = basePath.getAbsolutePath(relativeURI.toString());
    }
    return _xblockexpression;
  }

  @Pure
  public IEncodingProvider getEncodingProvider() {
    return this.encodingProvider;
  }

  public void setEncodingProvider(final IEncodingProvider encodingProvider) {
    this.encodingProvider = encodingProvider;
  }

  @Pure
  public IFilePostProcessor getPostProcessor() {
    return this.postProcessor;
  }

  public void setPostProcessor(final IFilePostProcessor postProcessor) {
    this.postProcessor = postProcessor;
  }

  @Pure
  public IProjectConfigProvider getProjectConfigProvider() {
    return this.projectConfigProvider;
  }

  public void setProjectConfigProvider(final IProjectConfigProvider projectConfigProvider) {
    this.projectConfigProvider = projectConfigProvider;
  }

  @Pure
  public ResourceSet getContext() {
    return this.context;
  }

  public void setContext(final ResourceSet context) {
    this.context = context;
  }
}
