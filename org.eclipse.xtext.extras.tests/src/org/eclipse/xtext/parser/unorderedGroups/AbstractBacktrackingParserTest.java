/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractBacktrackingParserTest extends AbstractXtextTests {

	@Test public void testNoException_01() throws Exception {
		getModel("unit { provides : unit { name : FooBar;	}; }");
	}
	
	@Test public void testException_01() throws Exception {
		getModelAndExpect("unit { provides : unit { name : FooBar	}; }", 
				/* usually expect 1 error (missing ;), but got a second due to backtracking */ 2);
	}
}
