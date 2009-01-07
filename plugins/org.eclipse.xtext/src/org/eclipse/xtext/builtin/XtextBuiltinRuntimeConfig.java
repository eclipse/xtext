/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.builtin;

import java.util.Set;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.impl.DefaultLinkingService;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultCrossReferenceSerializer;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Heiko Behrens
 *
 * contains the default runtime components registered for the built-language (i.e. defaults for all languages)
 */
public class XtextBuiltinRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(IXtextBuiltin.SCOPE)
				.with(IGrammarAccess.class, getIGrammarAccess())
				.with(IValueConverterService.class, getIValueConverterService())
				.with(ILinker.class, getILinker())
				.with(ILinkingService.class, getILinkingService())
				.with(IScopeProvider.class, getIScopeProvider())
				.with(IFragmentProvider.class, getIFragmentProvider())
				.with(AntlrTokenDefProvider.class)
				.with(DefaultCrossReferenceSerializer.class)
				.registrations();
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
		return XtextBuiltInConverters.class;
	}

	protected Class<? extends IGrammarAccess> getIGrammarAccess() {
		return XtextBuiltinGrammarAccess.class;
	}

}