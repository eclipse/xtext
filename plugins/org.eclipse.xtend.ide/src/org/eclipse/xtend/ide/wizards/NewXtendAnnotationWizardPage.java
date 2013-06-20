/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class NewXtendAnnotationWizardPage extends AbstractNewXtendElementWizardPage {

	public NewXtendAnnotationWizardPage() {
		super(ANNOTATION_TYPE, NewXtendAnnotationWizard.TITLE);
		this.setTitle(NewXtendAnnotationWizard.TITLE);
		this.setDescription(Messages.XTEND_ANNOTATION_WIZARD_DESCRIPTION);
	}

	public void createControl(Composite parent) {
		setControl(createCommonControls(parent));
	}

	@Override
	protected void doStatusUpdate() {
		IStatus[] status = new IStatus[] { fContainerStatus, fPackageStatus, fTypeNameStatus };
		updateStatus(status);
	}

	@Override
	protected int createXtendElement(IProgressMonitor monitor, IFile xtendFile, String indentation, String lineSperator) {
		int size = 0;
		try {
			String contents = XtendTypeCreatorUtil.createAnnotation(
					getTypeName(),
					getPackageFragment(),
					indentation,
					lineSperator,
					monitor);
			size = contents.length();
			xtendFile.create(new ByteArrayInputStream(contents.getBytes()), true, monitor);
			setResource(xtendFile);
		} catch (CoreException e) {
			displayError(Messages.ERROR_CREATING_ANNOTATION, e.getMessage());
		}
		return size;
	}

	@Override
	protected String getElementCreationErrorMessage() {
		return Messages.ERROR_CREATING_ANNOTATION;
	}

}
