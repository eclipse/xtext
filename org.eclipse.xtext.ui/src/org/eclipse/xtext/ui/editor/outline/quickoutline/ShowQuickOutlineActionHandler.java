/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.quickoutline;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ShowQuickOutlineActionHandler extends AbstractHandler {
	
	@Inject
	private Injector injector;
	
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		if (xtextEditor != null) {
			final IXtextDocument document = xtextEditor.getDocument();
			document.priorityReadOnly(new IUnitOfWork.Void<XtextResource>()  {
				@Override
				public void process(XtextResource state) throws Exception {
					final QuickOutlinePopup quickOutlinePopup = createPopup(xtextEditor.getEditorSite().getShell());
					quickOutlinePopup.setEditor(xtextEditor);
					quickOutlinePopup.setInput(document);
					if (event.getTrigger() != null) {
						quickOutlinePopup.setEvent((Event) event.getTrigger());
					}
					quickOutlinePopup.open();
				}
			});
		}
		return null;
	}
	
	/**
	 * @since 2.2
	 */
	protected QuickOutlinePopup createPopup(Shell parent) {
		QuickOutlinePopup result = new QuickOutlinePopup(parent);
		injector.injectMembers(result);
		return result;
	}

}
