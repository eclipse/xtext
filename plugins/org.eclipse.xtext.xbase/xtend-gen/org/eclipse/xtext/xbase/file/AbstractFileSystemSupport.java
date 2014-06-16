package org.eclipse.xtext.xbase.file;

import com.google.common.io.CharStreams;
import com.google.common.io.InputSupplier;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {
  @Inject
  @Property
  private IEncodingProvider _encodingProvider;
  
  public CharSequence getContents(final Path path) {
    try {
      final InputSupplier<InputStreamReader> _function = new InputSupplier<InputStreamReader>() {
        public InputStreamReader getInput() throws IOException {
          InputStream _contentsAsStream = AbstractFileSystemSupport.this.getContentsAsStream(path);
          String _charset = AbstractFileSystemSupport.this.getCharset(path);
          return new InputStreamReader(_contentsAsStream, _charset);
        }
      };
      return CharStreams.<InputStreamReader>toString(_function);
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
  
  public void setContents(final Path path, final CharSequence contents) {
    Path _parent = path.getParent();
    this.mkdir(_parent);
    try {
      String _string = contents.toString();
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
  
  public abstract Path getPath(final Resource res);
  
  public IEncodingProvider getEncodingProvider() {
    return this._encodingProvider;
  }
  
  public void setEncodingProvider(final IEncodingProvider encodingProvider) {
    this._encodingProvider = encodingProvider;
  }
}
