/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.List;

import org.eclipse.xtext.util.Strings;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * Converts {@link QualifiedName}s to strings and back.
 * 
 * Clients can change the namespace delimiter her by overriding
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
			if (qualifiedNameAsString == null)
				throw new IllegalArgumentException("Qualified name cannot be null");
			if (qualifiedNameAsString.equals(""))
				throw new IllegalArgumentException("Qualified name cannot be empty");
			if (Strings.isEmpty(getDelimiter()))
				return QualifiedName.create(qualifiedNameAsString);
			List<String> segs = getDelimiter().length() == 1 ? Strings.split(qualifiedNameAsString, getDelimiter()
					.charAt(0)) : Strings.split(qualifiedNameAsString, getDelimiter());
		    return QualifiedName.create(segs);
		}

		public String getDelimiter() {
			return ".";
		}
	}
}
