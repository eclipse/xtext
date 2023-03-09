/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.List;

import org.eclipse.xtext.util.Strings;

import com.google.common.base.Preconditions;
import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * Converts {@link QualifiedName}s to strings and back.
 * 
 * Clients can change the namespace delimiter here by overriding
 * {@link IQualifiedNameConverter.DefaultImpl#getDelimiter()}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IQualifiedNameConverter.DefaultImpl.class)
public interface IQualifiedNameConverter {

	String toString(QualifiedName name);

	QualifiedName toQualifiedName(String qualifiedNameAsText);

	@Singleton
	static class DefaultImpl implements IQualifiedNameConverter {

		/**
		 * Converts the given qualified name to a string.
		 * 
		 * @exception IllegalArgumentException
		 *                when the qualified name is null.
		 */
		@Override
		public String toString(QualifiedName qualifiedName) {
			if (qualifiedName == null)
				throw new IllegalArgumentException("Qualified name cannot be null");
			return qualifiedName.toString(getDelimiter());
		}

		/**
		 * Splits the given string into segments and returns them as a {@link QualifiedName}.
		 * 
		 * @exception IllegalArgumentException
		 *                if the input is empty or null.
		 */
		@Override
		public QualifiedName toQualifiedName(String qualifiedNameAsString) {
			Preconditions.checkArgument(qualifiedNameAsString != null, "Qualified name cannot be null");
			Preconditions.checkArgument(!qualifiedNameAsString.isEmpty(), "Qualified name cannot be empty");
			String delimiter = getDelimiter();
			if (Strings.isEmpty(delimiter))
				return QualifiedName.create(qualifiedNameAsString);
			List<String> segs = delimiter.length() == 1
					? Strings.split(qualifiedNameAsString, delimiter.charAt(0))
					: Strings.split(qualifiedNameAsString, delimiter);
			return QualifiedName.create(segs);
		}

		public String getDelimiter() {
			return ".";
		}
	}
}
