/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.templates;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DefaultPositionUpdater;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateBuffer;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContext;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseTemplateContext extends XtextTemplateContext {
	static class Factory {
		@Inject
		private MembersInjector<XbaseTemplateContext> injector;

		public XbaseTemplateContext create(TemplateContextType type, IDocument document, Position position,
				ContentAssistContext contentAssistContext, IScopeProvider scopeProvider) {
			XbaseTemplateContext result = new XbaseTemplateContext(type, document, position, contentAssistContext,
					scopeProvider);
			injector.injectMembers(result);
			return result;
		}
	}

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private RewritableImportSection.Factory importSectionFactory;

	@Inject
	private ReplaceConverter replaceConverter;
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;

	private List<String> imports = new ArrayList<String>();

	public XbaseTemplateContext(TemplateContextType type, IDocument document, Position position,
			ContentAssistContext contentAssistContext, IScopeProvider scopeProvider) {
		super(type, document, position, contentAssistContext, scopeProvider);
	}

	@Override
	public TemplateBuffer evaluateForDisplay(Template template) throws BadLocationException, TemplateException {
		// Ensure clean state before evaluation starts
		imports.clear();
		return super.evaluateForDisplay(template);
	}

	@Override
	public TemplateBuffer evaluate(Template template) throws BadLocationException, TemplateException {
		IXtextDocument xDocument = xtextDocumentUtil.getXtextDocument(getDocument());
		// Ensure clean state before evaluation starts
		imports.clear();
		TemplateBuffer resolvedContent = super.evaluate(template);

		Position position = new Position(getCompletionOffset(), 0);
		List<ReplaceRegion> rewrite = createImports(imports, xDocument);
		if (rewrite.size() > 0 && !isReadOnly()) {
			// Remember the completion offset before performing doc changes
			final String category = "__template_position_import_section" + System.currentTimeMillis(); //$NON-NLS-1$
			IPositionUpdater updater = new DefaultPositionUpdater(category);
			xDocument.addPositionCategory(category);
			xDocument.addPositionUpdater(updater);
			xDocument.addPosition(position);
			try {
				replaceConverter.convertToTextEdit(rewrite).apply(xDocument);
				//restore CompletionOffset
				setCompletionOffset(position.getOffset());
			} catch (BadLocationException e) {
				throw new TemplateException(e);
			} finally {
				xDocument.removePosition(position);
				xDocument.removePositionUpdater(updater);
				try {
					xDocument.removePositionCategory(category);
				} catch (BadPositionCategoryException e) {
					throw new TemplateException(e);
				}
			}

		}
		return resolvedContent;
	}

	private List<ReplaceRegion> createImports(final List<String> types, IXtextDocument document) {
		return document.priorityReadOnly(new IUnitOfWork<List<ReplaceRegion>, XtextResource>() {
			@Override
			public List<ReplaceRegion> exec(XtextResource state) throws Exception {
				RewritableImportSection impSection = importSectionFactory.parse(state);
				for (String fqName : types) {
					JvmDeclaredType jvmType = findJvmDeclaredType(fqName, state.getResourceSet());
					if (jvmType != null) {
						impSection.addImport(jvmType);
					}
				}
				return impSection.rewrite();
			}
		});
	}

	private boolean checkImports(final List<String> types, IXtextDocument document) {
		return document.priorityReadOnly(new IUnitOfWork<Boolean, XtextResource>() {
			@Override
			public Boolean exec(XtextResource state) throws Exception {
				for (String fqName : types) {
					JvmDeclaredType jvmType = findJvmDeclaredType(fqName, state.getResourceSet());
					if (jvmType == null) {
						return false;
					}
				}
				return true;
			}
		});
	}

	private JvmDeclaredType findJvmDeclaredType(String fqName, ResourceSet resourceSet) {
		JvmType typeByName = typeReferences.findDeclaredType(fqName, resourceSet);
		if (typeByName instanceof JvmDeclaredType) {
			return (JvmDeclaredType) typeByName;
		}
		return null;
	}

	@Override
	public boolean canEvaluate(Template template) {
		boolean canEvaluate = super.canEvaluate(template);
		if (canEvaluate && !imports.isEmpty()) {
			IXtextDocument xDocument = xtextDocumentUtil.getXtextDocument(getDocument());
			return checkImports(imports, xDocument);
		}
		return canEvaluate;
	}

	public void addImport(String typeName) {
		if (!imports.contains(typeName))
			this.imports.add(typeName);
	}
}
