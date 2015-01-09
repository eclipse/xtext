package org.eclipse.xtext.idea.sdomain.idea.tests.issues;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.tests.LightToolingTest;

@SuppressWarnings("all")
public class IssueAnnotatorTest extends LightToolingTest {
  public IssueAnnotatorTest() {
    super(SDomainFileType.INSTANCE);
  }
  
  public void testErrorsAndWarnings() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity <warning descr=\"Name should start with a capital\">foo</warning> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<error descr=\"Couldn\'t resolve reference to Type \'Bar\'.\">Bar</error> bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    this.myFixture.checkHighlighting();
  }
  
  public void testNoDuplicateSyntaxErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{}<EOLError descr=\"missing EOF at \'{\'\"></EOLError>");
    this.configureByText(_builder.toString());
    this.myFixture.checkHighlighting();
  }
}
