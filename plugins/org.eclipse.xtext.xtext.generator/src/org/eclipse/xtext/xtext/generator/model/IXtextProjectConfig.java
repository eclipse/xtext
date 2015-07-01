/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.ModuleAccess;

/**
 * Inject an instance of this interface in order to generate code in a generator fragment.
 *
 * <p>This file has been generated with {@link org.eclipse.xtext.xtext.generator.internal.ProjectConfigGenerator}.</p>
 */
public interface IXtextProjectConfig {
	
	IFileSystemAccess2 getRuntimeSrc();
	IFileSystemAccess2 getRuntimeSrcGen();
	ManifestAccess getRuntimeManifest();
	ModuleAccess getRuntimeModule();
	TextFileAccess getRuntimePluginXml();
	
	IFileSystemAccess2 getRuntimeTestSrc();
	IFileSystemAccess2 getRuntimeTestSrcGen();
	ManifestAccess getRuntimeTestManifest();
	ModuleAccess getRuntimeTestModule();
	TextFileAccess getRuntimeTestPluginXml();
	
	IFileSystemAccess2 getGenericIdeSrc();
	IFileSystemAccess2 getGenericIdeSrcGen();
	ManifestAccess getGenericIdeManifest();
	ModuleAccess getGenericIdeModule();
	TextFileAccess getGenericIdePluginXml();
	
	IFileSystemAccess2 getGenericIdeTestSrc();
	IFileSystemAccess2 getGenericIdeTestSrcGen();
	ManifestAccess getGenericIdeTestManifest();
	ModuleAccess getGenericIdeTestModule();
	TextFileAccess getGenericIdeTestPluginXml();
	
	IFileSystemAccess2 getEclipsePluginSrc();
	IFileSystemAccess2 getEclipsePluginSrcGen();
	ManifestAccess getEclipsePluginManifest();
	ModuleAccess getEclipsePluginModule();
	TextFileAccess getEclipsePluginPluginXml();
	
	IFileSystemAccess2 getEclipsePluginTestSrc();
	IFileSystemAccess2 getEclipsePluginTestSrcGen();
	ManifestAccess getEclipsePluginTestManifest();
	ModuleAccess getEclipsePluginTestModule();
	TextFileAccess getEclipsePluginTestPluginXml();
	
	IFileSystemAccess2 getIdeaPluginSrc();
	IFileSystemAccess2 getIdeaPluginSrcGen();
	ManifestAccess getIdeaPluginManifest();
	ModuleAccess getIdeaPluginModule();
	TextFileAccess getIdeaPluginPluginXml();
	
	IFileSystemAccess2 getIdeaPluginTestSrc();
	IFileSystemAccess2 getIdeaPluginTestSrcGen();
	ManifestAccess getIdeaPluginTestManifest();
	ModuleAccess getIdeaPluginTestModule();
	TextFileAccess getIdeaPluginTestPluginXml();
	
	IFileSystemAccess2 getWebSrc();
	IFileSystemAccess2 getWebSrcGen();
	ManifestAccess getWebManifest();
	ModuleAccess getWebModule();
	TextFileAccess getWebPluginXml();
	
	IFileSystemAccess2 getWebTestSrc();
	IFileSystemAccess2 getWebTestSrcGen();
	ManifestAccess getWebTestManifest();
	ModuleAccess getWebTestModule();
	TextFileAccess getWebTestPluginXml();
	
	IFileSystemAccess2 getOrionJsGen();
	IFileSystemAccess2 getAceJsGen();
	
}
