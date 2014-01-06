package org.eclipse.xtext.xbase.tests.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.junit.formatter.AssertingFormatterData;
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.formatting.XbaseFormatterTestInjectorProvider;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XbaseFormatterTestInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractXbaseFormatterTest {
  @Inject
  private FormatterTester tester;
  
  public void assertFormatted(final CharSequence toBeFormatted) {
    this.assertFormatted(toBeFormatted, toBeFormatted);
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
    String _indent = this.indent(_trim, "\t");
    String _string_1 = toBeFormatted.toString();
    String _trim_1 = _string_1.trim();
    String _indent_1 = this.indent(_trim_1, "\t");
    this.assertFormatted(cfg, _indent, _indent_1, 
      "{\n\t", 
      "\n}", allowErrors);
  }
  
  protected String indent(final String string, final String indent) {
    String[] _split = string.split("\\r?\\n");
    final Function1<String,String> _function = new Function1<String,String>() {
      public String apply(final String it) {
        String _xifexpression = null;
        boolean _equals = Objects.equal(it, "");
        if (_equals) {
          _xifexpression = it;
        } else {
          _xifexpression = (indent + it);
        }
        return _xifexpression;
      }
    };
    List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
    return IterableExtensions.join(_map, "\n");
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
        AbstractXbaseFormatterTest.this.initConfig(_config, cfg);
        it.setExpectation(expectation);
        it.setToBeFormatted(toBeFormatted);
        it.setPrefix(prefix);
        it.setPostfix(postfix);
        it.setAllowErrors(allowErrors);
      }
    };
    this.tester.assertFormatted(_function);
  }
  
  public void initConfig(final MapBasedPreferenceValues target, final Procedure1<? super MapBasedPreferenceValues> cfg) {
    String _id = BasicFormatterPreferenceKeys.maxLineWidth.getId();
    String _string = Integer.valueOf(80).toString();
    target.put(_id, _string);
    boolean _notEquals = (!Objects.equal(cfg, null));
    if (_notEquals) {
      cfg.apply(target);
    }
  }
}
