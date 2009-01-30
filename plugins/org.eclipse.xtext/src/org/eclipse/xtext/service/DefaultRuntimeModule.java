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
import org.eclipse.xtext.parser.ISwitchingParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.SwitchingParser;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parser.packrat.IPackratParser;
import org.eclipse.xtext.parser.packrat.IParseResultFactory;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.IFragmentProvider;

import com.google.inject.Binder;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class DefaultRuntimeModule extends AbstractRuntimeModule {

	protected abstract Class<? extends ITransientValueService> getITransientValueService();

	abstract protected Class<? extends org.eclipse.xtext.IGrammarAccess> getIGrammarAccess();

	abstract protected Class<? extends org.eclipse.xtext.IMetamodelAccess> getIMetamodelAccess();

	abstract protected Class<? extends org.eclipse.xtext.parser.IAstFactory> getIAstFactory();

	abstract protected Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> getIAntlrTokenFileProvider();

	abstract protected Class<? extends org.eclipse.xtext.resource.IResourceFactory> getIResourceFactory();

	abstract protected Class<? extends org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor> getIParseTreeConstructor();

	abstract protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer> getITokenSerializer();

	abstract protected Class<? extends org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer> getICrossReferenceSerializer();

	abstract protected Class<? extends org.eclipse.xtext.parser.antlr.Lexer> getLexer();

	protected Class<? extends IFragmentProvider> getIFragmentProvider() {
		return DefaultFragmentProvider.class;
	}

	protected Class<? extends ILinkingService> getILinkingService() {
		return DefaultLinkingService.class;
	}

	protected Class<? extends IScopeProvider> getIScopeProvider() {
		return DefaultScopeProvider.class;
	}

	protected Class<? extends org.eclipse.xtext.crossref.ILinker> getILinker() {
		return Linker.class;
	}

	protected Class<? extends org.eclipse.xtext.conversion.IValueConverterService> getIValueConverterService() {
		return XtextBuiltInConverters.class;
	}

	protected void bindIGrammarAccess(Binder binder) {
		binder.bind(org.eclipse.xtext.IGrammarAccess.class).to(getIGrammarAccess());
	}

	protected void bindIMetamodelAccess(Binder binder) {
		binder.bind(org.eclipse.xtext.IMetamodelAccess.class).to(getIMetamodelAccess());
	}

	protected void bindIAstFactory(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.IAstFactory.class).to(getIAstFactory());
	}

	protected void bindIAntlrTokenFileProvider(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider.class).to(getIAntlrTokenFileProvider());
	}

	protected void bindIResourceFactory(Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceFactory.class).to(getIResourceFactory());
	}

	protected void bindIParseTreeConstructor(Binder binder) {
		binder.bind(org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.class).to(getIParseTreeConstructor());
	}

	protected void bindITokenSerializer(Binder binder) {
		binder.bind(org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.class).to(getITokenSerializer());
	}

	protected void bindICrossReferenceSerializer(Binder binder) {
		binder.bind(org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer.class).to(
				getICrossReferenceSerializer());
	}

	protected void bindLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).to(getLexer());
	}

	protected void bindIFragmentProvider(Binder binder) {
		binder.bind(IFragmentProvider.class).to(getIFragmentProvider());
	}

	protected void bindIScopeProvider(Binder binder) {
		binder.bind(IScopeProvider.class).to(getIScopeProvider());
	}

	protected void bindILinkingService(Binder binder) {
		binder.bind(org.eclipse.xtext.crossref.ILinkingService.class).to(getILinkingService());
	}

	protected void bindILinker(Binder binder) {
		binder.bind(org.eclipse.xtext.crossref.ILinker.class).to(getILinker());
	}

	protected void bindIValueConvertService(Binder binder) {
		binder.bind(org.eclipse.xtext.conversion.IValueConverterService.class).to(getIValueConverterService());
	}

	protected abstract Class<? extends org.eclipse.xtext.parser.antlr.IAntlrParser> getIAntlrParser();

	protected Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> getITokenToStringConverter() {
		return AntlrTokenToStringConverter.class;
	}

	protected abstract Class<? extends org.eclipse.xtext.parser.packrat.IPackratParser> getIPackratParser();

	protected Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> getIParseResultFactory() {
		return ParseResultFactory.class;
	}

	protected Class<? extends org.eclipse.xtext.parser.ISwitchingParser> getISwitchingParser() {
		return SwitchingParser.class;
	}

	public void configure(Binder binder) {
		binder.bind(ITransientValueService.class).to(getITransientValueService());
		binder.bind(IAntlrParser.class).to(getIAntlrParser());
		binder.bind(ITokenToStringConverter.class).to(getITokenToStringConverter());
		binder.bind(IPackratParser.class).to(getIPackratParser());
		binder.bind(IParseResultFactory.class).to(getIParseResultFactory());
		binder.bind(ISwitchingParser.class).to(getISwitchingParser());

		bindIGrammarAccess(binder);
		bindIMetamodelAccess(binder);
		bindIAstFactory(binder);
		bindIAntlrTokenFileProvider(binder);
		bindIResourceFactory(binder);
		bindIParseTreeConstructor(binder);
		bindITokenSerializer(binder);
		bindICrossReferenceSerializer(binder);
		bindLexer(binder);
		bindIFragmentProvider(binder);
		bindIScopeProvider(binder);
		bindILinkingService(binder);
		bindILinker(binder);
		bindIValueConvertService(binder);
	}

}
