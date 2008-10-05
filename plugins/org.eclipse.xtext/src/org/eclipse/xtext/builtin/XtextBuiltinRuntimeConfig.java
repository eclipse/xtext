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
import org.eclipse.xtext.crossref.IFragmentProvider;
import org.eclipse.xtext.crossref.ILinkProvider;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.IURIChecker;
import org.eclipse.xtext.crossref.impl.DefaultRuntimeURIChecker;
import org.eclipse.xtext.crossref.impl.XtextBuiltinFragmentProvider;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkProvider;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.service.AbstractServiceRegistrationFactory;

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 *
 * contains the default runtime components registered for the built-language (i.e. defaults for all languages)
 */
public class XtextBuiltinRuntimeConfig extends AbstractServiceRegistrationFactory {

	public Set<IServiceRegistration> registrations() {
		return scope(IXtextBuiltin.SCOPE)
				.with(IGrammarAccess.class, XtextBuiltinGrammarAccess.class)
				.with(IValueConverterService.class, XtextBuiltInConverters.class)
				.with(ILinker.class, Linker.class)
				.with(ILinkProvider.class, XtextBuiltinLinkProvider.class)
				.with(IURIChecker.class, DefaultRuntimeURIChecker.class)
				.with(IFragmentProvider.class, XtextBuiltinFragmentProvider.class)
				.with(AntlrTokenDefProvider.class)
				.registrations();
	}

}