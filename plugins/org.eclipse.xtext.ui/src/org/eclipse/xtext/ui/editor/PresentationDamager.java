/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.Regions;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.common.collect.Iterables;

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
		if (!(e.getDocument() instanceof IXtextDocument)) {
			return new Region(0, 0);
		}
		XtextDocument document = (XtextDocument) e.getDocument();
		IRegion lastDamage = document.getLastDamage();
		// check whether this is just a presentation invalidation not based on a real document change
		if (lastDamage == null || !isEventMatchingLastDamage(e, lastDamage)) {
			IRegion result = computeInterSection(partition, e, document);
			return result;
		}
		
		if (!TextUtilities.overlaps(partition, lastDamage) && lastDamage.getOffset()<e.getDocument().getLength()) {
			if (documentPartitioningChanged)
				return partition;
			return lastDamage;
		}
		
		int offset = Math.max(lastDamage.getOffset(),partition.getOffset());
		int endOffset = Math.min(lastDamage.getOffset()+lastDamage.getLength(),partition.getOffset()+partition.getLength());
			
		IRegion result = new Region(offset,endOffset-offset);
		return result;
	}

	/**
	 * @return the common region of the given partition and the changed region in the DocumentEvent based on the underlying tokens.
	 */
	protected IRegion computeInterSection(ITypedRegion partition, DocumentEvent e, XtextDocument document) {
		Iterable<ILexerTokenRegion> tokensInPartition = Iterables.filter(document.getTokens(),Regions.overlaps(partition.getOffset(), partition.getLength()));
		Iterator<ILexerTokenRegion> tokens = Iterables.filter(tokensInPartition, Regions.overlaps(e.getOffset(), e.getLength())).iterator();
		if (tokens.hasNext()) {
			ILexerTokenRegion first = tokens.next();
			ILexerTokenRegion last = first;
			while(tokens.hasNext())
				last = tokens.next();
			return new Region(first.getOffset(), last.getOffset()+last.getLength() -first.getOffset());
		}
		// this shouldn't happen, but just in case return the whole partition
		return partition;
	}

	/**
	 * @return <code>true</code> only if the lastDamage is encloses the affected text of the given DocumentEvent.
	 */
	protected boolean isEventMatchingLastDamage(DocumentEvent e, IRegion lastDamage) {
		int eventStart = e.getOffset();
		int eventEnd = eventStart+e.getText().length();
		int damageStart = lastDamage.getOffset();
		int damageEnd = damageStart+lastDamage.getLength();
		boolean result = damageStart<=eventStart && damageEnd>=eventEnd;
		return result;
	}

}
