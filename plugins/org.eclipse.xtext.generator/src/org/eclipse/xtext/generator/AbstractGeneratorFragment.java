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
 * @author Sven Efftinge - Initial contribution and API
 *
 * base class redirecting call backs to respective Xpand definitions.
 * The template needs to have the same qualified name the extending class has.
 */
public abstract class AbstractGeneratorFragment extends DefaultGeneratorFragment {

	protected String getTemplate() {
		return getClass().getName().replaceAll("\\.", "::");
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate()+"::generate", grammar, getParameters(grammar));
	}

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate()+"::addToPluginXmlRt", grammar, getParameters(grammar));
	}

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate()+"::addToPluginXmlUi", grammar, getParameters(grammar));
	}

	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		XpandFacade.create(ctx).evaluate2(getTemplate()+"::addToStandaloneSetup", grammar, getParameters(grammar));
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
