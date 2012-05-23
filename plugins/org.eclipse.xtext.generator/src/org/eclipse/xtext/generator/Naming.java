/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.generator;

import static org.eclipse.xtext.GrammarUtil.*;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.Strings;

/**
 * Utility class providing names and the like for general artifacts used in all Xtext projects There's a
 * corresponding Xtend file (Naming.ext) mapping the methods defined inhere to Xtend signatures.
 * @author Sven Efftinge - Initial contribution and API
 */
public class Naming {

	public final static String GLOBAL_VAR_NAME = "__Naming__";
	private String uiBasePackage;
	private String pathTestProject;
	private String activatorName;
	private String grammarId;
	private String projectNameRt;
	private String projectNameUi;
	
	/**
	 * @since 2.3
	 */
	public void setGrammarId(String grammarId) {
		this.grammarId = grammarId;
	}
	
	/**
	 * @since 2.3
	 */
	public void setProjectNameRt(String projectNameRt) {
		this.projectNameRt = projectNameRt;
	}
	
	/**
	 * @since 2.3
	 */
	public String getProjectNameRt() {
		return projectNameRt;
	}
	
	/**
	 * @since 2.3
	 */
	public void setProjectNameUi(String projectNameUi) {
		this.projectNameUi = projectNameUi;
	}
	
	/**
	 * @since 2.3
	 */
	public String getProjectNameUi() {
		return projectNameUi;
	}

	public void setUiBasePackage(String uiBasePackage) {
		this.uiBasePackage = uiBasePackage;
	}

	public void setPathTestProject(String pathTestProject) {
		this.pathTestProject = pathTestProject;
	}

	public void setActivatorName(String activator) {
		this.activatorName = activator;
	}

	public String guiceModuleRtGenerated(Grammar g) {
		return basePackageRuntime(g) + ".Abstract" + getName(g) + "RuntimeModule";
	}

	public String guiceModuleRt(Grammar g) {
		return basePackageRuntime(g) + "." + getName(g) + "RuntimeModule";
	}

	public String guiceModuleUiGenerated(Grammar g) {
		return basePackageUi(g) + ".Abstract" + getName(g) + "UiModule";
	}

	public String guiceModuleUi(Grammar g) {
		return basePackageUi(g) + "." + getName(g) + "UiModule";
	}

	public String setup(Grammar g) {
		return basePackageRuntime(g)+"."+getName(g) + "StandaloneSetup";
	}

	public String setupImpl(Grammar g) {
		return basePackageRuntime(g)+"."+getName(g) + "StandaloneSetupGenerated";
	}

	/**
	 * @deprecated use {@link #activatorName()} instead
	 */
	@Deprecated
	public String activator() {
		return uiBasePackage+ ".Activator";
	}

	public String activatorName() {
		return activatorName;
	}

	public String activatorPackageName() {
		return packageName(activatorName());
	}

	public String getPathTestProject() {
		return pathTestProject;
	}

	public String packageName(String className) {
		return Strings.skipLastToken(className, ".");
	}

	public String executableExtensionFactory(Grammar g) {
		return basePackageUi(g)+"."+getName(g)+"ExecutableExtensionFactory";
	}

	public String asPath(String s) {
		return s.replace('.', '/');
	}

	public String basePackageRuntime(Grammar g) {
		return getNamespace(g);
	}

	public String basePackageUi(Grammar g) {
		// for backward compatibility reasons, the uiBasePackage is only used, if also the grammarId has been explicitly set.
		if (!Strings.isEmpty(uiBasePackage) && (grammarId!=null && grammarId.equals(g.getName())))
			return this.uiBasePackage;
		return getNamespace(g) + ".ui";
	}
	
	/**
	 * @since 2.0
	 */
	public String toSimpleName(String name) {
		return Strings.lastToken(name, ".");
	}

	/**
	 * @since 2.0
	 */
	public String toPackageName(String name) {
		return Strings.skipLastToken(name, ".");
	}

}
