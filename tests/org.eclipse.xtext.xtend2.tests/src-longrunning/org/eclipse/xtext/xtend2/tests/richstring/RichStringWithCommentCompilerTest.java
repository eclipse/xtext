/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.richstring;

import java.util.List;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringWithCommentCompilerTest extends RichStringCompilerTest {

	@Inject
	private CommentInserter commentInserter;
	
	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		List<String> allCandidates = commentInserter.getRichStringWithComments(richString);
		for(String richStringWithComment: allCandidates)
			super.assertOutput(expectedOutput, richStringWithComment);
	}
	
	@Override
	public void testBug343148() throws Exception {
		// Simple CommentInserter cannot handle nested rich string literals
//		assertOutput(" zonk a\n\n zonk b\n\n zonk c",
//				"'''«newArrayList('a','b','c').join('\n\n',[e|''' zonk «e»'''])»'''");
	}
	
}
