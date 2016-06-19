/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.indentation;

import org.eclipse.xtext.parser.indentation.IndentationAwareLanguageTest;
import org.eclipse.xtext.testing.smoketest.ProcessedBy;
import org.eclipse.xtext.testing.smoketest.XtextSmokeTestRunner;
import org.eclipse.xtext.testing.smoketest.processors.PartialParsingProcessor;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextSmokeTestRunner.class)
@ProcessedBy(value = PartialParsingProcessor.class, processInParallel = true)
@Suite.SuiteClasses(IndentationAwareLanguageTest.class)
@SuppressWarnings("all")
public class IndentationAwarePartialParsingTest {
}
