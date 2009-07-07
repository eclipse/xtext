/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.reconciler;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class XtextReconcilerUnitOfWork extends IUnitOfWork.Void<XtextResource> {

	private static final Logger log = Logger.getLogger(XtextReconcilerUnitOfWork.class);

	private IRegion region;

	private IDocument document;

	/**
	 * @param region
	 * @param document
	 */
	public XtextReconcilerUnitOfWork(IRegion region, IDocument document) {
		super();
		this.document = document;
		this.region = region;
	}

	@Override
	public void process(XtextResource resource) throws Exception {
		if (log.isDebugEnabled())
			log.debug("Preparing reconciliation.");
		try {
			if (!(region instanceof ReplaceRegion)) {
				throw new IllegalArgumentException("Region to be reconciled must be a ReplaceRegion");
			}
			ReplaceRegion replaceRegionToBeProcessed = (ReplaceRegion) region;

			if (log.isTraceEnabled())
				log.trace("Parsing replace region '" + replaceRegionToBeProcessed.getText() + "'.");

			resource.update(replaceRegionToBeProcessed.getOffset(), replaceRegionToBeProcessed.getLength(),
					replaceRegionToBeProcessed.getText());
			EcoreUtil.resolveAll(resource);
		}
		catch (Exception t) {
			if (log.isDebugEnabled())
				log.debug("Partial parsing failed. Performing full reparse", t);
			try {
				resource.reparse(document.get());
			} catch (Exception e) {
				log.error("Parsing in reconciler failed.", e);
			}
		}
	}
}
