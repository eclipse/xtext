/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.ui.DefaultLabelProvider;
import org.eclipse.xtext.ui.IImageHelper;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultLabelProviderTest extends TestCase {

	public void testSimple() throws Exception {
		final List<String> calls = new ArrayList<String>();
		@SuppressWarnings("unused")
		DefaultLabelProvider lp = new DefaultLabelProvider() {
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
		assertEquals("89", lp.getText(new Integer(89)));

		assertTrue(calls.isEmpty());
		lp.getImage(true);
		assertTrue(calls.isEmpty());
		lp.getImage("String");
		assertTrue(calls.contains("String"));
		lp.getImage(new Integer(45));
		assertTrue(calls.contains("45"));
		assertTrue(calls.size() == 2);
	}

	public void testGetStyledText() throws Exception {
		DefaultLabelProvider defaultLabelProvider = new DefaultLabelProvider() {

			@SuppressWarnings("unused")
			public StyledString text(ParserRule parserRule) {
				return createStyledString(parserRule);
			}

		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testCreateStyledString");
		StyledString styledText = defaultLabelProvider.getStyledText(parserRule);
		assertEquals("testCreateStyledString", styledText.getString());
	}

	public void testGetStyledTextFallbackText() throws Exception {
		DefaultLabelProvider defaultLabelProvider = new DefaultLabelProvider();
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testCreateStyledString");
		StyledString styledText = defaultLabelProvider.getStyledText(parserRule);
		assertEquals("testCreateStyledString", styledText.getString());
	}

	public void testGetStyledTextWithExistingTextLabel() throws Exception {
		DefaultLabelProvider defaultLabelProvider = new DefaultLabelProvider() {
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

	public void testGetTextWithExistingStyledStringLabel() throws Exception {
		DefaultLabelProvider defaultLabelProvider = new DefaultLabelProvider() {
			@SuppressWarnings("unused")
			public StyledString text(ParserRule parserRule) {
				return createStyledString(parserRule);
			}

		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("testGetTextWithStyledStringLabel");
		assertEquals("testGetTextWithStyledStringLabel", defaultLabelProvider.getText(parserRule));
	}

	public void testGetNullSafeDefaultText() throws Exception {
		DefaultLabelProvider defaultLabelProvider = new DefaultLabelProvider() {

			@SuppressWarnings("unused")
			public StyledString text(ParserRule parserRule) {
				return createStyledString(parserRule);
			}

		};
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		StyledString styledText = defaultLabelProvider.getStyledText(parserRule);
		assertNotNull(styledText.getString());
	}

	public void testErrorHandling() throws Exception {
		final List<String> calls = new ArrayList<String>();
		@SuppressWarnings("unused")
		DefaultLabelProvider lp = new DefaultLabelProvider() {
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
				throw new NullPointerException();
			}

			@Override
			public String error_image(Object obj, NullPointerException ex) {
				calls.add("error_" + obj.toString());
				return null;
			}
		};
		assertNull(lp.getText("foo"));
		try {
			assertEquals("89", lp.getText(new Integer(89)));
			fail();
		} catch (WrappedException e) {
			assertTrue(e.getCause() instanceof IllegalArgumentException);
		}

		assertTrue(calls.isEmpty());
		lp.getImage(true);
		assertTrue(calls.isEmpty());
		lp.getImage("String");
		assertTrue(calls.contains("error_String"));
		lp.getImage(new Integer(45));
		assertTrue(calls.contains("error_45"));
		assertTrue(calls.size() == 2);
	}
}
