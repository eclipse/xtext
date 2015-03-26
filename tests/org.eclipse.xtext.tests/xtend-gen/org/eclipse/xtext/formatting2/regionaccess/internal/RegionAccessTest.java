/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.SerializerBasedRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.SerializerHelper;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class RegionAccessTest {
  @Inject
  private ParseHelper<Root> parseHelper;
  
  @Inject
  private SerializerHelper serializerHelper;
  
  @Test
  public void testSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("test 1 foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Simple\'foo\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 4 Semantic \"test\" Root:\'test\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1 Semantic \"1\" Simple:\'1\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 3 Semantic \"foo\" Simple:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Simple\'foo\'");
    _builder_1.newLine();
    _builder_1.append("10 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignedDelegate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("test 2 foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Delegation");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 4 Semantic \"test\" Root:\'test\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1 Semantic \"2\" Delegation:\'2\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    delegate=Delegate\'foo\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 3 Semantic \"foo\" Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Delegation, delegate=Delegate\'foo\'");
    _builder_1.newLine();
    _builder_1.append("10 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testUnassignedDelegate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("test 3 foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Delegate\'foo\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 4 Semantic \"test\" Root:\'test\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1 Semantic \"3\" Unassigned:\'3\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 3 Semantic \"foo\" Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Delegate\'foo\'");
    _builder_1.newLine();
    _builder_1.append("10 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testUnassignedPrefixedDelegate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("test 4 prefix foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    PrefixedUnassigned");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 4 Semantic \"test\" Root:\'test\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1 Semantic \"4\" PrefixedUnassigned:\'4\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    delegate=Delegate\'foo\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 6 Semantic \"prefix\" PrefixedDelegate:\'prefix\'");
    _builder_1.newLine();
    _builder_1.append("13 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("14 3 Semantic \"foo\" Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      PrefixedUnassigned, delegate=Delegate\'foo\'");
    _builder_1.newLine();
    _builder_1.append("17 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("test 5 a + b");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Add");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 4 Semantic \"test\" Root:\'test\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1 Semantic \"5\" Root:\'5\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    left=Named\'a\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1 Semantic \"a\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      left=Named\'a\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1 Semantic \"+\" Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append("10 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    right=Named\'b\'");
    _builder_1.newLine();
    _builder_1.append("11 1 Semantic \"b\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Add, right=Named\'b\'");
    _builder_1.newLine();
    _builder_1.append("12 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("test 5 (a + b) + c");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Add");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 4 Semantic \"test\" Root:\'test\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1 Semantic \"5\" Root:\'5\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    left=Add");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1 Semantic \"(\" Parenthesized:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    left=Named\'a\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1 Semantic \"a\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      left=Named\'a\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("10 1 Semantic \"+\" Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append("11 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    right=Named\'b\'");
    _builder_1.newLine();
    _builder_1.append("12 1 Semantic \"b\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      right=Named\'b\'");
    _builder_1.newLine();
    _builder_1.append("13 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("13 1 Semantic \")\" Parenthesized:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      left=Add");
    _builder_1.newLine();
    _builder_1.append("14 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("15 1 Semantic \"+\" Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append("16 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    right=Named\'c\'");
    _builder_1.newLine();
    _builder_1.append("17 1 Semantic \"c\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Add, right=Named\'c\'");
    _builder_1.newLine();
    _builder_1.append("18 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  private void operator_tripleEquals(final CharSequence file, final CharSequence expectation) {
    try {
      final String exp = expectation.toString();
      final Root obj = this.parseHelper.parse(file);
      final NodeModelBasedRegionAccess access1 = this.createFromNodeModel(obj);
      final SerializerBasedRegionAccess access2 = this.createFromSerializer(obj);
      TextRegionAccessToString _textRegionAccessToString = new TextRegionAccessToString();
      TextRegionAccessToString _withOrigin = _textRegionAccessToString.withOrigin(access1);
      TextRegionAccessToString _hideColumnExplanation = _withOrigin.hideColumnExplanation();
      String _plus = (_hideColumnExplanation + "\n");
      Assert.assertEquals(exp, _plus);
      TextRegionAccessToString _textRegionAccessToString_1 = new TextRegionAccessToString();
      TextRegionAccessToString _withOrigin_1 = _textRegionAccessToString_1.withOrigin(access2);
      TextRegionAccessToString _hideColumnExplanation_1 = _withOrigin_1.hideColumnExplanation();
      String _plus_1 = (_hideColumnExplanation_1 + "\n");
      Assert.assertEquals(exp, _plus_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private NodeModelBasedRegionAccess createFromNodeModel(final EObject obj) {
    NodeModelBasedRegionAccess.Builder _builder = new NodeModelBasedRegionAccess.Builder();
    Resource _eResource = obj.eResource();
    NodeModelBasedRegionAccess.Builder _withResource = _builder.withResource(((XtextResource) _eResource));
    return _withResource.create();
  }
  
  private SerializerBasedRegionAccess createFromSerializer(final EObject obj) {
    SerializerBasedRegionAccess _xblockexpression = null;
    {
      SerializerBasedRegionAccess.Builder _builder = new SerializerBasedRegionAccess.Builder();
      final SerializerBasedRegionAccess.Builder builder = _builder.withRoot(obj);
      this.serializerHelper.serialize(obj, builder);
      _xblockexpression = builder.getRegionAccess();
    }
    return _xblockexpression;
  }
}
