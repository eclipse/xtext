/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.generator.serializer.JavaFile;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
public class JavaFileTest extends Assert {

	@Test public void testMain() {
		JavaFile file = new JavaFile("foo");
		assertEquals("Foo", file.imported("foo.Foo"));
		assertEquals("bar.Foo", file.imported("bar.Foo"));
		assertEquals("foo.Package", file.imported("foo.Package"));
	}
}
