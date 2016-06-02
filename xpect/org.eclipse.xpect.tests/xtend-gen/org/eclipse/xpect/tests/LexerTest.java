package org.eclipse.xpect.tests;

import com.google.common.base.Objects;
import com.google.common.io.CharStreams;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.xpect.lexer.XpectRT;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class LexerTest {
  @Test
  public void testSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// XPECT_SETUP foo END_SETUP");
    final String actual = this.lex(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_ANY_OTHER \'/\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \'/\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \' \'");
    _builder_1.newLine();
    _builder_1.append("KEYWORD \'XPECT_SETUP\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'foo\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("KEYWORD \'END_SETUP\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void testX() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("X");
    final String actual = this.lex(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_ANY_OTHER \'X\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void testXP() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("XP");
    final String actual = this.lex(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_ANY_OTHER \'X\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \'P\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void testXPE() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("XPE");
    final String actual = this.lex(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_ANY_OTHER \'X\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \'P\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \'E\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void testXPEC() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("XPEC");
    final String actual = this.lex(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_ANY_OTHER \'X\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \'P\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \'E\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ANY_OTHER \'C\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void testXPECT() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("XPECT");
    final String actual = this.lex(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("KEYWORD \'XPECT\'");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  private String lex(final CharSequence text) {
    final Map<Integer, String> names = this.tokenNames();
    String _string = text.toString();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_string);
    final XpectRT lexer = new XpectRT(_aNTLRStringStream);
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList();
    while (true) {
      {
        final Token token = lexer.nextToken();
        boolean _equals = Objects.equal(token, Token.EOF_TOKEN);
        if (_equals) {
          return IterableExtensions.join(result, "\n");
        }
        Object _elvis = null;
        int _type = token.getType();
        String _get = names.get(Integer.valueOf(_type));
        if (_get != null) {
          _elvis = _get;
        } else {
          int _type_1 = token.getType();
          _elvis = Integer.valueOf(_type_1);
        }
        String _plus = (((Comparable<?>)_elvis) + " \'");
        String _text = token.getText();
        String _plus_1 = (_plus + _text);
        String _plus_2 = (_plus_1 + "\'");
        result.add(_plus_2);
      }
    }
  }
  
  private Map<Integer, String> tokenNames() {
    try {
      LinkedHashMap<Integer, String> _xblockexpression = null;
      {
        final String file = "../org.xpect/src-gen/org/xpect/lexer/XpectRT.tokens";
        final LinkedHashMap<Integer, String> result = CollectionLiterals.<Integer, String>newLinkedHashMap();
        FileReader _fileReader = new FileReader(file);
        List<String> _readLines = CharStreams.readLines(_fileReader);
        for (final String line : _readLines) {
          {
            final String[] s = line.split("=");
            final String name = s[0];
            String _get = s[1];
            int _parseInt = Integer.parseInt(_get);
            String _xifexpression = null;
            boolean _startsWith = name.startsWith("KEYWORD");
            if (_startsWith) {
              _xifexpression = "KEYWORD";
            } else {
              _xifexpression = name;
            }
            result.put(Integer.valueOf(_parseInt), _xifexpression);
          }
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertEquals(final CharSequence expt, final CharSequence act) {
    String _string = expt.toString();
    String _trim = _string.trim();
    String _string_1 = act.toString();
    String _trim_1 = _string_1.trim();
    Assert.assertEquals(_trim, _trim_1);
  }
}
