/**
 * Copyright (c) 2017, 2023 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalChildList;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.OptionalValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.WithTransientContainer;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(PartialSerializationTestLanguageInjectorProvider.class)
public class PartialSerializerTest {
	private PartialSerializationTestLanguageFactory fac = PartialSerializationTestLanguageFactory.eINSTANCE;

	@Inject
	private Provider<ChangeSerializer> serializerProvider;

	@Inject
	private ChangeSerializerTestHelper changeSerializerTestHelper;

	@Test
	public void testMandatoryValueChange() {
		ITextRegionAccess diff = recordDiff(MandatoryValue.class, "#2 foo", (MandatoryValue it) -> {
			it.setName("bar");
		});
		String expectation =
				"0 0   H\n" +
				"      B MandatoryValue'bar'  Model\n" +
				"0 2    S \"#2\"                 Model:'#2'\n" +
				"2 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"3 3 1  S \"bar\"                MandatoryValue:name=ID\n" +
				"      E MandatoryValue'bar'  Model\n" +
				"6 0   H\n" +
				"------------ diff 1 ------------\n" +
				"3 3 S \"foo\"                MandatoryValue:name=ID\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalValueInsert() {
		ITextRegionAccess diff = recordDiff(OptionalValue.class, "#3", (OptionalValue it) -> {
			it.setName("foo");
		});
		String expectation =
				"0 0 1 H\n" +
				"      B OptionalValue'foo'   Model\n" +
				"0 2 1  S \"#3\"                 Model:'#3'\n" +
				"2 0 1  H\n" +
				"2 3 1  S \"foo\"                OptionalValue:name=ID\n" +
				"      E OptionalValue'foo'   Model\n" +
				"5 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"0 0 H\n" +
				"0 2 S \"#3\"                 Model:'#3'\n" +
				"2 0 H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalValueChange() {
		ITextRegionAccess diff = recordDiff(OptionalValue.class, "#3 foo", (OptionalValue it) -> {
			it.setName("baz");
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalValue'baz'   Model\n" +
				"0 2    S \"#3\"                 Model:'#3'\n" +
				"2 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"3 3 1  S \"baz\"                OptionalValue:name=ID\n" +
				"      E OptionalValue'baz'   Model\n" +
				"6 0   H\n" +
				"------------ diff 1 ------------\n" +
				"3 3 S \"foo\"                OptionalValue:name=ID\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalValueRemove() {
		ITextRegionAccess diff = recordDiff(OptionalValue.class, "#3 foo", (OptionalValue it) -> {
			it.setName(null);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalValue        Model\n" +
				"0 2    S \"#3\"                 Model:'#3'\n" +
				"      E OptionalValue        Model\n" +
				"2 1 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 1 ------------\n" +
				"2 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"3 3  S \"foo\"                OptionalValue:name=ID\n" +
				"6 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testMandatoryChildChange() {
		ITextRegionAccess diff = recordDiff(MandatoryChild.class, "#4 foo", (MandatoryChild it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("baz");
			it.setChild(newMandatoryValue);
		});
		String expectation =
				"0 0   H\n" +
				"      B MandatoryChild       Model\n" +
				"0 2    S \"#4\"                 Model:'#4'\n" +
				"2 1 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'baz'  MandatoryValue path:MandatoryChild/child\n" +
				"3 3 1   S \"baz\"                MandatoryValue:name=ID\n" +
				"       E MandatoryValue'baz'  MandatoryValue path:MandatoryChild/child\n" +
				"      E MandatoryChild       Model\n" +
				"6 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"2 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"3 3  S \"foo\"                MandatoryValue:name=ID\n" +
				"6 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildInsert() {
		ITextRegionAccess diff = recordDiff(OptionalChild.class, "#5", (OptionalChild it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("baz");
			it.setChild(newMandatoryValue);
		});
		String expectation =
				"0 0 1 H\n" +
				"      B OptionalChild        Model\n" +
				"0 2 1  S \"#5\"                 Model:'#5'\n" +
				"2 0 1  H\n" +
				"       B MandatoryValue'baz'  OptionalChild:child=MandatoryValue path:OptionalChild/child\n" +
				"2 3 1   S \"baz\"                MandatoryValue:name=ID\n" +
				"       E MandatoryValue'baz'  OptionalChild:child=MandatoryValue path:OptionalChild/child\n" +
				"      E OptionalChild        Model\n" +
				"5 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"0 0 H\n" +
				"0 2 S \"#5\"                 Model:'#5'\n" +
				"2 0 H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildChange() {
		ITextRegionAccess diff = recordDiff(OptionalChild.class, "#5 foo", (OptionalChild it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("baz");
			it.setChild(newMandatoryValue);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChild        Model\n" +
				"0 2    S \"#5\"                 Model:'#5'\n" +
				"2 1 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'baz'  MandatoryValue path:OptionalChild/child\n" +
				"3 3 1   S \"baz\"                MandatoryValue:name=ID\n" +
				"       E MandatoryValue'baz'  MandatoryValue path:OptionalChild/child\n" +
				"      E OptionalChild        Model\n" +
				"6 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"2 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"3 3  S \"foo\"                MandatoryValue:name=ID\n" +
				"6 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildRemove() {
		ITextRegionAccess diff = recordDiff(OptionalChild.class, "#5 foo", (OptionalChild it) -> {
			it.setChild(null);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChild        Model\n" +
				"0 2    S \"#5\"                 Model:'#5'\n" +
				"      E OptionalChild        Model\n" +
				"2 1 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 1 ------------\n" +
				"2 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"3 3  S \"foo\"                MandatoryValue:name=ID\n" +
				"6 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testMoveInList1() {
		ITextRegionAccess diff = recordDiff(Node.class, "#1 root { Foo; Bar; }", (Node it) -> {
			it.getChildren().move(0, 1);
		});
		String expectation =
				"0 0   H\n" +
				"       B Node'root'           Model\n" +
				" 0 2    S \"#1\"                 Model:'#1'\n" +
				" 2 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				" 3 4    S \"root\"               Node:name=ID\n" +
				" 7 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				" 8 1    S \"{\"                  Node:'{'\n" +
				" 9 1 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"        B Node'Bar'            Node:children+=Node path:Node'root'/children[0]\n" +
				"10 3 1   S \"Bar\"                Node:name=ID\n" +
				"13 0 1   H\n" +
				"13 1 1   S \";\"                  Node:';'\n" +
				"        E Node'Bar'            Node:children+=Node path:Node'root'/children[0]\n" +
				"14 0 1  H\n" +
				"        B Node'Foo'            Node:children+=Node path:Node'root'/children[1]\n" +
				"14 3     S \"Foo\"                Node:name=ID\n" +
				"17 0     H\n" +
				"17 1     S \";\"                  Node:';'\n" +
				"        E Node'Foo'            Node:children+=Node path:Node'root'/children[1]\n" +
				"18   2  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"   2    \" \"                  Whitespace:TerminalRule'WS'\n" +
				"20 1    S \"}\"                  Node:'}'\n" +
				"       E Node'root'           Model\n" +
				"21 0   H\n" +
				"------------ diff 1 ------------\n" +
				" 9 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"10 3 S \"Foo\"                Node:name=ID\n" +
				"------------ diff 2 ------------\n" +
				"14 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"15 3  S \"Bar\"                Node:name=ID\n" +
				"18 0  H\n" +
				"18 1  S \";\"                  Node:';'\n" +
				"19 1  H \" \"                  Whitespace:TerminalRule'WS'\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildListInsertIntoEmpty() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13", (OptionalChildList it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("foo");
			it.getChildren().add(newMandatoryValue);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3 1  S \"#13\"                Model:'#13'\n" +
				"3 0 1  H\n" +
				"       B MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]\n" +
				"3 3 1   S \"foo\"                MandatoryValue:name=ID\n" +
				"       E MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]\n" +
				"      E OptionalChildList    Model\n" +
				"6 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"0 3  S \"#13\"                Model:'#13'\n" +
				"3 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildListInsertIntoEmpty2() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13", (OptionalChildList it) -> {
			MandatoryValue newMandatoryValue1 = fac.createMandatoryValue();
			newMandatoryValue1.setName("foo");
			it.getChildren().add(newMandatoryValue1);
			MandatoryValue newMandatoryValue2 = fac.createMandatoryValue();
			newMandatoryValue2.setName("bar");
			it.getChildren().add(newMandatoryValue2);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3 1  S \"#13\"                Model:'#13'\n" +
				"3 0 1  H\n" +
				"       B MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]\n" +
				"3 3 1   S \"foo\"                MandatoryValue:name=ID\n" +
				"       E MandatoryValue'foo'  MandatoryValue path:OptionalChildList/children[0]\n" +
				"6 0 1  H\n" +
				"       B MandatoryValue'bar'  MandatoryValue path:OptionalChildList/children[1]\n" +
				"6 3 1   S \"bar\"                MandatoryValue:name=ID\n" +
				"       E MandatoryValue'bar'  MandatoryValue path:OptionalChildList/children[1]\n" +
				"      E OptionalChildList    Model\n" +
				"9 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"0 3  S \"#13\"                Model:'#13'\n" +
				"3 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildListInsertIntoFirst() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 x2", (OptionalChildList it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("x1");
			it.getChildren().add(0, newMandatoryValue);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"3 1 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'x1'   MandatoryValue path:OptionalChildList/children[0]\n" +
				"4 2 1   S \"x1\"                 MandatoryValue:name=ID\n" +
				"       E MandatoryValue'x1'   MandatoryValue path:OptionalChildList/children[0]\n" +
				"6 0 1  H\n" +
				"       B MandatoryValue'x2'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]\n" +
				"6 2     S \"x2\"                 MandatoryValue:name=ID\n" +
				"       E MandatoryValue'x2'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]\n" +
				"      E OptionalChildList    Model\n" +
				"8 0   H\n" +
				"------------ diff 1 ------------\n" +
				"3 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"4 2 S \"x2\"                 MandatoryValue:name=ID\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildListInsertIntoMiddle() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 x1 x3", (OptionalChildList it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("x2");
			it.getChildren().add(1, newMandatoryValue);
		});
		String expectation =
				"0 0   H\n" +
				"       B OptionalChildList    Model\n" +
				" 0 3    S \"#13\"                Model:'#13'\n" +
				" 3 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"        B MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				" 4 2     S \"x1\"                 MandatoryValue:name=ID\n" +
				"        E MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				" 6 1 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"        B MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]\n" +
				" 7 2 1   S \"x2\"                 MandatoryValue:name=ID\n" +
				"        E MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]\n" +
				" 9 0 1  H\n" +
				"        B MandatoryValue'x3'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[2]\n" +
				" 9 2     S \"x3\"                 MandatoryValue:name=ID\n" +
				"        E MandatoryValue'x3'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[2]\n" +
				"       E OptionalChildList    Model\n" +
				"11 0   H\n" +
				"------------ diff 1 ------------\n" +
				" 6 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				" 7 2  S \"x3\"                 MandatoryValue:name=ID\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildListInsertIntoEndOne() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 x1", (OptionalChildList it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("x2");
			it.getChildren().add(newMandatoryValue);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"3 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"4 2 1   S \"x1\"                 MandatoryValue:name=ID\n" +
				"       E MandatoryValue'x1'   OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"6 0 1  H\n" +
				"       B MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]\n" +
				"6 2 1   S \"x2\"                 MandatoryValue:name=ID\n" +
				"       E MandatoryValue'x2'   MandatoryValue path:OptionalChildList/children[1]\n" +
				"      E OptionalChildList    Model\n" +
				"8 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"4 2   S \"x1\"                 MandatoryValue:name=ID\n" +
				"6 0   H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildListInsertIntoEndTwo() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 a", (OptionalChildList it) -> {
			MandatoryValue newMandatoryValue1 = fac.createMandatoryValue();
			newMandatoryValue1.setName("b");
			it.getChildren().add(newMandatoryValue1);
			MandatoryValue newMandatoryValue2 = fac.createMandatoryValue();
			newMandatoryValue2.setName("c");
			it.getChildren().add(newMandatoryValue2);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"3 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"4 1 1   S \"a\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"5 0 1  H\n" +
				"       B MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]\n" +
				"5 1 1   S \"b\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]\n" +
				"6 0 1  H\n" +
				"       B MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]\n" +
				"6 1 1   S \"c\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]\n" +
				"      E OptionalChildList    Model\n" +
				"7 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"4 1   S \"a\"                  MandatoryValue:name=ID\n" +
				"5 0   H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildListInsertIntoEndThree() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 a", (OptionalChildList it) -> {
			MandatoryValue newMandatoryValue1 = fac.createMandatoryValue();
			newMandatoryValue1.setName("b");
			it.getChildren().add(newMandatoryValue1);
			MandatoryValue newMandatoryValue2 = fac.createMandatoryValue();
			newMandatoryValue2.setName("c");
			it.getChildren().add(newMandatoryValue2);
			MandatoryValue newMandatoryValue3 = fac.createMandatoryValue();
			newMandatoryValue3.setName("d");
			it.getChildren().add(newMandatoryValue3);
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"3 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"4 1 1   S \"a\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"5 0 1  H\n" +
				"       B MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]\n" +
				"5 1 1   S \"b\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'b'    MandatoryValue path:OptionalChildList/children[1]\n" +
				"6 0 1  H\n" +
				"       B MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]\n" +
				"6 1 1   S \"c\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'c'    MandatoryValue path:OptionalChildList/children[2]\n" +
				"7 0 1  H\n" +
				"       B MandatoryValue'd'    MandatoryValue path:OptionalChildList/children[3]\n" +
				"7 1 1   S \"d\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'd'    MandatoryValue path:OptionalChildList/children[3]\n" +
				"      E OptionalChildList    Model\n" +
				"8 0 1 H\n" +
				"------------ diff 1 ------------\n" +
				"4 1   S \"a\"                  MandatoryValue:name=ID\n" +
				"5 0   H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildRemoveListAllOne() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 x1", (OptionalChildList it) -> {
			EcoreUtil.remove(it.getChildren().get(0));
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"      E OptionalChildList    Model\n" +
				"3 1 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 1 ------------\n" +
				"3 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"4 2  S \"x1\"                 MandatoryValue:name=ID\n" +
				"6 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildRemoveListAllTwo() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 a b", (OptionalChildList it) -> {
			EcoreUtil.remove(it.getChildren().get(1));
			EcoreUtil.remove(it.getChildren().get(0));
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"      E OptionalChildList    Model\n" +
				"3   2 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"  2   \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 1 ------------\n" +
				"3 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"4 1 S \"a\"                  MandatoryValue:name=ID\n" +
				"5 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 2 ------------\n" +
				"5 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"6 1  S \"b\"                  MandatoryValue:name=ID\n" +
				"7 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildRemoveListFirstTwo() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 a b c", (OptionalChildList it) -> {
			EcoreUtil.remove(it.getChildren().get(1));
			EcoreUtil.remove(it.getChildren().get(0));
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"3   2  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       \" \"                  Whitespace:TerminalRule'WS'\n" +
				"  3    \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'c'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"6 1     S \"c\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'c'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"      E OptionalChildList    Model\n" +
				"7 0   H\n" +
				"------------ diff 1 ------------\n" +
				"3 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"4 1 S \"a\"                  MandatoryValue:name=ID\n" +
				"5 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 2 ------------\n" +
				"5 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"6 1 S \"b\"                  MandatoryValue:name=ID\n" +
				"7 1 H \" \"                  Whitespace:TerminalRule'WS'\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildRemoveListLastTwo() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 a b c", (OptionalChildList it) -> {
			EcoreUtil.remove(it.getChildren().get(2));
			EcoreUtil.remove(it.getChildren().get(1));
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"3 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"4 1     S \"a\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"      E OptionalChildList    Model\n" +
				"5   2 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"  2   \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 1 ------------\n" +
				"5 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"6 1  S \"b\"                  MandatoryValue:name=ID\n" +
				"7 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 2 ------------\n" +
				"7 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"8 1  S \"c\"                  MandatoryValue:name=ID\n" +
				"9 0  H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testOptionalChildRemoveListMiddleTwo() {
		ITextRegionAccess diff = recordDiff(OptionalChildList.class, "#13 a b c d", (OptionalChildList it) -> {
			EcoreUtil.remove(it.getChildren().get(2));
			EcoreUtil.remove(it.getChildren().get(1));
		});
		String expectation =
				"0 0   H\n" +
				"      B OptionalChildList    Model\n" +
				"0 3    S \"#13\"                Model:'#13'\n" +
				"3 1    H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"4 1     S \"a\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'a'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[0]\n" +
				"5   2  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       \" \"                  Whitespace:TerminalRule'WS'\n" +
				"  3    \" \"                  Whitespace:TerminalRule'WS'\n" +
				"       B MandatoryValue'd'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]\n" +
				"8 1     S \"d\"                  MandatoryValue:name=ID\n" +
				"       E MandatoryValue'd'    OptionalChildList:children+=MandatoryValue path:OptionalChildList/children[1]\n" +
				"      E OptionalChildList    Model\n" +
				"9 0   H\n" +
				"------------ diff 1 ------------\n" +
				"5 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"6 1  S \"b\"                  MandatoryValue:name=ID\n" +
				"7 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"------------ diff 2 ------------\n" +
				"7 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"8 1 S \"c\"                  MandatoryValue:name=ID\n" +
				"9 1 H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"\t\t";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	@Test
	public void testTransientValueChange() {
		ITextRegionAccess diff = recordDiff(WithTransientContainer.class, "#30 foo", (WithTransientContainer it) -> {
			it.getChild().setPackageName("bar");
		});
		String expectation =
				"0 0 H\n" +
				"    B WithTransientContainer Model\n" +
				"0 3  S \"#30\"                Model:'#30'\n" +
				"3 1  H \" \"                  Whitespace:TerminalRule'WS'\n" +
				"     B WithTransient'foo'   WithTransientContainer:child=WithTransient path:WithTransientContainer/child\n" +
				"4 3   S \"foo\"                WithTransient:name=ID\n" +
				"     E WithTransient'foo'   WithTransientContainer:child=WithTransient path:WithTransientContainer/child\n" +
				"    E WithTransientContainer Model\n" +
				"7 0 H\n";
		changeSerializerTestHelper.operator_tripleEquals(diff, expectation);
	}

	private <T extends EObject> ITextRegionAccess recordDiff(Class<T> modelType, String modelText,
			IChangeSerializer.IModification<T> modification) {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", modelText));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		T model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", modelType);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model, modification);
		return changeSerializerTestHelper.endRecordChangesToTextRegions(serializer);
	}
}
