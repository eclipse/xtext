/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.valueconverter;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.valueconverter.Bug250313RuntimeModule.Converters;
import org.eclipse.xtext.valueconverter.bug250313.Model;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Bug250313Test extends AbstractXtextTests {

	private ParserTestHelper helper;
	private INode node;
	private String lexerRule;
	private int convertCallCount;
	private String string;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new Bug250313StandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new MyBug250313RuntimeModule(Bug250313Test.this));
			}
		});
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}

	@Override
	public void tearDown() throws Exception {
		string = null;
		node = null;
		lexerRule = null;
		convertCallCount = 0;
		super.tearDown();
	}
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	public static class MyBug250313RuntimeModule extends Bug250313RuntimeModule {

		private final Bug250313Test test;

		public MyBug250313RuntimeModule(Bug250313Test test) {
			this.test = test;
		}

		@Override
		public void configure(Binder binder) {
			super.configure(binder);
			binder.bind(Bug250313Test.class).toInstance(test);
		}

		@Override
		public Class<? extends IValueConverterService> bindIValueConverterService() {
			return MyConverterService.class;
		}

	}

	public static class MyConverterService implements IValueConverterService {

		@Inject
		private Converters delegate;

		@Inject
		private Bug250313Test test;

		@Override
		public String toString(Object value, String lexerRule) {
			return delegate.toString(value, lexerRule);
		}

		@Override
		public Object toValue(String string, String lexerRule, INode node) throws ValueConverterException {
			test.toValueCalled(string, lexerRule, node);
			return delegate.toValue(string, lexerRule, node);
		}

	}

	public void toValueCalled(String string, String lexerRule, INode node) {
		this.string = string;
		this.node = node;
		this.lexerRule = lexerRule;
		this.convertCallCount++;
	}

	@Override
	public XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		return helper.getResourceFromStream(in);
	}
	
	@Test public void testSTRINGConversion_01() throws Exception {
		Model model = (Model) getModel("1 'str'");
		assertEquals("str", model.getValue());
		assertNotNull(lexerRule);
		assertEquals("org.eclipse.xtext.common.Terminals.STRING", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("'str'", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testSTRINGConversion_02() throws Exception {
		Model model = (Model) getModel("'str'");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.common.Terminals.STRING", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("'str'", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testSTRINGConversion_03() throws Exception {
		Model model = (Model) getModel("2 'str'");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.common.Terminals.STRING", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("'str'", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testSTRINGConversion_04() throws Exception {
		Model model = (Model) getModel("1+ 'str'");
		assertEquals("[str]", model.getMultiValue().toString());
		assertNotNull(lexerRule);
		assertEquals("org.eclipse.xtext.common.Terminals.STRING", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("'str'", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testSTRINGConversion_05() throws Exception {
		Model model = (Model) getModel("2+ 'str'");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.common.Terminals.STRING", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("'str'", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testIDConversion_01() throws Exception {
		Model model = (Model) getModel("1 str");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.common.Terminals.ID", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("str", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testIDConversion_02() throws Exception {
		Model model = (Model) getModel("1 ^str");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.common.Terminals.ID", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("^str", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testIDConversion_03() throws Exception {
		Model model = (Model) getModel("str");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.common.Terminals.ID", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("str", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testIDConversion_04() throws Exception {
		Model model = (Model) getModel("^str");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.common.Terminals.ID", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("^str", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testIDConversion_05() throws Exception {
		Model model = (Model) getModel("1+ str");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.common.Terminals.ID", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("str", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testIDConversion_06() throws Exception {
		Model model = (Model) getModel("1+ ^str");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.common.Terminals.ID", lexerRule);
		assertTrue(node instanceof ILeafNode);
		assertEquals("^str", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testDatatypeConversion_01() throws Exception {
		Model model = (Model) getModel("1 foo - bar");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.Datatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(6, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testDatatypeConversion_02() throws Exception {
		Model model = (Model) getModel("foo - bar");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.Datatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(5, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testDatatypeConversion_03() throws Exception {
		Model model = (Model) getModel("3 foo - bar");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.Datatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(6, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testDatatypeConversion_04() throws Exception {
		Model model = (Model) getModel("1+ foo - bar");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.Datatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(6, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testDatatypeConversion_05() throws Exception {
		Model model = (Model) getModel("3+ foo - bar");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.Datatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(6, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_01() throws Exception {
		Model model = (Model) getModel("1 zonk + foo - bar");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(5, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk + foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_02() throws Exception {
		Model model = (Model) getModel("1 zonk +");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(4, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk +", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_03() throws Exception {
		Model model = (Model) getModel("zonk + foo - bar");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(4, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk + foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_04() throws Exception {
		Model model = (Model) getModel("zonk +");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(3, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk +", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_05() throws Exception {
		Model model = (Model) getModel("4 zonk + foo - bar");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(5, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk + foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_06() throws Exception {
		Model model = (Model) getModel("4 zonk +");
		assertEquals("str", model.getValue());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(4, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk +", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_07() throws Exception {
		Model model = (Model) getModel("1+ zonk + foo - bar");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(5, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk + foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_08() throws Exception {
		Model model = (Model) getModel("1+ zonk +");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(4, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk +", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_09() throws Exception {
		Model model = (Model) getModel("4+ zonk + foo - bar");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(5, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk + foo - bar", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testNestedDatatypeConversion_10() throws Exception {
		Model model = (Model) getModel("4+ zonk +");
		assertEquals("[str]", model.getMultiValue().toString());
		assertEquals("org.eclipse.xtext.valueconverter.Bug250313.NestedDatatype", lexerRule);
		assertTrue(node instanceof ICompositeNode);
		assertEquals(4, Iterables.size(((ICompositeNode)node).getChildren()));
		assertEquals("zonk +", string);
		assertEquals(1, convertCallCount);
	}

	@Test public void testKeywordConversion_01() throws Exception {
		Model model = (Model) getModel("1 mykeyword1");
		assertEquals("mykeyword1", model.getValue());
		// XXX value converter is not called for keywords?
		// if this is a bug, all assertions 'assertEquals(1, convertCallCount)' have to be increased
		assertEquals(lexerRule, 0, convertCallCount);
	}

	@Test public void testKeywordConversion_02() throws Exception {
		Model model = (Model) getModel("mykeyword1");
		assertEquals("mykeyword1", model.getValue());
		assertEquals(lexerRule, 0, convertCallCount);
	}

	@Test public void testKeywordConversion_03() throws Exception {
		Model model = (Model) getModel("1+ mykeyword1");
		assertEquals("[mykeyword1]", model.getMultiValue().toString());
		// XXX value converter is not called for keywords?
		// if this is a bug, all assertions 'assertEquals(1, convertCallCount)' have to be increased
		assertEquals(lexerRule, 0, convertCallCount);
	}

	@Test public void testChild1_01() throws Exception {
		// tests only, if crossrefs in alternatives work
		Model model = (Model) getModel("content str ref 'str'");
		assertEquals("str", model.getRef().getName());
		assertEquals(lexerRule, 2, convertCallCount);
	}

	@Test public void testChild2_01() throws Exception {
		// tests only, if crossrefs in alternatives work
		Model model = (Model) getModel("content 'str' ref str");
		assertEquals("str", model.getRef().getName());
		assertEquals(lexerRule, 2, convertCallCount);
	}
}
