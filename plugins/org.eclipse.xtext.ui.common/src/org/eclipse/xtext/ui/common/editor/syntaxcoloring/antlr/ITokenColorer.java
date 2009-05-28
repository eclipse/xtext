/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr;

import org.eclipse.xtext.ui.common.editor.syntaxcoloring.CommonTokenStyles;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyle;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
@ImplementedBy(ITokenColorer.NullTokenColorer.class)
public interface ITokenColorer {

	ITokenStyle getTokenStyle(String antlrTokenType);

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public static class NullTokenColorer implements ITokenColorer {

		public ITokenStyle getTokenStyle(String antlrTokenType) {
			return CommonTokenStyles.DEFAULT;
		}

	}
}