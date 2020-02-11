/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.search;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.internal.text.TableOwnerDrawSupport;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Knut Wannheden
 */
public class XtextEObjectSearchDialog extends ListDialog {

	protected Text searchControl;

	private String initialPatternText;

	private String initialTypeText;
	
	private Label messageLabel;

	private Label searchStatusLabel;

	private IteratorJob sizeCalculationJob;

	private Label matchingElementsLabel;

	/** @since 2.0 */
	protected Text typeSearchControl;

	private IXtextEObjectSearch searchEngine;

	private final ILabelProvider labelProvider;

	private boolean enableStyledLabels;

	private boolean editableTypePattern = true;

	public XtextEObjectSearchDialog(Shell parent, IXtextEObjectSearch searchEngine, ILabelProvider labelProvider) {
		super(parent);
		this.searchEngine = searchEngine;
		this.labelProvider = labelProvider;
		setTitle(Messages.XtextEObjectSearchDialog_TableLabelDialogTitle);
		setMessage(Messages.XtextEObjectSearchDialog_TableLabelSearchControlLabel);
		setAddCancelButton(true);
		// super class needs an IStructuredContentProvider so we register this dummy and 
		// register the lazy one later
		setContentProvider(new IStructuredContentProvider() {
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return null;
			}
		});
		setLabelProvider(labelProvider);
	}
	
	public XtextEObjectSearchDialog(Shell parent, IXtextEObjectSearch searchEngine, ILabelProvider labelProvider, boolean enableStyledLabels) {
		this(parent, searchEngine, labelProvider);
		this.enableStyledLabels = enableStyledLabels;
	}

	/**
	 * @since 2.0
	 */
	protected IXtextEObjectSearch getSearchEngine() {
		return searchEngine;
	}

	/**
	 * @since 2.0
	 */
	public void setInitialPattern(String text) {
		this.initialPatternText = text;
	}

	/**
	 * @since 2.0
	 */
	protected String getInitialPattern() {
		return initialPatternText;
	}

	/**
	 * @since 2.6
	 */
	public void setInitialTypePattern(String text) {
		setInitialTypePattern(text, true);
	}

	/**
	 * @since 2.6
	 */
	public void setInitialTypePattern(String text, boolean editable) {
		this.initialTypeText = text;
		this.editableTypePattern = editable;
	}
	
	@Override
	public int open() {
		if (getInitialPattern() == null) {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (window != null) {
				ISelection selection = window.getSelectionService().getSelection();
				if (selection instanceof ITextSelection) {
					String text = ((ITextSelection) selection).getText();
					if (text != null) {
						text = text.trim();
						if (text.length() > 0) {
							setInitialPattern(text);
						}
					}
				}
			}
		}
		return super.open();
	}

	@Override
	protected int getTableStyle() {
		return super.getTableStyle() | SWT.VIRTUAL;
	}

	@Override
	protected Control createDialogArea(Composite container) {
		Composite parent = (Composite) super.createDialogArea(container);
		if (enableStyledLabels && labelProvider instanceof IStyledLabelProvider) {
			final Table table = getTableViewer().getTable();
			final IStyledLabelProvider styledLabelProvider = (IStyledLabelProvider) labelProvider;
			TableOwnerDrawSupport.install(table);
			Listener listener= new Listener() {
				@Override
				public void handleEvent(Event event) {
					handleSetData(event);
				}
				protected void handleSetData(Event event) {
					TableItem item= (TableItem) event.item;
					IEObjectDescription description = (IEObjectDescription) item.getData();
					if (description != null) {
						StyledString styledString = styledLabelProvider.getStyledText(description);
						String displayString = styledString.toString();
						StyleRange[] styleRanges = styledString.getStyleRanges();
						item.setText(displayString);
						TableOwnerDrawSupport.storeStyleRanges(item, 0, styleRanges);
					}
				}
			};
			table.addListener(SWT.SetData, listener);
		}
		messageLabel = new Label(parent, SWT.NONE);
		setDefaultGridData(messageLabel);
		EObjectDescriptionContentProvider contentProvider = new EObjectDescriptionContentProvider();
		getTableViewer().setContentProvider(contentProvider);
		getTableViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
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

		applyFilter();
		
		return parent;
	}
	
	

	@Override
	protected Label createMessageArea(Composite composite) {
		Label label = super.createMessageArea(composite);
		searchControl = new Text(composite, SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
		setDefaultGridData(searchControl);
		Label typePatternLabel = new Label(composite, SWT.NONE);
		typePatternLabel.setText(Messages.XtextEObjectSearchDialog_TypeSearchLabel);
		setDefaultGridData(typePatternLabel);
		typeSearchControl = new Text(composite, SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
		setDefaultGridData(typeSearchControl);

		Composite labelComposite = new Composite(composite, SWT.NONE);
		setDefaultGridData(labelComposite);
		GridLayout labelCompositeLayout = new GridLayout(2, false);
		labelCompositeLayout.marginWidth = 0;
		labelComposite.setLayout(labelCompositeLayout);
		matchingElementsLabel = new Label(labelComposite, SWT.NONE);
		matchingElementsLabel.setText(Messages.XtextEObjectSearchDialog_MatchingElementsLabel);
		matchingElementsLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		searchStatusLabel = new Label(labelComposite, SWT.RIGHT);
		searchStatusLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		ModifyListener textModifyListener = new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				applyFilter();
			}
		};
		searchControl.addModifyListener(textModifyListener);
		typeSearchControl.addModifyListener(textModifyListener);

		searchControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					typeSearchControl.setFocus();
				}
			}
		});

		if (initialPatternText != null) {
			searchControl.setText(initialPatternText);
			searchControl.selectAll();
		}

		typeSearchControl.addKeyListener(new KeyAdapter() {
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

		if (initialTypeText != null)
			typeSearchControl.setText(initialTypeText);
		
		typeSearchControl.setEditable(editableTypePattern);
		
		return label;
	}

	private void setDefaultGridData(Control control) {
		control.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
	}

	/**
	 * Called when the dialog is initially opened and whenever the input text changes. Applies the search filter as 
	 * specified by {@link #searchControl} and {@link #typeSearchControl} using {@link #getSearchEngine()} and updates
	 * the result using {@link #startSizeCalculation(Iterable)}.
	 * 
	 * @since 2.0
	 */
	protected void applyFilter() {
		String searchPattern = searchControl.getText();
		String typeSearchPattern = typeSearchControl.getText();
		if (searchPattern != null || typeSearchPattern != null) {
			Iterable<IEObjectDescription> matches = getSearchEngine().findMatches(searchPattern, typeSearchPattern);
			startSizeCalculation(matches);
		}
	}

	public void updateMatches(final Collection<IEObjectDescription> matches, final boolean isFinished) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				if (getShell() != null) {
					if (getTableViewer() != null) {
						getTableViewer().setItemCount(matches.size());
						getTableViewer().setInput(matches);
						if (getTableViewer().getSelection().isEmpty() && matches.size() > 0) 
							getTableViewer().getTable().select(0);
					}
					searchStatusLabel
							.setText((isFinished) ? "" : Messages.XtextEObjectSearchDialog_StatusMessageSearching); //$NON-NLS-1$
					matchingElementsLabel.setText(Messages.XtextEObjectSearchDialog_MatchingElementsLabel
							+ " (" + matches.size() + Messages.XtextEObjectSearchDialog_Matches); //$NON-NLS-1$
				}
			}
		});
	}

	/**
	 * Called by {@link #applyFilter()} and is responsible for calling {@link #updateMatches(Collection, boolean)} with
	 * an appropriately sorted list of matches.
	 * 
	 * @since 2.0
	 */
	protected void startSizeCalculation(Iterable<IEObjectDescription> matches) {
		if (getTableViewer() != null) {
			if (sizeCalculationJob != null) {
				sizeCalculationJob.cancel();
				try {
					sizeCalculationJob.join();
				} catch (InterruptedException e) {
					sizeCalculationJob = new IteratorJob(this);
				}
			} else {
				sizeCalculationJob = new IteratorJob(this);
			}
			sizeCalculationJob.init(matches);
			sizeCalculationJob.schedule();
		}
	}

}
