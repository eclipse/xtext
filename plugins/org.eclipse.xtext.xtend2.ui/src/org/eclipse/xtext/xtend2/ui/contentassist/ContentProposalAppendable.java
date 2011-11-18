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
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ContentProposalAppendable extends StringBuilderBasedAppendable {

	public static class Factory {
		private static final Logger LOG = Logger.getLogger(ContentProposalAppendable.class);

		@Inject
		private IIndentationInformation indentation;

		@Inject
		private XbaseScopeProvider scopeProvider;

		@Inject
		private IQualifiedNameConverter converter;

		public ContentProposalAppendable get(IXtextDocument document, EObject context) {
			return get(document, context, -1);
		}

		public ContentProposalAppendable get(IXtextDocument document, EObject context, int offset) {
			try {
				XtendFile xtendFile = EcoreUtil2.getContainerOfType(context, XtendFile.class);
				if (xtendFile != null) {
					ImportManager importManager = new ImportManager(true);
					for (XtendImport xImport : xtendFile.getImports()) {
						if (xImport.getImportedType() != null) {
							importManager.addImportFor(xImport.getImportedType());
						}
					}
					ContentProposalAppendable appendable = new ContentProposalAppendable(importManager,
							indentation.getIndentString(), document, xtendFile);
					IScope scope = scopeProvider.createSimpleFeatureCallScope(context, 
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, context.eResource(), true, -1);
					appendable.openScope();
					for (IEObjectDescription feature : scope.getAllElements())
						appendable.declareVariable(feature, converter.toString(feature.getName()));
					for (int i = 0; i < getIndentationLevelAtOffset(offset, document); ++i)
						appendable.increaseIndentation();
					return appendable;
				}
			} catch (Exception exc) {
				LOG.error("Error initializing appendable", exc);
			}
			return null;
		}

		protected int getIndentationLevelAtOffset(int offset, IDocument document) throws BadLocationException {
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
		}
	}

	private List<String> existingImports;

	private IXtextDocument document;

	private XtendFile xtendFile;

	public ContentProposalAppendable(ImportManager importManager, String indentString, IXtextDocument document,
			XtendFile xtendFile) {
		super(importManager, indentString);
		this.document = document;
		this.xtendFile = xtendFile;
		existingImports = importManager.getImports();
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
