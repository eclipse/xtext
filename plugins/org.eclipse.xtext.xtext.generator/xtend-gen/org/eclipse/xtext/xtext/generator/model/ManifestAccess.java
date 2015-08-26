/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Log
@Accessors
@SuppressWarnings("all")
public class ManifestAccess {
  private String path = "MANIFEST.MF";
  
  private String bundleName;
  
  private String symbolicName;
  
  private String version = "0.0.1.qualifier";
  
  private boolean merge = true;
  
  private final Set<String> exportedPackages = CollectionLiterals.<String>newHashSet();
  
  private final Set<String> requiredBundles = CollectionLiterals.<String>newHashSet();
  
  private final Set<String> importedPackages = CollectionLiterals.<String>newHashSet();
  
  /**
   * Merge the contents of the given manifest into this one.
   */
  public boolean merge(final ManifestAccess other) {
    boolean _xblockexpression = false;
    {
      boolean _notEquals = (!Objects.equal(this.path, other.path));
      if (_notEquals) {
        ManifestAccess.LOG.warn(((("Merging manifest files with different paths: " + this.path) + ", ") + other.path));
      }
      boolean _notEquals_1 = (!Objects.equal(this.bundleName, other.bundleName));
      if (_notEquals_1) {
        if ((this.bundleName == null)) {
          this.bundleName = other.bundleName;
        } else {
          if ((other.bundleName != null)) {
            ManifestAccess.LOG.warn(((("Merging manifest files with different bundle names: " + this.bundleName) + ", ") + other.bundleName));
          }
        }
      }
      boolean _notEquals_2 = (!Objects.equal(this.symbolicName, other.symbolicName));
      if (_notEquals_2) {
        if ((this.symbolicName == null)) {
          this.symbolicName = other.symbolicName;
        } else {
          if ((other.symbolicName != null)) {
            ManifestAccess.LOG.warn(((("Merging manifest files with different symbolic names: " + this.symbolicName) + ", ") + other.symbolicName));
          }
        }
      }
      boolean _notEquals_3 = (!Objects.equal(this.version, other.version));
      if (_notEquals_3) {
        ManifestAccess.LOG.warn(((("Merging manifest files with different versions: " + this.version) + ", ") + other.version));
      }
      if ((this.merge != other.merge)) {
        ManifestAccess.LOG.warn("Merging manifest files with different merging settings.");
      }
      this.exportedPackages.addAll(other.exportedPackages);
      this.requiredBundles.addAll(other.requiredBundles);
      _xblockexpression = this.importedPackages.addAll(other.importedPackages);
    }
    return _xblockexpression;
  }
  
  private final static Logger LOG = Logger.getLogger(ManifestAccess.class);
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
  
  @Pure
  public String getBundleName() {
    return this.bundleName;
  }
  
  public void setBundleName(final String bundleName) {
    this.bundleName = bundleName;
  }
  
  @Pure
  public String getSymbolicName() {
    return this.symbolicName;
  }
  
  public void setSymbolicName(final String symbolicName) {
    this.symbolicName = symbolicName;
  }
  
  @Pure
  public String getVersion() {
    return this.version;
  }
  
  public void setVersion(final String version) {
    this.version = version;
  }
  
  @Pure
  public boolean isMerge() {
    return this.merge;
  }
  
  public void setMerge(final boolean merge) {
    this.merge = merge;
  }
  
  @Pure
  public Set<String> getExportedPackages() {
    return this.exportedPackages;
  }
  
  @Pure
  public Set<String> getRequiredBundles() {
    return this.requiredBundles;
  }
  
  @Pure
  public Set<String> getImportedPackages() {
    return this.importedPackages;
  }
}
