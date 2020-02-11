/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;

/**
 * Abstract base implementation of import normalizers that are aware of nested type references, e.g.
 * <code>import java.util.Map</code> allows to use
 * {@code Map$Entry entry} and {@code Map.Entry entry}.
 * 
 * Concrete subtypes handle imports that use the dot or the dollar sign respectively.
 * 
 * The base implementation refuses to resolve relative imports, e.g. an import
 * for the package {@code java.*} does not allow to use the type {@code util.Map}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractNestedTypeAwareImportNormalizer extends ImportNormalizer {

	public static ImportNormalizer createNestedTypeAwareImportNormalizer(QualifiedName importedNamespace, boolean wildcard,
			boolean ignoreCase) {
		for(int i = 0; i < importedNamespace.getSegmentCount(); i++) {
			if (importedNamespace.getSegment(i).indexOf('$') >= 0) {
				return new NestedTypeAwareImportNormalizer(importedNamespace, wildcard, ignoreCase);
			}
		}
		return new NestedTypeAwareImportNormalizerWithDotSeparator(importedNamespace, wildcard, ignoreCase);
	}
	
	protected AbstractNestedTypeAwareImportNormalizer(QualifiedName importedNamespace, boolean wildCard, boolean ignoreCase) {
		super(importedNamespace, wildCard, ignoreCase);
		if (ignoreCase)
			throw new IllegalArgumentException("ignoreCase is currently not supported");
	}
	
	@Override
	public QualifiedName resolve(QualifiedName relativeName) {
		if (hasWildCard()) {
			return resolveWildcard(relativeName);
		} else {
			return resolveNonWildcard(relativeName);
		}
	}

	protected QualifiedName resolveWildcard(QualifiedName relativeName) {
		int segmentCount = relativeName.getSegmentCount();
		if (segmentCount == 1) {
			return getImportedNamespacePrefix().append(relativeName);	
		}
		for(int i = 0; i < segmentCount; i++) {
			if (relativeName.getSegment(i).indexOf('$') != -1) {
				return null;
			}
		}
		return getImportedNamespacePrefix().append(relativeName.toString("$"));
	}

	protected abstract QualifiedName resolveNonWildcard(QualifiedName relativeName);

}
