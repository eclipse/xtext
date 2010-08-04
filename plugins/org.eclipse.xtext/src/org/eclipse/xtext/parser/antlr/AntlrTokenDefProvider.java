/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
@Singleton
public class AntlrTokenDefProvider implements ITokenDefProvider {
	
	private static final Logger log = Logger.getLogger(AntlrTokenDefProvider.class);
	
	@Inject
	private IAntlrTokenFileProvider antlrTokenFileProvider;
	
	protected volatile Map<Integer, String> tokenDefMap;
	
	private static final String TOKEN_COUNT = "Tokens";
	
	public Map<Integer, String> getTokenDefMap() {
		if (antlrTokenFileProvider == null)
			return Collections.emptyMap();
		if (tokenDefMap == null) {
			InputStream tokenFile = antlrTokenFileProvider.getAntlrTokenFile();
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(tokenFile));
				Map<Integer, String> tokenDefMap = new HashMap<Integer, String>();
				String line = br.readLine();
				Pattern pattern = Pattern.compile("(.*)=(\\d+)");
				while (line != null) {
					Matcher m = pattern.matcher(line);
					if (!m.matches()) {
						throw new IllegalStateException("Couldn't match line : '" + line + "'");
					}

					int antlrTokenType = Integer.parseInt(m.group(2));
					String antlrTokenDef = m.group(1);
					if (!TOKEN_COUNT.equals(antlrTokenDef)) {
						if (antlrTokenDef.startsWith("'")) {
							antlrTokenDef = antlrTokenDef.substring(1, antlrTokenDef.length() - 1);
							antlrTokenDef = Strings.convertFromJavaString(antlrTokenDef, true);
							antlrTokenDef = "'" + antlrTokenDef + "'";
						}
						tokenDefMap.put(antlrTokenType, antlrTokenDef);
					}
					line = br.readLine();
				}
				setTokenDefMap(tokenDefMap);
			} catch (Exception e) {
				log.error(e, e);
				tokenDefMap = null;
				throw new WrappedException(e);
			} finally {
				try {
					tokenFile.close();
				} catch (IOException e) {
					//ignore
				}
			}
		}
		return tokenDefMap;
	}

	protected void setTokenDefMap(Map<Integer, String> tokenDefMap) {
		this.tokenDefMap = ImmutableMap.copyOf(tokenDefMap);
	}
	
	public void setAntlrTokenFileProvider(IAntlrTokenFileProvider antlrTokenFileProvider) {
		this.antlrTokenFileProvider = antlrTokenFileProvider;
	}

	public IAntlrTokenFileProvider getAntlrTokenFileProvider() {
		return antlrTokenFileProvider;
	}
}
