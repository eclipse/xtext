package org.eclipse.xpect.tests.xjm;

import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.tests.xjm.AnnotationWithImport;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class AnnotationType {
  @Xpect
  public void test(@AnnotationWithImport final String arg0) {
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("suite org.xpect.tests.xjm.AnnotationType {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("test org.xpect.tests.xjm.AnnotationType {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Xpect public void test(); // Imports: Contribution1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contributionsFor @XpectSetupFactory {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("org.xpect.tests.xjm.Contribution1 ImportedBy:AnnotationType.test()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
