/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.dialog;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XtextEObjectSearchDialog extends ListDialog {

	protected Text searchControl;

	private Label messageLabel;

	private Label searchStatusLabel;

	private IResourceDescriptions resourceDescriptions;
	
	private SizeCalculationJob sizeCalculationJob;

	private Label matchingElementsLabel;

	public XtextEObjectSearchDialog(Shell parent, IResourceDescriptions resourceDescriptions) {
		super(parent);
		this.resourceDescriptions = resourceDescriptions;
		setTitle(Messages.XtextEObjectSearchDialog_TableLabelDialogTitle);
		setMessage(Messages.XtextEObjectSearchDialog_TableLabelSearchControlLabel);
		setAddCancelButton(true);
		// super class needs an IStructuredContentProvider so we register this dummy and 
		// register the lazy one later
		setContentProvider(new IStructuredContentProvider() {
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
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
		EObjectDescriptionContentProvider contentProvider = new EObjectDescriptionContentProvider();
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
				Iterable<IEObjectDescription> matches = calculateMatches(searchPattern);
				startSizeCalculation(matches);
				getTableViewer().setInput(matches);
			}
		});
		searchControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					TableViewer tableViewer = getTableViewer();
					tableViewer.getTable().setFocus();
					if (tableViewer.getSelection().isEmpty()) {
						Object firstElement = tableViewer.getElementAt(0);
						if (firstElement != null) {
							tableViewer.setSelection(new StructuredSelection(firstElement));
						}
					}
				}
			}
		});
		Composite labelComposite = new Composite(composite, SWT.NONE);
		labelComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		GridLayout labelCompositeLayout = new GridLayout(2, true);
		labelCompositeLayout.marginWidth = 0;
		labelComposite.setLayout(labelCompositeLayout);
		matchingElementsLabel = new Label(labelComposite, SWT.NONE);
		matchingElementsLabel.setText(Messages.XtextEObjectSearchDialog_MatchingElementsLabel);
		matchingElementsLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		searchStatusLabel = new Label(labelComposite, SWT.RIGHT);
		searchStatusLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		return label;
	}

	protected Iterable<IEObjectDescription> calculateMatches(final String searchPattern) {
		return Iterables.filter(getSearchScope(), getSearchPredicate(searchPattern));
	}

	protected Predicate<IEObjectDescription> getSearchPredicate(final String stringPattern) {
		final SearchPattern searchPattern = new SearchPattern();
		searchPattern.setPattern(stringPattern);
		final Collection<IXtextSearchFilter> registeredFilters = IXtextSearchFilter.Registry.allRegisteredFilters();
		return new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if(searchPattern.matches(input.getQualifiedName())) {
					for (IXtextSearchFilter xtextSearchFilter: registeredFilters) {
						if(xtextSearchFilter.reject(input)) {
							return false;
						}
					}
					return true;
				}
				return false;
			}
		};
	}

	protected Iterable<IEObjectDescription> getSearchScope() {
		return Iterables.concat(Iterables.transform(getResourceDescriptions().getAllResourceDescriptions(),
				new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
					public Iterable<IEObjectDescription> apply(IResourceDescription from) {
						return from.getExportedObjects();
					}
				}));
	}

	private IResourceDescriptions getResourceDescriptions() {
		return resourceDescriptions;
	}
	
	public void updateItemCount(final int itemCount, final boolean isFinished) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if(getShell() != null) {
					if (getTableViewer() != null) {
						getTableViewer().setItemCount(itemCount);
					}
					searchStatusLabel.setText((isFinished) ? "" : Messages.XtextEObjectSearchDialog_StatusMessageSearching); //$NON-NLS-1$
					matchingElementsLabel.setText(Messages.XtextEObjectSearchDialog_MatchingElementsLabel + " (" + itemCount + " matches)"); //$NON-NLS-1$
				}
			}
		});
	}

	private void startSizeCalculation(Iterable<IEObjectDescription> matches) {
		if (getTableViewer() != null) {
			if (sizeCalculationJob != null) {
				sizeCalculationJob.cancel();
				try {
					sizeCalculationJob.join();
				} catch (InterruptedException e) {
					sizeCalculationJob = new SizeCalculationJob(this);
				}
			} else {
				sizeCalculationJob = new SizeCalculationJob(this);
			}
			sizeCalculationJob.init(matches);
			sizeCalculationJob.schedule();
		}
	}

}
