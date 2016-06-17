/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LineSeparatorHarminizerTest extends AbstractXtextTests {

	@Test
	public void testHarmonizeLineBreaks() {
		IWhitespaceInformationProvider whitespaceInformationProvider = get(IWhitespaceInformationProvider.class);
		URI uri = URI.createURI("example.txt");
		String ls = whitespaceInformationProvider.getLineSeparatorInformation(uri).getLineSeparator();
		assertFalse(isEmpty(ls));
		LineSeparatorHarmonizer lineSeparatorHarmonizer = get(LineSeparatorHarmonizer.class);

		assertEquals(ls, lineSeparatorHarmonizer.postProcess(uri, "\n"));
		assertEquals(ls, lineSeparatorHarmonizer.postProcess(uri, "\r"));
		assertEquals(ls, lineSeparatorHarmonizer.postProcess(uri, "\n\r"));
		assertEquals(ls, lineSeparatorHarmonizer.postProcess(uri, "\r\n"));
		
		assertEquals("0" + ls + "1" + ls + "2", lineSeparatorHarmonizer.postProcess(uri, "0\n1\r2"));
		assertEquals("0" + ls + "1" + ls + "2", lineSeparatorHarmonizer.postProcess(uri, "0\n\r1\r\n2"));
		assertEquals("0" + ls + ls + "1", lineSeparatorHarmonizer.postProcess(uri, "0\n\r\n\r1"));
		assertEquals("0" + ls + ls + "1", lineSeparatorHarmonizer.postProcess(uri, "0\r\n\r\n1"));
		assertEquals("0" + ls + ls + ls + "1", lineSeparatorHarmonizer.postProcess(uri, "0\n\r\n\r\n1"));
		assertEquals("0" + ls + ls + ls + "1", lineSeparatorHarmonizer.postProcess(uri, "0\r\n\r\n\r1"));
	}
}
