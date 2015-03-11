/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest
import org.junit.Ignore

@FinalFieldsConstructor
@Ignore("Only here as a delegate")
class IdeaXbaseParserTest extends XbaseParserTest {

	val ModelChecker expresssionChecker
	
	override protected expression(CharSequence string) throws Exception {
		expresssionChecker.checkModel(string.toString, false)
	}

	override protected expression(CharSequence string, boolean resolve) throws Exception {
		expresssionChecker.checkModel(string.toString, resolve)
	}

}