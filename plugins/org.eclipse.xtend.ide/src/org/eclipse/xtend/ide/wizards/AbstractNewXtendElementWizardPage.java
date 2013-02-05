/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.dialogs.StatusInfo;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public abstract class AbstractNewXtendElementWizardPage extends NewTypeWizardPage {

	protected static final int COLS = 4;

	private IResource resource;

	@Inject
	private FieldInitializerUtil util;

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	public AbstractNewXtendElementWizardPage(int typeKind, String title) {
		super(typeKind, title);
	}

	protected abstract void doStatusUpdate();

	protected abstract String getElementCreationErrorMessage();

	protected abstract int createXtendElement(IProgressMonitor monitor, IFile xtendFile, String indentation,
			String lineSeperator);

	protected Composite createCommonControls(Composite parent) {
		initializeDialogUnits(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());
		GridLayout layout = new GridLayout();
		layout.numColumns = COLS;
		composite.setLayout(layout);
		createContainerControls(composite, COLS);
		createPackageControls(composite, COLS);
		createSeparator(composite, COLS);
		createTypeNameControls(composite, COLS);
		return composite;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			setFocus();
		}
	}

	protected void init(IStructuredSelection selection) {
		IJavaElement elem = util.getSelectedResource(selection);
		initContainerPage(elem);
		initTypePage(elem);
	}

	@Override
	public void createType(IProgressMonitor monitor) throws CoreException, InterruptedException {
		throw new UnsupportedOperationException();
	}

	protected int createType() {
		final int[] size = { 0 };
		IRunnableWithProgress op = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				try {
					if (monitor == null) {
						monitor = new NullProgressMonitor();
					}
					if (!getPackageFragment().exists()) {
						try {
							getPackageFragmentRoot().createPackageFragment(getPackageFragment().getElementName(), true,
									monitor);
						} catch (JavaModelException e) {
							displayError(Messages.ERROR_CREATING_PACKAGE, e.getMessage());
						}
					}
					IResource res = getPackageFragment().getResource();
					IFile xtendFile = ((IFolder) res).getFile(getTypeName() + ".xtend"); //$NON-NLS-1$
					URI uri = storage2UriMapper.getUri(xtendFile);
					size[0] = createXtendElement(monitor, xtendFile, whitespaceInformationProvider
							.getIndentationInformation(uri).getIndentString(), whitespaceInformationProvider
							.getLineSeparatorInformation(uri).getLineSeparator());
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), getElementCreationErrorMessage(), realException.getMessage());
		}
		return size[0];
	}

	protected void displayError(final String title, final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(getShell(), title, message);
			}
		});
	}

	/*
	 * @see NewContainerWizardPage#handleFieldChanged
	 */
	@Override
	protected void handleFieldChanged(String fieldName) {
		super.handleFieldChanged(fieldName);
		doStatusUpdate();
	}

	@Override
	protected IStatus typeNameChanged() {
		IPackageFragment packageFragment = getPackageFragment();
		if (packageFragment != null) {
			IResource resource = packageFragment.getResource();
			if (resource instanceof IFolder) {
				IFolder folder = (IFolder) resource;
				if (folder.getFile(getTypeName() + ".xtend").exists()) { //$NON-NLS-1$
					String packageName = ""; //$NON-NLS-1$
					if (!packageFragment.isDefaultPackage()) {
						packageName = packageFragment.getElementName() + "."; //$NON-NLS-1$
					}
					return new StatusInfo(IStatus.ERROR, Messages.TYPE_EXISTS_0 + packageName + getTypeName()
							+ Messages.TYPE_EXISTS_1);
				}
			}
		}
		return super.typeNameChanged();
	}

	public IResource getResource() {
		return resource;
	}

	protected void setResource(IResource resource) {
		this.resource = resource;
	}
}
