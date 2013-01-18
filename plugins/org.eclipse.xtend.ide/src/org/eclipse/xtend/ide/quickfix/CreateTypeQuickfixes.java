/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix;

import static org.eclipse.xtext.ui.util.DisplayRunHelper.*;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.wizards.NewClassCreationWizard;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jdt.internal.ui.wizards.NewInterfaceCreationWizard;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.jdt.ui.wizards.NewInterfaceWizardPage;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.ide.wizards.NewXtendClassWizard;
import org.eclipse.xtend.ide.wizards.NewXtendClassWizardPage;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.ui.quickfix.ILinkingIssueQuickfixProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CreateTypeQuickfixes implements ILinkingIssueQuickfixProvider {

	private static final Logger LOG = Logger.getLogger(CreateTypeQuickfixes.class);
	
	@Inject 
	private ProjectUtil projectUtil;

	@Inject
	private Provider<NewXtendClassWizard> newXtendClassWizardProvider;

	public void addQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			IXtextDocument xtextDocument, XtextResource resource, 
			EObject referenceOwner, EReference unresolvedReference)
			throws Exception {
		if (unresolvedReference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR
				|| unresolvedReference == XbasePackage.Literals.XTYPE_LITERAL__TYPE
				|| unresolvedReference == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE) {
			URI context = resource.getURI();
			String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
			issueResolutionAcceptor.accept(issue, "Create Xtend class",
					"Opens the new Xtend class wizard to create the type '" + issueString + "'", "xtend_file.png",
					openNewXtendClassWizardFor(context, issueString));
			issueResolutionAcceptor.accept(issue, "Create Java class",
					"Opens the new Java class wizard to create the type '" + issueString + "'", "java_file.gif",
					openNewJavaClassWizardFor(context, issueString));
			issueResolutionAcceptor.accept(issue, "Create Java interface",
					"Opens the new Java interface wizard to create the type '" + issueString + "'",
					"java_interface.gif", openNewJavaInterfaceWizardFor(context, issueString));
		}
	}

	protected IModification openNewJavaInterfaceWizardFor(final URI contextUri, final String typeName) {
		return new IModification() {
			public void apply(IModificationContext context) throws Exception {
				runAsyncInDisplayThread(new Runnable() {

					public void run() {
						NewInterfaceWizardPage classWizardPage = new NewInterfaceWizardPage();
						NewInterfaceCreationWizard wizard = new NewInterfaceCreationWizard(classWizardPage, true);
						WizardDialog dialog = createWizardDialog(wizard);
						configureWizardPage(classWizardPage, contextUri, typeName);
						dialog.open();
					}
				});
			}
		};
	}

	protected IModification openNewJavaClassWizardFor(final URI contextUri, final String typeName) {
		return new IModification() {
			public void apply(IModificationContext context) throws Exception {
				runAsyncInDisplayThread(new Runnable() {

					public void run() {
						NewClassWizardPage classWizardPage = new NewClassWizardPage();
						NewClassCreationWizard wizard = new NewClassCreationWizard(classWizardPage, true);
						WizardDialog dialog = createWizardDialog(wizard);
						configureWizardPage(classWizardPage, contextUri, typeName);
						dialog.open();
					}
				});
			}
		};
	}

	protected IModification openNewXtendClassWizardFor(final URI contextUri, final String typeName) {
		return new IModification() {
			public void apply(IModificationContext context) throws Exception {
				runAsyncInDisplayThread(new Runnable() {

					public void run() {
						NewElementWizard newXtendClassWizard = newXtendClassWizardProvider.get();
						WizardDialog dialog = createWizardDialog(newXtendClassWizard);
						NewXtendClassWizardPage page = (NewXtendClassWizardPage) newXtendClassWizard.getStartingPage();
						configureWizardPage(page, contextUri, typeName);
						dialog.open();
					}
				});
			}
		};
	}

	protected WizardDialog createWizardDialog(NewElementWizard newXtendClassWizard) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		Shell shell = workbench.getActiveWorkbenchWindow().getShell();
		newXtendClassWizard.init(workbench, new StructuredSelection());
		WizardDialog dialog = new WizardDialog(shell, newXtendClassWizard);
		dialog.create();
		return dialog;
	}

	
	protected void configureWizardPage(NewTypeWizardPage page, URI contextUri, String typeName) {
		setPackageName(page, contextUri);
		page.setTypeName(typeName, true);
	}

	protected void setPackageName(NewTypeWizardPage page, URI contextUri) {
		IJavaProject javaProject = getJavaProject(contextUri);
		String path = contextUri.trimSegments(1).toPlatformString(true);
		try {
			IPackageFragment packageFragment = javaProject.findPackageFragment(new Path(path));
			IPackageFragmentRoot root = (IPackageFragmentRoot) packageFragment
					.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
			page.setPackageFragment(packageFragment, true);
			page.setPackageFragmentRoot(root, true);
		} catch (JavaModelException e) {
			LOG.error("Could not find package for " + path, e);
		}
	}

	protected IJavaProject getJavaProject(URI uri){
		IProject project = projectUtil.getProject(uri);
		if(project == null){
			return null;
		}
		return JavaCore.create(project);
	}

}
