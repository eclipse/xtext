/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.action;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.core.dialog.AbstractEObjectSearchDialog;
import org.eclipse.xtext.ui.core.editor.IURIEditorOpener;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OpenXtextElementHandler extends AbstractHandler {

	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Inject
	private IURIEditorOpener uriEditorOpener;

	private static final Logger LOG = Logger.getLogger(OpenXtextElementHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell activeShell = Display.getCurrent().getActiveShell();
		AbstractEObjectSearchDialog searchDialog = new AbstractEObjectSearchDialog(activeShell) {
			@Override
			protected Iterable<IEObjectDescription> getSearchScope() {
				return Iterables.concat(Iterables.transform(getResourceDescriptions().getAllResourceDescriptions(),
						new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
							public Iterable<IEObjectDescription> apply(IResourceDescription from) {
								return from.getExportedObjects();
							}
						}));
			}
		};
		int result = searchDialog.open();
		if (result == Window.OK) {
			try {
				Object[] selections = searchDialog.getResult();
				if (selections != null && selections.length > 0) {
					Object selection = selections[0];
					if (selection instanceof IEObjectDescription) {
						IEObjectDescription selectedObjectDescription = (IEObjectDescription) selection;
						uriEditorOpener.open(selectedObjectDescription.getEObjectURI());
					}
				}
			} catch (Exception e) {
				LOG.error("Error opening editor", e);
				throw new ExecutionException("Error opening editor", e);
			}
		}
		return null;
	}

	protected IResourceDescriptions getResourceDescriptions() {
		return resourceDescriptions;
	}

}
