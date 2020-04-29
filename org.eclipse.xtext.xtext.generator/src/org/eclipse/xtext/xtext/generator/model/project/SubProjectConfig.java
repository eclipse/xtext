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
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Configuration of subprojects.
 * 
 * @noextend This class should not be extended by clients.
 */
public class SubProjectConfig implements ISubProjectConfig {
	@Inject
	private XtextProjectConfig owner;

	private boolean enabled;

	private boolean overwriteSrc;

	private String name;

	private String rootPath;

	private IXtextGeneratorFileSystemAccess root;

	private String metaInfPath;

	private IXtextGeneratorFileSystemAccess metaInf;

	private String srcPath;

	private IXtextGeneratorFileSystemAccess src;

	private String srcGenPath;

	private IXtextGeneratorFileSystemAccess srcGen;

	private String iconsPath;

	private IXtextGeneratorFileSystemAccess icons;

	public void setRoot(String path) {
		this.rootPath = path;
	}

	public void setMetaInf(String path) {
		this.metaInfPath = path;
	}

	public void setSrc(String path) {
		this.srcPath = path;
	}

	public void setSrcGen(String path) {
		this.srcGenPath = path;
	}

	public void setIcons(String path) {
		this.iconsPath = path;
	}

	public void checkConfiguration(Issues issues) {
	}

	@Override
	public void initialize(Injector injector) {
		injector.injectMembers(this);
		if (!Strings.isNullOrEmpty(rootPath)) {
			root = owner.newFileSystemAccess(rootPath, true);
			root.initialize(injector);
		}
		if (!Strings.isNullOrEmpty(metaInfPath)) {
			metaInf = owner.newFileSystemAccess(metaInfPath, true);
			metaInf.initialize(injector);
		}
		if (!Strings.isNullOrEmpty(srcPath)) {
			src = owner.newFileSystemAccess(srcPath, overwriteSrc);
			src.initialize(injector);
		}
		if (!Strings.isNullOrEmpty(srcGenPath)) {
			srcGen = owner.newFileSystemAccess(srcGenPath, true);
			srcGen.initialize(injector);
		}
		if (!Strings.isNullOrEmpty(iconsPath)) {
			icons = owner.newFileSystemAccess(iconsPath, true);
			icons.initialize(injector);
		}
	}

	public XtextProjectConfig getOwner() {
		return owner;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isOverwriteSrc() {
		return overwriteSrc;
	}

	public void setOverwriteSrc(boolean overwriteSrc) {
		this.overwriteSrc = overwriteSrc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRootPath() {
		return rootPath;
	}

	public IXtextGeneratorFileSystemAccess getRoot() {
		return root;
	}

	public String getMetaInfPath() {
		return metaInfPath;
	}

	public IXtextGeneratorFileSystemAccess getMetaInf() {
		return metaInf;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public IXtextGeneratorFileSystemAccess getSrc() {
		return src;
	}

	public String getSrcGenPath() {
		return srcGenPath;
	}

	public IXtextGeneratorFileSystemAccess getSrcGen() {
		return srcGen;
	}

	public String getIconsPath() {
		return iconsPath;
	}

	public IXtextGeneratorFileSystemAccess getIcons() {
		return icons;
	}
}
