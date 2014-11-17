package org.eclipse.xtext.idea.parser;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.idea.parser.PsiXtextTokenStream;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractXtextPsiParser implements PsiParser {
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private ITokenDefProvider tokenDefProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private TokenTypeProvider tokenTypeProvider;
  
  public ASTNode parse(final IElementType root, final PsiBuilder builder) {
    try {
      ASTNode _xblockexpression = null;
      {
        builder.setDebugMode(true);
        PsiBuilder.Marker rootMarker = builder.mark();
        PsiXtextTokenStream _createTokenStream = this.createTokenStream(builder);
        AbstractPsiAntlrParser _createParser = this.createParser(builder, _createTokenStream);
        final Procedure1<AbstractPsiAntlrParser> _function = new Procedure1<AbstractPsiAntlrParser>() {
          public void apply(final AbstractPsiAntlrParser it) {
            Map<Integer, String> _tokenDefMap = AbstractXtextPsiParser.this.tokenDefProvider.getTokenDefMap();
            it.setTokenTypeMap(_tokenDefMap);
          }
        };
        final AbstractPsiAntlrParser parser = ObjectExtensions.<AbstractPsiAntlrParser>operator_doubleArrow(_createParser, _function);
        parser.parse();
        rootMarker.done(root);
        _xblockexpression = builder.getTreeBuilt();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected abstract AbstractPsiAntlrParser createParser(final PsiBuilder builder, final TokenStream tokenStream);
  
  protected PsiXtextTokenStream createTokenStream(final PsiBuilder builder) {
    PsiXtextTokenStream _xblockexpression = null;
    {
      final TokenSource tokenSource = this.createTokenSource(builder);
      PsiXtextTokenStream _psiXtextTokenStream = new PsiXtextTokenStream(builder, tokenSource, this.tokenDefProvider);
      final Procedure1<PsiXtextTokenStream> _function = new Procedure1<PsiXtextTokenStream>() {
        public void apply(final PsiXtextTokenStream it) {
          HashSet<String> _initialHiddenTokens = AbstractXtextPsiParser.this.getInitialHiddenTokens();
          it.setInitialHiddenTokens(((String[])Conversions.unwrapArray(_initialHiddenTokens, String.class)));
        }
      };
      _xblockexpression = ObjectExtensions.<PsiXtextTokenStream>operator_doubleArrow(_psiXtextTokenStream, _function);
    }
    return _xblockexpression;
  }
  
  protected abstract TokenSource createTokenSource(final PsiBuilder builder);
  
  protected HashSet<String> getInitialHiddenTokens() {
    HashSet<String> _xblockexpression = null;
    {
      HashSet<String> hiddenTokens = CollectionLiterals.<String>newHashSet();
      TokenSet _whitespaceTokens = this.tokenTypeProvider.getWhitespaceTokens();
      IElementType[] _types = _whitespaceTokens.getTypes();
      final Function1<IElementType, String> _function = new Function1<IElementType, String>() {
        public String apply(final IElementType it) {
          return it.toString();
        }
      };
      List<String> _map = ListExtensions.<IElementType, String>map(((List<IElementType>)Conversions.doWrapArray(_types)), _function);
      Iterables.<String>addAll(hiddenTokens, _map);
      TokenSet _commentTokens = this.tokenTypeProvider.getCommentTokens();
      IElementType[] _types_1 = _commentTokens.getTypes();
      final Function1<IElementType, String> _function_1 = new Function1<IElementType, String>() {
        public String apply(final IElementType it) {
          return it.toString();
        }
      };
      List<String> _map_1 = ListExtensions.<IElementType, String>map(((List<IElementType>)Conversions.doWrapArray(_types_1)), _function_1);
      Iterables.<String>addAll(hiddenTokens, _map_1);
      _xblockexpression = hiddenTokens;
    }
    return _xblockexpression;
  }
  
  @Pure
  protected ITokenDefProvider getTokenDefProvider() {
    return this.tokenDefProvider;
  }
  
  @Pure
  protected TokenTypeProvider getTokenTypeProvider() {
    return this.tokenTypeProvider;
  }
}
