/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model.project;

import com.google.inject.Injector;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

/**
 * Configuration of the web project.
 * 
 * @noextend This class should not be extended by clients.
 */
public class WebProjectConfig extends SubProjectConfig implements IWebProjectConfig {
	private String assetsPath;

	private IXtextGeneratorFileSystemAccess assets;

	public void setAssets(String path) {
		this.assetsPath = path;
	}

	@Override
	public void initialize(Injector injector) {
		super.initialize(injector);
		if (this.assetsPath != null) {
			assets = getOwner().newFileSystemAccess(assetsPath, true);
			assets.initialize(injector);
		}
	}

	public String getAssetsPath() {
		return assetsPath;
	}

	public IXtextGeneratorFileSystemAccess getAssets() {
		return assets;
	}
}
