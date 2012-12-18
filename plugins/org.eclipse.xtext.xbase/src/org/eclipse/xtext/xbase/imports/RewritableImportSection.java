/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RewritableImportSection {

	public static class Factory {
		@Inject
		private IImportsConfiguration importsConfiguration;

		@Inject
		private IWhitespaceInformationProvider whitespaceInformationProvider;

		@Inject
		private ImportSectionRegionUtil regionUtil;
		
		public RewritableImportSection create(XtextResource resource) {
			RewritableImportSection reWritableImportSection = new RewritableImportSection(resource,
					importsConfiguration, whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI())
							.getLineSeparator(), regionUtil);
			return reWritableImportSection;
		}
	}

	private List<XImportDeclaration> originalImportDeclarations = newArrayList();

	private List<XImportDeclaration> newImportDeclarations = newArrayList();

	private Map<String, JvmDeclaredType> plainImports = newHashMap();

	private Set<JvmDeclaredType> staticImports = newHashSet();

	private Set<JvmDeclaredType> staticExtensionImports = newHashSet();

	private String lineSeparator;

	private XtextResource resource;
	
	private ImportSectionRegionUtil regionUtil;

	public RewritableImportSection(XtextResource resource, IImportsConfiguration importsConfiguration,
				String lineSeparator, ImportSectionRegionUtil regionUtil) {
		this.lineSeparator = lineSeparator;
		this.resource = resource;
		this.regionUtil = regionUtil;
		XImportSection originalImportSection = importsConfiguration.getImportSection(resource);
		if (originalImportSection != null) {
			for (XImportDeclaration originalImportDeclaration : originalImportSection.getImportDeclarations()) {
				this.originalImportDeclarations.add(originalImportDeclaration);
				if (originalImportDeclaration.isStatic()) {
					if (originalImportDeclaration.isExtension())
						staticExtensionImports.add(originalImportDeclaration.getImportedType());
					else
						staticImports.add(originalImportDeclaration.getImportedType());
				} else {
					plainImports.put(originalImportDeclaration.getImportedType().getSimpleName(),
							originalImportDeclaration.getImportedType());
				}
			}
		}
	}

	public boolean addImport(JvmDeclaredType type) {
		if (plainImports.containsKey(type.getSimpleName()))
			return false;
		plainImports.put(type.getSimpleName(), type);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		newImportDeclarations.add(importDeclaration);
		return true;
	}
	
	public JvmDeclaredType getType(String simpleName) {
		return plainImports.get(simpleName);
	}

	public boolean addStaticImport(JvmDeclaredType type) {
		if (staticImports.contains(type))
			return false;
		staticImports.add(type);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		importDeclaration.setStatic(true);
		newImportDeclarations.add(importDeclaration);
		return true;
	}

	public boolean addStaticExtensionImport(JvmDeclaredType type) {
		if (staticExtensionImports.contains(type))
			return false;
		staticExtensionImports.add(type);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		importDeclaration.setStatic(true);
		importDeclaration.setExtension(true);
		newImportDeclarations.add(importDeclaration);
		return true;
	}

	public List<ReplaceRegion> rewrite() {
		StringBuilder importDeclarationsToAppend = getImportDeclarationsToAppend();
		TextRegion region = regionUtil.computeRegion(resource);
		region = regionUtil.addLeadingWhitespace(region, resource);
		int insertOffset = region.getOffset() + region.getLength();
		if(insertOffset != 0) {
			importDeclarationsToAppend.insert(0, lineSeparator);
			if(originalImportDeclarations.isEmpty()) 
				importDeclarationsToAppend.insert(0, lineSeparator);
		}
		importDeclarationsToAppend.append(lineSeparator);
		int insertLength = -region.getLength();
		insertLength += regionUtil.addTrailingWhitespace(region, resource).getLength();
		return singletonList(new ReplaceRegion(new TextRegion(insertOffset, insertLength), importDeclarationsToAppend.toString()));
	}

	protected StringBuilder getImportDeclarationsToAppend() {
		StringBuilder builder = new StringBuilder();
		for (XImportDeclaration newImportDeclaration : newImportDeclarations) {
			builder.append("import ");
			if (newImportDeclaration.isStatic()) {
				builder.append("static ");
				if (newImportDeclaration.isExtension()) {
					builder.append("extension ");
				}
			}
			builder.append(newImportDeclaration.getImportedTypeName());
			if (newImportDeclaration.isStatic())
				builder.append(".*");
			builder.append(lineSeparator);
		}
		return builder;
	}
}
