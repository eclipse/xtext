/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringCompilerTest2 extends RichStringCompilerTest {
	
	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		String completeCode = "val result = new org.eclipse.xtend2.lib.StringConcatenation\n" +
			"result.append(client)\n" + 
			"return result.toString();\n" +
			"}\n" +
			"def org.eclipse.xtend2.lib.StringConcatenationClient getClient() {\n" + richString;
		super.assertOutput(expectedOutput, completeCode);
	}
}
