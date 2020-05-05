/*******************************************************************************
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.text.BreakIterator;
import java.text.CharacterIterator;

import org.eclipse.core.runtime.Assert;

/**
 * This class was copied from <code>org.eclipse.jdt.internal.ui.text.JavaBreakIterator</code>.
 */
/*
 * @see org.eclipse.jdt.internal.ui.text.JavaBreakIterator
 */
public class CommonBreakIterator extends BreakIterator {

	/**
	 * A run of common characters.
	 */
	protected static abstract class Run {
		/** The length of this run. */
		protected int length;

		public Run() {
			init();
		}

		/**
		 * Returns <code>true</code> if this run consumes <code>ch</code>, <code>false</code> otherwise. If
		 * <code>true</code> is returned, the length of the receiver is adjusted accordingly.
		 * 
		 * @param ch
		 *            the character to test
		 * @return <code>true</code> if <code>ch</code> was consumed
		 */
		protected boolean consume(char ch) {
			if (isValid(ch)) {
				length++;
				return true;
			}
			return false;
		}

		/**
		 * Whether this run accepts that character; does not update state. Called from the default implementation of
		 * <code>consume</code>.
		 * 
		 * @param ch
		 *            the character to test
		 * @return <code>true</code> if <code>ch</code> is accepted
		 */
		protected abstract boolean isValid(char ch);

		/**
		 * Resets this run to the initial state.
		 */
		protected void init() {
			length = 0;
		}
	}

	protected static class Whitespace extends Run {
		@Override
		protected boolean isValid(char ch) {
			return Character.isWhitespace(ch) && ch != '\n' && ch != '\r';
		}
	}

	protected static class LineDelimiter extends Run {
		/** State: INIT -> delimiter -> EXIT. */
		private char fState;
		private static final char INIT = '\0';
		private static final char EXIT = '\1';

		/*
		 * @see org.eclipse.xtext.ui.editor.model.CommonBreakIterator.Run#init()
		 */
		@Override
		protected void init() {
			super.init();
			fState = INIT;
		}

		/*
		 * @see org.eclipse.xtext.ui.editor.model.CommonBreakIterator.Run#consume(char)
		 */
		@Override
		protected boolean consume(char ch) {
			if (!isValid(ch) || fState == EXIT)
				return false;

			if (fState == INIT) {
				fState = ch;
				length++;
				return true;
			} else if (fState != ch) {
				fState = EXIT;
				length++;
				return true;
			} else {
				return false;
			}
		}

		@Override
		protected boolean isValid(char ch) {
			return ch == '\n' || ch == '\r';
		}
	}

	protected static class Identifier extends Run {
		/*
		 * @see org.eclipse.xtext.ui.editor.model.CommonBreakIterator.Run#isValid(char)
		 */
		@Override
		protected boolean isValid(char ch) {
			return Character.isJavaIdentifierPart(ch);
		}
	}

	protected static class CamelCaseIdentifier extends Run {
		/* states */
		private static final int S_INIT = 0;
		private static final int S_LOWER = 1;
		private static final int S_ONE_CAP = 2;
		private static final int S_ALL_CAPS = 3;
		private static final int S_EXIT = 4;
		private static final int S_EXIT_MINUS_ONE = 5;

		/* character types */
		private static final int K_INVALID = 0;
		private static final int K_LOWER = 1;
		private static final int K_UPPER = 2;
		private static final int K_OTHER = 3;

		private int fState;

		private final static int[][] MATRIX = new int[][] {
				// K_INVALID, K_LOWER,           K_UPPER,    K_OTHER
				{ S_EXIT, S_LOWER, S_ONE_CAP, S_LOWER }, // S_INIT
				{ S_EXIT, S_LOWER, S_EXIT, S_LOWER }, // S_LOWER
				{ S_EXIT, S_LOWER, S_ALL_CAPS, S_LOWER }, // S_ONE_CAP
				{ S_EXIT, S_EXIT_MINUS_ONE, S_ALL_CAPS, S_LOWER }, // S_ALL_CAPS
		};

		/*
		 * @see org.eclipse.xtext.ui.editor.model.CommonBreakIterator.Run#init()
		 */
		@Override
		protected void init() {
			super.init();
			fState = S_INIT;
		}

		/*
		 * @see org.eclipse.xtext.ui.editor.model.CommonBreakIterator.Run#consumes(char)
		 */
		@Override
		protected boolean consume(char ch) {
			int kind = getKind(ch);
			fState = MATRIX[fState][kind];
			switch (fState) {
				case S_LOWER:
				case S_ONE_CAP:
				case S_ALL_CAPS:
					length++;
					return true;
				case S_EXIT:
					return false;
				case S_EXIT_MINUS_ONE:
					length--;
					return false;
				default:
					Assert.isTrue(false);
					return false;
			}
		}

		/**
		 * Determines the kind of a character.
		 * 
		 * @param ch
		 *            the character to test
		 */
		protected int getKind(char ch) {
			if (Character.isUpperCase(ch))
				return K_UPPER;
			if (Character.isLowerCase(ch))
				return K_LOWER;
			if (Character.isJavaIdentifierPart(ch)) // _, digits...
				return K_OTHER;
			return K_INVALID;
		}

		/*
		 * @see org.eclipse.xtext.ui.editor.model.CommonBreakIterator.Run#isValid(char)
		 */
		@Override
		protected boolean isValid(char ch) {
			return Character.isJavaIdentifierPart(ch);
		}
	}

	protected static class Other extends Run {
		/*
		 * @see org.eclipse.xtext.ui.editor.model.CommonBreakIterator.Run#isValid(char)
		 */
		@Override
		protected boolean isValid(char ch) {
			return !Character.isWhitespace(ch) && !Character.isJavaIdentifierPart(ch);
		}
	}

	/**
	 * A <code>CharSequence</code> based implementation of <code>CharacterIterator</code>.
	 * 
	 * Copied from org.eclipse.jdt.internal.ui.text.SequenceCharacterIterator.
	 * 
	 */
	/*
	 * @see org.eclipse.jdt.internal.ui.text.SequenceCharacterIterator
	 */
	protected class SequenceCharacterIterator implements CharacterIterator {

		private int fIndex = -1;
		private final CharSequence fSequence;
		private final int fFirst;
		private final int fLast;

		private void invariant() {
			Assert.isTrue(fIndex >= fFirst);
			Assert.isTrue(fIndex <= fLast);
		}

		/**
		 * Creates an iterator for the entire sequence.
		 * 
		 * @param sequence
		 *            the sequence backing this iterator
		 */
		public SequenceCharacterIterator(CharSequence sequence) {
			this(sequence, 0);
		}

		/**
		 * Creates an iterator.
		 * 
		 * @param sequence
		 *            the sequence backing this iterator
		 * @param first
		 *            the first character to consider
		 * @throws IllegalArgumentException
		 *             if the indices are out of bounds
		 */
		public SequenceCharacterIterator(CharSequence sequence, int first) throws IllegalArgumentException {
			this(sequence, first, sequence.length());
		}

		/**
		 * Creates an iterator.
		 * 
		 * @param sequence
		 *            the sequence backing this iterator
		 * @param first
		 *            the first character to consider
		 * @param last
		 *            the last character index to consider
		 * @throws IllegalArgumentException
		 *             if the indices are out of bounds
		 */
		public SequenceCharacterIterator(CharSequence sequence, int first, int last) throws IllegalArgumentException {
			if (sequence == null)
				throw new NullPointerException();
			if (first < 0 || first > last)
				throw new IllegalArgumentException();
			if (last > sequence.length())
				throw new IllegalArgumentException();
			fSequence = sequence;
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
				return fSequence.charAt(fIndex);
			else
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
	}

	protected Run whitespace;
	protected Run delimiter;
	protected Run identifier;
	protected Run other;

	/** The platform break iterator (word instance) used as a base. */
	protected final BreakIterator fIterator;
	/** The text we operate on. */
	protected CharSequence fText;
	/** our current position for the stateful methods. */
	private int fIndex;

	/**
	 * Creates a new break iterator.
	 */
	public CommonBreakIterator(boolean camelCase) {
		fIterator = BreakIterator.getWordInstance();
		fIndex = fIterator.current();
		whitespace = new Whitespace();
		delimiter = new LineDelimiter();
		if (camelCase)
			identifier = new CamelCaseIdentifier();
		else
			identifier = new Identifier();
		other = new Other();
	}

	/*
	 * @see java.text.BreakIterator#current()
	 */
	@Override
	public int current() {
		return fIndex;
	}

	/*
	 * @see java.text.BreakIterator#first()
	 */
	@Override
	public int first() {
		fIndex = fIterator.first();
		return fIndex;
	}

	/*
	 * @see java.text.BreakIterator#following(int)
	 */
	@Override
	public int following(int offset) {
		// work around too eager IAEs in standard implementation
		if (offset == getText().getEndIndex())
			return DONE;

		int next = fIterator.following(offset);
		if (next == DONE)
			return DONE;

		// TODO deal with complex script word boundaries
		// Math.min(offset + run.length, next) does not work
		// since BreakIterator.getWordInstance considers _ as boundaries
		// seems to work fine, however
		Run run = consumeRun(offset);
		return offset + run.length;

	}

	/**
	 * Consumes a run of characters at the limits of which we introduce a break.
	 * 
	 * @param offset
	 *            the offset to start at
	 * @return the run that was consumed
	 */
	protected Run consumeRun(int offset) {
		// assert offset < length

		char ch = fText.charAt(offset);
		int length = fText.length();
		Run run = getRun(ch);
		while (run.consume(ch) && offset < length - 1) {
			offset++;
			ch = fText.charAt(offset);
		}

		return run;
	}

	/**
	 * Returns a run based on a character.
	 * 
	 * @param ch
	 *            the character to test
	 * @return the correct character given <code>ch</code>
	 */
	protected Run getRun(char ch) {
		Run run;
		if (whitespace.isValid(ch))
			run = whitespace;
		else if (delimiter.isValid(ch))
			run = delimiter;
		else if (identifier.isValid(ch))
			run = identifier;
		else if (other.isValid(ch))
			run = other;
		else {
			Assert.isTrue(false);
			return null;
		}

		run.init();
		return run;
	}

	/*
	 * @see java.text.BreakIterator#getText()
	 */
	@Override
	public CharacterIterator getText() {
		return fIterator.getText();
	}

	/*
	 * @see java.text.BreakIterator#isBoundary(int)
	 */
	@Override
	public boolean isBoundary(int offset) {
		if (offset == getText().getBeginIndex())
			return true;
		else
			return following(offset - 1) == offset;
	}

	/*
	 * @see java.text.BreakIterator#last()
	 */
	@Override
	public int last() {
		fIndex = fIterator.last();
		return fIndex;
	}

	/*
	 * @see java.text.BreakIterator#next()
	 */
	@Override
	public int next() {
		fIndex = following(fIndex);
		return fIndex;
	}

	/*
	 * @see java.text.BreakIterator#next(int)
	 */
	@Override
	public int next(int n) {
		return fIterator.next(n);
	}

	/*
	 * @see java.text.BreakIterator#preceding(int)
	 */
	@Override
	public int preceding(int offset) {
		if (offset == getText().getBeginIndex())
			return DONE;

		if (isBoundary(offset - 1))
			return offset - 1;

		int previous = offset - 1;
		do {
			previous = fIterator.preceding(previous);
		} while (!isBoundary(previous));

		int last = DONE;
		while (previous < offset) {
			last = previous;
			previous = following(previous);
		}

		return last;
	}

	/*
	 * @see java.text.BreakIterator#previous()
	 */
	@Override
	public int previous() {
		fIndex = preceding(fIndex);
		return fIndex;
	}

	/*
	 * @see java.text.BreakIterator#setText(java.lang.String)
	 */
	@Override
	public void setText(String newText) {
		setText((CharSequence) newText);
	}

	/**
	 * Creates a break iterator given a char sequence.
	 * 
	 * @param newText
	 *            the new text
	 */
	public void setText(CharSequence newText) {
		fText = newText;
		fIterator.setText(new SequenceCharacterIterator(newText));
		first();
	}

	/*
	 * @see java.text.BreakIterator#setText(java.text.CharacterIterator)
	 */
	@Override
	public void setText(CharacterIterator newText) {
		if (newText instanceof CharSequence) {
			fText = (CharSequence) newText;
			fIterator.setText(newText);
			first();
		} else {
			throw new UnsupportedOperationException("CharacterIterator not supported"); //$NON-NLS-1$
		}
	}
}
