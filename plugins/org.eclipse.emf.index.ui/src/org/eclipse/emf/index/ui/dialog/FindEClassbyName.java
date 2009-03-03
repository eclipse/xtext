/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.dialog;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
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

	public FindEClassbyName(Shell parent) {
		super(parent);
		setTitle("Find EClass");
		setMessage("Enter name of EClass (use * for wildcard)");
		setAddCancelButton(false);
		setContentProvider(new EClassDescriptorContentProvider());
		setLabelProvider(new EClassDescriptorLabelProvider());
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
		if(searchPattern.length() >0 && searchPattern.charAt(searchPattern.length()-1) !='*') {
			searchPattern += '*';
		}
		Collection<EClassDescriptor> matches = index.eClassDAO().createQuery().name(searchPattern).executeListResult();
		getTableViewer().setInput(matches);
	}
	
	class EClassDescriptorContentProvider implements IStructuredContentProvider {
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection<?>) {
				Collection<EClassDescriptor> collection = (Collection<EClassDescriptor>) inputElement;
				EClassDescriptor[] array = collection.toArray(new EClassDescriptor[collection.size()]);
				Arrays.sort(array, new Comparator<EClassDescriptor>() {
					public int compare(EClassDescriptor desc0, EClassDescriptor desc1) {
						return desc0.getDisplayName().compareTo(desc1.getDisplayName());
					}
				});
				return array;
			}
			else if (inputElement instanceof EClassDescriptor) {
				return new EClassDescriptor[] { (EClassDescriptor) inputElement };
			}
			return null;
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

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
			// TODO Auto-generated method stub
		}

		public void dispose() {
			// TODO Auto-generated method stub
		}

		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	}

}
