/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.contentassist

import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import com.google.inject.Inject
import java.util.Collections
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.xbase.ide.types.ClasspathScanner
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor
import org.eclipse.xtext.xbase.imports.IImportsConfiguration
import org.eclipse.xtext.xbase.imports.ImportSectionRegionUtil
import org.eclipse.xtext.xtype.XImportSection
import org.eclipse.xtext.xtype.XtypePackage
import org.objectweb.asm.Opcodes

class ClasspathBasedIdeTypesProposalProvider implements IIdeTypesProposalProvider {
	
	@Inject ClassLoader classLoader
	
	@Inject ClasspathScanner classpathScanner
	
	@Inject IdeContentProposalCreator proposalCreator
	
	@Inject IdeContentProposalPriorities proposalPriorities
	
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Inject IImportsConfiguration importsConfiguration
	
	@Inject ImportSectionRegionUtil importSectionRegionUtil
	
	override createTypeProposals(EReference reference, ContentAssistContext context, Predicate<ITypeDescriptor> filter,
			IIdeContentProposalAcceptor acceptor) {
		var ITextRegion importSectionRegion
		var XImportSection importSection
		if (!isImportDeclaration(reference, context)) {
			importSection = importsConfiguration.getImportSection(context.resource)
			importSectionRegion = importSectionRegionUtil.computeRegion(context.resource)
		}
		
		for (typeDesc : context.typeDescriptors) {
			if (!acceptor.canAcceptMoreProposals) {
				return
			}
			if (canPropose(typeDesc, context, filter)) {
				val entry = createProposal(reference, typeDesc, context, importSection, importSectionRegion)
				val priority = (proposalPriorities as XbaseIdeContentProposalPriorities).getTypeRefPriority(typeDesc, entry)
				acceptor.accept(entry, priority)
			}
		}
	}
	
	protected def getTypeDescriptors(ContentAssistContext context) {
		val bootClasspath = classpathScanner.getBootClasspathDescriptors(#['java'])
		val appClasspath = classpathScanner.getDescriptors(context.classLoader, Collections.emptyList)
		return Iterables.concat(bootClasspath, appClasspath)
	}
	
	protected def getClassLoader(ContentAssistContext context) {
		val resourceSet = context.resource.resourceSet
		if (resourceSet instanceof XtextResourceSet) {
			val ctx = resourceSet.classpathURIContext
			if (ctx !== null) {
		        if (ctx instanceof Class<?>)
		            return ctx.classLoader
		        if (ctx instanceof ClassLoader)
			        return ctx
	        	return ctx.class.classLoader
			}
		}
		return classLoader
	}
	
	protected def canPropose(ITypeDescriptor typeDesc, ContentAssistContext context, Predicate<ITypeDescriptor> filter) {
		isVisible(typeDesc, context) && filter.apply(typeDesc)
	}
	
	protected def isVisible(ITypeDescriptor typeDesc, ContentAssistContext context) {
		typeDesc.accessFlags.bitwiseAnd(Opcodes.ACC_PUBLIC) != 0
	}
	
	protected def ContentAssistEntry createProposal(EReference reference, ITypeDescriptor typeDesc,
			ContentAssistContext context, XImportSection importSection, ITextRegion importSectionRegion) {
		val importDecl = isImportDeclaration(reference, context)
		val qualifiedName = qualifiedNameConverter.toString(typeDesc.qualifiedName)
		val proposal = if (importDecl) qualifiedName else typeDesc.simpleName
		proposalCreator.createProposal(proposal, context) [
			kind = ContentAssistEntry.KIND_REFERENCE
			if (importDecl) {
				label = typeDesc.simpleName
				description = proposal
			} else {
				description = qualifiedName
				if (importSectionRegion !== null
						&& isImportDeclarationRequired(typeDesc, qualifiedName, context, importSection)) {
					addImportDeclaration(importSectionRegion, typeDesc, qualifiedName, context)
				}
			}
		]
	}
	
	protected def isImportDeclaration(EReference reference, ContentAssistContext context) {
		reference == XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE
	}
	
	protected def isImportDeclarationRequired(ITypeDescriptor typeDesc, String qualifiedName,
			ContentAssistContext context, XImportSection importSection) {
		!(typeDesc.name.startsWith('java.lang') && typeDesc.name.lastIndexOf('.') == 9)
			&& (importSection === null || !importSection.importDeclarations.exists[importedType?.qualifiedName == qualifiedName])
	}
	
	protected def addImportDeclaration(ContentAssistEntry entry, ITextRegion importSectionRegion,
			ITypeDescriptor typeDesc, String qualifiedName, ContentAssistContext context) {
		val insertionOffset = importSectionRegion.offset + importSectionRegion.length
		val declaration = '\nimport ' + qualifiedName
		entry.textReplacements += new ReplaceRegion(insertionOffset, 0, declaration)
	}
	
}
				
