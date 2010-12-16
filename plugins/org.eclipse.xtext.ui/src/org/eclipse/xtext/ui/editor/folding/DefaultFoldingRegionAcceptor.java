/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultFoldingRegionAcceptor implements IFoldingRegionAcceptor {
	private static final Logger log = Logger.getLogger(DefaultFoldingRegionAcceptor.class);
	private List<IFoldingRegion> foldingRegions;
	private IXtextDocument xtextDocument;

	public DefaultFoldingRegionAcceptor(IXtextDocument document, List<IFoldingRegion> foldingRegions) {
		super();
		this.foldingRegions = foldingRegions;
		this.xtextDocument = document;
	}

	public void accept(int offset, int length) {
		accept(offset, length, null);
	}

	public void accept(int offset, int length, StyledString text) {
		Position position = getPosition(offset, length);
		IFoldingRegion foldingRegion = newFoldingRegion(position, text);
		if (foldingRegion != null) {
			foldingRegions.add(foldingRegion);
		}
	}

	protected Position getPosition(int offset, int length) {
		Position position = null;
		try {
			int startLine = xtextDocument.getLineOfOffset(offset);
			int endLine = xtextDocument.getLineOfOffset(offset + length);
			if (startLine < endLine) {
				int start = xtextDocument.getLineOffset(startLine);
				int end = xtextDocument.getLineOffset(endLine) + xtextDocument.getLineLength(endLine);
				position = new Position(start, end - start);
			}
		} catch (BadLocationException e) {
			log.error(e);
		}
		return position;
	}

	protected IFoldingRegion newFoldingRegion(Position position) {
		return newFoldingRegion(position, null);
	}

	protected IFoldingRegion newFoldingRegion(Position position, StyledString styledString) {
		return position != null ? new DefaultFoldingRegion(position, styledString) : null;
	}

}
