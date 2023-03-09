/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BacktrackingGuardForUnorderedGroupsRemover {

//	if ( state.backtracking==0 ) {
//  	getUnorderedGroupHelper().enter(grammarAccess.getModelAccess().getUnorderedGroup_1_0_1());
//      -(1)--------------------------------------------------------------------------------------
//	}
	public static final Pattern GUARDED_GROUP_PATTERN_01 = Pattern.compile(
		"if\\s*\\(\\s*state\\.backtracking\\s*==\\s*0\\s*\\)\\s*\\{\\s*(getUnorderedGroupHelper().\\S+(,\\s*\\S+)?)\\s*\\}");

//	if ( state.backtracking==0 ) {
//		selected = true;
//  	-(1)--------------------------------------------------------------------------------------
//	}
	public static final Pattern GUARDED_GROUP_PATTERN_02 = Pattern.compile(
		"if\\s*\\(\\s*state\\.backtracking\\s*==\\s*0\\s*\\)\\s*\\{\\s*(selected\\s*=\\strue;?)\\s*\\}");

	private final String content;

	public BacktrackingGuardForUnorderedGroupsRemover(String content) {
		this.content = content;
	}

	public String transform() {
		Matcher m = GUARDED_GROUP_PATTERN_01.matcher(content);
		String result = m.replaceAll("$1");
		m = GUARDED_GROUP_PATTERN_02.matcher(result);
		result = m.replaceAll("$1");
		return result;
	}

}
