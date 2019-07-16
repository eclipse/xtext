package org.eclipse.xtext.ui.tests.xmleditor;

import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

/**
 * The implementation of the following helper methods is mainly taken from
 * the org.eclipse.xpect.tests.LexerTest class of the Eclipse Xpect project.
 */
@SuppressWarnings("all")
public abstract class AbstractLexerTest {
  @Inject
  @Extension
  private IAntlrTokenFileProvider _iAntlrTokenFileProvider;
  
  protected void assertLexing(final CharSequence modelAsText, final CharSequence expected) {
    final String actual = this.lex(this.lexer(), this._iAntlrTokenFileProvider.getAntlrTokenFile(), modelAsText.toString().trim());
    Assert.assertEquals(expected.toString().trim(), actual.toString().trim());
  }
  
  protected abstract Lexer lexer();
  
  protected String lex(final Lexer lexer, final InputStream tokensStream, final CharSequence text) {
    String _xblockexpression = null;
    {
      InputStreamReader _inputStreamReader = new InputStreamReader(tokensStream);
      final LinkedHashMap<Integer, String> tokenNames = this.tokenNames(_inputStreamReader);
      _xblockexpression = this.lexerResult(lexer, tokenNames, text);
    }
    return _xblockexpression;
  }
  
  private String lexerResult(final Lexer lexer, final Map<Integer, String> tokenNames, final CharSequence text) {
    String _string = text.toString();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_string);
    lexer.setCharStream(_aNTLRStringStream);
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList();
    while (true) {
      {
        final Token token = lexer.nextToken();
        if ((token == Token.EOF_TOKEN)) {
          return IterableExtensions.join(result, System.lineSeparator());
        }
        Object _elvis = null;
        String _get = tokenNames.get(Integer.valueOf(token.getType()));
        if (_get != null) {
          _elvis = _get;
        } else {
          int _type = token.getType();
          _elvis = Integer.valueOf(_type);
        }
        String _plus = (_elvis + " \'");
        String _text = token.getText();
        String _plus_1 = (_plus + _text);
        String _plus_2 = (_plus_1 + "\'");
        result.add(_plus_2);
      }
    }
  }
  
  private LinkedHashMap<Integer, String> tokenNames(final Reader tokensReader) {
    try {
      LinkedHashMap<Integer, String> _xblockexpression = null;
      {
        final LinkedHashMap<Integer, String> result = CollectionLiterals.<Integer, String>newLinkedHashMap();
        final List<String> lines = CharStreams.readLines(tokensReader);
        for (final String line : lines) {
          {
            final String[] s = line.split("=");
            final String name = s[0];
            final int index = Integer.parseInt(s[1]);
            String _xifexpression = null;
            boolean _startsWith = name.startsWith("KEYWORD");
            if (_startsWith) {
              _xifexpression = "KEYWORD";
            } else {
              _xifexpression = name;
            }
            result.put(Integer.valueOf(index), _xifexpression);
          }
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
