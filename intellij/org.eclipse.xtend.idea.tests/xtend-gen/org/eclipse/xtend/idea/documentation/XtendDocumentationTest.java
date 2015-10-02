/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.documentation;

import com.intellij.codeInsight.documentation.DocumentationManager;
import com.intellij.lang.documentation.DocumentationProvider;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.testFramework.PlatformTestCase;
import com.intellij.testFramework.PsiTestCase;
import com.intellij.testFramework.PsiTestUtil;
import java.io.File;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author kosyakov - Initial contribution and API
 * @author moritz.eysholdt@itemis.de
 */
@SuppressWarnings("all")
public class XtendDocumentationTest extends PsiTestCase {
  private VirtualFile src;
  
  private VirtualFile xtendgen;
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    Application _application = ApplicationManager.getApplication();
    final Procedure1<Object> _function = new Procedure1<Object>() {
      @Override
      public void apply(final Object it) {
        try {
          String _testName = XtendDocumentationTest.this.getTestName(true);
          final File myTempDirectory = FileUtil.createTempDirectory(_testName, "test", false);
          PlatformTestCase.myFilesToDelete.add(myTempDirectory);
          LocalFileSystem _instance = LocalFileSystem.getInstance();
          final VirtualFile root = _instance.refreshAndFindFileByIoFile(myTempDirectory);
          VirtualFile _createDirectoryIfMissing = VfsUtil.createDirectoryIfMissing(root, "src");
          XtendDocumentationTest.this.src = _createDirectoryIfMissing;
          VirtualFile _createDirectoryIfMissing_1 = VfsUtil.createDirectoryIfMissing(root, "xtend-gen");
          XtendDocumentationTest.this.xtendgen = _createDirectoryIfMissing_1;
          Module _createModule = XtendDocumentationTest.this.createModule("myModule");
          XtendDocumentationTest.this.myModule = _createModule;
          Module _module = XtendDocumentationTest.this.getModule();
          String _iD = XtendLanguage.INSTANCE.getID();
          LightToolingTest.addFacetToModule(_module, _iD);
          PsiTestUtil.addContentRoot(XtendDocumentationTest.this.myModule, root);
          PsiTestUtil.addSourceRoot(XtendDocumentationTest.this.myModule, XtendDocumentationTest.this.src);
          PsiTestUtil.addSourceRoot(XtendDocumentationTest.this.myModule, XtendDocumentationTest.this.xtendgen);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runWriteAction(
      ((Runnable) new Runnable() {
          public void run() {
            _function.apply(null);
          }
      }));
  }
  
  public void testJavaClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* mydocumentation");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.createFile(this.src, "Foo.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar extends F<caret>oo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiReference xtend = this.createReferenceByFileWithMarker(this.src, "Bar.xtend", _builder_1.toString());
    final String expected = this.generateDocumentation(xtend);
    boolean _contains = expected.contains("mydocumentation");
    TestCase.assertTrue(_contains);
  }
  
  public void testXtendClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* mydocumentation");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.createFile(this.src, "Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar extends F<caret>oo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiReference xtend = this.createReferenceByFileWithMarker(this.src, "Bar.xtend", _builder_1.toString());
    final String expected = this.generateDocumentation(xtend);
    boolean _contains = expected.contains("mydocumentation");
    TestCase.assertTrue(_contains);
  }
  
  public void testXtendField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* mydocumentation");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public val String myfoo = \"x\"");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.createFile(this.src, "Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val String x = new Foo().my<caret>foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiReference xtend = this.createReferenceByFileWithMarker(this.src, "Bar.xtend", _builder_1.toString());
    final String expected = this.generateDocumentation(xtend);
    boolean _contains = expected.contains("<b>myfoo = &quot;x&quot;</b>");
    TestCase.assertTrue(_contains);
    boolean _contains_1 = expected.contains("mydocumentation");
    TestCase.assertTrue(_contains_1);
  }
  
  public void testXtendMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* mydocumentation");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def myfoo() { \"x\" }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.createFile(this.src, "Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val String x = new Foo().my<caret>foo()");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiReference xtend = this.createReferenceByFileWithMarker(this.src, "Bar.xtend", _builder_1.toString());
    final String expected = this.generateDocumentation(xtend);
    boolean _contains = expected.contains("<b>myfoo</b>()");
    TestCase.assertTrue(_contains);
    boolean _contains_1 = expected.contains("mydocumentation");
    TestCase.assertTrue(_contains_1);
  }
  
  public void testXtendConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* mydocumentation");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.createFile(this.src, "Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val String x = new F<caret>oo()");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiReference xtend = this.createReferenceByFileWithMarker(this.src, "Bar.xtend", _builder_1.toString());
    final String expected = this.generateDocumentation(xtend);
    boolean _contains = expected.contains("<b>Foo</b>()");
    TestCase.assertTrue(_contains);
    boolean _contains_1 = expected.contains("mydocumentation");
    TestCase.assertTrue(_contains_1);
  }
  
  protected PsiFile createFile(final VirtualFile dir, final String fileName, final String contents) {
    try {
      return this.createFile(this.myModule, dir, fileName, contents);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected PsiReference createReferenceByFileWithMarker(final VirtualFile dir, final String fileName, final String contents) {
    try {
      final String caret = "<caret>";
      final int index = contents.indexOf(caret);
      String _substring = contents.substring(0, index);
      int _length = caret.length();
      int _plus = (index + _length);
      int _length_1 = contents.length();
      String _substring_1 = contents.substring(_plus, _length_1);
      final String document = (_substring + _substring_1);
      final PsiFile file = this.createFile(this.myModule, dir, fileName, document);
      return file.findReferenceAt(index);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String generateDocumentation(final PsiReference reference) {
    String _xblockexpression = null;
    {
      final PsiElement originalElement = reference.getElement();
      final PsiElement element = reference.resolve();
      TestCase.assertNotNull(originalElement);
      TestCase.assertNotNull(element);
      _xblockexpression = this.generateDocumentation(element, originalElement);
    }
    return _xblockexpression;
  }
  
  protected String generateDocumentation(final PsiElement element, final PsiElement originalElement) {
    DocumentationProvider _providerFromElement = DocumentationManager.getProviderFromElement(element, originalElement);
    return _providerFromElement.generateDoc(element, originalElement);
  }
}
