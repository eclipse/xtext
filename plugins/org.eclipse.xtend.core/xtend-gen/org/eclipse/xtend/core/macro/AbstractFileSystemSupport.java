package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {
  @Inject
  @Accessors
  private IEncodingProvider encodingProvider;
  
  @Inject(optional = true)
  @Accessors
  private IFilePostProcessor postProcessor;
  
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
            boolean _equals = Objects.equal(threw, null);
            if (_equals) {
              threw = e_1;
            }
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
      boolean _equals_1 = Objects.equal(threw, null);
      if (_equals_1) {
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
    CharSequence _elvis = null;
    CharSequence _postProcess = null;
    if (this.postProcessor!=null) {
      String _string = path.toString();
      URI _createFileURI = URI.createFileURI(_string);
      _postProcess=this.postProcessor.postProcess(_createFileURI, contents);
    }
    if (_postProcess != null) {
      _elvis = _postProcess;
    } else {
      _elvis = contents;
    }
    final CharSequence processedContents = _elvis;
    Path _parent = path.getParent();
    this.mkdir(_parent);
    try {
      String _string_1 = processedContents.toString();
      String _charset = this.getCharset(path);
      StringInputStream _stringInputStream = new StringInputStream(_string_1, _charset);
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
  
  public abstract Path getPath(final Resource res);
  
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
  public ResourceSet getContext() {
    return this.context;
  }
  
  public void setContext(final ResourceSet context) {
    this.context = context;
  }
}
