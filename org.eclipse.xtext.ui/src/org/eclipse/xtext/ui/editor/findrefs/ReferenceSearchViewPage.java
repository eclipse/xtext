/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.OpenAndLinkWithEditorHelper;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceSearchViewPageActions.RemoveSelectedMatchesAction;
import org.eclipse.xtext.ui.editor.navigation.NavigationService;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.inject.Inject;

public class ReferenceSearchViewPage extends Page implements ISearchResultPage {

	private String id;

	private ISearchResult searchResult;

	private PageBook pagebook;

	private Table busyLabel;

	private Composite control;

	private TreeViewer viewer;

	private ISearchResultViewPart part;

	private MenuManager menu;

	private IAction showNextAction;

	private IAction showPreviousAction;

	private IAction expandAllAction;

	private IAction collapseAllAction;

	private IAction copyAction;

	private RemoveSelectedMatchesAction removeSelectedMatchesAction;

	@Inject
	private ReferenceSearchResultContentProvider contentProvider;

	@Inject
	private ReferenceSearchResultLabelProvider labelProvider;

	@Inject
	private ReferenceSearchViewSorter sorter;

	@Inject
	private NavigationService navigationService;

	private boolean isBusyShowing;

	private IQueryListener queryListener;

	private final ISearchResultListener labelUpdater = (e) -> {
		if (viewer != null && !viewer.getControl().isDisposed()
				&& (e instanceof ReferenceSearchResultEvents.Finish || e instanceof ReferenceSearchResultEvents.Removed)) {
			Display.getDefault().asyncExec(() -> part.updateLabel());
		}
	};

	public ReferenceSearchViewPage() {
		showPreviousAction = new ReferenceSearchViewPageActions.ShowPrevious(this);
		showNextAction = new ReferenceSearchViewPageActions.ShowNext(this);
		expandAllAction = new ReferenceSearchViewPageActions.ExpandAll(this);
		collapseAllAction = new ReferenceSearchViewPageActions.CollapseAll(this);
		copyAction = new ReferenceSearchViewPageActions.Copy(this);
		removeSelectedMatchesAction = new ReferenceSearchViewPageActions.RemoveSelectedMatchesAction(this);
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void setID(String id) {
		this.id = id;
	}

	@Override
	public String getLabel() {
		return searchResult == null ? "" : searchResult.getLabel();
	}

	@Override
	public Object getUIState() {
		return viewer.getSelection();
	}

	@Override
	public void restoreState(IMemento memento) {
	}

	@Override
	public void saveState(IMemento memento) {
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
	}

	@Override
	public void setInput(ISearchResult newSearchResult, Object uiState) {
		synchronized (viewer) {
			if (this.searchResult != null) {
				this.searchResult.removeListener(labelUpdater);
			}

			this.searchResult = newSearchResult;
			if (searchResult != null) {
				searchResult.addListener(labelUpdater);
				viewer.setInput(newSearchResult);
				if (uiState instanceof ISelection) {
					viewer.setSelection((ISelection) uiState);
				}
				removeSelectedMatchesAction.setSearchResult(searchResult);
			}
			part.updateLabel();
		}
	}

	@Override
	public void setViewPart(ISearchResultViewPart part) {
		this.part = part;
	}

	@Override
	public void createControl(Composite parent) {
		pagebook = new PageBook(parent, SWT.NULL);
		pagebook.setLayoutData(new GridData(GridData.FILL_BOTH));
		busyLabel = new Table(pagebook, SWT.NONE);
		TableItem item = new TableItem(busyLabel, SWT.NONE);
		item.setText(Messages.ReferenceSearchViewPage_busyLabel);
		busyLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		control = new Composite(pagebook, SWT.NULL);
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
		control.setSize(100, 100);
		control.setLayout(new FillLayout());
		viewer = new TreeViewer(control, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(labelProvider);
		viewer.setComparator(sorter);
		createOpenAndLinkWithEditorHandler();
		IToolBarManager tbm = getSite().getActionBars().getToolBarManager();
		fillToolbar(tbm);
		tbm.update(true);
		pagebook.showPage(control);
		isBusyShowing = false;
		queryListener = createQueryListener();
		NewSearchUI.addQueryListener(queryListener);

		menu = new MenuManager("#PopUp"); //$NON-NLS-1$
		menu.setRemoveAllWhenShown(true);
		menu.setParent(getSite().getActionBars().getMenuManager());
		menu.addMenuListener(mgr -> {
			fillContextMenu(mgr);
			part.fillContextMenu(mgr);
		});

		viewer.getControl().setMenu(menu.createContextMenu(viewer.getControl()));
		viewer.getControl().addKeyListener(KeyListener.keyPressedAdapter(e -> {
			if (e.keyCode == SWT.DEL) {
				removeSelectedMatchesAction.run();
			} else if ((e.stateMask | SWT.COMMAND) != 0 && e.keyCode == 'c') {
				copyAction.run();
			}
		}));
	}

	protected OpenAndLinkWithEditorHelper createOpenAndLinkWithEditorHandler() {
		return navigationService.installNavigationSupport(viewer, new Procedures.Procedure1<OpenEvent>() {

			@Override
			public void apply(OpenEvent openEvent) {
				handleOpen(openEvent);
			}

		});
	}

	protected IQueryListener createQueryListener() {
		return new IQueryListener() {

			@Override
			public void queryStarting(ISearchQuery query) {
				showBusyLabel(true);
			}

			@Override
			public void queryRemoved(ISearchQuery query) {
				showBusyLabel(false);
			}

			@Override
			public void queryFinished(ISearchQuery query) {
				showBusyLabel(false);
			}

			@Override
			public void queryAdded(ISearchQuery query) {
				showBusyLabel(false);
			}
		};
	}

	@Override
	public void dispose() {
		NewSearchUI.removeQueryListener(queryListener);
		super.dispose();
	}

	protected void showBusyLabel(final boolean shouldShowBusy) {
		if (shouldShowBusy != isBusyShowing) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					if (shouldShowBusy)
						pagebook.showPage(busyLabel);
					else
						pagebook.showPage(control);
				}
			});
			isBusyShowing = shouldShowBusy;
		}
	}

	protected void fillToolbar(IToolBarManager tbm) {
		tbm.appendToGroup(IContextMenuConstants.GROUP_SHOW, showNextAction);
		tbm.appendToGroup(IContextMenuConstants.GROUP_SHOW, showPreviousAction);
		IActionBars actionBars = getSite().getActionBars();
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(ActionFactory.NEXT.getId(), showNextAction);
			actionBars.setGlobalActionHandler(ActionFactory.PREVIOUS.getId(), showPreviousAction);
		}
		tbm.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP, expandAllAction);
		tbm.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP, collapseAllAction);
	}

	/**
	 * @since 2.18
	 */
	protected void fillContextMenu(IMenuManager mgr) {
		mgr.add(copyAction);
		mgr.add(removeSelectedMatchesAction);
	}

	protected void handleOpen(OpenEvent openEvent) {
		navigationService.open(openEvent);
	}

	@Override
	public Control getControl() {
		return pagebook;
	}

	@Override
	public void setFocus() {
		Control control = viewer.getControl();
		if (control != null && !control.isDisposed())
			control.setFocus();
	}

	public TreeViewer getViewer() {
		return viewer;
	}

	/**
	 * @since 2.18
	 */
	protected ReferenceSearchResultContentProvider getContentProvider() {
		return contentProvider;
	}

	/**
	 * @since 2.18
	 */
	protected ReferenceSearchResultLabelProvider getLabelProvider() {
		return labelProvider;
	}

}
