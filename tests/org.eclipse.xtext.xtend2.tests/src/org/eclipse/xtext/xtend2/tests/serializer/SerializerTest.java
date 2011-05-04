/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.serializer;

import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.impl.Serializer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class SerializerTest extends AbstractXtend2TestData {

	@Inject
	private ISerializer serializer;

	public void testSerializer() {
		assertTrue(serializer instanceof Serializer);
	}

	@Override
	protected void doTest(String fileContents) throws Exception {
		assertEquals(fileContents, serializer.serialize(file(fileContents)));
	}
}
