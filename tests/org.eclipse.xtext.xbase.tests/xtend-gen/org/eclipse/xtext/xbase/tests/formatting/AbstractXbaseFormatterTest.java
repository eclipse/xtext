package org.eclipse.xtext.xbase.tests.formatting;

import javax.inject.Inject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues;
import org.eclipse.xtext.xbase.formatting.XbaseFormatterConfigKeys;
import org.eclipse.xtext.xbase.junit.formatter.AssertingFormatterData;
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.formatting.XbaseFormatterTestInjectorProvider;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseFormatterTestInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractXbaseFormatterTest {
  @Inject
  private FormatterTester tester;
  
  @Inject
  private XbaseFormatterConfigKeys keys;
  
  public void assertFormatted(final CharSequence toBeFormatted) {
    this.assertFormatted(toBeFormatted, toBeFormatted);
  }
  
  public void assertFormattedExpression(final Procedure1<? super MapBasedConfigurationValues> cfg, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(cfg, toBeFormatted, toBeFormatted);
  }
  
  public void assertFormattedExpression(final CharSequence toBeFormatted) {
    this.assertFormattedExpression(null, toBeFormatted, toBeFormatted);
  }
  
  public void assertFormattedExpression(final String expectation, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(null, expectation, toBeFormatted);
  }
  
  public void assertFormattedExpression(final Procedure1<? super MapBasedConfigurationValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(cfg, expectation, toBeFormatted, false);
  }
  
  public void assertFormattedExpression(final Procedure1<? super MapBasedConfigurationValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted, final boolean allowErrors) {
    String _string = expectation.toString();
    String _trim = _string.trim();
    String _replace = _trim.replace("\n", "\n\t");
    String _string_1 = toBeFormatted.toString();
    String _trim_1 = _string_1.trim();
    String _replace_1 = _trim_1.replace("\n", "\n\t");
    this.assertFormatted(cfg, _replace, _replace_1, 
      "{\n\t", 
      "\n}", allowErrors);
  }
  
  public void assertFormatted(final Procedure1<? super MapBasedConfigurationValues> cfg, final CharSequence expectation) {
    this.assertFormatted(cfg, expectation, expectation);
  }
  
  public void assertFormatted(final CharSequence expectation, final CharSequence toBeFormatted) {
    this.assertFormatted(null, expectation, toBeFormatted);
  }
  
  public void assertFormatted(final Procedure1<? super MapBasedConfigurationValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted) {
    this.assertFormatted(cfg, expectation, toBeFormatted, "", "", false);
  }
  
  public void assertFormatted(final Procedure1<? super MapBasedConfigurationValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted, final String prefix, final String postfix, final boolean allowErrors) {
    final Procedure1<AssertingFormatterData> _function = new Procedure1<AssertingFormatterData>() {
        public void apply(final AssertingFormatterData it) {
          MapBasedConfigurationValues _cfg = it.getCfg();
          AbstractXbaseFormatterTest.this.initConfig(_cfg, cfg);
          it.setExpectation(expectation);
          it.setToBeFormatted(toBeFormatted);
          it.setPrefix(prefix);
          it.setPostfix(postfix);
          it.setAllowErrors(allowErrors);
        }
      };
    this.tester.assertFormatted(_function);
  }
  
  public void initConfig(final MapBasedConfigurationValues target, final Procedure1<? super MapBasedConfigurationValues> cfg) {
    target.<Integer>put(this.keys.maxLineWidth, Integer.valueOf(80));
    boolean _notEquals = ObjectExtensions.operator_notEquals(cfg, null);
    if (_notEquals) {
      cfg.apply(target);
    }
  }
}
