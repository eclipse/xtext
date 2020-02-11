/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(NamesAreUniqueValidationHelper.class)
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
