/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.emf.mwe2.runtime.Mandatory;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;

import com.google.inject.Injector;

/**
 * Generator fragment that allows to write files to arbitrary, user configurable
 * locations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractExternalFolderAwareFragment extends AbstractXtextGeneratorFragment {
	private String absolutePath;

	private boolean override = false;

	private IXtextGeneratorFileSystemAccess outputLocation;

	protected IXtextGeneratorFileSystemAccess getOutputLocation() {
		return outputLocation;
	}

	@Override
	public void initialize(Injector injector) {
		super.initialize(injector);
		outputLocation = new XtextGeneratorFileSystemAccess(absolutePath, override);
		injector.injectMembers(outputLocation);
	}

	protected String getAbsolutePath() {
		return absolutePath;
	}

	@Mandatory
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	protected boolean isOverride() {
		return override;
	}

	public void setOverride(boolean override) {
		this.override = override;
	}
}
