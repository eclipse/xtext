/*******************************************************************************
 * Copyright (c) 2019 Sigasi N.V. (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.xtext.testing.AbstractLanguageServerTest
import org.junit.Test

/**
 * Class for testing the highlighting of reference that refer to the object in which they are embedded.
 */
class DocumentHighlightTest2 extends AbstractLanguageServerTest {

	new() {
		super('nestedRefs');
	}

	@Test
	def void testHighlightDeclarationWithNestedReference() {
		testDocumentHighlight[
			model = '''
				decl myDecl end myDecl;
			''';

			line = 0
			column = '''decl myDec'''.length;
			expectedDocumentHighlight = 'W [[0, 5] .. [0, 11]] | R [[0, 16] .. [0, 22]]';
		];
	}
	
		@Test
	def void testHighlightNestedReferenceInsideDeclaration() {
		testDocumentHighlight[
			model = '''
				decl myDecl end myDecl;
			''';

			line = 0
			column = '''decl myDecl end myDe'''.length;
			expectedDocumentHighlight = 'W [[0, 5] .. [0, 11]] | R [[0, 16] .. [0, 22]]';
		];
	}
}
