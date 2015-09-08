/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.javaconverter;

import static com.google.common.collect.Sets.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.compare.CompareUI;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.core.javaconverter.JavaConverter.ConversionResult;

import com.ibm.icu.text.MessageFormat;

/**
 * Shows problematic files contained in a passed input map
 * {@link ConversionProblemsDialog#ConversionProblemsDialog(Shell, Map)}.<br>
 * After selection is done, unselected entries will be removed from the input map.
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class ConversionProblemsDialog extends Dialog {

	private Map<ICompilationUnit, ConversionResult> input;
	private CompareViewerPane javaFilesPane;
	private Table javaFilesTable;
	private Set<ICompilationUnit> excluded = new HashSet<ICompilationUnit>();
	private CompareViewerPane problemsPane;
	private Table problemsTable;
	private Button okButton;
	private ICompilationUnit currentCU;
	protected Image errorImage;

	public ConversionProblemsDialog(Shell parentShell, Map<ICompilationUnit, ConversionResult> input) {
		super(parentShell);
		this.errorImage = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		this.input = input;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public void create() {
		super.create();
		if (javaFilesTable != null && !javaFilesTable.isDisposed()) {
			for (Entry<ICompilationUnit, ConversionResult> entry : input.entrySet()) {
				if (entry.getValue().getProblems().iterator().hasNext()) {
					ICompilationUnit cu = entry.getKey();
					IResource resource = cu.getResource();
					TableItem ti = new TableItem(javaFilesTable, SWT.NONE);
					ti.setImage(CompareUI.getImage(resource));
					ti.setText(resource.getName());
					ti.setData(cu);
					ti.setChecked(true);
				}
			}
			if (javaFilesTable.getItems().length > 0) {
				javaFilesTable.select(0);
				handleMemberSelect(javaFilesTable.getItems()[0]);
			}
		}
	}

	@Override
	protected void okPressed() {
		for (ICompilationUnit iCompilationUnit : excluded) {
			input.remove(iCompilationUnit);
		}
		super.okPressed();
	}

	@Override
	protected Point getInitialSize() {
		Point initialSize = super.getInitialSize();
		return new Point(600, initialSize.y);
	}

	@Override
	protected Control createDialogArea(Composite parent2) {
		Composite parent = (Composite) super.createDialogArea(parent2);
		getShell().setText("Problems occured during conversion"); //$NON-NLS-1$
		org.eclipse.compare.Splitter vsplitter = new org.eclipse.compare.Splitter(parent, SWT.VERTICAL);
		vsplitter.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL | GridData.GRAB_VERTICAL));

		Composite c = new Composite(vsplitter, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 2;
		layout.verticalSpacing = 2;
		layout.numColumns = 1;
		c.setLayout(layout);
		Label l1 = new Label(c, SWT.NONE);
		l1.setText("Select files which should be converted anyway:"); //$NON-NLS-1$
		javaFilesPane = new CompareViewerPane(c, SWT.BORDER | SWT.FLAT);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		javaFilesPane.setLayoutData(gd);
		javaFilesPane.setText("Files with unrecoverable problems");
		javaFilesTable = new Table(javaFilesPane, SWT.MULTI | SWT.CHECK | SWT.H_SCROLL | SWT.V_SCROLL);
		javaFilesTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.detail == SWT.CHECK) {
					if (e.item instanceof TableItem) {
						TableItem checkedItem = (TableItem) e.item;
						Set<TableItem> selectedItems = newHashSet(javaFilesTable.getSelection());
						for(TableItem ti: selectedItems) {
							ti.setChecked(checkedItem.getChecked());
						}
						selectedItems.add(checkedItem);
						for(TableItem ti: selectedItems) {
							if (!ti.getChecked())
								excluded.add((ICompilationUnit) ti.getData());
							else
								excluded.remove(ti.getData());
						}
					}
					
				} else {
					handleMemberSelect(e.item);
				}
			}
		});
		javaFilesPane.setContent(javaFilesTable);
		c = new Composite(vsplitter, SWT.NONE);
		layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 2;
		layout.verticalSpacing = 2;
		layout.numColumns = 1;
		c.setLayout(layout);
		Label l2 = new Label(c, SWT.NONE);
		l2.setText("Choose a file in the file table to show problems:"); //$NON-NLS-1$
		problemsPane = new CompareViewerPane(c, SWT.BORDER | SWT.FLAT);
		gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		problemsPane.setLayoutData(gd);

		problemsTable = new Table(problemsPane, SWT.H_SCROLL | SWT.V_SCROLL);
		problemsPane.setContent(problemsTable);
		applyDialogFont(parent);
		vsplitter.setWeights(new int[] { 50, 50 });
		return parent;
	}

	protected void handleMemberSelect(Widget item) {
		Object data = null;
		if (item != null)
			data = item.getData();
		if (data instanceof ICompilationUnit) {
			this.currentCU = (ICompilationUnit) data;
			problemsPane.setImage(CompareUI.getImage(this.currentCU.getResource()));
			String pattern = "Problems in file {0}";
			String title = MessageFormat.format(pattern, new Object[] { this.currentCU.getResource().getName() });
			problemsPane.setText(title);
			if (problemsTable != null) {
				problemsTable.setRedraw(false);
				problemsTable.removeAll();
				ConversionResult conversionResult = input.get(currentCU);
				for (String problem : conversionResult.getProblems()) {
					addProblemItem(problem);
				}
				problemsTable.setRedraw(true);
			}
		} else
			this.currentCU = null;
	}

	private void addProblemItem(String problem) {
		if (problemsTable == null || problemsTable.isDisposed())
			return;
		TableItem ti = new TableItem(problemsTable, SWT.NONE);
		ti.setImage(errorImage);
		ti.setText(problem);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.PROCEED_LABEL, true);
		okButton.setEnabled(true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
}
