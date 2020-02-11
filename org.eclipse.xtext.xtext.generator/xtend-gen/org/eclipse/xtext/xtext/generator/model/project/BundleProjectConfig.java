/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.inject.Injector;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.SubProjectConfig;

/**
 * Configuration of subprojects that can be used as Eclipse bundles.
 * 
 * @noextend This class should not be extended by clients.
 */
@Accessors
@SuppressWarnings("all")
public class BundleProjectConfig extends SubProjectConfig implements IBundleProjectConfig {
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
    if (((this.manifest != null) && (this.getMetaInf() == null))) {
      issues.addError("The \'metaInf\' outlet must be configured for projects with a manifest", this);
    }
    if (((this.pluginXml != null) && (this.getRoot() == null))) {
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
