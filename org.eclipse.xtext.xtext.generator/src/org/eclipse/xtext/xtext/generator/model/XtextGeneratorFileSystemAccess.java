/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Injector;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

public class XtextGeneratorFileSystemAccess extends JavaIoFileSystemAccess implements IXtextGeneratorFileSystemAccess {
	public XtextGeneratorFileSystemAccess(String path, boolean overwrite) {
		setOutputPath(removeTrailingPathSeparator(path));
		getDefaultOutput().setOverrideExistingResources(overwrite);
	}

	private String removeTrailingPathSeparator(String s) {
		if (s.endsWith("/")) {
			return s.substring(0, s.length() - 1);
		} else {
			return s;
		}
	}

	private OutputConfiguration getDefaultOutput() {
		return IterableExtensions.head(getOutputConfigurations().values());
	}

	@Override
	public void initialize(Injector injector) {
		injector.injectMembers(this);
	}

	@Override
	public String getPath() {
		return getDefaultOutput().getOutputDirectory();
	}

	@Override
	public boolean isOverwrite() {
		return getDefaultOutput().isOverrideExistingResources();
	}
}
