/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.autoedit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	AutoEditTest.class,
	AutoEditInClassBodyTest.class,
	AutoEditInCodeBlockTest.class,
	AutoEditInFirstMethodTest.class,
	AutoEditInMethodBodyTest.class,
	AutoEditInRichStringTest.class,
	AutoEditInSecondMethodTest.class,
})
public class AutoEditSuite {
}
