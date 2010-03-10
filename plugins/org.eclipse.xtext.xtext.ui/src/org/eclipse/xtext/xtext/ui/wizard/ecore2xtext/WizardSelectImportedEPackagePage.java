/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
public class WizardSelectImportedEPackagePage extends WizardPage {

	private Set<EPackageInfo> ePackageInfos = new HashSet<EPackageInfo>();

	private EPackageInfo defaultEPackageInfo;

	private ComboViewer rootElementComboViewer;

	private TableViewer importedEPackagesViewer;

	public WizardSelectImportedEPackagePage(String pageName, IStructuredSelection selection) {
		super(pageName);
		setTitle(Messages.WizardSelectImportedEPackagePage_WindowTitle);
		setDescription(Messages.WizardSelectImportedEPackagePage_Description);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		Label label = new Label(composite, SWT.NONE);
		label.setText(Messages.WizardSelectImportedEPackagePage_ListTitle);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
		importedEPackagesViewer = new TableViewer(composite, SWT.BORDER);
		importedEPackagesViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3));
		importedEPackagesViewer.setContentProvider(new IStructuredContentProvider() {
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				return Iterables.newArray(ePackageInfos, EPackageInfo.class);
			}
		});
		importedEPackagesViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof EPackageInfo) {
					String label = ((EPackageInfo) element).getEPackageJavaFQN();
					if (element == getDefaultEPackageInfo()) {
						return label + Messages.WizardSelectImportedEPackagePage_DefaultMarker;
					} else {
						return label;
					}
				}
				return element.toString();
			}
		});
		Button addButton = new Button(composite, SWT.PUSH);
		addButton.setText(Messages.WizardSelectImportedEPackagePage_AddButtonText);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, false, 1, 1));
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addEPackageInfos(new EPackageChooser(getShell()).open());
			}
		});
		Button defaultButton = new Button(composite, SWT.PUSH);
		defaultButton.setText(Messages.WizardSelectImportedEPackagePage_SetDefault);
		defaultButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		defaultButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = importedEPackagesViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					if (structuredSelection.size() == 1) {
						Object firstElement = structuredSelection.getFirstElement();
						if (firstElement instanceof EPackageInfo) {
							defaultEPackageInfo = (EPackageInfo) firstElement;
						}
					}
				}
				updateUI();
			}
		});
		Button removeButton = new Button(composite, SWT.PUSH);
		removeButton.setText(Messages.WizardSelectImportedEPackagePage_RemoveButtonText);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = importedEPackagesViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					for (Iterator<?> i = ((IStructuredSelection) selection).iterator(); i.hasNext();) {
						Object ePackageInfo = i.next();
						ePackageInfos.remove(ePackageInfo);
						if (defaultEPackageInfo == ePackageInfo) {
							defaultEPackageInfo = null;
						}
					}
				}
				updateUI();
			}
		});
		Label entryRuleLabel = new Label(composite, SWT.NONE);
		entryRuleLabel.setText(Messages.WizardSelectImportedEPackagePage_entryRuleLabelText);
		entryRuleLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
		CCombo rootElementComboBoxCellEditor = new CCombo(composite, SWT.BORDER | SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		layoutData.heightHint = 20;
		rootElementComboBoxCellEditor.setLayoutData(layoutData);
		rootElementComboBoxCellEditor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				validatePage();
			}
		});
		rootElementComboViewer = new ComboViewer(rootElementComboBoxCellEditor);
		rootElementComboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return (element instanceof EClass) ? ((EClass) element).getName() + " - "
						+ ((EClass) element).getEPackage().getName() : super.getText(element);
			}
		});
		rootElementComboViewer.setContentProvider(new IStructuredContentProvider() {
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				Iterable<EClass> eClasses = Iterables.filter(Iterables.concat(Iterables.transform(ePackageInfos,
						new Function<EPackageInfo, List<EClassifier>>() {
							public List<EClassifier> apply(EPackageInfo from) {
								return from.getEPackage().getEClassifiers();
							}
						})), EClass.class);
				return Iterables.newArray(Lists.sortedCopy(eClasses, new Comparator<EClass>() {
					public int compare(EClass o1, EClass o2) {
						return o1.getName().compareTo(o2.getName());
					}
				}), EClass.class);
			}
		});
		updateUI();
		setControl(composite);
		Dialog.applyDialogFont(getControl());
	}

	public java.util.Collection<EPackageInfo> getEPackageInfos() {
		return ePackageInfos;
	}

	private void addEPackageInfos(List<EPackageInfo> newEPackageInfos) {
		for (Iterator<EPackageInfo> i = newEPackageInfos.iterator(); i.hasNext();) {
			EPackage newEPackage = i.next().getEPackage();
			for (EPackageInfo ePackageInfo : ePackageInfos) {
				EPackage ePackage = ePackageInfo.getEPackage();
				if (ePackage.getNsURI().equals(newEPackage.getNsURI())) {
					i.remove();
					break;
				}
			}
		}
		ePackageInfos.addAll(newEPackageInfos);
		updateUI();
	}

	private void updateUI() {
		importedEPackagesViewer.setInput(ePackageInfos);
		ISelection selection = rootElementComboViewer.getSelection();
		rootElementComboViewer.setInput(ePackageInfos);
		if (selection.isEmpty()) {
			Object firstEClass = rootElementComboViewer.getElementAt(0);
			if (firstEClass != null) {
				rootElementComboViewer.setSelection(new StructuredSelection(firstEClass));
			}
		} else {
			rootElementComboViewer.setSelection(selection);
		}
		importedEPackagesViewer.refresh();
		validatePage();
	}

	private void validatePage() {
		setPageComplete(!ePackageInfos.isEmpty() && getRootElementClass() != null);
	}

	public EClass getRootElementClass() {
		ISelection selection = rootElementComboViewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			return (EClass) ((IStructuredSelection) selection).getFirstElement();
		}
		return null;
	}

	public EPackageInfo getDefaultEPackageInfo() {
		if (defaultEPackageInfo == null && !ePackageInfos.isEmpty()) {
			defaultEPackageInfo = ePackageInfos.iterator().next();
		}
		return defaultEPackageInfo;
	}
}
