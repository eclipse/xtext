/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.jdt.internal.core.PackageFragment;
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
 * @author Anton Kosyakov - https://bugs.eclipse.org/bugs/show_bug.cgi?id=379220
 */
@SuppressWarnings("restriction")
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

	protected int createXtendElement(IProgressMonitor monitor, IFile xtendFile, String indentation, String lineSeparator) {
		int size = 0;
		try {
			String content = createContent(monitor, xtendFile, indentation, lineSeparator);
			size = content.length();
			xtendFile.create(new ByteArrayInputStream(content.getBytes()), true, monitor);
			setResource(xtendFile);
		} catch (CoreException e) {
			displayError(getElementCreationErrorMessage(), e.getMessage());
		}
		return size;
	}

	private String createContent(IProgressMonitor monitor, IFile xtendFile, String indentation, String lineSeparator) throws CoreException {
		ICompilationUnit compilationUnit = getCompilationUnitStub();
		String fileComment = getFileComment(compilationUnit, lineSeparator);
		String typeComment = getTypeComment(compilationUnit, lineSeparator);
		
		String typeContent = getTypeContent(indentation, lineSeparator);
		String packageDeclaration = getPackageDeclaration(lineSeparator);
		return StubUtilityProxy.getCompilationUnitContent(compilationUnit, packageDeclaration, fileComment, typeComment, typeContent, lineSeparator);
	}

	protected abstract String getPackageDeclaration(String lineSeparator);

	protected abstract String getTypeContent(String indentation, String lineSeparator);

	private ICompilationUnit getCompilationUnitStub() {
		String compilationUnitName = getCompilationUnitName(getTypeName());
		return new CompilationUnit((PackageFragment) getPackageFragment(), compilationUnitName, DefaultWorkingCopyOwner.PRIMARY);
	}

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
				if (monitor == null) {
					monitor = new NullProgressMonitor();
				}
				try {
					if (!getPackageFragment().exists()) {
						try {
							getPackageFragmentRoot().createPackageFragment(getPackageFragment().getElementName(), true,
									monitor);
						} catch (JavaModelException e) {
							displayError(Messages.ERROR_CREATING_PACKAGE, e.getMessage());
						}
					}
					IResource res = getPackageFragment().getResource();
					IFile xtendFile = ((IFolder) res).getFile(getTypeNameWithoutParameters() + ".xtend"); //$NON-NLS-1$
					URI uri = storage2UriMapper.getUri(xtendFile);
					size[0] = createXtendElement(monitor, xtendFile, whitespaceInformationProvider
							.getIndentationInformation(uri).getIndentString(), whitespaceInformationProvider
							.getLineSeparatorInformation(uri).getLineSeparator());
				} catch (OperationCanceledException e) {
					throw new InterruptedException();
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
			// cancelled by user
			return 0;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), getElementCreationErrorMessage(), realException.getMessage());
		}
		return size[0];
	}

	protected String getTypeNameWithoutParameters() {
		return getTypeNameWithoutParameters(getTypeName());
	}

	protected String getTypeNameWithoutParameters(String typeNameWithParameters) {
		int angleBracketOffset= typeNameWithParameters.indexOf('<');
		if (angleBracketOffset == -1) {
			return typeNameWithParameters;
		} else {
			return typeNameWithParameters.substring(0, angleBracketOffset);
		}
	}

	protected void displayError(final String title, final String message) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
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
