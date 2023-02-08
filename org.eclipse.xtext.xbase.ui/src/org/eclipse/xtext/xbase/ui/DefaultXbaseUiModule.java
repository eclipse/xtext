/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.EclipseSourceFolderProvider;
import org.eclipse.xtext.builder.JDTAwareEclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.JDTAwareSourceFolderProvider;
import org.eclipse.xtext.builder.preferences.BuilderConfigurationBlock;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities;
import org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor;
import org.eclipse.xtext.ui.editor.folding.FoldingActionContributor;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.ui.builder.EclipseGeneratorConfigProvider;
import org.eclipse.xtext.xbase.ui.builder.XbaseBuilderConfigurationBlock;
import org.eclipse.xtext.xbase.ui.builder.XbaseBuilderPreferenceAccess;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseContentProposalPriorities;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator;
import org.eclipse.xtext.xbase.ui.editor.XbaseResourceForEditorInputFactory;
import org.eclipse.xtext.xbase.ui.editor.actions.XbaseFoldingActionContributor;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.eclipse.xtext.xbase.ui.hover.XbaseDispatchingEObjectTextHover;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;
import org.eclipse.xtext.xbase.ui.navigation.XbaseHyperLinkHelper;
import org.eclipse.xtext.xbase.ui.quickfix.XbaseCrossRefResolutionConverter;
import org.eclipse.xtext.xbase.ui.validation.ProjectAwareUniqueClassNameValidator;
import org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator;
import org.eclipse.xtext.xbase.validation.UniqueClassNameValidator;

/**
 * A base module that contains default UI bindings for all Xbase inheriting languages.
 *
 * @since 2.8
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultXbaseUiModule extends DefaultCommonTypesUiModule {

	public DefaultXbaseUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return DefaultAntlrTokenToAttributeIdMapper.class;
	}

	@Override
	public Class<? extends AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator> bindAbstractJavaBasedContentProposalProvider$ReferenceProposalCreator() {
		return XbaseReferenceProposalCreator.class;
	}

	@Override
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return RepeatedContentAssistProcessor.class;
	}

	/**
	 * @deprecated clients should use the new org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
	 */
	@Deprecated
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return null;
	}
	
	public Class<? extends org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindIdeSemanticHighlightingCalculator() {
		return org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return XbaseHighlightingConfiguration.class;
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return XbaseHoverProvider.class;
	}

	@Override
	public Class<? extends IEObjectHover> bindIEObjectHover() {
		return XbaseDispatchingEObjectTextHover.class;
	}

	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider() {
		return XbaseHoverDocumentationProvider.class;
	}

	public Class<? extends DefaultQuickfixProvider.CrossRefResolutionConverter> bindDefaultQuickfixProvider$CrossRefResolutionConverter() {
		return XbaseCrossRefResolutionConverter.class;
	}

	@SingletonBinding(eager = true)
	public Class<? extends XbaseUIValidator> bindXbaseUIValidator() {
		return XbaseUIValidator.class;
	}

	@Override
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return XbaseHyperLinkHelper.class;
	}

	public Class<? extends org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider> bindIFeatureScopeTracker$Provider() {
		return org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider.class;
	}

	public Class<? extends IContentProposalPriorities> bindIContentProposalPriorities() {
		return XbaseContentProposalPriorities.class;
	}

	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return EclipseResourceFileSystemAccess2.class;
	}

	public Class<? extends EclipseResourceFileSystemAccess2> bindEclipseResourceFileSystemAccess2() {
		return JDTAwareEclipseResourceFileSystemAccess2.class;
	}

	public Class<? extends EclipseSourceFolderProvider> bindEclipseSourceFolderProvider() {
		return JDTAwareSourceFolderProvider.class;
	}

	@SingletonBinding(eager = true)
	public Class<? extends UniqueClassNameValidator> bindUniqueClassNameValidator() {
		return ProjectAwareUniqueClassNameValidator.class;
	}

	public Class<? extends FoldingActionContributor> bindFoldingActionContributor() {
		return XbaseFoldingActionContributor.class;
	}

	public Class<? extends BuilderConfigurationBlock> bindBuilderConfigurationBlock() {
		return XbaseBuilderConfigurationBlock.class;
	}

	public Class<? extends IGeneratorConfigProvider> bindIGeneratorConfigProvider() {
		return EclipseGeneratorConfigProvider.class;
	}

	public Class<? extends BuilderPreferenceAccess.Initializer> bindBuilderPreferenceAccess$Initializer() {
		return XbaseBuilderPreferenceAccess.Initializer.class;
	}

	/**
	 * @since 2.9
	 */
	public org.eclipse.core.resources.IWorkspaceRoot bindIWorkspaceRootToInstance() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	/**
	 * @since 2.13
	 */
	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return XbaseResourceForEditorInputFactory.class;
	}

}
