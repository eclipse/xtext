package org.eclipse.xtext.util;

import com.google.common.base.Objects;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.9
 */
@Data
@SuppressWarnings("all")
public class XtextVersion {
  private static class Plugin extends EMFPlugin {
    public final static XtextVersion.Plugin INSTANCE = new XtextVersion.Plugin();
    
    private Plugin() {
      super(new ResourceLocator[] {});
    }
    
    @Override
    public ResourceLocator getPluginResourceLocator() {
      return null;
    }
  }
  
  public static XtextVersion getCurrent() {
    String _elvis = null;
    String _readVersionFromManifest = XtextVersion.readVersionFromManifest();
    if (_readVersionFromManifest != null) {
      _elvis = _readVersionFromManifest;
    } else {
      _elvis = "unknown";
    }
    return new XtextVersion(_elvis);
  }
  
  private static String readVersionFromManifest() {
    InputStream is = null;
    try {
      URL _baseURL = XtextVersion.Plugin.INSTANCE.getBaseURL();
      String _plus = (_baseURL + "META-INF/MANIFEST.MF");
      final URL url = new URL(_plus);
      InputStream _openStream = url.openStream();
      is = _openStream;
      final Manifest manifest = new Manifest(is);
      Attributes _mainAttributes = manifest.getMainAttributes();
      return _mainAttributes.getValue("Maven-Version");
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      boolean _notEquals = (!Objects.equal(is, null));
      if (_notEquals) {
        try {
          is.close();
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof IOException) {
            final IOException e_1 = (IOException)_t_1;
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
    }
  }
  
  private final String version;
  
  public boolean isSnapshot() {
    return this.version.endsWith("-SNAPSHOT");
  }
  
  public boolean isStable() {
    boolean _and = false;
    boolean _isSnapshot = this.isSnapshot();
    boolean _not = (!_isSnapshot);
    if (!_not) {
      _and = false;
    } else {
      boolean _matches = this.version.matches("\\d+\\.\\d+(\\.\\d+)+");
      boolean _not_1 = (!_matches);
      _and = _not_1;
    }
    return _and;
  }
  
  public String getXtendGradlePluginVersion() {
    return "0.4.12";
  }
  
  public String getXtextGradlePluginVersion() {
    return "0.3.25";
  }
  
  /**
   * @noreference
   */
  public String getMweVersion() {
    return "2.8.3";
  }
  
  @Override
  public String toString() {
    return this.version;
  }
  
  public XtextVersion(final String version) {
    super();
    this.version = version;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.version== null) ? 0 : this.version.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    XtextVersion other = (XtextVersion) obj;
    if (this.version == null) {
      if (other.version != null)
        return false;
    } else if (!this.version.equals(other.version))
      return false;
    return true;
  }
  
  @Pure
  public String getVersion() {
    return this.version;
  }
}
