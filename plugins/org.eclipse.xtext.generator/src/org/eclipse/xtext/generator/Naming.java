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
 * Utility class providing names and the like for general artifacts used in all Xtext projects
 * There's a corresponding Xtend file (Naming.ext) mapping the methods defined inhere to Xtend signatures. 
 * 
 */
public final class Naming {
	private Naming(){}
	
	public static String guiceModuleRtGenerated(Grammar g) {
		return getNamespace(g)+".Abstract"+getName(g)+"RuntimeModule";
	}
	
	public static String guiceModuleRt(Grammar g) {
		return getNamespace(g)+"."+getName(g)+"RuntimeModule";
	}
	
	public static String guiceModuleUiGenerated(Grammar g) {
		return getNamespace(g)+".Abstract"+getName(g)+"UiModule";
	}
	
	public static String guiceModuleUi(Grammar g) {
		return getNamespace(g)+"."+getName(g)+"UiModule";
	}
	
	public static String setup(Grammar g) {
		return g.getName()+"StandaloneSetup";
	}
	
	public static String activator(Grammar g) {
		return getNamespace(g)+".Activator";
	}
	
	public static String executableExtensionFactory(Grammar g) {
		return g.getName()+"ExecutableExtensionFactory";
	}
	
	public static String asPath(String s) {
		return s.replace('.','/');
	}
	
	public static String javaPack(Grammar g) {
		return getNamespace(g);
	}
}
