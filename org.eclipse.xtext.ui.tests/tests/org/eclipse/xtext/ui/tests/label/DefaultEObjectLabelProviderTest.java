/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.label;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultEObjectLabelProviderTest extends Assert {

	private static final String DEFAULT_TEXT = "default";

	@Test public void testSimple() throws Exception {
		final List<String> calls = new ArrayList<String>();
		@SuppressWarnings("unused")
		DefaultEObjectLabelProvider lp = new DefaultEObjectLabelProvider(null) {
			{
				setImageHelper(new IImageHelper.NullImageHelper());
			}

			public String text(String object) {
				return object;
			}

			public String text(Integer object) {
				return object.toString();
			}

			public String image(String obj) {
				calls.add(obj);
				return null;
			}

			public String image(Integer obj) {
				calls.add(obj.toString());
				return null;
			}
		};
		assertEquals("foo", lp.getText("foo"));
		assertEquals("89", lp.getText(Integer.valueOf(89)));

		assertTrue(calls.isEmpty());
		lp.getImage(true);
		assertTrue(calls.isEmpty());
		lp.getImage("String");
		assertTrue(calls.contains("String"));
		lp.getImage(Integer.valueOf(45));
		assertTrue(calls.contains("45"));
		assertTrue(calls.size() == 2);
	}

	@Test public void testGetStyledText() throws Exception {
		DefaultEObjectLabelProvider defaultLabelProvider = new DefaultEObjectLabelProvider() {

			@SuppressWarnings("unused")
			public Object text(ParserRule parserRule) {
				return new StyledString(parserRule.getName());
			}

		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testCreateStyledString");
		StyledString styledText = defaultLabelProvider.getStyledText(parserRule);
		assertEquals("testCreateStyledString", styledText.getString());
	}

	@Test public void testGetStyledTextFallbackText() throws Exception {
		DefaultEObjectLabelProvider defaultLabelProvider = new DefaultEObjectLabelProvider();
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testCreateStyledString");
		StyledString styledText = defaultLabelProvider.getStyledText(parserRule);
		assertEquals("testCreateStyledString", styledText.getString());
	}

	@Test public void testGetStyledTextWithExistingTextLabel() throws Exception {
		DefaultEObjectLabelProvider defaultLabelProvider = new DefaultEObjectLabelProvider() {
			@SuppressWarnings("unused")
			public String text(ParserRule parserRule) {
				return parserRule.getName();
			}
		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testCreateStyledStringWithTextLabel");
		StyledString styledText = defaultLabelProvider.getStyledText(parserRule);
		assertEquals("testCreateStyledStringWithTextLabel", styledText.getString());
	}

	@Test public void testGetTextWithExistingStyledStringLabel() throws Exception {
		DefaultEObjectLabelProvider defaultLabelProvider = new DefaultEObjectLabelProvider() {
			@SuppressWarnings("unused")
			public StyledString text(ParserRule parserRule) {
				return new StyledString(parserRule.getName());
			}

		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testGetTextWithStyledStringLabel");
		assertEquals("testGetTextWithStyledStringLabel", defaultLabelProvider.getText(parserRule));
	}

	@Test public void testGetNullSafeDefaultText() throws Exception {
		DefaultEObjectLabelProvider defaultLabelProvider = new DefaultEObjectLabelProvider() {
			@SuppressWarnings("unused")
			public StyledString text(ParserRule parserRule) {
				return new StyledString(parserRule.getName());
			}

			@Override
			protected String getDefaultText() {
				return DEFAULT_TEXT;
			}
		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		StyledString styledText = defaultLabelProvider.getStyledText(parserRule);
		assertEquals(DEFAULT_TEXT, styledText.getString());
	}

	@Test public void testErrorHandling() throws Exception {
		final List<Object> calls = new ArrayList<Object>();
		@SuppressWarnings("unused")
		DefaultEObjectLabelProvider defaultLabelProvider = new DefaultEObjectLabelProvider() {
			{
				setImageHelper(new IImageHelper.NullImageHelper());
			}

			public String text(String object) {
				throw new NullPointerException();
			}

			public String text(Integer object) {
				throw new IllegalArgumentException();
			}

			public String image(String obj) {
				throw new NullPointerException();
			}

			public String image(Integer obj) {
				throw new IllegalArgumentException();
			}

			@Override
			protected String getDefaultText() {
				return DEFAULT_TEXT;
			}

			@Override
			protected Object handleImageError(Object[] params, Throwable e) {
				calls.add(params[0]);
				return super.handleImageError(params, e);
			}

			@Override
			protected Object handleTextError(Object[] params, Throwable e) {
				calls.add(params[0]);
				return super.handleTextError(params, e);
			}
		};

		assertEquals(DEFAULT_TEXT, defaultLabelProvider.getText("foo"));
		assertEquals(1, calls.size());
		try {
			assertEquals("89", defaultLabelProvider.getText(Integer.valueOf(89)));
			fail();
		} catch (RuntimeException e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertEquals(2, calls.size());

		assertNull(defaultLabelProvider.getImage("String"));
		assertEquals(3, calls.size());
		try {
			defaultLabelProvider.getImage(Integer.valueOf(45));
			fail();
		} catch (RuntimeException e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
		assertEquals(4, calls.size());
	}

	@Test public void testGetTextCharSequence() throws Exception {
		DefaultEObjectLabelProvider defaultLabelProvider = new DefaultEObjectLabelProvider() {

			@SuppressWarnings("unused")
			public Object text(ParserRule parserRule) {
				StringConcatenation _builder = new StringConcatenation();
			    _builder.append(parserRule.getName());
			    return _builder;
			}

		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testCreateStyledString");
		String styledText = defaultLabelProvider.getText(parserRule);
		assertEquals("testCreateStyledString", styledText);
	}
}
