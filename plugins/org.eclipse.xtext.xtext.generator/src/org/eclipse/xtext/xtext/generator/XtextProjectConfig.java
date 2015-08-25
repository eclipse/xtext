/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;

/**
 * Use this class to configure output paths in the XtextGenerator.
 *
 * <p>This file has been generated with {@link org.eclipse.xtext.xtext.generator.internal.ProjectConfigGenerator}.</p>
 */
public class XtextProjectConfig implements IXtextProjectConfig {
	
	private IXtextGeneratorFileSystemAccess runtimeRoot;
	private IXtextGeneratorFileSystemAccess runtimeMetaInf;
	private IXtextGeneratorFileSystemAccess runtimeSrc;
	private IXtextGeneratorFileSystemAccess runtimeSrcGen;
	private IXtextGeneratorFileSystemAccess runtimeWebApp;
	private ManifestAccess runtimeManifest;
	private PluginXmlAccess runtimePluginXml;
	private IXtextGeneratorFileSystemAccess runtimeTestRoot;
	private IXtextGeneratorFileSystemAccess runtimeTestMetaInf;
	private IXtextGeneratorFileSystemAccess runtimeTestSrc;
	private IXtextGeneratorFileSystemAccess runtimeTestSrcGen;
	private IXtextGeneratorFileSystemAccess runtimeTestWebApp;
	private ManifestAccess runtimeTestManifest;
	private PluginXmlAccess runtimeTestPluginXml;
	private IXtextGeneratorFileSystemAccess genericIdeRoot;
	private IXtextGeneratorFileSystemAccess genericIdeMetaInf;
	private IXtextGeneratorFileSystemAccess genericIdeSrc;
	private IXtextGeneratorFileSystemAccess genericIdeSrcGen;
	private IXtextGeneratorFileSystemAccess genericIdeWebApp;
	private ManifestAccess genericIdeManifest;
	private PluginXmlAccess genericIdePluginXml;
	private IXtextGeneratorFileSystemAccess genericIdeTestRoot;
	private IXtextGeneratorFileSystemAccess genericIdeTestMetaInf;
	private IXtextGeneratorFileSystemAccess genericIdeTestSrc;
	private IXtextGeneratorFileSystemAccess genericIdeTestSrcGen;
	private IXtextGeneratorFileSystemAccess genericIdeTestWebApp;
	private ManifestAccess genericIdeTestManifest;
	private PluginXmlAccess genericIdeTestPluginXml;
	private IXtextGeneratorFileSystemAccess eclipsePluginRoot;
	private IXtextGeneratorFileSystemAccess eclipsePluginMetaInf;
	private IXtextGeneratorFileSystemAccess eclipsePluginSrc;
	private IXtextGeneratorFileSystemAccess eclipsePluginSrcGen;
	private IXtextGeneratorFileSystemAccess eclipsePluginWebApp;
	private ManifestAccess eclipsePluginManifest;
	private PluginXmlAccess eclipsePluginPluginXml;
	private IXtextGeneratorFileSystemAccess eclipsePluginTestRoot;
	private IXtextGeneratorFileSystemAccess eclipsePluginTestMetaInf;
	private IXtextGeneratorFileSystemAccess eclipsePluginTestSrc;
	private IXtextGeneratorFileSystemAccess eclipsePluginTestSrcGen;
	private IXtextGeneratorFileSystemAccess eclipsePluginTestWebApp;
	private ManifestAccess eclipsePluginTestManifest;
	private PluginXmlAccess eclipsePluginTestPluginXml;
	private IXtextGeneratorFileSystemAccess ideaPluginRoot;
	private IXtextGeneratorFileSystemAccess ideaPluginMetaInf;
	private IXtextGeneratorFileSystemAccess ideaPluginSrc;
	private IXtextGeneratorFileSystemAccess ideaPluginSrcGen;
	private IXtextGeneratorFileSystemAccess ideaPluginWebApp;
	private ManifestAccess ideaPluginManifest;
	private PluginXmlAccess ideaPluginPluginXml;
	private IXtextGeneratorFileSystemAccess ideaPluginTestRoot;
	private IXtextGeneratorFileSystemAccess ideaPluginTestMetaInf;
	private IXtextGeneratorFileSystemAccess ideaPluginTestSrc;
	private IXtextGeneratorFileSystemAccess ideaPluginTestSrcGen;
	private IXtextGeneratorFileSystemAccess ideaPluginTestWebApp;
	private ManifestAccess ideaPluginTestManifest;
	private PluginXmlAccess ideaPluginTestPluginXml;
	private IXtextGeneratorFileSystemAccess webRoot;
	private IXtextGeneratorFileSystemAccess webMetaInf;
	private IXtextGeneratorFileSystemAccess webSrc;
	private IXtextGeneratorFileSystemAccess webSrcGen;
	private IXtextGeneratorFileSystemAccess webWebApp;
	private ManifestAccess webManifest;
	private PluginXmlAccess webPluginXml;
	private IXtextGeneratorFileSystemAccess webTestRoot;
	private IXtextGeneratorFileSystemAccess webTestMetaInf;
	private IXtextGeneratorFileSystemAccess webTestSrc;
	private IXtextGeneratorFileSystemAccess webTestSrcGen;
	private IXtextGeneratorFileSystemAccess webTestWebApp;
	private ManifestAccess webTestManifest;
	private PluginXmlAccess webTestPluginXml;
	
	public void checkConfiguration(Issues issues) {
		if (runtimeSrc == null) {
			issues.addError("The property 'runtimeSrc' must be set.", this);
		}
		if (runtimeSrcGen == null) {
			issues.addError("The property 'runtimeSrcGen' must be set.", this);
		}
		if (runtimeManifest != null && Strings.isEmpty(runtimeManifest.getPath())) {
			issues.addError("The property 'path' must be set.", runtimeManifest);
		}
		if (runtimePluginXml != null && Strings.isEmpty(runtimePluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", runtimePluginXml);
		}
		if (runtimeTestManifest != null && Strings.isEmpty(runtimeTestManifest.getPath())) {
			issues.addError("The property 'path' must be set.", runtimeTestManifest);
		}
		if (runtimeTestPluginXml != null && Strings.isEmpty(runtimeTestPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", runtimeTestPluginXml);
		}
		if (genericIdeManifest != null && Strings.isEmpty(genericIdeManifest.getPath())) {
			issues.addError("The property 'path' must be set.", genericIdeManifest);
		}
		if (genericIdePluginXml != null && Strings.isEmpty(genericIdePluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", genericIdePluginXml);
		}
		if (genericIdeTestManifest != null && Strings.isEmpty(genericIdeTestManifest.getPath())) {
			issues.addError("The property 'path' must be set.", genericIdeTestManifest);
		}
		if (genericIdeTestPluginXml != null && Strings.isEmpty(genericIdeTestPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", genericIdeTestPluginXml);
		}
		if (eclipsePluginManifest != null && Strings.isEmpty(eclipsePluginManifest.getPath())) {
			issues.addError("The property 'path' must be set.", eclipsePluginManifest);
		}
		if (eclipsePluginPluginXml != null && Strings.isEmpty(eclipsePluginPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", eclipsePluginPluginXml);
		}
		if (eclipsePluginTestManifest != null && Strings.isEmpty(eclipsePluginTestManifest.getPath())) {
			issues.addError("The property 'path' must be set.", eclipsePluginTestManifest);
		}
		if (eclipsePluginTestPluginXml != null && Strings.isEmpty(eclipsePluginTestPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", eclipsePluginTestPluginXml);
		}
		if (ideaPluginManifest != null && Strings.isEmpty(ideaPluginManifest.getPath())) {
			issues.addError("The property 'path' must be set.", ideaPluginManifest);
		}
		if (ideaPluginPluginXml != null && Strings.isEmpty(ideaPluginPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", ideaPluginPluginXml);
		}
		if (ideaPluginTestManifest != null && Strings.isEmpty(ideaPluginTestManifest.getPath())) {
			issues.addError("The property 'path' must be set.", ideaPluginTestManifest);
		}
		if (ideaPluginTestPluginXml != null && Strings.isEmpty(ideaPluginTestPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", ideaPluginTestPluginXml);
		}
		if (webManifest != null && Strings.isEmpty(webManifest.getPath())) {
			issues.addError("The property 'path' must be set.", webManifest);
		}
		if (webPluginXml != null && Strings.isEmpty(webPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", webPluginXml);
		}
		if (webTestManifest != null && Strings.isEmpty(webTestManifest.getPath())) {
			issues.addError("The property 'path' must be set.", webTestManifest);
		}
		if (webTestPluginXml != null && Strings.isEmpty(webTestPluginXml.getPath())) {
			issues.addError("The property 'path' must be set.", webTestPluginXml);
		}
	}
	
	@Override
	public void initialize(Injector injector) {
		injector.injectMembers(this);
		
		// Initialize runtime configuration
		if (runtimeRoot != null) {
			runtimeRoot.initialize(injector);
		}
		if (runtimeMetaInf != null) {
			runtimeMetaInf.initialize(injector);
		}
		if (runtimeSrc != null) {
			runtimeSrc.initialize(injector);
		}
		if (runtimeSrcGen != null) {
			runtimeSrcGen.initialize(injector);
		}
		if (runtimeWebApp != null) {
			runtimeWebApp.initialize(injector);
		}
		
		// Initialize runtimeTest configuration
		if (runtimeTestRoot != null) {
			runtimeTestRoot.initialize(injector);
		}
		if (runtimeTestMetaInf != null) {
			runtimeTestMetaInf.initialize(injector);
		}
		if (runtimeTestSrc != null) {
			runtimeTestSrc.initialize(injector);
		}
		if (runtimeTestSrcGen != null) {
			runtimeTestSrcGen.initialize(injector);
		}
		if (runtimeTestWebApp != null) {
			runtimeTestWebApp.initialize(injector);
		}
		
		// Initialize genericIde configuration
		if (genericIdeRoot != null) {
			genericIdeRoot.initialize(injector);
		}
		if (genericIdeMetaInf != null) {
			genericIdeMetaInf.initialize(injector);
		}
		if (genericIdeSrc != null) {
			genericIdeSrc.initialize(injector);
		}
		if (genericIdeSrcGen != null) {
			genericIdeSrcGen.initialize(injector);
		}
		if (genericIdeWebApp != null) {
			genericIdeWebApp.initialize(injector);
		}
		
		// Initialize genericIdeTest configuration
		if (genericIdeTestRoot != null) {
			genericIdeTestRoot.initialize(injector);
		}
		if (genericIdeTestMetaInf != null) {
			genericIdeTestMetaInf.initialize(injector);
		}
		if (genericIdeTestSrc != null) {
			genericIdeTestSrc.initialize(injector);
		}
		if (genericIdeTestSrcGen != null) {
			genericIdeTestSrcGen.initialize(injector);
		}
		if (genericIdeTestWebApp != null) {
			genericIdeTestWebApp.initialize(injector);
		}
		
		// Initialize eclipsePlugin configuration
		if (eclipsePluginRoot != null) {
			eclipsePluginRoot.initialize(injector);
		}
		if (eclipsePluginMetaInf != null) {
			eclipsePluginMetaInf.initialize(injector);
		}
		if (eclipsePluginSrc != null) {
			eclipsePluginSrc.initialize(injector);
		}
		if (eclipsePluginSrcGen != null) {
			eclipsePluginSrcGen.initialize(injector);
		}
		if (eclipsePluginWebApp != null) {
			eclipsePluginWebApp.initialize(injector);
		}
		
		// Initialize eclipsePluginTest configuration
		if (eclipsePluginTestRoot != null) {
			eclipsePluginTestRoot.initialize(injector);
		}
		if (eclipsePluginTestMetaInf != null) {
			eclipsePluginTestMetaInf.initialize(injector);
		}
		if (eclipsePluginTestSrc != null) {
			eclipsePluginTestSrc.initialize(injector);
		}
		if (eclipsePluginTestSrcGen != null) {
			eclipsePluginTestSrcGen.initialize(injector);
		}
		if (eclipsePluginTestWebApp != null) {
			eclipsePluginTestWebApp.initialize(injector);
		}
		
		// Initialize ideaPlugin configuration
		if (ideaPluginRoot != null) {
			ideaPluginRoot.initialize(injector);
		}
		if (ideaPluginMetaInf != null) {
			ideaPluginMetaInf.initialize(injector);
		}
		if (ideaPluginSrc != null) {
			ideaPluginSrc.initialize(injector);
		}
		if (ideaPluginSrcGen != null) {
			ideaPluginSrcGen.initialize(injector);
		}
		if (ideaPluginWebApp != null) {
			ideaPluginWebApp.initialize(injector);
		}
		
		// Initialize ideaPluginTest configuration
		if (ideaPluginTestRoot != null) {
			ideaPluginTestRoot.initialize(injector);
		}
		if (ideaPluginTestMetaInf != null) {
			ideaPluginTestMetaInf.initialize(injector);
		}
		if (ideaPluginTestSrc != null) {
			ideaPluginTestSrc.initialize(injector);
		}
		if (ideaPluginTestSrcGen != null) {
			ideaPluginTestSrcGen.initialize(injector);
		}
		if (ideaPluginTestWebApp != null) {
			ideaPluginTestWebApp.initialize(injector);
		}
		
		// Initialize web configuration
		if (webRoot != null) {
			webRoot.initialize(injector);
		}
		if (webMetaInf != null) {
			webMetaInf.initialize(injector);
		}
		if (webSrc != null) {
			webSrc.initialize(injector);
		}
		if (webSrcGen != null) {
			webSrcGen.initialize(injector);
		}
		if (webWebApp != null) {
			webWebApp.initialize(injector);
		}
		
		// Initialize webTest configuration
		if (webTestRoot != null) {
			webTestRoot.initialize(injector);
		}
		if (webTestMetaInf != null) {
			webTestMetaInf.initialize(injector);
		}
		if (webTestSrc != null) {
			webTestSrc.initialize(injector);
		}
		if (webTestSrcGen != null) {
			webTestSrcGen.initialize(injector);
		}
		if (webTestWebApp != null) {
			webTestWebApp.initialize(injector);
		}
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeRoot() {
		return runtimeRoot;
	}
	
	public void setRuntimeRoot(String path) {
		this.runtimeRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeMetaInf() {
		return runtimeMetaInf;
	}
	
	public void setRuntimeMetaInf(String path) {
		this.runtimeMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeSrc() {
		return runtimeSrc;
	}
	
	public void setRuntimeSrc(String path) {
		this.runtimeSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeSrcGen() {
		return runtimeSrcGen;
	}
	
	public void setRuntimeSrcGen(String path) {
		this.runtimeSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeWebApp() {
		return runtimeWebApp;
	}
	
	public void setRuntimeWebApp(String path) {
		this.runtimeWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getRuntimeTestRoot() {
		return runtimeTestRoot;
	}
	
	public void setRuntimeTestRoot(String path) {
		this.runtimeTestRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeTestMetaInf() {
		return runtimeTestMetaInf;
	}
	
	public void setRuntimeTestMetaInf(String path) {
		this.runtimeTestMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeTestSrc() {
		return runtimeTestSrc;
	}
	
	public void setRuntimeTestSrc(String path) {
		this.runtimeTestSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeTestSrcGen() {
		return runtimeTestSrcGen;
	}
	
	public void setRuntimeTestSrcGen(String path) {
		this.runtimeTestSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getRuntimeTestWebApp() {
		return runtimeTestWebApp;
	}
	
	public void setRuntimeTestWebApp(String path) {
		this.runtimeTestWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getGenericIdeRoot() {
		return genericIdeRoot;
	}
	
	public void setGenericIdeRoot(String path) {
		this.genericIdeRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeMetaInf() {
		return genericIdeMetaInf;
	}
	
	public void setGenericIdeMetaInf(String path) {
		this.genericIdeMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeSrc() {
		return genericIdeSrc;
	}
	
	public void setGenericIdeSrc(String path) {
		this.genericIdeSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeSrcGen() {
		return genericIdeSrcGen;
	}
	
	public void setGenericIdeSrcGen(String path) {
		this.genericIdeSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeWebApp() {
		return genericIdeWebApp;
	}
	
	public void setGenericIdeWebApp(String path) {
		this.genericIdeWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getGenericIdeTestRoot() {
		return genericIdeTestRoot;
	}
	
	public void setGenericIdeTestRoot(String path) {
		this.genericIdeTestRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeTestMetaInf() {
		return genericIdeTestMetaInf;
	}
	
	public void setGenericIdeTestMetaInf(String path) {
		this.genericIdeTestMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeTestSrc() {
		return genericIdeTestSrc;
	}
	
	public void setGenericIdeTestSrc(String path) {
		this.genericIdeTestSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeTestSrcGen() {
		return genericIdeTestSrcGen;
	}
	
	public void setGenericIdeTestSrcGen(String path) {
		this.genericIdeTestSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getGenericIdeTestWebApp() {
		return genericIdeTestWebApp;
	}
	
	public void setGenericIdeTestWebApp(String path) {
		this.genericIdeTestWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getEclipsePluginRoot() {
		return eclipsePluginRoot;
	}
	
	public void setEclipsePluginRoot(String path) {
		this.eclipsePluginRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginMetaInf() {
		return eclipsePluginMetaInf;
	}
	
	public void setEclipsePluginMetaInf(String path) {
		this.eclipsePluginMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginSrc() {
		return eclipsePluginSrc;
	}
	
	public void setEclipsePluginSrc(String path) {
		this.eclipsePluginSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginSrcGen() {
		return eclipsePluginSrcGen;
	}
	
	public void setEclipsePluginSrcGen(String path) {
		this.eclipsePluginSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginWebApp() {
		return eclipsePluginWebApp;
	}
	
	public void setEclipsePluginWebApp(String path) {
		this.eclipsePluginWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getEclipsePluginTestRoot() {
		return eclipsePluginTestRoot;
	}
	
	public void setEclipsePluginTestRoot(String path) {
		this.eclipsePluginTestRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginTestMetaInf() {
		return eclipsePluginTestMetaInf;
	}
	
	public void setEclipsePluginTestMetaInf(String path) {
		this.eclipsePluginTestMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginTestSrc() {
		return eclipsePluginTestSrc;
	}
	
	public void setEclipsePluginTestSrc(String path) {
		this.eclipsePluginTestSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginTestSrcGen() {
		return eclipsePluginTestSrcGen;
	}
	
	public void setEclipsePluginTestSrcGen(String path) {
		this.eclipsePluginTestSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getEclipsePluginTestWebApp() {
		return eclipsePluginTestWebApp;
	}
	
	public void setEclipsePluginTestWebApp(String path) {
		this.eclipsePluginTestWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getIdeaPluginRoot() {
		return ideaPluginRoot;
	}
	
	public void setIdeaPluginRoot(String path) {
		this.ideaPluginRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginMetaInf() {
		return ideaPluginMetaInf;
	}
	
	public void setIdeaPluginMetaInf(String path) {
		this.ideaPluginMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginSrc() {
		return ideaPluginSrc;
	}
	
	public void setIdeaPluginSrc(String path) {
		this.ideaPluginSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginSrcGen() {
		return ideaPluginSrcGen;
	}
	
	public void setIdeaPluginSrcGen(String path) {
		this.ideaPluginSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginWebApp() {
		return ideaPluginWebApp;
	}
	
	public void setIdeaPluginWebApp(String path) {
		this.ideaPluginWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getIdeaPluginTestRoot() {
		return ideaPluginTestRoot;
	}
	
	public void setIdeaPluginTestRoot(String path) {
		this.ideaPluginTestRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginTestMetaInf() {
		return ideaPluginTestMetaInf;
	}
	
	public void setIdeaPluginTestMetaInf(String path) {
		this.ideaPluginTestMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginTestSrc() {
		return ideaPluginTestSrc;
	}
	
	public void setIdeaPluginTestSrc(String path) {
		this.ideaPluginTestSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginTestSrcGen() {
		return ideaPluginTestSrcGen;
	}
	
	public void setIdeaPluginTestSrcGen(String path) {
		this.ideaPluginTestSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getIdeaPluginTestWebApp() {
		return ideaPluginTestWebApp;
	}
	
	public void setIdeaPluginTestWebApp(String path) {
		this.ideaPluginTestWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getWebRoot() {
		return webRoot;
	}
	
	public void setWebRoot(String path) {
		this.webRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebMetaInf() {
		return webMetaInf;
	}
	
	public void setWebMetaInf(String path) {
		this.webMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebSrc() {
		return webSrc;
	}
	
	public void setWebSrc(String path) {
		this.webSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebSrcGen() {
		return webSrcGen;
	}
	
	public void setWebSrcGen(String path) {
		this.webSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebWebApp() {
		return webWebApp;
	}
	
	public void setWebWebApp(String path) {
		this.webWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	public IXtextGeneratorFileSystemAccess getWebTestRoot() {
		return webTestRoot;
	}
	
	public void setWebTestRoot(String path) {
		this.webTestRoot = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebTestMetaInf() {
		return webTestMetaInf;
	}
	
	public void setWebTestMetaInf(String path) {
		this.webTestMetaInf = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebTestSrc() {
		return webTestSrc;
	}
	
	public void setWebTestSrc(String path) {
		this.webTestSrc = new XtextGeneratorFileSystemAccess(path, false);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebTestSrcGen() {
		return webTestSrcGen;
	}
	
	public void setWebTestSrcGen(String path) {
		this.webTestSrcGen = new XtextGeneratorFileSystemAccess(path, true);
	}
	
	@Override
	public IXtextGeneratorFileSystemAccess getWebTestWebApp() {
		return webTestWebApp;
	}
	
	public void setWebTestWebApp(String path) {
		this.webTestWebApp = new XtextGeneratorFileSystemAccess(path, true);
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
	
}
