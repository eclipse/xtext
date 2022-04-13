/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.builder;

import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SeveralEditorsQueuedBuildTest extends AbstractQueuedBuildDataTest {
  @Test
  public void saveSeveralEditorsOneByOne() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void bar() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder_1.toString());
      this.reset();
      final ITextEditor fooEditor = this._javaEditorExtension.reconcile("/mypackage/Foo.java", "foo", "foo2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.save(barEditor);
      this.assertThereAreDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas(), "mypackage.Bar");
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this.confirmDeltas();
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreDeltas(this.queuedBuildData.getAndRemovePendingDeltas(), "mypackage.Bar");
      this._javaEditorExtension.save(fooEditor);
      this.assertThereAreDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas(), "mypackage.Foo");
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this.confirmDeltas();
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreDeltas(this.queuedBuildData.getAndRemovePendingDeltas(), "mypackage.Foo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void closeEditorWithChanges() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void bar() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder_1.toString());
      this.reset();
      final ITextEditor fooEditor = this._javaEditorExtension.reconcile("/mypackage/Foo.java", "foo", "foo2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.close(fooEditor);
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.save(barEditor);
      this.assertThereAreDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas(), "mypackage.Bar");
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this.confirmDeltas();
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreDeltas(this.queuedBuildData.getAndRemovePendingDeltas(), "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void undoEditorChangesAndClose() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void bar() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder_1.toString());
      this.reset();
      final ITextEditor fooEditor = this._javaEditorExtension.reconcile("/mypackage/Foo.java", "foo", "foo2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.reconcile(fooEditor, "foo2", "foo");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.close(fooEditor);
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.save(barEditor);
      this.assertThereAreDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas(), "mypackage.Bar");
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this.confirmDeltas();
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreDeltas(this.queuedBuildData.getAndRemovePendingDeltas(), "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void undoEditorChangesAndSave() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.testHelper.createFile("/mypackage/Foo.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypackage;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("public class Bar {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public void bar() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.testHelper.createFile("/mypackage/Bar.java", _builder_1.toString());
      this.reset();
      final ITextEditor fooEditor = this._javaEditorExtension.reconcile("/mypackage/Foo.java", "foo", "foo2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.reconcile(fooEditor, "foo2", "foo");
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.save(fooEditor);
      this.assertThereAreDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas(), "mypackage.Foo");
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this.confirmDeltas();
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this._javaEditorExtension.save(barEditor);
      this.assertThereAreDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas(), "mypackage.Bar");
      this.assertThereAreNotDeltas(this.queuedBuildData.getAndRemovePendingDeltas());
      this.confirmDeltas();
      this.assertThereAreNotDeltas(this.queuedBuildDataContribution.getUnconfirmedDeltas());
      this.assertThereAreDeltas(this.queuedBuildData.getAndRemovePendingDeltas(), "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
