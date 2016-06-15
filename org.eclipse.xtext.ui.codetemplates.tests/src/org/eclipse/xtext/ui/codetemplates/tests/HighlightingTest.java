/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.tests;

import java.util.Collection;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.CodetemplatesUiInjectorProvider;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.SemanticHighlighter;
import org.eclipse.xtext.ui.codetemplates.ui.highlighting.TemplatesHighlightingConfiguration;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplateResourceProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@InjectWith(CodetemplatesUiInjectorProvider.class)
@RunWith(XtextRunner.class)
public class HighlightingTest implements IHighlightedPositionAcceptor {

	@Inject
	private SemanticHighlighter highlighter;
	
	@Inject
	private TemplateResourceProvider resourceProvider;
	
	private Multimap<TextRegion, String> expectedRegions;
	
	@Before
	public void setUp() throws Exception {
		expectedRegions = HashMultimap.create();
	}
	
	@After
	public void tearDown() throws Exception {
		expectedRegions = null;
	}
	
	@Test
	public void testKeywordHighlighting() throws Exception {
		String model = 
				"templates for org.eclipse.xtext.ui.codetemplates.Codetemplates\n" + 
				"'' for Codetemplates >>templates";
		expect(model.length() - "templates".length(), "templates".length(), DefaultHighlightingConfiguration.KEYWORD_ID);
		highlight(model);
	}
	
	@Test
	public void testKeywordInVariable() throws Exception {
		String model = 
				"templates for org.eclipse.xtext.ui.codetemplates.Codetemplates\n" + 
				"'' for Codetemplates >>${templates}";
		expect(model.length() - "${templates}".length(), "${templates}".length(), DefaultHighlightingConfiguration.KEYWORD_ID);
		expect(model.indexOf("${"), 2, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("}"), 1, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		highlight(model);
	}
	
	@Test
	public void testVariableWithArguments() throws Exception {
		String model = 
				"templates for org.eclipse.xtext.ui.codetemplates.Codetemplates\n" + 
				"'' for Codetemplates >>${name:type(arg1, arg2)}";
		expect(model.length() - "${name:type(arg1, arg2)}".length(), "${name:type(arg1, arg2)}".length(), DefaultHighlightingConfiguration.DEFAULT_ID);
		expect(model.indexOf("${"), 2, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf(":"), 1, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("type"), 4, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("("), 1, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("arg1"), 4, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE_ARGUMENT);
		expect(model.indexOf(","), 1, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("arg2"), 4, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE_ARGUMENT);
		expect(model.indexOf(")"), 1, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("}"), 1, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		highlight(model);
	}
	
	@Test
	public void testCursorVariable() throws Exception {
		String model = 
				"templates for org.eclipse.xtext.ui.codetemplates.Codetemplates\n" + 
				"'' for Codetemplates >>${cursor}";
		expect(model.length() - "${cursor}".length(), "${cursor}".length(), DefaultHighlightingConfiguration.DEFAULT_ID);
		expect(model.indexOf("${"), 2, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("cursor"), 6, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		expect(model.indexOf("}"), 1, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);
		highlight(model);
	}
	
	@Test
	public void testStringHighlighting() throws Exception {
		String model = 
				"templates for org.eclipse.xtext.ui.codetemplates.Codetemplates\n" + 
				"'' for Codetemplates >>'foo'";
		expect(model.length() - "'foo'".length(), "'foo'".length(), DefaultHighlightingConfiguration.STRING_ID);
		highlight(model);
	}
	
	protected void expect(int offset, int length, String highlightID) {
		expectedRegions.put(new TextRegion(offset, length), highlightID);
	}
	
	protected void highlight(String model) {
		try {
			XtextResource resource = resourceProvider.createResource();
			resource.load(new StringInputStream(model), null);
			highlighter.provideHighlightingFor(resource, this, CancelIndicator.NullImpl);
			Assert.assertTrue(expectedRegions.toString(), expectedRegions.isEmpty());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void addPosition(int offset, int length, String... id) {
		TextRegion region = new TextRegion(offset, length);
		Assert.assertEquals(1, id.length);
		Assert.assertFalse(region.toString(), expectedRegions.isEmpty());
		Collection<String> expectedIds = expectedRegions.get(region);
		if(expectedIds.size() > 0)
			Assert.assertTrue("expected: " + expectedRegions.toString() + " but was: " + region + " (" + id[0] + ")", expectedIds.contains(id[0]));
		if(expectedIds.contains(id[0]))
			expectedRegions.remove(region, id[0]);
	}
}
