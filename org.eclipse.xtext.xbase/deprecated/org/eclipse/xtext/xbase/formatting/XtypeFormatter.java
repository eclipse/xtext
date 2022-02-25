/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess.JvmParameterizedTypeReferenceElements;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess.XFunctionTypeRefElements;

/**
 * This class is deprecated since it uses Xtext's old formatter architecture.
 * 
 * @deprecated use {@link XbaseFormatter}
 */
@Deprecated
public class XtypeFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		configure(c, (XtypeGrammarAccess) getGrammarAccess());
	}

	public void configure(FormattingConfig c, XtypeGrammarAccess ga) {
		configureXFunctionTypeRef(c, ga.getXFunctionTypeRefAccess());
		configureJvmParameterizedTypeReference(c, ga.getJvmParameterizedTypeReferenceAccess());
	}

	public void configureXFunctionTypeRef(FormattingConfig c, XFunctionTypeRefElements ele) {
		c.setNoSpace().after(ele.getLeftParenthesisKeyword_0_0());
		c.setNoSpace().before(ele.getCommaKeyword_0_1_1_0());
		c.setNoSpace().before(ele.getRightParenthesisKeyword_0_2());
	}

	public void configureJvmParameterizedTypeReference(FormattingConfig c, JvmParameterizedTypeReferenceElements ele) {
		c.setNoSpace().after(ele.getLessThanSignKeyword_1_0());
		c.setNoSpace().before(ele.getCommaKeyword_1_2_0());
		c.setNoSpace().before(ele.getGreaterThanSignKeyword_1_3());
	}
}
