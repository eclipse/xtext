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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;
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

	private List<XImportDeclaration> addedImportDeclarations = newArrayList();

	private Set<XImportDeclaration> removedImportDeclarations = newLinkedHashSet();

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
		addedImportDeclarations.add(importDeclaration);
		return true;
	}
	
	public boolean removeImport(JvmDeclaredType type) {
		XImportDeclaration importDeclaration = findOriginalImport(type, originalImportDeclarations, false, false);
		if(importDeclaration != null) 
			removedImportDeclarations.add(importDeclaration);
		else {
			importDeclaration = findOriginalImport(type, addedImportDeclarations, false, false);
			if(importDeclaration != null)
				addedImportDeclarations.remove(importDeclaration);
		}
		if(importDeclaration != null) {
			for(Map.Entry<String, JvmDeclaredType> entry: plainImports.entrySet()) {
				if(entry.getValue() == type) {
					plainImports.remove(entry.getKey());
					return true;
				}
			}
		}
		return false;
	}
	
	protected XImportDeclaration findOriginalImport(JvmDeclaredType type, Collection<XImportDeclaration> list,
			boolean isStatic, boolean isExtension) {
		for(XImportDeclaration importDeclaration: list) {
			if(!(isStatic ^ importDeclaration.isStatic())
					&& !(isExtension ^ importDeclaration.isExtension())
					&& importDeclaration.getImportedType()==type) 
				return importDeclaration;
		}
		return null;
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
		addedImportDeclarations.add(importDeclaration);
		return true;
	}

	public boolean removeStaticImport(JvmDeclaredType type) {
		XImportDeclaration importDeclaration = findOriginalImport(type, originalImportDeclarations, true, false);
		if(importDeclaration != null) 
			removedImportDeclarations.add(importDeclaration);
		else {
			importDeclaration = findOriginalImport(type, addedImportDeclarations, true, false);
			if(importDeclaration != null)
				addedImportDeclarations.remove(importDeclaration);
		}
		staticImports.remove(type);
		return importDeclaration != null;
	}
	

	public boolean addStaticExtensionImport(JvmDeclaredType type) {
		if (staticExtensionImports.contains(type))
			return false;
		staticExtensionImports.add(type);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		importDeclaration.setStatic(true);
		importDeclaration.setExtension(true);
		addedImportDeclarations.add(importDeclaration);
		return true;
	}

	public boolean removeStaticExtensionImport(JvmDeclaredType type) {
		XImportDeclaration importDeclaration = findOriginalImport(type, originalImportDeclarations, true, true);
		if(importDeclaration != null) 
			removedImportDeclarations.add(importDeclaration);
		else {
			importDeclaration = findOriginalImport(type, addedImportDeclarations, true, true);
			if(importDeclaration != null)
				addedImportDeclarations.remove(importDeclaration);
		}
		staticExtensionImports.remove(type);
		return importDeclaration != null;
	}

	public List<ReplaceRegion> rewrite() {
		final List<ReplaceRegion> replaceRegions = newArrayList();
		for(XImportDeclaration removedImportDeclaration: removedImportDeclarations) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(removedImportDeclaration);
			if(node != null) {
				ITextRegion textRegion = new TextRegion(node.getOffset(), node.getLength());
				if(removedImportDeclaration!=originalImportDeclarations.get(originalImportDeclarations.size()-1) 
						|| addedImportDeclarations.isEmpty()) {
					textRegion = regionUtil.addTrailingSingleWhitespace(textRegion, lineSeparator, resource);
				}
				replaceRegions.add(new ReplaceRegion(textRegion, ""));
			}
		}
		addSectionToAppend(new IAcceptor<ReplaceRegion>() {
			public void accept(ReplaceRegion t) {
				replaceRegions.add(t);
			}
		});
		return replaceRegions;
	}

	protected void addSectionToAppend(IAcceptor<ReplaceRegion> acceptor) {
		StringBuilder importDeclarationsToAppend = getImportDeclarationsToAppend();
		if(importDeclarationsToAppend.length() ==0) 
			return;
		ITextRegion region = regionUtil.computeRegion(resource);
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
		ReplaceRegion appendDeclarations = new ReplaceRegion(new TextRegion(insertOffset, insertLength), importDeclarationsToAppend.toString());
		acceptor.accept(appendDeclarations);
	}

	protected StringBuilder getImportDeclarationsToAppend() {
		StringBuilder builder = new StringBuilder();
		for (XImportDeclaration newImportDeclaration : addedImportDeclarations) {
			appendImport(builder, newImportDeclaration);
		}
		return builder;
	}

	protected void appendImport(StringBuilder builder, XImportDeclaration newImportDeclaration) {
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
}
