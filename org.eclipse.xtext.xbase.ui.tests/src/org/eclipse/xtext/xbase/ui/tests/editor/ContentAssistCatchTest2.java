/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistCatchTest2 extends ContentAssistTest {
	@Override
	protected String getPrefix() {
		return "try { var x = 0 } catch(Exception ex) (";
	}

	@Override
	protected String getSuffix() {
		return ")";
	}

	@Override
	protected String[] getKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.getKeywordsAndStatics());
		result.add("ex");
		return result.toArray(new String[result.size()]);
	}
}
