/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import java.io.StringReader;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.util.DisplayRunnable;
import org.eclipse.xtext.util.DiffUtil;
import org.eclipse.xtext.util.EmfStructureComparator;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.4
 * @noextend
 * @noreference
 */
public class XtextReconcilerDebugger {
	
	private static final Logger LOG = Logger.getLogger(XtextReconcilerDebugger.class);
	
	@Inject
	private IParser parser;
	
	@Inject 
	private EmfStructureComparator emfStructureComparator;
	
	public void assertModelInSyncWithDocument(IDocument document, XtextResource resource, final ReconcilerReplaceRegion region) {
		if (document instanceof IDocumentExtension4 && resource != null) {
			long beforeGet = ((IDocumentExtension4) document).getModificationStamp();
			final String documentContent = document.get();
			long afterGet = ((IDocumentExtension4) document).getModificationStamp();
			if (beforeGet == afterGet && beforeGet == resource.getModificationStamp()) {
				IParseResult parseResult = resource.getParseResult();
				if (parseResult != null) {
					ICompositeNode rootNode = parseResult.getRootNode();
					final String resourceContent = rootNode.getText();
					if (!resourceContent.equals(documentContent)) {
						new DisplayRunnable() {
							@Override
							protected void run() throws Exception {
								LOG.error("XtextDocument and XtextResource have run out of sync:\n" 
												+ DiffUtil.diff(documentContent, resourceContent));
								LOG.error("Events: \n\t" + Joiner.on("\n\t").join(region.getDocumentEvents()));
								LOG.error("ReplaceRegion: \n\t'" + region + "'" );
								MessageDialog.openError(
										Display.getCurrent().getActiveShell(),
										"XtextReconcilerDebugger",
										"XtextDocument and XtextResource have run out of sync."
												+ "\n\nSee log for details.");
							}
							
						}.syncExec();
					} else {
						if (LOG.isDebugEnabled())
							LOG.debug("Model and document are in sync");
					}
				}
			}
		}
	}
	
	public void assertResouceParsedCorrectly(XtextResource resource, final ReconcilerReplaceRegion region) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ICompositeNode rootNode = parseResult.getRootNode();
			final String resourceContent = rootNode.getText();
			IParseResult reparseResult = parser.parse(new StringReader(resourceContent));
			if(!emfStructureComparator.isSameStructure(parseResult.getRootASTElement(), reparseResult.getRootASTElement())) {
				new DisplayRunnable() {
					@Override
					protected void run() throws Exception {
						LOG.error("PartialParsing produced wrong model");
						LOG.error("Events: \n\t" + Joiner.on("\n\t").join(region.getDocumentEvents()));
						LOG.error("ReplaceRegion: \n\t'" + region + "'" );
						MessageDialog.openError(
								Display.getCurrent().getActiveShell(),
								"XtextReconcilerDebugger",
								"PartialParsing produced wrong model."
										+ "\n\nSee log for details.");
					}
					
				};
				
			}
		}
	}
}
