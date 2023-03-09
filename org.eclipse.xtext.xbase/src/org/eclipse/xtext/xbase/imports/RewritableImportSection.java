/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.isEmpty;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.isEmpty;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Model of an import section that can be changed.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RewritableImportSection {

	public static class Factory {
		
		public static final String REWRITABLEIMPORTSECTION_ENABLEMENT = "RewritableImportSection_Enablement";
		
		@Inject(optional = true)
		@Named(REWRITABLEIMPORTSECTION_ENABLEMENT)
		private boolean enabled = true;
		
		@Inject
		private IImportsConfiguration importsConfiguration;

		@Inject
		private IWhitespaceInformationProvider whitespaceInformationProvider;

		@Inject
		private ImportSectionRegionUtil regionUtil;

		@Inject
		private XbaseQualifiedNameValueConverter nameValueConverter;

		public RewritableImportSection parse(XtextResource resource) {
			RewritableImportSection rewritableImportSection = new RewritableImportSection(resource, importsConfiguration,
					importsConfiguration.getImportSection(resource), getLineSeparator(resource), regionUtil, nameValueConverter);
			rewritableImportSection.setEnabled(enabled);
			return rewritableImportSection;
		}

		public RewritableImportSection createNewEmpty(XtextResource resource) {
			RewritableImportSection rewritableImportSection = new RewritableImportSection(resource, importsConfiguration, null, getLineSeparator(resource), regionUtil, nameValueConverter);
			rewritableImportSection.setSort(true);
			rewritableImportSection.setEnabled(enabled);
			return rewritableImportSection;
		}

		protected String getLineSeparator(XtextResource resource) {
			return whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI()).getLineSeparator();
		}
	}

	private List<XImportDeclaration> originalImportDeclarations = newArrayList();

	private List<XImportDeclaration> addedImportDeclarations = newArrayList();

	private Set<XImportDeclaration> removedImportDeclarations = newLinkedHashSet();

	private Map<String, List<JvmDeclaredType>> plainImports = newHashMap();

	private Map<JvmDeclaredType, Set<String>> staticImports = newHashMap();

	private Map<JvmDeclaredType, Set<String>> staticExtensionImports = newHashMap();

	private String lineSeparator;

	private XtextResource resource;

	private ImportSectionRegionUtil regionUtil;

	private boolean isSort;

	private Set<String> implicitlyImportedPackages;

	private IValueConverter<String> nameValueConverter;

	private ITextRegion importRegion;

	private IImportsConfiguration importsConfiguration;

	private boolean enabled = true;

	public RewritableImportSection(XtextResource resource, IImportsConfiguration importsConfiguration, XImportSection originalImportSection,
			String lineSeparator, ImportSectionRegionUtil regionUtil, IValueConverter<String> nameConverter) {
		this.importsConfiguration = importsConfiguration;
		this.resource = resource;
		this.lineSeparator = lineSeparator;
		this.regionUtil = regionUtil;
		this.nameValueConverter = nameConverter;
		this.implicitlyImportedPackages = importsConfiguration.getImplicitlyImportedPackages(resource);
		this.importRegion = regionUtil.computeRegion(resource);
		if (originalImportSection != null) {
			for (XImportDeclaration originalImportDeclaration : originalImportSection.getImportDeclarations()) {
				this.originalImportDeclarations.add(originalImportDeclaration);
				JvmDeclaredType importedType = originalImportDeclaration.getImportedType();
				if (originalImportDeclaration.isStatic()) {
					String memberName = originalImportDeclaration.getMemberName();
					if (originalImportDeclaration.isExtension()) {
						Maps2.putIntoSetMap(importedType, memberName, staticExtensionImports);
					} else {
						Maps2.putIntoSetMap(importedType, memberName, staticImports);
					}
				} else if (importedType != null) {
					Maps2.putIntoListMap(importedType.getSimpleName(), importedType, plainImports);
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
		Maps2.putIntoListMap(type.getSimpleName(), type, plainImports);
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedType(type);
		addedImportDeclarations.add(importDeclaration);
		return true;
	}

	public boolean addImport(String fqn) {
		if (!needsImport(fqn)) {
			return false;
		}
		return addedImportDeclarations.add(createImport(fqn, null));
	}

	protected XImportDeclaration createImport(String importedNamespace, final String member) {
		XImportDeclaration importDeclaration = XtypeFactory.eINSTANCE.createXImportDeclaration();
		importDeclaration.setImportedNamespace(importedNamespace);
		if (member != null) {
			importDeclaration.setMemberName(member);
		}
		return importDeclaration;
	}

	protected boolean needsImport(final String fqn) {
		for (String string : implicitlyImportedPackages) {
			if (fqn.startsWith(string)) {
				return fqn.substring(string.length() + 1).lastIndexOf('.') > 0;
			}
		}
		for (XImportDeclaration importDeclr : originalImportDeclarations) {
			if (!importDeclr.isStatic() && fqn.equals(importDeclr.getImportedTypeName())) {
				return false;
			}
		}
		for (XImportDeclaration importDeclr : addedImportDeclarations) {
			String identifier = importDeclr.getImportedTypeName();
			if (!importDeclr.isStatic() && fqn.equals(identifier)) {
				return false;
			}
		}
		return true;
	}

	public boolean needsImport(JvmDeclaredType type) {
		if (type.getDeclaringType() != null)
			return true;
		String packageName = type.getPackageName();
		return packageName != null && !(implicitlyImportedPackages.contains(packageName));
	}

	public boolean removeImport(JvmDeclaredType type) {
		List<XImportDeclaration> addedImportDeclarationsToRemove = findOriginalImports(type, null, addedImportDeclarations, false, false);
		addedImportDeclarations.removeAll(addedImportDeclarationsToRemove);

		List<XImportDeclaration> originalImportDeclarationsToRemove = findOriginalImports(type, null, originalImportDeclarations, false, false);
		removedImportDeclarations.addAll(originalImportDeclarationsToRemove);

		for (Map.Entry<String, List<JvmDeclaredType>> entry : plainImports.entrySet()) {
			List<JvmDeclaredType> values = entry.getValue();
			if (values.size() == 1) {
				if (values.get(0) == type) {
					plainImports.remove(type.getSimpleName());
					return true;
				}
			}
			Iterator<JvmDeclaredType> iterator = values.iterator();
			while (iterator.hasNext()) {
				JvmDeclaredType value = iterator.next();
				if (value == type) {
					iterator.remove();
					return true;
				}
			}
		}
		return false;
	}

	protected List<XImportDeclaration> findOriginalImports(JvmDeclaredType type, String memberName, Collection<XImportDeclaration> list, boolean isStatic,
			boolean isExtension) {
		List<XImportDeclaration> result = newArrayList();
		for (XImportDeclaration importDeclaration : list) {
			if (!(isStatic ^ importDeclaration.isStatic()) && !(isExtension ^ importDeclaration.isExtension()) && importDeclaration.getImportedType() == type
					&& (memberName == null || memberName.equals(importDeclaration.getMemberName()))) {
				result.add(importDeclaration);
			}
		}
		return result;
	}

	public boolean hasImportedType(JvmDeclaredType type) {
		List<JvmDeclaredType> importedTypes = getImportedTypes(type.getSimpleName());
		if (importedTypes == null) {
			return false;
		}
		for (JvmDeclaredType importedType : importedTypes) {
			if (importedType == type) {
				return true;
			}
		}
		return false;
	}

	public List<JvmDeclaredType> getImportedTypes(String simpleName) {
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

	/**
	 * @param typeFqn
	 *            The fully qualified name of the type to import. E.g. <code>java.util.List</code>. May not be
	 *            <code>null</code>.
	 * @param member
	 *            member name to import. May not be <code>null</code>. For wildcard use <code>*</code>
	 * 
	 */
	public boolean addStaticImport(final String typeFqn, final String member) {
		if (typeFqn == null || member == null) {
			throw new IllegalArgumentException("Type name " + typeFqn + ". Member name: " + member);
		}
		if (hasStaticImport(typeFqn, member, false)) {
			return false;
		}
		XImportDeclaration importDecl = createImport(typeFqn, member);
		importDecl.setStatic(true);
		return addedImportDeclarations.add(importDecl);
	}

	/**
	 * @param typeFqn
	 *            The fully qualified name of the type to import. E.g. <code>java.util.List</code>. May not be
	 *            <code>null</code>.
	 * @param member
	 *            member name to import. May not be <code>null</code>. For wildcard use <code>*</code>
	 * 
	 */
	public boolean addStaticExtensionImport(final String typeFqn, final String member) {
		if (typeFqn == null || member == null) {
			throw new IllegalArgumentException("Type name " + typeFqn + ". Member name: " + member);
		}
		if (hasStaticImport(typeFqn, member, true)) {
			return false;
		}
		XImportDeclaration importDecl = createImport(typeFqn, member);
		importDecl.setStatic(true);
		importDecl.setExtension(true);
		return addedImportDeclarations.add(importDecl);
	}

	public boolean removeStaticImport(JvmDeclaredType type, String memberName) {
		return removeStaticImport(staticImports, type, memberName, true, false);
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
		return removeStaticImport(staticExtensionImports, type, memberName, true, true);
	}

	protected boolean removeStaticImport(Map<JvmDeclaredType, Set<String>> staticImports, JvmDeclaredType type, String memberName, boolean isStatic,
			boolean isExtension) {
		List<XImportDeclaration> originalImportDeclarationsToRemove = findOriginalImports(type, memberName, originalImportDeclarations, isStatic, isExtension);
		removedImportDeclarations.addAll(originalImportDeclarationsToRemove);

		List<XImportDeclaration> addedImportDeclarationsToRemove = findOriginalImports(type, memberName, addedImportDeclarations, isStatic, isExtension);
		addedImportDeclarations.removeAll(addedImportDeclarationsToRemove);

		Set<String> members = staticImports.get(type);
		return members != null && members.remove(memberName);
	}

	public void update() {
		XImportSection importSection = importsConfiguration.getImportSection(resource);
		if (importSection == null && importsConfiguration instanceof IMutableImportsConfiguration) {
			importSection = XtypeFactory.eINSTANCE.createXImportSection();

			IMutableImportsConfiguration mutableImportsConfiguration = (IMutableImportsConfiguration) importsConfiguration;
			mutableImportsConfiguration.setImportSection(resource, importSection);
		}
		if (importSection == null) {
			return;
		}
		removeObsoleteStaticImports();

		List<XImportDeclaration> allImportDeclarations = newArrayList();
		allImportDeclarations.addAll(originalImportDeclarations);
		allImportDeclarations.addAll(addedImportDeclarations);
		allImportDeclarations.removeAll(removedImportDeclarations);

		List<XImportDeclaration> importDeclarations = importSection.getImportDeclarations();
		importDeclarations.clear();
		importDeclarations.addAll(allImportDeclarations);
	}

	public List<ReplaceRegion> rewrite() {
		removeObsoleteStaticImports();
		final List<ReplaceRegion> replaceRegions = newArrayList();
		if (isSort) {
			List<XImportDeclaration> allImportDeclarations = newArrayList();
			allImportDeclarations.addAll(originalImportDeclarations);
			allImportDeclarations.addAll(addedImportDeclarations);
			allImportDeclarations.removeAll(removedImportDeclarations);
			String newImportSection = serializeImports(allImportDeclarations);
			importRegion = regionUtil.addLeadingWhitespace(importRegion, resource);
			importRegion = regionUtil.addTrailingWhitespace(importRegion, resource);
			return singletonList(new ReplaceRegion(importRegion, newImportSection));
		} else {
			for (XImportDeclaration removedImportDeclaration : removedImportDeclarations) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(removedImportDeclaration);
				if (node != null) {
					ITextRegion textRegion = node.getTextRegion();
					textRegion = regionUtil.addTrailingSingleWhitespace(textRegion, lineSeparator, resource);
					replaceRegions.add(new ReplaceRegion(textRegion, ""));
				}
			}
			addSectionToAppend(new IAcceptor<ReplaceRegion>() {
				@Override
				public void accept(ReplaceRegion t) {
					replaceRegions.add(t);
				}
			});
		}
		return replaceRegions;
	}

	private void removeObsoleteStaticImports() {
		for (Entry<JvmDeclaredType, Set<String>> staticExtensionImport : staticExtensionImports.entrySet()) {
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
		if (importDeclarationsToAppend.length() == 0)
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
		String qualifiedTypeName = newImportDeclaration.getImportedNamespace();
		if (newImportDeclaration.getImportedType() != null) {
			qualifiedTypeName = serializeType(newImportDeclaration.getImportedType());
		}
		String escapedTypeName = nameValueConverter.toString(qualifiedTypeName);
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
	 * We cannot rely on JvmType#getIdentifier as it is cached and does not pick up changed simpleNames, e.g. in rename
	 * refactoring.
	 */
	protected String serializeType(JvmDeclaredType type) {
		return type.getQualifiedName('.');
	}

	protected String serializeImports(List<XImportDeclaration> allDeclarations) {
		StringBuilder builder = new StringBuilder();
		if (needsPreceedingBlankLine())
			builder.append(lineSeparator).append(lineSeparator);
		boolean needNewline = appendSubsection(builder, filter(allDeclarations, new Predicate<XImportDeclaration>() {
			@Override
			public boolean apply(XImportDeclaration input) {
				return !input.isStatic();
			}
		}), false);
		needNewline = appendSubsection(builder, filter(allDeclarations, new Predicate<XImportDeclaration>() {
			@Override
			public boolean apply(XImportDeclaration input) {
				return input.isStatic() && !input.isExtension();
			}
		}), needNewline);
		appendSubsection(builder, filter(allDeclarations, new Predicate<XImportDeclaration>() {
			@Override
			public boolean apply(XImportDeclaration input) {
				return input.isStatic() && input.isExtension();
			}
		}), needNewline);
		if (!isEmpty(allDeclarations))
			builder.append(lineSeparator);
		return builder.toString();
	}

	protected boolean needsPreceedingBlankLine() {
		return regionUtil.addLeadingWhitespace(importRegion, resource).getOffset() != 0;
	}

	protected boolean appendSubsection(StringBuilder builder, Iterable<XImportDeclaration> subSection, boolean needsNewline) {
		if (!isEmpty(subSection)) {
			if (needsNewline)
				builder.append(lineSeparator);
			for (XImportDeclaration declaration : isSort() ? sort(subSection) : subSection) {
				appendImport(builder, declaration);
			}
			return true;
		}
		return needsNewline;
	}

	protected List<XImportDeclaration> sort(Iterable<XImportDeclaration> declarations) {
		List<XImportDeclaration> sortMe = newArrayList(filter(declarations, new Predicate<XImportDeclaration>() {
			@Override
			public boolean apply(XImportDeclaration in) {
				return !isEmpty(in.getImportedTypeName());
			}
		}));
		Collections.sort(sortMe, new Comparator<XImportDeclaration>() {
			@Override
			public int compare(XImportDeclaration o1, XImportDeclaration o2) {
				return o1.getImportedName().compareTo(o2.getImportedName());
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

	public boolean hasStaticImport(String memberName, boolean extension) {
		if (extension) {
			return hasStaticImport(staticExtensionImports, memberName);
		}
		return hasStaticImport(staticImports, memberName);
	}

	private boolean hasStaticImport(Map<JvmDeclaredType, Set<String>> imports, String memberName) {
		for (Entry<JvmDeclaredType, Set<String>> entry : imports.entrySet()) {
			Set<String> value = entry.getValue();
			if (value != null && value.contains(memberName)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasStaticImport(String typeName, String memberName, boolean extension) {
		for (String string : implicitlyImportedPackages) {
			if (typeName.startsWith(string)) {
				return typeName.substring(string.length()).lastIndexOf('.') == 0;
			}
		}
		Map<JvmDeclaredType, Set<String>> imports = staticImports;
		if (extension) {
			imports = staticExtensionImports;
		}
		for (JvmDeclaredType type : imports.keySet()) {
			if (typeName.equals(type.getIdentifier())) {
				Set<String> members = imports.get(type);
				return members != null && ((members.contains(memberName) || members.contains(null)));
			}
		}
		for (XImportDeclaration importDeclr : addedImportDeclarations) {
			String identifier = importDeclr.getImportedTypeName();
			if (importDeclr.isStatic() && typeName.equals(identifier)) {
				if (Objects.equal(importDeclr.getMemberName(), memberName) || importDeclr.isWildcard() || "*".equals(importDeclr.getMemberName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
