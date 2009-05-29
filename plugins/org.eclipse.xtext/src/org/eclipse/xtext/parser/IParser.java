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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IParser {
	
	IParseResult parse(InputStream in);
	
    IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change);
    
}
