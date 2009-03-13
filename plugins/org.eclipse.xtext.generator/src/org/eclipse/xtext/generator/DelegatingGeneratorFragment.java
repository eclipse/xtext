/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DelegatingGeneratorFragment implements IGeneratorFragment {

	private static Logger log = Logger.getLogger(DelegatingGeneratorFragment.class);

	private IGeneratorFragment delegate;

	private String message;

	private String delegateClass;

	public void setDelegate(String className) {
		delegateClass = className;
		try {
			Class<?> delegateClass = Class.forName(className);
			delegate = (IGeneratorFragment) delegateClass.newInstance();
			return;
		}
		catch (ClassNotFoundException e) {
			// ignore
		}
		catch (InstantiationException e) {
			// ignore
		}
		catch (IllegalAccessException e) {
			// ignore
		}
		delegate = null;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
			delegate.addToPluginXmlRt(grammar, ctx);
	}

	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
		delegate.addToPluginXmlUi(grammar, ctx);
	}

	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
		delegate.addToStandaloneSetup(grammar, ctx);
	}

	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (delegate != null)
			delegate.generate(grammar, ctx);
		else if (message != null) {
			log.warn("---- ATTENTION ----");
			log.warn(message);
		} else {
			throw new IllegalStateException("Delegate '" + delegateClass + "' could not be instantiated.");
		}
	}

	public String[] getExportedPackagesRt(Grammar grammar) {
		if (delegate != null)
			return delegate.getExportedPackagesRt(grammar);
		return Strings.EMPTY_ARRAY;
	}

	public String[] getExportedPackagesUi(Grammar grammar) {
		if (delegate != null)
			return delegate.getExportedPackagesUi(grammar);
		return Strings.EMPTY_ARRAY;
	}

	public Map<BindKey, BindValue> getGuiceBindingsRt(Grammar grammar) {
		if (delegate != null)
			return delegate.getGuiceBindingsRt(grammar);
		return Collections.emptyMap();
	}

	public Map<BindKey, BindValue> getGuiceBindingsUi(Grammar grammar) {
		if (delegate != null)
			return delegate.getGuiceBindingsUi(grammar);
		return Collections.emptyMap();
	}

	public String[] getRequiredBundlesRt(Grammar grammar) {
		if (delegate != null)
			return delegate.getRequiredBundlesRt(grammar);
		return Strings.EMPTY_ARRAY;
	}

	public String[] getRequiredBundlesUi(Grammar grammar) {
		if (delegate != null)
			return delegate.getRequiredBundlesUi(grammar);
		return Strings.EMPTY_ARRAY;
	}

}
