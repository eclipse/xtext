/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import static com.google.common.collect.Lists.*;
import static java.lang.Math.*;

import java.util.List;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.xtext.ui.views.IWorkbenchPartSelection;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DerivedSourceDropDownAction extends Action implements IMenuCreator {
	private static final int RESULTS_IN_DROP_DOWN = 10;

	private final class SelectDerivedSourceAction extends Action {
		private IStorage derivedSource;

		public SelectDerivedSourceAction(IStorage derivedSource) {
			this.derivedSource = derivedSource;
			setText(derivedSource.getName());
		}

		@Override
		public void run() {
			DerivedSourceView derivedSourceView = DerivedSourceDropDownAction.this.derivedSourceView;
			IWorkbenchPartSelection workbenchPartSelection = derivedSourceView.getWorkbenchPartSelection();
			derivedSourceView.computeAndSetInput(new DerivedSourceSelection(workbenchPartSelection, derivedSource));
		}
	}

	private DerivedSourceView derivedSourceView;
	private Menu menu;

	public DerivedSourceDropDownAction(DerivedSourceView derivedSourceView) {
		super();
		this.derivedSourceView = derivedSourceView;
		setToolTipText("Show all derived sources");
		setImageDescriptor(derivedSourceView.getXtendImages().forFilter());
		setMenuCreator(this);
	}

	@Override
	public Menu getMenu(Control parent) {
		if (menu != null) {
			menu.dispose();
		}
		menu = new Menu(parent);
		if (derivedSourceView.getSelectedSource() == null) {
			return menu;
		}
		List<IStorage> derivedSources = newArrayList(derivedSourceView.getDerivedSources());
		int min = min(derivedSources.size(), RESULTS_IN_DROP_DOWN);
		SelectDerivedSourceAction action = new SelectDerivedSourceAction(derivedSourceView.getSelectedSource());
		action.setChecked(true);
		addActionToMenu(menu, action);
		new MenuItem(menu, SWT.SEPARATOR);
		for (int i = 0; i < min; i++) {
			IStorage resource = derivedSources.get(i);
			if (!resource.equals(derivedSourceView.getSelectedSource())) {
				action = new SelectDerivedSourceAction(resource);
				addActionToMenu(menu, action);
			}
		}
		return menu;
	}

	@Override
	public Menu getMenu(Menu parent) {
		return null;
	}

	@Override
	public void dispose() {
		if (menu != null) {
			menu.dispose();
			menu = null;
		}
	}

	private void addActionToMenu(Menu parent, Action action) {
		ActionContributionItem item = new ActionContributionItem(action);
		item.fill(parent, -1);
	}

}
