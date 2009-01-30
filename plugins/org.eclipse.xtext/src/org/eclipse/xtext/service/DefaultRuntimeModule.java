/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.impl.DefaultLinkingService;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.parser.SwitchingParser;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.IFragmentProvider;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class DefaultRuntimeModule extends AbstractXtextModule {

	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return DefaultFragmentProvider.class;
	}

	public Class<? extends ILinkingService> bindILinkingService() {
		return DefaultLinkingService.class;
	}

	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DefaultScopeProvider.class;
	}

	public Class<? extends org.eclipse.xtext.crossref.ILinker> bindILinker() {
		return Linker.class;
	}

	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return XtextBuiltInConverters.class;
	}

	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return AntlrTokenToStringConverter.class;
	}

	public Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> bindIParseResultFactory() {
		return ParseResultFactory.class;
	}

	public Class<? extends org.eclipse.xtext.parser.ISwitchingParser> bindISwitchingParser() {
		return SwitchingParser.class;
	}

}
