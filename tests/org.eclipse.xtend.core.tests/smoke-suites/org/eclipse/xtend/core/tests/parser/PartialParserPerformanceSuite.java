/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.parser;

import java.io.StringReader;

import org.eclipse.xtend.core.tests.compiler.CompilerSuite;
import org.eclipse.xtext.junit4.smoketest.ProcessedBy;
import org.eclipse.xtext.junit4.smoketest.ScenarioProcessor;
import org.eclipse.xtext.junit4.smoketest.XtextSmokeTestRunner;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.util.ReplaceRegion;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	PartialParserPerformanceSuite.SingleCharSuite.class,
	PartialParserPerformanceSuite.TwoCharsSuite.class, 
	PartialParserPerformanceSuite.ThreeCharsSuite.class, 
})
public class PartialParserPerformanceSuite {

	@Ignore
	@RunWith(XtextSmokeTestRunner.class)
	@ProcessedBy(value = SingleCharSuite.SingleCharProcessor.class, processCompleteInput = true)
	public static class SingleCharSuite extends CompilerSuite {

		public static class SingleCharProcessor extends PartialParsingProcessor {

			public SingleCharProcessor() {
				super(1);
			}

		}
	}

	@Ignore
	@RunWith(XtextSmokeTestRunner.class)
	@ProcessedBy(value = TwoCharsSuite.TwoCharsProcessor.class, processCompleteInput = true)
	public static class TwoCharsSuite extends CompilerSuite {
		
		public static class TwoCharsProcessor extends PartialParsingProcessor {

			public TwoCharsProcessor() {
				super(2);
			}

		}

	}

	@RunWith(XtextSmokeTestRunner.class)
	@ProcessedBy(value = ThreeCharsSuite.ThreeCharsProcessor.class, processCompleteInput = true)
	public static class ThreeCharsSuite extends CompilerSuite {
		
		public static class ThreeCharsProcessor extends PartialParsingProcessor {

			public ThreeCharsProcessor() {
				super(3);
			}

		}

	}
	
	private static class PartialParsingProcessor extends ScenarioProcessor {

		@Inject
		private IParser parser;
		private int chars;

		private PartialParsingProcessor(int chars) {
			this.chars = chars;
		}

		@Override
		public void processFile(String data) throws Exception {
			IParseResult parseResult = parser.parse(new StringReader(data));
			for (int i = 0; i < data.length() - chars; i++) {
				parseResult = parser.reparse(parseResult, new ReplaceRegion(i, chars, ""));
				parseResult = parser.reparse(parseResult, new ReplaceRegion(i, 0, data.substring(i, i + chars)));
			}
		}

	}
}