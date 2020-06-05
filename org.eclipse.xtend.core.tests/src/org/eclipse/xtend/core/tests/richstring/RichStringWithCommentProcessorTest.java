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

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringWithCommentProcessorTest extends RichStringProcessorTest {

	@Inject
	private CommentInserter commentInserter;
	
	@Override
	protected void doTestStackIsConsistent(String richString) throws Exception {
		List<String> allCandidates = commentInserter.getRichStringWithComments(richString);
		for(String richStringWithComment: allCandidates)
			super.doTestStackIsConsistent(richStringWithComment);
	}
	
	@Override
	protected void doTestStackIsConsistentWithErroneousModel(String richString) throws Exception {
		List<String> allCandidates = commentInserter.getRichStringWithComments(richString);
		for(String richStringWithComment: allCandidates)
			super.doTestStackIsConsistentWithErroneousModel(richStringWithComment);
	}
	
}
