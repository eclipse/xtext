/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Objects;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.descriptions.ClasspathScanner;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.imports.ImportSectionRegionUtil;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ClasspathBasedIdeTypesProposalProvider implements IIdeTypesProposalProvider {
	@Inject
	private ClassLoader classLoader;

	@Inject
	private ClasspathScanner classpathScanner;

	@Inject
	private IdeContentProposalCreator proposalCreator;

	@Inject
	private IdeContentProposalPriorities proposalPriorities;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private IImportsConfiguration importsConfiguration;

	@Inject
	private ImportSectionRegionUtil importSectionRegionUtil;

	@Override
	public void createTypeProposals(EReference reference, ContentAssistContext context,
			Predicate<? super ITypeDescriptor> filter, IIdeContentProposalAcceptor acceptor) {
		ITextRegion importSectionRegion = null;
		XImportSection importSection = null;
		if (!isImportDeclaration(reference, context)) {
			importSection = importsConfiguration.getImportSection(context.getResource());
			importSectionRegion = importSectionRegionUtil.computeRegion(context.getResource());
		}
		for (ITypeDescriptor typeDesc : getTypeDescriptors(context)) {
			if (!acceptor.canAcceptMoreProposals()) {
				return;
			}
			if (canPropose(typeDesc, context, filter)) {
				ContentAssistEntry entry = createProposal(reference, typeDesc, context, importSection,
						importSectionRegion);
				int priority = ((XbaseIdeContentProposalPriorities) proposalPriorities).getTypeRefPriority(typeDesc,
						entry);
				acceptor.accept(entry, priority);
			}
		}
	}

	protected Iterable<ITypeDescriptor> getTypeDescriptors(ContentAssistContext context) {
		Iterable<ITypeDescriptor> bootClasspath = classpathScanner
				.getBootClasspathDescriptors(Lists.newArrayList("java"));
		Iterable<ITypeDescriptor> appClasspath = classpathScanner.getDescriptors(getClassLoader(context),
				Collections.emptyList());
		return Iterables.concat(bootClasspath, appClasspath);
	}

	protected ClassLoader getClassLoader(ContentAssistContext context) {
		ResourceSet resourceSet = context.getResource().getResourceSet();
		if (resourceSet instanceof XtextResourceSet) {
			Object ctx = ((XtextResourceSet) resourceSet).getClasspathURIContext();
			if (ctx != null) {
				if (ctx instanceof Class<?>) {
					return ((Class<?>) ctx).getClassLoader();
				}
				if (ctx instanceof ClassLoader) {
					return (ClassLoader) ctx;
				}
				return ctx.getClass().getClassLoader();
			}
		}
		return classLoader;
	}

	protected boolean canPropose(ITypeDescriptor typeDesc, ContentAssistContext context,
			Predicate<? super ITypeDescriptor> filter) {
		return isVisible(typeDesc, context) && filter.apply(typeDesc);
	}

	protected boolean isVisible(ITypeDescriptor typeDesc, ContentAssistContext context) {
		return Modifier.isPublic(typeDesc.getModifiers());
	}

	protected ContentAssistEntry createProposal(EReference reference, ITypeDescriptor typeDesc,
			ContentAssistContext context, XImportSection importSection, ITextRegion importSectionRegion) {
		boolean importDecl = isImportDeclaration(reference, context);
		String qualifiedName = qualifiedNameConverter.toString(typeDesc.getQualifiedName());
		String proposal;
		if (importDecl) {
			proposal = qualifiedName;
		} else {
			proposal = typeDesc.getSimpleName();
		}
		return proposalCreator.createProposal(proposal, context, (ContentAssistEntry it) -> {
			it.setKind(ContentAssistEntry.KIND_REFERENCE);
			if (importDecl) {
				it.setLabel(typeDesc.getSimpleName());
				it.setDescription(proposal);
			} else {
				it.setDescription(qualifiedName);
				if (importSectionRegion != null
						&& isImportDeclarationRequired(typeDesc, qualifiedName, context, importSection)) {
					addImportDeclaration(it, importSectionRegion, typeDesc, qualifiedName, context);
				}
			}
		});
	}

	protected boolean isImportDeclaration(EReference reference, ContentAssistContext context) {
		return XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE.equals(reference);
	}

	protected boolean isImportDeclarationRequired(ITypeDescriptor typeDesc, String qualifiedName,
			ContentAssistContext context, XImportSection importSection) {
		return !(typeDesc.getName().startsWith("java.lang") && typeDesc.getName().lastIndexOf('.') == "java.lang".length())
				&& (importSection == null || !IterableExtensions.exists(importSection.getImportDeclarations(),
						(XImportDeclaration it) -> {
							String importFqn = null;
							if (it.getImportedType() != null) {
								importFqn = it.getImportedType().getQualifiedName();
							}
							return Objects.equals(importFqn, qualifiedName);
						}));
	}

	protected boolean addImportDeclaration(ContentAssistEntry entry, ITextRegion importSectionRegion,
			ITypeDescriptor typeDesc, String qualifiedName, ContentAssistContext context) {
		int insertionOffset = importSectionRegion.getOffset() + importSectionRegion.getLength();
		String declaration = "\nimport " + qualifiedName;
		return entry.getTextReplacements().add(new ReplaceRegion(insertionOffset, 0, declaration));
	}
}
