/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class RegionAccessBuilderTest {
  @Inject
  private ParseHelper<Root> parseHelper;
  
  @Inject
  private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;
  
  @Inject
  private ValidationTestHelper validationTestHelper;
  
  @Inject
  @Extension
  private Serializer serializer;
  
  @Test
  public void testSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("1 foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Simple\'foo\' via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"1\" Simple:\'1\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 3 Semantic \"foo\" Simple:name=ID");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Simple\'foo\' via Root");
    _builder_1.newLine();
    _builder_1.append("5 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignedDelegate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("2 foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Delegation via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"2\" Delegation:\'2\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    delegate=Delegate\'foo\' via Delegation:delegate=Delegate");
    _builder_1.newLine();
    _builder_1.append("2 3 Semantic \"foo\" Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      delegate=Delegate\'foo\' via Delegation:delegate=Delegate");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Delegation via Root");
    _builder_1.newLine();
    _builder_1.append("5 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testUnassignedDelegate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("3 foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Delegate\'foo\' via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"3\" Unassigned:\'3\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 3 Semantic \"foo\" Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Delegate\'foo\' via Root");
    _builder_1.newLine();
    _builder_1.append("5 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testUnassignedPrefixedDelegate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("4 prefix foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    PrefixedUnassigned via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"4\" PrefixedUnassigned:\'4\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    delegate=Delegate\'foo\' via PrefixedUnassigned:delegate=PrefixedDelegate");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 6 Semantic \"prefix\" PrefixedDelegate:\'prefix\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 3 Semantic \"foo\" Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      delegate=Delegate\'foo\' via PrefixedUnassigned:delegate=PrefixedDelegate");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      PrefixedUnassigned via Root");
    _builder_1.newLine();
    _builder_1.append("12 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("5 a + b");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Add via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"5\" Root:\'5\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    left=Named\'a\' via Expression:{Add.left=}");
    _builder_1.newLine();
    _builder_1.append("2 1 Semantic \"a\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      left=Named\'a\' via Expression:{Add.left=}");
    _builder_1.newLine();
    _builder_1.append("3 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("4 1 Semantic \"+\" Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append("5 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    right=Named\'b\' via Expression:right=Primary");
    _builder_1.newLine();
    _builder_1.append("6 1 Semantic \"b\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      right=Named\'b\' via Expression:right=Primary");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Add via Root");
    _builder_1.newLine();
    _builder_1.append("7 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("5 (a + b) + c");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Add via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"5\" Root:\'5\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    left=Add via Expression:{Add.left=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1 Semantic \"(\" Parenthesized:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    left=Named\'a\' via Expression:{Add.left=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 1 Semantic \"a\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      left=Named\'a\' via Expression:{Add.left=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1 Semantic \"+\" Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    right=Named\'b\' via Expression:right=Primary");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1 Semantic \"b\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      right=Named\'b\' via Expression:right=Primary");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1 Semantic \")\" Parenthesized:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      left=Add via Expression:{Add.left=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("10 1 Semantic \"+\" Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append("11 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    right=Named\'c\' via Expression:right=Primary");
    _builder_1.newLine();
    _builder_1.append("12 1 Semantic \"c\" Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      right=Named\'c\' via Expression:right=Primary");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Add via Root");
    _builder_1.newLine();
    _builder_1.append("13 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testMixedUnassignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Start    Action via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 10 Semantic \"unassigned\" Mixed:\'unassigned\'");
    _builder_1.newLine();
    _builder_1.append("13  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("14  3 Semantic \"foo\" Mixed:ID");
    _builder_1.newLine();
    _builder_1.append("17  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("17  1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("End      Action via Root");
    _builder_1.newLine();
    _builder_1.append("18  0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testMixedUnassignedDatatype1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned datatype foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Start    Action via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 10 Semantic \"unassigned\" Mixed:\'unassigned\'");
    _builder_1.newLine();
    _builder_1.append("13  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("14 12 Semantic \"datatyp...\" Mixed:Datatype");
    _builder_1.newLine();
    _builder_1.append("26  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("26  1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("End      Action via Root");
    _builder_1.newLine();
    _builder_1.append("27  0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testMixedUnassignedDatatype2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned datatype datatype foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Start    Action via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 10 Semantic \"unassigned\" Mixed:\'unassigned\'");
    _builder_1.newLine();
    _builder_1.append("13  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("14 21 Semantic \"datatyp...\" Mixed:Datatype");
    _builder_1.newLine();
    _builder_1.append("35  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("35  1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("End      Action via Root");
    _builder_1.newLine();
    _builder_1.append("36  0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 ()");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Action via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("3 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Action via Root");
    _builder_1.newLine();
    _builder_1.append("4 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testActionDelegate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (())");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Action via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("3 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("4 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("4 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("5 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("5 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Action via Root");
    _builder_1.newLine();
    _builder_1.append("6 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testActionDelegate2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 ((()))");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Action via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("3 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("4 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("4 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("5 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("5 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("6 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("6 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("7 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("7 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Action via Root");
    _builder_1.newLine();
    _builder_1.append("8 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignmentDelegate2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (((foo)))");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Mixed\'foo\' via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 3 Semantic \"foo\" Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("10 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("10 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Mixed\'foo\' via Root");
    _builder_1.newLine();
    _builder_1.append("11 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignmentChildDelegate2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (child(((foo))))");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    Mixed via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 5 Semantic \"child\" Mixed:\'child\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    eobj=Mixed\'foo\' via Mixed:eobj=Mixed");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("10 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("10 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("11 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("11 3 Semantic \"foo\" Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append("14 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("14 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("15 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("15 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("16 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("16 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      eobj=Mixed\'foo\' via Mixed:eobj=Mixed");
    _builder_1.newLine();
    _builder_1.append("17 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("17 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      Mixed via Root");
    _builder_1.newLine();
    _builder_1.append("18 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignedDatatype() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (datatype foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Start    Mixed via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 12 Semantic \"datatyp...\" Mixed:datatype=Datatype");
    _builder_1.newLine();
    _builder_1.append("15  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("15  1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("End      Mixed via Root");
    _builder_1.newLine();
    _builder_1.append("16  0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignedDatatype2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (datatype datatype foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Start    Mixed via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 21 Semantic \"datatyp...\" Mixed:datatype=Datatype");
    _builder_1.newLine();
    _builder_1.append("24  0 Hidden");
    _builder_1.newLine();
    _builder_1.append("24  1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("End      Mixed via Root");
    _builder_1.newLine();
    _builder_1.append("25  0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testRef() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action (ref foo) end");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    child=Mixed\'foo\' via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 3 Semantic \"foo\" Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      child=Mixed\'foo\' via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 6 Semantic \"action\" Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("14 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    body=Mixed via Mixed:body=Mixed");
    _builder_1.newLine();
    _builder_1.append("15 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("16 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("16 3 Semantic \"ref\" Mixed:\'ref\'");
    _builder_1.newLine();
    _builder_1.append("19 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("20 3 Semantic \"foo\" Mixed:ref=[Mixed|ID]");
    _builder_1.newLine();
    _builder_1.append("23 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("23 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      body=Mixed via Mixed:body=Mixed");
    _builder_1.newLine();
    _builder_1.append("24 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("25 3 Semantic \"end\" Mixed:\'end\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append("28 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testEnum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (lit1)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Start    Mixed via Root");
    _builder_1.newLine();
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("3 4 Semantic \"lit1\" Mixed:lit=Enum");
    _builder_1.newLine();
    _builder_1.append("7 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("7 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("End      Mixed via Root");
    _builder_1.newLine();
    _builder_1.append("8 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignmentAction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    child=Mixed\'foo\' via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 3 Semantic \"foo\" Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      child=Mixed\'foo\' via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 6 Semantic \"action\" Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append("14 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testAssignmentActionAction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action action");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    child=AssignedAction via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    child=Mixed\'foo\' via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 3 Semantic \"foo\" Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      child=Mixed\'foo\' via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 6 Semantic \"action\" Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      child=AssignedAction via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append("14 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("15 6 Semantic \"action\" Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append("21 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testActionActionAction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 () action action");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 Hidden");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1 Semantic \"6\" Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    child=AssignedAction via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("Start    child=Action via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1 Semantic \"(\" Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0 Hidden");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 1 Semantic \")\" Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      child=Action via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 6 Semantic \"action\" Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      child=AssignedAction via Mixed:{AssignedAction.child=}");
    _builder_1.newLine();
    _builder_1.append("11 1 Hidden   \" \" Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("12 6 Semantic \"action\" Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("End      AssignedAction via Root");
    _builder_1.newLine();
    _builder_1.append("18 0 Hidden");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  private void operator_tripleEquals(final CharSequence file, final CharSequence expectation) {
    try {
      final String exp = expectation.toString();
      final Root obj = this.parseHelper.parse(file);
      this.validationTestHelper.assertNoErrors(obj);
      final ITextRegionAccess access1 = this.createFromNodeModel(obj);
      final ITextRegionAccess access2 = this.serializer.serializeToRegions(obj);
      TextRegionAccessToString _textRegionAccessToString = new TextRegionAccessToString();
      TextRegionAccessToString _withRegionAccess = _textRegionAccessToString.withRegionAccess(access1);
      TextRegionAccessToString _hideColumnExplanation = _withRegionAccess.hideColumnExplanation();
      String _plus = (_hideColumnExplanation + "\n");
      Assert.assertEquals(exp, _plus);
      TextRegionAccessToString _textRegionAccessToString_1 = new TextRegionAccessToString();
      TextRegionAccessToString _withRegionAccess_1 = _textRegionAccessToString_1.withRegionAccess(access2);
      TextRegionAccessToString _hideColumnExplanation_1 = _withRegionAccess_1.hideColumnExplanation();
      String _plus_1 = (_hideColumnExplanation_1 + "\n");
      Assert.assertEquals(exp, _plus_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private ITextRegionAccess createFromNodeModel(final EObject obj) {
    TextRegionAccessBuilder _get = this.textRegionAccessBuilder.get();
    Resource _eResource = obj.eResource();
    TextRegionAccessBuilder _forNodeModel = _get.forNodeModel(((XtextResource) _eResource));
    return _forNodeModel.create();
  }
}
