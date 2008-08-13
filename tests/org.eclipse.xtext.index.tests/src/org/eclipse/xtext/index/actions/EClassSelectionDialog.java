/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.actions;

import java.util.Collection;
import java.util.Comparator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.xtext.index.IModelIndex;
import org.eclipse.xtext.index.internal.IndexPlugin;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EClassSelectionDialog extends FilteredItemsSelectionDialog {

	private IProject scope;

	public EClassSelectionDialog(Shell shell, IProject scope) {
		super(shell, false);
		this.scope=scope;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createExtendedContentArea
	 * (org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ItemsFilter createFilter() {
		return new ItemsFilter() {

			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}

			@Override
			public boolean matchItem(Object item) {
				return true;
			}

		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#fillContentProvider
	 * (org
	 * .eclipse.ui.dialogs.FilteredItemsSelectionDialog.AbstractContentProvider,
	 * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
			IProgressMonitor progressMonitor) throws CoreException {
		Collection<URI> instances = IModelIndex.INSTANCE.findInstances(EcorePackage.Literals.ECLASS, scope);
		for (URI uri : instances) {
			contentProvider.add(uri, itemsFilter);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getDialogSettings()
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		return new DialogSettings("EClass Selection Dialog");
	}

	@Override
	public String getElementName(Object item) {
		return item.toString();
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<?>() {
			public int compare(Object o1, Object o2) {
				return o1.toString().compareTo(o2.toString());
			}

		};
	}

	@Override
	protected IStatus validateItem(Object item) {
		return new Status(IStatus.OK, IndexPlugin.PLUGIN_ID, "");
	}

}
