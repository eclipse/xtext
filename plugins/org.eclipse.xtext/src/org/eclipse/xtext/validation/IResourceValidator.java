/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.List;
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
	 * @return all issues of the underlying resources (includes syntax errors as well as semantic problems)
	 */
	List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator);
	
	public static IResourceValidator NULL = new IResourceValidator() {
		public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator) {
			return Collections.emptyList();
		}
	};
}
