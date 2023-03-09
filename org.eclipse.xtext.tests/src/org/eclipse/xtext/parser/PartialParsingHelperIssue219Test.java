/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.impl.PartialParsingHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.PartialParserTestLanguageStandaloneSetup;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class PartialParsingHelperIssue219Test extends AbstractPartialParserTest {

	@Test
	public void testIssue219() throws Exception {
		with(PartialParserTestLanguageStandaloneSetup.class);
		String model = "container c1 {\n" + "  children {\n" + "-> C ( ch1 )\n" + "  }" + "}";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
		((PartialParsingHelper) ((AbstractAntlrParser) resource.getParser()).getPartialParser())
				.setTokenRegionProvider(null);
		resource.update(model.indexOf("ch1") + 1, 1, "x");
	}

}
