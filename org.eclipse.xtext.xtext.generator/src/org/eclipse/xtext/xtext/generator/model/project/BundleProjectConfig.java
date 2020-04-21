/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.project;

import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

import com.google.inject.Injector;

/**
 * Configuration of subprojects that can be used as Eclipse bundles.
 * 
 * @noextend This class should not be extended by clients.
 */
public class BundleProjectConfig extends SubProjectConfig implements IBundleProjectConfig {
	private ManifestAccess manifest;

	private PluginXmlAccess pluginXml;

	@Override
	public void initialize(Injector injector) {
		super.initialize(injector);
		if (manifest != null) {
			manifest.initialize(injector);
		}
		if (pluginXml != null) {
			pluginXml.initialize(injector);
		}
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (manifest != null && getMetaInf() == null) {
			issues.addError("The 'metaInf' outlet must be configured for projects with a manifest", this);
		}
		if (pluginXml != null && getRoot() == null) {
			issues.addError("The 'root' outlet must be configured for projects with a plugin.xml", this);
		}
	}

	public ManifestAccess getManifest() {
		return manifest;
	}

	public void setManifest(ManifestAccess manifest) {
		this.manifest = manifest;
	}

	public PluginXmlAccess getPluginXml() {
		return pluginXml;
	}

	public void setPluginXml(PluginXmlAccess pluginXml) {
		this.pluginXml = pluginXml;
	}
}
