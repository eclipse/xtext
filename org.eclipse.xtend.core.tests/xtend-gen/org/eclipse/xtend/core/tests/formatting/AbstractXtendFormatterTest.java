package org.eclipse.xtend.core.tests.formatting;

import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractXtendFormatterTest {
  @Inject
  protected FormatterTestHelper tester;
  
  public void assertFormatted(final CharSequence toBeFormatted) {
    this.assertFormatted(toBeFormatted, toBeFormatted);
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
    this.assertFormatted(cfg, 
      expectation.toString().trim().replace("\n", "\n\t\t"), 
      toBeFormatted.toString().trim().replace("\n", "\n\t\t"), 
      "class bar {\n\tdef baz() {\n\t\t", 
      "\n\t}\n}", allowErrors);
  }
  
  public void assertFormattedMember(final String expectation, final CharSequence toBeFormatted) {
    this.assertFormatted(this.toMember(expectation), this.toMember(toBeFormatted));
  }
  
  public void assertFormattedMember(final Procedure1<? super MapBasedPreferenceValues> cfg, final String expectation, final CharSequence toBeFormatted) {
    this.assertFormatted(cfg, this.toMember(expectation), this.toMember(toBeFormatted));
  }
  
  public void assertFormattedMember(final Procedure1<? super MapBasedPreferenceValues> cfg, final String expectation) {
    this.assertFormatted(cfg, this.toMember(expectation), this.toMember(expectation));
  }
  
  public void assertFormattedMember(final String expectation) {
    this.assertFormatted(this.toMember(expectation), this.toMember(expectation));
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
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
        it_1.<Boolean>put(XtendFormatterPreferenceKeys.keepOneLineMethods, Boolean.valueOf(false));
        if (cfg!=null) {
          cfg.apply(it_1);
        }
      };
      it.preferences(_function_1);
      it.setExpectation(((prefix + expectation) + postfix));
      it.setToBeFormatted(((prefix + toBeFormatted) + postfix));
      Collection<ITextRegion> _regions = it.getRequest().getRegions();
      int _length = prefix.length();
      int _length_1 = toBeFormatted.length();
      TextRegion _textRegion = new TextRegion(_length, _length_1);
      _regions.add(_textRegion);
      it.setAllowSyntaxErrors(allowErrors);
    };
    this.tester.assertFormatted(_function);
  }
  
  protected String decode(final CharSequence seq) {
    return seq.toString().replace("<<", "«").replace(">>", "»").replace("```", "\'\'\'");
  }
  
  public void assertFormattedRichStringExpression(final CharSequence seq) {
    this.assertFormattedExpression(this.decode(seq));
  }
  
  public void assertFormattedRichString(final CharSequence seq) {
    this.assertFormatted(this.decode(seq));
  }
  
  public void assertFormattedRichStringExpression(final CharSequence expected, final CharSequence actual) {
    this.assertFormattedExpression(this.decode(expected), this.decode(actual));
  }
  
  public void assertFormattedRichStringExpressionWithErrors(final CharSequence actual) {
    this.assertFormattedExpression(null, this.decode(actual), this.decode(actual), true);
  }
}
