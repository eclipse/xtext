/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.quickfix

import com.google.inject.Inject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.ide.codebuilder.JavaConstructorBuilder
import org.eclipse.xtend.ide.codebuilder.JavaFieldBuilder
import org.eclipse.xtend.ide.codebuilder.JavaMethodBuilder
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable
import org.eclipse.xtext.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.resource.XtextResource

/**
 * Creates quickfixes using {@link ICodeBuilder}s.
 * 
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API
 */
class CodeBuilderQuickfix {
	
	@Inject IURIEditorOpener editorOpener
	@Inject ReplacingAppendable.Factory appendableFactory 
	
	def addQuickfix(ICodeBuilder builder, String label, Issue issue, IssueResolutionAcceptor acceptor) {
		if (builder.isValid) {
			val modification = switch builder {
				ICodeBuilder.Xtend: builder.xtendModification
				ICodeBuilder.Java: builder.javaModification
			} 
			acceptor.accept(issue, label, builder.preview, builder.image, modification)
		}
	}
	
	def protected getImage(ICodeBuilder builder) {
		switch builder.visibility {
			case JvmVisibility.PRIVATE: 'fix_private_obj.gif'
			case JvmVisibility.PUBLIC: 'fix_public_obj.gif'
			case JvmVisibility.PROTECTED: 'fix_protected_obj.gif'
			default: 'fix_default_obj.gif'
		} 	
	}
	
	def protected isXtendSource(ICodeBuilder builder) {
		builder.ownerSource instanceof XtendClass
	}
	
	def protected int getTypeIndentation(XtextResource resource, IXtextDocument document, XtendTypeDeclaration xtendClass) {
		val object = resource.getEObject(EcoreUtil.getURI(xtendClass).fragment)
		if (object !== null) {
			val node = NodeModelUtils.findActualNodeFor(object)
			if (node !== null) {
				return appendableFactory.getIndentationLevelAtOffset(node.offset, document, resource);
			}
		}
		return 0
	}
	
	def protected IModification getXtendModification(ICodeBuilder.Xtend builder) {
		[
			val xtendClass = builder.xtendType
			val editor = editorOpener.open(EcoreUtil.getURI(xtendClass), false);
			if (!(editor instanceof XtextEditor)) {
				return
			}
			val xtextEditor = editor as XtextEditor;
			val document = xtextEditor.getDocument();
			val wrapper = Wrapper.forType(Integer)
			val appendable = document.readOnly [ resource |
				var offset = builder.getInsertOffset(resource)
				wrapper.set(offset)
				val typeIndentation = getTypeIndentation(resource, document, xtendClass)
				appendableFactory.create(document, resource, offset, 0, new OptionalParameters => [
					baseIndentationLevel = builder.indentationLevel + typeIndentation
					ensureEmptyLinesAround = true
				])				
			] 
			
			var offset = wrapper.get
			builder.build(appendable)
			appendable.commitChanges
			xtextEditor.setHighlightRange(offset + 1, appendable.length, true)
		]
	}

	def protected IModification getJavaModification(ICodeBuilder.Java builder) {
		[
			val type = builder.IType
			val importManager = new ImportManager(true, ".".charAt(0))
			val content = new StringBuilderBasedAppendable(importManager)
			builder.build(content)
			importManager.imports.forEach [
				type.compilationUnit.createImport(it, null, new NullProgressMonitor)
			]
			val element = 
				switch(builder) {
					JavaFieldBuilder:  type.createField(content.toString, null, true, new NullProgressMonitor)
					JavaConstructorBuilder: type.createMethod(content.toString, null, true, new NullProgressMonitor)
					JavaMethodBuilder: type.createMethod(content.toString, null, true, new NullProgressMonitor)
					default: null
				}
			if(element !== null)
				new JdtHyperlink => [
					javaElement = element
					open
				]
		]
	}
	
}