/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.lang.CodeDocumentationAwareCommenter;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.util.Key;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.trace.ITraceForURIProvider;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.bracketmatching.DefaultBracePairProvider;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.idea.build.IdeaOutputConfigurationProvider;
import org.eclipse.xtext.idea.common.types.StubTypeProviderFactory;
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfigProvider;
import org.eclipse.xtext.idea.formatting.CodeStyleSettingsIndentationInformation;
import org.eclipse.xtext.idea.formatting.DefaultCommenter;
import org.eclipse.xtext.idea.formatting.DefaultFormattingModelBuilder;
import org.eclipse.xtext.idea.highlighting.DefaultHighlightingConfiguration;
import org.eclipse.xtext.idea.highlighting.DefaultPairedBraceMatcher;
import org.eclipse.xtext.idea.highlighting.DefaultSyntaxHighlighter;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.idea.parser.AntlrDelegatingIdeaLexer;
import org.eclipse.xtext.idea.refactoring.NullNamesValidator;
import org.eclipse.xtext.idea.resource.IdeaEncodingProvider;
import org.eclipse.xtext.idea.resource.IdeaResourceDescriptionsProvider;
import org.eclipse.xtext.idea.service.IdeaOperationCanceledManager;
import org.eclipse.xtext.idea.structureview.DefaultPsiStructureViewFactory;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.TraceForVirtualFileProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.LanguageSpecific;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultIdeaModule extends AbstractGenericModule {
  public Class<? extends Lexer> bindIdeaLexer() {
    return AntlrDelegatingIdeaLexer.class;
  }
  
  public Class<? extends IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
    return StubTypeProviderFactory.class;
  }
  
  public void configureLanguageSpecificPsiModelAssociations(final Binder binder) {
    AnnotatedBindingBuilder<IPsiModelAssociations> _bind = binder.<IPsiModelAssociations>bind(IPsiModelAssociations.class);
    LinkedBindingBuilder<IPsiModelAssociations> _annotatedWith = _bind.annotatedWith(LanguageSpecific.class);
    _annotatedWith.to(PsiModelAssociations.class);
  }
  
  public Class<? extends IPsiModelAssociator> bindIPsiModelAssociator() {
    return PsiModelAssociations.class;
  }
  
  @SingletonBinding
  public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
    return DefaultAntlrTokenToAttributeIdMapper.class;
  }
  
  public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
    return DefaultHighlightingConfiguration.class;
  }
  
  public void configureHighlightingTokenDefProvider(final Binder binder) {
    AnnotatedBindingBuilder<ITokenDefProvider> _bind = binder.<ITokenDefProvider>bind(ITokenDefProvider.class);
    Named _named = Names.named(LexerIdeBindings.HIGHLIGHTING);
    LinkedBindingBuilder<ITokenDefProvider> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.to(AntlrTokenDefProvider.class);
  }
  
  @SingletonBinding
  public Class<? extends SyntaxHighlighter> bindSyntaxHighlighter() {
    return DefaultSyntaxHighlighter.class;
  }
  
  @SingletonBinding
  public Class<? extends NamesValidator> bindNamesValidator() {
    return NullNamesValidator.class;
  }
  
  @SingletonBinding
  public Class<? extends PairedBraceMatcher> bindPairedBraceMatcher() {
    return DefaultPairedBraceMatcher.class;
  }
  
  @SingletonBinding
  public Class<? extends IBracePairProvider> bindIBracePairProvider() {
    return DefaultBracePairProvider.class;
  }
  
  @SingletonBinding
  public Class<? extends PsiStructureViewFactory> bindPsiStructureViewFactory() {
    return DefaultPsiStructureViewFactory.class;
  }
  
  public void configureGlobalModificationTracker(final Binder binder) {
    AnnotatedBindingBuilder<Key> _bind = binder.<Key>bind(Key.class);
    Named _named = Names.named(BaseXtextFile.GLOBAL_MODIFICATION_COUNT);
    LinkedBindingBuilder<Key> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.toInstance(PsiModificationTracker.MODIFICATION_COUNT);
  }
  
  public Class<? extends IEncodingProvider> bindEncodingProvider() {
    return IdeaEncodingProvider.class;
  }
  
  public Class<? extends IContainer.Manager> bindIContainer$Manager() {
    return ProjectDescriptionBasedContainerManager.class;
  }
  
  public Class<? extends IWorkspaceConfigProvider> bindWorkspaceConfigProvider() {
    return IdeaWorkspaceConfigProvider.class;
  }
  
  public Class<? extends IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
    return IdeaOutputConfigurationProvider.class;
  }
  
  public Class<? extends IResourceDescriptionsProvider> bindIResourceDescriptionsProvider() {
    return IdeaResourceDescriptionsProvider.class;
  }
  
  @SingletonBinding
  public Class<? extends FormattingModelBuilder> bindFormattingModelBuilder() {
    return DefaultFormattingModelBuilder.class;
  }
  
  @SingletonBinding
  public Class<? extends CodeDocumentationAwareCommenter> bindCodeDocumentationAwareCommenter() {
    return DefaultCommenter.class;
  }
  
  @SingletonBinding
  public Class<? extends IIndentationInformation> bindIIndentationInformation() {
    return CodeStyleSettingsIndentationInformation.class;
  }
  
  public Class<? extends OperationCanceledManager> bindOperationCanceledManager() {
    return IdeaOperationCanceledManager.class;
  }
  
  public Class<? extends ITraceForURIProvider> bindPlatformNeutralTraceInformation() {
    return ITraceForVirtualFileProvider.class;
  }
  
  public Class<? extends ITraceForURIProvider> bindTraceInformation() {
    return TraceForVirtualFileProvider.class;
  }
}
