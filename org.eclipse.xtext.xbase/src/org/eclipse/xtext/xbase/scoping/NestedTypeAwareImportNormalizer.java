/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.xtext.naming.QualifiedName;

/**
 * Import normalizer that is aware of nested type references, e.g.
 * <code>import java.util.Map</code> allows to use
 * {@code Map$Entry entry} and {@code Map.Entry entry}.
 * 
 * This import normalizer handles imports that use the dollar ({@code '$'}) sign
 * as the separator for nested types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeAwareImportNormalizer extends AbstractNestedTypeAwareImportNormalizer {

	protected final boolean allowWildcard;

	public NestedTypeAwareImportNormalizer(QualifiedName importedNamespace, boolean wildcard, boolean ignoreCase) {
		super(importedNamespace, wildcard, ignoreCase);
		allowWildcard = importedNamespaceHasDollar();
	}
	
	protected boolean importedNamespaceHasDollar() {
		if (!hasWildCard()) // don't care
			return true;
		QualifiedName importedNamespace = getImportedNamespacePrefix();
		int segmentCount = importedNamespace.getSegmentCount();
		for(int i = 0; i < segmentCount; i++) {
			if (importedNamespace.getSegment(i).indexOf('$') != -1) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public QualifiedName deresolve(QualifiedName fullyQualifiedName) {
		if (hasWildCard()) {
			if (fullyQualifiedName.startsWith(getImportedNamespacePrefix()) 
					&& fullyQualifiedName.getSegmentCount() != getImportedNamespacePrefix().getSegmentCount()) {
				return fullyQualifiedName.skipFirst(getImportedNamespacePrefix().getSegmentCount());
			}
		} else {
			if (fullyQualifiedName.equals(getImportedNamespacePrefix())) {
				String lastSegment = fullyQualifiedName.getLastSegment();
				int dollar = lastSegment.lastIndexOf('$');
				if (dollar >= 0) {
					return QualifiedName.create(lastSegment.substring(dollar + 1));
				}
				return QualifiedName.create(fullyQualifiedName.getLastSegment());
			}
			if (fullyQualifiedName.skipLast(1).equals(getImportedNamespacePrefix().skipLast(1))) {
				String lastImportedSegment = getImportedNamespacePrefix().getLastSegment();
				String lastSegment = fullyQualifiedName.getLastSegment();
				if (lastSegment.startsWith(lastImportedSegment) && lastSegment.charAt(lastImportedSegment.length()) == '$') {
					int dollar = lastImportedSegment.lastIndexOf('$');
					if (dollar == -1) {
						return fullyQualifiedName.skipFirst(getImportedNamespacePrefix().getSegmentCount() - 1);
					} else {
						return QualifiedName.create(lastSegment.substring(dollar +1));
					}
				}
			}
		}
		return null;
	}
	
	@Override
	protected QualifiedName resolveWildcard(QualifiedName relativeName) {
		if (!allowWildcard)
			return null;
		return super.resolveWildcard(relativeName);
	}
	
	@Override
	protected QualifiedName resolveNonWildcard(QualifiedName relativeName) {
		if (relativeName.getSegmentCount()==1) {
			// legacy import support, e.g. import java.util.Map$Entry allows to use Map$Entry as the simple name
			if (getImportedNamespacePrefix().getLastSegment().equals(relativeName.getFirstSegment())) {
				return getImportedNamespacePrefix();
			}
			return internalResolve(relativeName);
		} else {
			StringBuilder concatenated = new StringBuilder();
			for(int i = 0; i < relativeName.getSegmentCount(); i++) {
				String segment = relativeName.getSegment(i);
				if (segment.indexOf('$') == -1) {
					if (concatenated.length() != 0) {
						concatenated.append('$');
					}
					concatenated.append(segment);
				} else {
					return null;
				}
			}
			return internalResolve(QualifiedName.create(concatenated.toString()));
		}
	}

	private QualifiedName internalResolve(QualifiedName relativeName) {
		if (relativeName.getSegmentCount() != 1) {
			throw new IllegalArgumentException(relativeName.toString());
		}
		String lastImportSegment = getImportedNamespacePrefix().getLastSegment();
		int importDollarIndex = lastImportSegment.lastIndexOf('$');
		if (importDollarIndex != -1) {
			lastImportSegment = lastImportSegment.substring(importDollarIndex + 1);
		}
		String singleSegment = relativeName.getFirstSegment();
		if (lastImportSegment.equals(singleSegment)) {
			return getImportedNamespacePrefix();
		}
		if (singleSegment.startsWith(lastImportSegment) && singleSegment.charAt(lastImportSegment.length()) == '$') {
			if (importDollarIndex == -1)
				return getImportedNamespacePrefix().skipLast(1).append(relativeName);
			else {
				String resolvedLastSegment = getImportedNamespacePrefix().getLastSegment() + singleSegment.substring(lastImportSegment.length());
				return getImportedNamespacePrefix().skipLast(1).append(resolvedLastSegment);
			}
		}
		return null;
	}
}