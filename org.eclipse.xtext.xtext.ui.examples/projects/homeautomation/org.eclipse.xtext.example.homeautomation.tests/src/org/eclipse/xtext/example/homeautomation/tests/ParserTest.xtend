/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper

class ParserTest extends AbstractTest {

	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper

	override protected test(CharSequence document) {
		document.parse.assertNoErrors
	}

}