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

public class XtextProjectConfig implements IXtextProjectConfig {
	
	@Inject private IEncodingProvider encodingProvider;
	
	private FileSystemAccess runtimeSrcAccess;
	private FileSystemAccess runtimeSrcGenAccess;
	private ManifestAccess runtimeManifestAccess;
	private PluginXmlAccess runtimePluginXmlAccess;
	private ModuleAccess runtimeModuleAccess;
	private FileSystemAccess runtimeTestSrcAccess;
	private FileSystemAccess runtimeTestSrcGenAccess;
	private ManifestAccess runtimeTestManifestAccess;
	private PluginXmlAccess runtimeTestPluginXmlAccess;
	private ModuleAccess runtimeTestModuleAccess;
	private FileSystemAccess genericIdeSrcAccess;
	private FileSystemAccess genericIdeSrcGenAccess;
	private ManifestAccess genericIdeManifestAccess;
	private PluginXmlAccess genericIdePluginXmlAccess;
	private ModuleAccess genericIdeModuleAccess;
	private FileSystemAccess genericIdeTestSrcAccess;
	private FileSystemAccess genericIdeTestSrcGenAccess;
	private ManifestAccess genericIdeTestManifestAccess;
	private PluginXmlAccess genericIdeTestPluginXmlAccess;
	private ModuleAccess genericIdeTestModuleAccess;
	private FileSystemAccess eclipsePluginSrcAccess;
	private FileSystemAccess eclipsePluginSrcGenAccess;
	private ManifestAccess eclipsePluginManifestAccess;
	private PluginXmlAccess eclipsePluginPluginXmlAccess;
	private ModuleAccess eclipsePluginModuleAccess;
	private FileSystemAccess eclipsePluginTestSrcAccess;
	private FileSystemAccess eclipsePluginTestSrcGenAccess;
	private ManifestAccess eclipsePluginTestManifestAccess;
	private PluginXmlAccess eclipsePluginTestPluginXmlAccess;
	private ModuleAccess eclipsePluginTestModuleAccess;
	private FileSystemAccess ideaPluginSrcAccess;
	private FileSystemAccess ideaPluginSrcGenAccess;
	private ManifestAccess ideaPluginManifestAccess;
	private PluginXmlAccess ideaPluginPluginXmlAccess;
	private ModuleAccess ideaPluginModuleAccess;
	private FileSystemAccess ideaPluginTestSrcAccess;
	private FileSystemAccess ideaPluginTestSrcGenAccess;
	private ManifestAccess ideaPluginTestManifestAccess;
	private PluginXmlAccess ideaPluginTestPluginXmlAccess;
	private ModuleAccess ideaPluginTestModuleAccess;
	private FileSystemAccess webSrcAccess;
	private FileSystemAccess webSrcGenAccess;
	private ManifestAccess webManifestAccess;
	private PluginXmlAccess webPluginXmlAccess;
	private ModuleAccess webModuleAccess;
	private FileSystemAccess webTestSrcAccess;
	private FileSystemAccess webTestSrcGenAccess;
	private ManifestAccess webTestManifestAccess;
	private PluginXmlAccess webTestPluginXmlAccess;
	private ModuleAccess webTestModuleAccess;
	private FileSystemAccess orionJsGenAccess;
	private FileSystemAccess aceJsGenAccess;
	
	@Override
	public IFileSystemAccess2 getRuntimeSrc() {
		return runtimeSrcAccess;
	}
	
	public void setRuntimeSrc(String path) {
		runtimeSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeSrcGen() {
		return runtimeSrcGenAccess;
	}
	
	public void setRuntimeSrcGen(String path) {
		runtimeSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		runtimeModuleAccess = new ModuleAccess(runtimeSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getRuntimeManifest() {
		return runtimeManifestAccess;
	}
	
	public void setRuntimeManifest(String path) {
		runtimeManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getRuntimePluginXml() {
		return runtimePluginXmlAccess;
	}
	
	public void setRuntimePluginXml(String path) {
		runtimePluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getRuntimeModule() {
		return runtimeModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeTestSrc() {
		return runtimeTestSrcAccess;
	}
	
	public void setRuntimeTestSrc(String path) {
		runtimeTestSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getRuntimeTestSrcGen() {
		return runtimeTestSrcGenAccess;
	}
	
	public void setRuntimeTestSrcGen(String path) {
		runtimeTestSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		runtimeTestModuleAccess = new ModuleAccess(runtimeTestSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getRuntimeTestManifest() {
		return runtimeTestManifestAccess;
	}
	
	public void setRuntimeTestManifest(String path) {
		runtimeTestManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getRuntimeTestPluginXml() {
		return runtimeTestPluginXmlAccess;
	}
	
	public void setRuntimeTestPluginXml(String path) {
		runtimeTestPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getRuntimeTestModule() {
		return runtimeTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeSrc() {
		return genericIdeSrcAccess;
	}
	
	public void setGenericIdeSrc(String path) {
		genericIdeSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeSrcGen() {
		return genericIdeSrcGenAccess;
	}
	
	public void setGenericIdeSrcGen(String path) {
		genericIdeSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		genericIdeModuleAccess = new ModuleAccess(genericIdeSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getGenericIdeManifest() {
		return genericIdeManifestAccess;
	}
	
	public void setGenericIdeManifest(String path) {
		genericIdeManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getGenericIdePluginXml() {
		return genericIdePluginXmlAccess;
	}
	
	public void setGenericIdePluginXml(String path) {
		genericIdePluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getGenericIdeModule() {
		return genericIdeModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeTestSrc() {
		return genericIdeTestSrcAccess;
	}
	
	public void setGenericIdeTestSrc(String path) {
		genericIdeTestSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getGenericIdeTestSrcGen() {
		return genericIdeTestSrcGenAccess;
	}
	
	public void setGenericIdeTestSrcGen(String path) {
		genericIdeTestSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		genericIdeTestModuleAccess = new ModuleAccess(genericIdeTestSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getGenericIdeTestManifest() {
		return genericIdeTestManifestAccess;
	}
	
	public void setGenericIdeTestManifest(String path) {
		genericIdeTestManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getGenericIdeTestPluginXml() {
		return genericIdeTestPluginXmlAccess;
	}
	
	public void setGenericIdeTestPluginXml(String path) {
		genericIdeTestPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getGenericIdeTestModule() {
		return genericIdeTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginSrc() {
		return eclipsePluginSrcAccess;
	}
	
	public void setEclipsePluginSrc(String path) {
		eclipsePluginSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginSrcGen() {
		return eclipsePluginSrcGenAccess;
	}
	
	public void setEclipsePluginSrcGen(String path) {
		eclipsePluginSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		eclipsePluginModuleAccess = new ModuleAccess(eclipsePluginSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getEclipsePluginManifest() {
		return eclipsePluginManifestAccess;
	}
	
	public void setEclipsePluginManifest(String path) {
		eclipsePluginManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getEclipsePluginPluginXml() {
		return eclipsePluginPluginXmlAccess;
	}
	
	public void setEclipsePluginPluginXml(String path) {
		eclipsePluginPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getEclipsePluginModule() {
		return eclipsePluginModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginTestSrc() {
		return eclipsePluginTestSrcAccess;
	}
	
	public void setEclipsePluginTestSrc(String path) {
		eclipsePluginTestSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getEclipsePluginTestSrcGen() {
		return eclipsePluginTestSrcGenAccess;
	}
	
	public void setEclipsePluginTestSrcGen(String path) {
		eclipsePluginTestSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		eclipsePluginTestModuleAccess = new ModuleAccess(eclipsePluginTestSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getEclipsePluginTestManifest() {
		return eclipsePluginTestManifestAccess;
	}
	
	public void setEclipsePluginTestManifest(String path) {
		eclipsePluginTestManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getEclipsePluginTestPluginXml() {
		return eclipsePluginTestPluginXmlAccess;
	}
	
	public void setEclipsePluginTestPluginXml(String path) {
		eclipsePluginTestPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getEclipsePluginTestModule() {
		return eclipsePluginTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginSrc() {
		return ideaPluginSrcAccess;
	}
	
	public void setIdeaPluginSrc(String path) {
		ideaPluginSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginSrcGen() {
		return ideaPluginSrcGenAccess;
	}
	
	public void setIdeaPluginSrcGen(String path) {
		ideaPluginSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		ideaPluginModuleAccess = new ModuleAccess(ideaPluginSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getIdeaPluginManifest() {
		return ideaPluginManifestAccess;
	}
	
	public void setIdeaPluginManifest(String path) {
		ideaPluginManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getIdeaPluginPluginXml() {
		return ideaPluginPluginXmlAccess;
	}
	
	public void setIdeaPluginPluginXml(String path) {
		ideaPluginPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getIdeaPluginModule() {
		return ideaPluginModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginTestSrc() {
		return ideaPluginTestSrcAccess;
	}
	
	public void setIdeaPluginTestSrc(String path) {
		ideaPluginTestSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getIdeaPluginTestSrcGen() {
		return ideaPluginTestSrcGenAccess;
	}
	
	public void setIdeaPluginTestSrcGen(String path) {
		ideaPluginTestSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		ideaPluginTestModuleAccess = new ModuleAccess(ideaPluginTestSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getIdeaPluginTestManifest() {
		return ideaPluginTestManifestAccess;
	}
	
	public void setIdeaPluginTestManifest(String path) {
		ideaPluginTestManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getIdeaPluginTestPluginXml() {
		return ideaPluginTestPluginXmlAccess;
	}
	
	public void setIdeaPluginTestPluginXml(String path) {
		ideaPluginTestPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getIdeaPluginTestModule() {
		return ideaPluginTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getWebSrc() {
		return webSrcAccess;
	}
	
	public void setWebSrc(String path) {
		webSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getWebSrcGen() {
		return webSrcGenAccess;
	}
	
	public void setWebSrcGen(String path) {
		webSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		webModuleAccess = new ModuleAccess(webSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getWebManifest() {
		return webManifestAccess;
	}
	
	public void setWebManifest(String path) {
		webManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getWebPluginXml() {
		return webPluginXmlAccess;
	}
	
	public void setWebPluginXml(String path) {
		webPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getWebModule() {
		return webModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getWebTestSrc() {
		return webTestSrcAccess;
	}
	
	public void setWebTestSrc(String path) {
		webTestSrcAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getWebTestSrcGen() {
		return webTestSrcGenAccess;
	}
	
	public void setWebTestSrcGen(String path) {
		webTestSrcGenAccess = new FileSystemAccess(path, encodingProvider);
		webTestModuleAccess = new ModuleAccess(webTestSrcGenAccess);
	}
	
	@Override
	public ManifestAccess getWebTestManifest() {
		return webTestManifestAccess;
	}
	
	public void setWebTestManifest(String path) {
		webTestManifestAccess = new ManifestAccess(path);
	}
	
	@Override
	public PluginXmlAccess getWebTestPluginXml() {
		return webTestPluginXmlAccess;
	}
	
	public void setWebTestPluginXml(String path) {
		webTestPluginXmlAccess = new PluginXmlAccess(path);
	}
	
	@Override
	public ModuleAccess getWebTestModule() {
		return webTestModuleAccess;
	}
	
	@Override
	public IFileSystemAccess2 getOrionJsGen() {
		return orionJsGenAccess;
	}
	
	public void setOrionJsGen(String path) {
		orionJsGenAccess = new FileSystemAccess(path, encodingProvider);
	}
	
	@Override
	public IFileSystemAccess2 getAceJsGen() {
		return aceJsGenAccess;
	}
	
	public void setAceJsGen(String path) {
		aceJsGenAccess = new FileSystemAccess(path, encodingProvider);
	}
	
}
