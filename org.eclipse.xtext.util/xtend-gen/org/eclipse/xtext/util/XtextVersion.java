/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util;

import com.google.common.base.Objects;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    public static final XtextVersion.Plugin INSTANCE = new XtextVersion.Plugin();
    
    private Plugin() {
      super(new ResourceLocator[] {});
    }
    
    @Override
    public ResourceLocator getPluginResourceLocator() {
      return null;
    }
  }
  
  private final String version;
  
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
  
  public String getXtextGradlePluginVersion() {
    return "2.0.7";
  }
  
  /**
   * @noreference
   */
  public String getMweVersion() {
    return "2.11.0";
  }
  
  public String getAntlrGeneratorVersion() {
    return "2.1.1";
  }
  
  public String getXtendGradlePluginVersion() {
    return this.getXtextGradlePluginVersion();
  }
  
  /**
   * @noreference
   */
  public String getXtendAndroidGradlePluginVersion() {
    return this.getXtendGradlePluginVersion();
  }
  
  /**
   * @return <code>true</code> if the current version ends with '-SNAPSHOT'
   */
  public boolean isSnapshot() {
    return this.version.endsWith("-SNAPSHOT");
  }
  
  /**
   * @return <code>true</code> if the current version is not a snapshot and not a release<br>
   * 				Release builds must match a following pattern: N.N(.N)+<br>
   *  			(N is a digit)<br>
   * 				For example 2.9.2 is a release, 2.9.2.beta3 is stable.
   */
  public boolean isStable() {
    return ((!this.isSnapshot()) && (!this.version.matches("\\d+\\.\\d+(\\.\\d+)+")));
  }
  
  @Override
  public String toString() {
    return this.version;
  }
  
  private static String readVersionFromManifest() {
    InputStream is = null;
    try {
      URL _baseURL = XtextVersion.Plugin.INSTANCE.getBaseURL();
      String _plus = (_baseURL + "META-INF/MANIFEST.MF");
      final URL url = new URL(_plus);
      is = url.openStream();
      final Manifest manifest = new Manifest(is);
      String version = manifest.getMainAttributes().getValue("Maven-Version");
      boolean _equals = Objects.equal("unspecified", version);
      if (_equals) {
        version = manifest.getMainAttributes().getValue("Bundle-Version");
        boolean _endsWith = version.endsWith(".qualifier");
        if (_endsWith) {
          return version.replace(".qualifier", "-SNAPSHOT");
        } else {
          return version.substring(0, version.lastIndexOf("."));
        }
      }
      return version;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      if ((is != null)) {
        try {
          is.close();
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof IOException) {
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      }
    }
  }
  
  public XtextVersion(final String version) {
    super();
    this.version = version;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.version== null) ? 0 : this.version.hashCode());
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
