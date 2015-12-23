/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.javaconverter;

import com.google.inject.Inject;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import junit.framework.TestCase;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.core.tests.javaconverter.JavaConverterTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@TestDecorator
@SuppressWarnings("all")
public class IdeaJavaConverterTest extends AbstractModelTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends JavaConverterTest {
    private final ModelChecker modelChecker;
    
    @Override
    public XtendFile file(final String code, final boolean validate) {
      String _fileName = this.getFileName(code);
      return this.modelChecker.<XtendFile>checkModel(_fileName, code, validate);
    }
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  @Inject
  private JavaConverter converter;
  
  public IdeaJavaConverterTest(final LanguageFileType fileType) {
    super(fileType);
  }
  
  private IdeaJavaConverterTest.Delegate delegate;
  
  public IdeaJavaConverterTest() {
    super(XtendFileType.INSTANCE);
    IdeaJavaConverterTest.Delegate _delegate = new IdeaJavaConverterTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    IXtextLanguage _xtextLanguage = this.getXtextLanguage();
    _xtextLanguage.injectMembers(this.delegate);
    this.delegate.setUp();
  }
  
  @Test
  public void testSimpleCase() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package javaconverter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class JavaConverterTest {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void doStuff() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile javaCalzz = this.myFixture.addFileToProject("javaconverter/JavaConverterTest.java", _builder.toString());
    VirtualFile _virtualFile = javaCalzz.getVirtualFile();
    String _nameWithoutExtension = _virtualFile.getNameWithoutExtension();
    String _text = javaCalzz.getText();
    final JavaConverter.ConversionResult result = this.converter.toXtend(_nameWithoutExtension, _text, this.myModule);
    TestCase.assertNotNull(result);
    Iterable<String> _problems = result.getProblems();
    boolean _isEmpty = IterableExtensions.isEmpty(_problems);
    TestCase.assertTrue(_isEmpty);
  }
  
  public void testAnnotationDeclaration() throws Exception {
    delegate.testAnnotationDeclaration();
  }
  
  public void testAnonymousClassCase() throws Exception {
    delegate.testAnonymousClassCase();
  }
  
  public void testArrayAccessCase() throws Exception {
    delegate.testArrayAccessCase();
  }
  
  public void testArrayAccessCaseConstantIndex_01() throws Exception {
    delegate.testArrayAccessCaseConstantIndex_01();
  }
  
  public void testArrayAccessCaseConstantIndex_02() throws Exception {
    delegate.testArrayAccessCaseConstantIndex_02();
  }
  
  public void testArrayCreationCase() throws Exception {
    delegate.testArrayCreationCase();
  }
  
  public void testArrayCreationCase2() throws Exception {
    delegate.testArrayCreationCase2();
  }
  
  public void testArrayDimensionOnFragmentAsParameter() throws Exception {
    delegate.testArrayDimensionOnFragmentAsParameter();
  }
  
  public void testArrayPrefixMinusCase() throws Exception {
    delegate.testArrayPrefixMinusCase();
  }
  
  public void testArrayShiftDimensionCase() throws Exception {
    delegate.testArrayShiftDimensionCase();
  }
  
  public void testAssertCase() throws Exception {
    delegate.testAssertCase();
  }
  
  public void testBasicForStatementCase() throws Exception {
    delegate.testBasicForStatementCase();
  }
  
  public void testBasicForStatementCase_02() throws Exception {
    delegate.testBasicForStatementCase_02();
  }
  
  public void testBasicForStatementCase_03() throws Exception {
    delegate.testBasicForStatementCase_03();
  }
  
  public void testBasicForStatementCase_04() throws Exception {
    delegate.testBasicForStatementCase_04();
  }
  
  public void testBasicForStatementCase_05() throws Exception {
    delegate.testBasicForStatementCase_05();
  }
  
  public void testBitwiseComplementCase() throws Exception {
    delegate.testBitwiseComplementCase();
  }
  
  public void testBooleanBitwiseOperatorsCase() throws Exception {
    delegate.testBooleanBitwiseOperatorsCase();
  }
  
  public void testBug462099() throws Exception {
    delegate.testBug462099();
  }
  
  public void testBug462100() throws Exception {
    delegate.testBug462100();
  }
  
  public void testBytePrimitive_01() throws Exception {
    delegate.testBytePrimitive_01();
  }
  
  public void testBytePrimitive_02() throws Exception {
    delegate.testBytePrimitive_02();
  }
  
  public void testBytePrimitive_03() throws Exception {
    delegate.testBytePrimitive_03();
  }
  
  public void testCastCase_01() throws Exception {
    delegate.testCastCase_01();
  }
  
  public void testCastCase_02() throws Exception {
    delegate.testCastCase_02();
  }
  
  public void testCommentsCase_01() throws Exception {
    delegate.testCommentsCase_01();
  }
  
  public void testCommentsCase_02() throws Exception {
    delegate.testCommentsCase_02();
  }
  
  public void testConstructorCase() throws Exception {
    delegate.testConstructorCase();
  }
  
  public void testConstructorProblemCase() throws Exception {
    delegate.testConstructorProblemCase();
  }
  
  public void testDoWhileStatement() throws Exception {
    delegate.testDoWhileStatement();
  }
  
  public void testEnumCase() throws Exception {
    delegate.testEnumCase();
  }
  
  public void testEnumCase1() throws Exception {
    delegate.testEnumCase1();
  }
  
  public void testEnumNotSupportedCase() throws Exception {
    delegate.testEnumNotSupportedCase();
  }
  
  public void testEnumNotSupportedCase2() throws Exception {
    delegate.testEnumNotSupportedCase2();
  }
  
  public void testEnumNotSupportedCase3() throws Exception {
    delegate.testEnumNotSupportedCase3();
  }
  
  public void testExtendedForStatementCase_01() throws Exception {
    delegate.testExtendedForStatementCase_01();
  }
  
  public void testFieldDeclarationCase() throws Exception {
    delegate.testFieldDeclarationCase();
  }
  
  public void testFieldVisibility() throws Exception {
    delegate.testFieldVisibility();
  }
  
  public void testFieldVisibility1() throws Exception {
    delegate.testFieldVisibility1();
  }
  
  public void testFinalVariableEmptyInitializer() throws Exception {
    delegate.testFinalVariableEmptyInitializer();
  }
  
  public void testForceStatementForTargetObject() {
    delegate.testForceStatementForTargetObject();
  }
  
  public void testIfElseCase_01() throws Exception {
    delegate.testIfElseCase_01();
  }
  
  public void testIfElseCase_02() throws Exception {
    delegate.testIfElseCase_02();
  }
  
  public void testInnerClassCase() throws Exception {
    delegate.testInnerClassCase();
  }
  
  public void testInnerIntefaceCase() throws Exception {
    delegate.testInnerIntefaceCase();
  }
  
  public void testIntegerBitwiseOperatorsCase() throws Exception {
    delegate.testIntegerBitwiseOperatorsCase();
  }
  
  public void testJavadocCase_01() throws Exception {
    delegate.testJavadocCase_01();
  }
  
  public void testJavadocCase_02() throws Exception {
    delegate.testJavadocCase_02();
  }
  
  public void testJavadocCase_03() throws Exception {
    delegate.testJavadocCase_03();
  }
  
  public void testLambdaCase() throws Exception {
    delegate.testLambdaCase();
  }
  
  public void testLambdaCase2() throws Exception {
    delegate.testLambdaCase2();
  }
  
  public void testLambdaCase3() throws Exception {
    delegate.testLambdaCase3();
  }
  
  public void testMethodDeclarationCase() throws Exception {
    delegate.testMethodDeclarationCase();
  }
  
  public void testMultiDeclaration() throws Exception {
    delegate.testMultiDeclaration();
  }
  
  public void testNonFinalMethodParameterCase_01() throws Exception {
    delegate.testNonFinalMethodParameterCase_01();
  }
  
  public void testNonFinalMethodParameterCase_02() throws Exception {
    delegate.testNonFinalMethodParameterCase_02();
  }
  
  public void testNumberLiteralCase() throws Exception {
    delegate.testNumberLiteralCase();
  }
  
  public void testNumberLiteralCase2() throws Exception {
    delegate.testNumberLiteralCase2();
  }
  
  public void testOverride() throws Exception {
    delegate.testOverride();
  }
  
  public void testOverrideMethodeDeclarationCase() throws Exception {
    delegate.testOverrideMethodeDeclarationCase();
  }
  
  public void testPostfixArrayAccess() throws Exception {
    delegate.testPostfixArrayAccess();
  }
  
  public void testPrefixPlusMinusArrayCase() throws Exception {
    delegate.testPrefixPlusMinusArrayCase();
  }
  
  public void testPrefixPlusMinusCase() throws Exception {
    delegate.testPrefixPlusMinusCase();
  }
  
  public void testPrefixPlusMinusSimpleArrayCase() throws Exception {
    delegate.testPrefixPlusMinusSimpleArrayCase();
  }
  
  public void testReturnCase_01() throws Exception {
    delegate.testReturnCase_01();
  }
  
  public void testReturnVoidCase() throws Exception {
    delegate.testReturnVoidCase();
  }
  
  public void testReturnVoidCase_01() throws Exception {
    delegate.testReturnVoidCase_01();
  }
  
  public void testRichStringCase() throws Exception {
    delegate.testRichStringCase();
  }
  
  public void testRichStringCase1() throws Exception {
    delegate.testRichStringCase1();
  }
  
  public void testRichStringCase2() throws Exception {
    delegate.testRichStringCase2();
  }
  
  public void testRichStringCase3() throws Exception {
    delegate.testRichStringCase3();
  }
  
  public void testRichStringCase4() throws Exception {
    delegate.testRichStringCase4();
  }
  
  public void testRichStringSpecialCase() throws Exception {
    delegate.testRichStringSpecialCase();
  }
  
  public void testRichStringSpecialCase2() throws Exception {
    delegate.testRichStringSpecialCase2();
  }
  
  public void testRichStringSpecialCase3() throws Exception {
    delegate.testRichStringSpecialCase3();
  }
  
  public void testRichStringSpecialCase4() throws Exception {
    delegate.testRichStringSpecialCase4();
  }
  
  public void testSLCommentCase() throws Exception {
    delegate.testSLCommentCase();
  }
  
  public void testSimpleAssigmentCase() throws Exception {
    delegate.testSimpleAssigmentCase();
  }
  
  public void testSimpleCalssDeclarationCase() throws Exception {
    delegate.testSimpleCalssDeclarationCase();
  }
  
  public void testSimpleInstanceOfCase() throws Exception {
    delegate.testSimpleInstanceOfCase();
  }
  
  public void testSimpleInterfaceDeclarationCase() throws Exception {
    delegate.testSimpleInterfaceDeclarationCase();
  }
  
  public void testSimpleTypeParameterCase() throws Exception {
    delegate.testSimpleTypeParameterCase();
  }
  
  public void testStaticAccessCase() throws Exception {
    delegate.testStaticAccessCase();
  }
  
  public void testStaticAccessCase2() throws Exception {
    delegate.testStaticAccessCase2();
  }
  
  public void testStaticBlockCase() throws Exception {
    delegate.testStaticBlockCase();
  }
  
  public void testStaticBlockCase1() throws Exception {
    delegate.testStaticBlockCase1();
  }
  
  public void testStaticBlockCase2() throws Exception {
    delegate.testStaticBlockCase2();
  }
  
  public void testStaticBlockCase3() throws Exception {
    delegate.testStaticBlockCase3();
  }
  
  public void testStaticImportCase() throws Exception {
    delegate.testStaticImportCase();
  }
  
  public void testStringLiteralCase() throws Exception {
    delegate.testStringLiteralCase();
  }
  
  public void testSuperCalls() throws Exception {
    delegate.testSuperCalls();
  }
  
  public void testSwitchCase() throws Exception {
    delegate.testSwitchCase();
  }
  
  public void testSwitchCase2() throws Exception {
    delegate.testSwitchCase2();
  }
  
  public void testSwitchCase3() throws Exception {
    delegate.testSwitchCase3();
  }
  
  public void testSynchronizedStatement() throws Exception {
    delegate.testSynchronizedStatement();
  }
  
  public void testThrowExpressionCase() throws Exception {
    delegate.testThrowExpressionCase();
  }
  
  public void testTryCatchCase() throws Exception {
    delegate.testTryCatchCase();
  }
  
  public void testTryCatchCaseAsStatement() throws Exception {
    delegate.testTryCatchCaseAsStatement();
  }
  
  public void testXORExpressionCase() throws Exception {
    delegate.testXORExpressionCase();
  }
}
