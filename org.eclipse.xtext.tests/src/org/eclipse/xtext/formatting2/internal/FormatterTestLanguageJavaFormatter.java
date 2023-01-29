/*******************************************************************************
 * Copyright (c) 2020, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;

import com.google.inject.Inject;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
public class FormatterTestLanguageJavaFormatter extends AbstractJavaFormatter {

	@Inject
	FormatterTestLanguageGrammarAccess grammar;

	protected void format(IDList list, IFormattableDocument doc) {
		doc.prepend(regionFor(list).keyword("idlist"), it -> it.noSpace());
		regionFor(list).ruleCallsTo(grammar.getIDRule()).forEach(region -> doc.prepend(region, it -> it.oneSpace()));
		doc.append(list, this::noSpace);
	}

}
