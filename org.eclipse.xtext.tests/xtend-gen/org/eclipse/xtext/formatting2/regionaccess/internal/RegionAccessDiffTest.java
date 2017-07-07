/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestHelper;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class RegionAccessDiffTest {
  @Inject
  @Extension
  private RegionAccessTestHelper _regionAccessTestHelper;
  
  @Inject
  private Serializer serializer;
  
  @Test
  public void testEmptyModification() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("1 foo");
    _builder.newLine();
    final ITextRegionAccess access = this._regionAccessTestHelper.toTextRegionAccess(_builder);
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
    this._regionAccessTestHelper.operator_tripleEquals(access, _builder_1);
    final Procedure1<ITextRegionDiffBuilder> _function = (ITextRegionDiffBuilder it) -> {
    };
    ITextRegionAccess _modify = this._regionAccessTestHelper.modify(access, _function);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("0 0 H");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("B Simple\'foo\' Root");
    _builder_2.newLine();
    _builder_2.append("0 1  S \"1\"        Simple:\'1\'");
    _builder_2.newLine();
    _builder_2.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_2.newLine();
    _builder_2.append("2 3  S \"foo\"      Simple:name=ID");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("E Simple\'foo\' Root");
    _builder_2.newLine();
    _builder_2.append("5 0 H");
    _builder_2.newLine();
    this._regionAccessTestHelper.operator_tripleEquals(_modify, _builder_2);
  }
  
  @Test
  public void testSingleSemanticToken() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("1 foo");
    _builder.newLine();
    final ITextRegionAccess access = this._regionAccessTestHelper.toTextRegionAccess(_builder);
    final Procedure1<ITextRegionDiffBuilder> _function = (ITextRegionDiffBuilder it) -> {
      @Extension
      final ITextRegionExtensions ext = access.getExtensions();
      final EObject root = access.regionForRootEObject().getSemanticElement();
      final ISemanticRegion foo = ext.allRegionsFor(root).feature(RegionaccesstestlanguagePackage.Literals.SIMPLE__NAME);
      it.replace(foo, "baaar");
    };
    ITextRegionAccess _modify = this._regionAccessTestHelper.modify(access, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0   H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Simple\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("0 1    S \"1\"        Simple:\'1\'");
    _builder_1.newLine();
    _builder_1.append("1 1    H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 5 1  S \"baaar\"    Simple:name=ID");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Simple\'foo\' Root");
    _builder_1.newLine();
    _builder_1.append("7 0   H");
    _builder_1.newLine();
    _builder_1.append("------------ diff 1 ------------");
    _builder_1.newLine();
    _builder_1.append("2 3 S \"foo\"      Simple:name=ID");
    _builder_1.newLine();
    this._regionAccessTestHelper.operator_tripleEquals(_modify, _builder_1);
  }
  
  @Test
  public void testSerializeChildObject() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("2 foo");
    _builder.newLine();
    final ITextRegionAccess access = this._regionAccessTestHelper.toTextRegionAccess(_builder);
    final Procedure1<ITextRegionDiffBuilder> _function = (ITextRegionDiffBuilder it) -> {
      EObject _semanticElement = access.regionForRootEObject().getSemanticElement();
      final Delegate child = ((Delegation) _semanticElement).getDelegate();
      final IEObjectRegion childRegion = access.regionForEObject(child);
      child.setName("baaaz");
      final ITextRegionAccess textRegions = this.serializer.serializeToRegions(child);
      it.replace(childRegion.getPreviousHiddenRegion(), childRegion.getNextHiddenRegion(), textRegions);
    };
    ITextRegionAccess _modify = this._regionAccessTestHelper.modify(access, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0   H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Delegation Root");
    _builder_1.newLine();
    _builder_1.append("0 1    S \"2\"        Delegation:\'2\'");
    _builder_1.newLine();
    _builder_1.append("1 1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("B Delegate\'baaaz\' Delegate path:Delegation/delegate");
    _builder_1.newLine();
    _builder_1.append("2 5 1   S \"baaaz\"    Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("       ");
    _builder_1.append("E Delegate\'baaaz\' Delegate path:Delegation/delegate");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Delegation Root");
    _builder_1.newLine();
    _builder_1.append("7 0 1 H");
    _builder_1.newLine();
    _builder_1.append("------------ diff 1 ------------");
    _builder_1.newLine();
    _builder_1.append("1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 3  S \"foo\"      Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("5 0  H");
    _builder_1.newLine();
    this._regionAccessTestHelper.operator_tripleEquals(_modify, _builder_1);
  }
  
  @Test
  public void testSerializeRootObject() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("3 foo");
    _builder.newLine();
    final ITextRegionAccess access = this._regionAccessTestHelper.toTextRegionAccess(_builder);
    final Procedure1<ITextRegionDiffBuilder> _function = (ITextRegionDiffBuilder it) -> {
      final IEObjectRegion root = access.regionForRootEObject();
      EObject _semanticElement = root.getSemanticElement();
      final Delegate rootObj = ((Delegate) _semanticElement);
      rootObj.setName("baaaz");
      final ITextRegionAccess textRegions = this.serializer.serializeToRegions(rootObj);
      it.replace(root.getPreviousHiddenRegion(), root.getNextHiddenRegion(), textRegions);
    };
    ITextRegionAccess _modify = this._regionAccessTestHelper.modify(access, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 0 1 H");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("B Delegate\'baaaz\' Root");
    _builder_1.newLine();
    _builder_1.append("0 1 1  S \"3\"        Unassigned:\'3\'");
    _builder_1.newLine();
    _builder_1.append("1 1 1  H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 5 1  S \"baaaz\"    Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("E Delegate\'baaaz\' Root");
    _builder_1.newLine();
    _builder_1.append("7 0 1 H");
    _builder_1.newLine();
    _builder_1.append("------------ diff 1 ------------");
    _builder_1.newLine();
    _builder_1.append("0 0 H");
    _builder_1.newLine();
    _builder_1.append("0 1 S \"3\"        Unassigned:\'3\'");
    _builder_1.newLine();
    _builder_1.append("1 1 H \" \"        Whitespace:TerminalRule\'WS\'");
    _builder_1.newLine();
    _builder_1.append("2 3 S \"foo\"      Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("5 0 H");
    _builder_1.newLine();
    this._regionAccessTestHelper.operator_tripleEquals(_modify, _builder_1);
  }
  
  @Test
  public void testDeleteOne() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("4/*1*/prefix/*2*/foo");
    _builder.newLine();
    final ITextRegionAccess access = this._regionAccessTestHelper.toTextRegionAccess(_builder);
    final Procedure1<ITextRegionDiffBuilder> _function = (ITextRegionDiffBuilder it) -> {
      @Extension
      final ITextRegionExtensions ext = access.getExtensions();
      EObject _semanticElement = access.regionForRootEObject().getSemanticElement();
      final PrefixedUnassigned rootObj = ((PrefixedUnassigned) _semanticElement);
      final ISemanticRegion prefix = ext.regionFor(rootObj.getDelegate()).keyword("prefix");
      it.remove(prefix);
    };
    ITextRegionAccess _modify = this._regionAccessTestHelper.modify(access, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0  0   H");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("B PrefixedUnassigned Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1    S \"4\"        PrefixedUnassigned:\'4\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1    1  H \"/*1*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("10    \"/*2*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append("         ");
    _builder_1.append("B Delegate\'foo\' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate");
    _builder_1.newLine();
    _builder_1.append("11  3     S \"foo\"      Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("         ");
    _builder_1.append("E Delegate\'foo\' PrefixedUnassigned:delegate=PrefixedDelegate path:PrefixedUnassigned/delegate");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("E PrefixedUnassigned Root");
    _builder_1.newLine();
    _builder_1.append("14  0   H");
    _builder_1.newLine();
    _builder_1.append("------------ diff 1 ------------");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  5 H \"/*1*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6  6 S \"prefix\"   PrefixedDelegate:\'prefix\'");
    _builder_1.newLine();
    _builder_1.append("12  5 H \"/*2*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    this._regionAccessTestHelper.operator_tripleEquals(_modify, _builder_1);
  }
  
  @Test
  public void testDeleteTwo() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("4/*1*/prefix/*2*/foo/*3*/");
    _builder.newLine();
    final ITextRegionAccess access = this._regionAccessTestHelper.toTextRegionAccess(_builder);
    final Procedure1<ITextRegionDiffBuilder> _function = (ITextRegionDiffBuilder it) -> {
      @Extension
      final ITextRegionExtensions ext = access.getExtensions();
      EObject _semanticElement = access.regionForRootEObject().getSemanticElement();
      final PrefixedUnassigned rootObj = ((PrefixedUnassigned) _semanticElement);
      final ISemanticRegion prefix = ext.regionFor(rootObj.getDelegate()).keyword("prefix");
      final ISemanticRegion foo = ext.regionFor(rootObj.getDelegate()).feature(RegionaccesstestlanguagePackage.Literals.DELEGATE__NAME);
      it.remove(prefix.getPreviousHiddenRegion(), foo.getNextHiddenRegion());
    };
    ITextRegionAccess _modify = this._regionAccessTestHelper.modify(access, _function);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("0  0   H");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("B PrefixedUnassigned Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("0  1    S \"4\"        PrefixedUnassigned:\'4\'");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("E PrefixedUnassigned Root");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1    1 H \"/*1*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("10   \"/*3*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append("------------ diff 1 ------------");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("1  5  H \"/*1*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("6  6  S \"prefix\"   PrefixedDelegate:\'prefix\'");
    _builder_1.newLine();
    _builder_1.append("12  5  H \"/*2*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    _builder_1.append("17  3  S \"foo\"      Delegate:name=ID");
    _builder_1.newLine();
    _builder_1.append("20  5  H \"/*3*/\"    Comment:TerminalRule\'ML_COMMENT\'");
    _builder_1.newLine();
    this._regionAccessTestHelper.operator_tripleEquals(_modify, _builder_1);
  }
}
