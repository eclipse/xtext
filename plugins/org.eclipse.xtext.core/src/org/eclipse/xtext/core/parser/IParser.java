/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.core.parser;

import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface IParser {
	
	/**
	 * @param in
	 * @param factory
	 * @param handler
	 * @return
	 */
	EObject parse(InputStream in, IElementFactory factory, IParseErrorHandler handler);
	
	/**
	 * @param in
	 * @param factory
	 * @return
	 */
	EObject parse(InputStream in, IElementFactory factory);
	
	/**
	 * @param in
	 * @param factory
	 * @return
	 */
	EObject parse(InputStream in);
}
