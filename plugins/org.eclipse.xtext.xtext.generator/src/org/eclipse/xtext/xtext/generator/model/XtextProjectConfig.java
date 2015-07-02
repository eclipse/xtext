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
	private TextFileAccess runtimePluginXmlAccess;
	private String runtimeTestSrcPath;
	private String runtimeTestSrcGenPath;
	private ManifestAccess runtimeTestManifestAccess;
	private TextFileAccess runtimeTestPluginXmlAccess;
	private String genericIdeSrcPath;
	private String genericIdeSrcGenPath;
	private ManifestAccess genericIdeManifestAccess;
	private TextFileAccess genericIdePluginXmlAccess;
	private String genericIdeTestSrcPath;
	private String genericIdeTestSrcGenPath;
	private ManifestAccess genericIdeTestManifestAccess;
	private TextFileAccess genericIdeTestPluginXmlAccess;
	private String eclipsePluginSrcPath;
	private String eclipsePluginSrcGenPath;
	private ManifestAccess eclipsePluginManifestAccess;
	private TextFileAccess eclipsePluginPluginXmlAccess;
	private String eclipsePluginTestSrcPath;
	private String eclipsePluginTestSrcGenPath;
	private ManifestAccess eclipsePluginTestManifestAccess;
	private TextFileAccess eclipsePluginTestPluginXmlAccess;
	private String ideaPluginSrcPath;
	private String ideaPluginSrcGenPath;
	private ManifestAccess ideaPluginManifestAccess;
	private TextFileAccess ideaPluginPluginXmlAccess;
	private String ideaPluginTestSrcPath;
	private String ideaPluginTestSrcGenPath;
	private ManifestAccess ideaPluginTestManifestAccess;
	private TextFileAccess ideaPluginTestPluginXmlAccess;
	private String webSrcPath;
	private String webSrcGenPath;
	private ManifestAccess webManifestAccess;
	private TextFileAccess webPluginXmlAccess;
	private String webTestSrcPath;
	private String webTestSrcGenPath;
	private ManifestAccess webTestManifestAccess;
	private TextFileAccess webTestPluginXmlAccess;
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
	
	public void setRuntimePluginXml(String path) {
		if (path != null) {
			this.runtimePluginXmlAccess = new TextFileAccess();
			this.runtimePluginXmlAccess.setPath(path);
		} else {
			this.runtimePluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getRuntimePluginXml() {
		return this.runtimePluginXmlAccess;
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
	
	public void setRuntimeTestPluginXml(String path) {
		if (path != null) {
			this.runtimeTestPluginXmlAccess = new TextFileAccess();
			this.runtimeTestPluginXmlAccess.setPath(path);
		} else {
			this.runtimeTestPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getRuntimeTestPluginXml() {
		return this.runtimeTestPluginXmlAccess;
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
	
	public void setGenericIdePluginXml(String path) {
		if (path != null) {
			this.genericIdePluginXmlAccess = new TextFileAccess();
			this.genericIdePluginXmlAccess.setPath(path);
		} else {
			this.genericIdePluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getGenericIdePluginXml() {
		return this.genericIdePluginXmlAccess;
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
	
	public void setGenericIdeTestPluginXml(String path) {
		if (path != null) {
			this.genericIdeTestPluginXmlAccess = new TextFileAccess();
			this.genericIdeTestPluginXmlAccess.setPath(path);
		} else {
			this.genericIdeTestPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getGenericIdeTestPluginXml() {
		return this.genericIdeTestPluginXmlAccess;
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
	
	public void setEclipsePluginPluginXml(String path) {
		if (path != null) {
			this.eclipsePluginPluginXmlAccess = new TextFileAccess();
			this.eclipsePluginPluginXmlAccess.setPath(path);
		} else {
			this.eclipsePluginPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getEclipsePluginPluginXml() {
		return this.eclipsePluginPluginXmlAccess;
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
	
	public void setEclipsePluginTestPluginXml(String path) {
		if (path != null) {
			this.eclipsePluginTestPluginXmlAccess = new TextFileAccess();
			this.eclipsePluginTestPluginXmlAccess.setPath(path);
		} else {
			this.eclipsePluginTestPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getEclipsePluginTestPluginXml() {
		return this.eclipsePluginTestPluginXmlAccess;
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
	
	public void setIdeaPluginPluginXml(String path) {
		if (path != null) {
			this.ideaPluginPluginXmlAccess = new TextFileAccess();
			this.ideaPluginPluginXmlAccess.setPath(path);
		} else {
			this.ideaPluginPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getIdeaPluginPluginXml() {
		return this.ideaPluginPluginXmlAccess;
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
	
	public void setIdeaPluginTestPluginXml(String path) {
		if (path != null) {
			this.ideaPluginTestPluginXmlAccess = new TextFileAccess();
			this.ideaPluginTestPluginXmlAccess.setPath(path);
		} else {
			this.ideaPluginTestPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getIdeaPluginTestPluginXml() {
		return this.ideaPluginTestPluginXmlAccess;
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
	
	public void setWebPluginXml(String path) {
		if (path != null) {
			this.webPluginXmlAccess = new TextFileAccess();
			this.webPluginXmlAccess.setPath(path);
		} else {
			this.webPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getWebPluginXml() {
		return this.webPluginXmlAccess;
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
	
	public void setWebTestPluginXml(String path) {
		if (path != null) {
			this.webTestPluginXmlAccess = new TextFileAccess();
			this.webTestPluginXmlAccess.setPath(path);
		} else {
			this.webTestPluginXmlAccess = null;
		}
	}
	
	@Override
	public TextFileAccess getWebTestPluginXml() {
		return this.webTestPluginXmlAccess;
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
