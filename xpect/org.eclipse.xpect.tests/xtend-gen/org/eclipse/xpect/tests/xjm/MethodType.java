package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.tests.xjm.ContributionWithChild;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MethodType {
  @Xpect
  public void test(final ContributionWithChild arg0) {
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("suite org.xpect.tests.xjm.MethodType {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("test org.xpect.tests.xjm.MethodType {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Xpect public void test(); // Imports: ContributionWithChild, Contribution1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contributionsFor @XpectSetupFactory {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.xjm.Contribution1 ImportedBy:ContributionWithChild");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.xjm.ContributionWithChild ImportedBy:MethodType.test()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
