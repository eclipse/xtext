/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.dialog;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractEObjectSearchDialog extends ListDialog {

	protected Text searchControl;

	private Label messageLabel;

	private Label searchStatusLabel;

	public AbstractEObjectSearchDialog(Shell parent) {
		super(parent);
		setTitle(Messages.AbstractEObjectSearchDialog_TableLabelDialogTitle);
		setMessage(Messages.AbstractEObjectSearchDialog_TableLabelSearchControlLabel);
		setAddCancelButton(true);
		// super class needs an IStructuredContentProvider so we register this dummy and register the lazy one later
		setContentProvider(new IStructuredContentProvider() {
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub
			}

			public void dispose() {
				// TODO Auto-generated method stub
			}

			public Object[] getElements(Object inputElement) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		setLabelProvider(new EObjectDescriptionLabelProvider());
	}

	@Override
	protected int getTableStyle() {
		return super.getTableStyle() | SWT.VIRTUAL;
	}

	@Override
	protected Control createDialogArea(Composite container) {
		Composite parent = (Composite) super.createDialogArea(container);
		messageLabel = new Label(parent, SWT.NONE);
		messageLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		EObjectDescriptionContentProvider contentProvider = new EObjectDescriptionContentProvider(searchStatusLabel);
		getTableViewer().setContentProvider(contentProvider);
		getTableViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					if (!structuredSelection.isEmpty()) {
						Object firstElement = structuredSelection.getFirstElement();
						if (firstElement instanceof IEObjectDescription) {
							IEObjectDescription eObjectDescription = (IEObjectDescription) firstElement;
							URI resourceURI = eObjectDescription.getEObjectURI().trimFragment();
							if (resourceURI.isPlatform()) {
								messageLabel.setText(resourceURI.toPlatformString(true));
							} else if (resourceURI.isFile()) {
								messageLabel.setText(resourceURI.toFileString());
							} else {
								messageLabel.setText(resourceURI.toString());
							}
							return;
						}
					}
				}
				messageLabel.setText(""); //$NON-NLS-1$
			}
		});
		return parent;
	}

	@Override
	protected Label createMessageArea(Composite composite) {
		Label label = super.createMessageArea(composite);
		searchControl = new Text(composite, SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
		searchControl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		searchControl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String searchPattern = searchControl.getText();
				Iterable<IEObjectDescription> matches = getMatches(searchPattern);
				getTableViewer().setInput(matches);
			}
		});
		Composite labelComposite = new Composite(composite, SWT.NONE);
		labelComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		GridLayout labelCompositeLayout = new GridLayout(2, true);
		labelCompositeLayout.marginWidth = 0;
		labelComposite.setLayout(labelCompositeLayout);
		Label tableLabel = new Label(labelComposite, SWT.NONE);
		tableLabel.setText(Messages.AbstractEObjectSearchDialog_TableLabel3);
		tableLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		searchStatusLabel = new Label(labelComposite, SWT.RIGHT);
		searchStatusLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		return label;
	}

	protected Iterable<IEObjectDescription> getMatches(final String searchPattern) {
		return Iterables.filter(getSearchScope(), getSearchPredicate(searchPattern));
	}

	protected Predicate<IEObjectDescription> getSearchPredicate(final String stringPattern) {
		final SearchPattern searchPattern = new SearchPattern();
		searchPattern.setPattern(stringPattern);
		return new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return searchPattern.matches(input.getName()) 
						|| searchPattern.matches(input.getQualifiedName());
			}
		};
	}

	protected abstract Iterable<IEObjectDescription> getSearchScope();

}
