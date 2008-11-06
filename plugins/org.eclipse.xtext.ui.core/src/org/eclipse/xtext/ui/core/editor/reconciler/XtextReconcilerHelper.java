/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.reconciler;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextReconcilerHelper {

	private static final Logger log = Logger.getLogger(XtextReconcilerHelper.class);
	
	public static UnitOfWork<Object> createReconcileJob(final IRegion region, final IDocument document) {
		
		return new UnitOfWork<Object>() {
			public Object exec(XtextResource resource) throws Exception {
				if (log.isDebugEnabled())
					log.debug("Preparing reconciliation.");
				try {
					if (!(region instanceof ReplaceRegion)) {
						throw new IllegalArgumentException("Region to be reconciled must be a ReplaceRegion");
					}
					ReplaceRegion replaceRegionToBeProcessed = (ReplaceRegion) region;
					
					if(log.isTraceEnabled())
						log.trace("Parsing replace region '" + replaceRegionToBeProcessed.getText() + "'.");
					
					resource.update(replaceRegionToBeProcessed.getOffset(), replaceRegionToBeProcessed.getLength(),
							replaceRegionToBeProcessed.getText());
				}
				catch (Throwable t) {
					if (log.isDebugEnabled())
						log.debug("Partial parsing failed. Performing full reparse", t);
					resource.reparse(document.get());
				}
				return null;
			}
		};
	}
}
