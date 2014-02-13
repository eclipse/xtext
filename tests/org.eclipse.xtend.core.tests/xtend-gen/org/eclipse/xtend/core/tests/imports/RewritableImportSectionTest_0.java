package org.eclipse.xtend.core.tests.imports;

import org.eclipse.xtend.core.tests.imports.AbstractRewritableImportSectionTest;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class RewritableImportSectionTest_0 extends AbstractRewritableImportSectionTest {
  protected CharSequence getModel(final Class<?>[] types) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    {
      for(final Class<?> type : types) {
        _builder.append("import ");
        String _canonicalName = type.getCanonicalName();
        _builder.append(_canonicalName, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence getExpectedModel(final String sectionAsString) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(sectionAsString, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }
}
