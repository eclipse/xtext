/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xtext.ui.common.DefaultXtextResourceCheckerTest;
import org.eclipse.xtext.ui.common.editor.contentassist.JavaContentAssistProcessorTest;
import org.eclipse.xtext.ui.common.editor.contentassist.ParserBasedContentAssistProcessorTest;
import org.eclipse.xtext.ui.common.editor.contentassist.ProposalConflictHelperTest;
import org.eclipse.xtext.ui.common.editor.contentassist.TwoContextsContentAssistTest;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.ParserTest;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.InternalParserTest;
import org.eclipse.xtext.ui.common.editor.hyperlinking.HyperlinkHelperTest;
import org.eclipse.xtext.ui.common.editor.outline.impl.AbstractDeclarativeSemanticModelTransformerTest;
import org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformerTest;

/**
 * @author Dennis Hübner - Initial contribution and API
 *
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui.common.tests");
		// $JUnit-BEGIN$
		suite.addTestSuite(JavaContentAssistProcessorTest.class);
		suite.addTestSuite(ParserBasedContentAssistProcessorTest.class);
		suite.addTestSuite(InternalParserTest.class);
		suite.addTestSuite(ParserTest.class);
		suite.addTestSuite(ParserBasedContentAssistProcessorTest.class);
		suite.addTestSuite(TwoContextsContentAssistTest.class);
		suite.addTestSuite(HyperlinkHelperTest.class);
		suite.addTestSuite(ProposalConflictHelperTest.Antlr.class);
		suite.addTestSuite(DefaultSemanticModelTransformerTest.class);
		suite.addTestSuite(AbstractDeclarativeSemanticModelTransformerTest.class);
		suite.addTestSuite(DefaultXtextResourceCheckerTest.class);
		// $JUnit-END$
		return suite;
	}

}
