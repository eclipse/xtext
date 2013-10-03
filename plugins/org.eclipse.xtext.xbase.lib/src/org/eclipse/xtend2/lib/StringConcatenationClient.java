/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend2.lib;

/**
 * A callback object that allows to reuse an existing {@link StringConcatenation}
 * to append content to it. This puts clients into the position that they can
 * fully control the used instance, e.g. they can use a custom line delimiter
 * or override {@link StringConcatenation#getStringRepresentation(Object)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
/*
 * This is deliberately modeled as an abstract class without abstract methods
 * to allow for better interaction with overloaded methods that accept functional
 * types.
 */
public abstract class StringConcatenationClient {
	
	/**
	 * Implementors have to override this method and feed the given
	 * target instance.
	 * 
	 * @param target the {@link TargetStringConcatenation} to-append-to. Never <code>null</code>.
	 */
	protected void appendTo(TargetStringConcatenation target) {
		throw new UnsupportedOperationException("Clients have to override this.");
	}

	/**
	 * A {@link TargetStringConcatenation} models the public interface of a
	 * {@link StringConcatenation} so implementations of the {@link StringConcatenationClient}
	 * can append their content properly.
	 * 
	 * @since 2.5
	 */
	public interface TargetStringConcatenation extends CharSequence {

		/**
		 * Add a newline to this sequence according to the configured lineDelimiter if the last line contains
		 * something besides whitespace.
		 */
		void newLineIfNotEmpty();

		/**
		 * Add a newline to this sequence according to the configured lineDelimiter.
		 */
		void newLine();

		/**
		 * Add the string representation of the given object to this sequence immediately. That is, all the trailing
		 * whitespace of this sequence will be ignored and the string is appended directly after the last segment that
		 * contains something besides whitespace. The given indentation will be prepended to each line except the first one
		 * if the object has a multi-line string representation.
		 * 
		 * @param object
		 *            the to-be-appended object.
		 * @param indentation
		 *            the indentation string that should be prepended. May not be <code>null</code>.
		 */
		void appendImmediate(Object object, String indentation);

		/**
		 * Add the string representation of the given object to this sequence. The given indentation will be prepended to
		 * each line except the first one if the object has a multi-line string representation.
		 * 
		 * @param object
		 *            the appended object.
		 * @param indentation
		 *            the indentation string that should be prepended. May not be <code>null</code>.
		 */
		void append(Object object, String indentation);

		/**
		 * Append the string representation of the given object to this sequence. Does nothing if the object is
		 * <code>null</code>.
		 * 
		 * @param object
		 *            the to-be-appended object.
		 */
		void append(Object object);

	}
}
