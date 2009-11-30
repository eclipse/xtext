/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.issues.Issues;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IResourceValidator {
	/**
	 * @return all issues of the underlying resources (includes syntax as well as semantic problems)
	 */
	Set<Issues> validate(Resource resource, CheckMode mode, CancelIndicator indicator);
}
