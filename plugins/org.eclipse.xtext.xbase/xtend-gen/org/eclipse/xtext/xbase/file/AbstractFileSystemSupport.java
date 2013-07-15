package org.eclipse.xtext.xbase.file;

import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import java.io.InputStream;
import java.io.InputStreamReader;
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
      InputStream _contentsAsStream = this.getContentsAsStream(path);
      String _charset = this.getCharset(path);
      InputStreamReader _inputStreamReader = new InputStreamReader(_contentsAsStream, _charset);
      final InputStreamReader reader = _inputStreamReader;
      try {
        return CharStreams.toString(reader);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    } catch (Throwable _e_1) {
      throw Exceptions.sneakyThrow(_e_1);
    }
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    Path _parent = path.getParent();
    this.mkdir(_parent);
    String _string = contents.toString();
    StringInputStream _stringInputStream = new StringInputStream(_string);
    this.setContentsAsStream(path, _stringInputStream);
  }
}
