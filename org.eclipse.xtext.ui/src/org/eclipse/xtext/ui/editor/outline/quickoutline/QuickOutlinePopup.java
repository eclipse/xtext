/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeContentProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Jan Koehnlein - Adaption to new outline architecture
 */
public class QuickOutlinePopup extends PopupDialog implements DisposeListener {

	protected class NamePatternFilter extends ViewerFilter {

		public NamePatternFilter() {
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			StringMatcher matcher = getMatcher();
			if (matcher == null || !(viewer instanceof TreeViewer))
				return true;
			TreeViewer treeViewer = (TreeViewer) viewer;

			String matchName = ((ILabelProvider) treeViewer.getLabelProvider()).getText(element);
			matchName = TextProcessor.deprocess(matchName);
			if (matchName != null && matcher.match(matchName))
				return true;

			return hasUnfilteredChild(treeViewer, element);
		}

		/**
		 * @since 2.1 protected
		 */
		protected boolean hasUnfilteredChild(TreeViewer viewer, Object element) {
			Object[] children = ((ITreeContentProvider) viewer.getContentProvider()).getChildren(element);
			for (int i = 0; i < children.length; i++)
				if (select(viewer, element, children[i]))
					return true;
			return false;
		}
	}

	@Inject
	private IOutlineTreeProvider treeProvider;

	@Inject
	private OutlineNodeLabelProvider labelProvider;

	@Inject
	private OutlineNodeContentProvider contentProvider;

	@Inject
	private OutlineFilterAndSorter.IComparator comparator;

	@Inject
	private QuickOutlineFilterAndSorter filterAndSorter;

	@Inject
	private PrefixMatcher prefixMatcher;

	@Inject
	private OutlineNodeElementOpener elementOpener;

	@Inject
	private IQuickOutlineContribution.Composite contributions;

	private int TREESTYLE = SWT.V_SCROLL | SWT.H_SCROLL;

	private TreeViewer treeViewer;

	private IXtextDocument document;

	private XtextEditor xtextEditor;

	private Text filterText;

	private PrefixMatcherOutlineAdapter prefixMatcherOutlineAdapter;

	private KeyStroke invokingKeystroke;

	private String invokingKeystrokeFormatted;

	public QuickOutlinePopup() {
		this(null);
	}

	public QuickOutlinePopup(Shell parent) {
		super(parent, SWT.RESIZE, true, false, true, true, true, null, Messages.QuickOutlinePopup_pressESC);
	}

	@Override
	protected Control createTitleControl(Composite parent) {
		filterText = createFilterText(parent);
		return filterText;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		treeViewer = createTreeViewer(parent, TREESTYLE);
		scheduleRefresh();

		final Tree tree = treeViewer.getTree();
		tree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == 0x1B) { // ESC
					dispose();
				} else {
					if (e.keyCode == invokingKeystroke.getNaturalKey()
							&& e.stateMask == invokingKeystroke.getModifierKeys()) {
						changeOutlineMode();
						e.doit = false;
					}
				}
			}
		});

		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				gotoSelectedElement();
			}
		});

		installFilter();
		setInfoText();

		addDisposeListener(this);
		return treeViewer.getControl();
	}

	/**
	 * @since 2.2
	 */
	protected void setInfoText() {
		if (treeProvider instanceof IOutlineTreeProvider.ModeAware) {
			setInfoText("Press '" + invokingKeystrokeFormatted + "' to "
					+ ((IOutlineTreeProvider.ModeAware) treeProvider).getNextMode().getDescription());
		} else {
			setInfoText(Messages.QuickOutlinePopup_pressESC);
		}
	}

	protected TreeViewer createTreeViewer(Composite parent, int style) {
		Tree tree = new Tree(parent, SWT.SINGLE | (style & ~SWT.MULTI));
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = tree.getItemHeight() * 12;
		tree.setLayoutData(gd);

		final TreeViewer treeViewer = new TreeViewer(tree);
		treeViewer.addFilter(new NamePatternFilter());

		treeViewer.setContentProvider(contentProvider);
		filterAndSorter.setComparator(comparator);
		contentProvider.setFilterAndSorter(filterAndSorter);
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setAutoExpandLevel(2);
		return treeViewer;
	}

	/**
	 * @since 2.7
	 */
	public void scheduleRefresh() {
		if (getTreeViewer() != null) {
			IOutlineNode rootNode = document.priorityReadOnly(new IUnitOfWork<IOutlineNode, XtextResource>() {
				@Override
				public IOutlineNode exec(XtextResource state) throws Exception {
					IOutlineNode rootNode = treeProvider.createRoot(document);
					createChildrenRecursively(rootNode.getChildren());
					return rootNode;
				}

				protected void createChildrenRecursively(List<IOutlineNode> nodes) {
					for (IOutlineNode node : nodes) {
						createChildrenRecursively(node.getChildren());
					}
				}
			});
			getTreeViewer().setInput(rootNode);
		}
	}

	protected Text createFilterText(Composite parent) {
		filterText = new Text(parent, SWT.NONE);
		Dialog.applyDialogFont(filterText);

		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.CENTER;
		filterText.setLayoutData(data);

		filterText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 0x0D) // return
					gotoSelectedElement();
				if (e.keyCode == SWT.ARROW_DOWN)
					treeViewer.getTree().setFocus();
				if (e.keyCode == SWT.ARROW_UP)
					treeViewer.getTree().setFocus();
				if (e.character == 0x1B) // ESC
					dispose();
				if (e.keyCode == invokingKeystroke.getNaturalKey()
						&& e.stateMask == invokingKeystroke.getModifierKeys()) {
					changeOutlineMode();
					e.doit = false;
				}

			}
		});
		return filterText;
	}

	@Override
	protected Control getFocusControl() {
		return filterText;
	}

	/**
	 * @since 2.1 protected
	 */
	protected void installFilter() {
		filterText.setText(""); //$NON-NLS-1$

		filterText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String text = ((Text) e.widget).getText();
				setMatcherString(text, true);
			}
		});
	}

	protected StringMatcher getMatcher() {
		return prefixMatcherOutlineAdapter;
	}

	protected boolean hasMatcher() {
		return prefixMatcherOutlineAdapter != null;
	}

	protected void setMatcherString(String pattern, boolean update) {
		if (pattern.length() == 0) {
			prefixMatcherOutlineAdapter = null;
		} else {
			prefixMatcherOutlineAdapter = new PrefixMatcherOutlineAdapter(pattern, prefixMatcher);
		}

		if (update)
			stringMatcherUpdated();
	}

	protected void stringMatcherUpdated() {
		// refresh viewer to re-filter
		treeViewer.getControl().setRedraw(false);
		treeViewer.refresh();
		treeViewer.expandAll();
		selectFirstMatch();
		treeViewer.getControl().setRedraw(true);
	}

	protected void selectFirstMatch() {
		Object[] rootElements = contentProvider.getElements(treeViewer.getInput());
		Object matchingElement = findMatchingElement(rootElements);

		ISelection selection = StructuredSelection.EMPTY;
		if (matchingElement != null) {
			selection = new StructuredSelection(matchingElement);
		}
		treeViewer.setSelection(selection);
	}

	protected Object findMatchingElement(Object[] elements) {
		if (hasMatcher()) {
			for (Object element : elements) {
				String text = labelProvider.getStyledStringProvider().getStyledText(element).getString();
				if (getMatcher().match(text)) {
					return element;
				}
				Object[] children = contentProvider.getChildren(element);
				Object matchingChild = findMatchingElement(children);
				if (matchingChild != null) {
					return matchingChild;
				}
			}
		}
		return null;
	}

	protected Object getSelectedElement() {
		if (treeViewer == null) {
			return null;
		}
		return ((IStructuredSelection) treeViewer.getSelection()).getFirstElement();
	}

	/**
	 * @since 2.1 protected
	 */
	protected void gotoSelectedElement() {
		Object selectedElement = getSelectedElement();
		if (selectedElement != null) {
			dispose();
			if (selectedElement instanceof IOutlineNode) {
				elementOpener.open((IOutlineNode) selectedElement, xtextEditor.getInternalSourceViewer());
			}
		}
	}

	public final void dispose() {
		close();
	}

	public void addDisposeListener(DisposeListener listener) {
		getShell().addDisposeListener(listener);
	}

	public void removeDisposeListener(DisposeListener listener) {
		getShell().removeDisposeListener(listener);
	}

	@Override
	public void widgetDisposed(DisposeEvent event) {
		treeViewer = null;
		filterText = null;
	}

	public void setInput(IXtextDocument document) {
		this.document = document;
		scheduleRefresh();
	}

	@Override
	protected Point getDefaultLocation(Point initialSize) {
		Control textWidget = xtextEditor.getAdapter(Control.class);
		Point size = textWidget.getSize();

		Point popupLocation = new Point((size.x / 2) - (initialSize.x / 2), (size.y / 2) - (initialSize.y / 2));
		return textWidget.toDisplay(popupLocation);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		String sectionName = "xtext.quickoutline"; //$NON-NLS-1$

		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(sectionName);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(sectionName);
		}

		return settings;
	}

	public void setEditor(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
	}

	/**
	 * @since 2.2
	 */
	public void setEvent(Event event) {
		this.invokingKeystrokeFormatted = KeySequence
				.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(SWTKeySupport.convertEventToUnmodifiedAccelerator(event)))
				.format();
		this.invokingKeystroke = KeyStroke.getInstance(event.stateMask, event.keyCode);
	}

	/**
	 * @since 2.2
	 */
	protected void changeOutlineMode() {
		if (treeProvider instanceof IOutlineTreeProvider.ModeAware) {
			IOutlineTreeProvider.ModeAware modeTreeProvider = (IOutlineTreeProvider.ModeAware) treeProvider;
			OutlineMode nextMode = modeTreeProvider.getNextMode();
			modeTreeProvider.setCurrentMode(nextMode);
			setInfoText();
			setInput(document);
		}
	}

	/**
	 * @since 2.7
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	@Override
	public boolean close() {
		contributions.deregister(this);
		return super.close();
	}

	@Override
	protected void fillDialogMenu(IMenuManager dialogMenu) {
		super.fillDialogMenu(dialogMenu);
		dialogMenu.add(new Separator("XtextContributions"));
		contributions.register(this, dialogMenu);
	}
}
