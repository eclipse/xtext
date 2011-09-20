/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.ImplementedBy;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
@ImplementedBy(DefaultResourceUIValidatorExtension.class)
public interface IResourceUIValidatorExtension {

	/**
	 * Update the validation markers of the given file
	 * 
	 * @param file
	 *            the file to create validation markers for
	 * @param resource
	 *            the resource corresponding to the given file
	 * @param mode
	 *            the mode (normal,fast,expensive) of the validation
	 */
	void updateValidationMarkers(IFile file, Resource resource, CheckMode mode, IProgressMonitor monitor);

	/**
	 * Delete all validation markers corresponding to the given checkMode on the passed in file
	 * 
	 * @param file
	 *            the file to create validation markers for
	 * @param checkMode
	 *            the mode (normal,fast,expensive) of the validation
	 */
	void deleteValidationMarkers(IFile file, CheckMode checkMode, IProgressMonitor monitor);
}
