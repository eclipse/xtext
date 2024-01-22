/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.ui;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.common.types.ui.navigation.GlobalDerivedMemberAwareURIEditorOpener;
import org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.common.types.ui.query.IJavaSearchParticipation;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.xbase.testlanguages.ide.contentassist.antlr.ContentAssistFragmentTestLangParser;
import org.eclipse.xtext.xbase.testlanguages.ide.contentassist.antlr.internal.InternalContentAssistFragmentTestLangLexer;
import org.eclipse.xtext.xbase.testlanguages.ui.contentassist.ContentAssistFragmentTestLangProposalProvider;
import org.eclipse.xtext.xbase.testlanguages.ui.editor.ContentAssistFragmentTestLangEditor;
import org.eclipse.xtext.xbase.ui.DefaultXbaseUiModule;
import org.eclipse.xtext.xbase.ui.editor.XbaseDocumentProvider;
import org.eclipse.xtext.xbase.ui.generator.trace.XbaseOpenGeneratedFileHandler;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceHandler;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceQueryExecutor;
import org.eclipse.xtext.xbase.ui.jvmmodel.navigation.DerivedMemberAwareEditorOpener;
import org.eclipse.xtext.xbase.ui.jvmmodel.outline.JvmOutlineNodeElementOpener;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContextFactory;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameRefactoringProvider;
import org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixes;
import org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixesNoImportSection;
import org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater;

/**
 * Manual modifications go to {@link ContentAssistFragmentTestLangUiModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractContentAssistFragmentTestLangUiModule extends DefaultXbaseUiModule {

	public AbstractContentAssistFragmentTestLangUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ImplicitFragment
	public Provider<? extends IAllContainersState> provideIAllContainersState() {
		return Access.getJavaProjectsState();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ImplicitFragment
	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return XbaseDocumentProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ImplicitFragment
	public Class<? extends OpenGeneratedFileHandler> bindOpenGeneratedFileHandler() {
		return XbaseOpenGeneratedFileHandler.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return AntlrProposalConflictHelper.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer.class)
			.annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST))
			.to(InternalContentAssistFragmentTestLangLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureHighlightingLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class)
			.annotatedWith(Names.named(LexerIdeBindings.HIGHLIGHTING))
			.to(org.eclipse.xtext.xbase.testlanguages.parser.antlr.internal.InternalContentAssistFragmentTestLangLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureHighlightingTokenDefProvider(Binder binder) {
		binder.bind(ITokenDefProvider.class)
			.annotatedWith(Names.named(LexerIdeBindings.HIGHLIGHTING))
			.to(AntlrTokenDefProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return DelegatingContentAssistContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return ContentAssistFragmentTestLangParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(InternalContentAssistFragmentTestLangLexer.class).toProvider(LexerProvider.create(InternalContentAssistFragmentTestLangLexer.class));
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsBuilderScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(CurrentDescriptions.ResourceSetAware.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return NatureAddingEditorCallback.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
		return EclipseOutputConfigurationProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsPersisted(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(IBuilderState.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
		return PersistentDataAwareDirtyResource.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2
	public Class<? extends PrefixMatcher> bindPrefixMatcher() {
		return FQNPrefixMatcher.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends FindReferencesHandler> bindFindReferencesHandler() {
		return JvmModelFindReferenceHandler.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends ReferenceQueryExecutor> bindReferenceQueryExecutor() {
		return JvmModelReferenceQueryExecutor.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return JvmModelDependentElementsCalculator.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IRenameRefactoringProvider> bindIRenameRefactoringProvider() {
		return CombinedJvmJdtRenameRefactoringProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IReferenceUpdater> bindIReferenceUpdater() {
		return XbaseReferenceUpdater.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IRenameContextFactory> bindIRenameContextFactory() {
		return CombinedJvmJdtRenameContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
		return DefaultJvmModelRenameStrategy.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends JdtRenameParticipant.ContextFactory> bindJdtRenameParticipant$ContextFactory() {
		return JvmModelJdtRenameParticipantContext.ContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends OutlineNodeElementOpener> bindOutlineNodeElementOpener() {
		return JvmOutlineNodeElementOpener.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends GlobalURIEditorOpener> bindGlobalURIEditorOpener() {
		return GlobalDerivedMemberAwareURIEditorOpener.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IJavaSearchParticipation> bindIJavaSearchParticipation() {
		return IJavaSearchParticipation.No.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public void configureLanguageSpecificURIEditorOpener(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class).to(DerivedMemberAwareEditorOpener.class);
			binder.bind(IDerivedMemberAwareEditorOpener.class).to(DerivedMemberAwareEditorOpener.class);
		}
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends JavaTypeQuickfixes> bindJavaTypeQuickfixes() {
		return JavaTypeQuickfixesNoImportSection.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends XtextEditor> bindXtextEditor() {
		return ContentAssistFragmentTestLangEditor.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.contentAssist.ContentAssistFragment2
	public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
		return ContentAssistFragmentTestLangProposalProvider.class;
	}
	
}
