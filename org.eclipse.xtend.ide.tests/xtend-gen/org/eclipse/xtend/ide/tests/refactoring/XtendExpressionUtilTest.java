/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.refactoring.XtendExpressionUtil;
import org.eclipse.xtend.ide.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendExpressionUtilTest extends AbstractXtendTestCase {
  @Inject
  private XtendExpressionUtil util;

  @Inject
  private ParseHelper<XtendFile> parseHelper;

  @Inject
  private ValidationTestHelper validationHelper;

  @Inject
  private ILocationInFileProvider locationInFileProvider;

  @Test
  public void testSelectionExpression() {
    this.assertExpressionSelected("\'\'\' Prefix «4$$2» Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix «$42$» Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix $«42»$ Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix «$$42» Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix «$4$2» Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix «$42»$ Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix «42$$» Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix «4$2$» Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix $«42$» Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix «$42» Postfix$ \'\'\'", "\'\'\' Prefix «42» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' Prefix «42»$ Postfix$ \'\'\'", "» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' Prefix «42»$$ Postfix \'\'\'", "» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' Prefix «42» $Postfix$ \'\'\'", "» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' $Prefix «42$» Postfix \'\'\'", "\'\'\' Prefix «42» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' $Prefix $«42» Postfix \'\'\'", "\'\'\' Prefix «");
    this.assertExpressionSelected("\'\'\' Prefix $$«42» Postfix \'\'\'", "\'\'\' Prefix «");
  }

  @Test
  public void testSelectionExpression2() {
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ 4$$2 /* postfix */ » Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ $42$ /* postfix */ » Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix $« /* prefix */ 42 /* postfix */ »$ Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ $$42 /* postfix */ » Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ $4$2 /* postfix */ » Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ $42 /* postfix */ »$ Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ 42$$ /* postfix */ » Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ 4$2$ /* postfix */ » Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix $« /* prefix */ 42$ /* postfix */ » Postfix \'\'\'", "42");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ $42 /* postfix */ » Postfix$ \'\'\'", "\'\'\' Prefix « /* prefix */ 42 /* postfix */ » Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ 42 /* postfix */ »$ Postfix$ \'\'\'", "» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ 42 /* postfix */ »$$ Postfix \'\'\'", "» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' Prefix « /* prefix */ 42 /* postfix */ » $Postfix$ \'\'\'", "» Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' $Prefix « /* prefix */ 42$ /* postfix */ » Postfix \'\'\'", "\'\'\' Prefix « /* prefix */ 42 /* postfix */ » Postfix \'\'\'");
    this.assertExpressionSelected("\'\'\' $Prefix $« /* prefix */ 42 /* postfix */ » Postfix \'\'\'", "\'\'\' Prefix «");
    this.assertExpressionSelected("\'\'\' Prefix $$« /* prefix */ 42 /* postfix */ » Postfix \'\'\'", "\'\'\' Prefix «");
  }

  protected void assertExpressionSelected(final String modelWithSelectionMarkup, final String expectedSelection) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() ");
    _builder.append(modelWithSelectionMarkup, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final String cleanedModel = model.replaceAll("\\$", "");
    final XtendFile expression = this.parse(cleanedModel);
    final int selectionOffset = model.indexOf("$");
    int _lastIndexOf = model.lastIndexOf("$");
    int _minus = (_lastIndexOf - selectionOffset);
    final int selectionLength = (_minus - 1);
    Resource _eResource = expression.eResource();
    TextSelection _textSelection = new TextSelection(selectionOffset, selectionLength);
    final XExpression selectedExpression = this.util.findSelectedExpression(((XtextResource) _eResource), _textSelection);
    final ITextRegion selectedRegion = this.locationInFileProvider.getFullTextRegion(selectedExpression);
    int _offset = selectedRegion.getOffset();
    int _offset_1 = selectedRegion.getOffset();
    int _length = selectedRegion.getLength();
    int _plus = (_offset_1 + _length);
    Assert.assertEquals(expectedSelection, cleanedModel.substring(_offset, _plus));
  }

  protected XtendFile parse(final CharSequence string) {
    try {
      XtendFile _xblockexpression = null;
      {
        final XtendFile expression = this.parseHelper.parse(string);
        this.validationHelper.assertNoErrors(expression);
        _xblockexpression = expression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
