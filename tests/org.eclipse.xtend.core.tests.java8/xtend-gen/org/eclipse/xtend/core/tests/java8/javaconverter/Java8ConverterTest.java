/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.javaconverter;

import org.eclipse.xtend.core.tests.javaconverter.JavaConverterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class Java8ConverterTest extends JavaConverterTest {
  @Test
  public void testDiamondOperator() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def List<?> foo(){");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var List<String> x=new ArrayList() ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return new ArrayList() ");
    _builder.newLine();
    _builder.append("}");
    String _string = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public List<?> foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("List<String> x = new ArrayList<>();");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("return new ArrayList<>();");
    _builder_1.newLine();
    _builder_1.append("}");
    String _xtendClassBodyDeclr = this.toXtendClassBodyDeclr(_builder_1);
    Assert.assertEquals(_string, _xtendClassBodyDeclr);
  }
}
