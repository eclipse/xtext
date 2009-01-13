/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.InputStream;

import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface IParser extends ILanguageService {
	
	/**
	 * @param in
	 * @param factory
	 * @param handler
	 * @return
	 */
	IParseResult parse(InputStream in, IAstFactory factory);
	
	/**
	 * @param in
	 * @param handler
	 * @return
	 */
	IParseResult parse(InputStream in);
	
    /**
     * @param in
     * @param handler
     * @return
     */
    IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change);
}
