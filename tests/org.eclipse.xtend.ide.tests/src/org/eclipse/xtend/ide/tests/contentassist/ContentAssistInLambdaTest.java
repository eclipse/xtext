/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ContentAssistInLambdaTest extends ContentAssistTest {

	@Override
	@Ignore
	//TODO: There's an unexpected equals()
	@Test public void testEmptyInput() throws Exception {
		super.testEmptyInput();
	}
	
	@Override
	protected String getPrefix() {
		return "class Name { def (Name)=>void _operation() { [";
	}
	
	@Override
	protected String getPostFix() {
		return "\n]\n}\n}";
	}
	
	@Override
	protected String[] getKeywordsAndStatics() {
		List<String> result = Lists.newArrayList(super.getKeywordsAndStatics());
		result.add("it");
		// this.equals(it)
		result.add("equals");
		result.remove("equals()");
		return result.toArray(new String[result.size()]);
	}
}
