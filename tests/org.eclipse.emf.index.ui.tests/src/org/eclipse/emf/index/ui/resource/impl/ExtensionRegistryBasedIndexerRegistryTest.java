/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.emf.index.ui.resource.impl;

import static org.eclipse.emf.index.ui.resource.impl.ExtensionRegistryBasedIndexerRegistry.*;
import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ExtensionRegistryBasedIndexerRegistryTest extends TestCase {
	
	public void testToSet() throws Exception {
		assertTrue(toList("foo").contains("foo"));
		assertTrue(toList("foo ").contains("foo"));
		assertTrue(toList("foo, bar").contains("foo"));
		assertTrue(toList("foo, bar").contains("bar"));
		assertTrue(toList("  ").isEmpty());
	}
}
