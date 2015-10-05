/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.ui;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.xbase.annotations.ui.contentassist.XbaseWithAnnotationsProposalProvider;
import org.eclipse.xtext.xbase.annotations.ui.contentassist.antlr.XbaseWithAnnotationsParser;
import org.eclipse.xtext.xbase.annotations.ui.labeling.XbaseWithAnnotationsLabelProvider;
import org.eclipse.xtext.xbase.annotations.ui.outline.XbaseWithAnnotationsOutlineTreeProvider;
import org.eclipse.xtext.xbase.annotations.ui.quickfix.XbaseWithAnnotationsQuickfixProvider;
import org.eclipse.xtext.xbase.ui.editor.XbaseDocumentProvider;
import org.eclipse.xtext.xbase.ui.editor.XbaseEditor;
import org.eclipse.xtext.xbase.ui.generator.trace.XbaseOpenGeneratedFileHandler;
import org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixes;
import org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixesNoImportSection;
import org.eclipse.xtext.xbase.ui.refactoring.XbaseRenameStrategy;

/**
 * Manual modifications go to {@link XbaseWithAnnotationsUiModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractXbaseWithAnnotationsUiModule extends DefaultXbaseWithAnnotationsUiModule {

	public AbstractXbaseWithAnnotationsUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.LanguageConfig2
	public Provider<IAllContainersState> provideIAllContainersState() {
		return Access.getJavaProjectsState();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.LanguageConfig2
	public Class<? extends XtextEditor> bindXtextEditor() {
		return XbaseEditor.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.LanguageConfig2
	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return XbaseDocumentProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.LanguageConfig2
	public Class<? extends OpenGeneratedFileHandler> bindOpenGeneratedFileHandler() {
		return XbaseOpenGeneratedFileHandler.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return AntlrProposalConflictHelper.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.xbase.annotations.parser.antlr.internal.InternalXbaseWithAnnotationsLexer.class);
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingTokenDefProvider(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2
	public Class<? extends PrefixMatcher> bindPrefixMatcher() {
		return FQNPrefixMatcher.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
		return XbaseRenameStrategy.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends JavaTypeQuickfixes> bindJavaTypeQuickfixes() {
		return JavaTypeQuickfixesNoImportSection.class;
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
	
	// contributed by org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		return ContentFormatterFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.quickfix.QuickfixProviderFragment2
	public Class<? extends IssueResolutionProvider> bindIssueResolutionProvider() {
		return XbaseWithAnnotationsQuickfixProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return XbaseWithAnnotationsLabelProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public void configureResourceUIServiceLabelProvider(Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(org.eclipse.xtext.xbase.annotations.ui.labeling.XbaseWithAnnotationsDescriptionLabelProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
	public Class<? extends IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return XbaseWithAnnotationsOutlineTreeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
	public Class<? extends IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return XbaseWithAnnotationsOutlineTreeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment
	public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
		return XbaseWithAnnotationsProposalProvider.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return ParserBasedContentAssistContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return XbaseWithAnnotationsParser.class;
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(org.eclipse.xtext.xbase.annotations.ui.contentassist.antlr.internal.InternalXbaseWithAnnotationsLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(org.eclipse.xtext.xbase.annotations.ui.contentassist.antlr.internal.InternalXbaseWithAnnotationsLexer.class));
	}
	
	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(org.eclipse.xtext.xbase.annotations.ui.contentassist.antlr.internal.InternalXbaseWithAnnotationsLexer.class);
	}
	
}
