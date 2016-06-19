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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Simple\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"1\"        Simple:\'1\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 3  S \"foo\"      Simple:name=ID");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Simple\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("5 0 H");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testMultiWhitespace() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("1 /**/ foo");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Simple\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"1\"        Simple:\'1\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1    H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("\"/**/\"     Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("6    \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 3  S \"foo\"      Simple:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Simple\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("10 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Delegation Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"2\"        Delegation:\'2\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Delegate\'foo\' Delegation:delegate=Delegate path:Delegation/delegate");
    _builder_1.newLine();
    _builder_1.append("2 3   S \"foo\"      Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Delegate\'foo\' Delegation:delegate=Delegate path:Delegation/delegate");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Delegation Root");
    _builder_1.newLine();
    _builder_1.append("5 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Delegate\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"3\"        Unassigned:\'3\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 3  S \"foo\"      Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Delegate\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("5 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B PrefixedUnassigned Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"4\"        PrefixedUnassigned:\'4\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Delegate\'foo\' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 6   S \"prefix\"   PrefixedDelegate:\'prefix\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1   H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 3   S \"foo\"      Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Delegate\'foo\' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E PrefixedUnassigned Root");
    _builder_1.newLine();
    _builder_1.append("12 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Add        Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"5\"        Root:\'5\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Named\'a\'   Expression:{Add.left=} path:Add/left");
    _builder_1.newLine();
    _builder_1.append("2 1   S \"a\"        Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Named\'a\'   Expression:{Add.left=} path:Add/left");
    _builder_1.newLine();
    _builder_1.append("3 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("4 1  S \"+\"        Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append("5 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Named\'b\'   Expression:right=Primary path:Add/right");
    _builder_1.newLine();
    _builder_1.append("6 1   S \"b\"        Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Named\'b\'   Expression:right=Primary path:Add/right");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Add        Root");
    _builder_1.newLine();
    _builder_1.append("7 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Add        Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"5\"        Root:\'5\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Add        Expression:{Add.left=} path:Add/left");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1   S \"(\"        Parenthesized:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0   H");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("B Named\'a\'   Expression:{Add.left=} path:Add/left=Add/left");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 1    S \"a\"        Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("E Named\'a\'   Expression:{Add.left=} path:Add/left=Add/left");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1   H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 1   S \"+\"        Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1   H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("B Named\'b\'   Expression:right=Primary path:Add/right=Add/left");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1    S \"b\"        Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("E Named\'b\'   Expression:right=Primary path:Add/right=Add/left");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 0   H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1   S \")\"        Parenthesized:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Add        Expression:{Add.left=} path:Add/left");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("10 1  S \"+\"        Expression:\'+\'");
    _builder_1.newLine();
    _builder_1.append("11 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Named\'c\'   Expression:right=Primary path:Add/right");
    _builder_1.newLine();
    _builder_1.append("12 1   S \"c\"        Primary:name=ID");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Named\'c\'   Expression:right=Primary path:Add/right");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Add        Root");
    _builder_1.newLine();
    _builder_1.append("13 0 H");
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
    _builder_1.append("0  0 H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 10  S \"unass...\" Mixed:\'unassigned\'");
    _builder_1.newLine();
    _builder_1.append("13  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("14  3  S \"foo\"      Mixed:ID");
    _builder_1.newLine();
    _builder_1.append("17  0  H");
    _builder_1.newLine();
    _builder_1.append("17  1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("18  0 H");
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
    _builder_1.append("0  0 H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 10  S \"unass...\" Mixed:\'unassigned\'");
    _builder_1.newLine();
    _builder_1.append("13  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("14 12  S \"datat...\" Mixed:Datatype");
    _builder_1.newLine();
    _builder_1.append("26  0  H");
    _builder_1.newLine();
    _builder_1.append("26  1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("27  0 H");
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
    _builder_1.append("0  0 H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 10  S \"unass...\" Mixed:\'unassigned\'");
    _builder_1.newLine();
    _builder_1.append("13  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("14 21  S \"datat...\" Mixed:Datatype");
    _builder_1.newLine();
    _builder_1.append("35  0  H");
    _builder_1.newLine();
    _builder_1.append("35  1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("36  0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append("3 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("4 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append("3 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("4 0  H");
    _builder_1.newLine();
    _builder_1.append("4 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("5 0  H");
    _builder_1.newLine();
    _builder_1.append("5 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("6 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append("3 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("4 0  H");
    _builder_1.newLine();
    _builder_1.append("4 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("5 0  H");
    _builder_1.newLine();
    _builder_1.append("5 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("6 0  H");
    _builder_1.newLine();
    _builder_1.append("6 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("7 0  H");
    _builder_1.newLine();
    _builder_1.append("7 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("8 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Mixed\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 3  S \"foo\"      Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("10 0  H");
    _builder_1.newLine();
    _builder_1.append("10 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Mixed\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("11 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Mixed      Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 5  S \"child\"    Mixed:\'child\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 0  H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed\'foo\' Mixed:eobj=Mixed path:Mixed/eobj");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 0   H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("10 0   H");
    _builder_1.newLine();
    _builder_1.append("10 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("11 0   H");
    _builder_1.newLine();
    _builder_1.append("11 3   S \"foo\"      Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append("14 0   H");
    _builder_1.newLine();
    _builder_1.append("14 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("15 0   H");
    _builder_1.newLine();
    _builder_1.append("15 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("16 0   H");
    _builder_1.newLine();
    _builder_1.append("16 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed\'foo\' Mixed:eobj=Mixed path:Mixed/eobj");
    _builder_1.newLine();
    _builder_1.append("17 0  H");
    _builder_1.newLine();
    _builder_1.append("17 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Mixed      Root");
    _builder_1.newLine();
    _builder_1.append("18 0 H");
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
    _builder_1.append("0  0 H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed      Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 12  S \"datat...\" Mixed:datatype=Datatype");
    _builder_1.newLine();
    _builder_1.append("15  0  H");
    _builder_1.newLine();
    _builder_1.append("15  1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed      Root");
    _builder_1.newLine();
    _builder_1.append("16  0 H");
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
    _builder_1.append("0  0 H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed      Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2  1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3  0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 21  S \"datat...\" Mixed:datatype=Datatype");
    _builder_1.newLine();
    _builder_1.append("24  0  H");
    _builder_1.newLine();
    _builder_1.append("24  1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed      Root");
    _builder_1.newLine();
    _builder_1.append("25  0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed\'foo\' Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0   H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 3   S \"foo\"      Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 0   H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed\'foo\' Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 6  S \"action\"   Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("14 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed      Mixed:body=Mixed path:AssignedAction/body");
    _builder_1.newLine();
    _builder_1.append("15 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("16 0   H");
    _builder_1.newLine();
    _builder_1.append("16 3   S \"ref\"      Mixed:\'ref\'");
    _builder_1.newLine();
    _builder_1.append("19 1   H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("20 3   S \"foo\"      Mixed:ref=[Mixed|ID]");
    _builder_1.newLine();
    _builder_1.append("23 0   H");
    _builder_1.newLine();
    _builder_1.append("23 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed      Mixed:body=Mixed path:AssignedAction/body");
    _builder_1.newLine();
    _builder_1.append("24 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("25 3  S \"end\"      Mixed:\'end\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append("28 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("B Mixed      Root");
    _builder_1.newLine();
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append("3 4  S \"lit1\"     Mixed:lit=Enum");
    _builder_1.newLine();
    _builder_1.append("7 0  H");
    _builder_1.newLine();
    _builder_1.append("7 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("E Mixed      Root");
    _builder_1.newLine();
    _builder_1.append("8 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed\'foo\' Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0   H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 3   S \"foo\"      Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 0   H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed\'foo\' Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 6  S \"action\"   Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append("14 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("B Mixed\'foo\' Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1    S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0    H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 3    S \"foo\"      Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 0    H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6 1    S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("E Mixed\'foo\' Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("7 1   H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 6   S \"action\"   Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append("14 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("15 6  S \"action\"   Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append("21 0 H");
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
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("B Action     Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1    S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0    H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 1    S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("E Action     Mixed:{AssignedAction.child=} path:AssignedAction/child=AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("4 1   H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("5 6   S \"action\"   Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E AssignedAction Mixed:{AssignedAction.child=} path:AssignedAction/child");
    _builder_1.newLine();
    _builder_1.append("11 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("12 6  S \"action\"   Mixed:\'action\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E AssignedAction Root");
    _builder_1.newLine();
    _builder_1.append("18 0 H");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testFragmentID() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (fragment foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 8  S \"fragment\" Mixed:\'fragment\'");
    _builder_1.newLine();
    _builder_1.append("11 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("12 3  S \"foo\"      Fragment:fragName=ID");
    _builder_1.newLine();
    _builder_1.append("15 0  H");
    _builder_1.newLine();
    _builder_1.append("15 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("16 0 H");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testFragmentRecursionID() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (fragment recursion foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 8  S \"fragment\" Mixed:\'fragment\'");
    _builder_1.newLine();
    _builder_1.append("11 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("12 9  S \"recur...\" Fragment:\'recursion\'");
    _builder_1.newLine();
    _builder_1.append("21 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("22 3  S \"foo\"      Fragment:fragName=ID");
    _builder_1.newLine();
    _builder_1.append("25 0  H");
    _builder_1.newLine();
    _builder_1.append("25 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("26 0 H");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testFragmentChildAction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (fragment child ())");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 8  S \"fragment\" Mixed:\'fragment\'");
    _builder_1.newLine();
    _builder_1.append("11 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("12 5  S \"child\"    Fragment:\'child\'");
    _builder_1.newLine();
    _builder_1.append("17 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Action     Fragment:mixed=Mixed path:Action/mixed");
    _builder_1.newLine();
    _builder_1.append("18 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("19 0   H");
    _builder_1.newLine();
    _builder_1.append("19 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Action     Fragment:mixed=Mixed path:Action/mixed");
    _builder_1.newLine();
    _builder_1.append("20 0  H");
    _builder_1.newLine();
    _builder_1.append("20 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("21 0 H");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testFragmentChildID() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (fragment child (foo))");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 8  S \"fragment\" Mixed:\'fragment\'");
    _builder_1.newLine();
    _builder_1.append("11 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("12 5  S \"child\"    Fragment:\'child\'");
    _builder_1.newLine();
    _builder_1.append("17 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed\'foo\' Fragment:mixed=Mixed path:Action/mixed");
    _builder_1.newLine();
    _builder_1.append("18 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("19 0   H");
    _builder_1.newLine();
    _builder_1.append("19 3   S \"foo\"      Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append("22 0   H");
    _builder_1.newLine();
    _builder_1.append("22 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed\'foo\' Fragment:mixed=Mixed path:Action/mixed");
    _builder_1.newLine();
    _builder_1.append("23 0  H");
    _builder_1.newLine();
    _builder_1.append("23 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("24 0 H");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testFragmentRecursionChild() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (fragment recursion child ())");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B Action     Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"6\"        Root:\'6\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 1  S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 0  H");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("3 8  S \"fragment\" Mixed:\'fragment\'");
    _builder_1.newLine();
    _builder_1.append("11 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("12 9  S \"recur...\" Fragment:\'recursion\'");
    _builder_1.newLine();
    _builder_1.append("21 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("22 5  S \"child\"    Fragment:\'child\'");
    _builder_1.newLine();
    _builder_1.append("27 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Action     Fragment:mixed=Mixed path:Action/mixed");
    _builder_1.newLine();
    _builder_1.append("28 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("29 0   H");
    _builder_1.newLine();
    _builder_1.append("29 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Action     Fragment:mixed=Mixed path:Action/mixed");
    _builder_1.newLine();
    _builder_1.append("30 0  H");
    _builder_1.newLine();
    _builder_1.append("30 1  S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E Action     Root");
    _builder_1.newLine();
    _builder_1.append("31 0 H");
    _builder_1.newLine();
    this.operator_tripleEquals(_trim, _builder_1);
  }
  
  @Test
  public void testMixedRootAction() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("7 action (foo)");
    _builder.newLine();
    String _string = _builder.toString();
    String _trim = _string.trim();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("B RootAction Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0 1  S \"7\"        Root:\'7\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("2 6  S \"action\"   Root:\'action\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("8 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Mixed\'foo\' Root:mixed=Mixed path:RootAction/mixed");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("9 1   S \"(\"        Mixed:\'(\'");
    _builder_1.newLine();
    _builder_1.append("10 0   H");
    _builder_1.newLine();
    _builder_1.append("10 3   S \"foo\"      Mixed:name=ID");
    _builder_1.newLine();
    _builder_1.append("13 0   H");
    _builder_1.newLine();
    _builder_1.append("13 1   S \")\"        Mixed:\')\'");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Mixed\'foo\' Root:mixed=Mixed path:RootAction/mixed");
    _builder_1.newLine();
    _builder_1.append("     ");
    _builder_1.append("E RootAction Root");
    _builder_1.newLine();
    _builder_1.append("14 0 H");
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
      TextRegionAccessToString _cfg = this.cfg(_withRegionAccess);
      String _plus = (_cfg + "\n");
      Assert.assertEquals(exp, _plus);
      TextRegionAccessToString _textRegionAccessToString_1 = new TextRegionAccessToString();
      TextRegionAccessToString _withRegionAccess_1 = _textRegionAccessToString_1.withRegionAccess(access2);
      TextRegionAccessToString _cfg_1 = this.cfg(_withRegionAccess_1);
      String _plus_1 = (_cfg_1 + "\n");
      Assert.assertEquals(exp, _plus_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private TextRegionAccessToString cfg(final TextRegionAccessToString toStr) {
    TextRegionAccessToString _hideColumnExplanation = toStr.hideColumnExplanation();
    return _hideColumnExplanation.withTextWidth(10);
  }
  
  private ITextRegionAccess createFromNodeModel(final EObject obj) {
    TextRegionAccessBuilder _get = this.textRegionAccessBuilder.get();
    Resource _eResource = obj.eResource();
    TextRegionAccessBuilder _forNodeModel = _get.forNodeModel(((XtextResource) _eResource));
    return _forNodeModel.create();
  }
}
