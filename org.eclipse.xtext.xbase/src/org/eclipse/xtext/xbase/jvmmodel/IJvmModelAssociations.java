/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * Facade to mappings between source elements, i.e. the EObjects parsed from the source and the 
 * JVM elements, i.e. the inferred elements inferred during {@link IJvmModelInferrer#infer(EObject, IJvmDeclaredTypeAcceptor, boolean)}
 * 
 * @see IJvmModelAssociator
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @since 2.7
 */
@ImplementedBy(JvmModelAssociator.class)
public interface IJvmModelAssociations {

	/**
	 * @return all source elements associated with the given JVM element.
	 */
	Set<EObject> getSourceElements(EObject jvmElement);

	/**
	 * @return all JVM elements associated with the given source element.
	 */
	Set<EObject> getJvmElements(EObject sourceElement);

	/**
	 * @return the primary source element for the given JVM element.
	 */
	EObject getPrimarySourceElement(EObject jvmElement);

	/**
	 * @return the primary JVM element for the given source element.
	 */
	EObject getPrimaryJvmElement(EObject sourceElement);

	/**
	 * @return whether the given JVM element is a primary JVM element.
	 */
	boolean isPrimaryJvmElement(EObject jvmElement);

}
