/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.util.CollectionBasedAcceptor;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Lists;

public abstract class OpenOppositeFileHandler extends AbstractHandler {

	protected abstract void collectOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		IWorkbenchPage page = editor.getSite().getPage();
		Collection<FileOpener> destinations = Lists.newArrayList();
		collectOpeners(editor, CollectionBasedAcceptor.of(destinations));
		switch (destinations.size()) {
			case 0:
				return null;
			case 1:
				destinations.iterator().next().open(page);
				return null;
			default:
				List<FileOpener> selected = selectOpeners(page, destinations);
				for (FileOpener sel : selected)
					sel.open(page);
				return null;
		}
	}

	protected List<FileOpener> selectOpeners(IWorkbenchPage page, Collection<FileOpener> openers) {
		Shell shell = page.getWorkbenchWindow().getShell();
		SelectionDialog dialog = new FileOpenerSelector(shell, openers);
		if (dialog.open() == Window.OK) {
			List<FileOpener> result = Lists.newArrayList();
			for (Object item : dialog.getResult())
				if (item instanceof FileOpener)
					result.add((FileOpener) item);
			return result;
		}
		return Collections.emptyList();
	}
}
