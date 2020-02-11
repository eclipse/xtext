/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ErrorTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private Oven _oven;
  
  @Test
  public void testErrorModel_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ewArrayList(\'\').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ].head");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else  Integer(\'20\')).map(v|v.intValue)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list.head");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else  Integer(\'20\')).map(v|v.compareTo(null))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list.head");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else  Integer(\'20\'))");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else  Integer(\'20\')).map(v|v.intValue)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = org::eclipse::xtext::xbase::lib::ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else  Integer(\'20\'))) [ v|v.intValue ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_07() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else n");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_08() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else ne");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_09() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else n");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_10() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else ne");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_11() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else new I");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_12() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else new In");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_13() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else new I");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_14() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else n");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_15() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else ew Integer(\'20\')).map(v|v.intValue)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list.head");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_16() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else ew Integer(\'20\')).map(v|v.compareTo(null))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list.head");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_17() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else ew Integer(\'20\'))");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_18() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else ew Integer(\'20\'), new Integer(\'29\'))");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_19() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else ew Integer(\'20\'), new Double(\'29\'))");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_20() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else ew Integer(\'20\'), new Integer(\'29\'), new Double(\'29\'))");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_21() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else ew Integer(\'20\')).map(v|v.intValue)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_22() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else ew Integer(\'20\'))) [ v|v.intValue ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_23() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else newInteger(\'20\')).map(v|v.intValue)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list.head");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_24() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else newInteger(\'20\')).map(v|v.compareTo(null))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list.head");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_25() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(if (true) new Double(\'-20\') else newInteger(\'20\'))");
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_26() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = newArrayList(if (false) new Double(\'-20\') else newInteger(\'20\')).map(v|v.intValue)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_27() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double(\'-20\') else  Integer(\'20\'))) [ v|v.intValue ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = list.head ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_28() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ val Iterable<Object> branch = if (true) [|<Object>newArrayList(terator] else newArrayList(\'a\').toArray }");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_29() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ var java.io.FileFilter filter = (if (true) [return true] else [return");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_30() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ var java.io.FileFilter filter = (if (true) [return ] else [return false])");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_31() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ var java.io.FileFilter filter = (if (true) [return] else [return false])");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_32() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("testdata::OuterClass$InnerClass");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_33() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[testdata.OuterClass$InnerClass");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_34() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("testdata.OuterClass$InnerClass");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_35() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("testdata::OuterClass$InnerClass::SINGLETON");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_36() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("testdata.OuterClass$InnerClass param| param.toUpperCase(\'foo\')].apply(new testdata.OuterClass$InnerClass())");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_37() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("testdata.OuterClass$InnerClass param| param.toUpperCase(\'foo\')].apply(new testdata.OuterClass$InnerClass)");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_38() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("testdata.OuterClass$InnerClass::SINGLETON");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_39() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("ypeof(java.util.Map$Entry)");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_40() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("java.util.Map$Entry");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_41() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org::eclipse::xtext::xbase::lib::ListExtensions::map(newArrayList()) [ it ]");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_42() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new testdata.ClosureClient2([|\'1\'],2\']) [|\'3\'].value");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
}
