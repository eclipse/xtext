/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.imports;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class RewritableImportSection2Test extends AbstractRewritableImportSectionTest {
  @Override
  protected boolean isIgnoreLinebreaks() {
    return true;
  }

  @Override
  protected CharSequence getModel(final boolean isStatic, final Class<?>[] types) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
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
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }

  @Override
  protected CharSequence getExpectedModel(final String sectionAsString) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append(sectionAsString);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Foo{}");
    _builder.newLine();
    return _builder;
  }
}
