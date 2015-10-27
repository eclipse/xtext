/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase
import org.eclipse.xtext.idea.tests.parsing.ModelChecker
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseFileType
import org.eclipse.xtext.purexbase.pureXbase.Model
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest

@TestDecorator
class XbaseModelTestCase extends AbstractModelTestCase {

	Delegate delegate

	new() {
		super(PureXbaseFileType.INSTANCE)
		delegate = new Delegate(this)
	}

	@FinalFieldsConstructor
	private static class Delegate extends XbaseParserTest {

		val ModelChecker expressionChecker

		override protected expression(CharSequence string) throws Exception {
			expressionChecker.<Model>checkModel(string.toString, false).block.expressions.head
		}

		override protected expression(CharSequence string, boolean resolve) throws Exception {
			expressionChecker.<Model>checkModel(string.toString, resolve).block.expressions.head
		}
		
	}
}