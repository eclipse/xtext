/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@ImplementedBy(JvmModelAssociator.class)
public interface IJvmModelAssociator {

	void associate(EObject sourceElement, EObject jvmElement);

	void associatePrimary(EObject sourceElement, EObject jvmElement);
	
	void associateLogicalContainer(EObject logicalChild, JvmIdentifiableElement logicalContainer);
	
	void removeLogicalChildAssociation(JvmIdentifiableElement logicalContainer);
}
