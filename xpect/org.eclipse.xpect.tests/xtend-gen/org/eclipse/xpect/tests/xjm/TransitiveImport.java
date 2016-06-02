package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.tests.xjm.ContributionWithChild;
import org.eclipse.xtend2.lib.StringConcatenation;

@XpectImport(ContributionWithChild.class)
@SuppressWarnings("all")
public class TransitiveImport {
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("suite org.xpect.tests.xjm.TransitiveImport {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("test org.xpect.tests.xjm.TransitiveImport {} // Imports: ContributionWithChild, Contribution1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contributionsFor @XpectSetupFactory {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.xjm.Contribution1 ImportedBy:ContributionWithChild");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.xjm.ContributionWithChild ImportedBy:TransitiveImport");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
