/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.ui.codetemplates.ui.contentassist.SingleCodetemplateProposalProvider;
import org.eclipse.xtext.ui.codetemplates.ui.contentassist.SingleTemplateProposalConflictHelper;
import org.eclipse.xtext.ui.codetemplates.ui.editor.embedded.CodetemplatesEmbeddedEditorActions;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.SemanticHighlighter;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.SingleTemplateTokenDefProvider;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.TemplatesHighlightingConfiguration;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.TokenToAttributeMapper;
import org.eclipse.xtext.ui.codetemplates.ui.internal.CodetemplatesActivator;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.ui.codetemplates.ui.scoping.SyntheticResourceAwareScopeProvider;
import org.eclipse.xtext.ui.codetemplates.ui.validation.TemplateValidator;
import org.eclipse.xtext.ui.codetemplates.validation.CodetemplatesValidator;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorActions;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.ResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.PreferenceStoreAccessor;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider;
import org.eclipse.xtext.ui.shared.Access;

import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class SingleCodetemplateUiModule extends org.eclipse.xtext.ui.codetemplates.ui.AbstractSingleCodetemplateUiModule {
	public SingleCodetemplateUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public void configureHighlightingTokenDefProvider(Binder binder) {
		binder.bind(ITokenDefProvider.class).annotatedWith(Names.named(LexerIdeBindings.HIGHLIGHTING)).to(SingleTemplateTokenDefProvider.class);
	}
	
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return TokenToAttributeMapper.class;
	}
	
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return TemplatesHighlightingConfiguration.class;
	}
	
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return SyntheticResourceAwareScopeProvider.class;
	}
	
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlighter.class;
	}
	
	@SingletonBinding(eager=true)	
	public Class<? extends CodetemplatesValidator> bindTemplatesJavaValidator() {
		return TemplateValidator.class;
	}
	
	@Override
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return RepeatedContentAssistProcessor.class;
	}
	
	@Override
	public Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return SingleTemplateProposalConflictHelper.class;
	}
	
	@Override
	public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
		return SingleCodetemplateProposalProvider.class;
	}
	
	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return ResourceForIEditorInputFactory.class;
	}

	@Override
	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return SimpleResourceSetProvider.class;
	}
	
	public Class<? extends ITraceForStorageProvider> bindITraceInformation() {
		return ITraceForStorageProvider.Null.class;
	}

	@Override
	public Provider<IAllContainersState> provideIAllContainersState() {
		return Access.getWorkspaceProjectsState();
	}
	
	public Provider<PreferenceStoreAccessor> providePreferenceStoreAccessor() {
		Injector injector = CodetemplatesActivator.getInstance().getInjector("org.eclipse.xtext.ui.codetemplates.Codetemplates");
		return injector.getProvider(PreferenceStoreAccessor.class);
	}
	
	public Provider<IPreferenceStoreAccess> provideIPreferenceStoreAccess() {
		Injector injector = CodetemplatesActivator.getInstance().getInjector("org.eclipse.xtext.ui.codetemplates.Codetemplates");
		return injector.getProvider(IPreferenceStoreAccess.class);
	}
	
	public Provider<LanguageRegistry> provideLanguageRegistry() {
		Injector injector = CodetemplatesActivator.getInstance().getInjector("org.eclipse.xtext.ui.codetemplates.Codetemplates");
		return injector.getProvider(LanguageRegistry.class);
	}
	
	public Class<? extends EmbeddedEditorActions.Factory> bindEmbeddedEditorActions$Factory() {
		return CodetemplatesEmbeddedEditorActions.Factory.class;
	}

}
