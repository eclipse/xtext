/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Set;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AntlrDelegatingFragment extends DefaultGeneratorFragment implements IGeneratorFragment {

	private String fragment = "de.itemis.xtext.antlr.XtextAntlrGeneratorFragment";

	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (getInstance() == null) {
			issues.addError(getMessage());
		} else {
			getInstance().checkConfiguration(issues);
		}
	}

	/**
	 * @return
	 */
	private String getMessage() {
		StringBuffer buff = new StringBuffer();
		buff.append("\n\nATTENTION!\nThe Antlr generator fragment couldn't be found on the classpath.\n");
		buff.append("It is highly recommended to install it using the external updatesite:\n\n");
		buff.append("\t\t'http://download.itemis.com/updates/'.\n\n");
		buff.append("(see the corresponding section in the documentation for details).\n\n");
		return buff.toString();
	}

	private IGeneratorFragment instance = null;

	private synchronized IGeneratorFragment getInstance() {
		if (instance == null) {
			instance = internalCreateInstance();
		}
		return instance;
	}

	private IGeneratorFragment internalCreateInstance() {
		Class<?> class1 = ResourceLoaderFactory.createResourceLoader().loadClass(fragment);
		if (class1 == null) {
			return null;
		}
		try {
			return (IGeneratorFragment) class1.newInstance();
		} catch (Exception e) {
			throw new WrappedException(e);
		}
	}

	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().addToPluginXmlRt(grammar, ctx);
	}

	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().addToPluginXmlUi(grammar, ctx);
	}

	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().addToStandaloneSetup(grammar, ctx);
	}

	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().generate(grammar, ctx);
	}

	public String[] getExportedPackagesRt(Grammar grammar) {
		return getInstance().getExportedPackagesRt(grammar);
	}

	public String[] getExportedPackagesUi(Grammar grammar) {
		return getInstance().getExportedPackagesUi(grammar);
	}

	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return getInstance().getGuiceBindingsRt(grammar);
	}

	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return getInstance().getGuiceBindingsUi(grammar);
	}

	public String[] getRequiredBundlesRt(Grammar grammar) {
		return getInstance().getRequiredBundlesRt(grammar);
	}

	public String[] getRequiredBundlesUi(Grammar grammar) {
		return getInstance().getRequiredBundlesUi(grammar);
	}

}
