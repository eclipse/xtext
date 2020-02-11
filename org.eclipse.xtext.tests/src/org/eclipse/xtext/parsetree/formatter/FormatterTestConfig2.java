/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguage2GrammarAccess;

/**
 * @author dietrich - Initial contribution and API
 */
public class FormatterTestConfig2 extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		FormatterTestLanguage2GrammarAccess f = (FormatterTestLanguage2GrammarAccess) getGrammarAccess();
		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());
		c.setLinewrap(2).between(f.getRootAccess().getLeftCurlyBracketKeyword_2(), f.getSL_COMMENTRule());
	}

}
