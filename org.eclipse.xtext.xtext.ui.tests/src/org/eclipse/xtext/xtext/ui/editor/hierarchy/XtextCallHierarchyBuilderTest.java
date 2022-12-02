/**
 * Copyright (c) 2016, 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ui.editor.hierarchy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ui.testing.AbstractHierarchyBuilderTest;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyBuilder;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ui.XtextInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author kosyakov - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class XtextCallHierarchyBuilderTest extends AbstractHierarchyBuilderTest {
	@Inject
	private Provider<XtextCallHierarchyBuilder> callHierarchyBuilderProvider;

	@Override
	protected void testBuildHierarchy(Procedure1<? super AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> configurator) {
		super.testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			it.setHierarchyBuilderProvider((ResourceSet resourceSet) -> {
				XtextCallHierarchyBuilder callHierarchyBuilder = configureBuilderWith(callHierarchyBuilderProvider.get(), resourceSet);
				callHierarchyBuilder.setHierarchyType(ICallHierarchyBuilder.CallHierarchyType.CALLER);
				return callHierarchyBuilder;
			});
			configurator.apply(it);
		});
	}

	protected void testBuildCalleeHierarchy(
			Procedure1<? super AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration> configurator) {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			it.setHierarchyBuilderProvider((ResourceSet resourceSet) -> {
				XtextCallHierarchyBuilder callHierarchyBuilder = configureBuilderWith(callHierarchyBuilderProvider.get(), resourceSet);
				callHierarchyBuilder.setHierarchyType(ICallHierarchyBuilder.CallHierarchyType.CALLEE);
				return callHierarchyBuilder;
			});
			configurator.apply(it);
		});
	}

	@Test
	public void testBuildHierarchy_01() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model:\n" +
				"	element+=Element*\n" +
				";\n" +
				"\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model));
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().indexOf("Element*"));
			String expectedHierarchy =
				"Element {\n" +
				"	grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"	Model {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'element+=Element*' [250, 17]\n" +
				"	}\n" +
				"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Test
	public void testBuildCalleeHierarchy_01() {
		testBuildCalleeHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model:\n" +
				"	element+=Element*\n" +
				";\n" +
				"\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model));
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().indexOf("Model"));
			String expectedHierarchy =
				"Model {\n" +
				"	grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"	Element {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'element+=Element*' [250, 17]\n" +
				"		ID {\n" +
				"			grammar: org.eclipse.xtext.common.Terminals\n" +
				"			'name=ID' [281, 7]\n" +
				"		}\n" +
				"	}\n" +
				"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Test
	public void testBuildHierarchy_02() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model:\n" +
				"	element+=AbstractElement*\n" +
				";\n" +
				"\n" +
				"AbstractElement:\n" +
				"	Element |\n" +
				"	'(' Model ')'\n" +
				";\n" +
				"\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model));
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().indexOf("AbstractElement*"));
			String expectedHierarchy =
				"AbstractElement {\n" +
				"	grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"	Model {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'element+=AbstractElement*' [250, 25]\n" +
				"		AbstractElement {\n" +
				"			grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"			'Model' [312, 5]\n" +
				"		}\n" +
				"	}\n" +
				"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Test
	public void testBuildHierarchy_03() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model:\n" +
				"	element+=Element element+=Element element+=Element\n" +
				";\n" +
				"\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model));
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().lastIndexOf("Element"));
			String expectedHierarchy =
				"Element {\n" +
				"	grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"	Model {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'element+=Element' [250, 16]\n" +
				"		'element+=Element' [267, 16]\n" +
				"		'element+=Element' [284, 16]\n" +
				"	}\n" +
				"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Test
	public void testBuildHierarchy_04() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model1 =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals hidden(ID)\n" +
				"\n" +
				"generate baseCallHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model: name=ID;\n";
			it.getModels().add(Pair.of("baseCallHierarchyBuilderTestLanguage.xtext", model1));
			String model2 =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"@Override\n" +
				"Model: name=ID;\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model2));
			it.setResourceURI(Iterables.getFirst(it.getModels(), null).getKey());
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().indexOf("ID"));
			String expectedHierarchy =
				"ID {\n" +
				"	grammar: org.eclipse.xtext.common.Terminals\n" +
				"	org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage\n" +
				"		'ID' [136, 2]\n" +
				"	}\n" +
				"	Model {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage\n" +
				"		'name=ID' [272, 7]\n" +
				"	}\n" +
				"	Model {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'name=ID' [305, 7]\n" +
				"	}\n" +
				"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Test
	public void testBuildHierarchy_05() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate baseCallHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model: name=ID;\n";
			it.getModels().add(Pair.of("baseCallHierarchyBuilderTestLanguage.xtext", model));
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().indexOf("BaseCallHierarchyBuilderTestLanguage"));
			it.setExpectedHierarchy("");
		});
	}

	@Test
	public void testBuildHierarchy_06() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model1 =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate baseCallHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model: \n" +
				"	elements+=Element*\n" +
				";\n" +
				"\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("baseCallHierarchyBuilderTestLanguage.xtext", model1));
			String model2 =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model2:\n" +
				"	elements+=Element*\n" +
				";\n" +
				"\n" +
				"@Override\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model2));
			it.setResourceURI(Iterables.getFirst(it.getModels(), null).getKey());
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().indexOf("Element"));
			String expectedHierarchy =
				"Element {\n" +
				"	grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"	Model {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage\n" +
				"		'elements+=Element*' [263, 18]\n" +
				"	}\n" +
				"	Model2 {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'elements+=Element*' [297, 18]\n" +
				"	}\n" +
				"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Test
	public void testBuildHierarchy_07() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model1 =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate baseCallHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model: \n" +
				"	elements+=Element*\n" +
				";\n" +
				"\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("baseCallHierarchyBuilderTestLanguage.xtext", model1));
			String model2 =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model2:\n" +
				"	elements+=Element*\n" +
				";\n" +
				"\n" +
				"@Override\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model2));
			it.setResourceURI(Iterables.getLast(it.getModels()).getKey());
			it.setIndex(Iterables.getLast(it.getModels()).getValue().indexOf("Element"));
			String expectedHierarchy =
					"Element {\n" +
					"	grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
					"	Model {\n" +
					"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage\n" +
					"		'elements+=Element*' [263, 18]\n" +
					"	}\n" +
					"	Model2 {\n" +
					"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
					"		'elements+=Element*' [297, 18]\n" +
					"	}\n" +
					"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Test
	public void testBuildHierarchy_08() {
		testBuildHierarchy((AbstractHierarchyBuilderTest.HierarchyBuilderTestConfiguration it) -> {
			String model =
				"grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"generate callHierarchyBuilderTestLanguage 'http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage'\n" +
				"\n" +
				"Model:\n" +
				"	elements+=[Element]\n" +
				"	elements+=[Element|ID]\n" +
				";\n" +
				"\n" +
				"Element:\n" +
				"	name=ID\n" +
				";\n";
			it.getModels().add(Pair.of("callHierarchyBuilderTestLanguage.xtext", model));
			it.setIndex(Iterables.getFirst(it.getModels(), null).getValue().lastIndexOf("ID"));
			String expectedHierarchy =
				"ID {\n" +
				"	grammar: org.eclipse.xtext.common.Terminals\n" +
				"	Model {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'elements+=[Element]' [250, 19]\n" +
				"		'elements+=[Element|ID]' [271, 22]\n" +
				"	}\n" +
				"	Element {\n" +
				"		grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage\n" +
				"		'name=ID' [307, 7]\n" +
				"	}\n" +
				"}\n";
			it.setExpectedHierarchy(expectedHierarchy);
		});
	}

	@Override
	protected String internalToExpectation(IHierarchyNode node, IHierarchyBuilder builder) {
		String superExpectation = super.internalToExpectation(node, builder);
		if (node instanceof XtextCallHierarchyNode) {
			return Strings
					.toUnixLineSeparator("grammar: " + ((XtextCallHierarchyNode) node).getGrammarDescription() + "\n" + superExpectation);
		}
		return Strings.toUnixLineSeparator(superExpectation);
	}

	@Override
	protected String toExpectation(URI rootURI, IHierarchyBuilder builder) {
		return Strings.toUnixLineSeparator(super.toExpectation(rootURI, builder));
	}
}
