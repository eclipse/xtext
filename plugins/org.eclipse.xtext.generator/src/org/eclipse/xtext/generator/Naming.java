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

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 *         Utility class providing names and the like for general artifacts used in all Xtext projects There's a
 *         corresponding Xtend file (Naming.ext) mapping the methods defined inhere to Xtend signatures.
 * 
 */
public class Naming {
	
	public final static String GLOBAL_VAR_NAME = "__Naming__";
	private String uiBasePackage;
	
	public void setUiBasePackage(String uiBasePackage) {
		this.uiBasePackage = uiBasePackage;
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

	public String activator() {
		return uiBasePackage+ ".Activator";
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
		return getNamespace(g) + ".ui";
	}

}
