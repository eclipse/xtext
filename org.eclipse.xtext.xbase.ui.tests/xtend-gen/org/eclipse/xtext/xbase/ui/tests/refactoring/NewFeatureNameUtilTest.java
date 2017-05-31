package org.eclipse.xtext.xbase.ui.tests.refactoring;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.refactoring.NewFeatureNameUtil;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.ui.tests.XbaseInjectorProviderWithScopeTracking;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein
 */
@InjectWith(XbaseInjectorProviderWithScopeTracking.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class NewFeatureNameUtilTest extends AbstractXbaseTestCase {
  @Inject
  private ExpressionUtil util;
  
  @Inject
  private Provider<NewFeatureNameUtil> nameUtilProvider;
  
  @Inject
  private ParseHelper<XExpression> parseHelper;
  
  @Inject
  private ValidationTestHelper validationHelper;
  
  @Test
  public void testDefaultNamePrimitive() {
    this.assertDefaultName("{2+$3}", "i");
    this.assertDefaultName("{2+$3f}", "f");
    this.assertDefaultName("{2+$3l}", "l");
    this.assertDefaultName("{2+$3.0}", "d");
    this.assertDefaultName("{$true}", "b");
  }
  
  @Test
  public void testDefaultNameFeatureCall() {
    this.assertDefaultName("{\"\".$getBytes}", "bytes");
    this.assertDefaultName("{\"\".$length}", "length");
  }
  
  @Test
  public void testDefaultNameType() {
    this.assertDefaultName("{$2+3$}", "i");
    this.assertDefaultName("{\"$\"}", "string");
  }
  
  @Test
  public void testDefaultNameAlternate() {
    this.assertDefaultName("{val i=1 2+$3}", "j");
    this.assertDefaultName("{val j=2+$3 val i=1}", "k");
    this.assertDefaultName("{val i=1 {val j=2+$3}}", "k");
    this.assertDefaultName("{val j=1 {val i=2+$3}}", "k");
    this.assertDefaultName("{{val j=2+$3} val i=1 }", "i");
  }
  
  @Test
  public void testDefaultNameClosure() {
    this.assertDefaultName("{newArrayList(\"\").map[toFirstUpper]$$}", "function");
  }
  
  @Test
  public void testInvalidNameNull() {
    this.assertInvalidName(null, RefactoringStatus.FATAL, "Choose a name");
    this.assertInvalidName("", RefactoringStatus.FATAL, "Choose a name");
  }
  
  @Test
  public void testInvalidNameSyntax() {
    this.assertInvalidName("%", RefactoringStatus.FATAL, "character");
    this.assertInvalidName("gürkenbröd", RefactoringStatus.FATAL, "character");
    this.assertInvalidName("&", RefactoringStatus.FATAL, "character");
  }
  
  @Test
  public void testInvalidNameKeyword() {
    this.assertInvalidName("if", RefactoringStatus.FATAL, "keyword");
    this.assertInvalidName("else", RefactoringStatus.FATAL, "keyword");
    this.assertInvalidName("while", RefactoringStatus.FATAL, "keyword");
    this.assertInvalidName("do", RefactoringStatus.FATAL, "keyword");
    this.assertInvalidName("switch", RefactoringStatus.FATAL, "keyword");
    this.assertInvalidName("case", RefactoringStatus.FATAL, "keyword");
  }
  
  @Test
  public void testInvalidNamePrimitive() {
    this.assertInvalidName("boolean", RefactoringStatus.FATAL, "reserved");
    this.assertInvalidName("short", RefactoringStatus.FATAL, "reserved");
    this.assertInvalidName("char", RefactoringStatus.FATAL, "reserved");
    this.assertInvalidName("int", RefactoringStatus.FATAL, "reserved");
    this.assertInvalidName("long", RefactoringStatus.FATAL, "reserved");
    this.assertInvalidName("float", RefactoringStatus.FATAL, "reserved");
    this.assertInvalidName("double", RefactoringStatus.FATAL, "reserved");
  }
  
  @Test
  public void testInvalidNameUpperCase() {
    this.assertInvalidName("CamelCase", RefactoringStatus.ERROR, "lowercase");
  }
  
  protected void assertDefaultName(final String modelWithSelectionMarkup, final String expectedName) {
    final String cleanedModel = modelWithSelectionMarkup.replaceAll("\\$", "");
    final XExpression expression = this.parse(cleanedModel);
    final int selectionOffset = modelWithSelectionMarkup.indexOf("$");
    int _lastIndexOf = modelWithSelectionMarkup.lastIndexOf("$");
    int _minus = (_lastIndexOf - selectionOffset);
    final int selectionLength = (_minus - 1);
    Resource _eResource = expression.eResource();
    TextSelection _textSelection = new TextSelection(selectionOffset, selectionLength);
    final XExpression selectedExpression = this.util.findSelectedExpression(((XtextResource) _eResource), _textSelection);
    final XExpression successor = this.util.findSuccessorExpressionForVariableDeclaration(selectedExpression);
    final NewFeatureNameUtil nameUtil = this.nameUtilProvider.get();
    nameUtil.setFeatureScopeContext(successor);
    final String defaultName = nameUtil.getDefaultName(selectedExpression);
    Assert.assertEquals(expectedName, defaultName);
  }
  
  protected void assertInvalidName(final String name, final int severity, final String messageFragment) {
    final RefactoringStatus status = new RefactoringStatus();
    final NewFeatureNameUtil nameUtil = this.nameUtilProvider.get();
    nameUtil.checkNewFeatureName(name, false, status);
    Assert.assertEquals(severity, status.getSeverity());
    final String message = status.getEntryWithHighestSeverity().getMessage();
    Assert.assertTrue(message, message.contains(messageFragment));
  }
  
  protected XExpression parse(final CharSequence string) {
    try {
      XExpression _xblockexpression = null;
      {
        final XExpression expression = this.parseHelper.parse(string);
        this.validationHelper.assertNoErrors(expression);
        _xblockexpression = expression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
