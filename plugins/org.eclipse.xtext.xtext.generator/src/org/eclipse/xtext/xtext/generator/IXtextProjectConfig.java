/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

/**
 * Inject an instance of this interface in order to generate code in a generator fragment.
 *
 * <p>This file has been generated with {@link org.eclipse.xtext.xtext.generator.internal.ProjectConfigGenerator}.</p>
 */
public interface IXtextProjectConfig extends IGuiceAwareGeneratorComponent {
	
	IXtextGeneratorFileSystemAccess getRuntimeModelGen();
	
	String getRuntimeProjectName();
	IXtextGeneratorFileSystemAccess getRuntimeRoot();
	IXtextGeneratorFileSystemAccess getRuntimeMetaInf();
	IXtextGeneratorFileSystemAccess getRuntimeSrc();
	IXtextGeneratorFileSystemAccess getRuntimeSrcGen();
	ManifestAccess getRuntimeManifest();
	PluginXmlAccess getRuntimePluginXml();
	
	String getRuntimeTestProjectName();
	IXtextGeneratorFileSystemAccess getRuntimeTestRoot();
	IXtextGeneratorFileSystemAccess getRuntimeTestMetaInf();
	IXtextGeneratorFileSystemAccess getRuntimeTestSrc();
	IXtextGeneratorFileSystemAccess getRuntimeTestSrcGen();
	ManifestAccess getRuntimeTestManifest();
	PluginXmlAccess getRuntimeTestPluginXml();
	
	String getGenericIdeProjectName();
	IXtextGeneratorFileSystemAccess getGenericIdeRoot();
	IXtextGeneratorFileSystemAccess getGenericIdeMetaInf();
	IXtextGeneratorFileSystemAccess getGenericIdeSrc();
	IXtextGeneratorFileSystemAccess getGenericIdeSrcGen();
	ManifestAccess getGenericIdeManifest();
	PluginXmlAccess getGenericIdePluginXml();
	
	String getGenericIdeTestProjectName();
	IXtextGeneratorFileSystemAccess getGenericIdeTestRoot();
	IXtextGeneratorFileSystemAccess getGenericIdeTestMetaInf();
	IXtextGeneratorFileSystemAccess getGenericIdeTestSrc();
	IXtextGeneratorFileSystemAccess getGenericIdeTestSrcGen();
	ManifestAccess getGenericIdeTestManifest();
	PluginXmlAccess getGenericIdeTestPluginXml();
	
	String getEclipsePluginProjectName();
	IXtextGeneratorFileSystemAccess getEclipsePluginRoot();
	IXtextGeneratorFileSystemAccess getEclipsePluginMetaInf();
	IXtextGeneratorFileSystemAccess getEclipsePluginSrc();
	IXtextGeneratorFileSystemAccess getEclipsePluginSrcGen();
	ManifestAccess getEclipsePluginManifest();
	PluginXmlAccess getEclipsePluginPluginXml();
	
	String getEclipsePluginTestProjectName();
	IXtextGeneratorFileSystemAccess getEclipsePluginTestRoot();
	IXtextGeneratorFileSystemAccess getEclipsePluginTestMetaInf();
	IXtextGeneratorFileSystemAccess getEclipsePluginTestSrc();
	IXtextGeneratorFileSystemAccess getEclipsePluginTestSrcGen();
	ManifestAccess getEclipsePluginTestManifest();
	PluginXmlAccess getEclipsePluginTestPluginXml();
	
	String getIdeaPluginProjectName();
	IXtextGeneratorFileSystemAccess getIdeaPluginRoot();
	IXtextGeneratorFileSystemAccess getIdeaPluginMetaInf();
	IXtextGeneratorFileSystemAccess getIdeaPluginSrc();
	IXtextGeneratorFileSystemAccess getIdeaPluginSrcGen();
	ManifestAccess getIdeaPluginManifest();
	
	String getIdeaPluginTestProjectName();
	IXtextGeneratorFileSystemAccess getIdeaPluginTestRoot();
	IXtextGeneratorFileSystemAccess getIdeaPluginTestMetaInf();
	IXtextGeneratorFileSystemAccess getIdeaPluginTestSrc();
	IXtextGeneratorFileSystemAccess getIdeaPluginTestSrcGen();
	ManifestAccess getIdeaPluginTestManifest();
	
	String getWebProjectName();
	IXtextGeneratorFileSystemAccess getWebRoot();
	IXtextGeneratorFileSystemAccess getWebMetaInf();
	IXtextGeneratorFileSystemAccess getWebSrc();
	IXtextGeneratorFileSystemAccess getWebSrcGen();
	ManifestAccess getWebManifest();
	
	String getWebTestProjectName();
	IXtextGeneratorFileSystemAccess getWebTestRoot();
	IXtextGeneratorFileSystemAccess getWebTestMetaInf();
	IXtextGeneratorFileSystemAccess getWebTestSrc();
	IXtextGeneratorFileSystemAccess getWebTestSrcGen();
	ManifestAccess getWebTestManifest();
	
	IXtextGeneratorFileSystemAccess getWebApp();
	
}
