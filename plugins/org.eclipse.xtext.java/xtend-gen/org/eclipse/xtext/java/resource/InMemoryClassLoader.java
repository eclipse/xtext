package org.eclipse.xtext.java.resource;

import com.google.common.base.Objects;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class InMemoryClassLoader extends ClassLoader {
  private Map<String, byte[]> classMap;
  
  public InMemoryClassLoader(final Map<String, byte[]> classMap, final ClassLoader parent) {
    super(parent);
    this.classMap = classMap;
  }
  
  @Override
  protected Class<?> findClass(final String name) throws ClassNotFoundException {
    byte[] bytes = this.classMap.get(name);
    if ((bytes == null)) {
      return super.findClass(name);
    } else {
      int _length = bytes.length;
      return this.defineClass(name, bytes, 0, _length);
    }
  }
  
  @Override
  protected URL findResource(final String path) {
    try {
      boolean _endsWith = path.endsWith(".class");
      if (_endsWith) {
        final String className = this.pathToClassName(path);
        final byte[] bytes = this.classMap.get(className);
        boolean _notEquals = (!Objects.equal(bytes, null));
        if (_notEquals) {
          final URLStreamHandler _function = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(final URL it) throws IOException {
              return new URLConnection(it) {
                @Override
                public void connect() {
                }
                
                @Override
                public InputStream getInputStream() {
                  return new ByteArrayInputStream(bytes);
                }
              };
            }
          };
          return new URL("in-memory", null, (-1), path, _function);
        }
      }
      return super.findResource(path);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String pathToClassName(final String path) {
    boolean _endsWith = path.endsWith(".class");
    if (_endsWith) {
      int _length = path.length();
      int _minus = (_length - 6);
      String _substring = path.substring(0, _minus);
      return _substring.replace("/", ".");
    } else {
      return null;
    }
  }
}
