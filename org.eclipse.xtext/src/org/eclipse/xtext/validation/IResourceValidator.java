/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - NULL implementation
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(ResourceValidatorImpl.class)
public interface IResourceValidator {
	/**
	 * Validates the given resource according to the {@link CheckMode mode}. An optional {@link CancelIndicator}
	 * may be provide to allow the method to exit early in case the long running validation was canceled by the
	 * user.
	 * 
	 * @return all issues of the underlying resources (includes syntax errors as well as semantic problems)
	 * @throws OperationCanceledError if the validation was cancelled, the method may exit with an {@link OperationCanceledError}
	 */
	List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator) throws OperationCanceledError;

	IResourceValidator NULL = new IResourceValidator() {
		@Override
		public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator) {
			return Collections.emptyList();
		}
	};
}
