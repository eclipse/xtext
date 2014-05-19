/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.quickfix;

import static org.eclipse.xtext.ui.util.DisplayRunHelper.*;
import static org.eclipse.xtext.util.Strings.*;

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
import org.eclipse.jdt.internal.ui.wizards.NewAnnotationCreationWizard;
import org.eclipse.jdt.internal.ui.wizards.NewClassCreationWizard;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jdt.internal.ui.wizards.NewInterfaceCreationWizard;
import org.eclipse.jdt.ui.wizards.NewAnnotationWizardPage;
import org.eclipse.jdt.ui.wizards.NewClassWizardPage;
import org.eclipse.jdt.ui.wizards.NewInterfaceWizardPage;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import com.google.inject.Inject;

/**
 * Quickfixes to create new Java types.
 *
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CreateJavaTypeQuickfixes implements ILinkingIssueQuickfixProvider {

	private static final Logger LOG = Logger.getLogger(CreateJavaTypeQuickfixes.class);
	
	@Inject 
	private ProjectUtil projectUtil;
	
	@Inject
	private TypeNameGuesser typeNameGuesser;
	
	public void addQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor,
			IXtextDocument xtextDocument, XtextResource resource, 
			EObject referenceOwner, EReference unresolvedReference)
			throws Exception {
		String typeString = (issue.getData() != null && issue.getData().length > 0) 
				? issue.getData()[0] 
				: xtextDocument.get(issue.getOffset(), issue.getLength());
		Pair<String, String> packageAndType = typeNameGuesser.guessPackageAndTypeName(referenceOwner, typeString);
		String packageName = packageAndType.getFirst();
		if(isEmpty(packageAndType.getSecond()))
			return;
		String typeName = packageAndType.getSecond();
		if (unresolvedReference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR) {
			if(((XConstructorCall)referenceOwner).getConstructor().eIsProxy())
				newJavaClassQuickfix(typeName, packageName, resource, issue, issueResolutionAcceptor);
		} else if(unresolvedReference == XbasePackage.Literals.XTYPE_LITERAL__TYPE
				|| unresolvedReference == TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE) {
			newJavaClassQuickfix(typeName, packageName, resource, issue, issueResolutionAcceptor);
			newJavaInterfaceQuickfix(typeName, packageName, resource, issue, issueResolutionAcceptor);
		} else if(unresolvedReference == XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE) {
			newJavaAnnotationQuickfix(typeName, packageName, resource, issue, issueResolutionAcceptor);
		}
	}

	protected void newJavaInterfaceQuickfix(final String typeName, final String explicitPackage, final XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		String packageDescription = getPackageDescription(explicitPackage);
		issueResolutionAcceptor.accept(issue, "Create Java interface '" + typeName + "'" + packageDescription,
				"Opens the new Java interface wizard to create the type '" + typeName + "'" + packageDescription,
				"java_interface.gif", new IModification() {
					public void apply(/* @Nullable */ IModificationContext context) throws Exception {
						runAsyncInDisplayThread(new Runnable() {
							public void run() {
								NewInterfaceWizardPage classWizardPage = new NewInterfaceWizardPage();
								NewInterfaceCreationWizard wizard = new NewInterfaceCreationWizard(classWizardPage, true);
								WizardDialog dialog = createWizardDialog(wizard);
								configureWizardPage(classWizardPage, resource.getURI(), typeName, explicitPackage);
								dialog.open();
							}
						});
					}
				});
	}

	protected void newJavaClassQuickfix(final String typeName, final String explicitPackage, final XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		String packageDescription = getPackageDescription(explicitPackage);
		issueResolutionAcceptor.accept(issue, "Create Java class '" + typeName + "'" + packageDescription,
				"Opens the new Java class wizard to create the type '" + typeName + "'" + packageDescription, "java_file.gif",
				new ISemanticModification() {
					public void apply(EObject element, IModificationContext context) throws Exception {
						runAsyncInDisplayThread(new Runnable() {
							public void run() {
								NewClassWizardPage classWizardPage = new NewClassWizardPage();
								NewClassCreationWizard wizard = new NewClassCreationWizard(classWizardPage, true);
								WizardDialog dialog = createWizardDialog(wizard);
								configureWizardPage(classWizardPage, resource.getURI(), typeName, explicitPackage);
								dialog.open();
							}
						});
					}
				});
	}

	protected String getPackageDescription(final String explicitPackage) {
		return (!isEmpty(explicitPackage))
				? " in package '" + explicitPackage + "'"
				: "";
	}

	protected void newJavaAnnotationQuickfix(final String typeName, final String explicitPackage, final XtextResource resource, Issue issue,
			IssueResolutionAcceptor issueResolutionAcceptor) {
		String packageDescription = getPackageDescription(explicitPackage);
		issueResolutionAcceptor.accept(issue, "Create Java annotation '@" + typeName + "'" + packageDescription,
				"Opens the new Java annotation wizard to create the type '@" + typeName + "'" + packageDescription, "java_file.gif",
				new IModification() {
					public void apply(/* @Nullable */ IModificationContext context) throws Exception {
						runAsyncInDisplayThread(new Runnable() {
							public void run() {
								NewAnnotationWizardPage annotationWizardPage = new NewAnnotationWizardPage();
								NewAnnotationCreationWizard wizard = new NewAnnotationCreationWizard(annotationWizardPage, true);
								WizardDialog dialog = createWizardDialog(wizard);
								configureWizardPage(annotationWizardPage, resource.getURI(), typeName, explicitPackage);
								dialog.open();
							}
						});
					}
				});
	}

	protected WizardDialog createWizardDialog(NewElementWizard newXtendClassWizard) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		Shell shell = workbench.getActiveWorkbenchWindow().getShell();
		newXtendClassWizard.init(workbench, new StructuredSelection());
		WizardDialog dialog = new WizardDialog(shell, newXtendClassWizard);
		dialog.create();
		return dialog;
	}

	
	protected void configureWizardPage(NewTypeWizardPage page, URI contextUri, String typeName, String packageName) {
		setPackageName(page, contextUri, packageName);
		page.setTypeName(typeName, true);
	}

	protected void setPackageName(NewTypeWizardPage page, URI contextUri, String packageName) {
		IJavaProject javaProject = getJavaProject(contextUri);
		String path = contextUri.trimSegments(1).toPlatformString(true);
		try {
			if(javaProject != null) {
				IPackageFragment contextPackageFragment = javaProject.findPackageFragment(new Path(path));
				IPackageFragmentRoot root = (IPackageFragmentRoot) contextPackageFragment
						.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
				IPackageFragment packageFragment;
				if(!isEmpty(packageName)) {
					packageFragment = root.getPackageFragment(packageName);
				} else {
					packageFragment = contextPackageFragment;
				}
				page.setPackageFragment(packageFragment, true);
				page.setPackageFragmentRoot(root, true);
			}
		} catch (JavaModelException e) {
			LOG.error("Could not find package for " + path, e);
		}
	}

	/* @Nullable */
	protected IJavaProject getJavaProject(URI uri){
		IProject project = projectUtil.getProject(uri);
		if(project == null){
			return null;
		}
		return JavaCore.create(project);
	}
}
