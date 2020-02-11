/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

/**
 * Responsible for instantiating and initializing the semantic model according
 * to call backs from clients. Main (and only default) client is the parser. 
 * 
 * @author Sven Efftinge
 */
public interface IAstFactory {

	/**
	 * Creates an instance of the given type which has to be an 
	 * {@link org.eclipse.emf.ecore.EClass EClass}.
	 * 
	 * @param clazz the {@link org.eclipse.emf.ecore.EClass EClass} to be instantiated.
	 * @return the instantiated {@link EObject} which must conform the given class.
	 */
	EObject create(EClassifier clazz);

	/**
	 * Assigns a given value to a feature of the element <code>_this</code>. The value may be converted
	 * according to the optional lexer rule. 
	 * The feature must be resolvable to a single value feature.
	 * 
	 * @throws ValueConverterException if the value cannot be converted.
	 */
	void set(EObject _this, String feature, Object value, String lexerRule, INode node)
			throws ValueConverterException;

	/**
	 * Adds a given value to a list described by the given feature. The list is owned by
	 * the element <code>_this</code>. The given value may be converted
	 * according to the optional lexer rule. 
	 * The feature must be resolvable to a multi value feature.
	 * 
	 * @throws ValueConverterException if the value cannot be converted.
	 */
	void add(EObject _this, String feature, Object value, String lexerRule, INode node)
			throws ValueConverterException;

}
