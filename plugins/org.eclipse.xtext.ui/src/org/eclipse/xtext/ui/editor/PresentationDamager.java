/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

/**
 * 
 * This implementations relies on an XtextDocument, which
 * provides information about the damaged region of the last change.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class PresentationDamager implements IPresentationDamager {

	public void setDocument(IDocument document) {}

	public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent e, boolean documentPartitioningChanged) {
		//TODO support partitions
		XtextDocument document = (XtextDocument) e.getDocument();
		return document.getLastDamage();
	}

}
