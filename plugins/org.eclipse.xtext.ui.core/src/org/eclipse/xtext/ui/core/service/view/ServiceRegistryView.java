/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.service.view;

import java.util.Collection;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.internal.Activator;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ServiceRegistryView extends ViewPart implements ISelectionListener {
	private TreeViewer treeViewer;
	private FilteredTree filteredTree;
	private ServiceRegistryViewSettings settings;

	public ServiceRegistryView() {
		super();
		settings = new ServiceRegistryViewSettings(Activator.getDefault().getDialogSettings());
	}

	@Override
	public void createPartControl(Composite parent) {
		filteredTree = new FilteredTree(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE,
				new PatternFilter());
		filteredTree.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));

		this.treeViewer = filteredTree.getViewer();
		this.treeViewer.setLabelProvider(new ServiceLabelProvider(settings));
		final ServiceConfigurationContentProvider provider = new ServiceConfigurationContentProvider();
		this.treeViewer.setContentProvider(provider);
		this.treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				if (event.getSelection() instanceof TreeSelection) {
					Object firstElement = ((org.eclipse.jface.viewers.TreeSelection) event.getViewer().getSelection())
							.getFirstElement();
					if (provider.hasChildren(firstElement))
						updateInput(firstElement);
				}
			}
		});
		showScopes();
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this);
	}

	private void updateInput(Object input) {
		treeViewer.setInput(input);
		if (input != null && !(input instanceof Collection<?>))
			if (treeViewer.getLabelProvider() instanceof LabelProvider)
				setContentDescription(((LabelProvider) treeViewer.getLabelProvider()).getText(input));
			else
				setContentDescription(input.toString());
		else
			setContentDescription("");

	}

	@Override
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this);
		filteredTree.dispose();
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (settings.isLinkWithEditor() && part instanceof XtextEditor) {
			IServiceScope scope = ((XtextEditor) part).getScope();
			treeViewer.setSelection(new StructuredSelection(scope));
			// treeViewer.expandToLevel(scope, 1);
		}
		treeViewer.refresh(true);
	}

	// Commands delegates
	public void showScopes() {
		updateInput(ServiceRegistry.getRegisteredScopes());
	}

	// Toggles
	public boolean isShowFQNames() {
		return settings.isShowFQNames();
	}

	public void toggleShowFQName() {
		settings.setShowFQNames(!settings.isShowFQNames());
		treeViewer.refresh(true);
	}

	public boolean isLinkWithEditor() {
		return settings.isLinkWithEditor();
	}

	public void toggleLinkWithEditor() {
		settings.setLinkWithEditor(!settings.isLinkWithEditor());
		treeViewer.refresh(false);

	}

}
