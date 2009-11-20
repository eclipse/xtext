/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface INamesAreUniqueValidationHelper {

	/**
	 * Create errors for objects that have the same name. Objects, that do not belong to
	 * the same cluster will not get any errors.
	 * @see INamesAreUniqueValidationHelper#checkUniqueNames(Iterable, CancelIndicator, ValidationMessageAcceptor)
	 */
	void checkUniqueNames(Iterable<IEObjectDescription> descriptions,  ValidationMessageAcceptor acceptor);
	
	/**
	 * Create errors for objects that have the same name. Objects, that do not belong to
	 * the same cluster will not get any errors. The cancel indicator may be used to interrupt 
	 * the validation.
	 */
	void checkUniqueNames(Iterable<IEObjectDescription> descriptions, CancelIndicator cancelIndicator, ValidationMessageAcceptor acceptor);

}
