/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface ILanguageFacade {
	
	/**
	 * @return
	 */
	String getLanguageId();
	
	/**
	 * @return
	 */
	IElementFactory getElementFactory();
	
	/**
	 * @return
	 */
	IParser getParser();
	
	/**
	 * @return
	 */
	IParseTreeConstructor getParsetreeConstructor();
	
	/**
	 * @return
	 */
	Grammar getGrammar();
	
	/**
	 * @return
	 */
	EPackage[] getGeneratedEPackages();
	
	/**
	 * @return
	 */
	Resource.Factory getResourceFactory();
	
	/**
	 * @return
	 */
	String getModelFileExtension();
}
