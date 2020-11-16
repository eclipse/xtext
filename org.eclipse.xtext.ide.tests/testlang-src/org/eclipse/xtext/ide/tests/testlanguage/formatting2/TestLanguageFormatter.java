/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.formatting2;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.AbstractElement;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Model;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;

import com.google.inject.Inject;

/**
 * @author cdietrich - Initial contribution and API
 */
public class TestLanguageFormatter extends AbstractJavaFormatter {
	
	@Inject
	private TestLanguageGrammarAccess ga;
	
	protected void format(Model model, IFormattableDocument doc) {
		for (AbstractElement type : model.getElements()) {
			doc.format(type);
		}
	}
	
	protected void format(TypeDeclaration type, IFormattableDocument doc) {
		ISemanticRegionsFinder region = regionFor(type);
		ISemanticRegion leftCurlyKeyword = region.keyword(ga.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3());
		doc.append(leftCurlyKeyword, it -> it.newLine());
		ISemanticRegion rightCurlyKeyword = region
				.keyword(ga.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5());
		doc.prepend(rightCurlyKeyword, it -> it.newLine());
		doc.append(rightCurlyKeyword, it -> it.newLine());
		doc.interior(leftCurlyKeyword, rightCurlyKeyword, it -> it.indent());
		type.getMembers().stream().filter(Property.class::isInstance).forEach(property -> {
			doc.format(property);
		});
	}
	
	protected void format(Property property, IFormattableDocument doc) {
		doc.append(property, it -> it.newLine());
	}

}
