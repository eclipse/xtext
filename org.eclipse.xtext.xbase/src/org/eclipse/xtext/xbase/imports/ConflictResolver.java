/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess.UnknownNestedTypeException;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ConflictResolver {

	@Inject
	private IImportsConfiguration config;
	
	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	
	@Inject@LinkingScopeProviderBinding
	private IScopeProvider scopeProvider;
	
	@Inject
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	public Map<String, JvmDeclaredType> resolveConflicts(TypeUsages usages, NonOverridableTypesProvider nonOverridableTypesProvider, XtextResource resource) {
		RewritableImportSection importSection = importSectionFactory.parse(resource);
		Multimap<String, JvmDeclaredType> locallyDefinedTypes = getLocallyDefinedTypes(resource);
		Map<String, JvmDeclaredType> result = newLinkedHashMap();
		Multimap<String, JvmDeclaredType> simpleName2Types = usages.getSimpleName2Types();
		for (String simpleName : simpleName2Types.keySet()) {
			Collection<JvmDeclaredType> types = simpleName2Types.get(simpleName);
			Collection<JvmDeclaredType> localTypes = locallyDefinedTypes.get(simpleName);
			if(!localTypes.isEmpty() || isConflictsWithNonOverridableTypes(types, usages, nonOverridableTypesProvider, simpleName)) {
				// name conflict with local type or non-overridable type
				// if there are multiple local types with same name, none of them can be imported 
				JvmDeclaredType singleLocalType = localTypes.size() == 1 
						? localTypes.iterator().next() 
						: null; 
				for (JvmDeclaredType type : types) {
					if(type == singleLocalType || (locallyDefinedTypes.values().contains(type) && types.size()==1))
						result.put(type.getSimpleName(), type);
					else 
						result.put(type.getQualifiedName('.'), type);
				}
			}
			else if(isConflictsWithNonOverridableTypes(types, usages, nonOverridableTypesProvider, simpleName)) {
				for (JvmDeclaredType type : types) 
					result.put(type.getQualifiedName('.'), type);
			} else {
				if (types.size() == 1) {
					result.put(simpleName, types.iterator().next());
				} else {
					JvmDeclaredType bestMatch = findBestMatch(types, usages, importSection);
					for (JvmDeclaredType type : types) {
						if (type == bestMatch)
							result.put(simpleName, type);
						else
							result.put(type.getQualifiedName('.'), type);
					}
				}
			}
		}
		return result;
	}
	
	protected Multimap<String, JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource) {
		Multimap<String, JvmDeclaredType> result = LinkedHashMultimap.create();
		for(JvmDeclaredType type: config.getLocallyDefinedTypes(resource)) {
			String packageName = type.getPackageName();
			if(isEmpty(packageName)) 
				result.put(type.getQualifiedName('.'), type);
			else 
				result.put(type.getQualifiedName('.').substring(packageName.length() + 1), type);
		}
		return result;
	}
	
	protected boolean isConflictsWithNonOverridableTypes(Iterable<JvmDeclaredType> types, TypeUsages usages, 
			NonOverridableTypesProvider nonOverridableTypesProvider, String simpleName) {
		for(JvmDeclaredType type: types) {
			for(TypeUsage usage: usages.getUsages(type)) {
				JvmIdentifiableElement visibleType = nonOverridableTypesProvider.getVisibleType(usage.getContext(), simpleName);
				if(visibleType != null && !visibleType.equals(type))
					return true;
				String contextPackage = usage.getContextPackageName();
				if(!isEmpty(contextPackage)) {
					QualifiedName qualifiedName = qualifiedNameConverter.toQualifiedName(contextPackage + "." + simpleName);
					try {
						EObject indexedJvmType = indexedJvmTypeAccess.getIndexedJvmType(qualifiedName, null, usage.getContext().eResource().getResourceSet());
						if(indexedJvmType != null && indexedJvmType != type) 
							return true;
					} catch(UnknownNestedTypeException e) {
						// ignore
					}
				}
			}
		}
		return false;
	}
	
	protected JvmDeclaredType findBestMatch(Collection<JvmDeclaredType> types, TypeUsages usages,
			RewritableImportSection importSection) {
		Iterator<JvmDeclaredType> iterator = types.iterator();
		JvmDeclaredType currentBestMatch = iterator.next();
		while (iterator.hasNext()) {
			JvmDeclaredType nextType = iterator.next();
			if (isBetter(nextType, currentBestMatch, usages, importSection)) {
				currentBestMatch = nextType;
			}
		}
		return currentBestMatch;
	}

	protected boolean isBetter(JvmDeclaredType candidate, JvmDeclaredType currentBestMatch, TypeUsages usages, 
			RewritableImportSection importSection) {
		if (importSection.hasImportedType(candidate) && !importSection.hasImportedType(currentBestMatch)) {
			return true;
		}
		return size(usages.getUsages(candidate)) > size(usages.getUsages(currentBestMatch));
	}
}
