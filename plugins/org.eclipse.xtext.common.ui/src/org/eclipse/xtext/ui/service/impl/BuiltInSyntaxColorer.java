/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.service.ISyntaxColorer;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.service.utils.PropertiesResolver;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;

/**
 * @author Dennis Hübner
 * 
 */
public class BuiltInSyntaxColorer implements ISyntaxColorer {

	private ITokenTypeDefProvider tokenTypeDef;
	private Map<String, TextStyle> styleCache = new HashMap<String, TextStyle>();
	private PropertiesResolver propertiesResolver;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.service.ISyntaxColorer#color(org.eclipse.xtext
	 * .parsetree.LeafNode)
	 */
	public TextStyle color(LeafNode leafNode) {
		for (ITokenTypeDef ttd : tokenTypeDef.allTokenTypes()) {
			if (ttd.match(leafNode)) {
				String tokenTpeDefId = ttd.getId();
				TextStyle ts = styleCache.get(tokenTpeDefId);
				if (ts == null) {
					ts = new TextStyle();
					propertiesResolver.populateTextStyle(tokenTpeDefId, ts, ttd.defaultTextStyle());
					styleCache.put(tokenTpeDefId, ts);
				}
				return ts;
			}
		}
		return null;
	}

	@Inject
	public void setTokenTypeDefProvider(ITokenTypeDefProvider service) {
		this.tokenTypeDef = service;
	}

	@Inject
	public void setServiceScope(IServiceScope serviceScope) {
		propertiesResolver = new PropertiesResolver(serviceScope);
	}

	public void clearCache() {
		styleCache.clear();
	}
}
