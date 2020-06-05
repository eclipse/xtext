/*******************************************************************************
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

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
	public void assertOutput(String expectedOutput, String imports, String richString) throws Exception {
		List<String> allCandidates = commentInserter.getRichStringWithComments(richString);
		for(String richStringWithComment: allCandidates)
			super.assertOutput(expectedOutput, imports, richStringWithComment);
	}
	
	@Override
	@Ignore
	@Test 
	public void testBug343148() throws Exception {
		// Simple CommentInserter cannot handle nested rich string literals
//		assertOutput(" zonk a\n\n zonk b\n\n zonk c",
//				"'''«newArrayList('a','b','c').join('\n\n',[e|''' zonk «e»'''])»'''");
	}
	
}
