/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.conversion.XbaseQualifiedNameValueConverter;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Model of an import section that can be changed. 
 * 
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
		
		@Inject 
		private XbaseQualifiedNameValueConverter nameValueConverter;
		
		public RewritableImportSection parse(XtextResource resource) {
			RewritableImportSection rewritableImportSection = new RewritableImportSection(
					resource,
					importsConfiguration,
					importsConfiguration.getImportSection(resource), 
					whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI()).getLineSeparator(), 
					regionUtil, 
					nameValueConverter);
			return rewritableImportSection;
		}

		public RewritableImportSection createNewEmpty(XtextResource resource) {
			RewritableImportSection rewritableImportSection = new RewritableImportSection(
					resource,
					importsConfiguration,
					null,
					whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI()).getLineSeparator(), 
					regionUtil,
					nameValueConverter);
			rewritableImportSection.setSort(true);
			return rewritableImportSection;
		}
	}

	private List<XImportDeclaration> originalImportDeclarations = newArrayList();

	private List<XImportDeclaration> addedImportDeclarations = newArrayList();

	private Set<XImportDeclaration> removedImportDeclarations = newLinkedHashSet();

	private Map<String, JvmDeclaredType> plainImports = newHashMap();

	private Map<JvmDeclaredType, Set<String>> staticImports = newHashMap();
	
	private Map<JvmDeclaredType, Set<String>> staticExtensionImports = newHashMap();

	private String lineSeparator;

	private XtextResource resource;
	
	private ImportSectionRegionUtil regionUtil;
	
	private boolean isSort;

	private Set<String> implicitlyImportedPackages;

	private IValueConverter<String> nameValueConverter;
	
	private ITextRegion importRegion;
	
	public RewritableImportSection(XtextResource resource, IImportsConfiguration importsConfiguration, 
			XImportSection originalImportSection, String lineSeparator, ImportSectionRegionUtil regionUtil,
			IValueConverter<String> nameConverter) {
		this.resource = resource;
		this.lineSeparator = lineSeparator;
		this.regionUtil = regionUtil;
		this.nameValueConverter = nameConverter;
		this.implicitlyImportedPackages = importsConfiguration.getImplicitlyImportedPackages(resource);
		this.importRegion = regionUtil.computeRegion(resource);
		if (originalImportSection != null) {
			for (XImportDeclaration originalImportDeclaration : originalImportSection.getImportDeclarations()) {
				this.originalImportDeclarations.add(originalImportDeclaration);
				if (originalImportDeclaration.isStatic()) {
					String memberName = originalImportDeclaration.getMemberName();
					JvmDeclaredType importedType = originalImportDeclaration.getImportedType();
					if (originalImportDeclaration.isExtension()) {
						Maps2.putIntoSetMap(importedType, memberName, staticExtensionImports);
					} else {
						Maps2.putIntoSetMap(importedType, memberName, staticImports);
					}
				} else if(originalImportDeclaration.getImportedType() != null) {
					plainImports.put(originalImportDeclaration.getImportedType().getSimpleName(),
							originalImportDeclaration.getImportedType());
				}
			}
		}
	}

	public void setSort(boolean isSort) {
		this.isSort = isSort;
	}
	
	public boolean isSort() {
		return isSort;
	}
	
	public boolean addImport(JvmDeclaredType type) {
		if (plainImports.containsKey(type.getSimpleName()) || !needsImport(type))
			return false;
		plainImports.put(type.getSimpleName(), type);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		addedImportDeclarations.add(importDeclaration);
		return true;
	}
	
	protected boolean needsImport(JvmDeclaredType type)  {
		if (type.getDeclaringType() != null)
			return true;
		String packageName = type.getPackageName();
		return packageName != null && !(implicitlyImportedPackages.contains(packageName));
	}
	
	public boolean removeImport(JvmDeclaredType type) {
		XImportDeclaration importDeclaration = findOriginalImport(type, null, addedImportDeclarations, false, false);
		if(importDeclaration != null) { 
			addedImportDeclarations.remove(importDeclaration);
		} else {
			importDeclaration = findOriginalImport(type, null, originalImportDeclarations, false, false);
			if(importDeclaration != null) 
				removedImportDeclarations.add(importDeclaration);
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
	
	protected XImportDeclaration findOriginalImport(JvmDeclaredType type, String memberName, Collection<XImportDeclaration> list,
			boolean isStatic, boolean isExtension) {
		XImportDeclaration result = null;
		for(XImportDeclaration importDeclaration: list) {
			if(!(isStatic ^ importDeclaration.isStatic())
					&& !(isExtension ^ importDeclaration.isExtension())
					&& importDeclaration.getImportedType() == type) {
				if (memberName == null) {
					return importDeclaration;
				}
				if (memberName.equals(importDeclaration.getMemberName())) { 
					return importDeclaration;
				}
				if (result == null) {
					result = importDeclaration;
				}
			}
		}
		return result;
	}

	public JvmDeclaredType getImportedType(String simpleName) {
		return plainImports.get(simpleName);
	}

	public boolean addStaticImport(JvmMember member) {
		if (member instanceof JvmDeclaredType) {
			return addStaticImport((JvmDeclaredType) member, null);
		} else {
			return addStaticImport(member.getDeclaringType(), member.getSimpleName());
		}
	}

	public boolean addStaticImport(JvmDeclaredType type, String memberName) {
		if (hasStaticImport(staticImports, type, memberName)) {
			return false;
		}
		Maps2.putIntoSetMap(type, memberName, staticImports);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		importDeclaration.setStatic(true);
		if (memberName == null) {
			importDeclaration.setWildcard(true);
		} else {
			importDeclaration.setMemberName(memberName);
		}
		addedImportDeclarations.add(importDeclaration);
		return true;		
	}

	public boolean removeStaticImport(JvmDeclaredType type, String memberName) {
		XImportDeclaration importDeclaration = findOriginalImport(type, memberName, originalImportDeclarations, true, false);
		if(importDeclaration != null) 
			removedImportDeclarations.add(importDeclaration);
		else {
			importDeclaration = findOriginalImport(type, memberName, addedImportDeclarations, true, false);
			if(importDeclaration != null)
				addedImportDeclarations.remove(importDeclaration);
		}
		Set<String> members = staticImports.get(type);
		if (members != null) {
			members.remove(memberName);
		}
		return importDeclaration != null;
	}
	
	public boolean addStaticExtensionImport(JvmMember member) {
		if (member instanceof JvmDeclaredType) {
			return addStaticExtensionImport((JvmDeclaredType) member, null);
		} else {
			return addStaticExtensionImport(member.getDeclaringType(), member.getSimpleName());
		}
	}

	public boolean addStaticExtensionImport(JvmDeclaredType type, String memberName) {
		if (hasStaticImport(staticExtensionImports, type, memberName)) {
			return false;
		}
		Maps2.putIntoSetMap(type, memberName, staticExtensionImports);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		importDeclaration.setStatic(true);
		importDeclaration.setExtension(true);
		if (memberName == null) {
			importDeclaration.setWildcard(true);
		} else {
			importDeclaration.setMemberName(memberName);
		}
		addedImportDeclarations.add(importDeclaration);
		return true;		
	}

	public boolean removeStaticExtensionImport(JvmDeclaredType type, String memberName) {
		XImportDeclaration importDeclaration = findOriginalImport(type, memberName, originalImportDeclarations, true, true);
		if(importDeclaration != null) 
			removedImportDeclarations.add(importDeclaration);
		else {
			importDeclaration = findOriginalImport(type, memberName, addedImportDeclarations, true, true);
			if(importDeclaration != null)
				addedImportDeclarations.remove(importDeclaration);
		}
		Set<String> members = staticExtensionImports.get(type);
		if (members != null) {
			members.remove(memberName);
		}
		return importDeclaration != null;
	}

	public List<ReplaceRegion> rewrite() {
		removeObsoleteStaticImports();
		final List<ReplaceRegion> replaceRegions = newArrayList();
		if(isSort) {
			List<XImportDeclaration> allImportDeclarations = newArrayList();
			allImportDeclarations.addAll(originalImportDeclarations);
			allImportDeclarations.addAll(addedImportDeclarations);
			allImportDeclarations.removeAll(removedImportDeclarations);
			String newImportSection = serializeImports(allImportDeclarations);
			importRegion = regionUtil.addLeadingWhitespace(importRegion, resource);
			importRegion = regionUtil.addTrailingWhitespace(importRegion, resource);
			return singletonList(new ReplaceRegion(importRegion, newImportSection));
		} else {
			for(XImportDeclaration removedImportDeclaration: removedImportDeclarations) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(removedImportDeclaration);
				if(node != null) {
					ITextRegion textRegion = node.getTextRegion();
					textRegion = regionUtil.addTrailingSingleWhitespace(textRegion, lineSeparator, resource);
					replaceRegions.add(new ReplaceRegion(textRegion, ""));
				}
			}
			addSectionToAppend(new IAcceptor<ReplaceRegion>() {
				public void accept(ReplaceRegion t) {
					replaceRegions.add(t);
				}
			});
		}
		return replaceRegions;
	}

	private void removeObsoleteStaticImports() {
		for(Entry<JvmDeclaredType, Set<String>> staticExtensionImport: staticExtensionImports.entrySet()) {
			JvmDeclaredType type = staticExtensionImport.getKey();
			Set<String> memberNames = staticImports.get(type);
			if (memberNames != null) {
				for (String memberName : staticExtensionImport.getValue()) {
					if (memberNames.contains(memberName)) { 
						removeStaticImport(type, memberName);
					}
				}
			}
		}
	}

	protected void addSectionToAppend(IAcceptor<ReplaceRegion> acceptor) {
		StringBuilder importDeclarationsToAppend = getImportDeclarationsToAppend();
		if(importDeclarationsToAppend.length() ==0) 
			return;
		importRegion = regionUtil.addLeadingWhitespace(importRegion, resource);
		importRegion = regionUtil.addTrailingSingleWhitespace(importRegion, lineSeparator, resource);
		int insertOffset = importRegion.getOffset() + importRegion.getLength();
		if (insertOffset != 0 && originalImportDeclarations.isEmpty())
			importDeclarationsToAppend.insert(0, lineSeparator);
		importDeclarationsToAppend.append(lineSeparator);
		int insertLength = -importRegion.getLength();
		insertLength += regionUtil.addTrailingWhitespace(importRegion, resource).getLength();
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
		String escapedTypeName = nameValueConverter.toString(serializeType(newImportDeclaration.getImportedType()));
		builder.append(escapedTypeName);
		if (newImportDeclaration.isStatic()) {
			builder.append(".");
			if (newImportDeclaration.isWildcard()) {
				builder.append("*");
			} else {
				builder.append(newImportDeclaration.getMemberName());
			}
		}
		builder.append(lineSeparator);
	}
	
	/**
	 * We cannot rely on JvmType#getIdentifier as it is cached and does not pick up changed simpleNames, 
	 * e.g. in rename refactoring. 
	 */
	protected String serializeType(JvmDeclaredType type) {
		return type.getQualifiedName('.');
	}
	
	protected String serializeImports(List<XImportDeclaration> allDeclarations) {
		StringBuilder builder = new StringBuilder();
		if(needsPreceedingBlankLine())
			builder.append(lineSeparator).append(lineSeparator);
		boolean needNewline = appendSubsection(builder, filter(allDeclarations, new Predicate<XImportDeclaration>() {
			public boolean apply(XImportDeclaration input) {
				return !input.isStatic();
			}
		}), false);
		needNewline = appendSubsection(builder, filter(allDeclarations, new Predicate<XImportDeclaration>() {
			public boolean apply(XImportDeclaration input) {
				return input.isStatic() && !input.isExtension();
			}
		}), needNewline);
		appendSubsection(builder, filter(allDeclarations, new Predicate<XImportDeclaration>() {
			public boolean apply(XImportDeclaration input) {
				return input.isStatic() && input.isExtension();
			}
		}), needNewline);
		if(!isEmpty(allDeclarations)) 
			builder.append(lineSeparator);
		return builder.toString();
	}

	protected boolean needsPreceedingBlankLine() {
		return regionUtil.addLeadingWhitespace(importRegion, resource).getOffset() != 0;
	}

	protected boolean appendSubsection(StringBuilder builder, Iterable<XImportDeclaration> subSection, boolean needsNewline) {
		if (!isEmpty(subSection)) {
			if(needsNewline)
				builder.append(lineSeparator);
			for (XImportDeclaration declaration: isSort() ? sort(subSection) : subSection) {
				appendImport(builder, declaration);
			}
			return true;
		}
		return needsNewline;
	}
	
	protected List<XImportDeclaration> sort(Iterable<XImportDeclaration> declarations) {
		List<XImportDeclaration> sortMe = newArrayList(filter(declarations, new Predicate<XImportDeclaration>() {
			public boolean apply(XImportDeclaration in) {
				return !isEmpty(in.getImportedTypeName());
			}
		}));
		Collections.sort(sortMe, new Comparator<XImportDeclaration>() {
			public int compare(XImportDeclaration o1, XImportDeclaration o2) {
				return o1.getImportedTypeName().compareTo(o2.getImportedTypeName());
			}
		});
		return sortMe;
	}

	public boolean hasStaticImport(JvmDeclaredType declaringType, String memberName, boolean extension) {
		if (extension) {
			return hasStaticImport(staticExtensionImports, declaringType, memberName);
		}
		return hasStaticImport(staticImports, declaringType, memberName);
	}

	private boolean hasStaticImport(Map<JvmDeclaredType, Set<String>> imports, JvmDeclaredType declaringType, String memberName) {
		Set<String> members = imports.get(declaringType);
		return members != null && members.contains(memberName);
	}

}
