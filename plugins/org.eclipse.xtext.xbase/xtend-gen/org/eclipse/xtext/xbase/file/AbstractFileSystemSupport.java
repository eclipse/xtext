package org.eclipse.xtext.xbase.file;

import com.google.common.io.CharStreams;
import com.google.common.io.InputSupplier;
import com.google.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {
  @Inject
  private IEncodingProvider _encodingProvider;
  
  public IEncodingProvider getEncodingProvider() {
    return this._encodingProvider;
  }
  
  public void setEncodingProvider(final IEncodingProvider encodingProvider) {
    this._encodingProvider = encodingProvider;
  }
  
  public CharSequence getContents(final Path path) {
    try {
      final InputSupplier<InputStreamReader> _function = new InputSupplier<InputStreamReader>() {
        public InputStreamReader getInput() throws IOException {
          InputStream _contentsAsStream = AbstractFileSystemSupport.this.getContentsAsStream(path);
          String _charset = AbstractFileSystemSupport.this.getCharset(path);
          InputStreamReader _inputStreamReader = new InputStreamReader(_contentsAsStream, _charset);
          return _inputStreamReader;
        }
      };
      return CharStreams.<InputStreamReader>toString(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    try {
      Path _parent = path.getParent();
      this.mkdir(_parent);
      String _string = contents.toString();
      String _charset = this.getCharset(path);
      StringInputStream _stringInputStream = new StringInputStream(_string, _charset);
      this.setContentsAsStream(path, _stringInputStream);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public abstract Path getPath(final Resource res);
}
