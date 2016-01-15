package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.tests.xjm.Contribution1Replacement;
import org.eclipse.xtend2.lib.StringConcatenation;

@XpectImport({ Contribution1Replacement.class })
@SuppressWarnings("all")
public class Replacement2 {
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("suite org.xpect.tests.xjm.Replacement2 {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("test org.xpect.tests.xjm.Replacement2 {} // Imports: Contribution1Replacement, Contribution1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contributionsFor @XpectSetupFactory {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("[INACTIVE] org.xpect.tests.xjm.Contribution1 InactiveBecause: ReplacedBy: org.xpect.tests.xjm.Contribution1Replacement ImportedBy:Contribution1Replacement");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.xjm.Contribution1Replacement ImportedBy:Replacement2");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
