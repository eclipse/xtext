/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractFoldingTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class FoldingTest extends AbstractFoldingTest {
  @Test
  public void imports() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>import java.util.List");
    _builder.newLine();
    _builder.append("import java.util.Date<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void package_declaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>package p1 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void package_declarations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>package p1 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>package p2 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void entitiy() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>entity HasAuthor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void operation1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>entity HasAuthor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("author: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("[>[>op getAuthor() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("author");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}<]<]");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void operation2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>entity HasAuthor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("author: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("[>\top getAuthor()");
    _builder.newLine();
    _builder.append("[>\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("author");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}<]<]");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void complex() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>entity Blog {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("title: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("posts: List<Post>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op addPost(Post post) : void {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op getPosts() : List<Post> {}");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>entity HasAuthor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("author: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op getAuthor() { author }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op setAuthor() : void {}");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>entity Post extends HasAuthor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("title: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("content: String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("comments: List<Comment>");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("[>entity Comment extends HasAuthor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("content: String");
    _builder.newLine();
    _builder.append("}<]");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void multi_line_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>/*");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("* Description of the entity E.");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("*/<]");
    _builder.newLine();
    _builder.append("entity E {}");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }

  @Test
  public void java_doc() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[>/**");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("* Documentation of the entity E.");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("*/<]");
    _builder.newLine();
    _builder.append("entity E {}");
    _builder.newLine();
    this.testFoldingRegions(_builder);
  }
}
