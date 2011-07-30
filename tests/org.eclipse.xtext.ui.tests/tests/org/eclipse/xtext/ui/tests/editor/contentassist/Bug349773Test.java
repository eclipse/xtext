/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher.IgnoreCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug349773Test extends FQNPrefixMatcherTest {

	@Override
	protected FQNPrefixMatcher createMatcher() {
		IgnoreCase ignoreCase = new PrefixMatcher.IgnoreCase();
		FQNPrefixMatcher result = new FQNPrefixMatcher();
		result.setDelegate(ignoreCase);
		result.setLastSegmentFinder(new FQNPrefixMatcher.DefaultLastSegmentFinder());
		return result;
	}
}
