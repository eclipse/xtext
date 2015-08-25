/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.idea;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class IdeaPluginClassNames {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  public String toPath(final String fullName) {
    return fullName.replace(".", "/");
  }
  
  public TypeReference getIdeaSetup(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus = (_simpleName + "IdeaSetup");
    return new TypeReference(_ideaBasePackage, _plus);
  }
  
  public TypeReference getExtensionFactory(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus = (_simpleName + "ExtensionFactory");
    return new TypeReference(_ideaBasePackage, _plus);
  }
  
  public TypeReference getAbstractIdeaModule(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus = ("Abstract" + _simpleName);
    String _plus_1 = (_plus + "IdeaModule");
    return new TypeReference(_ideaBasePackage, _plus_1);
  }
  
  public TypeReference getFileType(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "FileType");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getAbstractFileType(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = ("Abstract" + _simpleName);
    String _plus_2 = (_plus_1 + "FileType");
    return new TypeReference(_plus, _plus_2);
  }
  
  public TypeReference getFileTypeFactory(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "FileTypeFactory");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getIdeaLanguage(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "Language");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getCodeBlockModificationListener(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang.psi");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "CodeBlockModificationListener");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getElementDescriptionProvider(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang.psi");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "ElementDescriptionProvider");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getPsiParser(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang.parser");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "PsiParser");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getAntlrTokenFileProvider(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang.parser.antlr");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "AntlrTokenFileProvider");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getPomDeclarationSearcher(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang.pom");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "PomDeclarationSearcher");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getSyntaxHighlighterFactory(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".highlighting");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "SyntaxHighlighterFactory");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getSemanticHighlightVisitor(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".highlighting");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "SemanticHighlightVisitor");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getSuperParserDefinition(final Grammar it) {
    return TypeReference.typeRef("org.eclipse.xtext.idea.parser.AbstractXtextParserDefinition");
  }
  
  public TypeReference getParserDefinition(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang.parser");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "ParserDefinition");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getTokenTypeProvider(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang.parser");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "TokenTypeProvider");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getElementTypeProvider(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".lang");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "ElementTypeProvider");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getPsiInternalLexer(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".parser.antlr.internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = ("PsiInternal" + _simpleName);
    String _plus_2 = (_plus_1 + "Lexer");
    return new TypeReference(_plus, _plus_2);
  }
  
  public TypeReference getPsiInternalParser(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".parser.antlr.internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = ("PsiInternal" + _simpleName);
    String _plus_2 = (_plus_1 + "Parser");
    return new TypeReference(_plus, _plus_2);
  }
  
  public String getTokens(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".parser.antlr.internal.PsiInternal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_plus + _simpleName);
    String _path = this.toPath(_plus_1);
    return (_path + ".tokens");
  }
  
  public TypeReference getFileImpl(final Grammar it) {
    String _psiImplPackageName = this.getPsiImplPackageName(it);
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus = (_simpleName + "FileImpl");
    return new TypeReference(_psiImplPackageName, _plus);
  }
  
  public String getPsiPackageName(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    return (_ideaBasePackage + ".lang.psi");
  }
  
  public String getPsiImplPackageName(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    return (_ideaBasePackage + ".lang.psi.impl");
  }
  
  public TypeReference getInternalParser(final Grammar it) {
    String _namespace = GrammarUtil.getNamespace(it);
    String _plus = (_namespace + ".parser.antlr.internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = ("Internal" + _simpleName);
    String _plus_2 = (_plus_1 + "Parser");
    return new TypeReference(_plus, _plus_2);
  }
  
  public TypeReference getAntlrLexer(final Grammar it) {
    String _namespace = GrammarUtil.getNamespace(it);
    String _plus = (_namespace + ".parser.antlr.internal");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = ("Internal" + _simpleName);
    String _plus_2 = (_plus_1 + "Lexer");
    return new TypeReference(_plus, _plus_2);
  }
  
  public TypeReference getCompletionContributorSuperClass(final Grammar it) {
    TypeReference _elvis = null;
    EList<Grammar> _usedGrammars = it.getUsedGrammars();
    Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
    TypeReference _completionContributor = null;
    if (_head!=null) {
      _completionContributor=this.getCompletionContributor(_head);
    }
    if (_completionContributor != null) {
      _elvis = _completionContributor;
    } else {
      TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.completion.AbstractCompletionContributor");
      _elvis = _typeRef;
    }
    return _elvis;
  }
  
  public TypeReference getCompletionContributor(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".completion");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "CompletionContributor");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getAbstractCompletionContributor(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".completion");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = ("Abstract" + _simpleName);
    String _plus_2 = (_plus_1 + "CompletionContributor");
    return new TypeReference(_plus, _plus_2);
  }
  
  public TypeReference getFacetConfiguration(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".facet");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "FacetConfiguration");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference getFacetType(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".facet");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "FacetType");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference baseColorSettingsPage(final Grammar it) {
    String _ideaBasePackage = this._xtextGeneratorNaming.getIdeaBasePackage(it);
    String _plus = (_ideaBasePackage + ".highlighting");
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus_1 = (_simpleName + "BaseColorSettingsPage");
    return new TypeReference(_plus, _plus_1);
  }
  
  public TypeReference colorSettingsPage(final Grammar it) {
    TypeReference _baseColorSettingsPage = this.baseColorSettingsPage(it);
    String _packageName = _baseColorSettingsPage.getPackageName();
    String _simpleName = GrammarUtil.getSimpleName(it);
    String _plus = (_simpleName + "ColorSettingsPage");
    return new TypeReference(_packageName, _plus);
  }
}
