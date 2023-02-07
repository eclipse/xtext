/**
 * Copyright (c) 2019, 2020 Sigasi N.V. (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.testing.DocumentHighlightConfiguration;
import org.junit.Test;

/**
 * Class for testing the highlighting of reference that refer to the object in
 * which they are embedded.
 */
public class DocumentHighlight2Test extends AbstractLanguageServerTest {
	public DocumentHighlight2Test() {
		super("nestedRefs");
	}

	@Test
	public void testHighlightDeclarationWithNestedReference() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("decl myDecl end myDecl;");
			cfg.setLine(0);
			cfg.setColumn("decl myDec".length());
			cfg.setExpectedDocumentHighlight("W [[0, 5] .. [0, 11]] | R [[0, 16] .. [0, 22]]");
		});
	}

	@Test
	public void testHighlightNestedReferenceInsideDeclaration() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("decl myDecl end myDecl;");
			cfg.setLine(0);
			cfg.setColumn("decl myDecl end myDe".length());
			cfg.setExpectedDocumentHighlight("W [[0, 5] .. [0, 11]] | R [[0, 16] .. [0, 22]]");
		});
	}
}
