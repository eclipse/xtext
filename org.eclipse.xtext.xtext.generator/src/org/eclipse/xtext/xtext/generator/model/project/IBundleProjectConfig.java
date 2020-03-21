/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project;

import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

/**
 * Configuration of subprojects that can be used as Eclipse bundles.
 * 
 * @noimplement This interface should not be implemented by clients.
 */
public interface IBundleProjectConfig extends ISubProjectConfig {
	
	ManifestAccess getManifest();
	
	PluginXmlAccess getPluginXml();
	
}
