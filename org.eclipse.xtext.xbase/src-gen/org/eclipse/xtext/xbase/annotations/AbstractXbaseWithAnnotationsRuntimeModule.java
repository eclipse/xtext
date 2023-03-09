/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import java.util.Properties;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.IgnoreCaseLinking;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter;
import org.eclipse.xtext.xbase.annotations.parser.antlr.XbaseWithAnnotationsAntlrTokenFileProvider;
import org.eclipse.xtext.xbase.annotations.parser.antlr.XbaseWithAnnotationsParser;
import org.eclipse.xtext.xbase.annotations.parser.antlr.internal.InternalXbaseWithAnnotationsLexer;
import org.eclipse.xtext.xbase.annotations.serializer.XbaseWithAnnotationsSemanticSequencer;
import org.eclipse.xtext.xbase.annotations.serializer.XbaseWithAnnotationsSyntacticSequencer;
import org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;
import org.eclipse.xtext.xbase.annotations.validation.XbaseWithAnnotationsValidator;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.resource.XbaseLocationInFileProvider;
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;
import org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider;

/**
 * Manual modifications go to {@link XbaseWithAnnotationsRuntimeModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractXbaseWithAnnotationsRuntimeModule extends DefaultXbaseWithAnnotationsRuntimeModule {

	protected Properties properties = null;

	@Override
	public void configure(Binder binder) {
		properties = tryBindProperties(binder, "org/eclipse/xtext/xbase/annotations/XbaseWithAnnotations.properties");
		super.configure(binder);
	}
	
	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations");
	}
	
	public void configureFileExtensions(Binder binder) {
		if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
			binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("___xbasewithannotations");
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2
	public ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2
	public Class<? extends IGrammarAccess> bindIGrammarAccess() {
		return XbaseWithAnnotationsGrammarAccess.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
	public Class<? extends ISemanticSequencer> bindISemanticSequencer() {
		return XbaseWithAnnotationsSemanticSequencer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
	public Class<? extends ISyntacticSequencer> bindISyntacticSequencer() {
		return XbaseWithAnnotationsSyntacticSequencer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
	public Class<? extends ISerializer> bindISerializer() {
		return Serializer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IParser> bindIParser() {
		return XbaseWithAnnotationsParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends ITokenToStringConverter> bindITokenToStringConverter() {
		return AntlrTokenToStringConverter.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return XbaseWithAnnotationsAntlrTokenFileProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends Lexer> bindLexer() {
		return InternalXbaseWithAnnotationsLexer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends ITokenDefProvider> bindITokenDefProvider() {
		return AntlrTokenDefProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Provider<? extends InternalXbaseWithAnnotationsLexer> provideInternalXbaseWithAnnotationsLexer() {
		return LexerProvider.create(InternalXbaseWithAnnotationsLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureRuntimeLexer(Binder binder) {
		binder.bind(Lexer.class)
			.annotatedWith(Names.named(LexerBindings.RUNTIME))
			.to(InternalXbaseWithAnnotationsLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2
	@SingletonBinding(eager=true)
	public Class<? extends XbaseWithAnnotationsValidator> bindXbaseWithAnnotationsValidator() {
		return XbaseWithAnnotationsValidator.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
	public Class<? extends IBatchScopeProvider> bindIBatchScopeProvider() {
		return XbaseWithAnnotationsBatchScopeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(XImportSectionNamespaceScopeProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
	public void configureIgnoreCaseLinking(Binder binder) {
		binder.bindConstant().annotatedWith(IgnoreCaseLinking.class).to(false);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return TypesAwareDefaultGlobalScopeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return XbaseQualifiedNameProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public void configureRewritableImportSectionEnablement(Binder binder) {
		binder.bind(Boolean.TYPE)
			.annotatedWith(Names.named(RewritableImportSection.Factory.REWRITABLEIMPORTSECTION_ENABLEMENT))
			.toInstance(Boolean.FALSE);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return XbaseLocationInFileProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IContainer.Manager> bindIContainer$Manager() {
		return StateBasedContainerManager.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IAllContainersState.Provider> bindIAllContainersState$Provider() {
		return ResourceSetBasedAllContainersStateProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptions(Binder binder) {
		binder.bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsPersisted(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(ResourceSetBasedResourceDescriptions.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
	public Class<? extends IFormatter2> bindIFormatter2() {
		return XbaseWithAnnotationsFormatter.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
	public void configureFormatterPreferences(Binder binder) {
		binder.bind(IPreferenceValuesProvider.class).annotatedWith(FormatterPreferences.class).to(FormatterPreferenceValuesProvider.class);
	}
	
}
