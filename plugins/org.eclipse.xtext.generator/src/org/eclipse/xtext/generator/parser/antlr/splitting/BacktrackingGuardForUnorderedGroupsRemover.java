/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.splitting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BacktrackingGuardForUnorderedGroupsRemover {

//	if ( backtracking==0 ) {
//  	getUnorderedGroupHelper().enter(grammarAccess.getModelAccess().getUnorderedGroup_1_0_1());
//      -(1)--------------------------------------------------------------------------------------
//	}
	public static final Pattern GUARDED_GROUP_PATTERN = Pattern.compile(
			"if\\s*\\(\\s*backtracking\\s*==\\s*0\\s*\\)\\s*\\{\\s*(getUnorderedGroupHelper().\\S+(,\\s*\\S+)?)\\s*\\}");
	


	private final String content;
	
	public BacktrackingGuardForUnorderedGroupsRemover(String content) {
		this.content = content;
	}
	
	public String transform() {
		Matcher m = GUARDED_GROUP_PATTERN.matcher(content);
		String result = m.replaceAll("$1");
		return result;
	}
	
	
}
