/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea;

import org.eclipse.xtend.core.idea.editorActions.XtendAutoEditBlockProvider;
import org.eclipse.xtend.core.idea.editorActions.XtendTokenSetProvider;
import org.eclipse.xtend.core.idea.formatting.XtendBlockFactory;
import org.eclipse.xtend.core.idea.formatting.XtendChildAttributesProvider;
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingConfiguration;
import org.eclipse.xtend.core.idea.highlighting.XtendSyntaxHighlighter;
import org.eclipse.xtend.core.idea.intentions.XtendIntentionsProvider;
import org.eclipse.xtend.core.idea.javaconverter.IdeaASTParserFactory;
import org.eclipse.xtend.core.idea.macro.IdeaFileSystemSupport;
import org.eclipse.xtend.core.idea.macro.IdeaProcessorProvider;
import org.eclipse.xtend.core.idea.presentation.XtendItemPresentationProvider;
import org.eclipse.xtend.core.idea.structureview.XtendStructureViewBuilder;
import org.eclipse.xtend.core.idea.validation.XtendIdeaValidator;
import org.eclipse.xtend.core.javaconverter.ASTParserFactory;
import org.eclipse.xtend.core.linking.Linker;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.ide.common.contentassist.antlr.DisabledInternalLexer;
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistContextFactory;
import org.eclipse.xtend.ide.common.contentassist.antlr.FlexerBasedContentAssistParser;
import org.eclipse.xtend.ide.common.contentassist.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.ide.common.editor.bracketmatching.XtendBracePairProvider;
import org.eclipse.xtend.ide.common.highlighting.XtendAntlrTokenToAttributeIdMapper;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingCalculator;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockProvider;
import org.eclipse.xtext.idea.editorActions.TokenSetProvider;
import org.eclipse.xtext.idea.formatting.BlockFactory;
import org.eclipse.xtext.idea.formatting.ChildAttributesProvider;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.idea.intentions.IdeaIntentionsProvider;
import org.eclipse.xtext.idea.presentation.ItemPresentationProvider;
import org.eclipse.xtext.idea.structureview.XtextFileAwareStructureViewBuilder;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.TraceForVirtualFileProvider;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.service.SingletonBinding;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.util.Key;
import com.intellij.psi.util.PsiModificationTracker;

public class XtendIdeaModule extends AbstractXtendIdeaModule {

	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return FlexerBasedContentAssistParser.class;
	}
	
	public void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(InternalXtendLexer.class).toProvider(LexerProvider.create(DisabledInternalLexer.class));
		binder.bind(DisabledInternalLexer.class).toProvider(LexerProvider.create(DisabledInternalLexer.class));
	}

	public void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer.class).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(DisabledInternalLexer.class);
	}
	
	public Class<? extends ContentAssistContextFactory> bindContentAssistContextFactory() {
		return FlexerBasedContentAssistContextFactory.class;
	}
	
	public Class<? extends ProcessorInstanceForJvmTypeProvider> bindProcessorInstanceForJvmTypeProvider() {
		return IdeaProcessorProvider.class;
	}
	
	@Override
	@SingletonBinding
	public Class<? extends IBracePairProvider> bindIBracePairProvider() {
		return XtendBracePairProvider.class;
	}
	
	public Class<? extends AbstractFileSystemSupport> bindAbstractFileSystemSupport() {
		return IdeaFileSystemSupport.class;
	}

	@SingletonBinding
	public Class<? extends ItemPresentationProvider> bindItemPresentationProvider() {
		return XtendItemPresentationProvider.class;
	}

	public Class<? extends XtextFileAwareStructureViewBuilder> bindXtextFileAwareStructureViewBuilder() {
		return XtendStructureViewBuilder.class;
	}

	@org.eclipse.xtext.service.SingletonBinding(eager = true)
	public Class<? extends XtendIdeaValidator> bindXtendIdeaValidator() {
		return XtendIdeaValidator.class;
	}

	public Class<? extends ILinker> bindILinker() {
		return Linker.class;
	}

	@Override
	public void configureGlobalModificationTracker(Binder binder) {
		binder.bind(Key.class).annotatedWith(Names.named(BaseXtextFile.GLOBAL_MODIFICATION_COUNT)).toInstance(PsiModificationTracker.JAVA_STRUCTURE_MODIFICATION_COUNT);
	}
	
	@SingletonBinding
	public Class<? extends TokenSetProvider> bindTokenSetProvider() {
		return XtendTokenSetProvider.class;
	}
	
	@SingletonBinding
	public Class<? extends AutoEditBlockProvider> bindAutoEditBlockProvider() {
		return XtendAutoEditBlockProvider.class;
	}

	@Override
	@SingletonBinding
	public Class<? extends SyntaxHighlighter> bindSyntaxHighlighter() {
		return XtendSyntaxHighlighter.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return XtendHighlightingCalculator.class;
	}
	
	@Override
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return XtendHighlightingConfiguration.class;
	}
	
	@Override
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return XtendAntlrTokenToAttributeIdMapper.class;
	}
	
	public Class<? extends IdeaIntentionsProvider> bindIdeaQuickFixProvider() {
		return XtendIntentionsProvider.class;
	}

	@Override
	public Class<? extends BlockFactory> bindBlockFactory() {
		return XtendBlockFactory.class;
	}
	
	@Override
	public Class<? extends ChildAttributesProvider> bindChildAttributesProvider() {
		return XtendChildAttributesProvider.class;
	}
	
	public Class<? extends ASTParserFactory> bindASTParserFactory() {
		return IdeaASTParserFactory.class;
	}
	
}
