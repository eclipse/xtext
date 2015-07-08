/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

/**
 * Inject an instance of this interface in order to generate code in a generator fragment.
 *
 * <p>This file has been generated with {@link org.eclipse.xtext.xtext.generator.internal.ProjectConfigGenerator}.</p>
 */
public interface IXtextProjectConfig extends IGuiceAwareGeneratorComponent {
	
	IFileSystemAccess2 getRuntimeSrc();
	IFileSystemAccess2 getRuntimeSrcGen();
	ManifestAccess getRuntimeManifest();
	PluginXmlAccess getRuntimePluginXml();
	
	IFileSystemAccess2 getRuntimeTestSrc();
	IFileSystemAccess2 getRuntimeTestSrcGen();
	ManifestAccess getRuntimeTestManifest();
	PluginXmlAccess getRuntimeTestPluginXml();
	
	IFileSystemAccess2 getGenericIdeSrc();
	IFileSystemAccess2 getGenericIdeSrcGen();
	ManifestAccess getGenericIdeManifest();
	PluginXmlAccess getGenericIdePluginXml();
	
	IFileSystemAccess2 getGenericIdeTestSrc();
	IFileSystemAccess2 getGenericIdeTestSrcGen();
	ManifestAccess getGenericIdeTestManifest();
	PluginXmlAccess getGenericIdeTestPluginXml();
	
	IFileSystemAccess2 getEclipsePluginSrc();
	IFileSystemAccess2 getEclipsePluginSrcGen();
	ManifestAccess getEclipsePluginManifest();
	PluginXmlAccess getEclipsePluginPluginXml();
	
	IFileSystemAccess2 getEclipsePluginTestSrc();
	IFileSystemAccess2 getEclipsePluginTestSrcGen();
	ManifestAccess getEclipsePluginTestManifest();
	PluginXmlAccess getEclipsePluginTestPluginXml();
	
	IFileSystemAccess2 getIdeaPluginSrc();
	IFileSystemAccess2 getIdeaPluginSrcGen();
	ManifestAccess getIdeaPluginManifest();
	PluginXmlAccess getIdeaPluginPluginXml();
	
	IFileSystemAccess2 getIdeaPluginTestSrc();
	IFileSystemAccess2 getIdeaPluginTestSrcGen();
	ManifestAccess getIdeaPluginTestManifest();
	PluginXmlAccess getIdeaPluginTestPluginXml();
	
	IFileSystemAccess2 getWebSrc();
	IFileSystemAccess2 getWebSrcGen();
	ManifestAccess getWebManifest();
	PluginXmlAccess getWebPluginXml();
	
	IFileSystemAccess2 getWebTestSrc();
	IFileSystemAccess2 getWebTestSrcGen();
	ManifestAccess getWebTestManifest();
	PluginXmlAccess getWebTestPluginXml();
	
	IFileSystemAccess2 getOrionJsGen();
	IFileSystemAccess2 getAceJsGen();
	
}
