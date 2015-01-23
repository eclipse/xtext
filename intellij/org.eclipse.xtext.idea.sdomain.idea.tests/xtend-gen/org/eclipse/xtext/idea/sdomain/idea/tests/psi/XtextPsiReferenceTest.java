/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.tests.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import junit.framework.TestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.sdomain.idea.tests.psi.XtextPsiReferenceTestContext;
import org.eclipse.xtext.psi.XtextPsiReference;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XtextPsiReferenceTest extends LightCodeInsightFixtureTestCase {
  public void testProperty_type_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {<crossReference>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<caret><referenceToHighlight><reference>Foo</reference></referenceToHighlight></crossReference> foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testReference(_builder);
  }
  
  public void testProperty_type_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("entity Foo {<crossReference>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<caret><referenceToHighlight>a.b.c.<reference>Foo</reference></referenceToHighlight></crossReference> foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testReference(_builder);
  }
  
  protected void testReference(final CharSequence text) {
    String _string = text.toString();
    XtextPsiReferenceTestContext _xtextPsiReferenceTestContext = new XtextPsiReferenceTestContext(_string);
    this.testReference(_xtextPsiReferenceTestContext);
  }
  
  protected void testReference(@Extension final XtextPsiReferenceTestContext context) {
    String _text = context.getText();
    this.myFixture.configureByText("aaa.sdomain", _text);
    PsiFile _file = this.myFixture.getFile();
    int _caretOffset = context.getCaretOffset();
    final PsiElement elementAtCaret = _file.findElementAt(_caretOffset);
    TestCase.assertNotNull(elementAtCaret);
    PsiFile _file_1 = this.myFixture.getFile();
    int _caretOffset_1 = context.getCaretOffset();
    PsiReference _findReferenceAt = _file_1.findReferenceAt(_caretOffset_1);
    final XtextPsiReference reference = ((XtextPsiReference) _findReferenceAt);
    TestCase.assertNotNull(reference);
    int _startReferenceOffset = context.getStartReferenceOffset();
    int _startCrossReferenceOffset = context.getStartCrossReferenceOffset();
    final int startReferneceOffsetInElement = (_startReferenceOffset - _startCrossReferenceOffset);
    int _endReferenceOffset = context.getEndReferenceOffset();
    int _startCrossReferenceOffset_1 = context.getStartCrossReferenceOffset();
    final int endReferenceOffsetInElement = (_endReferenceOffset - _startCrossReferenceOffset_1);
    final TextRange rangeInElement = reference.getRangeInElement();
    int _startOffset = rangeInElement.getStartOffset();
    TestCase.assertEquals(startReferneceOffsetInElement, _startOffset);
    int _endOffset = rangeInElement.getEndOffset();
    TestCase.assertEquals(endReferenceOffsetInElement, _endOffset);
    int _startReferenceToHighlightOffset = context.getStartReferenceToHighlightOffset();
    int _startCrossReferenceOffset_2 = context.getStartCrossReferenceOffset();
    final int startReferenceToHighlightOffsetInElement = (_startReferenceToHighlightOffset - _startCrossReferenceOffset_2);
    int _endReferenceToHighlightOffset = context.getEndReferenceToHighlightOffset();
    int _startCrossReferenceOffset_3 = context.getStartCrossReferenceOffset();
    final int endReferenceToHighlightOffsetInElement = (_endReferenceToHighlightOffset - _startCrossReferenceOffset_3);
    final TextRange rangeToHighlight = reference.getRangeToHighlightInElement();
    int _startOffset_1 = rangeToHighlight.getStartOffset();
    TestCase.assertEquals(startReferenceToHighlightOffsetInElement, _startOffset_1);
    int _endOffset_1 = rangeToHighlight.getEndOffset();
    TestCase.assertEquals(endReferenceToHighlightOffsetInElement, _endOffset_1);
  }
}
