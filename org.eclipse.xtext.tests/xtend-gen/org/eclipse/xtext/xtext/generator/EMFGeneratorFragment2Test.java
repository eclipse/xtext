/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class EMFGeneratorFragment2Test {
  @Extension
  private final EMFGeneratorFragment2 _eMFGeneratorFragment2 = new EMFGeneratorFragment2();
  
  @Test
  public void testTrimMultiLineString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*foo*/");
    _builder.newLine();
    this.assertTrim("foo", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/* ");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* foo*/");
    _builder_1.newLine();
    this.assertTrim("foo", _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("/* ");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append("* ");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append("* foo");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append("*/");
    _builder_2.newLine();
    this.assertTrim("foo", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("multi");
    _builder_3.newLine();
    _builder_3.append("foo");
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("/* ");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("* multi");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("* foo");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("* ");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("*/");
    _builder_4.newLine();
    this.assertTrim(_builder_3.toString(), _builder_4.toString());
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("/* foo */");
    _builder_5.newLine();
    this.assertTrim("foo", _builder_5.toString());
    this.assertTrim("foo", "foo");
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.");
    _builder_6.newLine();
    _builder_6.append("This program and the accompanying materials are made available under the");
    _builder_6.newLine();
    _builder_6.append("terms of the Eclipse Public License 2.0 which is available at");
    _builder_6.newLine();
    _builder_6.append("http://www.eclipse.org/legal/epl-2.0.");
    _builder_6.newLine();
    _builder_6.newLine();
    _builder_6.append("SPDX-License-Identifier: EPL-2.0");
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("/**");
    _builder_7.newLine();
    _builder_7.append(" ");
    _builder_7.append("* Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.");
    _builder_7.newLine();
    _builder_7.append(" ");
    _builder_7.append("* This program and the accompanying materials are made available under the");
    _builder_7.newLine();
    _builder_7.append(" ");
    _builder_7.append("* terms of the Eclipse Public License 2.0 which is available at");
    _builder_7.newLine();
    _builder_7.append(" ");
    _builder_7.append("* http://www.eclipse.org/legal/epl-2.0.");
    _builder_7.newLine();
    _builder_7.append(" ");
    _builder_7.append("* ");
    _builder_7.newLine();
    _builder_7.append(" ");
    _builder_7.append("* SPDX-License-Identifier: EPL-2.0");
    _builder_7.newLine();
    _builder_7.append(" ");
    _builder_7.append("*/");
    this.assertTrim(_builder_6.toString(), _builder_7.toString());
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.");
    _builder_8.newLine();
    _builder_8.append("This program and the accompanying materials are made available under the");
    _builder_8.newLine();
    _builder_8.append("terms of the Eclipse Public License 2.0 which is available at");
    _builder_8.newLine();
    _builder_8.append("http://www.eclipse.org/legal/epl-2.0.");
    _builder_8.newLine();
    _builder_8.newLine();
    _builder_8.append("SPDX-License-Identifier: EPL-2.0");
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("/*******************************************************************************");
    _builder_9.newLine();
    _builder_9.append(" ");
    _builder_9.append("* Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.");
    _builder_9.newLine();
    _builder_9.append(" ");
    _builder_9.append("* This program and the accompanying materials are made available under the");
    _builder_9.newLine();
    _builder_9.append(" ");
    _builder_9.append("* terms of the Eclipse Public License 2.0 which is available at");
    _builder_9.newLine();
    _builder_9.append(" ");
    _builder_9.append("* http://www.eclipse.org/legal/epl-2.0.");
    _builder_9.newLine();
    _builder_9.append(" ");
    _builder_9.append("* ");
    _builder_9.newLine();
    _builder_9.append(" ");
    _builder_9.append("* SPDX-License-Identifier: EPL-2.0");
    _builder_9.newLine();
    _builder_9.append(" ");
    _builder_9.append("*******************************************************************************/");
    this.assertTrim(_builder_8.toString(), _builder_9.toString());
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.");
    _builder_10.newLine();
    _builder_10.append("This program and the accompanying materials are made available under the");
    _builder_10.newLine();
    _builder_10.append("terms of the Eclipse Public License 2.0 which is available at");
    _builder_10.newLine();
    _builder_10.append("http://www.eclipse.org/legal/epl-2.0.");
    _builder_10.newLine();
    _builder_10.newLine();
    _builder_10.append("SPDX-License-Identifier: EPL-2.0");
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("/*******************************************************************************");
    _builder_11.newLine();
    _builder_11.append(" ");
    _builder_11.append("* Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.");
    _builder_11.newLine();
    _builder_11.append(" ");
    _builder_11.append("* This program and the accompanying materials are made available under the");
    _builder_11.newLine();
    _builder_11.append(" ");
    _builder_11.append("* terms of the Eclipse Public License 2.0 which is available at");
    _builder_11.newLine();
    _builder_11.append(" ");
    _builder_11.append("* http://www.eclipse.org/legal/epl-2.0.");
    _builder_11.newLine();
    _builder_11.append(" ");
    _builder_11.append("*");
    _builder_11.newLine();
    _builder_11.append(" ");
    _builder_11.append("* SPDX-License-Identifier: EPL-2.0");
    _builder_11.newLine();
    _builder_11.append(" ");
    _builder_11.append("*******************************************************************************/");
    this.assertTrim(_builder_10.toString(), _builder_11.toString());
  }
  
  private void assertTrim(final String expected, final String original) {
    Assert.assertEquals(expected, this._eMFGeneratorFragment2.trimMultiLineComment(original));
  }
}
