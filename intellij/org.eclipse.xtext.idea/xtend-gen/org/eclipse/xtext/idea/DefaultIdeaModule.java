package org.eclipse.xtext.idea;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.ide.LexerUIBindings;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.idea.containers.ResolveScopeBasedContainerManger;
import org.eclipse.xtext.idea.parser.AntlrDelegatingIdeaLexer;
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions;
import org.eclipse.xtext.idea.syntaxcoloring.DefaultSyntaxHighlighter;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.SingletonBinding;

@SuppressWarnings("all")
public class DefaultIdeaModule extends AbstractGenericModule {
  public Class<? extends Lexer> bindLexer() {
    return AntlrDelegatingIdeaLexer.class;
  }
  
  public void configureIResourceDescriptions(final Binder binder) {
    AnnotatedBindingBuilder<IResourceDescriptions> _bind = binder.<IResourceDescriptions>bind(IResourceDescriptions.class);
    _bind.to(ProjectScopeBasedResourceDescriptions.class);
  }
  
  public Class<? extends IContainer.Manager> bindIContainer$Manager() {
    return ResolveScopeBasedContainerManger.class;
  }
  
  public Class<? extends IPsiModelAssociations> bindIPsiModelAssociations() {
    return PsiModelAssociations.class;
  }
  
  public Class<? extends IPsiModelAssociator> bindIPsiModelAssociator() {
    return PsiModelAssociations.class;
  }
  
  @SingletonBinding
  public Class<? extends ExportedObjectQualifiedNameIndex> bindExportedObjectQualifiedNameIndex() {
    return ExportedObjectQualifiedNameIndex.class;
  }
  
  @SingletonBinding
  public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
    return DefaultAntlrTokenToAttributeIdMapper.class;
  }
  
  @SingletonBinding
  public Class<? extends SyntaxHighlighter> bindSyntaxHighlighter() {
    return DefaultSyntaxHighlighter.class;
  }
  
  public void configureHighlightingTokenDefProvider(final Binder binder) {
    AnnotatedBindingBuilder<ITokenDefProvider> _bind = binder.<ITokenDefProvider>bind(ITokenDefProvider.class);
    Named _named = Names.named(LexerUIBindings.HIGHLIGHTING);
    LinkedBindingBuilder<ITokenDefProvider> _annotatedWith = _bind.annotatedWith(_named);
    _annotatedWith.to(AntlrTokenDefProvider.class);
  }
}
