/*******************************************************************************
 * Copyright (c) 2016, 2023 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.util;

import java.io.IOException;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.PositionReader;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for the {@link PositionReader}.
 *
 * @author Joao Dinis Ferreira - Initial contribution
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class PositionReaderTest extends Assert {

	@Test
	public void noLineBreaks() throws IOException {
		PositionReader reader = new PositionReader("Hello Test");

		assertEquals(new Position(0, 0), reader.getPosition());
		assertEquals(5, reader.skip(5));
		assertEquals(new Position(0, 5), reader.getPosition());

		reader.close();
	}

	@Test
	public void readPastLimit() throws IOException {
		final String inputString = "Hello world\nTest\nA\nB\nC\n";
		PositionReader reader = new PositionReader(inputString);

		assertEquals(new Position(0, 0), reader.getPosition());
		assertEquals(inputString.length(), reader.skip(1000));
		assertEquals(new Position(5, 0), reader.getPosition());

		reader.close();
	}

	@Test
	public void lineEndingsLF() throws IOException {
		PositionReader reader = new PositionReader("Hello world\nTest\nA\nB\nC\n");

		// Cursor at the start of "Hello"
		assertEquals(new Position(0, 0), reader.getPosition());
		assertEquals(5, reader.skip(5));
		assertEquals(new Position(0, 5), reader.getPosition());
		assertEquals(7, reader.skip(7));

		// Cursor at the start of "Test"
		assertEquals(new Position(1, 0), reader.getPosition());
		assertEquals(2, reader.skip(2));
		assertEquals(new Position(1, 2), reader.getPosition());
		assertEquals(3, reader.skip(3));

		// Cursor at the start of "A"
		assertEquals(new Position(2, 0), reader.getPosition());
		assertEquals(3, reader.skip(3));

		// Cursor at the end of "B"
		assertEquals(new Position(3, 1), reader.getPosition());
		assertEquals(1, reader.skip(1));

		// Cursor at the start of "C"
		assertEquals(new Position(4, 0), reader.getPosition());
		assertEquals(2, reader.skip(2));

		// Cursor at the start of the last line
		assertEquals(new Position(5, 0), reader.getPosition());

		reader.close();
	}

	@Test
	public void lineEndingsCR() throws IOException {
		PositionReader reader = new PositionReader("Hello world\rTest\rA\rB\rC\r");

		// Cursor at the start of "Hello"
		assertEquals(new Position(0, 0), reader.getPosition());
		assertEquals(5, reader.skip(5));
		assertEquals(new Position(0, 5), reader.getPosition());
		assertEquals(7, reader.skip(7));

		// Cursor at the start of "Test"
		assertEquals(new Position(1, 0), reader.getPosition());
		assertEquals(2, reader.skip(2));
		assertEquals(new Position(1, 2), reader.getPosition());
		assertEquals(3, reader.skip(3));

		// Cursor at the start of "A"
		assertEquals(new Position(2, 0), reader.getPosition());
		assertEquals(3, reader.skip(3));

		// Cursor at the end of "B"
		assertEquals(new Position(3, 1), reader.getPosition());
		assertEquals(1, reader.skip(1));

		// Cursor at the start of "C"
		assertEquals(new Position(4, 0), reader.getPosition());
		assertEquals(2, reader.skip(2));

		// Cursor at the start of the last line
		assertEquals(new Position(5, 0), reader.getPosition());

		reader.close();
	}

	@Test
	public void lineEndingsCRLF() throws IOException {
		PositionReader reader = new PositionReader("Hello world\r\nTest\r\nA\r\nB\r\nC\r\n");

		// Cursor at the start of "Hello"
		assertEquals(new Position(0, 0), reader.getPosition());
		assertEquals(5, reader.skip(5));
		assertEquals(new Position(0, 5), reader.getPosition());
		assertEquals(8, reader.skip(8));

		// Cursor at the start of "Test"
		assertEquals(new Position(1, 0), reader.getPosition());
		assertEquals(2, reader.skip(2));
		assertEquals(new Position(1, 2), reader.getPosition());
		assertEquals(4, reader.skip(4));

		// Cursor at the start of "A"
		assertEquals(new Position(2, 0), reader.getPosition());
		assertEquals(4, reader.skip(4));

		// Cursor at the end of "B"
		assertEquals(new Position(3, 1), reader.getPosition());
		assertEquals(2, reader.skip(2));

		// Cursor at the start of "C"
		assertEquals(new Position(4, 0), reader.getPosition());
		assertEquals(3, reader.skip(3));

		// Cursor at the start of the last line
		assertEquals(new Position(5, 0), reader.getPosition());

		reader.close();
	}

	@Test
	public void lineEndingsMixed() throws IOException {
		PositionReader reader = new PositionReader("Hello world\nTest\rA\r\nB\nC\r");

		// Cursor at the start of "Hello"
		assertEquals(new Position(0, 0), reader.getPosition());
		assertEquals(5, reader.skip(5));
		assertEquals(new Position(0, 5), reader.getPosition());
		assertEquals(7, reader.skip(7));

		// Cursor at the start of "Test"
		assertEquals(new Position(1, 0), reader.getPosition());
		assertEquals(2, reader.skip(2));
		assertEquals(new Position(1, 2), reader.getPosition());
		assertEquals(3, reader.skip(3));

		// Cursor at the start of "A"
		assertEquals(new Position(2, 0), reader.getPosition());
		assertEquals(4, reader.skip(4));

		// Cursor at the end of "B"
		assertEquals(new Position(3, 1), reader.getPosition());
		assertEquals(1, reader.skip(1));

		// Cursor at the start of "C"
		assertEquals(new Position(4, 0), reader.getPosition());
		assertEquals(2, reader.skip(2));

		// Cursor at the start of the last line
		assertEquals(new Position(5, 0), reader.getPosition());

		reader.close();
	}

	@Test
	public void lineEndingsMixedWithConsecutiveBreaks() throws IOException {
		PositionReader reader = new PositionReader("A\n\nB\r\rC\r\n\r\n");

		// Cursor at the start of "A"
		assertEquals(new Position(0, 0), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(0, 1), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(1, 0), reader.getPosition());
		assertEquals(1, reader.skip(1));

		// Cursor at the start of "B"
		assertEquals(new Position(2, 0), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(2, 1), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(3, 0), reader.getPosition());
		assertEquals(1, reader.skip(1));

		// Cursor at the start of "C"
		assertEquals(new Position(4, 0), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(4, 1), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(4, 1), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(5, 0), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(5, 0), reader.getPosition());
		assertEquals(1, reader.skip(1));
		assertEquals(new Position(6, 0), reader.getPosition());

		// Try to skip past the end of the String: position remains unchanged
		assertEquals(0, reader.skip(1));
		assertEquals(new Position(6, 0), reader.getPosition());

		reader.close();
	}

}