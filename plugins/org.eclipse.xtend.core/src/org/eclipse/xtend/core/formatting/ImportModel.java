/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

public class ImportModel implements IImportCollection {

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private ImplicitlyImportedTypes implicitImports;
	
	private Map<String, JvmType> types = Maps.newLinkedHashMap();
	private Set<JvmType> staticImports = newLinkedHashSet();
	private Set<JvmType> staticExtensionImports = newLinkedHashSet();
	
	private Set<String> implicitPackageImports = newLinkedHashSet();
	private JvmDeclaredType thisType = null;
	
	private Set<JvmType> knownTypesForStaticImports = null;

	private List<String> locallyDefinedTypes;
	
	
	public void setThisType(JvmDeclaredType declaredType) {
		this.thisType = declaredType;
		knownTypesForStaticImports = null;
	}

	public void setLocallyDefinedSimpleNames(List<String> simpleNames) {
		this.locallyDefinedTypes = simpleNames;
	}

	public void addImplicitlyImportedPackages(Collection<? extends String> implicitlyImportedPackage) {
		implicitPackageImports.addAll(implicitlyImportedPackage);
	}

	public List<String> getListofStaticExtensionImports() {
		List<String> result = newArrayList();
		for (JvmType type : staticExtensionImports) {
			result.add(type.getIdentifier());
		}
		Collections.sort(result);
		return result;
	}

	public List<String> getListofStaticImports() {
		List<String> result = newArrayList();
		for (JvmType type : staticImports) {
			result.add(type.getIdentifier());
		}
		// extension imports are static imports, so no need to have them twice.
		List<String> staticExtensionImports = getListofStaticExtensionImports();
		result.removeAll(staticExtensionImports);
		Collections.sort(result);
		return result;
	}

	public List<String> getListofImportedTypeNames() {
		Map<String, String> names = newLinkedHashMap();
		for (JvmType type : types.values()) {
			if (type instanceof JvmDeclaredType) {
				final JvmDeclaredType jvmGenericType = (JvmDeclaredType) type;
				if (isTypeNeedsImport(jvmGenericType))
					addType(names, jvmGenericType);
			}
		}
		final ArrayList<String> result = newArrayList(names.values());
		Collections.sort(result);
		return result;
	}

	protected boolean isTypeNeedsImport(final JvmDeclaredType jvmType) {
		final String packageName = jvmType.getPackageName();
		return !this.implicitPackageImports.contains(packageName);
	}

	protected void addType(Map<String, String> names, JvmDeclaredType type) {
		String packageName = type.getPackageName();
		final String simpleName = packageName != null ? type.getQualifiedName().substring(packageName.length() + 1)
				: type.getQualifiedName();
		if (simpleName == null)
			return;
		if (!names.containsKey(simpleName)) {
			final String identifier = type.getIdentifier();
			if (identifier == null)
				return;
			names.put(simpleName, identifier);
		}
	}

	public boolean acceptType(JvmType type) {
		if (type != null && !type.equals(this.thisType)) {
			String simpleName = type.getSimpleName();
			if (!locallyDefinedTypes.contains(simpleName) && !types.containsKey(simpleName)) {
				types.put(simpleName, type);
				return true;
			}
		}
		return false;
	}

	public void acceptStaticImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (thisType == declarator || implicitImports.getStaticImportClasses(thisType.eResource()).contains(declarator))
			return;
		if (knownTypesForStaticImports == null) {
			JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			reference.setType(thisType);
			knownTypesForStaticImports = superTypeCollector.collectSuperTypesAsRawTypes(reference);
		}
		if (knownTypesForStaticImports.contains(declarator))
			return;
		staticImports.add(declarator);
	}

	public void acceptStaticExtensionImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (implicitImports.getExtensionClasses(thisType.eResource()).contains(declarator))
			return;
		staticExtensionImports.add(declarator);
	}
}