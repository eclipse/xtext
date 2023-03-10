/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ITokenScanner;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Dennis Hübner - Initial contribution and API
 */
public abstract class AbstractTokenScanner implements ITokenScanner {

	@Inject
	private ITextAttributeProvider textAttributeProvider;
	
	public void setTextAttributeProvider(ITextAttributeProvider textAttributeProvider) {
		this.textAttributeProvider = textAttributeProvider;
	}

	public ITextAttributeProvider getTextAttributeProvider() {
		return textAttributeProvider;
	}
	
	protected TextAttribute getAttribute(String id) {
		return textAttributeProvider.getAttribute(id);
	}

}
