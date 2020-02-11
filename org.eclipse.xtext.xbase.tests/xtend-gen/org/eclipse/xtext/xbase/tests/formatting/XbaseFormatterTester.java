/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.formatting;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseFormatterTester extends FormatterTester {
  public void assertFormattedExpression(final Procedure1<? super FormatterTestRequest> test) {
    String _newLine = Strings.newLine();
    final String prefix = ("{" + _newLine);
    String _newLine_1 = Strings.newLine();
    final String postfix = (_newLine_1 + "}");
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      test.apply(it);
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
      };
      it.preferences(_function_1);
      String _indent = this.indent(it.getExpectationOrToBeFormatted().toString().trim(), "\t");
      String _plus = (prefix + _indent);
      String _plus_1 = (_plus + postfix);
      it.setExpectation(_plus_1);
      String _indent_1 = this.indent(it.getToBeFormatted().toString().trim(), "\t");
      String _plus_2 = (prefix + _indent_1);
      String _plus_3 = (_plus_2 + postfix);
      it.setToBeFormatted(_plus_3);
    };
    final Procedure1<? super FormatterTestRequest> setup = _function;
    this.assertFormatted(((Procedure1<FormatterTestRequest>)setup));
  }
  
  protected String indent(final String string, final String indent) {
    final Function1<String, String> _function = (String it) -> {
      String _xifexpression = null;
      boolean _equals = Objects.equal(it, "");
      if (_equals) {
        _xifexpression = it;
      } else {
        _xifexpression = (indent + it);
      }
      return _xifexpression;
    };
    return IterableExtensions.join(ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(string.split("\\r?\\n"))), _function), Strings.newLine());
  }
}
