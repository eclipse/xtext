/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("deprecation")
public class FormattingConfig2 extends FormattingConfig {

	protected ILineSeparatorInformation lineSeparatorInfo;

	public FormattingConfig2(IGrammarAccess grammarAccess, IHiddenTokenHelper hiddenTokenHelper,
			IIndentationInformation indentInfo, ILineSeparatorInformation lineSeparatorInfo) {
		super(grammarAccess, hiddenTokenHelper, indentInfo);
		this.lineSeparatorInfo = lineSeparatorInfo;
	}

	public ILineSeparatorInformation getLineSeparatorInfo() {
		return lineSeparatorInfo;
	}
}
