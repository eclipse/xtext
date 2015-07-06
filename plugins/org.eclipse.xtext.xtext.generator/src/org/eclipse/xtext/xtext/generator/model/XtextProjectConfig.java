/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Injector;
import org.eclipse.xtext.generator.IFileSystemAccess2;

/**
 * Use this class to configure output paths in the XtextGenerator.
 *
 * <p>This file has been generated with {@link org.eclipse.xtext.xtext.generator.internal.ProjectConfigGenerator}.</p>
 */
public class XtextProjectConfig implements IXtextProjectConfig {
	
	private FileSystemAccess runtimeSrc;
	private FileSystemAccess runtimeSrcGen;
	private ManifestAccess runtimeManifest;
	private PluginXmlAccess runtimePluginXml;
	private FileSystemAccess runtimeTestSrc;
	private FileSystemAccess runtimeTestSrcGen;
	private ManifestAccess runtimeTestManifest;
	private PluginXmlAccess runtimeTestPluginXml;
	private FileSystemAccess genericIdeSrc;
	private FileSystemAccess genericIdeSrcGen;
	private ManifestAccess genericIdeManifest;
	private PluginXmlAccess genericIdePluginXml;
	private FileSystemAccess genericIdeTestSrc;
	private FileSystemAccess genericIdeTestSrcGen;
	private ManifestAccess genericIdeTestManifest;
	private PluginXmlAccess genericIdeTestPluginXml;
	private FileSystemAccess eclipsePluginSrc;
	private FileSystemAccess eclipsePluginSrcGen;
	private ManifestAccess eclipsePluginManifest;
	private PluginXmlAccess eclipsePluginPluginXml;
	private FileSystemAccess eclipsePluginTestSrc;
	private FileSystemAccess eclipsePluginTestSrcGen;
	private ManifestAccess eclipsePluginTestManifest;
	private PluginXmlAccess eclipsePluginTestPluginXml;
	private FileSystemAccess ideaPluginSrc;
	private FileSystemAccess ideaPluginSrcGen;
	private ManifestAccess ideaPluginManifest;
	private PluginXmlAccess ideaPluginPluginXml;
	private FileSystemAccess ideaPluginTestSrc;
	private FileSystemAccess ideaPluginTestSrcGen;
	private ManifestAccess ideaPluginTestManifest;
	private PluginXmlAccess ideaPluginTestPluginXml;
	private FileSystemAccess webSrc;
	private FileSystemAccess webSrcGen;
	private ManifestAccess webManifest;
	private PluginXmlAccess webPluginXml;
	private FileSystemAccess webTestSrc;
	private FileSystemAccess webTestSrcGen;
	private ManifestAccess webTestManifest;
	private PluginXmlAccess webTestPluginXml;
	private FileSystemAccess orionJsGen;
	private FileSystemAccess aceJsGen;
	
	@Override
	public void initialize(Injector injector) {
		injector.injectMembers(this);
		if (runtimeSrc != null) {
			runtimeSrc.initialize(injector);
		}
		if (runtimeSrcGen != null) {
			runtimeSrcGen.initialize(injector);
		}
		if (runtimeTestSrc != null) {
			runtimeTestSrc.initialize(injector);
		}
		if (runtimeTestSrcGen != null) {
			runtimeTestSrcGen.initialize(injector);
		}
		if (genericIdeSrc != null) {
			genericIdeSrc.initialize(injector);
		}
		if (genericIdeSrcGen != null) {
			genericIdeSrcGen.initialize(injector);
		}
		if (genericIdeTestSrc != null) {
			genericIdeTestSrc.initialize(injector);
		}
		if (genericIdeTestSrcGen != null) {
			genericIdeTestSrcGen.initialize(injector);
		}
		if (eclipsePluginSrc != null) {
			eclipsePluginSrc.initialize(injector);
		}
		if (eclipsePluginSrcGen != null) {
			eclipsePluginSrcGen.initialize(injector);
		}
		if (eclipsePluginTestSrc != null) {
			eclipsePluginTestSrc.initialize(injector);
		}
		if (eclipsePluginTestSrcGen != null) {
			eclipsePluginTestSrcGen.initialize(injector);
		}
		if (ideaPluginSrc != null) {
			ideaPluginSrc.initialize(injector);
		}
		if (ideaPluginSrcGen != null) {
			ideaPluginSrcGen.initialize(injector);
		}
		if (ideaPluginTestSrc != null) {
			ideaPluginTestSrc.initialize(injector);
		}
		if (ideaPluginTestSrcGen != null) {
			ideaPluginTestSrcGen.initialize(injector);
		}
		if (webSrc != null) {
			webSrc.initialize(injector);
		}
		if (webSrcGen != null) {
			webSrcGen.initialize(injector);
		}
		if (webTestSrc != null) {
			webTestSrc.initialize(injector);
		}
		if (webTestSrcGen != null) {
			webTestSrcGen.initialize(injector);
		}
		if (orionJsGen != null) {
			orionJsGen.initialize(injector);
		}
		if (aceJsGen != null) {
			aceJsGen.initialize(injector);
		}
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeSrc() {
		return runtimeSrc;
	}
	
	public void setRuntimeSrc(String path) {
		this.runtimeSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeSrcGen() {
		return runtimeSrcGen;
	}
	
	public void setRuntimeSrcGen(String path) {
		this.runtimeSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getRuntimeManifest() {
		return runtimeManifest;
	}
	
	public void setRuntimeManifest(ManifestAccess manifest) {
		this.runtimeManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getRuntimePluginXml() {
		return runtimePluginXml;
	}
	
	public void setRuntimePluginXml(PluginXmlAccess pluginXml) {
		this.runtimePluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeTestSrc() {
		return runtimeTestSrc;
	}
	
	public void setRuntimeTestSrc(String path) {
		this.runtimeTestSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeTestSrcGen() {
		return runtimeTestSrcGen;
	}
	
	public void setRuntimeTestSrcGen(String path) {
		this.runtimeTestSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getRuntimeTestManifest() {
		return runtimeTestManifest;
	}
	
	public void setRuntimeTestManifest(ManifestAccess manifest) {
		this.runtimeTestManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getRuntimeTestPluginXml() {
		return runtimeTestPluginXml;
	}
	
	public void setRuntimeTestPluginXml(PluginXmlAccess pluginXml) {
		this.runtimeTestPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeSrc() {
		return genericIdeSrc;
	}
	
	public void setGenericIdeSrc(String path) {
		this.genericIdeSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeSrcGen() {
		return genericIdeSrcGen;
	}
	
	public void setGenericIdeSrcGen(String path) {
		this.genericIdeSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getGenericIdeManifest() {
		return genericIdeManifest;
	}
	
	public void setGenericIdeManifest(ManifestAccess manifest) {
		this.genericIdeManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getGenericIdePluginXml() {
		return genericIdePluginXml;
	}
	
	public void setGenericIdePluginXml(PluginXmlAccess pluginXml) {
		this.genericIdePluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeTestSrc() {
		return genericIdeTestSrc;
	}
	
	public void setGenericIdeTestSrc(String path) {
		this.genericIdeTestSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeTestSrcGen() {
		return genericIdeTestSrcGen;
	}
	
	public void setGenericIdeTestSrcGen(String path) {
		this.genericIdeTestSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getGenericIdeTestManifest() {
		return genericIdeTestManifest;
	}
	
	public void setGenericIdeTestManifest(ManifestAccess manifest) {
		this.genericIdeTestManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getGenericIdeTestPluginXml() {
		return genericIdeTestPluginXml;
	}
	
	public void setGenericIdeTestPluginXml(PluginXmlAccess pluginXml) {
		this.genericIdeTestPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginSrc() {
		return eclipsePluginSrc;
	}
	
	public void setEclipsePluginSrc(String path) {
		this.eclipsePluginSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginSrcGen() {
		return eclipsePluginSrcGen;
	}
	
	public void setEclipsePluginSrcGen(String path) {
		this.eclipsePluginSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getEclipsePluginManifest() {
		return eclipsePluginManifest;
	}
	
	public void setEclipsePluginManifest(ManifestAccess manifest) {
		this.eclipsePluginManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getEclipsePluginPluginXml() {
		return eclipsePluginPluginXml;
	}
	
	public void setEclipsePluginPluginXml(PluginXmlAccess pluginXml) {
		this.eclipsePluginPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginTestSrc() {
		return eclipsePluginTestSrc;
	}
	
	public void setEclipsePluginTestSrc(String path) {
		this.eclipsePluginTestSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginTestSrcGen() {
		return eclipsePluginTestSrcGen;
	}
	
	public void setEclipsePluginTestSrcGen(String path) {
		this.eclipsePluginTestSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getEclipsePluginTestManifest() {
		return eclipsePluginTestManifest;
	}
	
	public void setEclipsePluginTestManifest(ManifestAccess manifest) {
		this.eclipsePluginTestManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getEclipsePluginTestPluginXml() {
		return eclipsePluginTestPluginXml;
	}
	
	public void setEclipsePluginTestPluginXml(PluginXmlAccess pluginXml) {
		this.eclipsePluginTestPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginSrc() {
		return ideaPluginSrc;
	}
	
	public void setIdeaPluginSrc(String path) {
		this.ideaPluginSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginSrcGen() {
		return ideaPluginSrcGen;
	}
	
	public void setIdeaPluginSrcGen(String path) {
		this.ideaPluginSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getIdeaPluginManifest() {
		return ideaPluginManifest;
	}
	
	public void setIdeaPluginManifest(ManifestAccess manifest) {
		this.ideaPluginManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getIdeaPluginPluginXml() {
		return ideaPluginPluginXml;
	}
	
	public void setIdeaPluginPluginXml(PluginXmlAccess pluginXml) {
		this.ideaPluginPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginTestSrc() {
		return ideaPluginTestSrc;
	}
	
	public void setIdeaPluginTestSrc(String path) {
		this.ideaPluginTestSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginTestSrcGen() {
		return ideaPluginTestSrcGen;
	}
	
	public void setIdeaPluginTestSrcGen(String path) {
		this.ideaPluginTestSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getIdeaPluginTestManifest() {
		return ideaPluginTestManifest;
	}
	
	public void setIdeaPluginTestManifest(ManifestAccess manifest) {
		this.ideaPluginTestManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getIdeaPluginTestPluginXml() {
		return ideaPluginTestPluginXml;
	}
	
	public void setIdeaPluginTestPluginXml(PluginXmlAccess pluginXml) {
		this.ideaPluginTestPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getWebSrc() {
		return webSrc;
	}
	
	public void setWebSrc(String path) {
		this.webSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getWebSrcGen() {
		return webSrcGen;
	}
	
	public void setWebSrcGen(String path) {
		this.webSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getWebManifest() {
		return webManifest;
	}
	
	public void setWebManifest(ManifestAccess manifest) {
		this.webManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getWebPluginXml() {
		return webPluginXml;
	}
	
	public void setWebPluginXml(PluginXmlAccess pluginXml) {
		this.webPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getWebTestSrc() {
		return webTestSrc;
	}
	
	public void setWebTestSrc(String path) {
		this.webTestSrc = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getWebTestSrcGen() {
		return webTestSrcGen;
	}
	
	public void setWebTestSrcGen(String path) {
		this.webTestSrcGen = new FileSystemAccess(path);
	}
	
	@Override
	public ManifestAccess getWebTestManifest() {
		return webTestManifest;
	}
	
	public void setWebTestManifest(ManifestAccess manifest) {
		this.webTestManifest = manifest;
	}
	
	@Override
	public PluginXmlAccess getWebTestPluginXml() {
		return webTestPluginXml;
	}
	
	public void setWebTestPluginXml(PluginXmlAccess pluginXml) {
		this.webTestPluginXml = pluginXml;
	}
	
	@Override
	public IFileSystemAccess2 getOrionJsGen() {
		return orionJsGen;
	}
	
	public void setOrionJsGen(String path) {
		this.orionJsGen = new FileSystemAccess(path);
	}
	
	@Override
	public IFileSystemAccess2 getAceJsGen() {
		return aceJsGen;
	}
	
	public void setAceJsGen(String path) {
		this.aceJsGen = new FileSystemAccess(path);
	}
	
}
