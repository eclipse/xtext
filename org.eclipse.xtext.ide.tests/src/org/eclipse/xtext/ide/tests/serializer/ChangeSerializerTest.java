/**
 * Copyright (c) 2017, 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.serializer;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.ChildWithSubChilds;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguageFactory;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.SubChild;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(PartialSerializationTestLanguageInjectorProvider.class)
public class ChangeSerializerTest {
	@Extension
	private PartialSerializationTestLanguageFactory fac = PartialSerializationTestLanguageFactory.eINSTANCE;

	@Inject
	private ChangeSerializerTestHelper changeSerializerTestHelper;

	@Test
	public void testNoop() {
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		changeSerializerTestHelper.operator_tripleEquals(changes, "");
	}

	@Test
	public void testSimple() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#2 foo"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		MandatoryValue model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl",
				MandatoryValue.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.setName("bar");
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#2 <3:3|bar>\n" +
				"--------------------------------------------------------------------------------\n" +
				"3 3 \"foo\" -> \"bar\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testTwoChildren() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#1 root { foo1; foo2; }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.getChildren().get(0).setName("bazz4");
			model.getChildren().get(1).setName("bazz5");
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root { <10:4|bazz4>; <16:4|bazz5>; }\n" +
				"--------------------------------------------------------------------------------\n" +
				"10 4 \"foo1\" -> \"bazz4\"\n" +
				"16 4 \"foo2\" -> \"bazz5\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testInsertOneChild() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#1 root { child1 { foo1; } }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			Node newNode = fac.createNode();
			newNode.setName("bazz");
			model.getChildren().get(0).getChildren().add(newNode);
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root { child1 { foo1; <25:0|bazz; >} }\n" +
				"--------------------------------------------------------------------------------\n" +
				"25 0 \"\" -> \"bazz; \"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testInsertBeforeComment() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content = "#1 root {\n" +
				"	/**/ \n" +
				"	child1;\n" +
				"}\n";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			Node newNode = fac.createNode();
			newNode.setName("bazz");
			model.getChildren().add(0, newNode);
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root {<9:0| bazz;>\n" +
				"	/**/ \n" +
				"	child1;\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"9 0 \"\" -> \" bazz;\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testInsertTwoChild() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#1 root { child1 { foo1; } }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			Node newNode1 = fac.createNode();
			newNode1.setName("bazz1");
			model.getChildren().get(0).getChildren().add(newNode1);
			Node newNode2 = fac.createNode();
			newNode2.setName("bazz2");
			model.getChildren().get(0).getChildren().add(newNode2);
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root { child1 { foo1; <25:0|bazz1; bazz2; >} }\n" +
				"--------------------------------------------------------------------------------\n" +
				"25 0 \"\" -> \"bazz1; bazz2; \"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testDeleteChild() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#1 root { child1 { foo1; } }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			EcoreUtil.remove(model.getChildren().get(0).getChildren().get(0));
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root { child1 { <19:5|> } }\n" +
				"--------------------------------------------------------------------------------\n" +
				"19 5 \"foo1;\" -> \"\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testDeleteTwoChildren() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#1 root { child1; child2; }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			EcoreUtil.remove(model.getChildren().get(1));
			EcoreUtil.remove(model.getChildren().get(0));
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root { <10:7|> <18:7|> }\n" +
				"--------------------------------------------------------------------------------\n" +
				"10 7 \"child1;\" -> \"\"\n" +
				"18 7 \"child2;\" -> \"\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testRenameLocal() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs,
				Pair.of("inmemory:/file1.pstl", "#1 root { foo1; foo2 { ref foo1 } }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.getChildren().get(0).setName("bazz4");
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root { <10:4|bazz4>; foo2 { ref <27:4|bazz4> } }\n" +
				"--------------------------------------------------------------------------------\n" +
				"10 4 \"foo1\" -> \"bazz4\"\n" +
				"27 4 \"foo1\" -> \"bazz4\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testRenameGlobal1() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#1 root1;"));
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file2.pstl", "#1 root2 { ref root1 }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.setName("newroot");
		});
		Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 <3:5|newroot>;\n" +
				"--------------------------------------------------------------------------------\n" +
				"3 5 \"root1\" -> \"newroot\"\n" +
				"----------------- inmemory:/file2.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root2 { ref <15:5|newroot> }\n" +
				"--------------------------------------------------------------------------------\n" +
				"15 5 \"root1\" -> \"newroot\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testRenameFqn1() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content =
				"#1 r {\n" +
				"	X refs a1.a2 X.a1.a2 r.X.a1.a2 { a1 { a2 refs a2 { a3 { ref a3 } } } }\n" +
				"	Y refs b1.b2 Y.b1.b2 r.Y.b1.b2 { b1 { b2 { ref b2 } } }\n" +
				"}\n";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			Node node = model.getChildren().get(0).getChildren().get(0).getChildren().get(0);
			node.setName("b");
		});
		Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 r {\n" +
				"	X refs <15:5|a1.b> <21:7|a1.b> <29:9|a1.b> { a1 { <46:2|b> refs <54:2|b> { a3 { ref a3 } } } }\n" +
				"	Y refs b1.b2 Y.b1.b2 r.Y.b1.b2 { b1 { b2 { ref b2 } } }\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"15 5 \"a1.a2\" -> \"a1.b\"\n" +
				"21 7 \"X.a1.a2\" -> \"a1.b\"\n" +
				"29 9 \"r.X.a1.a2\" -> \"a1.b\"\n" +
				"46 2 \"a2\" -> \"b\"\n" +
				"54 2 \"a2\" -> \"b\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testRenameFqn1ValueConversion() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content =
				"#1 r {\n" +
				"	X refs ^a1.^a2 ^X.^a1.^a2 ^r.^X.^a1.^a2 { a1 { a2 refs ^a2 { a3 { ref ^a3 } } } }\n" +
				"	Y refs ^b1.^b2 ^Y.^b1.^b2 ^r.^Y.^b1.^b2 { b1 { b2 { ref b2 } } }\n" +
				"}\n";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			Node node = model.getChildren().get(0).getChildren().get(0).getChildren().get(0);
			node.setName("b");
		});
		Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 r {\n" +
				"	X refs <15:7|a1.b> <23:10|a1.b> <34:13|a1.b> { a1 { <55:2|b> refs <63:3|b> { a3 { ref ^a3 } } } }\n" +
				"	Y refs ^b1.^b2 ^Y.^b1.^b2 ^r.^Y.^b1.^b2 { b1 { b2 { ref b2 } } }\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"15  7 \"^a1.^a2\" -> \"a1.b\"\n" +
				"23 10 \"^X.^a1.^a2\" -> \"a1.b\"\n" +
				"34 13 \"^r.^X.^a1.^a2\" -> \"a1.b\"\n" +
				"55  2 \"a2\" -> \"b\"\n" +
				"63  3 \"^a2\" -> \"b\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testResourceURIChange() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/f.pstl", "#1 root { }"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/f.pstl", Node.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.eResource().setURI(URI.createURI("inmemory:/x.pstl"));
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----- renamed inmemory:/f.pstl to inmemory:/x.pstl (syntax: <offset|text>) -----\n" +
				"(no changes)\n" +
				"--------------------------------------------------------------------------------\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testAddChildElement() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content =
				"#22 {\n" +
				"	child1\n" +
				"	children1 {\n" +
				"		child2 child3\n" +
				"	}\n" +
				"}";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file-move.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		TwoChildLists model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file-move.pstl",
				TwoChildLists.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			MandatoryValue newMandatoryValue = fac.createMandatoryValue();
			newMandatoryValue.setName("newChild");
			model.getDirectChildren().add(newMandatoryValue);
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"--------------- inmemory:/file-move.pstl (syntax: <offset|text>) ---------------\n" +
				"#22 {\n" +
				"	child1<13:0| newChild>\n" +
				"	children1 {\n" +
				"		child2 child3\n" +
				"	}\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"13 0 \"\" -> \" newChild\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testMoveElement() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content =
				"#22 {\n" +
				"	child1\n" +
				"	children1 {\n" +
				"		child2 jumper\n" +
				"	}\n" +
				"}";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file-move1.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		TwoChildLists model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file-move1.pstl",
				TwoChildLists.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.getDirectChildren().add(IterableExtensions.findFirst(model.getChildsList().getChildren(),
					(MandatoryValue v) -> "jumper".equals(v.getName())));
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"-------------- inmemory:/file-move1.pstl (syntax: <offset|text>) ---------------\n" +
				"#22 {\n" +
				"	child1<13:0| jumper>\n" +
				"	children1 {\n" +
				"		child2 <36:6|>\n" +
				"	}\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"13 0 \"\" -> \" jumper\"\n" +
				"36 6 \"jumper\" -> \"\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testMoveElement_2() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content =
				"#22 {\n" +
				"	child1\n" +
				"	children1 {\n" +
				"		child2 jumper\n" +
				"	}\n" +
				"}";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file-move.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		TwoChildLists model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file-move.pstl",
				TwoChildLists.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.getDirectChildren().add(0, IterableExtensions.findFirst(model.getChildsList().getChildren(),
					(MandatoryValue v) -> "jumper".equals(v.getName())));
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"--------------- inmemory:/file-move.pstl (syntax: <offset|text>) ---------------\n" +
				"#22 {<5:0| jumper>\n" +
				"	child1\n" +
				"	children1 {\n" +
				"		child2 <36:6|>\n" +
				"	}\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				" 5 0 \"\" -> \" jumper\"\n" +
				"36 6 \"jumper\" -> \"\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testMoveElement_2a() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content = "#22 {\n" +
				"	child1 child3\n" +
				"	children1 {\n" +
				"		child2 jumper\n" +
				"	}\n" +
				"}";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file-move2a.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		TwoChildLists model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file-move2a.pstl",
				TwoChildLists.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.getDirectChildren().add(1, IterableExtensions.findFirst(model.getChildsList().getChildren(),
					(MandatoryValue v) -> "jumper".equals(v.getName())));
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"-------------- inmemory:/file-move2a.pstl (syntax: <offset|text>) --------------\n" +
				"#22 {\n" +
				"	child1 <14:0|jumper >child3\n" +
				"	children1 {\n" +
				"		child2 <43:6|>\n" +
				"	}\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"14 0 \"\" -> \"jumper \"\n" +
				"43 6 \"jumper\" -> \"\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testMoveElement_3() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content = "#24 direct:\n" +
				"	child:jumper\n";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file-move3.pstl", content));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		TwoChilds model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file-move3.pstl",
				TwoChilds.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.setDirectChild(model.getOptChild().getChild());
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"-------------- inmemory:/file-move3.pstl (syntax: <offset|text>) ---------------\n" +
				"<0:26|#24 direct:\n" +
				"	jumper\n" +
				"child :>\n" +
				"--------------------------------------------------------------------------------\n" +
				"0 26 \"#24 direct:\\n" +
				"	chil...\" -> \"#24 direct:\\n" +
				"	jump...\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testAddElements() {
		String uri = "inmemory:/file-add.pstl";
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of(uri, "#23"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		ChildWithSubChilds model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, uri, ChildWithSubChilds.class);
		IChangeSerializer serializer = changeSerializerTestHelper.newChangeSerializer();
		serializer.addModification(model.eResource(), (Resource it) -> {
			ChildWithSubChild newChildWithSubChild = fac.createChildWithSubChild();
			SubChild newSubChild1 = fac.createSubChild();
			newSubChild1.setName("A");
			newChildWithSubChild.getSubChilds().add(newSubChild1);
			model.getChildren().add(newChildWithSubChild);
			SubChild newSubChild = fac.createSubChild();
			newSubChild.setName("A2");
			model.getChildren().get(0).getSubChilds().add(newSubChild);
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"--------------- inmemory:/file-add.pstl (syntax: <offset|text>) ----------------\n" +
				"<0:3|#23 subs A A2>\n" +
				"--------------------------------------------------------------------------------\n" +
				"0 3 \"#23\" -> \"#23 subs A A2\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}
}
