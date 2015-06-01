/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.contentassist

import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import com.google.inject.Inject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities
import org.eclipse.xtext.xbase.imports.ImportSectionRegionUtil
import org.eclipse.xtext.xbase.web.scoping.ClasspathScanner
import org.eclipse.xtext.xbase.web.scoping.ITypeDescriptor
import org.eclipse.xtext.xtype.XtypePackage
import org.objectweb.asm.Opcodes

class ClasspathBasedWebTypesProposalProvider implements IWebTypesProposalProvider {
	
	@Inject ClassLoader classLoader
	
	@Inject WebContentProposalPriorities proposalPriorities
	
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Inject ImportSectionRegionUtil importSectionRegionUtil
	
	override createTypeProposals(EReference reference, ContentAssistContext context, Predicate<ITypeDescriptor> filter,
			IWebContentProposaAcceptor acceptor) {
		val importSectionRegion = if (!isImportDeclaration(reference, context)) importSectionRegionUtil.computeRegion(context.resource)
		var count = 0
		for (typeDesc : context.typeDescriptors) {
			if (canPropose(typeDesc, context, filter, count)) {
				val entry = createProposal(reference, typeDesc, context, importSectionRegion)
				val priority = (proposalPriorities as XbaseWebContentProposalPriorities).getTypeRefPriority(typeDesc, entry)
				acceptor.accept(entry, priority)
				count++
			}
		}
	}
	
	protected def getTypeDescriptors(ContentAssistContext context) {
		val classLoader = context.classLoader
		val classpathScanner = ClasspathScanner.instance
		return Iterables.concat(classpathScanner.bootClasspathDescriptors, classpathScanner.getDescriptors(classLoader))
	}
	
	protected def getClassLoader(ContentAssistContext context) {
		val resourceSet = context.resource.resourceSet
		if (resourceSet instanceof XtextResourceSet) {
			val ctx = resourceSet.classpathURIContext
			if (ctx != null) {
		        if (ctx instanceof Class<?>)
		            return ctx.classLoader
		        if (ctx instanceof ClassLoader)
			        return ctx
	        	return ctx.class.classLoader
			}
		}
		return classLoader
	}
	
	protected def canPropose(ITypeDescriptor typeDesc, ContentAssistContext context, Predicate<ITypeDescriptor> filter,
			int numberOfProposedTypes) {
		val prefix = context.prefix
		numberOfProposedTypes < 1000 && typeDesc.simpleName.regionMatches(true, 0, prefix, 0, prefix.length)
					&& isVisible(typeDesc, context) && filter.apply(typeDesc)
	}
	
	protected def isVisible(ITypeDescriptor typeDesc, ContentAssistContext context) {
		typeDesc.accessFlags.bitwiseAnd(Opcodes.ACC_PUBLIC) != 0
	}
	
	protected def ContentAssistResult.Entry createProposal(EReference reference, ITypeDescriptor typeDesc,
			ContentAssistContext context, ITextRegion importSectionRegion) {
		return new ContentAssistResult.Entry(context.prefix) => [
			if (isImportDeclaration(reference, context)) {
				proposal = qualifiedNameConverter.toString(typeDesc.qualifiedName)
				name = typeDesc.simpleName
				description = proposal
			} else {
				proposal = typeDesc.simpleName
				description = qualifiedNameConverter.toString(typeDesc.qualifiedName)
				if (importSectionRegion !== null && isImportDeclarationRequired(typeDesc, context))
					addImportDeclaration(importSectionRegion, typeDesc, context)
			}
		]
	}
	
	protected def isImportDeclaration(EReference reference, ContentAssistContext context) {
		reference == XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE
	}
	
	protected def isImportDeclarationRequired(ITypeDescriptor typeDesc, ContentAssistContext context) {
		!(typeDesc.name.startsWith('java.lang') && typeDesc.name.lastIndexOf('.') == 9)
	}
	
	protected def addImportDeclaration(ContentAssistResult.Entry entry, ITextRegion importSectionRegion,
			ITypeDescriptor typeDesc, ContentAssistContext context) {
		val insertionOffset = importSectionRegion.offset + importSectionRegion.length
		val declaration = '\nimport ' + qualifiedNameConverter.toString(typeDesc.qualifiedName)
		entry.textReplacements += new ReplaceRegion(insertionOffset, 0, declaration)
	}
	
}