/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Level;
import org.eclipse.xtext.enumrules.parser.antlr.EnumAndReferenceTestLanguageParser;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.detachable.DetachableNodeModelBuilder;
import org.eclipse.xtext.nodemodel.detachable.DetachableParseResult;
import org.eclipse.xtext.nodemodel.detachable.GrammarElementLookup;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.testing.logging.LoggingTester.LogCapture;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian - Initial contribution and API
 */
public class AutoDetachNodeModelTest extends AbstractEnumRulesTest {
	
	private ParserTestHelper helper;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(EnumAndReferenceTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}
	
	static class CustomParser extends EnumAndReferenceTestLanguageParser {
		
		@Inject	GrammarElementLookup grammarElementLookup;
		
		@Override
		protected NodeModelBuilder createNodeModelBuilder() {
			return new DetachableNodeModelBuilder(grammarElementLookup) {
				@Override
				protected DetachableParseResult createEmptyParseResult(GrammarElementLookup grammarElementLookup) {
					return new DetachableParseResult(grammarElementLookup, Duration.ofMillis(50));
				}
			};
		}
	}
	
	@Override
	protected IParser getParser() {
		return getInjector().getInstance(CustomParser.class);
	}
	
	@Test public void testNodeModelIsAutoReleased() throws Exception {
		LogCapture messages = LoggingTester.captureLogging(Level.TRACE, "org.eclipse.xtext.nodemodel.detachable", ()->{
			try {
				String modelAsString = "kindOfKeyword Hoo reference Hoo";
				XtextResource resource = parse(modelAsString);
				DetachableParseResult parseResult = (DetachableParseResult) resource.getParseResult();
				ICompositeNode rootNode = parseResult.getRootNode();
				parseResult.releaseNodeModel(false);
				
				Thread.sleep(200);
				assertNotSame(rootNode, parseResult.getRootNode());
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		});
		messages.assertNumberOfLogEntries(2, "scheduleRelease");
		messages.assertLogEntry("serialize:NodeModelData");
		messages.assertLogEntry("nodeModelRequested");
		messages.assertLogEntry("deserialize:StandardNodeModelReference");
	}
	
	@Test public void testNodeModelIsAutoReleasedAfterUsage() throws Exception {
		LogCapture messages = LoggingTester.captureLogging(Level.TRACE, "org.eclipse.xtext.nodemodel.detachable", ()->{
			try {
				String modelAsString = "kindOfKeyword Hoo reference Hoo";
				XtextResource resource = parse(modelAsString);
				DetachableParseResult parseResult = (DetachableParseResult) resource.getParseResult();
				ICompositeNode rootNode = parseResult.getRootNode();
				parseResult.releaseNodeModel(false);
				
				Thread.sleep(200);
				assertNotSame(rootNode, parseResult.getRootNode());
				Thread.sleep(200);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		});
		messages.assertNumberOfLogEntries(2, "scheduleRelease");
		messages.assertLogEntry("serialize:NodeModelData");
		messages.assertLogEntry("nodeModelRequested");
		messages.assertLogEntry("deserialize:StandardNodeModelReference");
		messages.assertLogEntry("release");
	}
	
	protected XtextResource parse(String modelAsString) throws IOException {
		return helper.getResourceFromString(modelAsString);
	}
}
