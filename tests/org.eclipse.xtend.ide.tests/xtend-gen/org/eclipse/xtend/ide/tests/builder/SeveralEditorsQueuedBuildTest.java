/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.builder;

import java.util.Collection;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtend.ide.tests.builder.AbstractQueuedBuildDataTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
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
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas);
      Collection<Delta> _andRemovePendingDeltas = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas);
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_1 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_1);
      Collection<Delta> _andRemovePendingDeltas_1 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_1);
      this._javaEditorExtension.save(barEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_2 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreDeltas(_unconfirmedDeltas_2, "mypackage.Bar");
      Collection<Delta> _andRemovePendingDeltas_2 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_2);
      this.confirmDeltas();
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_3 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_3);
      Collection<Delta> _andRemovePendingDeltas_3 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreDeltas(_andRemovePendingDeltas_3, "mypackage.Bar");
      this._javaEditorExtension.save(fooEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_4 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreDeltas(_unconfirmedDeltas_4, "mypackage.Foo");
      Collection<Delta> _andRemovePendingDeltas_4 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_4);
      this.confirmDeltas();
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_5 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_5);
      Collection<Delta> _andRemovePendingDeltas_5 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreDeltas(_andRemovePendingDeltas_5, "mypackage.Foo");
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
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas);
      Collection<Delta> _andRemovePendingDeltas = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas);
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_1 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_1);
      Collection<Delta> _andRemovePendingDeltas_1 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_1);
      this._javaEditorExtension.close(fooEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_2 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_2);
      Collection<Delta> _andRemovePendingDeltas_2 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_2);
      this._javaEditorExtension.save(barEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_3 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreDeltas(_unconfirmedDeltas_3, "mypackage.Bar");
      Collection<Delta> _andRemovePendingDeltas_3 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_3);
      this.confirmDeltas();
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_4 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_4);
      Collection<Delta> _andRemovePendingDeltas_4 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreDeltas(_andRemovePendingDeltas_4, "mypackage.Bar");
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
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas);
      Collection<Delta> _andRemovePendingDeltas = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas);
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_1 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_1);
      Collection<Delta> _andRemovePendingDeltas_1 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_1);
      this._javaEditorExtension.reconcile(fooEditor, "foo2", "foo");
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_2 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_2);
      Collection<Delta> _andRemovePendingDeltas_2 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_2);
      this._javaEditorExtension.close(fooEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_3 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_3);
      Collection<Delta> _andRemovePendingDeltas_3 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_3);
      this._javaEditorExtension.save(barEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_4 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreDeltas(_unconfirmedDeltas_4, "mypackage.Bar");
      Collection<Delta> _andRemovePendingDeltas_4 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_4);
      this.confirmDeltas();
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_5 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_5);
      Collection<Delta> _andRemovePendingDeltas_5 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreDeltas(_andRemovePendingDeltas_5, "mypackage.Bar");
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
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas);
      Collection<Delta> _andRemovePendingDeltas = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas);
      final ITextEditor barEditor = this._javaEditorExtension.reconcile("/mypackage/Bar.java", "bar", "bar2");
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_1 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_1);
      Collection<Delta> _andRemovePendingDeltas_1 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_1);
      this._javaEditorExtension.reconcile(fooEditor, "foo2", "foo");
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_2 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_2);
      Collection<Delta> _andRemovePendingDeltas_2 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_2);
      this._javaEditorExtension.save(fooEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_3 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreDeltas(_unconfirmedDeltas_3, "mypackage.Foo");
      Collection<Delta> _andRemovePendingDeltas_3 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_3);
      this.confirmDeltas();
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_4 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_4);
      Collection<Delta> _andRemovePendingDeltas_4 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_4);
      this._javaEditorExtension.save(barEditor);
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_5 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreDeltas(_unconfirmedDeltas_5, "mypackage.Bar");
      Collection<Delta> _andRemovePendingDeltas_5 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreNotDeltas(_andRemovePendingDeltas_5);
      this.confirmDeltas();
      Collection<UnconfirmedStructuralChangesDelta> _unconfirmedDeltas_6 = this.queuedBuildData.getUnconfirmedDeltas();
      this.assertThereAreNotDeltas(_unconfirmedDeltas_6);
      Collection<Delta> _andRemovePendingDeltas_6 = this.queuedBuildData.getAndRemovePendingDeltas();
      this.assertThereAreDeltas(_andRemovePendingDeltas_6, "mypackage.Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
