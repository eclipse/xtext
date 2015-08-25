/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

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
