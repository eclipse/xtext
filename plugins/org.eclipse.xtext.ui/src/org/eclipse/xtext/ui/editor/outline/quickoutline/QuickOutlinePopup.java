/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.AbstractTreeViewer;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNodeLabelProvider;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.internal.Activator;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
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

		private boolean hasUnfilteredChild(TreeViewer viewer, Object element) {
			Object[] children = ((ITreeContentProvider) viewer.getContentProvider()).getChildren(element);
			for (int i = 0; i < children.length; i++)
				if (select(viewer, element, children[i]))
					return true;
			return false;
		}
	}

	@Inject
	private IOutlineTreeProvider contentProvider;

	@Inject
	private ContentOutlineNodeLabelProvider labelProvider;

	private int TREESTYLE = SWT.V_SCROLL | SWT.H_SCROLL;

	private TreeViewer treeViewer;

	private IXtextDocument document;

	private XtextEditor xtextEditor;

	private Text filterText;

	private StringMatcher stringMatcher;

	public QuickOutlinePopup() {
		this(null);
	}

	public QuickOutlinePopup(Shell parent) {
		super(parent, PopupDialog.HOVER_SHELLSTYLE | SWT.RESIZE, true, true, true, true, true, null,
				"Press 'Esc' to exit the quick outline.");
	}

	@Override
	protected Control createTitleControl(Composite parent) {
		filterText = createFilterText(parent);
		return filterText;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		treeViewer = createTreeViewer(parent, TREESTYLE);

		final Tree tree = treeViewer.getTree();
		tree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == 0x1B) // ESC
					dispose();
			}
		});

		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				gotoSelectedElement();
			}
		});

		installFilter();

		addDisposeListener(this);
		return treeViewer.getControl();
	}

	protected TreeViewer createTreeViewer(Composite parent, int style) {
		Tree tree = new Tree(parent, SWT.SINGLE | (style & ~SWT.MULTI));
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = tree.getItemHeight() * 12;
		tree.setLayoutData(gd);

		final TreeViewer treeViewer = new TreeViewer(tree);
		treeViewer.addFilter(new NamePatternFilter());

		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
		treeViewer.setInput(document);

		return treeViewer;
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
			}
		});

		return filterText;
	}

	@Override
	protected Control getFocusControl() {
		return filterText;
	}

	private void installFilter() {
		filterText.setText("");

		filterText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String text = ((Text) e.widget).getText();
				int length = text.length();
				if (length > 0 && text.charAt(length - 1) != '*') {
					text = text + '*';
				}
				setMatcherString(text, true);
			}
		});
	}

	protected StringMatcher getMatcher() {
		return stringMatcher;
	}

	protected boolean hasMatcher() {
		return stringMatcher != null;
	}

	protected void setMatcherString(String pattern, boolean update) {
		if (pattern.length() == 0) {
			stringMatcher = null;
		} else {
			boolean ignoreCase = pattern.toLowerCase().equals(pattern);
			stringMatcher = new StringMatcher(pattern, ignoreCase);
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
				String text = labelProvider.getText(element);
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

	private void gotoSelectedElement() {
		Object selectedElement = getSelectedElement();
		if (selectedElement != null) {
			dispose();
			if (selectedElement instanceof ContentOutlineNode) {
				final ContentOutlineNode outlineNode = (ContentOutlineNode) selectedElement;
				xtextEditor.selectAndReveal(outlineNode.getSelectionOffset(), outlineNode.getSelectionLength());
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

	public void widgetDisposed(DisposeEvent event) {
	}

	public void setInput(IXtextDocument document) {
		if (treeViewer != null) {
			treeViewer.setInput(document);
		} else {
			this.document = document;
		}
	}

	@Override
	protected Point getInitialLocation(Point initialSize) {
		Control textWidget = (Control) xtextEditor.getAdapter(Control.class);
		Point size = textWidget.getSize();

		Point popupLocation = new Point((size.x / 2) - (initialSize.x / 2), (size.y / 2) - (initialSize.y / 2));
		return textWidget.toDisplay(popupLocation);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		String sectionName = "xtext.quickoutline";

		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(sectionName);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(sectionName);
		}

		return settings;
	}

	public void setEditor(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
	}
}
