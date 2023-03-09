/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;

public class AttributedPosition extends Position {

	/** HighlightingStyle of the position */
	private final TextAttribute attribute;

	/** Lock object */
	private final Object fLock;

	/**
	 * Initialize the position with the given offset, length and foreground color.
	 * 
	 * @param offset
	 *            The position offset
	 * @param length
	 *            The position length
	 * @param attribute
	 *            The highlighting TextAttribute
	 * @param lock
	 *            The lock object
	 */
	public AttributedPosition(int offset, int length, TextAttribute attribute, Object lock) {
		super(offset, length);
		this.attribute = attribute;
		fLock = lock;
	}

	/**
	 * @return Returns a corresponding style range.
	 */
	public StyleRange createStyleRange() {
		int len = getLength();

		TextAttribute textAttribute = attribute;
		int style = textAttribute.getStyle();
		int fontStyle = style & (SWT.ITALIC | SWT.BOLD | SWT.NORMAL);
		StyleRange styleRange = new StyleRange(getOffset(), len, textAttribute.getForeground(),
				textAttribute.getBackground(), fontStyle);
		styleRange.strikeout = (style & TextAttribute.STRIKETHROUGH) != 0;
		styleRange.underline = (style & TextAttribute.UNDERLINE) != 0;
		styleRange.font = textAttribute.getFont();

		return styleRange;
	}

	/**
	 * Uses reference equality for the highlighting.
	 * 
	 * @param off
	 *            The offset
	 * @param len
	 *            The length
	 * @param other
	 *            The highlighting TextAttribute to compare with
	 * @return <code>true</code> if the given offset, length and highlighting are equal to the internal ones.
	 */
	public boolean isEqual(int off, int len, TextAttribute other) {
		synchronized (fLock) {
			return !isDeleted() && getOffset() == off && getLength() == len && attribute == other;
		}
	}

	/**
	 * Is this position contained in the given range (inclusive)? Synchronizes on position updater.
	 * 
	 * @param off
	 *            The range offset
	 * @param len
	 *            The range length
	 * @return <code>true</code> iff this position is not delete and contained in the given range.
	 */
	public boolean isContained(int off, int len) {
		synchronized (fLock) {
			return !isDeleted() && off <= getOffset() && off + len >= getOffset() + getLength();
		}
	}

	public void update(int off, int len) {
		synchronized (fLock) {
			super.setOffset(off);
			super.setLength(len);
		}
	}

	/*
	 * @see org.eclipse.jface.text.Position#setLength(int)
	 */
	@Override
	public void setLength(int length) {
		synchronized (fLock) {
			super.setLength(length);
		}
	}

	/*
	 * @see org.eclipse.jface.text.Position#setOffset(int)
	 */
	@Override
	public void setOffset(int offset) {
		synchronized (fLock) {
			super.setOffset(offset);
		}
	}

	/*
	 * @see org.eclipse.jface.text.Position#delete()
	 */
	@Override
	public void delete() {
		synchronized (fLock) {
			super.delete();
		}
	}

	/*
	 * @see org.eclipse.jface.text.Position#undelete()
	 */
	@Override
	public void undelete() {
		synchronized (fLock) {
			super.undelete();
		}
	}

	/**
	 * @return Returns the highlighting.
	 */
	public TextAttribute getHighlighting() {
		return attribute;
	}

}