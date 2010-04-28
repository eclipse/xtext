/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sven Efftinge
 */
public interface IAstFactory {

	/**
	 * creates an instance of the given type
	 * 
	 * @param typeName
	 * @return
	 */
	EObject create(EClassifier clazz);

	/**
	 * 
	 * sets the value to the feature of _this element
	 * 
	 * @param _this
	 * @param feature
	 * @param value
	 * @throws RecognitionException
	 */
	void set(EObject _this, String feature, Object value, String lexerRule, AbstractNode node)
			throws ValueConverterException;

	/**
	 * adds the value to the feature of _this element
	 * 
	 * @param _this
	 * @param feature
	 * @param value
	 */
	void add(EObject _this, String feature, Object value, String lexerRule, AbstractNode node)
			throws ValueConverterException;

}
