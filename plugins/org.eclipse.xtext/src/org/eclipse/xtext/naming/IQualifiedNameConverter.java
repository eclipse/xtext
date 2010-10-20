/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.regex.Pattern;

import org.eclipse.xtext.util.Strings;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IQualifiedNameConverter.DefaultImpl.class)
public interface IQualifiedNameConverter {

	String toString(QualifiedName name);

	QualifiedName toQualifiedName(String qulifiedNameAsText);

	static class DefaultImpl implements IQualifiedNameConverter {

		public String toString(QualifiedName qualifiedName) {
			if(qualifiedName == null)
				return null;
			StringBuilder builder = new StringBuilder();
			boolean isFirst = true;
			for (String segment : qualifiedName.getSegments()) {
				if (!isFirst)
					builder.append(getDelimiter());
				isFirst = false;
				builder.append(segment);
			}
			return builder.toString();
		}

		public QualifiedName toQualifiedName(String qualifiedNameAsString) {
			if(Strings.isEmpty(qualifiedNameAsString))
				return null;
			if(Strings.isEmpty(getDelimiter()))
				return QualifiedName.create(qualifiedNameAsString);
			String[] segments = qualifiedNameAsString.split(Pattern.quote(getDelimiter()));
			return QualifiedName.create(segments);
		}
		
		public String getDelimiter() {
			return ".";
		}
	}
}
