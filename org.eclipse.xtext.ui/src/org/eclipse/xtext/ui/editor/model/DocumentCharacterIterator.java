/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.text.CharacterIterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

/**
 * Copied from <code>org.eclipse.jdt.internal.ui.text.DocumentCharacterIterator</code>.
 */
/*
 * @see org.eclipse.jdt.internal.ui.text.DocumentCharacterIterator
 */
public class DocumentCharacterIterator implements CharacterIterator, CharSequence {

	private int fIndex = -1;
	private final IDocument fDocument;
	private final int fFirst;
	private final int fLast;

	private void invariant() {
		Assert.isTrue(fIndex >= fFirst);
		Assert.isTrue(fIndex <= fLast);
	}

	/**
	 * Creates an iterator for the entire document.
	 * 
	 * @param document
	 *            the document backing this iterator
	 * @throws BadLocationException
	 *             if the indices are out of bounds
	 */
	public DocumentCharacterIterator(IDocument document) throws BadLocationException {
		this(document, 0);
	}

	/**
	 * Creates an iterator, starting at offset <code>first</code>.
	 * 
	 * @param document
	 *            the document backing this iterator
	 * @param first
	 *            the first character to consider
	 * @throws BadLocationException
	 *             if the indices are out of bounds
	 */
	public DocumentCharacterIterator(IDocument document, int first) throws BadLocationException {
		this(document, first, document.getLength());
	}

	/**
	 * Creates an iterator for the document contents from <code>first</code> (inclusive) to <code>last</code>
	 * (exclusive).
	 * 
	 * @param document
	 *            the document backing this iterator
	 * @param first
	 *            the first character to consider
	 * @param last
	 *            the last character index to consider
	 * @throws BadLocationException
	 *             if the indices are out of bounds
	 */
	public DocumentCharacterIterator(IDocument document, int first, int last) throws BadLocationException {
		if (document == null)
			throw new NullPointerException();
		if (first < 0 || first > last)
			throw new BadLocationException();
		if (last > document.getLength()) {
			throw new BadLocationException();
		}
		fDocument = document;
		fFirst = first;
		fLast = last;
		fIndex = first;
		invariant();
	}

	/*
	 * @see java.text.CharacterIterator#first()
	 */
	@Override
	public char first() {
		return setIndex(getBeginIndex());
	}

	/*
	 * @see java.text.CharacterIterator#last()
	 */
	@Override
	public char last() {
		if (fFirst == fLast)
			return setIndex(getEndIndex());
		else
			return setIndex(getEndIndex() - 1);
	}

	/*
	 * @see java.text.CharacterIterator#current()
	 */
	@Override
	public char current() {
		if (fIndex >= fFirst && fIndex < fLast)
			try {
				return fDocument.getChar(fIndex);
			} catch (BadLocationException e) {
				// ignore
			}
		return DONE;
	}

	/*
	 * @see java.text.CharacterIterator#next()
	 */
	@Override
	public char next() {
		return setIndex(Math.min(fIndex + 1, getEndIndex()));
	}

	/*
	 * @see java.text.CharacterIterator#previous()
	 */
	@Override
	public char previous() {
		if (fIndex > getBeginIndex()) {
			return setIndex(fIndex - 1);
		} else {
			return DONE;
		}
	}

	/*
	 * @see java.text.CharacterIterator#setIndex(int)
	 */
	@Override
	public char setIndex(int position) {
		if (position >= getBeginIndex() && position <= getEndIndex())
			fIndex = position;
		else
			throw new IllegalArgumentException();

		invariant();
		return current();
	}

	/*
	 * @see java.text.CharacterIterator#getBeginIndex()
	 */
	@Override
	public int getBeginIndex() {
		return fFirst;
	}

	/*
	 * @see java.text.CharacterIterator#getEndIndex()
	 */
	@Override
	public int getEndIndex() {
		return fLast;
	}

	/*
	 * @see java.text.CharacterIterator#getIndex()
	 */
	@Override
	public int getIndex() {
		return fIndex;
	}

	/*
	 * @see java.text.CharacterIterator#clone()
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	/*
	 * @see java.lang.CharSequence#length()
	 */
	@Override
	public int length() {
		return getEndIndex() - getBeginIndex();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Note that, if the document is modified concurrently, this method may return {@link CharacterIterator#DONE} if a
	 * {@link BadLocationException} was thrown when accessing the backing document.
	 * </p>
	 * 
	 * @param index
	 *            {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public char charAt(int index) {
		if (index >= 0 && index < length())
			try {
				return fDocument.getChar(getBeginIndex() + index);
			} catch (BadLocationException e) {
				// ignore and return DONE
				return DONE;
			}
		else
			throw new IndexOutOfBoundsException();
	}

	/*
	 * @see java.lang.CharSequence#subSequence(int, int)
	 */
	@Override
	public CharSequence subSequence(int start, int end) {
		if (start < 0)
			throw new IndexOutOfBoundsException();
		if (end < start)
			throw new IndexOutOfBoundsException();
		if (end > length())
			throw new IndexOutOfBoundsException();
		try {
			return new DocumentCharacterIterator(fDocument, getBeginIndex() + start, getBeginIndex() + end);
		} catch (BadLocationException ex) {
			throw new IndexOutOfBoundsException();
		}
	}
}
