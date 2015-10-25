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
import java.util.List;
import java.util.Map;
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
    } catch (final Throwable _t_2) {
      if (_t_2 instanceof IOException) {
        final IOException exc = (IOException)_t_2;
        String _message = exc.getMessage();
        throw new IllegalArgumentException(_message, exc);
      } else {
        throw Exceptions.sneakyThrow(_t_2);
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
      boolean _and = false;
      boolean _exists = this.exists(uri);
      if (!_exists) {
        _and = false;
      } else {
        boolean _isFile = this.isFile(uri);
        _and = _isFile;
      }
      if (_and) {
        boolean _markSupported = source.markSupported();
        if (_markSupported) {
          InputStream _contentsAsStream = this.getContentsAsStream(path);
          boolean _hasContentsChanged = this.hasContentsChanged(source, _contentsAsStream);
          boolean _not = (!_hasContentsChanged);
          if (_not) {
            return;
          }
          source.reset();
        }
      }
      URIConverter _uRIConverter = this.getURIConverter();
      final OutputStream out = _uRIConverter.createOutputStream(uri);
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
          int _read = newContent.read();
          newByte = _read;
          int _read_1 = oldContent.read();
          oldByte = _read_1;
        }
      }
      contentChanged = (newByte != oldByte);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
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
            final IOException e_1 = (IOException)_t_1;
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
      IProjectConfig _projectConfig = this.projectConfigProvider.getProjectConfig(this.context);
      String _name = _projectConfig.getName();
      Path _absolutePath = path.getAbsolutePath(_name);
      return Collections.<Path>unmodifiableList(CollectionLiterals.<Path>newArrayList(_absolutePath));
    }
    final URI uri = this.getURI(path);
    boolean _or = false;
    boolean _or_1 = false;
    if ((uri == null)) {
      _or_1 = true;
    } else {
      boolean _exists = this.exists(uri);
      boolean _not = (!_exists);
      _or_1 = _not;
    }
    if (_or_1) {
      _or = true;
    } else {
      Boolean _isFolder = this.isFolder(uri);
      boolean _not_1 = (!(_isFolder).booleanValue());
      _or = _not_1;
    }
    if (_or) {
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
    boolean _or = false;
    boolean _or_1 = false;
    if ((uri == null)) {
      _or_1 = true;
    } else {
      boolean _exists = this.exists(uri);
      boolean _not = (!_exists);
      _or_1 = _not;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _isFile = this.isFile(uri);
      boolean _not_1 = (!_isFile);
      _or = _not_1;
    }
    if (_or) {
      throw new IllegalArgumentException(("The file cannot be found: " + path));
    }
    try {
      URIConverter _uRIConverter = this.getURIConverter();
      return _uRIConverter.createInputStream(uri);
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
    boolean _and = false;
    Boolean _isFolder = this.isFolder(uri);
    if (!(_isFolder).booleanValue()) {
      _and = false;
    } else {
      Iterable<? extends Path> _children = this.getChildren(uri, path);
      boolean _isEmpty = IterableExtensions.isEmpty(_children);
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    if (_and) {
      return;
    }
    try {
      URIConverter _uRIConverter = this.getURIConverter();
      _uRIConverter.delete(uri, null);
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
      URI _uRI = this.getURI(path);
      _xblockexpression = this.exists(_uRI);
    }
    return _xblockexpression;
  }
  
  protected boolean exists(final URI uri) {
    boolean _xifexpression = false;
    if ((uri == null)) {
      _xifexpression = false;
    } else {
      URIConverter _uRIConverter = this.getURIConverter();
      _xifexpression = _uRIConverter.exists(uri, null);
    }
    return _xifexpression;
  }
  
  @Override
  public String getCharset(final Path path) {
    URI _uRI = this.getURI(path);
    return this.getCharset(_uRI);
  }
  
  protected String getCharset(final URI uri) {
    return this.encodingProvider.getEncoding(uri);
  }
  
  @Override
  public long getLastModification(final Path path) {
    URI _uRI = this.getURI(path);
    return (this.getLastModification(_uRI)).longValue();
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
    URI _uRI = this.getURI(path);
    return this.isFile(_uRI);
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
      URI _uRI = this.getURI(path);
      _xblockexpression = this.isFolder(_uRI);
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
      URL _uRL = new URL(_string);
      _xtrycatchfinallyexpression = _uRL.toURI();
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
    boolean _or = false;
    if ((path == null)) {
      _or = true;
    } else {
      boolean _equals = Objects.equal(path, Path.ROOT);
      _or = _equals;
    }
    if (_or) {
      return null;
    }
    final IProjectConfig projectConfig = this.projectConfigProvider.getProjectConfig(this.context);
    if ((projectConfig == null)) {
      return null;
    }
    final URI projectURI = projectConfig.getPath();
    List<String> _segments = path.getSegments();
    final String projectName = IterableExtensions.<String>head(_segments);
    String _name = projectConfig.getName();
    boolean _notEquals = (!Objects.equal(projectName, _name));
    if (_notEquals) {
      return null;
    }
    List<String> _segments_1 = path.getSegments();
    final Iterable<String> segments = IterableExtensions.<String>tail(_segments_1);
    boolean _isEmpty = IterableExtensions.isEmpty(segments);
    if (_isEmpty) {
      return projectURI;
    }
    String _head = IterableExtensions.<String>head(segments);
    URI _createURI = URI.createURI(_head);
    Iterable<String> _tail = IterableExtensions.<String>tail(segments);
    final URI relativeURI = _createURI.appendSegments(((String[])Conversions.unwrapArray(_tail, String.class)));
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
      URIConverter _uRIConverter = this.getURIConverter();
      Map<String, ?> _attributes = _uRIConverter.getAttributes(uri, options);
      _xblockexpression = _attributes.get(attributeName);
    }
    return _xblockexpression;
  }
  
  protected URIConverter getURIConverter() {
    return this.context.getURIConverter();
  }
  
  public Path getPath(final Resource res) {
    URI _uRI = res.getURI();
    ResourceSet _resourceSet = res.getResourceSet();
    return this.getPath(_uRI, _resourceSet);
  }
  
  protected Path getPath(final URI uri, final ResourceSet context) {
    final IProjectConfig projectConfig = this.projectConfigProvider.getProjectConfig(context);
    if ((projectConfig == null)) {
      return null;
    }
    URI _path = projectConfig.getPath();
    String _name = projectConfig.getName();
    Path _append = Path.ROOT.append(_name);
    return this.getPath(uri, _path, _append);
  }
  
  protected Path getPath(final URI absoluteURI, final URI baseURI, final Path basePath) {
    Path _xblockexpression = null;
    {
      final URI relativeURI = absoluteURI.deresolve(baseURI);
      boolean _or = false;
      boolean _isEmpty = relativeURI.isEmpty();
      if (_isEmpty) {
        _or = true;
      } else {
        boolean _equals = Objects.equal(relativeURI, absoluteURI);
        _or = _equals;
      }
      if (_or) {
        return null;
      }
      String _string = relativeURI.toString();
      _xblockexpression = basePath.getAbsolutePath(_string);
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
