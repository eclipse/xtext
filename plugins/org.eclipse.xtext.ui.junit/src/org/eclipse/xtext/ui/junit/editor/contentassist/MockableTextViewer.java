/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.junit.editor.contentassist;

import org.eclipse.jface.text.IAutoIndentStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IEventConsumer;
import org.eclipse.jface.text.IFindReplaceTarget;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IViewportListener;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class MockableTextViewer implements ITextViewer {

	public void activatePlugins() {
		throw new UnsupportedOperationException();
	}

	public void addTextInputListener(ITextInputListener listener) {
		throw new UnsupportedOperationException();
	}

	public void addTextListener(ITextListener listener) {
		throw new UnsupportedOperationException();
	}

	public void addViewportListener(IViewportListener listener) {
		throw new UnsupportedOperationException();
	}

	public void changeTextPresentation(TextPresentation presentation, boolean controlRedraw) {
		throw new UnsupportedOperationException();
	}

	public int getBottomIndex() {
		throw new UnsupportedOperationException();
	}

	public int getBottomIndexEndOffset() {
		throw new UnsupportedOperationException();
	}

	public IDocument getDocument() {
		throw new UnsupportedOperationException();
	}

	public IFindReplaceTarget getFindReplaceTarget() {
		throw new UnsupportedOperationException();
	}

	public Point getSelectedRange() {
		throw new UnsupportedOperationException();
	}

	public ISelectionProvider getSelectionProvider() {
		throw new UnsupportedOperationException();
	}

	public ITextOperationTarget getTextOperationTarget() {
		throw new UnsupportedOperationException();
	}

	public StyledText getTextWidget() {
		throw new UnsupportedOperationException();
	}

	public int getTopIndex() {
		throw new UnsupportedOperationException();
	}

	public int getTopIndexStartOffset() {
		throw new UnsupportedOperationException();
	}

	public int getTopInset() {
		throw new UnsupportedOperationException();
	}

	public IRegion getVisibleRegion() {
		throw new UnsupportedOperationException();
	}

	public void invalidateTextPresentation() {
		throw new UnsupportedOperationException();
	}

	public boolean isEditable() {
		throw new UnsupportedOperationException();
	}

	public boolean overlapsWithVisibleRegion(int offset, int length) {
		throw new UnsupportedOperationException();
	}

	public void removeTextInputListener(ITextInputListener listener) {
		throw new UnsupportedOperationException();
	}

	public void removeTextListener(ITextListener listener) {
		throw new UnsupportedOperationException();
	}

	public void removeViewportListener(IViewportListener listener) {
		throw new UnsupportedOperationException();
	}

	public void resetPlugins() {
		throw new UnsupportedOperationException();
	}

	public void resetVisibleRegion() {
		throw new UnsupportedOperationException();
	}

	public void revealRange(int offset, int length) {
		throw new UnsupportedOperationException();
	}

	public void setAutoIndentStrategy(IAutoIndentStrategy strategy, String contentType) {
		throw new UnsupportedOperationException();
	}

	public void setDefaultPrefixes(String[] defaultPrefixes, String contentType) {
		throw new UnsupportedOperationException();
	}

	public void setDocument(IDocument document) {
		throw new UnsupportedOperationException();
	}

	public void setDocument(IDocument document, int modelRangeOffset, int modelRangeLength) {
		throw new UnsupportedOperationException();
	}

	public void setEditable(boolean editable) {
		throw new UnsupportedOperationException();
	}

	public void setEventConsumer(IEventConsumer consumer) {
		throw new UnsupportedOperationException();
	}

	public void setIndentPrefixes(String[] indentPrefixes, String contentType) {
		throw new UnsupportedOperationException();
	}

	public void setSelectedRange(int offset, int length) {
		throw new UnsupportedOperationException();
	}

	public void setTextColor(Color color) {
		throw new UnsupportedOperationException();
	}

	public void setTextColor(Color color, int offset, int length, boolean controlRedraw) {
		throw new UnsupportedOperationException();
	}

	public void setTextDoubleClickStrategy(ITextDoubleClickStrategy strategy, String contentType) {
		throw new UnsupportedOperationException();
	}

	public void setTextHover(ITextHover textViewerHover, String contentType) {
		throw new UnsupportedOperationException();
	}

	public void setTopIndex(int index) {
		throw new UnsupportedOperationException();
	}

	public void setUndoManager(IUndoManager undoManager) {
		throw new UnsupportedOperationException();
	}

	public void setVisibleRegion(int offset, int length) {
		throw new UnsupportedOperationException();
	}

}
