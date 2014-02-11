/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.antlr.internal;

import java.io.Reader;

import org.eclipse.xtend.core.parser.InternalFlexer;
import org.eclipse.xtend.ide.contentassist.antlr.internal.InternalXtendFlexer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistFlexerFactory {

	public InternalFlexer createFlexer(Reader reader) {
		return new InternalXtendFlexer(reader);
	}
	
	public ContentAssistTokenSource createTokenSource(Reader reader) {
		return new ContentAssistTokenSource(createFlexer(reader));
	}
	
}
