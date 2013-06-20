/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeUsages {

	private Multimap<String, JvmDeclaredType> simpleName2types = LinkedHashMultimap.create();
	private Multimap<JvmDeclaredType, TypeUsage> types2usages = LinkedHashMultimap.create();
	
	private List<JvmDeclaredType> staticImports = newArrayList();
	private List<JvmDeclaredType> extensionImports = newArrayList();
	
	private List<TypeUsage> unresolvedTypes = newArrayList();
	
	public void addTypeUsage(
			JvmDeclaredType typeToImport,
			JvmDeclaredType usedType,
			ITextRegion textRegion,
			JvmMember context) {
		simpleName2types.put(typeToImport.getSimpleName(), typeToImport);
		types2usages.put(typeToImport, new TypeUsage(usedType, textRegion, context));
	}
	
	public void addTypeUsage(
			JvmDeclaredType typeToImport,
			String suffix,
			ITextRegion textRegion,
			JvmMember context) {
		simpleName2types.put(typeToImport.getSimpleName(), typeToImport);
		types2usages.put(typeToImport, new TypeUsage(typeToImport, suffix, textRegion, context));
	}
	
	public void addUnresolved(String unresolvedTypeName, String suffix, ITextRegion textRegion, JvmMember context) {
		unresolvedTypes.add(new TypeUsage(unresolvedTypeName, suffix, textRegion, context));
	}
	
	public Multimap<String, JvmDeclaredType> getSimpleName2Types() {
		return simpleName2types;
	}
	
	public Iterable<TypeUsage> getUsages(JvmDeclaredType type) {
		return types2usages.get(type);
	}

	public List<TypeUsage> getUnresolvedTypeUsages() {
		return unresolvedTypes;
	}
	
	public void addStaticImport(JvmDeclaredType declarator) {
		staticImports.add(declarator);
	}

	public void addExtensionImport(JvmDeclaredType declarator) {
		extensionImports.add(declarator);
	}
	
	public List<JvmDeclaredType> getStaticImports() {
		return staticImports;
	}
	
	public List<JvmDeclaredType> getExtensionImports() {
		return extensionImports;
	}
}
