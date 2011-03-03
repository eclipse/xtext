/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IJvmModelAssociator {

	void associate(EObject sourceElement, EObject jvmElement);

	void associatePrimary(EObject sourceElement, EObject jvmElement);
	
	void disassociate(EObject rootElement);
}
