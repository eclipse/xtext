/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ConflictResolver {

	@Inject
	private IJvmModelAssociations associations;
	
	public Map<String, JvmDeclaredType> resolveConflicts(TypeUsages usages, NonOverridableTypesProvider nonOverridableTypesProvider, XtendFile xtendFile) {
		String packageName = xtendFile.getPackage();
		ImportSection importSection = new ImportSection(xtendFile);
		Map<String, JvmDeclaredType> locallyDeclaredTypes = getLocallyDeclaredTypes(xtendFile);
		Map<String, JvmDeclaredType> result = newLinkedHashMap();
		Multimap<String, JvmDeclaredType> simpleName2Types = usages.getSimpleName2Types();
		for (String simpleName : simpleName2Types.keySet()) {
			Collection<JvmDeclaredType> types = simpleName2Types.get(simpleName);
			JvmDeclaredType locallyDeclaredType = locallyDeclaredTypes.get(simpleName);
			if (locallyDeclaredType != null || isConflictsWithVisibleTypes(types, usages, nonOverridableTypesProvider, simpleName)) {
				for (JvmDeclaredType type : types) {
					if (type != locallyDeclaredType)
						result.put(type.getIdentifier(), type);
				}
			} else {
				if (types.size() == 1) {
					result.put(simpleName, types.iterator().next());
				} else {
					JvmDeclaredType bestMatch = findBestMatch(types, usages, packageName, importSection);
					for (JvmDeclaredType type : types) {
						if (type == bestMatch)
							result.put(simpleName, type);
						else
							result.put(type.getIdentifier(), type);
					}
				}
			}
		}
		return result;
	}
	
	protected boolean isConflictsWithVisibleTypes(Iterable<JvmDeclaredType> types, TypeUsages usages, 
			NonOverridableTypesProvider nonOverridableTypesProvider, String simpleName) {
		for(JvmDeclaredType type: types) {
			for(TypeUsage usage: usages.getUsages(type)) {
				JvmIdentifiableElement visibleType = nonOverridableTypesProvider.getVisibleType(usage.getContext(), simpleName);
				if(visibleType != null && !visibleType.equals(type))
					return true;
			}
		}
		return false;
	}

	protected Map<String, JvmDeclaredType> getLocallyDeclaredTypes(XtendFile xtendFile) {
		Map<String, JvmDeclaredType> locallyDeclaredTypes = newHashMap();
		for (XtendTypeDeclaration xtendType : xtendFile.getXtendTypes()) {
			for (EObject inferredElement : associations.getJvmElements(xtendType)) {
				if (inferredElement instanceof JvmDeclaredType)
					locallyDeclaredTypes.put(((JvmDeclaredType) inferredElement).getSimpleName(),
							(JvmDeclaredType) inferredElement);
			}
		}
		return locallyDeclaredTypes;
	}

	protected ImportSection getImportSection(XtendFile xtendFile) {
		return new ImportSection(xtendFile);
	}

	protected JvmDeclaredType findBestMatch(Collection<JvmDeclaredType> types, TypeUsages usages, String packageName,
			ImportSection importSection) {
		Iterator<JvmDeclaredType> iterator = types.iterator();
		JvmDeclaredType currentBestMatch = iterator.next();
		while (iterator.hasNext()) {
			JvmDeclaredType nextType = iterator.next();
			if (isBetter(nextType, currentBestMatch, usages, packageName, importSection)) {
				currentBestMatch = nextType;
			}
		}
		return currentBestMatch;
	}

	protected boolean isBetter(JvmDeclaredType candidate, JvmDeclaredType currentBestMatch, TypeUsages usages, String packageName,
			ImportSection importSection) {
		if (equal(packageName,candidate.getPackageName()) && !equal(packageName, currentBestMatch.getPackageName()))
			return true;
		if (importSection.getImportedTypes().contains(candidate)
				&& !importSection.getImportedTypes().contains(currentBestMatch))
			return true;
		return size(usages.getUsages(candidate)) > size(usages.getUsages(currentBestMatch));
	}
}
