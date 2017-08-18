/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.serializer;

import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.serializer.ChangeSerializerTestHelper;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(PartialSerializationTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class PartialSerializerTest {
  @Extension
  private PartialSerializationTestLanguageFactory fac = PartialSerializationTestLanguageFactory.eINSTANCE;
  
  @Inject
  private Provider<ChangeSerializer> serializerProvider;
  
  @Inject
  @Extension
  private ChangeSerializerTestHelper _changeSerializerTestHelper;
  
  @Test
  public void testMandatoryValueChange() {
    final Procedure1<MandatoryValue> _function = (MandatoryValue it) -> {
      it.setName("bar");
    };
    ITextRegionAccess _recordDiff = this.<MandatoryValue>recordDiff(MandatoryValue.class, "#2 foo", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B MandatoryValue\'bar\'  Model");
    _builder.newLine();
    _builder.append("0 2    S \"#2\"                 Model:\'#2\'");
    _builder.newLine();
    _builder.append("2 1    H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("3 3 1  S \"bar\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E MandatoryValue\'bar\'  Model");
    _builder.newLine();
    _builder.append("6 0   H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("3 3 S \"foo\"                MandatoryValue:name=ID");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalValueInsert() {
    final Procedure1<OptionalValue> _function = (OptionalValue it) -> {
      it.setName("foo");
    };
    ITextRegionAccess _recordDiff = this.<OptionalValue>recordDiff(OptionalValue.class, "#3", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0 1 H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalValue\'foo\'   Model");
    _builder.newLine();
    _builder.append("0 2 1  S \"#3\"                 Model:\'#3\'");
    _builder.newLine();
    _builder.append("2 0 1  H");
    _builder.newLine();
    _builder.append("2 3 1  S \"foo\"                OptionalValue:name=ID");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalValue\'foo\'   Model");
    _builder.newLine();
    _builder.append("5 0 1 H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("0 0 H");
    _builder.newLine();
    _builder.append("0 2 S \"#3\"                 Model:\'#3\'");
    _builder.newLine();
    _builder.append("2 0 H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalValueChange() {
    final Procedure1<OptionalValue> _function = (OptionalValue it) -> {
      it.setName("baz");
    };
    ITextRegionAccess _recordDiff = this.<OptionalValue>recordDiff(OptionalValue.class, "#3 foo", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalValue\'baz\'   Model");
    _builder.newLine();
    _builder.append("0 2    S \"#3\"                 Model:\'#3\'");
    _builder.newLine();
    _builder.append("2 1    H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("3 3 1  S \"baz\"                OptionalValue:name=ID");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalValue\'baz\'   Model");
    _builder.newLine();
    _builder.append("6 0   H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("3 3 S \"foo\"                OptionalValue:name=ID");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalValueRemove() {
    final Procedure1<OptionalValue> _function = (OptionalValue it) -> {
      it.setName(null);
    };
    ITextRegionAccess _recordDiff = this.<OptionalValue>recordDiff(OptionalValue.class, "#3 foo", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalValue        Model");
    _builder.newLine();
    _builder.append("0 2    S \"#3\"                 Model:\'#3\'");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalValue        Model");
    _builder.newLine();
    _builder.append("2 1 1 H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("2 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("3 3  S \"foo\"                OptionalValue:name=ID");
    _builder.newLine();
    _builder.append("6 0  H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testMandatoryChildChange() {
    final Procedure1<MandatoryChild> _function = (MandatoryChild it) -> {
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("baz");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      it.setChild(_doubleArrow);
    };
    ITextRegionAccess _recordDiff = this.<MandatoryChild>recordDiff(MandatoryChild.class, "#4 foo", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B MandatoryChild       Model");
    _builder.newLine();
    _builder.append("0 2    S \"#4\"                 Model:\'#4\'");
    _builder.newLine();
    _builder.append("2 1 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'baz\'  MandatoryValue path:MandatoryChild/child");
    _builder.newLine();
    _builder.append("3 3 1   S \"baz\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'baz\'  MandatoryValue path:MandatoryChild/child");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E MandatoryChild       Model");
    _builder.newLine();
    _builder.append("6 0 1 H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("2 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("3 3  S \"foo\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("6 0  H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildInsert() {
    final Procedure1<OptionalChild> _function = (OptionalChild it) -> {
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("baz");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      it.setChild(_doubleArrow);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChild>recordDiff(OptionalChild.class, "#5", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0 1 H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalChild        Model");
    _builder.newLine();
    _builder.append("0 2 1  S \"#5\"                 Model:\'#5\'");
    _builder.newLine();
    _builder.append("2 0 1  H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'baz\'  OptionalChild:child=MandatoryValue path:OptionalChild/child");
    _builder.newLine();
    _builder.append("2 3 1   S \"baz\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'baz\'  OptionalChild:child=MandatoryValue path:OptionalChild/child");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalChild        Model");
    _builder.newLine();
    _builder.append("5 0 1 H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("0 0 H");
    _builder.newLine();
    _builder.append("0 2 S \"#5\"                 Model:\'#5\'");
    _builder.newLine();
    _builder.append("2 0 H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildChange() {
    final Procedure1<OptionalChild> _function = (OptionalChild it) -> {
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("baz");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      it.setChild(_doubleArrow);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChild>recordDiff(OptionalChild.class, "#5 foo", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalChild        Model");
    _builder.newLine();
    _builder.append("0 2    S \"#5\"                 Model:\'#5\'");
    _builder.newLine();
    _builder.append("2 1 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'baz\'  MandatoryValue path:OptionalChild/child");
    _builder.newLine();
    _builder.append("3 3 1   S \"baz\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'baz\'  MandatoryValue path:OptionalChild/child");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalChild        Model");
    _builder.newLine();
    _builder.append("6 0 1 H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("2 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("3 3  S \"foo\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("6 0  H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildRemove() {
    final Procedure1<OptionalChild> _function = (OptionalChild it) -> {
      it.setChild(null);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChild>recordDiff(OptionalChild.class, "#5 foo", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalChild        Model");
    _builder.newLine();
    _builder.append("0 2    S \"#5\"                 Model:\'#5\'");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalChild        Model");
    _builder.newLine();
    _builder.append("2 1 1 H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("2 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("3 3  S \"foo\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("6 0  H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testMoveInList1() {
    final Procedure1<Node> _function = (Node it) -> {
      it.getChildren().move(0, 1);
    };
    ITextRegionAccess _recordDiff = this.<Node>recordDiff(Node.class, "#1 root { Foo; Bar; }", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B Node\'root\'           Model");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("0 2    S \"#1\"                 Model:\'#1\'");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("2 1    H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("3 4    S \"root\"               Node:name=ID");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("7 1    H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("8 1    S \"{\"                  Node:\'{\'");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("9 1 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("B Node\'Bar\'            Node:children+=Node path:Node\'root\'/children[0]");
    _builder.newLine();
    _builder.append("10 3 1   S \"Bar\"                Node:name=ID");
    _builder.newLine();
    _builder.append("13 0 1   H");
    _builder.newLine();
    _builder.append("13 1 1   S \";\"                  Node:\';\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("E Node\'Bar\'            Node:children+=Node path:Node\'root\'/children[0]");
    _builder.newLine();
    _builder.append("14 1 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("B Node\'Foo\'            Node:children+=Node path:Node\'root\'/children[1]");
    _builder.newLine();
    _builder.append("15 3     S \"Foo\"                Node:name=ID");
    _builder.newLine();
    _builder.append("18 0     H");
    _builder.newLine();
    _builder.append("18 1     S \";\"                  Node:\';\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("E Node\'Foo\'            Node:children+=Node path:Node\'root\'/children[1]");
    _builder.newLine();
    _builder.append("19   2  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("2    \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("21 1    S \"}\"                  Node:\'}\'");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E Node\'root\'           Model");
    _builder.newLine();
    _builder.append("22 0   H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("9 1 H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("------------ diff 2 ------------");
    _builder.newLine();
    _builder.append("14 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("15 3  S \"Bar\"                Node:name=ID");
    _builder.newLine();
    _builder.append("18 0  H");
    _builder.newLine();
    _builder.append("18 1  S \";\"                  Node:\';\'");
    _builder.newLine();
    _builder.append("19 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildListInsertIntoEmpty() {
    final Procedure1<OptionalChildList> _function = (OptionalChildList it) -> {
      EList<MandatoryValue> _children = it.getChildren();
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("foo");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      _children.add(_doubleArrow);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChildList>recordDiff(OptionalChildList.class, "#13", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalChildList    Model");
    _builder.newLine();
    _builder.append("0 3    S \"#13\"                Model:\'#13\'");
    _builder.newLine();
    _builder.append("3 0 1  H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'foo\'  MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("3 3 1   S \"foo\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'foo\'  MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalChildList    Model");
    _builder.newLine();
    _builder.append("6 0 1 H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("3 0  H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildListInsertIntoEmpty2() {
    final Procedure1<OptionalChildList> _function = (OptionalChildList it) -> {
      EList<MandatoryValue> _children = it.getChildren();
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("foo");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      _children.add(_doubleArrow);
      EList<MandatoryValue> _children_1 = it.getChildren();
      MandatoryValue _createMandatoryValue_1 = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_2 = (MandatoryValue it_1) -> {
        it_1.setName("bar");
      };
      MandatoryValue _doubleArrow_1 = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue_1, _function_2);
      _children_1.add(_doubleArrow_1);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChildList>recordDiff(OptionalChildList.class, "#13", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalChildList    Model");
    _builder.newLine();
    _builder.append("0 3    S \"#13\"                Model:\'#13\'");
    _builder.newLine();
    _builder.append("3 0 1  H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'foo\'  MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("3 3 1   S \"foo\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'foo\'  MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("6 0 1  H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'bar\'  MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append("6 3 1   S \"bar\"                MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'bar\'  MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalChildList    Model");
    _builder.newLine();
    _builder.append("9 0 1 H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("3 0  H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildListInsertIntoFirst() {
    final Procedure1<OptionalChildList> _function = (OptionalChildList it) -> {
      EList<MandatoryValue> _children = it.getChildren();
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("x1");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      _children.add(0, _doubleArrow);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChildList>recordDiff(OptionalChildList.class, "#13 x2", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalChildList    Model");
    _builder.newLine();
    _builder.append("0 3    S \"#13\"                Model:\'#13\'");
    _builder.newLine();
    _builder.append("3 1 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'x1\'   MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("4 2 1   S \"x1\"                 MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'x1\'   MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("6 0 1  H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'x2\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append("6 2     S \"x2\"                 MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'x2\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalChildList    Model");
    _builder.newLine();
    _builder.append("8 0   H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("3 1 H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildListInsertIntoMiddle() {
    final Procedure1<OptionalChildList> _function = (OptionalChildList it) -> {
      EList<MandatoryValue> _children = it.getChildren();
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("x2");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      _children.add(1, _doubleArrow);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChildList>recordDiff(OptionalChildList.class, "#13 x1 x3", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B OptionalChildList    Model");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("0 3    S \"#13\"                Model:\'#13\'");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("3 1    H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("B MandatoryValue\'x1\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("4 2     S \"x1\"                 MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("E MandatoryValue\'x1\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("6 1 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("B MandatoryValue\'x2\'   MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("7 2 1   S \"x2\"                 MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("E MandatoryValue\'x2\'   MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("9 0 1  H");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("B MandatoryValue\'x3\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[2]");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("9 2     S \"x3\"                 MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("E MandatoryValue\'x3\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[2]");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E OptionalChildList    Model");
    _builder.newLine();
    _builder.append("11 0   H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("6 1  H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  @Test
  public void testOptionalChildListInsertIntoEnd() {
    final Procedure1<OptionalChildList> _function = (OptionalChildList it) -> {
      EList<MandatoryValue> _children = it.getChildren();
      MandatoryValue _createMandatoryValue = this.fac.createMandatoryValue();
      final Procedure1<MandatoryValue> _function_1 = (MandatoryValue it_1) -> {
        it_1.setName("x2");
      };
      MandatoryValue _doubleArrow = ObjectExtensions.<MandatoryValue>operator_doubleArrow(_createMandatoryValue, _function_1);
      _children.add(_doubleArrow);
    };
    ITextRegionAccess _recordDiff = this.<OptionalChildList>recordDiff(OptionalChildList.class, "#13 x1", _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0 0   H");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("B OptionalChildList    Model");
    _builder.newLine();
    _builder.append("0 3    S \"#13\"                Model:\'#13\'");
    _builder.newLine();
    _builder.append("3 1    H \" \"                  Whitespace:TerminalRule\'WS\'");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'x1\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("4 2     S \"x1\"                 MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'x1\'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]");
    _builder.newLine();
    _builder.append("6 0 1  H");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("B MandatoryValue\'x2\'   MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append("6 2 1   S \"x2\"                 MandatoryValue:name=ID");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("E MandatoryValue\'x2\'   MandatoryValue path:OptionalChildList/children[1]");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("E OptionalChildList    Model");
    _builder.newLine();
    _builder.append("8 0 1 H");
    _builder.newLine();
    _builder.append("------------ diff 1 ------------");
    _builder.newLine();
    _builder.append("6 0   H");
    _builder.newLine();
    this._changeSerializerTestHelper.operator_tripleEquals(_recordDiff, _builder);
  }
  
  private <T extends EObject> ITextRegionAccess recordDiff(final Class<T> modelType, final CharSequence modelText, final Procedure1<? super T> modification) {
    final InMemoryURIHandler fs = new InMemoryURIHandler();
    String _string = modelText.toString();
    Pair<String, String> _mappedTo = Pair.<String, String>of("inmemory:/file1.pstl", _string);
    this._changeSerializerTestHelper.operator_add(fs, _mappedTo);
    final ResourceSet rs = this._changeSerializerTestHelper.createResourceSet(fs);
    final T model = this._changeSerializerTestHelper.<T>contents(rs, "inmemory:/file1.pstl", modelType);
    final ChangeSerializer serializer = this.serializerProvider.get();
    serializer.beginRecordChanges(model.eResource());
    modification.apply(model);
    return this._changeSerializerTestHelper.endRecordChangesToTextRegions(serializer);
  }
}
