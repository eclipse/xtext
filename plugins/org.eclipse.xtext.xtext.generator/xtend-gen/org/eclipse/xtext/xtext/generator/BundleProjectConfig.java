/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.SubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

@Accessors
@SuppressWarnings("all")
public class BundleProjectConfig extends SubProjectConfig {
  private ManifestAccess manifest;
  
  private PluginXmlAccess pluginXml;
  
  @Override
  public void initialize(final Injector injector) {
    super.initialize(injector);
    if (this.manifest!=null) {
      this.manifest.initialize(injector);
    }
    if (this.pluginXml!=null) {
      this.pluginXml.initialize(injector);
    }
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    boolean _and = false;
    if (!(this.manifest != null)) {
      _and = false;
    } else {
      IXtextGeneratorFileSystemAccess _metaInf = this.getMetaInf();
      boolean _tripleEquals = (_metaInf == null);
      _and = _tripleEquals;
    }
    if (_and) {
      issues.addError("The \'metaInf\' outlet must be configured for projects with a manifest", this);
    }
    boolean _and_1 = false;
    if (!(this.pluginXml != null)) {
      _and_1 = false;
    } else {
      IXtextGeneratorFileSystemAccess _root = this.getRoot();
      boolean _tripleEquals_1 = (_root == null);
      _and_1 = _tripleEquals_1;
    }
    if (_and_1) {
      issues.addError("The \'root\' outlet must be configured for projects with a plugin.xml", this);
    }
  }
  
  @Pure
  public ManifestAccess getManifest() {
    return this.manifest;
  }
  
  public void setManifest(final ManifestAccess manifest) {
    this.manifest = manifest;
  }
  
  @Pure
  public PluginXmlAccess getPluginXml() {
    return this.pluginXml;
  }
  
  public void setPluginXml(final PluginXmlAccess pluginXml) {
    this.pluginXml = pluginXml;
  }
}
