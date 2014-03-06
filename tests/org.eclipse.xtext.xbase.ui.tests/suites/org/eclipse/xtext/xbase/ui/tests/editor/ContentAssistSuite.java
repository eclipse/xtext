/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({
	ContentAssistTest.class,
	ContentAssistInBlockTest.class,
	ContentAssistInBlockAsSecondTest.class,
	ContentAssistInBlockAsSecondWithoutParenTest.class,
	ContentAssistInBlockAsSecondWithSemiTest.class,
	Bug350007Test.class,
	Bug372950Test.class,
	Bug379238Test.class,
	Bug401154Test.class,
	Bug402716Test.class,
	Bug403554Test.class
})
public class ContentAssistSuite {
}
