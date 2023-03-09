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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialSerializationTestLanguageInjectorProvider;
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
@InjectWith(PartialSerializationTestLanguageInjectorProvider.class)
public class ChangeSerializerWithImportsTest {
	@Inject
	private Provider<ChangeSerializer> serializerProvider;

	@Inject
	private ChangeSerializerTestHelper changeSerializerTestHelper;

	@Test
	public void testRenameGlobal1() {
		InMemoryURIHandler fs = new InMemoryURIHandler();
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file1.pstl", "#1 root1 { child1; }"));
		changeSerializerTestHelper.operator_add(fs, Pair.of("inmemory:/file2.pstl", "#1 import root1.child1 refs child1;"));
		ResourceSet rs = changeSerializerTestHelper.createResourceSet(fs);
		Node model = changeSerializerTestHelper.<Node>findFirstOfTypeInFile(rs, "inmemory:/file1.pstl", Node.class);
		ChangeSerializer serializer = serializerProvider.get();
		serializer.addModification(model.eResource(), (Resource it) -> {
			model.getChildren().get(0).setName("newchild");
			Assert.assertEquals(1, model.eResource().getResourceSet().getResources().size());
		});
		Collection<IEmfResourceChange> changes = changeSerializerTestHelper.endRecordChangesToTextDocuments(serializer);
		String expectation =
				"----------------- inmemory:/file1.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 root1 { <11:6|newchild>; }\n" +
				"--------------------------------------------------------------------------------\n" +
				"11 6 \"child1\" -> \"newchild\"\n" +
				"----------------- inmemory:/file2.pstl (syntax: <offset|text>) -----------------\n" +
				"#1 import <10:12|root1.newchild> refs <28:6|newchild>;\n" +
				"--------------------------------------------------------------------------------\n" +
				"10 12 \"root1.child1\" -> \"root1.newchild\"\n" +
				"28  6 \"child1\" -> \"newchild\"\n";
		changeSerializerTestHelper.operator_tripleEquals(changes, expectation);
	}
}
