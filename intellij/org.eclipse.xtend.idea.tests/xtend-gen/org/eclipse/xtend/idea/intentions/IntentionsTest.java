/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.intentions;

import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.intentions.XtendIntentionsProvider;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class IntentionsTest extends LightXtendTest {
  public void testImplementMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class F<caret>oo implements Comparable<Foo> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo implements Comparable<Foo> {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("override compareTo(Foo t) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("throw new UnsupportedOperationException()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIntentionApplication(XtendIntentionsProvider.InsertXtendMethodsIntentionAction.TEXT, _builder.toString(), _builder_1.toString());
  }
  
  public void testImplementMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void myMethods() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val runnable = new Run<caret>nable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("runnable.run()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void myMethods() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val runnable = new Runnable() {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("override run() {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("throw new UnsupportedOperationException()");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("runnable.run()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertIntentionApplication(XtendIntentionsProvider.InsertXtendMethodsIntentionAction.TEXT, _builder.toString(), _builder_1.toString());
  }
  
  public void testSuperConstructors_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.FileNotFoundException;");
    _builder.newLine();
    _builder.append("import java.io.File;");
    _builder.newLine();
    _builder.append("import java.io.FileDescriptor;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public MyClass(String s) throws FileNotFoundException {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public MyClass(File file) throws FileNotFoundException {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public MyClass(FileDescriptor fileDescriptor) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class F<caret>oo extends mypackage.MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("import java.io.FileNotFoundException");
    _builder_2.newLine();
    _builder_2.append("import java.io.File");
    _builder_2.newLine();
    _builder_2.append("import java.io.FileDescriptor");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("class Foo extends mypackage.MyClass {");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("new (String s) throws FileNotFoundException {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("super(s)");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("new (File file) throws FileNotFoundException {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("super(file)");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("new (FileDescriptor fileDescriptor) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("super(fileDescriptor)");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.assertIntentionApplication(XtendIntentionsProvider.InsertSuperConstructorsIntentionAction.TEXT, _builder_1.toString(), _builder_2.toString());
  }
  
  protected void assertIntentionApplication(final String intentionId, final String source, final String after) {
    final PsiFile file = this.configureByText(source);
    final IntentionAction intention = this.myFixture.findSingleIntention(intentionId);
    CommandProcessor _instance = CommandProcessor.getInstance();
    Project _project = this.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        Application _application = ApplicationManager.getApplication();
        final Runnable _function = new Runnable() {
          @Override
          public void run() {
            Project _project = file.getProject();
            Editor _editor = IntentionsTest.this.getEditor();
            intention.invoke(_project, _editor, file);
            Project _project_1 = IntentionsTest.this.getProject();
            PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project_1);
            _instance.commitAllDocuments();
          }
        };
        _application.runWriteAction(_function);
      }
    };
    _instance.executeCommand(_project, _function, "", "");
    Editor _editor = this.myFixture.getEditor();
    Document _document = _editor.getDocument();
    String _text = _document.getText();
    TestCase.assertEquals(after, _text);
  }
}
