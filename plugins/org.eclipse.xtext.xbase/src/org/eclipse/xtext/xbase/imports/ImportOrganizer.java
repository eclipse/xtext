/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.conversion.XbaseQualifiedNameValueConverter;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ImportOrganizer {

	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	
	@Inject
	private Provider<TypeUsageCollector> typeUsageCollectorProvider;
	
	@Inject 
	private ConflictResolver conflictResolver;
	
	@Inject
	private NonOverridableTypesProvider nonOverridableTypesProvider;
	
	@Inject(optional=true)
	private IUnresolvedTypeResolver unresolvedTypeResolver;
	
	@Inject
	private XbaseQualifiedNameValueConverter nameValueConverter;
	
	public List<ReplaceRegion> getOrganizedImportChanges(XtextResource resource) {
		TypeUsageCollector typeUsageCollector = typeUsageCollectorProvider.get();
		TypeUsages typeUsages = typeUsageCollector.collectTypeUsages(resource);
		if(unresolvedTypeResolver != null) 
			unresolvedTypeResolver.resolve(typeUsages, resource);
		Map<String, JvmDeclaredType> name2type = conflictResolver.resolveConflicts(typeUsages, nonOverridableTypesProvider, resource);
		return getOrganizedImportChanges(resource, name2type, typeUsages); 
	}

	private List<ReplaceRegion> getOrganizedImportChanges(XtextResource resource, Map<String, JvmDeclaredType> resolvedConflicts, TypeUsages typeUsages) {
		RewritableImportSection oldImportSection = importSectionFactory.parse(resource);
		
		RewritableImportSection newImportSection = importSectionFactory.createNewEmpty(resource);
		addImports(resolvedConflicts, typeUsages, newImportSection);
		List<ReplaceRegion> replaceRegions = getReplacedUsageSites(resolvedConflicts, typeUsages, newImportSection);
		for(JvmMember staticImport: typeUsages.getStaticImports()) {
			JvmDeclaredType declaringType = staticImport.getDeclaringType();
			if (oldImportSection.hasStaticImport(declaringType, staticImport.getSimpleName(), false)) {
				newImportSection.addStaticImport(staticImport);
			} else {
				newImportSection.addStaticImport(declaringType, null);
			}
		}
		for(JvmMember extensionImport: typeUsages.getExtensionImports()) {
			JvmDeclaredType declaringType = extensionImport.getDeclaringType();
			if (oldImportSection.hasStaticImport(declaringType, extensionImport.getSimpleName(), true)) {
				newImportSection.addStaticExtensionImport(extensionImport);
			} else {
				newImportSection.addStaticExtensionImport(declaringType, null);
			}
		}
		replaceRegions.addAll(newImportSection.rewrite());
		return replaceRegions;
	}

	private List<ReplaceRegion> getReplacedUsageSites(Map<String, JvmDeclaredType> resolvedConflicts, TypeUsages typeUsages,
			RewritableImportSection newImportSection) {
		List<ReplaceRegion> result = newArrayList();
		for(Map.Entry<String, JvmDeclaredType> textToType: resolvedConflicts.entrySet()) {
			getReplacedUsagesOf(textToType, typeUsages, newImportSection, result);
		}
		return result;
	}

	private void getReplacedUsagesOf(Map.Entry<String, JvmDeclaredType> nameToType, TypeUsages typeUsages, RewritableImportSection importSection,
			List<ReplaceRegion> result) {
		String nameToUse = nameToType.getKey();
		JvmDeclaredType type = nameToType.getValue();
		String packageLocalName = getPackageLocalName(type);
		for(TypeUsage typeUsage: typeUsages.getUsages(type)) {
			ReplaceRegion replaceRegion = getReplaceRegion(nameToUse, packageLocalName, type, typeUsage, importSection);
			if (replaceRegion != null) {
				result.add(replaceRegion);
			}
		}
	}

	@Nullable
	private ReplaceRegion getReplaceRegion(String nameToUse, String packageLocalName, JvmDeclaredType type,
			TypeUsage usage, RewritableImportSection importSection) {
		// if the resource contains two types with the same simple name, we don't add any import
		// but we can still use the package local name within the same package.
		if(equal(usage.getContextPackageName(), type.getPackageName())) {
			if(importSection.getImportedTypes(packageLocalName) == null) {
				nameToUse = packageLocalName;
			}
		}
		String textToUse = getConcreteSyntax(nameToUse, type, usage);
		return new ReplaceRegion(usage.getTextRegion(), textToUse);
	}

	private String getConcreteSyntax(String name, JvmDeclaredType importedType, TypeUsage usage) {
		JvmDeclaredType usedType = usage.getUsedType();
		if (usedType == null) {
			String typeName = usage.getUsedTypeName();
			String suffix = getSuffix(usage);
			String fullTypeName = typeName + suffix;
			return nameValueConverter.toString(fullTypeName);
		} else {
			if (usedType != importedType) {
				List<String> segments = Lists.newLinkedList();
				while(usedType != importedType) {
					segments.add(0, usedType.getSimpleName());
					usedType = usedType.getDeclaringType();
				}
				name = name + '.' + Joiner.on('.').join(segments);
			} else {
				String suffix = getSuffix(usage);
				name = name + suffix;
			}
			return nameValueConverter.toString(name);
		}
	}

	protected String getSuffix(TypeUsage usage) {
		String suffix = usage.getSuffix();
		suffix = suffix.replace('$', '.').replace("::", ".");
		return suffix;
	}
	
	private void addImports(Map<String, JvmDeclaredType> resolvedConflicts, TypeUsages typeUsages, RewritableImportSection target) {
		for(Map.Entry<String, JvmDeclaredType> entry: resolvedConflicts.entrySet()) {
			String text = entry.getKey();
			JvmDeclaredType type = entry.getValue();
			Iterable<TypeUsage> usages = typeUsages.getUsages(type);
			if(needsImport(type, text, nonOverridableTypesProvider, usages)) {
				target.addImport(type);
			}
		}
	}

	protected String getPackageLocalName(JvmDeclaredType type) {
		String packageName = type.getPackageName();
		if(isEmpty(packageName)) 
			return type.getQualifiedName('.');
		else 
			return type.getQualifiedName('.').substring(packageName.length() + 1);
	}
	
	protected boolean needsImport(JvmDeclaredType type, String name, 
			NonOverridableTypesProvider nonOverridableTypesProvider, Iterable<TypeUsage> usages)  {
		boolean nameEquals = type.getQualifiedName().equals(name) || type.getQualifiedName('.').equals(name);
		return !( nameEquals || isUsedInLocalContextOnly(type, usages, nonOverridableTypesProvider, name));
	}
	
	protected boolean isUsedInLocalContextOnly(JvmDeclaredType type, Iterable<TypeUsage> usages, 
			NonOverridableTypesProvider nonOverridableTypesProvider, String name) {
		for(TypeUsage usage: usages) {
			if(nonOverridableTypesProvider.getVisibleType(usage.getContext(), name) == null
					&& !equal(usage.getContextPackageName(), type.getPackageName())
					) 
				return false;
		}
		return true;
	}
}
