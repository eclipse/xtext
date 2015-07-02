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
	private TextFileAccess runtimePluginXml;
	private FileSystemAccess runtimeTestSrc;
	private FileSystemAccess runtimeTestSrcGen;
	private ManifestAccess runtimeTestManifest;
	private TextFileAccess runtimeTestPluginXml;
	private FileSystemAccess genericIdeSrc;
	private FileSystemAccess genericIdeSrcGen;
	private ManifestAccess genericIdeManifest;
	private TextFileAccess genericIdePluginXml;
	private FileSystemAccess genericIdeTestSrc;
	private FileSystemAccess genericIdeTestSrcGen;
	private ManifestAccess genericIdeTestManifest;
	private TextFileAccess genericIdeTestPluginXml;
	private FileSystemAccess eclipsePluginSrc;
	private FileSystemAccess eclipsePluginSrcGen;
	private ManifestAccess eclipsePluginManifest;
	private TextFileAccess eclipsePluginPluginXml;
	private FileSystemAccess eclipsePluginTestSrc;
	private FileSystemAccess eclipsePluginTestSrcGen;
	private ManifestAccess eclipsePluginTestManifest;
	private TextFileAccess eclipsePluginTestPluginXml;
	private FileSystemAccess ideaPluginSrc;
	private FileSystemAccess ideaPluginSrcGen;
	private ManifestAccess ideaPluginManifest;
	private TextFileAccess ideaPluginPluginXml;
	private FileSystemAccess ideaPluginTestSrc;
	private FileSystemAccess ideaPluginTestSrcGen;
	private ManifestAccess ideaPluginTestManifest;
	private TextFileAccess ideaPluginTestPluginXml;
	private FileSystemAccess webSrc;
	private FileSystemAccess webSrcGen;
	private ManifestAccess webManifest;
	private TextFileAccess webPluginXml;
	private FileSystemAccess webTestSrc;
	private FileSystemAccess webTestSrcGen;
	private ManifestAccess webTestManifest;
	private TextFileAccess webTestPluginXml;
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
	
	public void setRuntimePluginXml(String path) {
		if (path != null) {
			this.runtimePluginXml = new TextFileAccess();
			this.runtimePluginXml.setPath(path);
		} else {
			this.runtimePluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getRuntimePluginXml() {
		return this.runtimePluginXml;
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
	
	public void setRuntimeTestPluginXml(String path) {
		if (path != null) {
			this.runtimeTestPluginXml = new TextFileAccess();
			this.runtimeTestPluginXml.setPath(path);
		} else {
			this.runtimeTestPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getRuntimeTestPluginXml() {
		return this.runtimeTestPluginXml;
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
	
	public void setGenericIdePluginXml(String path) {
		if (path != null) {
			this.genericIdePluginXml = new TextFileAccess();
			this.genericIdePluginXml.setPath(path);
		} else {
			this.genericIdePluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getGenericIdePluginXml() {
		return this.genericIdePluginXml;
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
	
	public void setGenericIdeTestPluginXml(String path) {
		if (path != null) {
			this.genericIdeTestPluginXml = new TextFileAccess();
			this.genericIdeTestPluginXml.setPath(path);
		} else {
			this.genericIdeTestPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getGenericIdeTestPluginXml() {
		return this.genericIdeTestPluginXml;
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
	
	public void setEclipsePluginPluginXml(String path) {
		if (path != null) {
			this.eclipsePluginPluginXml = new TextFileAccess();
			this.eclipsePluginPluginXml.setPath(path);
		} else {
			this.eclipsePluginPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getEclipsePluginPluginXml() {
		return this.eclipsePluginPluginXml;
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
	
	public void setEclipsePluginTestPluginXml(String path) {
		if (path != null) {
			this.eclipsePluginTestPluginXml = new TextFileAccess();
			this.eclipsePluginTestPluginXml.setPath(path);
		} else {
			this.eclipsePluginTestPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getEclipsePluginTestPluginXml() {
		return this.eclipsePluginTestPluginXml;
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
	
	public void setIdeaPluginPluginXml(String path) {
		if (path != null) {
			this.ideaPluginPluginXml = new TextFileAccess();
			this.ideaPluginPluginXml.setPath(path);
		} else {
			this.ideaPluginPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getIdeaPluginPluginXml() {
		return this.ideaPluginPluginXml;
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
	
	public void setIdeaPluginTestPluginXml(String path) {
		if (path != null) {
			this.ideaPluginTestPluginXml = new TextFileAccess();
			this.ideaPluginTestPluginXml.setPath(path);
		} else {
			this.ideaPluginTestPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getIdeaPluginTestPluginXml() {
		return this.ideaPluginTestPluginXml;
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
	
	public void setWebPluginXml(String path) {
		if (path != null) {
			this.webPluginXml = new TextFileAccess();
			this.webPluginXml.setPath(path);
		} else {
			this.webPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getWebPluginXml() {
		return this.webPluginXml;
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
	
	public void setWebTestPluginXml(String path) {
		if (path != null) {
			this.webTestPluginXml = new TextFileAccess();
			this.webTestPluginXml.setPath(path);
		} else {
			this.webTestPluginXml = null;
		}
	}
	
	@Override
	public TextFileAccess getWebTestPluginXml() {
		return this.webTestPluginXml;
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
