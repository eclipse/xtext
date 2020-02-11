/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * Delegates to an AntLR generator fragment on the classpath. Issues a warning if it cannot be located.
 *
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class AntlrDelegatingFragment extends DefaultGeneratorFragment implements NamingAware{

	private String fragment = "de.itemis.xtext.antlr.XtextAntlrGeneratorFragment";

	/**
	 * Set the class name of the generator fragment.
	 *
	 * @param fragment
	 */
	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	@Override
	public void checkConfiguration(Issues issues) {
		super.checkConfiguration(issues);
		if (getInstance() == null) {
			issues.addError(getMessage());
		}
		else {
			getInstance().checkConfiguration(issues);
		}
	}

	/**
	 * @return
	 */
	private String getMessage() {
		StringBuffer buff = new StringBuffer();
		buff.append("\n\nATTENTION!\nThe Antlr generator fragment couldn't be found on the classpath.\n");
		buff.append("It is highly recommended to install the feature 'Xtext Antlr SDK' using the external updatesite:\n\n");
		buff.append("\t\t'http://download.itemis.com/updates/'.\n\n");
		buff.append("(see http://www.eclipse.org/Xtext/download.html for details).\n\n");
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
			return (IGeneratorFragment) class1.getDeclaredConstructor().newInstance();
		}
		catch (Exception e) {
			throw new WrappedException(e);
		}
	}

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().addToPluginXmlRt(grammar, ctx);
	}

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().addToPluginXmlUi(grammar, ctx);
	}

	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().addToStandaloneSetup(grammar, ctx);
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		getInstance().generate(grammar, ctx);
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return getInstance().getExportedPackagesRt(grammar);
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return getInstance().getExportedPackagesUi(grammar);
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return getInstance().getGuiceBindingsRt(grammar);
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return getInstance().getGuiceBindingsUi(grammar);
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return getInstance().getRequiredBundlesRt(grammar);
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return getInstance().getRequiredBundlesUi(grammar);
	}

	@Override
	public void registerNaming(Naming naming) {
		IGeneratorFragment generatorFragment = getInstance();
		if(generatorFragment instanceof NamingAware){
			((NamingAware) generatorFragment).registerNaming(naming);
		}
	}

}
