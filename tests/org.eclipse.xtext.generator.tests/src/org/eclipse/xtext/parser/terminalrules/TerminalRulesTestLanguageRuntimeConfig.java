/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import java.util.Set;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.impl.DefaultLinkingService;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.IFragmentProvider;

/**
 * used to register components to be used at runtime.
 */
public class TerminalRulesTestLanguageRuntimeConfig extends AbstractTerminalRulesTestLanguageRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		generated.addAll(
			scope(TerminalRulesTestLanguageStandaloneSetup.getServiceScope())
				.with(IGrammarAccess.class, getIGrammarAccess())
				.with(IValueConverterService.class, getIValueConverterService())
				.with(ILinker.class, getILinker())
				.with(ILinkingService.class, getILinkingService())
				.with(IScopeProvider.class, getIScopeProvider())
				.with(IFragmentProvider.class, getIFragmentProvider())
				.with(AntlrTokenDefProvider.class)
				.registrations());
		return generated;
	}

	protected Class<? extends IFragmentProvider> getIFragmentProvider() {
		return DefaultFragmentProvider.class;
	}

	protected Class<? extends IScopeProvider> getIScopeProvider() {
		return DefaultScopeProvider.class;
	}

	protected Class<? extends ILinkingService> getILinkingService() {
		return DefaultLinkingService.class;
	}

	protected Class<? extends ILinker> getILinker() {
		return Linker.class;
	}

	protected Class<? extends IValueConverterService> getIValueConverterService() {
		return TerminalRuleTestLanguageConverters.class;
	}
}
			
