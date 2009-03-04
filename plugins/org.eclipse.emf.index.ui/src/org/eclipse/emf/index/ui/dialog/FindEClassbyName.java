/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.dialog;

import java.util.Iterator;

import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.util.PreloadingListIterator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class FindEClassbyName extends ListDialog {

	protected Text searchControl;

	protected IIndexStore index = IIndexStore.INSTANCE;

	private Label messageLabel;

	public FindEClassbyName(Shell parent) {
		super(parent);
		setTitle("Find EClass");
		setMessage("Enter name of EClass (use * for wildcard)");
		setAddCancelButton(false);
		// set a dummy content provider, as superclass expects an
		// IStructuredContentProvider
		setContentProvider(new IStructuredContentProvider() {
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				return null;
			}
		});
		setLabelProvider(new EClassDescriptorLabelProvider());
	}

	@Override
	protected int getTableStyle() {
		return super.getTableStyle() | SWT.VIRTUAL;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		// set real content provider :-)
		getTableViewer().setContentProvider(new EClassDescriptorLazyContentProvider());
		return contents;
	}

	protected Control createDialogArea(Composite container) {
		Composite parent = (Composite) super.createDialogArea(container);
		messageLabel = new Label(parent, SWT.NONE);
		messageLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		return parent;
	}

	@Override
	protected Label createMessageArea(Composite composite) {
		Label label = super.createMessageArea(composite);
		searchControl = new Text(composite, SWT.BORDER);
		GridData layoutData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		searchControl.setLayoutData(layoutData);
		searchControl.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				handleSearchPatternChanged(e);
			}
		});
		return label;
	}

	protected void handleSearchPatternChanged(ModifyEvent e) {
		String searchPattern = searchControl.getText();
		if (searchPattern.length() > 0 && searchPattern.charAt(searchPattern.length() - 1) != '*') {
			searchPattern += '*';
		}
		Iterable<EClassDescriptor> matches = index.eClassDAO().createQuery().name(searchPattern).executeListResult();
		getTableViewer().setInput(matches);
	}

	class EClassDescriptorLazyContentProvider implements ILazyContentProvider {

		private PreloadingListIterator<EClassDescriptor> iterator;

		private TableViewer viewer;

		private static final int PREFETCH_ITEM_COUNT = 20;

		private int currentItemCount = 0;

		public void updateElement(int index) {
			if (iterator != null) {
				while (iterator.nextIndex() > index) {
					iterator.previous();
				}
				while (iterator.nextIndex() < index) {
					iterator.next();
				}
				EClassDescriptor element = iterator.next();
				viewer.replace(element, index);
				if (index == currentItemCount - 1) {
					currentItemCount += iterator.preloadNext(PREFETCH_ITEM_COUNT);
					updateItemCount();
				}
			}
		}

		public void dispose() {
			iterator = null;
			viewer = null;
		}

		private void updateItemCount() {
			if (currentItemCount >= PREFETCH_ITEM_COUNT)
				if(currentItemCount % PREFETCH_ITEM_COUNT == 0)
					messageLabel.setText("More than " + currentItemCount + " hits. Scroll down to see more.");
				else 
					messageLabel.setText("" + currentItemCount + " hits.");
			else
				messageLabel.setText("");
			this.viewer.setItemCount(currentItemCount);

		}

		@SuppressWarnings("unchecked")
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			this.viewer = (TableViewer) viewer;
			iterator = null;
			if (newInput instanceof Iterable<?>)
				iterator = new PreloadingListIterator(((Iterable<EClassDescriptor>) newInput).iterator());
			else if (newInput instanceof Iterator<?>)
				iterator = new PreloadingListIterator((Iterator<EClassDescriptor>) newInput);
			if (this.iterator != null)
				currentItemCount = iterator.preloadNext(PREFETCH_ITEM_COUNT);
			else
				currentItemCount = 0;
			updateItemCount();
		}
	}

	class EClassDescriptorLabelProvider implements ILabelProvider {

		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			return ((EClassDescriptor) element).getDisplayName();
		}

		public void addListener(ILabelProviderListener listener) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}

	}

}
