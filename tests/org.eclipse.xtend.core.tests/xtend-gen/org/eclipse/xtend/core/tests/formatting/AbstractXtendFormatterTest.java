package org.eclipse.xtend.core.tests.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.junit.formatter.AssertingFormatterData;
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractXtendFormatterTest {
  @Inject
  private FormatterTester tester;
  
  public void assertFormatted(final CharSequence toBeFormatted) {
    this.assertFormatted(toBeFormatted, toBeFormatted);
  }
  
  public void put(final MapBasedPreferenceValues basedPreferenceValues, final PreferenceKey key, final Object value) {
    String _id = key.getId();
    String _string = value.toString();
    basedPreferenceValues.put(_id, _string);
  }
  
  private CharSequence toMember(final CharSequence expression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(expression, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public void assertFormattedExpression(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(cfg, toBeFormatted, toBeFormatted);
  }
  
  public void assertFormattedExpression(final CharSequence toBeFormatted) {
    this.assertFormattedExpression(null, toBeFormatted, toBeFormatted);
  }
  
  public void assertFormattedExpression(final String expectation, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(null, expectation, toBeFormatted);
  }
  
  public void assertFormattedExpression(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(cfg, expectation, toBeFormatted, false);
  }
  
  public void assertFormattedExpression(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted, final boolean allowErrors) {
    String _string = expectation.toString();
    String _trim = _string.trim();
    String _replace = _trim.replace("\n", "\n\t\t");
    String _string_1 = toBeFormatted.toString();
    String _trim_1 = _string_1.trim();
    String _replace_1 = _trim_1.replace("\n", "\n\t\t");
    this.assertFormatted(cfg, _replace, _replace_1, 
      "class bar {\n\tdef baz() {\n\t\t", 
      "\n\t}\n}", allowErrors);
  }
  
  public void assertFormattedMember(final String expectation, final CharSequence toBeFormatted) {
    CharSequence _member = this.toMember(expectation);
    CharSequence _member_1 = this.toMember(toBeFormatted);
    this.assertFormatted(_member, _member_1);
  }
  
  public void assertFormattedMember(final Procedure1<? super MapBasedPreferenceValues> cfg, final String expectation, final CharSequence toBeFormatted) {
    CharSequence _member = this.toMember(expectation);
    CharSequence _member_1 = this.toMember(toBeFormatted);
    this.assertFormatted(cfg, _member, _member_1);
  }
  
  public void assertFormattedMember(final Procedure1<? super MapBasedPreferenceValues> cfg, final String expectation) {
    CharSequence _member = this.toMember(expectation);
    CharSequence _member_1 = this.toMember(expectation);
    this.assertFormatted(cfg, _member, _member_1);
  }
  
  public void assertFormattedMember(final String expectation) {
    CharSequence _member = this.toMember(expectation);
    CharSequence _member_1 = this.toMember(expectation);
    this.assertFormatted(_member, _member_1);
  }
  
  public void assertFormatted(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence expectation) {
    this.assertFormatted(cfg, expectation, expectation);
  }
  
  public void assertFormatted(final CharSequence expectation, final CharSequence toBeFormatted) {
    this.assertFormatted(null, expectation, toBeFormatted);
  }
  
  public void assertFormatted(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted) {
    this.assertFormatted(cfg, expectation, toBeFormatted, "", "", false);
  }
  
  public void assertFormatted(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted, final String prefix, final String postfix, final boolean allowErrors) {
    final Procedure1<AssertingFormatterData> _function = new Procedure1<AssertingFormatterData>() {
      public void apply(final AssertingFormatterData it) {
        MapBasedPreferenceValues _config = it.getConfig();
        AbstractXtendFormatterTest.this.put(_config, BasicFormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
        boolean _notEquals = (!Objects.equal(cfg, null));
        if (_notEquals) {
          MapBasedPreferenceValues _config_1 = it.getConfig();
          cfg.apply(_config_1);
        }
        it.setExpectation(expectation);
        it.setToBeFormatted(toBeFormatted);
        it.setPrefix(prefix);
        it.setPostfix(postfix);
        it.setAllowErrors(allowErrors);
      }
    };
    this.tester.assertFormatted(_function);
  }
  
  protected String decode(final CharSequence seq) {
    String _string = seq.toString();
    String _replace = _string.replace("<<", "«");
    String _replace_1 = _replace.replace(">>", "»");
    String _replace_2 = _replace_1.replace("```", "\'\'\'");
    return _replace_2;
  }
  
  public void assertFormattedRichStringExpression(final CharSequence seq) {
    String _decode = this.decode(seq);
    this.assertFormattedExpression(_decode);
  }
  
  public void assertFormattedRichString(final CharSequence seq) {
    String _decode = this.decode(seq);
    this.assertFormatted(_decode);
  }
  
  public void assertFormattedRichStringExpression(final CharSequence expected, final CharSequence actual) {
    String _decode = this.decode(expected);
    String _decode_1 = this.decode(actual);
    this.assertFormattedExpression(_decode, _decode_1);
  }
  
  public void assertFormattedRichStringExpressionWithErrors(final CharSequence actual) {
    String _decode = this.decode(actual);
    String _decode_1 = this.decode(actual);
    this.assertFormattedExpression(null, _decode, _decode_1, true);
  }
}
