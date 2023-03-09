/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

/**
 * This class contains custom formatting description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * @deprecated use {@link org.eclipse.xtext.xbase.annotations.formatting2.XbaseWithAnnotationsFormatter}
 *   instead.
 */
@Deprecated
public class XbaseWithAnnotationsFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
// It's usually a good idea to activate the following three statements.
// They will add and preserve newlines around comments
//		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getSL_COMMENTRule());
//		c.setLinewrap(0, 1, 2).before(getGrammarAccess().getML_COMMENTRule());
//		c.setLinewrap(0, 1, 1).after(getGrammarAccess().getML_COMMENTRule());
	}
}
