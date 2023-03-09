/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.testlanguages.backtracking.ExBeeLangTestLanguageStandaloneSetup;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BacktrackingParserExTest extends AbstractBacktrackingParserTest {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ExBeeLangTestLanguageStandaloneSetup.class);
	}

}
