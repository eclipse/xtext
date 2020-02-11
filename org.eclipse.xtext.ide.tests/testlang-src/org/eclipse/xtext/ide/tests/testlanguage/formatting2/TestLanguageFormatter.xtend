/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.formatting2

import javax.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class TestLanguageFormatter extends AbstractFormatter2 {
	
	@Inject extension TestLanguageGrammarAccess

	def dispatch void format(Model model, extension IFormattableDocument document) {
		for (type : model.elements) {
			type.format
		}	
	}
	
	def dispatch void format(TypeDeclaration type, extension IFormattableDocument document) {
		//type.regionFor.keyword(typeDeclarationAccess.leftCurlyBracketKeyword_2).prepend[oneSpace]
		type.regionFor.keyword(typeDeclarationAccess.leftCurlyBracketKeyword_3).append[newLine]
		type.regionFor.keyword(typeDeclarationAccess.rightCurlyBracketKeyword_5).prepend[newLine].append[newLine]
		interior(
			type.regionFor.keyword(typeDeclarationAccess.leftCurlyBracketKeyword_3),
			type.regionFor.keyword(typeDeclarationAccess.rightCurlyBracketKeyword_5)
		) [indent]
		for (property : type.members.filter(Property)) {
			property.format
		}	
	}
	def dispatch void format(Property property, extension IFormattableDocument document) {
		property.append[newLine]
	}
	
}