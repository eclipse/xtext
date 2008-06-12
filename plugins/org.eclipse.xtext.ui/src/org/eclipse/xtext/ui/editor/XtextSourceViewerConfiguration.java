/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.ContentFormatter;
import org.eclipse.jface.text.formatter.ContextBasedFormattingStrategy;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.texteditor.HippieProposalProcessor;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.codecompletion.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;
import org.eclipse.xtext.ui.editor.model.XtextEditorModelReconcileStrategy;
import org.eclipse.xtext.ui.service.IProposalsProvider;

/**
 * 
 * 
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextSourceViewerConfiguration extends TextSourceViewerConfiguration {
	private final IEditorModelProvider editorModelProvider;
	private final ILanguageDescriptor languageDescriptor;

	/**
	 * @param languageDescriptor
	 * @param preferenceStore
	 * @param editor
	 */
	public XtextSourceViewerConfiguration(ILanguageDescriptor languageDescriptor, IPreferenceStore preferenceStore,
			IEditorModelProvider editor) {
		super(preferenceStore);
		this.languageDescriptor = languageDescriptor;
		this.editorModelProvider = editor;
	}

	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer) {
		return new MonoReconciler(new XtextEditorModelReconcileStrategy(editorModelProvider), false);
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		IProposalsProvider proposalsProvider = ServiceRegistry.getService(languageDescriptor, IProposalsProvider.class);
		IContentAssistProcessor processor;
		if (proposalsProvider != null) {
			processor = new XtextContentAssistProcessor(editorModelProvider, proposalsProvider);
		}
		else {
			processor = new HippieProposalProcessor();
		}
		ContentAssistant ca = new ContentAssistant();
		ca.enableColoredLabels(true);
		ca.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
		ca.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
		ca.setProposalPopupOrientation(IContentAssistant.PROPOSAL_STACKED);
		ca.setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			@Override
			protected IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, false);
			}
		});
		return ca;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = (PresentationReconciler) super.getPresentationReconciler(sourceViewer);
		DefaultDamagerRepairer defDR = new DefaultDamagerRepairer(new XtextTokenScanner(languageDescriptor));
		reconciler.setRepairer(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setDamager(defDR, IDocument.DEFAULT_CONTENT_TYPE);
		return reconciler;
	}

	/*
	 * Just a little test
	 * 
	 * @see
	 * org.eclipse.jface.text.source.SourceViewerConfiguration#getContentFormatter
	 * (org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		ContentFormatter formatter = new ContentFormatter();
		formatter.enablePartitionAwareFormatting(false);
		formatter.setFormattingStrategy(new ContextBasedFormattingStrategy() {
			@Override
			public String format(String content, boolean start, String indentation, int[] positions) {
				tabs = 1;
				StringBuffer buffy = new StringBuffer();
				IEditorModel model = editorModelProvider.getModel();
				if (model != null && !model.hasErrors()) {
					appendNode(buffy, model.getParseTreeRootNode());
					return buffy.toString();
				}
				else
					return content;
			}

			private int tabs = 0;

			private void appendNode(StringBuffer buffy, EObject node) {
				String lineWrapper = "\n";
				String tab = "\t";
				if (node instanceof LeafNode && !isWhiteSpace(((LeafNode) node))) {
					LeafNode leafNode = (LeafNode) node;
					String text = leafNode.getText();
					if (text.endsWith(lineWrapper)) {
						text = text.substring(0, text.length() - 1);
					}
					boolean shouldWrapBefor = shouldWrapBefor(leafNode);
					int tabsToIdent = tabs;
					if (preventIdent(leafNode))
						tabsToIdent--;
					if (shouldWrapBefor) {
						buffy.append(lineWrapper);
						for (int i = 0; i < tabsToIdent; i++) {
							buffy.append(tab);
						}
					}
					buffy.append(text);
					boolean shouldWrapAfter = shouldWrapAfter(leafNode);
					if (shouldWrapAfter) {
						buffy.append(lineWrapper);
						for (int i = 0; i < tabsToIdent; i++) {
							buffy.append(tab);
						}
					}
					else {
						LeafNode nextNode = nextNode(leafNode.getParent(), leafNode);
						if (nextNode != null && !shouldWrapBefor(nextNode) && !shouldWrapAfter)
							buffy.append(" ");
					}
				}
				else if (node instanceof CompositeNode) {
					tabs--;
					CompositeNode cNode = (CompositeNode) node;
					boolean first = true;
					for (EObject child : cNode.eContents()) {
						appendNode(buffy, child);
						if (first && shouldIdent(cNode))
							tabs++;
						first = false;
					}
				}
			}

			private LeafNode nextNode(CompositeNode parent, LeafNode leafNode) {
				Iterator<LeafNode> iter = parent.getLeafNodes().listIterator(parent.getLeafNodes().indexOf(leafNode));
				iter.next();
				LeafNode retVal = null;
				for (; iter.hasNext();) {
					LeafNode current = iter.next();
					if (!isWhiteSpace(current)) {
						retVal = current;
						break;
					}
				}
				if (retVal == null && parent.getParent() != null) {
					EList<AbstractNode> children = parent.getParent().getChildren();
					ListIterator<AbstractNode> listIterator = children.listIterator(children.indexOf(parent));
					listIterator.next();
					if (listIterator.hasNext()) {
						AbstractNode nextParent = listIterator.next();
						for (LeafNode ln : nextParent.getLeafNodes()) {
							if (!isWhiteSpace(ln)) {
								retVal = ln;
								break;
							}
						}
					}
				}
				return retVal;
			}

			private boolean shouldIdent(CompositeNode node) {
				return true;
			}

			private boolean preventIdent(LeafNode node) {
				return "}".equals(node.getText());
			}

			private boolean isWhiteSpace(LeafNode ln) {
				return ln.isHidden() && ln.getGrammarElement() instanceof LexerRule
						&& "WS".equals(((LexerRule) ln.getGrammarElement()).getName());
			}

			private boolean shouldWrapAfter(LeafNode leafNode) {
				if (leafNode != null && (leafNode.isHidden() || "{".equals(leafNode.getText())))
					return true;
				return false;
			}

			private boolean shouldWrapBefor(LeafNode leafNode) {
				return "}".equals(leafNode.getText()) || "spielzeug".equals(leafNode.getText())
						|| "kind".equals(leafNode.getText());
			}

			@Override
			public void formatterStarts(String indentation) {
				super.formatterStarts(indentation);
			}
		}, IDocument.DEFAULT_CONTENT_TYPE);
		return formatter;
	}
}
