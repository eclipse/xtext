/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.richstring;

import java.util.List;

import org.eclipse.xtend.core.tests.validation.RichStringValidationTest;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringWithCommentValidationTest extends RichStringValidationTest {

	@Inject
	private CommentInserter commentInserter;
	
	@Override
	protected void assertValidRichString(String input) throws Exception {
		List<String> richStringWithComments = commentInserter.getRichStringWithComments(input);
		for(String richStringWithComment: richStringWithComments)
			super.assertValidRichString(richStringWithComment);
	}
	
}
