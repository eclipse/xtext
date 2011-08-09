/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.edit;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xtend2.formatting.OrganizeImports;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OrganizeImportsHandler extends AbstractHandler {
	
	@Inject
	private OrganizeImports organizeImports;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
		if (editor != null) {
			Pair<Region, String> result = editor.getDocument().readOnly(new IUnitOfWork<Pair<Region,String>, XtextResource>() {
				public Pair<Region,String> exec(XtextResource state) throws Exception {
					final TextRegion computeRegion = organizeImports.computeRegion(state);
					if (computeRegion == null)
						return null;
					final String organizedImportSection = organizeImports.getOrganizedImportSection(state);
					if (organizedImportSection == null)
						return null;
					return Tuples.create(new Region(computeRegion.getOffset(), computeRegion.getLength()) , organizedImportSection);
				}
			});
			if (result == null)
				return null;
			try {
				String string = editor.getDocument().get(result.getFirst().getOffset(), result.getFirst().getLength());
				if (!string.equals(result.getSecond())) {
					editor.getDocument().replace(result.getFirst().getOffset(), result.getFirst().getLength(), result.getSecond());
				}
			} catch (BadLocationException e) {
				// ignore
			}
			
		}
		return null;
	}
	
}
