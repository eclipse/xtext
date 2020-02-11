/*******************************************************************************
 * Copyright (c) 2008,2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

import java.io.InputStream;
import java.util.Map;

import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;

import com.google.common.collect.ImmutableMap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemplatesTokenDefProvider implements ITokenDefProvider, IAntlrTokenFileProvider {

	private ImmutableMap<Integer, String> map;

	@Override
	public Map<Integer, String> getTokenDefMap() {
		if (map == null) {
			AntlrTokenDefProvider provider = new AntlrTokenDefProvider();
			provider.setAntlrTokenFileProvider(this);
			map = ImmutableMap.copyOf(provider.getTokenDefMap());
		}
		return map;
	}

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		String resourcePath = getClass().getPackage().getName().replace('.', '/') + "/CodetemplatesHighlightingLexer.tokens";
		InputStream result = classLoader.getResourceAsStream(resourcePath);
		return result;
	}

}
