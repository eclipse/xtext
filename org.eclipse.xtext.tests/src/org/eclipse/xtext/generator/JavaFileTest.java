/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.generator.serializer.JavaFile;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JavaFileTest extends Assert {

	@Test public void testMain() {
		JavaFile file = new JavaFile("foo");
		assertEquals("Foo", file.imported("foo.Foo"));
		assertEquals("bar.Foo", file.imported("bar.Foo"));
		assertEquals("foo.Package", file.imported("foo.Package"));
	}
}
