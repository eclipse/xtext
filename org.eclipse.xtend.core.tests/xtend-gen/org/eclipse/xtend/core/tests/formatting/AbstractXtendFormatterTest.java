/**
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import java.util.Collection;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractXtendFormatterTest extends AbstractFormatterTest {
  protected String decode(final CharSequence seq) {
    return seq.toString().replace("<<", "«").replace(">>", "»").replace("```", "\'\'\'");
  }

  protected void assertFormattedExpression(final CharSequence toBeFormatted) {
    this.assertFormattedExpression(null, toBeFormatted, toBeFormatted);
  }

  protected void assertFormattedExpression(final String expectation, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(null, expectation, toBeFormatted);
  }

  protected void assertFormattedExpression(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted) {
    this.assertFormattedExpression(cfg, expectation, toBeFormatted, false);
  }

  protected void assertFormattedRichStringExpression(final CharSequence seq) {
    this.assertFormattedExpression(this.decode(seq));
  }

  protected void assertFormattedRichStringExpression(final CharSequence expected, final CharSequence actual) {
    this.assertFormattedExpression(this.decode(expected), this.decode(actual));
  }

  protected void assertFormattedRichStringExpressionWithErrors(final CharSequence actual) {
    this.assertFormattedExpression(null, this.decode(actual), this.decode(actual), true);
  }

  private void assertFormattedExpression(final Procedure1<? super MapBasedPreferenceValues> cfg, final CharSequence expectation, final CharSequence toBeFormatted, final boolean allowErrors) {
    final String prefix = "class bar {\n\tdef baz() {\n\t\t";
    final String postfix = "\n\t}\n}";
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        if (cfg!=null) {
          cfg.apply(it_1);
        }
      };
      it.preferences(_function_1);
      String _replace = expectation.toString().trim().replace("\n", "\n\t\t");
      String _plus = (prefix + _replace);
      String _plus_1 = (_plus + postfix);
      it.setExpectation(_plus_1);
      String _replace_1 = toBeFormatted.toString().trim().replace("\n", "\n\t\t");
      String _plus_2 = (prefix + _replace_1);
      String _plus_3 = (_plus_2 + postfix);
      it.setToBeFormatted(_plus_3);
      Collection<ITextRegion> _regions = it.getRequest().getRegions();
      int _length = prefix.length();
      int _length_1 = toBeFormatted.toString().trim().replace("\n", "\n\t\t").length();
      TextRegion _textRegion = new TextRegion(_length, _length_1);
      _regions.add(_textRegion);
      it.setAllowSyntaxErrors(allowErrors);
    };
    this.formatterTestHelper.assertFormatted(_function);
  }
}
