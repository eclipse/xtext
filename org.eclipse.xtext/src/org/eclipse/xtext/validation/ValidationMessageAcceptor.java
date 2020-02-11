/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <p>A validation message acceptor provides the minimal necessary API to create
 * error and warning messages that are associated with a feature value or with
 * a range in the input source.</p>
 * 
 * <p>Partial implementations will usually inherit from {@link AbstractValidationMessageAcceptor}.</p>
 * 
 * @author Sebastian Zarnekow - initial contribution and API
 */
public interface ValidationMessageAcceptor {

	int INSIGNIFICANT_INDEX = -1;
	
	/**
	 * Annotate an instance, a feature value, or all feature values with an error.
	 * @param message the error message. May not be <code>null</code>.
	 * @param object the object or the feature holder. May not be <code>null</code>.
	 * @param feature the feature or <code>null</code> if the complete instance should be annotated.
	 * @param index the index of the erroneous value or <code>-1</code> if all values are considered to be invalid. The index is ignored if
	 *   the feature is null or the feature is a single value feature.
	 * @param code the optional issue code.
	 * @param issueData the optional issue data.
	 */
	void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String...issueData);
	
	/**
	 * Annotate a range of the resource with an error.
	 * @param message the error message. May not be <code>null</code>.
	 * @param offset the absolute offset in the resource. 
	 * @param length the length of the erroneous range.
	 * @param code the optional issue code.
	 * @param issueData the optional issue data.
	 * @throws IndexOutOfBoundsException if the offset or the length is invalid.
	 */
	void acceptError(String message, EObject object, int offset, int length, String code, String...issueData);
	
	/**
	 * Annotate an instance, a feature value, or all feature values with a warning.
	 * @param message the warning message. May not be <code>null</code>.
	 * @param object the object or the feature holder. May not be <code>null</code>.
	 * @param feature the feature or <code>null</code> if the complete instance should be annotated.
	 * @param index the index of the relevant value or <code>-1</code> if all values are considered to be affected. The index is ignored if
	 *   the feature is null or the feature is a single value feature.
	 * @param code the optional issue code.
	 * @param issueData the optional issue data.
	 */
	void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData);
	
	/**
	 * Annotate a range of the resource with a warning.
	 * @param message the warning message. May not be <code>null</code>.
	 * @param offset the absolute offset in the resource. 
	 * @param length the length of the invalid range.
	 * @param code the optional issue code.
	 * @param issueData the optional issue data.
	 * @throws IndexOutOfBoundsException if the offset or the length is invalid.
	 */
	void acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData);
	
	/**
	 * Annotate an instance, a feature value, or all feature values with an info message.
	 * @param message the info message. May not be <code>null</code>.
	 * @param object the object or the feature holder. May not be <code>null</code>.
	 * @param feature the feature or <code>null</code> if the complete instance should be annotated.
	 * @param index the index of the interesting value or <code>-1</code> if all values are considered to be interesting. The index is ignored if
	 *   the feature is null or the feature is a single value feature.
	 * @param code the optional issue code.
	 * @param issueData the optional issue data.
	 */
	void acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData);
	
	/**
	 * Annotate a range of the resource with an info message..
	 * @param message the info message. May not be <code>null</code>.
	 * @param offset the absolute offset in the resource. 
	 * @param length the length of the annotated range.
	 * @param code the optional issue code.
	 * @param issueData the optional issue data.
	 * @throws IndexOutOfBoundsException if the offset or the length is invalid.
	 */
	void acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData);
}