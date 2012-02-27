/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;

/**
 * Can delete validation markers in {@link IFile} corresponding to the given {@link CheckMode}<br>
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
public class MarkerEraser {
	private final static Logger LOG = Logger.getLogger(MarkerEraser.class);

	public void deleteValidationMarkers(IFile file, CheckMode checkMode, IProgressMonitor monitor) {
		if (shouldProcess(file)) {
			try {
				deleteMarkers(file, checkMode, monitor);
			} catch (CoreException ex) {
				LOG.error(ex.getMessage(), ex);
			}
		}
	}

	/**
	 * Checks if a {@link IFile} should/can be processed
	 * 
	 * @return <code>true</code> if file is accessible and not hidden
	 */
	public final boolean shouldProcess(final IFile file) {
		return file.isAccessible() && file.getProject().isAccessible() && !file.getProject().isHidden();
	}

	/**
	 * Deletes {@link IFile}'s markers which type matches the given {@link CheckType}s represented by the
	 * {@link CheckMode}.
	 * 
	 * @see CheckType
	 * @see CheckMode#shouldCheck(CheckType)
	 * @see MarkerTypes#forCheckType(CheckType)
	 */
	public final void deleteMarkers(final IFile file, final CheckMode checkMode, final IProgressMonitor monitor)
			throws CoreException {
		for (CheckType chkType : CheckType.values()) {
			if (checkMode.shouldCheck(chkType)) {
				String markerType = MarkerTypes.forCheckType(chkType);
				file.deleteMarkers(markerType, true, IResource.DEPTH_ZERO);
			}
		}
	}
}