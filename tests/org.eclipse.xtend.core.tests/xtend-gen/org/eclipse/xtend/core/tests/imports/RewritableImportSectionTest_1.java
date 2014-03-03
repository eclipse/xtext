package org.eclipse.xtend.core.tests.imports;

import java.util.List;
import org.eclipse.xtend.core.tests.imports.AbstractRewritableImportSectionTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class RewritableImportSectionTest_1 extends AbstractRewritableImportSectionTest {
  protected CharSequence getModel(final Class<? extends Object>[] types) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = ((List<Class<? extends Object>>)Conversions.doWrapArray(types)).size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        {
          for(final Class<?> type : types) {
            _builder.append("import ");
            String _canonicalName = type.getCanonicalName();
            _builder.append(_canonicalName, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
      }
    }
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence getExpectedModel(final String sectionAsString) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(sectionAsString, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }
}
