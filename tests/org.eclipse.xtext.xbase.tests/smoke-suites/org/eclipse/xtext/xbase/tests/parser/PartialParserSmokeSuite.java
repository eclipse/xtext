package org.eclipse.xtext.xbase.tests.parser;

import org.eclipse.xtext.junit4.smoketest.ProcessedBy;
import org.eclipse.xtext.junit4.smoketest.XtextSmokeTestRunner;
import org.eclipse.xtext.junit4.smoketest.processors.PartialParsingProcessor;
import org.eclipse.xtext.xbase.tests.compiler.CompilerSuite;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextSmokeTestRunner.class)
@ProcessedBy(value = PartialParsingProcessor.class, processInParallel = true)
public class PartialParserSmokeSuite extends CompilerSuite {
}