/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.imports;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class RewritableImportSection1Test extends AbstractRewritableImportSectionTest {
  @Override
  protected CharSequence getModel(final boolean isStatic, final Class<?>[] types) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = ((List<Class<?>>)Conversions.doWrapArray(types)).size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        {
          for(final Class<?> type : types) {
            {
              if (isStatic) {
                _builder.append("import static ");
                String _canonicalName = type.getCanonicalName();
                _builder.append(_canonicalName);
                _builder.append(".*");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("import ");
                String _canonicalName_1 = type.getCanonicalName();
                _builder.append(_canonicalName_1);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.newLine();
      }
    }
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }

  @Override
  protected CharSequence getExpectedModel(final String sectionAsString) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(sectionAsString);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }
}
