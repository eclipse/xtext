/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * Import normalizer that is aware of nested type references, e.g.
 * <code>import java.util.Map</code> allows to use
 * {@code Map$Entry entry} and {@code Map.Entry entry}.
 * 
 * This import normalizer handles imports that use the dollar ({@code '.'}) sign
 * as the separator for nested types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeAwareImportNormalizerWithDotSeparator extends AbstractNestedTypeAwareImportNormalizer {
	
	public NestedTypeAwareImportNormalizerWithDotSeparator(QualifiedName importedNamespace, boolean wildcard, boolean ignoreCase) {
		super(importedNamespace, wildcard, ignoreCase);
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
				return QualifiedName.create(fullyQualifiedName.getLastSegment());
			}
			if (fullyQualifiedName.startsWith(getImportedNamespacePrefix())) {
				return fullyQualifiedName.skipFirst(getImportedNamespacePrefix().getSegmentCount() - 1);
			}
			int segmentCount = fullyQualifiedName.getSegmentCount();
			List<String> segments = Lists.newArrayListWithExpectedSize(segmentCount);
			for(int i = 0; i < segmentCount; i++) {
				String segment = fullyQualifiedName.getSegment(i);
				segments.addAll(Strings.split(segment, '$'));
			}
			if (segments.size() > segmentCount) {
				QualifiedName withoutDollars = QualifiedName.create(segments);
				if (withoutDollars.startsWith(getImportedNamespacePrefix())) {
					return withoutDollars.skipFirst(getImportedNamespacePrefix().getSegmentCount() - 1);
				}
			}
		}
		return null;
	}

	@Override
	protected QualifiedName resolveNonWildcard(QualifiedName relativeName) {
		if (relativeName.getSegmentCount()==1) {
			List<String> split = Strings.split(relativeName.getFirstSegment(), '$');
			if (split.size() == 0) {
				// relativeName may be just something like '$'
				return internalResolve(relativeName);
			}
			return internalResolve(QualifiedName.create(split));
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
			return internalResolve(relativeName);
		}
	}
	
	protected QualifiedName internalResolve(QualifiedName relativeName) {
		QualifiedName importedNamespace = getImportedNamespacePrefix();
		if (importedNamespace.getLastSegment().equals(relativeName.getFirstSegment())) {
			return importedNamespace.skipLast(1).append(relativeName);
		}
		return null;
	}
}
