/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.operation.IRunnableWithProgress;

/**
 * A project creator is used to create one or more projects.<br>
 * First the corresponding {@link IProjectInfo} is set. After that the
 * {@link #run(org.eclipse.core.runtime.IProgressMonitor)} method is called.<br>
 * If the execution successes, the result returned by {@link #getResult()} method<br>
 * will be selected and opened.
 * 
 * @author Peter Friese - Initial contribution and API
 * @author Dennis Huebner - Javadoc
 * 
 * @see XtextNewProjectWizard
 */
public interface IProjectCreator extends IRunnableWithProgress {

	/**
	 * Sets project creator configuration object.<br>
	 * A {@link IProjectInfo}, normally created by {@link XtextNewProjectWizard} subclasses,<br>
	 * is a kind of data holder for values which were collected<br>
	 * from the corresponding Wizard pages.<br>
	 * This data should be used to create a proper project<br>
	 * @see IProjectInfo
	 */
	void setProjectInfo(IProjectInfo projectInfo);

	/**
	 * <p>Result is a file that will be opened after the project creation was successfully completed.</p>
	 * (Dennis: This method name is misleading. Should be fileToOpenOnFinish or something. Consider to deprecate it in 2.4)
	 * @return {@link IFile} that should be opened after the project creation was successfully done.
	 */
	IFile getResult();

}