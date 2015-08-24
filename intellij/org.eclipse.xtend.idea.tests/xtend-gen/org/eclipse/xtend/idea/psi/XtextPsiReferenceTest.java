/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextPsiReferenceTest extends LightXtendTest {
  @Test
  public void testGetTextOffset() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.File");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Main {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val file = new File(\'lalala\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("File(");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement element = reference.getElement();
    final TextRange textRange = element.getTextRange();
    final int textOffset = element.getTextOffset();
    String _plus = (textRange + " ");
    String _plus_1 = (_plus + Integer.valueOf(textOffset));
    boolean _contains = textRange.contains(textOffset);
    TestCase.assertTrue(_plus_1, _contains);
  }
}
