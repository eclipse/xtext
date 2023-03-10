/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.imports;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.label.AbstractLabelProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.imports.TypeUsage;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeChooser {

	@Inject
	private ILabelProvider labelProvider;
	
	private ISelection originalSelection;
	
	public JvmDeclaredType choose(final List<JvmDeclaredType> candidateTypes, Iterable<TypeUsage> usages, final XtextResource resource) {
		XtextEditor activeXtextEditor = EditorUtils.getActiveXtextEditor();
		if (activeXtextEditor==null) return null;
		revealInEditor(activeXtextEditor, usages, resource);
		Shell shell = Display.getDefault().getActiveShell();
		IStructuredContentProvider contentProvider = new ContentProvider();
		Dialog dialog = new Dialog(shell, new LabelProvider(labelProvider), contentProvider);
		dialog.setInput(candidateTypes);
		dialog.setInitialSelections((Object[])new JvmDeclaredType[] { candidateTypes.get(0) });
		int result = dialog.open();
		if(originalSelection != null)
			activeXtextEditor.getSelectionProvider().setSelection(originalSelection);
		if(result == Window.OK && dialog.getResult().length > 0) 
			return (JvmDeclaredType) dialog.getResult()[0];
		else 
			return null;
	}

	protected void revealInEditor(XtextEditor activeXtextEditor, Iterable<TypeUsage> usages, final XtextResource resource) {
		boolean isRevealUsages = activeXtextEditor.getDocument().priorityReadOnly(new IUnitOfWork<Boolean, XtextResource>() {
			@Override
			public Boolean exec(XtextResource state) throws Exception {
				return state.getURI().equals(resource.getURI());
			}
		});
		if(isRevealUsages) {
			originalSelection = activeXtextEditor.getSelectionProvider().getSelection();
			ITextRegion firstOccurrence = usages.iterator().next().getTextRegion();
			activeXtextEditor.selectAndReveal(firstOccurrence.getOffset(), firstOccurrence.getLength());
		}
	}

	protected static class ContentProvider implements IStructuredContentProvider {
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public void dispose() {
		}

		@Override
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			return toArray((List<JvmDeclaredType>)inputElement, JvmDeclaredType.class);
		}
	}

	protected static class LabelProvider extends AbstractLabelProvider {

		public LabelProvider(ILabelProvider delegate) {
			super(delegate);
		}
		
		@Override
		protected String doGetText(Object element) {
			return ((JvmDeclaredType) element).getIdentifier();
		}
	}
	
	protected static class Filter extends ViewerFilter {

		private SearchPattern searchPattern;

		public Filter(String pattern) {
			searchPattern = new SearchPattern();
			searchPattern.setPattern(pattern);
		}
		
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return searchPattern.matches(((JvmDeclaredType)element).getIdentifier());
		}
	}
	
	protected static class Dialog extends ListDialog {

		protected Text searchControl;

		public Dialog(Shell parent, ILabelProvider labelProvider, IStructuredContentProvider contentProvider) {
			super(parent);
			setTitle(Messages.OrganizeImports); //$NON-NLS-1$
			setMessage(Messages.TypeChooser_dialogTitle);
			setAddCancelButton(true);
			setContentProvider(contentProvider);
			setLabelProvider(labelProvider);
		}
		
		@Override
		protected Label createMessageArea(Composite composite) {
			Label label = super.createMessageArea(composite);
			searchControl = new Text(composite, SWT.BORDER | SWT.SEARCH | SWT.ICON_CANCEL);
			setDefaultGridData(searchControl);
			ModifyListener textModifyListener = new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					applyFilter();
				}
			};
			searchControl.addModifyListener(textModifyListener);
			searchControl.addKeyListener(new KeyAdapter() {
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
			return label;
		}
		
		private void setDefaultGridData(Control control) {
			control.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		}

		protected void applyFilter() {
			String searchPattern = searchControl.getText();
			if (searchPattern != null) {
				getTableViewer().resetFilters();
				getTableViewer().addFilter(new Filter(searchPattern));
			}
		}
	}
}
