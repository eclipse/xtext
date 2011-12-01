/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.contentassist;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * An {@link org.eclipse.xtext.xbase.compiler.IAppendable} to insert text into an Xtend document. Takes imports and
 * existing variable names into account.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplacingAppendable extends StringBuilderBasedAppendable {

	private static final Logger LOG = Logger.getLogger(ReplacingAppendable.class);

	public static class Factory {

		@Inject
		private IIndentationInformation indentation;

		@Inject
		private XbaseScopeProvider scopeProvider;

		@Inject
		private IQualifiedNameConverter converter;

		@Inject
		private IXtend2JvmAssociations associations;

		@Inject
		private Provider<WhitespaceHelper> whitespaceHelperProvider;

		public ReplacingAppendable get(IXtextDocument document, EObject context, int offset, int length) {
			return get(document, context, offset, length, getIndentationLevelAtOffset(offset, document), false);
		}

		public ReplacingAppendable get(IXtextDocument document, EObject context, int offset, int length,
				int indentationLevel, boolean ensureEmptyLinesAround) {
			try {
				XtendFile xtendFile = EcoreUtil2.getContainerOfType(context, XtendFile.class);
				if (xtendFile != null) {
					ImportManager importManager = new ImportManager(true);
					for (XtendImport xImport : xtendFile.getImports()) {
						if (xImport.getImportedType() != null) {
							importManager.addImportFor(xImport.getImportedType());
						}
					}
					WhitespaceHelper whitespaceHelper = whitespaceHelperProvider.get();
					whitespaceHelper.initialize(document, offset, length, ensureEmptyLinesAround);
					ReplacingAppendable appendable = new ReplacingAppendable(importManager,
							indentation.getIndentString(), document, xtendFile, whitespaceHelper);
					IScope scope = scopeProvider.createSimpleFeatureCallScope(getLocalVariableScopeContext(context),
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, context.eResource(), true, -1);
					for (IEObjectDescription feature : scope.getAllElements()) {
						if (feature instanceof IValidatedEObjectDescription
								&& ((IValidatedEObjectDescription) feature).isVisible())
							appendable.declareVariable(feature, converter.toString(feature.getName()));
					}
					for (int i = 0; i < indentationLevel; ++i)
						appendable.increaseIndentation();
					return appendable;
				}
			} catch (Exception exc) {
				LOG.error("Error initializing appendable", exc);
			}
			return null;
		}

		protected EObject getLocalVariableScopeContext(EObject context) {
			if (context instanceof XtendClass)
				return associations.getInferredType((XtendClass) context);
			else if (context instanceof XtendFunction) {
				return associations.getDirectlyInferredOperation((XtendFunction) context);
			}
			return context;
		}

		protected int getIndentationLevelAtOffset(int offset, IDocument document) {
			try {
				if (offset <= 0)
					return 0;
				int currentOffset = offset - 1;
				char currentChr = document.getChar(currentOffset);
				int indentationOffset = 0;
				while (currentChr != '\n' && currentChr != '\r' && currentOffset > 0) {
					if (Character.isWhitespace(currentChr))
						++indentationOffset;
					else
						indentationOffset = 0;
					--currentOffset;
					currentChr = document.getChar(currentOffset);
				}
				return indentationOffset / indentation.getIndentString().length();
			} catch (BadLocationException e) {
				LOG.error("Error calculating indentation at offset", e);
			}
			return 0;
		}
	}

	private List<String> existingImports;

	private IXtextDocument document;

	private XtendFile xtendFile;

	private final WhitespaceHelper whitespaceHelper;

	public ReplacingAppendable(ImportManager importManager, String indentString, IXtextDocument document,
			XtendFile xtendFile, WhitespaceHelper whitespaceHelper) {
		super(importManager, indentString);
		this.document = document;
		this.xtendFile = xtendFile;
		this.whitespaceHelper = whitespaceHelper;
		existingImports = importManager.getImports();
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		if (whitespaceHelper.getPrefix() != null)
			b.append(whitespaceHelper.getPrefix().replace("\n", getIndentationString()));
		b.append(super.toString());
		if (whitespaceHelper.getSuffix() != null)
			b.append(whitespaceHelper.getSuffix().replace("\n", getIndentationString()));
		return b.toString();
	}

	public void commitChanges() throws BadLocationException {
		document.replace(whitespaceHelper.getTotalOffset(), whitespaceHelper.getTotalLength(), toString());
		insertNewImports();
	}

	public void insertNewImports() throws BadLocationException {
		List<String> newImports = getNewImports();
		if (!newImports.isEmpty()) {
			StringBuilder importSection = new StringBuilder();
			for (String newImport : newImports) {
				importSection.append("import ");
				importSection.append(newImport);
				importSection.append("\n");
			}
			int offset;
			if (xtendFile.getImports().isEmpty()) {
				offset = NodeModelUtils.findActualNodeFor(xtendFile.getXtendClass()).getOffset();
				importSection.append("\n");
			} else {
				ICompositeNode lastImportNode = NodeModelUtils.findActualNodeFor(xtendFile.getImports().get(
						xtendFile.getImports().size() - 1));
				importSection.insert(0, "\n");
				importSection.replace(importSection.length() - 1, importSection.length(), "");
				offset = lastImportNode.getOffset() + lastImportNode.getLength();
			}
			document.replace(offset, 0, importSection.toString());
		}
	}

	protected List<String> getNewImports() {
		List<String> imports = getImportManager().getImports();
		imports.removeAll(existingImports);
		return imports;
	}
}
