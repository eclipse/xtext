/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.google.inject.Inject;

/**
 * Provide some limited but useful utilities when dealing with files that are currently in an intermediate state, e.g.
 * the builder did not pick up their contents yet.
 * 
 * @author Michael Clay
 */
public class FileOpener {

	private static final Logger logger = Logger.getLogger(FileOpener.class);

	@Inject
	private IWorkbench workbench;

	/**
	 * @param file
	 *            the file that should be selected. May be <code>null</code>.
	 */
	public void selectAndReveal(IFile file) {
		BasicNewResourceWizard.selectAndReveal(file, workbench.getActiveWorkbenchWindow());
	}

	/**
	 * <p>
	 * Opens the file in the corresponding default editor (asynchronous execution).<br>
	 * Does nothing if <code>file</code> is <code>null</code>
	 * </p>
	 * 
	 * @param shell
	 *            the parent shell. May not be <code>null</code>
	 * @param file
	 *            that should be selected.
	 */
	public void openFileToEdit(final Shell shell, final IFile file) {
		if (file == null) {
			return;
		}
		shell.getDisplay().asyncExec(new Runnable() {
			public void run() {
				final IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (final PartInitException e) {
					logger.error(e.getMessage(), e);
				}
			}
		});
	}
}
