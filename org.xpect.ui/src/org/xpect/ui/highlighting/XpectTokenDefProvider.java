/*******************************************************************************
 * Copyright (c) 2008,2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.highlighting;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import com.google.common.collect.ImmutableMap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectTokenDefProvider implements ITokenDefProvider, IAntlrTokenFileProvider {

	private ImmutableMap<Integer, String> map;

	public Map<Integer, String> getTokenDefMap() {
		if (map == null) {
			AntlrTokenDefProvider provider = new AntlrTokenDefProvider();
			provider.setAntlrTokenFileProvider(this);
			map = ImmutableMap.copyOf(provider.getTokenDefMap());
		}
		return map;
	}

	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		String resourcePath = "org/xpect/lexer/XpectHI.tokens";
		InputStream result = classLoader.getResourceAsStream(resourcePath);
		return result;
	}

}
