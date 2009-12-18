/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

/**
 * @author koehnlein - Initial contribution and API
 */
public class WizardSelectImportedEPackagePage extends WizardPage {

	private EditingDomain editingDomain;

	private java.util.Set<EPackage> ePackages = new HashSet<EPackage>();

	private IStructuredSelection selection;

	private boolean isAutoImportReferencedEPackages;

	public WizardSelectImportedEPackagePage(String pageName, IStructuredSelection selection) {
		super(pageName);
		this.selection = selection;
		setTitle(Messages.WizardSelectImportedEPackagePage_WindowTitle);
		setDescription(Messages.WizardSelectImportedEPackagePage_Description);
	}

	private EditingDomain getEditingDomain() {
		if (editingDomain == null) {
			java.util.List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());
			AdapterFactory adapterFactory = new ComposedAdapterFactory(factories);
			editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack());
		}
		return editingDomain;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, true));
		Label label = new Label(composite, SWT.NONE);
		label.setText(Messages.WizardSelectImportedEPackagePage_ListTitle);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
		final List list = new List(composite, SWT.MULTI);
		initializeListFromSelection(list, selection);
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
		Button addButton = new Button(composite, SWT.PUSH);
		addButton.setText(Messages.WizardSelectImportedEPackagePage_AddButtonText);
		addButton.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog loadResourceDialog = new EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog(
						getShell(), editingDomain);
				loadResourceDialog.setBlockOnOpen(true);
				int result = loadResourceDialog.open();
				if (result == Window.OK) {
					for (URI uri : loadResourceDialog.getURIs()) {
						addEPackages(list, uri);
					}
				}
			}
		});
		Button removeButton = new Button(composite, SWT.PUSH);
		removeButton.setText(Messages.WizardSelectImportedEPackagePage_RemoveButtonText);
		removeButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (String listSelection : list.getSelection()) {
					for (Iterator<EPackage> i = ePackages.iterator(); i.hasNext();) {
						EPackage ePackage = i.next();
						if (ePackage.getNsURI().equals(listSelection)) {
							i.remove();
							list.remove(listSelection);
						}
					}
				}
			}
		});
		final Button addReferencedEPackagesButton = new Button(composite, SWT.CHECK);
		addReferencedEPackagesButton.setText(Messages.WizardSelectImportedEPackagePage_CheckButtonText);
		addReferencedEPackagesButton.setSelection(isAutoImportReferencedEPackages);
		addReferencedEPackagesButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
		addReferencedEPackagesButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				isAutoImportReferencedEPackages = addReferencedEPackagesButton.getSelection();
				if (isAutoImportReferencedEPackages) {
					for (EPackage ePackage : ePackages) {
						addEPackage(list, ePackage);
					}
				}
			}
		});
		setControl(composite);
		Dialog.applyDialogFont(getControl());
	}

	public java.util.Collection<EPackage> getEPackages() {
		return ePackages;
	}

	protected boolean validatePage() {
		return !ePackages.isEmpty();
	}

	private void addEPackages(final List list, URI uri) {
		if ("http".equals(uri.scheme())) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri.toString());
			if (ePackage != null) {
				addEPackage(list, ePackage);
			}
		} else {
			Resource resource = getEditingDomain().getResourceSet().getResource(uri, true);
			for (EPackage ePackage : ePackagesInResource(resource)) {
				addEPackage(list, ePackage);
			}
		}
	}

	private void addEPackage(final List list, EPackage ePackage) {
		addEPackageToList(list, ePackage);
		if (isAutoImportReferencedEPackages) {
			for (EClassifier classifier : ePackage.getEClassifiers()) {
				if (classifier instanceof EClass) {
					for (EStructuralFeature feature : ((EClass) classifier).getEAllStructuralFeatures()) {
						EPackage featurePackage = feature.getEType().getEPackage();
						addEPackageToList(list, featurePackage);
					}
					for (EClass superType : ((EClass) classifier).getESuperTypes()) {
						EPackage superTypePackage = superType.getEPackage();
						addEPackageToList(list, superTypePackage);
					}
				}
			}
		}
	}

	private void addEPackageToList(final List list, EPackage ePackage) {
		if (ePackage != null) {
			boolean isAdded = ePackages.add(ePackage);
			if (isAdded) {
				list.add(ePackage.getNsURI().toString());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void initializeListFromSelection(List list, IStructuredSelection selection) {
		for (Iterator i = selection.iterator(); i.hasNext();) {
			Object selectedObject = i.next();
			if (selectedObject instanceof IFile) {
				IFile ecoreFile = (IFile) selectedObject;
				try {
					addEPackages(list, URI.createPlatformResourceURI(ecoreFile.getFullPath().toString(), true));
				} catch (Exception exc) {
					// TODO log
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private java.util.List<EPackage> ePackagesInResource(Resource resource) {
		java.util.List<EPackage> result = null;
		for (Iterator i = resource.getAllContents(); i.hasNext();) {
			Object object = i.next();
			if (object instanceof EPackage) {
				if (result == null) {
					result = new ArrayList<EPackage>();
				}
				result.add((EPackage) object);
			}
		}
		return (result == null) ? Collections.<EPackage> emptyList() : result;
	}

}
