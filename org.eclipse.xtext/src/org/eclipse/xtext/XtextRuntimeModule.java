/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting2.FormatterPreferenceValuesProvider;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.xtext.GrammarResource;
import org.eclipse.xtext.xtext.XtextConfigurableIssueCodes;
import org.eclipse.xtext.xtext.XtextCrossReferenceSerializer;
import org.eclipse.xtext.xtext.XtextDiagnosticConverter;
import org.eclipse.xtext.xtext.XtextFormatter;
import org.eclipse.xtext.xtext.XtextFormatterJava;
import org.eclipse.xtext.xtext.XtextFragmentProvider;
import org.eclipse.xtext.xtext.XtextLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xtext.XtextLinkingService;
import org.eclipse.xtext.xtext.XtextLocationInFileProvider;
import org.eclipse.xtext.xtext.XtextReferableElementsUnloader;
import org.eclipse.xtext.xtext.XtextResourceDescriptionStrategy;
import org.eclipse.xtext.xtext.XtextScopeProvider;
import org.eclipse.xtext.xtext.XtextTransientValueService;
import org.eclipse.xtext.xtext.XtextTransientValueService2;
import org.eclipse.xtext.xtext.XtextValidator;
import org.eclipse.xtext.xtext.XtextValueConverters;
import org.eclipse.xtext.xtext.CardinalityAwareSyntacticSequencer;
import org.eclipse.xtext.xtext.parser.CardinalityAwareEcoreFactory;
import org.eclipse.xtext.xtext.parser.CardinalityAwareSyntaxErrorMessageProvider;

import com.google.inject.Binder;

/**
 * used to register components to be used at runtime.
 */
public class XtextRuntimeModule extends AbstractXtextRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(XtextValidator.class).asEagerSingleton();
	}

	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return XtextLinkingService.class;
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return XtextScopeProvider.class;
	}

	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return XtextCrossReferenceSerializer.class;
	}

	@Override
	public Class<? extends ILinker> bindILinker() {
		return org.eclipse.xtext.xtext.XtextLinker.class;
	}

	@Override
	public Class<? extends ITransientValueService> bindITransientValueService() {
		return XtextTransientValueService.class;
	}

	public Class<? extends org.eclipse.xtext.serializer.sequencer.ITransientValueService> bindITransientValueService2() {
		return XtextTransientValueService2.class;
	}

	@Override
	public Class<? extends IFormatter> bindIFormatter() {
		return XtextFormatter.class;
	}

	public Class<? extends IFormatter2> bindIFormatter2() {
		return XtextFormatterJava.class;
	}
	
	public void configureFormatterPreferences(Binder binder) {
		binder.bind(IPreferenceValuesProvider.class).annotatedWith(FormatterPreferences.class)
				.to(FormatterPreferenceValuesProvider.class);
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return XtextValueConverters.class;
	}

	/**
	 * @since 2.9
	 */
	@SuppressWarnings({"removal","deprecation"})
	public void configureIXtext2EcorePostProcessor(Binder binder) {
		try {
			Class.forName("org.eclipse.xtend.expression.ExecutionContext");
			binder.bind(org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor.class)
				.to(org.eclipse.xtext.xtext.ecoreInference.XtendXtext2EcorePostProcessor.class);
		} catch (ClassNotFoundException e) {
		}
	}

	@Override
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return XtextFragmentProvider.class;
	}

	public Class<? extends IReferableElementsUnloader> bindIReferableElementsUnloader() {
		return XtextReferableElementsUnloader.class;
	}

	public Class<? extends IDiagnosticConverter> bindIDiagnosticConverter() {
		return XtextDiagnosticConverter.class;
	}

	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return XtextResourceDescriptionStrategy.class;
	}

	public Class<? extends ILinkingDiagnosticMessageProvider.Extended> bindILinkingDiagnosticMessageProvider() {
		return XtextLinkingDiagnosticMessageProvider.class;
	}

	@Override
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return XtextLocationInFileProvider.class;
	}

	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return DefaultGlobalScopeProvider.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return GrammarResource.class;
	}

	/**
	 * @since 2.2
	 */
	public Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
		return GrammarResource.LinkingTrigger.class;
	}

	/**
	 * @since 2.2
	 */
	public Class<? extends IResourceDescription.Manager> bindIResourceDescriptionManager() {
		return DerivedStateAwareResourceDescriptionManager.class;
	}

	/**
	 * @since 2.8
	 */
	public Class<? extends ConfigurableIssueCodesProvider> bindConfigurableIssueCodesProvider() {
		return XtextConfigurableIssueCodes.class;
	}

	/**
	 * @since 2.9
	 */
	public Class<? extends DefaultEcoreElementFactory> bindCardinalityAwareFactory() {
		return CardinalityAwareEcoreFactory.class;
	}

	/**
	 * @since 2.9
	 */
	public Class<? extends SyntaxErrorMessageProvider> bindSyntaxErrorMessageProvider() {
		return CardinalityAwareSyntaxErrorMessageProvider.class;
	}

	/**
	 * @since 2.9
	 */
	@Override
	public Class<? extends ISerializer> bindISerializer() {
		return Serializer.class;
	}

	@Override
	public Class<? extends ISyntacticSequencer> bindISyntacticSequencer() {
		return CardinalityAwareSyntacticSequencer.class;
	}
}
