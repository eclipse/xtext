/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.xtend.ide.codebuilder.AbstractInterfaceBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class InterfaceBuilderTest extends AbstractBuilderTest {
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;

  @Test
  public void testXtendInterface() {
    AbstractInterfaceBuilder _createInterfaceBuilder = this._codeBuilderFactory.createInterfaceBuilder(this.getXtendClass());
    final Procedure1<AbstractInterfaceBuilder> _function = (AbstractInterfaceBuilder it) -> {
      it.setContext(this.getXtendClass());
      it.setInterfaceName("Bar");
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractInterfaceBuilder _doubleArrow = ObjectExtensions.<AbstractInterfaceBuilder>operator_doubleArrow(_createInterfaceBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }

  @Test
  public void testJavaClass() {
    AbstractInterfaceBuilder _createInterfaceBuilder = this._codeBuilderFactory.createInterfaceBuilder(this.getJavaClass());
    final Procedure1<AbstractInterfaceBuilder> _function = (AbstractInterfaceBuilder it) -> {
      it.setContext(this.getJavaClass());
      it.setInterfaceName("Bar");
      it.setVisibility(JvmVisibility.PUBLIC);
    };
    AbstractInterfaceBuilder _doubleArrow = ObjectExtensions.<AbstractInterfaceBuilder>operator_doubleArrow(_createInterfaceBuilder, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public interface Bar {");
    _builder.newLine();
    _builder.append("}");
    this.assertBuilds(_doubleArrow, _builder.toString());
  }
}
