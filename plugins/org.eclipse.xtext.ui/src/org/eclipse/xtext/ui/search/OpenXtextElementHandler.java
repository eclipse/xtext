/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.search;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OpenXtextElementHandler extends AbstractHandler {

	@Inject
	private IURIEditorOpener uriEditorOpener;
	
	@Inject
	private IXtextEObjectSearch searchEngine;
	
	@Inject
	private GlobalDescriptionLabelProvider globalDescriptionLabelProvider;
	
	@Inject(optional=true)
	@Named("xtext.enable.styledLables")
	private boolean enableStyledLabels = true;
	
	private static final Logger LOG = Logger.getLogger(OpenXtextElementHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell activeShell = HandlerUtil.getActiveShell(event);
		ListDialog searchDialog = createSearchDialog(event, activeShell, searchEngine);
		int result = searchDialog.open();
		if (result == Window.OK) {
			try {
				Object[] selections = searchDialog.getResult();
				if (selections != null && selections.length > 0) {
					Object selection = selections[0];
					if (selection instanceof IEObjectDescription) {
						IEObjectDescription selectedObjectDescription = (IEObjectDescription) selection;
						uriEditorOpener.open(selectedObjectDescription.getEObjectURI(), true);
					}
				}
			} catch (Exception e) {
				LOG.error("Error opening editor", e);
				throw new ExecutionException("Error opening editor", e);
			}
		}
		return null;
	}

	protected ListDialog createSearchDialog(ExecutionEvent event, Shell activeShell, IXtextEObjectSearch searchEngine) {
		return new XtextEObjectSearchDialog(activeShell, searchEngine, globalDescriptionLabelProvider, isEnableStyledLabels());
	}

	public void setEnableStyledLabels(boolean enableStyledLabels) {
		this.enableStyledLabels = enableStyledLabels;
	}

	public boolean isEnableStyledLabels() {
		return enableStyledLabels;
	}

}
