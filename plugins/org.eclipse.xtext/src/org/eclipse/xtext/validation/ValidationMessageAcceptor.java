/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Sebastian Zarnekow - initial contribution and API
 */
public interface ValidationMessageAcceptor {

	void acceptError(String message, EObject object, Integer feature, String code);
	
	void acceptWarning(String message, EObject object, Integer feature, String code);
	
}