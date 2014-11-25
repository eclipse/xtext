/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBaseRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.TokenAccessToString;
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
  
  private void operator_tripleEquals(final CharSequence file, final CharSequence expectation) {
    try {
      final Root obj = this.parseHelper.parse(file);
      NodeModelBaseRegionAccess.Builder _builder = new NodeModelBaseRegionAccess.Builder();
      Resource _eResource = obj.eResource();
      NodeModelBaseRegionAccess.Builder _withResource = _builder.withResource(((XtextResource) _eResource));
      final NodeModelBaseRegionAccess access = _withResource.create();
      TokenAccessToString _tokenAccessToString = new TokenAccessToString();
      TokenAccessToString _withOrigin = _tokenAccessToString.withOrigin(access);
      TokenAccessToString _hideColumnExplanation = _withOrigin.hideColumnExplanation();
      final String actual = _hideColumnExplanation.toString();
      String _string = expectation.toString();
      Assert.assertEquals(_string, (actual + "\n"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
