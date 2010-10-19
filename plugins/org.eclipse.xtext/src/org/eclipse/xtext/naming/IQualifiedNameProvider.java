/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;

/**
 * Provides qualified names for EObjects.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public interface IQualifiedNameProvider extends Function<EObject, QualifiedName> {

	/**
	 * @return the qualified name for the given object, <code>null</code> if this {@link IQualifiedNameProvider} is not
	 *         responsible or if the given object doesn't have qualified name.
	 */
	QualifiedName getQualifiedName(EObject obj);

	/**
	 * Retuns the namespace delimiter. 
	 */
	String getDelimiter();

	/**
	 * Splits a string at the delimiter and returns a QualifiedName for these segments. 
	 */
	QualifiedName toValue(String qualifiedNameAsString);
	
	/**
	 * Converts a qualified name to a string by concatenating the segments with delimiters in between.
	 */
	String toString(QualifiedName qualifiedName);

	abstract class AbstractImpl implements IQualifiedNameProvider {
		public QualifiedName apply(EObject from) {
			return getQualifiedName(from);
		}
		
		public QualifiedName toValue(String qualifiedNameAsString) {
			if(Strings.isEmpty(qualifiedNameAsString))
				return null;
			if(Strings.isEmpty(getDelimiter()))
				return QualifiedName.create(qualifiedNameAsString);
			String[] segments = qualifiedNameAsString.split(Pattern.quote(getDelimiter()));
			return QualifiedName.create(segments);
		}
		
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
		
		public String getDelimiter() {
			return ".";
		}
	}
}
