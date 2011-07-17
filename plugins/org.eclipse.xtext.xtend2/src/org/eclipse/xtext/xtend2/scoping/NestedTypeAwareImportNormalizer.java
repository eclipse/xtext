/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;

/**
 * Import normalizer that is aware of nested type references, e.g.
 * <code>import java.util.Map</code> allows to use
 * <code>Map$Entry entry</code>.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeAwareImportNormalizer extends ImportNormalizer {

	private final QualifiedName importedNamespacePrefix;
	private final boolean wildCard;

	public NestedTypeAwareImportNormalizer(QualifiedName importedNamespace, boolean wildCard, boolean ignoreCase) {
		super(importedNamespace, wildCard, ignoreCase);
		if (ignoreCase)
			throw new IllegalArgumentException("ignoreCase is currently not supported");
		this.importedNamespacePrefix = importedNamespace;
		this.wildCard = wildCard;
	}
	
	@Override
	public QualifiedName deresolve(QualifiedName fullyQualifiedName) {
		if (wildCard) {
			if (fullyQualifiedName.startsWith(importedNamespacePrefix) 
					&& fullyQualifiedName.getSegmentCount() != importedNamespacePrefix.getSegmentCount()) {
				return fullyQualifiedName.skipFirst(importedNamespacePrefix.getSegmentCount());
			}
		} else {
			if (fullyQualifiedName.equals(importedNamespacePrefix)) {
				String lastSegment = fullyQualifiedName.getLastSegment();
				int dollar = lastSegment.lastIndexOf('$');
				if (dollar >= 0) {
					return QualifiedName.create(lastSegment.substring(dollar + 1));
				}
				return QualifiedName.create(fullyQualifiedName.getLastSegment());
			}
			if (fullyQualifiedName.skipLast(1).equals(importedNamespacePrefix.skipLast(1))) {
				String lastImportedSegment = importedNamespacePrefix.getLastSegment();
				String lastSegment = fullyQualifiedName.getLastSegment();
				if (lastSegment.startsWith(lastImportedSegment) && lastSegment.charAt(lastImportedSegment.length()) == '$') {
					int dollar = lastImportedSegment.lastIndexOf('$');
					if (dollar == -1) {
						return fullyQualifiedName.skipFirst(importedNamespacePrefix.getSegmentCount() - 1);
					} else {
						return QualifiedName.create(lastSegment.substring(dollar +1));
					}
				}
			}
		}
		return null;
	}

	@Override
	public QualifiedName resolve(QualifiedName relativeName) {
		if (wildCard) {
			return importedNamespacePrefix.append(relativeName);
		} else {
			if (relativeName.getSegmentCount()==1) {
				if (relativeName.getLastSegment().equals(importedNamespacePrefix.getLastSegment())) {
					return importedNamespacePrefix;
				}
				String relativeNameAsString = relativeName.getLastSegment();
				String lastImportedSegment = importedNamespacePrefix.getLastSegment();
				int dollar = relativeNameAsString.indexOf('$');
				if (dollar >= 0) {
					if (dollar == lastImportedSegment.length() && relativeNameAsString.startsWith(lastImportedSegment))
						return importedNamespacePrefix.skipLast(1).append(relativeNameAsString);
				}
				int importedDollar = lastImportedSegment.lastIndexOf('$');
				if (importedDollar >= 0) {
					String nestedTypeName = lastImportedSegment.substring(importedDollar + 1);
					if (relativeNameAsString.startsWith(nestedTypeName)) {
						if (nestedTypeName.length() == relativeNameAsString.length())
							return importedNamespacePrefix;
						if (relativeNameAsString.charAt(nestedTypeName.length()) == '$')
							return importedNamespacePrefix.skipLast(1).append(
									lastImportedSegment + relativeNameAsString.substring(nestedTypeName.length())); 
					}
					
				}
			}
		}
		return null;
	}
}