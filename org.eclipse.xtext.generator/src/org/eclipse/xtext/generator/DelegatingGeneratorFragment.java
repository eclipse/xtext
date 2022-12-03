/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Set;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@Deprecated(forRemoval = true)
public class DelegatingGeneratorFragment extends DefaultGeneratorFragment implements NamingAware {

	private IGeneratorFragment delegate;

	private String message;

	private IGeneratorFragment fallback = new DefaultGeneratorFragment();

	private Naming naming;

	public void setFallback(IGeneratorFragment fragment) {
		this.fallback = fragment;
	}

	public void setDelegate(String className) {
		try {
			Class<?> delegateClass = ResourceLoaderFactory.createResourceLoader().loadClass(className);
			delegate = (IGeneratorFragment) delegateClass.getDeclaredConstructor().newInstance();
			return;
		} catch (Exception e) {
			// ignore
		}
		delegate = null;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (delegate == null && message != null) {
			issues.addWarning("---- ATTENTION----\n\t" + "\n\n\t" + message);
		}
		if (fallback instanceof NamingAware)
			((NamingAware) fallback).registerNaming(getNaming());
		if (delegate instanceof NamingAware)
			((NamingAware) delegate).registerNaming(getNaming());
		if (delegate != null)
			delegate.checkConfiguration(issues);
		else
			fallback.checkConfiguration(issues);
	}

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
			delegate.addToPluginXmlRt(grammar, ctx);
		else
			fallback.addToPluginXmlRt(grammar, ctx);
	}

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
			delegate.addToPluginXmlUi(grammar, ctx);
		else
			fallback.addToPluginXmlUi(grammar, ctx);
	}

	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
			delegate.addToStandaloneSetup(grammar, ctx);
		else
			fallback.addToStandaloneSetup(grammar, ctx);
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
			delegate.generate(grammar, ctx);
		else
			fallback.generate(grammar, ctx);
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		if (delegate != null)
			return delegate.getExportedPackagesRt(grammar);
		return fallback.getExportedPackagesRt(grammar);
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		if (delegate != null)
			return delegate.getExportedPackagesUi(grammar);
		return fallback.getExportedPackagesUi(grammar);
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (delegate != null)
			return delegate.getGuiceBindingsRt(grammar);
		return fallback.getGuiceBindingsRt(grammar);
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (delegate != null)
			return delegate.getGuiceBindingsUi(grammar);
		return fallback.getGuiceBindingsUi(grammar);
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		if (delegate != null)
			return delegate.getRequiredBundlesRt(grammar);
		return fallback.getRequiredBundlesRt(grammar);
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		if (delegate != null)
			return delegate.getRequiredBundlesUi(grammar);
		return fallback.getRequiredBundlesUi(grammar);
	}

	@Override
	public void registerNaming(Naming n) {
		this.naming = n;
	}

	public Naming getNaming() {
		return naming;
	}

}
