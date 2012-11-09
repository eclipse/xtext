package org.eclipse.xtext.xbase.ui.tests.refactoring;

import com.google.inject.Provider;
import javax.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.refactoring.NewVariableNameUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jan Koehnlein
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseInjectorProvider.class)
@SuppressWarnings("all")
public class NewVariableNameUtilTest {
  @Inject
  private ExpressionUtil util;
  
  @Inject
  private Provider<NewVariableNameUtil> nameUtilProvider;
  
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
    this.assertDefaultName("{val CAMEL_CASE_NAME = 1 $CAMEL_CASE_NAME}", "camelCaseName");
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
    this.assertDefaultName("{val i=1 2+$3}", "i1");
    this.assertDefaultName("{val j=2+$3 val i=1}", "i1");
    this.assertDefaultName("{val i=1 {val j=2+$3}}", "i1");
    this.assertDefaultName("{val i=1 {val i1=1 val j=2+$3}}", "i2");
    this.assertDefaultName("{{val j=2+$3} val i=1 }", "i");
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
    final Pair<XBlockExpression,XExpression> point = this.util.findInsertionPointForVariableDeclaration(selectedExpression);
    final NewVariableNameUtil nameUtil = this.nameUtilProvider.get();
    XExpression _second = point.getSecond();
    XBlockExpression _first = point.getFirst();
    nameUtil.initialize(_second, _first);
    final String defaultName = nameUtil.getDefaultName(selectedExpression);
    Assert.assertEquals(expectedName, defaultName);
  }
  
  protected XExpression parse(final CharSequence string) {
    try {
      XExpression _xblockexpression = null;
      {
        final XExpression expression = this.parseHelper.parse(string);
        this.validationHelper.assertNoErrors(expression);
        _xblockexpression = (expression);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
