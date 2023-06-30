/*******************************************************************************
 * Copyright (c) 2016, 2023 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.util;

import static java.lang.Math.*;

import java.io.IOException;
import java.util.List;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.PositionComparator;
import org.eclipse.xtext.ide.util.PositionReader;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Test for the {@link PositionReader}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class PositionReaderTest extends Assert {

	@Test
	public void singleLine() throws IOException {
		PositionReader reader = new PositionReader("Hello Test");

		assertEquals(new Position(0, 0), reader.getPosition());
		reader.skip(5);
		assertEquals(new Position(0, 5), reader.getPosition());
	}

	@Test
	public void withCarriageReturns() throws IOException {
		PositionReader reader = new PositionReader("Hello\r\nTest\nA\r\nB\nC");
	
		assertEquals(new Position(0, 0), reader.getPosition());
		reader.skip(7);
		assertEquals(new Position(1, 0), reader.getPosition());
		reader.skip(2);
		assertEquals(new Position(1, 2), reader.getPosition());
		reader.skip(3);
		assertEquals(new Position(2, 0), reader.getPosition());
		reader.skip(3);
		assertEquals(new Position(3, 0), reader.getPosition());
		reader.skip(2);
		assertEquals(new Position(4, 0), reader.getPosition());
	}

}
