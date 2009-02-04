/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyle;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyleProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrTokenStyleProvider implements ITokenStyleProvider {

	@Inject
	private ITokenDefProvider tokenDefProvider;
	
	@Inject
	private ITokenColorer tc;
	
	private ITokenStyle[] styles;
	
	public ITokenStyle[] getTokenStyles() {
		if (styles == null) {
			List<ITokenStyle> allTokenStyles = new ArrayList<ITokenStyle>();
			for (Integer id : tokenDefProvider.getTokenDefMap().keySet()) {
				ITokenStyle tokenStyle = tc.getTokenStyle(Integer.toString(id));
				if (!allTokenStyles.contains(tokenStyle)) {
					allTokenStyles.add(tokenStyle);
				}
			}
			styles = allTokenStyles.toArray(new ITokenStyle[allTokenStyles.size()]);
		}
		return styles;
	}

}
