/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author sven efftinge
 * 
 */
public interface IElementFactory extends ILanguageService {
	
	/**
	 * creates an instance of the given typename
	 * 
	 * @param typeName
	 * @return
	 */
	public EObject create(String typeName);

	/**
	 * 
	 * sets the value to the feature of _this element
	 * 
	 * @param _this
	 * @param feature
	 * @param value
	 */
	public void set(EObject _this, String feature, Object value);

	/**
	 * adds the value to the feature of _this element
	 * 
	 * @param _this
	 * @param feature
	 * @param value
	 */
	public void add(EObject _this, String feature, Object value);

}
