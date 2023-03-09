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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.EClassRef;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
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
@InjectWith(PartialSerializationTestLanguageInjectorProviderWithEmf.class)
public class ChangeSerializerWithEmfTest {
	@Inject
	private Provider<ChangeSerializer> serializerProvider;

	@Inject
	private ChangeSerializerTestHelper changeSerializerTestHelper;

	@Test
	public void testChangeRefToXML() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#21 MyPackage.MyClass1"));
		String ecore =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">\n" +
				"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass1\" eSuperTypes=\"#//MyClass2\"/>\n" +
				"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass2\"/>\n" +
				"</ecore:EPackage>\n";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file2.ecore", ecore));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		EClassRef model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl",
				EClassRef.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model, (EClassRef it) -> {
			model.setRef(((EClass) model.getRef().getEPackage().getEClassifiers().get(1)));
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#21 <4:18|MyPackage.MyClass2>\n" +
				"--------------------------------------------------------------------------------\n" +
				"4 18 \"MyPackage.MyClass1\" -> \"MyPackage.MyClass2\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testChangeInXML() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#21 MyPackage.MyClass1"));
		String ecore =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">\n" +
				"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass1\"/>\n" +
				"</ecore:EPackage>\n";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file2.ecore", ecore));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		EPackage model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file2.ecore",
				EPackage.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model, (EPackage it) -> {
			((EClass) model.getEClassifiers().get(0)).setName("NewClass");
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"---------------------------- inmemory:/file2.ecore -----------------------------\n" +
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">\n" +
				"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"NewClass\"/>\n" +
				"</ecore:EPackage>\n" +
				"--------------------------------------------------------------------------------\n" +
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#21 <4:18|MyPackage.NewClass>\n" +
				"--------------------------------------------------------------------------------\n" +
				"4 18 \"MyPackage.MyClass1\" -> \"MyPackage.NewClass\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}

	@Test
	public void testChangeInDSL() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#20 DslEClass"));
		String ecore =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">\n" +
				"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass1\" eSuperTypes=\"inmemory:/file1.pstl#//@clazz.0\"/>\n" +
				"</ecore:EPackage>\n";
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file2.ecore", ecore));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Model model = changeSerializerTestHelper.findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Model.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.getClazz().get(0).setName("ChangedName");
			EClass newEClass = EcoreFactory.eINSTANCE.createEClass();
			newEClass.setName("NewName");
			model.getClazz().add(0, newEClass);
			Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#20 <4:0|NewName ><4:9| ChangedName>\n" +
				"--------------------------------------------------------------------------------\n" +
				"4 0 \"\" -> \"NewName \"\n" +
				"4 9 \"DslEClass\" -> \" ChangedName\"\n" +
				"---------------------------- inmemory:/file2.ecore -----------------------------\n" +
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"    xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"MyPackage\">\n" +
				"  <eClassifiers xsi:type=\"ecore:EClass\" name=\"MyClass1\" eSuperTypes=\"file1.pstl#//@clazz.1\"/>\n" +
				"</ecore:EPackage>\n" +
				"--------------------------------------------------------------------------------\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}
}
