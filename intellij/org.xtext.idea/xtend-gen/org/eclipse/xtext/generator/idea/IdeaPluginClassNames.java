package org.eclipse.xtext.generator.idea;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch;
import org.eclipse.xtext.util.Strings;

@SuppressWarnings("all")
public class IdeaPluginClassNames {
  public String toSimpleName(final String name) {
    return Strings.lastToken(name, ".");
  }
  
  public String toPackageName(final String name) {
    return Strings.skipLastToken(name, ".");
  }
  
  public String toJavaPath(final String fullName) {
    String _replace = fullName.replace(".", "/");
    return (_replace + ".java");
  }
  
  public String toXtendPath(final String fullName) {
    String _replace = fullName.replace(".", "/");
    return (_replace + ".xtend");
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
  
  public String getStandaloneSetupIdea(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "StandaloneSetupIdea");
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
  
  public String buildProcessParametersProviderName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".server.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "BuildProcessParametersProvider");
  }
  
  public String getJvmTypesElementFinderName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.types.psi.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "JvmTypesElementFinder");
  }
  
  public String getJvmTypesShortNamesCacheName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.types.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "JvmTypesShortNamesCache");
  }
  
  public String getJvmElementsReferencesSearch(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.types.psi.search.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    String _simpleName_1 = JvmElementsReferencesSearch.class.getSimpleName();
    return (_plus_1 + _simpleName_1);
  }
  
  public String getCodeBlockModificationListenerName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.psi.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "CodeBlockModificationListener");
  }
  
  public String getSyntaxHighlighterName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "SyntaxHighlighter");
  }
  
  public String getSyntaxHighlighterFactoryName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "SyntaxHighlighterFactory");
  }
  
  public String getLexerName(final Grammar it) {
    String _basePackageName = this.getBasePackageName(it);
    String _plus = (_basePackageName + ".lang.parser.");
    String _name = it.getName();
    String _simpleName = this.toSimpleName(_name);
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "Lexer");
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
}
