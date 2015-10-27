/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class IdeaPluginClassNames {
  public String toSimpleName(final String name) {
    return Strings.lastToken(name, ".");
  }
  
  public String toPackageName(final String name) {
    return Strings.skipLastToken(name, ".");
  }
  
  public String toJavaPath(final String fullName) {
    String _path = this.toPath(fullName);
    return (_path + ".java");
  }
  
  public String toXtendPath(final String fullName) {
    String _path = this.toPath(fullName);
    return (_path + ".xtend");
  }
  
  public String toPath(final String fullName) {
    return fullName.replace(".", "/");
  }
  
  public String getBasePackageName(final Grammar grammar) {
    String _name = grammar.getName();
    String _packageName = this.toPackageName(_name);
    return (_packageName + ".idea");
  }
  
  public String getIdeaModuleName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "IdeaModule");
  }
  
  public String getStandaloneSetup(final Grammar it) {
    String _name = it.getName();
    String _packageName = this.toPackageName(_name);
    String _plus = (_packageName + ".");
    String _name_1 = it.getName();
    String _simpleName = this.toSimpleName(_name_1);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "StandaloneSetup");
  }
  
  public String getStandaloneSetupIdea(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "StandaloneSetupIdea");
  }
  
  public String getIdeaSetup(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "IdeaSetup");
  }
  
  public String getExtensionFactoryName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "ExtensionFactory");
  }
  
  public String getAbstractIdeaModuleName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".Abstract");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "IdeaModule");
  }
  
  public String getFileTypeName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "FileType");
  }
  
  public String getAbstractFileTypeName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.Abstract");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "FileType");
  }
  
  public String getFileTypeFactoryName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "FileTypeFactory");
  }
  
  public String getLanguageName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "Language");
  }
  
  public String getCodeBlockModificationListenerName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.psi.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "CodeBlockModificationListener");
  }
  
  public String getPsiParserName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.parser.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "PsiParser");
  }
  
  public String getAntlrTokenFileProvider(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.parser.antlr.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "AntlrTokenFileProvider");
  }
  
  public String getPomDeclarationSearcherName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.pom.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "PomDeclarationSearcher");
  }
  
  public String getSyntaxHighlighterFactoryName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".highlighting.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "SyntaxHighlighterFactory");
  }
  
  public String getSemanticHighlightVisitorName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".highlighting.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "SemanticHighlightVisitor");
  }
  
  public String getSuperParserDefinitionName(final Grammar it) {
    return "org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition";
  }
  
  public String getParserDefinitionName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.parser.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "ParserDefinition");
  }
  
  public String getTokenTypeProviderName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.parser.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "TokenTypeProvider");
  }
  
  public String getElementTypeProviderName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "ElementTypeProvider");
  }
  
  public String getGrammarAccessName(final Grammar it) {
    String _name = it.getName();
    String _packageName = this.toPackageName(_name);
    String _plus = (_packageName + ".services.");
    String _name_1 = it.getName();
    String _simpleName = this.toSimpleName(_name_1);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "GrammarAccess");
  }
  
  public String getPsiInternalLexerName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".parser.antlr.internal.PsiInternal");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "Lexer");
  }
  
  public String getPsiInternalParserName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".parser.antlr.internal.PsiInternal");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "Parser");
  }
  
  public String getTokens(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".parser.antlr.internal.PsiInternal");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    String _path = this.toPath(_plus_1);
    return (_path + ".tokens");
  }
  
  public String getFileImplName(final Grammar it) {
    String _psiImplPackageName = this.getPsiImplPackageName(it);
    String _plus = (_psiImplPackageName + ".");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "FileImpl");
  }
  
  public String getPsiPackageName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    return (_basePackageName + ".lang.psi");
  }
  
  public String getPsiImplPackageName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    return (_basePackageName + ".lang.psi.impl");
  }
  
  public String getInternalParserName(final Grammar it) {
    String _name = it.getName();
    String _packageName = this.toPackageName(_name);
    String _plus = (_packageName + ".parser.antlr.internal.Internal");
    String _name_1 = it.getName();
    String _simpleName = this.toSimpleName(_name_1);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "Parser");
  }
  
  public String getAntlrLexerName(final Grammar it) {
    String _name = it.getName();
    String _packageName = this.toPackageName(_name);
    String _plus = (_packageName + ".parser.antlr.internal.Internal");
    String _name_1 = it.getName();
    String _simpleName = this.toSimpleName(_name_1);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "Lexer");
  }
  
  public String getCompletionContributorSuperClass(final Grammar it) {
    String _elvis = null;
    EList<Grammar> _usedGrammars = it.getUsedGrammars();
    Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
    String _completionContributor = null;
    if (_head!=null) {
      _completionContributor=this.getCompletionContributor(_head);
    }
    if (_completionContributor != null) {
      _elvis = _completionContributor;
    } else {
      _elvis = "org.eclipse.xtext.idea.completion.AbstractCompletionContributor";
    }
    return _elvis;
  }
  
  public String getCompletionContributor(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".completion.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "CompletionContributor");
  }
  
  public String getAbstractCompletionContributor(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".completion.Abstract");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "CompletionContributor");
  }
  
  public String getFacetConfiguration(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".facet.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "FacetConfiguration");
  }
  
  public String getFacetTypeName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".facet.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "FacetType");
  }
  
  public String baseColorSettingsPage(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".highlighting.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "BaseColorSettingsPage");
  }
  
  public String colorSettingsPage(final Grammar it) {
    String _baseColorSettingsPage = this.baseColorSettingsPage(it);
    String _packageName = this.toPackageName(_baseColorSettingsPage);
    String _plus = (_packageName + ".");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "ColorSettingsPage");
  }
}
