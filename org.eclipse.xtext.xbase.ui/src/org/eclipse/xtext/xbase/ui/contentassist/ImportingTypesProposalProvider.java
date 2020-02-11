/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.xtext.ui.JdtTypesProposalProvider;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal.IReplacementTextApplier;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.scoping.batch.StaticExtensionFeatureDescription;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - moved from Xtend to Xbase
 */
public class ImportingTypesProposalProvider extends JdtTypesProposalProvider {

	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	
	@Inject
	private ReplaceConverter replaceConverter;

	@Override
	protected IReplacementTextApplier createTextApplier(ContentAssistContext context, IScope typeScope,
			IQualifiedNameConverter qualifiedNameConverter, IValueConverter<String> valueConverter) {
		if (EcoreUtil2.getContainerOfType(context.getCurrentModel(), XImportSection.class) != null)
			return null;
		return new FQNImporter(context.getResource(), context.getViewer(), typeScope, qualifiedNameConverter,
				valueConverter, importSectionFactory, replaceConverter);
	}

	public static class FQNImporter extends FQNShortener {

		private static final Logger LOG = Logger.getLogger(FQNImporter.class);
		private final ITextViewer viewer;

		private RewritableImportSection.Factory importSectionFactory;

		private ReplaceConverter replaceConverter;
		
		public FQNImporter(Resource context, ITextViewer viewer, IScope scope,
				IQualifiedNameConverter qualifiedNameConverter, IValueConverter<String> valueConverter, 
				RewritableImportSection.Factory importSectionFactory,
				ReplaceConverter replaceConverter) {
			super(context, scope, qualifiedNameConverter, valueConverter);
			this.viewer = viewer;
			this.importSectionFactory = importSectionFactory;
			this.replaceConverter = replaceConverter;
		}

		@Override
		public void apply(IDocument document, ConfigurableCompletionProposal proposal) throws BadLocationException {
			String proposalReplacementString = proposal.getReplacementString();
			String typeName = proposalReplacementString;
			if (valueConverter != null)
				typeName = valueConverter.toValue(proposalReplacementString, null);
			String replacementString = getActualReplacementString(proposal);
			// there is an import statement - apply computed replacementString
			if (!proposalReplacementString.equals(replacementString)) {
				String shortTypeName = replacementString;
				if (valueConverter != null)
					shortTypeName = valueConverter.toValue(replacementString, null);
				QualifiedName shortQualifiedName = qualifiedNameConverter.toQualifiedName(shortTypeName);
				if (shortQualifiedName.getSegmentCount() == 1) {
					proposal.setCursorPosition(replacementString.length());
					if (!replacementString.equals(document.get(proposal.getReplacementOffset(), proposal.getReplacementLength()))) {
						document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(),
								replacementString);
					}
					return;
				}
			}
			String typeNameInScope = typeName;
			// ReplacementString might have brackets if it's a JVMExecutable
			int indexOfBracket = typeName.lastIndexOf("(");
			if(indexOfBracket > -1) {
				typeNameInScope = typeName.substring(0, indexOfBracket);
			}
			QualifiedName qualifiedNameInScope = qualifiedNameConverter.toQualifiedName(typeNameInScope);
			// we could create an import statement if there is no conflict
			QualifiedName qualifiedName = qualifiedNameConverter.toQualifiedName(typeName);
			IEObjectDescription description = scope.getSingleElement(qualifiedNameInScope.skipFirst(qualifiedNameInScope
					.getSegmentCount() - 1));
			IEObjectDescription typeToImport = scope.getSingleElement(qualifiedNameInScope);
			if (description != null) {
				if (typeToImport != null && !description.getEObjectURI().equals(typeToImport.getEObjectURI())) {
					// there exists a conflict - insert fully qualified name
					proposal.setCursorPosition(proposalReplacementString.length());
					document.replace(proposal.getReplacementOffset(), proposal.getReplacementLength(), proposalReplacementString);
					return;
				}
			}

			// Import does not introduce ambiguities - add import and insert short name
			String shortName = qualifiedName.getLastSegment();
			int topPixel = -1;
			// store the pixel coordinates to prevent the ui from flickering
			StyledText widget = viewer.getTextWidget();
			if (widget != null)
				topPixel = widget.getTopPixel();
			ITextViewerExtension viewerExtension = null;
			if (viewer instanceof ITextViewerExtension) {
				viewerExtension = (ITextViewerExtension) viewer;
				viewerExtension.setRedraw(false);
			}
			
			RewritableImportSection importSection = importSectionFactory.parse((XtextResource) context);
			if(typeToImport == null) {
				LOG.error("Could not find unique type named '" + notNull(qualifiedName) + "' in scope");
				if (viewerExtension != null)
					viewerExtension.setRedraw(true);
				return;
			}
			EObject resolved = EcoreUtil.resolve(typeToImport.getEObjectOrProxy(), context);
			// In case we want to import a static JvmFeature - https://github.com/eclipse/xtext-xtend/issues/677
			if(resolved instanceof JvmFeature) {
				JvmFeature operation = (JvmFeature) resolved;
				if(operation.isStatic()) {
					EObject container = operation.eContainer();
					if(container instanceof JvmDeclaredType) {
						JvmDeclaredType type = (JvmDeclaredType) container;
						if(description instanceof StaticExtensionFeatureDescription) {
							importSection.addStaticExtensionImport(type.getQualifiedName(), operation.getSimpleName());
						} else {
							importSection.addStaticImport(type.getQualifiedName(), operation.getSimpleName());
						}
					}
				}
			} else {
				Assert.isTrue(!resolved.eIsProxy() && resolved instanceof JvmDeclaredType);
				importSection.addImport((JvmDeclaredType) resolved);
			}
			DocumentRewriteSession rewriteSession = null;
			try {
				if (document instanceof IDocumentExtension4) {
					rewriteSession = ((IDocumentExtension4) document)
							.startRewriteSession(DocumentRewriteSessionType.UNRESTRICTED_SMALL);
				}
				// apply short proposal
				String escapedShortname = shortName;
				
				if(indexOfBracket > -1) {
					if (valueConverter != null) {
						escapedShortname = valueConverter.toString(typeNameInScope) + shortName.substring(indexOfBracket);
					}
					proposal.setCursorPosition(escapedShortname.length()-1);
				} else {
					if (valueConverter != null) {
						escapedShortname = valueConverter.toString(shortName);
					}
					proposal.setCursorPosition(escapedShortname.length());
				}
				int initialCursorLine = document.getLineOfOffset(proposal.getReplacementOffset());
				ReplaceEdit replaceEdit = new ReplaceEdit(proposal.getReplacementOffset(), proposal.getReplacementLength(), escapedShortname);

				// add import statement
				List<ReplaceRegion> importChanges = importSection.rewrite();
				TextEdit textEdit = replaceConverter.convertToTextEdit(importChanges);
				if (textEdit != null) {
					MultiTextEdit compound = new MultiTextEdit();
					compound.addChild(textEdit);
					compound.addChild(replaceEdit);
					textEdit = compound;
				} else {
					textEdit = replaceEdit;
				}
				textEdit.apply(document);
				// delta caused by the newly introduced imports
				int deltaLength = replaceConverter.getReplaceLengthDelta(importChanges, proposal.getSelectionStart());
				// shift offset by deltaLength
				proposal.shiftOffset(deltaLength);
				int newCursorLine = document.getLineOfOffset(proposal.getCursorPosition());

				// set the pixel coordinates
				if (widget != null) {
					int additionalTopPixel = (newCursorLine - initialCursorLine) * widget.getLineHeight();
					widget.setTopPixel(topPixel + additionalTopPixel);
				}
			} finally {
				if (rewriteSession != null) {
					((IDocumentExtension4) document).stopRewriteSession(rewriteSession);
				}
				if (viewerExtension != null)
					viewerExtension.setRedraw(true);
			}
		}
	}

}
