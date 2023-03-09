/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * Used by clients to establish associations between source elements and inferred JVM elements.
 * 
 * @see IJvmModelAssociations
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @since 2.7
 */
@ImplementedBy(JvmModelAssociator.class)
public interface IJvmModelAssociator {

	/**
	 * Associated the given source element with the given jvmElement.
	 * @param sourceElement the source EObject
	 * @param jvmElement the inferred EObject
	 */
	void associate(EObject sourceElement, EObject jvmElement);

	/**
	 * Associated the given source element with the given jvmElement and marks the association as primary
	 * on both sides.
	 * 
	 * @param sourceElement the source EObject
	 * @param jvmElement the inferred EObject
	 */
	void associatePrimary(EObject sourceElement, EObject jvmElement);
	
	/**
	 * Sets the given {@link JvmIdentifiableElement} as the logical container of the given {@link XExpression}.
	 * The container must be an instanceof {@link JvmExecutable} or {@link JvmField}.
	 * The logical container is used to scope and link the given expression.
	 * 
	 * Associating the logical container of an expression, automatically removes any previously logical containers for the given expression.
	 * 
	 *  @param expression the expression that is put into a scope
	 *  @param logicalContainer a method, constructor or field that should act as the logical container of the given expression
	 */
	void associateLogicalContainer(XExpression expression, JvmIdentifiableElement logicalContainer);
	
	/**
	 * Removes the logically contained child of the given identifiable.
	 */
	void removeLogicalChildAssociation(JvmIdentifiableElement logicalContainer);
	
	/**
	 * Removes an association between the given source and jvm elements.
	 * 
	 * @throws IllegalArgumentException if the given source element is null; if the given jvm element is null or dangling; if elements does not belong to the same resource
	 */
	void removeAssociation(EObject sourceElement, EObject jvmElement);
	
	/**
	 * Removes all associations for the given jvm element. 
	 * 
	 * @throws IllegalArgumentException if the give jvm element is null or dangling
	 */
	void removeAllAssociation(EObject jvmElement);
	
}
