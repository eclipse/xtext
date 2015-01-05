package org.eclipse.xtext.xbase.idea.tests.parsing;

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest;
import org.junit.Ignore;

@FinalFieldsConstructor
@Ignore("Only here as a delegate")
@SuppressWarnings("all")
public class IdeaXbaseParserTest extends XbaseParserTest {
  private final ModelChecker expresssionChecker;
  
  protected XExpression expression(final CharSequence string) throws Exception {
    String _string = string.toString();
    return this.expresssionChecker.<XExpression>checkModel(_string, false);
  }
  
  protected XExpression expression(final CharSequence string, final boolean resolve) throws Exception {
    String _string = string.toString();
    return this.expresssionChecker.<XExpression>checkModel(_string, resolve);
  }
  
  public IdeaXbaseParserTest(final ModelChecker expresssionChecker) {
    super();
    this.expresssionChecker = expresssionChecker;
  }
}
