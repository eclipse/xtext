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
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendDocumentationTest extends LightXtendTest {
  @Override
  protected void invokeTestRunnable(final Runnable runnable) {
    Project _project = this.getProject();
    WriteCommandAction.runWriteCommandAction(_project, runnable);
  }
  
  public void testGenerateDocumentation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bar");
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private foo.Fo<caret>o foo;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Bar.java", _builder.toString());
    final String expectedDocumentation = this.generateDocumentation("testSrc-xtend-gen", "foo/Foo.java");
    final String actualDocumentation = this.generateDocumentation("testSrc", "foo/Foo.xtend");
    TestCase.assertEquals(expectedDocumentation, actualDocumentation);
  }
  
  protected String generateDocumentation(final String sourceFolder, final String sourcePath) {
    try {
      String _xblockexpression = null;
      {
        final VirtualFile virtualFile = this.myFixture.copyFileToProject(((sourceFolder + "/") + sourcePath), sourcePath);
        String _xtrycatchfinallyexpression = null;
        try {
          PsiFile _file = this.getFile();
          int _caretOffset = this.myFixture.getCaretOffset();
          PsiReference _findReferenceAt = _file.findReferenceAt(_caretOffset);
          _xtrycatchfinallyexpression = this.generateDocumentation(_findReferenceAt);
        } finally {
          virtualFile.delete(this);
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String generateDocumentation(final PsiReference reference) {
    String _xblockexpression = null;
    {
      final PsiElement originalElement = reference.getElement();
      final PsiElement element = reference.resolve();
      _xblockexpression = this.generateDocumentation(element, originalElement);
    }
    return _xblockexpression;
  }
  
  protected String generateDocumentation(final PsiElement element, final PsiElement originalElement) {
    DocumentationProvider _providerFromElement = DocumentationManager.getProviderFromElement(element, originalElement);
    return _providerFromElement.generateDoc(element, originalElement);
  }
}
