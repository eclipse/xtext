package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.tests.xjm.Contribution1;
import org.eclipse.xtend2.lib.StringConcatenation;

@XpectImport(Contribution1.class)
@SuppressWarnings("all")
public class Simple1 {
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("suite org.xpect.tests.xjm.Simple1 {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("test org.xpect.tests.xjm.Simple1 {} // Imports: Contribution1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contributionsFor @XpectSetupFactory {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.xjm.Contribution1 ImportedBy:Simple1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
