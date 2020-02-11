/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.formatting2

import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node

class PartialSerializationTestLanguageFormatter extends AbstractFormatter2 {

//	@Inject extension PartialSerializationTestLanguageGrammarAccess
	dispatch def format(Node obj, extension IFormattableDocument document) {
		for (r : obj.regionFor.keywords(";")) {
			r.prepend[noSpace].append[oneSpace]
		}
		for (child : obj.children) {
			child.format
		}
	}

}
