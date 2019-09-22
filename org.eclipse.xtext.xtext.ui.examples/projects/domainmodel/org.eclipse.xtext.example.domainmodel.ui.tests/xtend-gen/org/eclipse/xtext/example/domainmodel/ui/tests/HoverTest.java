/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.ui.tests.DomainmodelUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHoverTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class HoverTest extends AbstractHoverTest {
  @Before
  public void setup() {
    try {
      JavaProjectSetupUtil.createJavaProject(this.getProjectName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void hover_over_import_statement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("bar : List<String>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("An ordered collection (also known as a <i>sequence</i>");
    this.hasHoverOver(_builder, "java.util.List", _builder_1.toString());
  }
  
  @Test
  public void hover_over_link_in_javadoc() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link java.util.List}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("entity Foo {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("An ordered collection (also known as a <i>sequence</i>");
    this.hasHoverOver(_builder, "java.util.List", _builder_1.toString());
  }
  
  @Test
  public void hover_over_java_typed_property() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name : Object");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Property name : Object");
    this.hasHoverOver(_builder, "name", _builder_1.toString());
  }
  
  @Test
  public void hover_over_java_type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name : Object");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Class <code>Object</code> is the root of the class hierarchy.");
    this.hasHoverOver(_builder, "Object", _builder_1.toString());
  }
  
  @Test
  public void hover_over_entity_typed_property() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("b : Bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Bar {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Property b : Bar");
    this.hasHoverOver(_builder, "b", _builder_1.toString());
  }
  
  @Test
  public void hover_over_entity_type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("b : Bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Documentation of the entity Bar.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("entity Bar {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Documentation of the entity Bar.");
    this.hasHoverOver(_builder, "Bar", _builder_1.toString());
  }
  
  @Test
  public void hover_over_operation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("b : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op : getB() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("getB() : String");
    this.hasHoverOver(_builder, "getB", _builder_1.toString());
  }
}
