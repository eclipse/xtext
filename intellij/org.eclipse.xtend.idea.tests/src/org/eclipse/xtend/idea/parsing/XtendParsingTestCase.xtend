/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.parsing

import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.idea.tests.parsing.AbstractModelTestCase

/**
 * @author kosyakov - Initial contribution and API
 */
@TestDecorator
class XtendParsingTestCase extends AbstractModelTestCase {

	IdeaXtendParserTest delegate

	new() {
		super(XtendFileType.INSTANCE)
		delegate = new IdeaXtendParserTest(this)
		xtextLanguage.injectMembers(delegate)
	}

}
