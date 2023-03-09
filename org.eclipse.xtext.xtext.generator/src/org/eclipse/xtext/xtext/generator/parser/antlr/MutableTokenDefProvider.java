/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MutableTokenDefProvider extends AntlrTokenDefProvider {

	private final Charset encoding;
	private final KeywordHelper keywordHelper;

	/**
	 * @since 2.7
	 */
	public MutableTokenDefProvider(KeywordHelper keywordHelper, Charset encoding) {
		this.encoding = encoding;
		this.keywordHelper = keywordHelper;
	}
	
	
	@Override
	protected BufferedReader createReader(InputStream stream) {
		return new BufferedReader(new InputStreamReader(stream, encoding));
	}
	
	public void writeTokenFile(PrintWriter out) throws IOException {
		List<Map.Entry<Integer, String>> entries = Lists.newArrayList(getTokenDefMap().entrySet());
		ListExtensions.sortInplaceBy(entries, new Functions.Function1<Map.Entry<Integer, String>, String>() {
			@Override
			public String apply(Map.Entry<Integer, String> p) {
				return p.getValue();
			}
		});
		for(Map.Entry<Integer, String> entry: entries) {
			out.print(entry.getValue());
			out.print('=');
			out.println(entry.getKey());
		}
		out.close();
	}
	
	@Override
	protected boolean isKeywordToken(String antlrTokenDef) {
		if (keywordHelper != null) {
			return keywordHelper.isKeywordRule(antlrTokenDef);
		}
		return super.isKeywordToken(antlrTokenDef);
	}

	@Override
	protected void setTokenDefMap(Map<Integer, String> tokenDefMap) {
		this.tokenDefMap = tokenDefMap;
	}

}
