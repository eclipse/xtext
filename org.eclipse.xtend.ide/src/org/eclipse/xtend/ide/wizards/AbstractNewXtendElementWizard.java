/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class AbstractNewXtendElementWizard extends NewElementWizard {

	private AbstractNewXtendElementWizardPage page;

	public AbstractNewXtendElementWizard(IImageDescriptorHelper imgHelper, AbstractNewXtendElementWizardPage page, String title) {
		this.page= page;
		ImageDescriptor image = imgHelper.getImageDescriptor("xtend_wizard_big.png");
		setDefaultPageImageDescriptor(image);
		setDialogSettings(JavaPlugin.getDefault().getDialogSettings());
		setWindowTitle(title);
	}

	@Override
	public void addPages() {
		super.addPages();
		page.init(getSelection());
		super.addPage(page);
	}

	@Override
	protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
	}

	@Override
	public IJavaElement getCreatedElement() {
		return null;
	}

	@Override
	public boolean performFinish() {
		final int size = this.page.createType();
		final IResource resource = page.getResource();
		if(resource != null) {
			selectAndReveal(resource);
			final Display display= getShell().getDisplay();
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					IEditorPart editor;
					try {
						editor = IDE.openEditor(JavaPlugin.getActivePage(), (IFile) resource);
						if (editor instanceof ITextEditor) {
							((ITextEditor) editor).selectAndReveal(size -2, 0);
						}
					} catch (PartInitException e) {
						throw new RuntimeException(e);
					}
				}
			});
			return true;
		} else {
			return false;
		}
	}
}
