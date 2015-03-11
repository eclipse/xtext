/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.List;

import org.eclipse.xtend.core.tests.richstring.CommentInserter;
import org.eclipse.xtend.core.tests.richstring.InitialIndentationTest;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InitialIndentationWithCommentsTest extends InitialIndentationTest {

	@Inject
	private CommentInserter commentInserter;
	
	@Override
	public void assertInitialIndentation(String expectedIndentation, String richString, String initial)
			throws Exception {
		List<String> allCandidates = commentInserter.getRichStringWithComments(richString);
		for(String richStringWithComment: allCandidates)
			super.assertInitialIndentation(expectedIndentation, richStringWithComment, initial);
	}
	
}
