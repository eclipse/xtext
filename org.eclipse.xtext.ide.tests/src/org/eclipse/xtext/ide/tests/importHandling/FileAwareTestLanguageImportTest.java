/**
 * Copyright (c) 2017, 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.importHandling;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.testlanguages.fileAware.ide.tests.FileAwareTestLanguageIdeInjectorProvider;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FileAwareTestLanguageIdeInjectorProvider.class)
public class FileAwareTestLanguageImportTest {
	@Inject
	private Provider<ChangeSerializer> serializerProvider;

	@Inject
	private ImportTestHelper importTestHelper;

	@Test
	public void testRenameGlobal1() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content1 =
				"package pkg1\n" +
				"\n" +
				"element Foo {\n" +
				"}\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/file1.fileawaretestlanguage", content1));
		String content2 =
				"package pkg2\n" +
				"\n" +
				"import pkg1.Foo\n" +
				"\n" +
				"element Bar {\n" +
				"	ref Foo\n" +
				"}\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/file2.fileawaretestlanguage", content2));
		ResourceSet rs = importTestHelper.createResourceSet(fs);
		PackageDeclaration model = importTestHelper.contents(rs, "inmemory:/file1.fileawaretestlanguage",
				PackageDeclaration.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model, (PackageDeclaration it) -> {
			it.setName("newpackage");
		});
		Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		Collection<IEmfResourceChange> changes = importTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"-------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ---------\n" +
				"package <8:4|newpackage>\n" +
				"\n" +
				"element Foo {\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"8 4 \"pkg1\" -> \"newpackage\"\n" +
				"-------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ---------\n" +
				"package pkg2\n" +
				"\n" +
				"import <21:8|newpackage.Foo>\n" +
				"\n" +
				"element Bar {\n" +
				"	ref Foo\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"21 8 \"pkg1.Foo\" -> \"newpackage.Foo\"\n";
		importTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testMoveToNewPackage() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content1 =
				"package pkg1\n" +
				"\n" +
				"element Foo {\n" +
				"}\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/file1.fileawaretestlanguage", content1));
		String content2 =
				"package pkg1\n" +
				"\n" +
				"element Bar {\n" +
				"	ref Foo\n" +
				"}\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/file2.fileawaretestlanguage", content2));
		ResourceSet rs = importTestHelper.createResourceSet(fs);
		PackageDeclaration model = importTestHelper.contents(rs, "inmemory:/file1.fileawaretestlanguage",
				PackageDeclaration.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model, (PackageDeclaration it) -> {
			it.setName("newpackage");
		});
		Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		Collection<IEmfResourceChange> changes = importTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"-------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ---------\n" +
				"package <8:4|newpackage>\n" +
				"\n" +
				"element Foo {\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"8 4 \"pkg1\" -> \"newpackage\"\n" +
				"-------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ---------\n" +
				"package pkg1\n" +
				"\n" +
				"<14:0|import newpackage.Foo\n" +
				"\n" +
				">element Bar {\n" +
				"	ref Foo\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"14 0 \"\" -> \"import newpackage...\"\n";
		importTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testMoveIntoLocalPackage() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content1 =
				"package other\n" +
				"\n" +
				"element Foo {\n" +
				"}\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/file1.fileawaretestlanguage", content1));
		String content2 =
				"package pkg1\n" +
				"\n" +
				"import other.Foo\n" +
				"\n" +
				"element Bar {\n" +
				"	ref Foo\n" +
				"}\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/file2.fileawaretestlanguage", content2));
		ResourceSet rs = importTestHelper.createResourceSet(fs);
		PackageDeclaration model = importTestHelper.contents(rs, "inmemory:/file1.fileawaretestlanguage",
				PackageDeclaration.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model, (PackageDeclaration it) -> {
			it.setName("pkg1");
		});
		Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		Collection<IEmfResourceChange> changes = importTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"-------- inmemory:/file1.fileawaretestlanguage (syntax: <offset|text>) ---------\n" +
				"package <8:5|pkg1>\n" +
				"\n" +
				"element Foo {\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"8 5 \"other\" -> \"pkg1\"\n" +
				"-------- inmemory:/file2.fileawaretestlanguage (syntax: <offset|text>) ---------\n" +
				"package pkg1\n" +
				"\n" +
				"<14:18|>element Bar {\n" +
				"	ref Foo\n" +
				"}\n" +
				"--------------------------------------------------------------------------------\n" +
				"14 18 \"import other.Foo\\n" +
				"\\n" +
				"\" -> \"\"\n";
		importTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testNestedPackage() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		String content1 =
				"package foo \n" +
				"element X {}\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/foo/X.fileawaretestlanguage", content1));
		String content2 =
				"package foo.bar \n" +
				"element Y { ref foo.X }\n";
		importTestHelper.operator_add(fs, Pair.of("inmemory:/foo/bar/Y.fileawaretestlanguage", content2));
		ResourceSet rs = importTestHelper.createResourceSet(fs);
		PackageDeclaration model1 = importTestHelper.contents(rs, "inmemory:/foo/X.fileawaretestlanguage",
				PackageDeclaration.class);
		PackageDeclaration model2 = importTestHelper.contents(rs, "inmemory:/foo/bar/Y.fileawaretestlanguage",
				PackageDeclaration.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model1, (PackageDeclaration it) -> {
			it.setName("foo2");
		});
		serializer.addModification(model2, (PackageDeclaration it) -> {
			it.setName("foo2.bar"); // was this way in the original test
			it.setName("foo2.bar");
		});
		Collection<IEmfResourceChange> changes = importTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"-------- inmemory:/foo/X.fileawaretestlanguage (syntax: <offset|text>) ---------\n" +
				"package <8:3|foo2> \n" +
				"element X {}\n" +
				"--------------------------------------------------------------------------------\n" +
				"8 3 \"foo\" -> \"foo2\"\n" +
				"------ inmemory:/foo/bar/Y.fileawaretestlanguage (syntax: <offset|text>) -------\n" +
				"package <8:7|foo2.bar> \n" +
				"<17:0|import foo2.X\n" +
				"\n" +
				">element Y { ref <33:5|X> }\n" +
				"--------------------------------------------------------------------------------\n" +
				" 8 7 \"foo.bar\" -> \"foo2.bar\"\n" +
				"17 0 \"\" -> \"import foo2.X\\n" +
				"\\n" +
				"\"\n" +
				"33 5 \"foo.X\" -> \"X\"\n";
		importTestHelper.operator_tripleEquals(changes, expectation);
	}
}
