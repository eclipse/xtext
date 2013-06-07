/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Bug410060Test extends AbstractXtendContentAssistBugTest {

	@Inject 
	private ILineSeparatorInformation lineSepInfo;  
	
	@Test public void testInnerClass() throws Exception {
		String lineSeparator = lineSepInfo.getLineSeparator();
		newBuilder()
			.append("import java.lang.Character" + lineSeparator + lineSeparator + "class Foo { Subset")
			.assertProposal("Character.Subset")
			.apply()
			.expectContent("import java.lang.Character" 
					+ lineSeparator 
					+ "import java.lang.Character.Subset"
					+ lineSeparator + lineSeparator
					+ "class Foo { Subset");
	}
	
}
