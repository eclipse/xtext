/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.generator;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtext.Grammar;

/**
 * Base class redirecting call backs to respective Xpand definitions. The template needs to have the same qualified name
 * the concrete subclass has.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractGeneratorFragment extends DefaultGeneratorFragment implements NamingAware {

	private Naming naming;

	public void registerNaming(Naming naming) {
		this.naming = naming;
	}

	public Naming getNaming() {
		return naming;
	}

	protected String getTemplate() {
		return getClass().getName().replaceAll("\\.", "::");
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::generate", grammar, getParameters(grammar));
	}

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::addToPluginXmlRt", grammar, getParameters(grammar));
	}

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::addToPluginXmlUi", grammar, getParameters(grammar));
	}

	/**
	 * @since 2.3
	 */
	public void addToPluginXmlTests(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::addToPluginXmlTests", grammar, getParameters(grammar));
	}

	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate() + "::addToStandaloneSetup", grammar, getParameters(grammar));
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return null;
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return null;
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return null;
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return null;
	}

	protected List<Object> getParameters(Grammar grammar) {
		return Collections.emptyList();
	}

}
