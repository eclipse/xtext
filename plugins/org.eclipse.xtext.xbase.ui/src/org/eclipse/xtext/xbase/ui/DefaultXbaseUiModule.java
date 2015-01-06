/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule;
import org.eclipse.xtext.common.types.ui.navigation.GlobalDerivedMemberAwareURIEditorOpener;
import org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.common.types.ui.query.IJavaSearchParticipation;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.ui.DefaultUiModule;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities;
import org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContextType;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.xbase.imports.IUnresolvedTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider;
import org.eclipse.xtext.xbase.ui.contentassist.ImportingTypesProposalProvider;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseContentProposalPriorities;
import org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingCalculator;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.eclipse.xtext.xbase.ui.hover.XbaseDispatchingEObjectTextHover;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;
import org.eclipse.xtext.xbase.ui.imports.InteractiveUnresolvedTypeResolver;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceHandler;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceQueryExecutor;
import org.eclipse.xtext.xbase.ui.jvmmodel.navigation.DerivedMemberAwareEditorOpener;
import org.eclipse.xtext.xbase.ui.jvmmodel.occurrence.JvmModelOccurrenceComputer;
import org.eclipse.xtext.xbase.ui.jvmmodel.outline.JvmOutlineNodeElementOpener;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameRefactoringProvider;
import org.eclipse.xtext.xbase.ui.navigation.TypeLiteralAwareHyperlinkHelper;
import org.eclipse.xtext.xbase.ui.quickfix.XbaseCrossRefResolutionConverter;
import org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater;
import org.eclipse.xtext.xbase.ui.syntaxcoloring.XbaseTokenToAttributeIdMapper;
import org.eclipse.xtext.xbase.ui.templates.XbaseTemplateContextType;
import org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * contains default bindings for all Xbase inheriting languages.
 */
public class DefaultXbaseUiModule extends DefaultCommonTypesUiModule {

	public DefaultXbaseUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return XbaseTokenToAttributeIdMapper.class;
	}

	@Override
	public Class<? extends AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator> bindAbstractJavaBasedContentProposalProvider$ReferenceProposalCreator() {
		return XbaseReferenceProposalCreator.class;
	}

	@Override
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return RepeatedContentAssistProcessor.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return XbaseHighlightingCalculator.class;
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
		return TypeLiteralAwareHyperlinkHelper.class;
	}

	public Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTracker$Provider() {
		return OptimizingFeatureScopeTrackerProvider.class;
	}

	public Class<? extends IContentProposalPriorities> bindIContentProposalPriorities() {
		return XbaseContentProposalPriorities.class;
	}

	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return EclipseResourceFileSystemAccess2.class;
	}
}
