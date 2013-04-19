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

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.conversion.StaticQualifierValueConverter;
import org.eclipse.xtext.xbase.conversion.XbaseQualifiedNameValueConverter;

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
	private StaticQualifierValueConverter staticQualifierConverter;
	
	@Inject
	private XbaseQualifiedNameValueConverter nameValueConverter;
	
	public List<ReplaceRegion> getOrganizedImportChanges(XtextResource resource) {
		TypeUsageCollector typeUsageCollector = typeUsageCollectorProvider.get();
		TypeUsages typeUsages = typeUsageCollector.collectTypeUsages(resource);
		if(unresolvedTypeResolver != null) 
			unresolvedTypeResolver.resolve(typeUsages, resource);
		Map<String, JvmDeclaredType> name2type = conflictResolver.resolveConflicts(typeUsages, nonOverridableTypesProvider, resource);
		RewritableImportSection newImportSection = importSectionFactory.createNewEmpty(resource);
		List<ReplaceRegion> replaceRegions = newArrayList();
		for(Map.Entry<String, JvmDeclaredType> entry: name2type.entrySet()) {
			String text = entry.getKey();
			JvmDeclaredType type = entry.getValue();
			Iterable<TypeUsage> usages = typeUsages.getUsages(type);
			if(needsImport(type, text, nonOverridableTypesProvider, usages)) {
				newImportSection.addImport(type);
			}
		}
		for(Map.Entry<String, JvmDeclaredType> entry: name2type.entrySet()) {
			String text = entry.getKey();
			JvmDeclaredType type = entry.getValue();
			String packageLocalName = getPackageLocalName(type);
			Iterable<TypeUsage> usages = typeUsages.getUsages(type);
			for(TypeUsage usage: usages) {
				// if the resource contains two types with the same simple name, we don't add any import
				// but we can still use the package local name within the same package.
				if(equal(usage.getContextPackageName(), type.getPackageName())) {
					JvmDeclaredType importedType = newImportSection.getImportedType(packageLocalName);
					if(importedType == null)
						text = packageLocalName;
				}
				if (usage.isStaticAccess()) {
					if (usage.isTrailingDelimiterSuppressed()) {
						text = staticQualifierConverter.toStringWithoutNamespaceDelimiter(text);
					} else {
						text = staticQualifierConverter.toString(text);
					}
				} else {
					text = nameValueConverter.toString(text);
				}
				if(!equal(usage.getText(), text)) {
					replaceRegions.add(new ReplaceRegion(usage.getTextRegion(), text));
				}
			}
		}
		for(JvmDeclaredType staticImport: typeUsages.getStaticImports()) 
			newImportSection.addStaticImport(staticImport);
		for(JvmDeclaredType extensionImport: typeUsages.getExtensionImports()) 
			newImportSection.addStaticExtensionImport(extensionImport);
		replaceRegions.addAll(newImportSection.rewrite());
		return replaceRegions; 
	}

	protected String getPackageLocalName(JvmDeclaredType type) {
		String packageName = type.getPackageName();
		if(isEmpty(packageName)) 
			return type.getIdentifier();
		else 
			return type.getIdentifier().substring(packageName.length() + 1);
	}
	
	protected boolean needsImport(JvmDeclaredType type, String name, 
			NonOverridableTypesProvider nonOverridableTypesProvider, Iterable<TypeUsage> usages)  {
		return !((type.getIdentifier().equals(name))
			|| isUsedInLocalContextOnly(type, usages, nonOverridableTypesProvider, name));
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
