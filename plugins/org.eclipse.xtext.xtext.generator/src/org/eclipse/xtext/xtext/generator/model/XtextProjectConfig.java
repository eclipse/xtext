/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Inject;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xtext.generator.model.FileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.ModuleAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

/**
 * Use this class to configure output paths in the XtextGenerator.
 *
 * <p>This file has been generated with {@link org.eclipse.xtext.xtext.generator.internal.ProjectConfigGenerator}.</p>
 */
public class XtextProjectConfig implements IXtextProjectConfig {
	
	@Inject private IEncodingProvider encodingProvider;
	
	private String runtimeSrcPath;
	private String runtimeSrcGenPath;
	private ManifestAccess runtimeManifestAccess;
	private PluginXmlAccess runtimePluginXmlAccess;
	private ModuleAccess runtimeModuleAccess;
	private String runtimeTestSrcPath;
	private String runtimeTestSrcGenPath;
	private ManifestAccess runtimeTestManifestAccess;
	private PluginXmlAccess runtimeTestPluginXmlAccess;
	private ModuleAccess runtimeTestModuleAccess;
	private String genericIdeSrcPath;
	private String genericIdeSrcGenPath;
	private ManifestAccess genericIdeManifestAccess;
	private PluginXmlAccess genericIdePluginXmlAccess;
	private ModuleAccess genericIdeModuleAccess;
	private String genericIdeTestSrcPath;
	private String genericIdeTestSrcGenPath;
	private ManifestAccess genericIdeTestManifestAccess;
	private PluginXmlAccess genericIdeTestPluginXmlAccess;
	private ModuleAccess genericIdeTestModuleAccess;
	private String eclipsePluginSrcPath;
	private String eclipsePluginSrcGenPath;
	private ManifestAccess eclipsePluginManifestAccess;
	private PluginXmlAccess eclipsePluginPluginXmlAccess;
	private ModuleAccess eclipsePluginModuleAccess;
	private String eclipsePluginTestSrcPath;
	private String eclipsePluginTestSrcGenPath;
	private ManifestAccess eclipsePluginTestManifestAccess;
	private PluginXmlAccess eclipsePluginTestPluginXmlAccess;
	private ModuleAccess eclipsePluginTestModuleAccess;
	private String ideaPluginSrcPath;
	private String ideaPluginSrcGenPath;
	private ManifestAccess ideaPluginManifestAccess;
	private PluginXmlAccess ideaPluginPluginXmlAccess;
	private ModuleAccess ideaPluginModuleAccess;
	private String ideaPluginTestSrcPath;
	private String ideaPluginTestSrcGenPath;
	private ManifestAccess ideaPluginTestManifestAccess;
	private PluginXmlAccess ideaPluginTestPluginXmlAccess;
	private ModuleAccess ideaPluginTestModuleAccess;
	private String webSrcPath;
	private String webSrcGenPath;
	private ManifestAccess webManifestAccess;
	private PluginXmlAccess webPluginXmlAccess;
	private ModuleAccess webModuleAccess;
	private String webTestSrcPath;
	private String webTestSrcGenPath;
	private ManifestAccess webTestManifestAccess;
	private PluginXmlAccess webTestPluginXmlAccess;
	private ModuleAccess webTestModuleAccess;
	private String orionJsGenPath;
	private String aceJsGenPath;
	
	public void initialize() {
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeSrc() {
		if (runtimeSrcPath != null)
			return new FileSystemAccess(runtimeSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setRuntimeSrc(String path) {
		this.runtimeSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeSrcGen() {
		if (runtimeSrcGenPath != null)
			return new FileSystemAccess(runtimeSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setRuntimeSrcGen(String path) {
		this.runtimeSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getRuntimeManifest() {
		return runtimeManifestAccess;
	}
	
	public void setRuntimeManifest(ManifestAccess manifest) {
		this.runtimeManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getRuntimePluginXml() {
		return runtimePluginXmlAccess;
	}
	
	public void setRuntimePluginXml(PluginXmlAccess pluginXml) {
		this.runtimePluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getRuntimeModule() {
		if (runtimeModuleAccess == null) {
			runtimeModuleAccess = new ModuleAccess(getRuntimeSrcGen());
		}
		return runtimeModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeTestSrc() {
		if (runtimeTestSrcPath != null)
			return new FileSystemAccess(runtimeTestSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setRuntimeTestSrc(String path) {
		this.runtimeTestSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeTestSrcGen() {
		if (runtimeTestSrcGenPath != null)
			return new FileSystemAccess(runtimeTestSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setRuntimeTestSrcGen(String path) {
		this.runtimeTestSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getRuntimeTestManifest() {
		return runtimeTestManifestAccess;
	}
	
	public void setRuntimeTestManifest(ManifestAccess manifest) {
		this.runtimeTestManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getRuntimeTestPluginXml() {
		return runtimeTestPluginXmlAccess;
	}
	
	public void setRuntimeTestPluginXml(PluginXmlAccess pluginXml) {
		this.runtimeTestPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getRuntimeTestModule() {
		if (runtimeTestModuleAccess == null) {
			runtimeTestModuleAccess = new ModuleAccess(getRuntimeTestSrcGen());
		}
		return runtimeTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeSrc() {
		if (genericIdeSrcPath != null)
			return new FileSystemAccess(genericIdeSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setGenericIdeSrc(String path) {
		this.genericIdeSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeSrcGen() {
		if (genericIdeSrcGenPath != null)
			return new FileSystemAccess(genericIdeSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setGenericIdeSrcGen(String path) {
		this.genericIdeSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getGenericIdeManifest() {
		return genericIdeManifestAccess;
	}
	
	public void setGenericIdeManifest(ManifestAccess manifest) {
		this.genericIdeManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getGenericIdePluginXml() {
		return genericIdePluginXmlAccess;
	}
	
	public void setGenericIdePluginXml(PluginXmlAccess pluginXml) {
		this.genericIdePluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getGenericIdeModule() {
		if (genericIdeModuleAccess == null) {
			genericIdeModuleAccess = new ModuleAccess(getGenericIdeSrcGen());
		}
		return genericIdeModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeTestSrc() {
		if (genericIdeTestSrcPath != null)
			return new FileSystemAccess(genericIdeTestSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setGenericIdeTestSrc(String path) {
		this.genericIdeTestSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeTestSrcGen() {
		if (genericIdeTestSrcGenPath != null)
			return new FileSystemAccess(genericIdeTestSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setGenericIdeTestSrcGen(String path) {
		this.genericIdeTestSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getGenericIdeTestManifest() {
		return genericIdeTestManifestAccess;
	}
	
	public void setGenericIdeTestManifest(ManifestAccess manifest) {
		this.genericIdeTestManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getGenericIdeTestPluginXml() {
		return genericIdeTestPluginXmlAccess;
	}
	
	public void setGenericIdeTestPluginXml(PluginXmlAccess pluginXml) {
		this.genericIdeTestPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getGenericIdeTestModule() {
		if (genericIdeTestModuleAccess == null) {
			genericIdeTestModuleAccess = new ModuleAccess(getGenericIdeTestSrcGen());
		}
		return genericIdeTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginSrc() {
		if (eclipsePluginSrcPath != null)
			return new FileSystemAccess(eclipsePluginSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setEclipsePluginSrc(String path) {
		this.eclipsePluginSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginSrcGen() {
		if (eclipsePluginSrcGenPath != null)
			return new FileSystemAccess(eclipsePluginSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setEclipsePluginSrcGen(String path) {
		this.eclipsePluginSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getEclipsePluginManifest() {
		return eclipsePluginManifestAccess;
	}
	
	public void setEclipsePluginManifest(ManifestAccess manifest) {
		this.eclipsePluginManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getEclipsePluginPluginXml() {
		return eclipsePluginPluginXmlAccess;
	}
	
	public void setEclipsePluginPluginXml(PluginXmlAccess pluginXml) {
		this.eclipsePluginPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getEclipsePluginModule() {
		if (eclipsePluginModuleAccess == null) {
			eclipsePluginModuleAccess = new ModuleAccess(getEclipsePluginSrcGen());
		}
		return eclipsePluginModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginTestSrc() {
		if (eclipsePluginTestSrcPath != null)
			return new FileSystemAccess(eclipsePluginTestSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setEclipsePluginTestSrc(String path) {
		this.eclipsePluginTestSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginTestSrcGen() {
		if (eclipsePluginTestSrcGenPath != null)
			return new FileSystemAccess(eclipsePluginTestSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setEclipsePluginTestSrcGen(String path) {
		this.eclipsePluginTestSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getEclipsePluginTestManifest() {
		return eclipsePluginTestManifestAccess;
	}
	
	public void setEclipsePluginTestManifest(ManifestAccess manifest) {
		this.eclipsePluginTestManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getEclipsePluginTestPluginXml() {
		return eclipsePluginTestPluginXmlAccess;
	}
	
	public void setEclipsePluginTestPluginXml(PluginXmlAccess pluginXml) {
		this.eclipsePluginTestPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getEclipsePluginTestModule() {
		if (eclipsePluginTestModuleAccess == null) {
			eclipsePluginTestModuleAccess = new ModuleAccess(getEclipsePluginTestSrcGen());
		}
		return eclipsePluginTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginSrc() {
		if (ideaPluginSrcPath != null)
			return new FileSystemAccess(ideaPluginSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setIdeaPluginSrc(String path) {
		this.ideaPluginSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginSrcGen() {
		if (ideaPluginSrcGenPath != null)
			return new FileSystemAccess(ideaPluginSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setIdeaPluginSrcGen(String path) {
		this.ideaPluginSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getIdeaPluginManifest() {
		return ideaPluginManifestAccess;
	}
	
	public void setIdeaPluginManifest(ManifestAccess manifest) {
		this.ideaPluginManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getIdeaPluginPluginXml() {
		return ideaPluginPluginXmlAccess;
	}
	
	public void setIdeaPluginPluginXml(PluginXmlAccess pluginXml) {
		this.ideaPluginPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getIdeaPluginModule() {
		if (ideaPluginModuleAccess == null) {
			ideaPluginModuleAccess = new ModuleAccess(getIdeaPluginSrcGen());
		}
		return ideaPluginModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginTestSrc() {
		if (ideaPluginTestSrcPath != null)
			return new FileSystemAccess(ideaPluginTestSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setIdeaPluginTestSrc(String path) {
		this.ideaPluginTestSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginTestSrcGen() {
		if (ideaPluginTestSrcGenPath != null)
			return new FileSystemAccess(ideaPluginTestSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setIdeaPluginTestSrcGen(String path) {
		this.ideaPluginTestSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getIdeaPluginTestManifest() {
		return ideaPluginTestManifestAccess;
	}
	
	public void setIdeaPluginTestManifest(ManifestAccess manifest) {
		this.ideaPluginTestManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getIdeaPluginTestPluginXml() {
		return ideaPluginTestPluginXmlAccess;
	}
	
	public void setIdeaPluginTestPluginXml(PluginXmlAccess pluginXml) {
		this.ideaPluginTestPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getIdeaPluginTestModule() {
		if (ideaPluginTestModuleAccess == null) {
			ideaPluginTestModuleAccess = new ModuleAccess(getIdeaPluginTestSrcGen());
		}
		return ideaPluginTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getWebSrc() {
		if (webSrcPath != null)
			return new FileSystemAccess(webSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setWebSrc(String path) {
		this.webSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getWebSrcGen() {
		if (webSrcGenPath != null)
			return new FileSystemAccess(webSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setWebSrcGen(String path) {
		this.webSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getWebManifest() {
		return webManifestAccess;
	}
	
	public void setWebManifest(ManifestAccess manifest) {
		this.webManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getWebPluginXml() {
		return webPluginXmlAccess;
	}
	
	public void setWebPluginXml(PluginXmlAccess pluginXml) {
		this.webPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getWebModule() {
		if (webModuleAccess == null) {
			webModuleAccess = new ModuleAccess(getWebSrcGen());
		}
		return webModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getWebTestSrc() {
		if (webTestSrcPath != null)
			return new FileSystemAccess(webTestSrcPath, encodingProvider);
		else
			return null;
	}
	
	public void setWebTestSrc(String path) {
		this.webTestSrcPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getWebTestSrcGen() {
		if (webTestSrcGenPath != null)
			return new FileSystemAccess(webTestSrcGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setWebTestSrcGen(String path) {
		this.webTestSrcGenPath = path;
	}
	
	@Override
	public ManifestAccess getWebTestManifest() {
		return webTestManifestAccess;
	}
	
	public void setWebTestManifest(ManifestAccess manifest) {
		this.webTestManifestAccess = manifest;
	}
	
	@Override
	public PluginXmlAccess getWebTestPluginXml() {
		return webTestPluginXmlAccess;
	}
	
	public void setWebTestPluginXml(PluginXmlAccess pluginXml) {
		this.webTestPluginXmlAccess = pluginXml;
	}
	
	@Override
	public ModuleAccess getWebTestModule() {
		if (webTestModuleAccess == null) {
			webTestModuleAccess = new ModuleAccess(getWebTestSrcGen());
		}
		return webTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getOrionJsGen() {
		if (orionJsGenPath != null)
			return new FileSystemAccess(orionJsGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setOrionJsGen(String path) {
		this.orionJsGenPath = path;
	}
	
	@Override
	public IFileSystemAccess2 getAceJsGen() {
		if (aceJsGenPath != null)
			return new FileSystemAccess(aceJsGenPath, encodingProvider);
		else
			return null;
	}
	
	public void setAceJsGen(String path) {
		this.aceJsGenPath = path;
	}
	
}
