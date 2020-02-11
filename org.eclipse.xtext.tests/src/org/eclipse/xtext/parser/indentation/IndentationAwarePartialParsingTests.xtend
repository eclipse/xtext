/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation

import org.eclipse.xtext.testing.smoketest.ProcessedBy
import org.eclipse.xtext.testing.smoketest.XtextSmokeTestRunner
import org.eclipse.xtext.testing.smoketest.processors.PartialParsingProcessor
import org.junit.runner.RunWith
import org.junit.runners.Suite.SuiteClasses
import org.junit.runners.Suite

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextSmokeTestRunner)
@ProcessedBy(value = PartialParsingProcessor, processInParallel = true)
class IndentationAwarePartialParsingTests extends IndentationAwareLanguageSuite {
}

@RunWith(Suite)
@SuiteClasses(IndentationAwareLanguageTest, NodeModelTest)
class IndentationAwareLanguageSuite {
}
