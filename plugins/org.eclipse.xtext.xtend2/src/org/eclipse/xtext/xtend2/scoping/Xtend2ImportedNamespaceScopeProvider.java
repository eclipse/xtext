/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Improved support for nested types in connection with imports
 */
public class Xtend2ImportedNamespaceScopeProvider extends XbaseImportedNamespaceScopeProvider {

	@Inject
	private IQualifiedNameConverter nameConverter;
	
	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		if (!(context instanceof XtendFile))
			return Collections.emptyList();
		List<ImportNormalizer> importedNamespaceResolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		if (context instanceof XtendFile && !Strings.isEmpty(((XtendFile) context).getPackage())) {
			importedNamespaceResolvers.add(new ImportNormalizer(nameConverter.toQualifiedName(((XtendFile) context)
					.getPackage()), true, ignoreCase));
		}
		return importedNamespaceResolvers;
	}
	
	@Override
	protected ImportNormalizer createImportedNamespaceResolver(String namespace, boolean ignoreCase) {
		if (Strings.isEmpty(namespace))
			return null;
		QualifiedName importedNamespace = nameConverter.toQualifiedName(namespace);
		if (importedNamespace == null || importedNamespace.getSegmentCount() < 1) {
			return null;
		}
		boolean hasWildCard = ignoreCase ? 
				importedNamespace.getLastSegment().equalsIgnoreCase(getWildCard()) :
				importedNamespace.getLastSegment().equals(getWildCard());
		if (hasWildCard) {
			if (importedNamespace.getSegmentCount() <= 1)
				return null;
			return doCreateImportNormalizer(importedNamespace.skipLast(1), true, ignoreCase);
		} else {
			return doCreateImportNormalizer(importedNamespace, false, ignoreCase);
		}
	}

	protected ImportNormalizer doCreateImportNormalizer(QualifiedName importedNamespace, boolean wildcard,
			boolean ignoreCase) {
		return new NestedTypeAwareImportNormalizer(importedNamespace, wildcard, ignoreCase);
	}
	
	@Override
	protected IScope getLocalElementsScope(IScope parent, final EObject context,
			final EReference reference) {
		IScope result = parent;
		ISelectable allDescriptions = getAllDescriptions(context.eResource());
		QualifiedName name = getQualifiedNameOfLocalElement(context);
		boolean ignoreCase = isIgnoreCase(reference);
		final List<ImportNormalizer> namespaceResolvers = getImportedNamespaceResolvers(context, ignoreCase);
		if (!namespaceResolvers.isEmpty()) {
			if (isRelativeImport() && name!=null) {
				ImportNormalizer localNormalizer = doCreateImportNormalizer(name, true, ignoreCase); 
				result = createImportScope(result, singletonList(localNormalizer), allDescriptions, reference.getEReferenceType(), isIgnoreCase(reference));
			}
			result = createImportScope(result, namespaceResolvers, null, reference.getEReferenceType(), isIgnoreCase(reference));
		}
		if (name!=null) {
			ImportNormalizer localNormalizer = doCreateImportNormalizer(name, true, ignoreCase); 
			result = createImportScope(result, singletonList(localNormalizer), allDescriptions, reference.getEReferenceType(), isIgnoreCase(reference));
		}
		return result;
	}
	
	@Override
	protected boolean isRelativeImport() {
		return false;
	}
}
