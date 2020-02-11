/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.ReferenceTestConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReferenceTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testReferences_01() {
    final Procedure1<ReferenceTestConfiguration> _function = (ReferenceTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setColumn("type F".length());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[2, 1] .. [2, 4]]");
      _builder_1.newLine();
      it.setExpectedReferences(_builder_1.toString());
    };
    this.testReferences(_function);
  }
  
  @Test
  public void testReferences_02() {
    final Procedure1<ReferenceTestConfiguration> _function = (ReferenceTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setColumn("type F".length());
      it.setIncludeDeclaration(true);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      _builder_1.append("MyModel.testlang [[2, 1] .. [2, 4]]");
      _builder_1.newLine();
      it.setExpectedReferences(_builder_1.toString());
    };
    this.testReferences(_function);
  }
  
  @Test
  public void testReferences_03_acrossFiles() {
    final Procedure1<ReferenceTestConfiguration> _function = (ReferenceTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("foo.testlang", _builder.toString());
      it.setFilesInScope(Collections.<String, CharSequence>unmodifiableMap(CollectionLiterals.<String, CharSequence>newHashMap(_mappedTo)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Bar {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Foo foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setModel(_builder_1.toString());
      it.setLine(1);
      it.setColumn(6);
      it.setIncludeDeclaration(true);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("foo.testlang [[0, 5] .. [0, 8]]");
      _builder_2.newLine();
      _builder_2.append("MyModel.testlang [[1, 4] .. [1, 7]]");
      _builder_2.newLine();
      it.setExpectedReferences(_builder_2.toString());
    };
    this.testReferences(_function);
  }
}
