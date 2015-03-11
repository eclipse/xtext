/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase
import org.eclipse.xtext.xbase.idea.lang.XbaseFileType

@TestDecorator
class XbaseModelTestCase extends AbstractModelTestCase {

	IdeaXbaseParserTest delegate

	new() {
		super(XbaseFileType.INSTANCE)
		delegate = new IdeaXbaseParserTest(this)
	}

}