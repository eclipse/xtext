package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendRichStringFormatterTest extends AbstractFormatterTest {
  @Ignore
  @Test
  public void testIf1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo");
    _builder.newLine();
    {
      if (true) {
        _builder.append("\t");
        _builder.append("bar");
        _builder.newLine();
      }
    }
    final CharSequence x = _builder;
    this.assertFormattedExpression(
      "\'\'\'\nfoo\n    \u00ABIF true\u00BB\n        bar\n    \u00ABENDIF\u00BB\n\'\'\'");
  }
}
