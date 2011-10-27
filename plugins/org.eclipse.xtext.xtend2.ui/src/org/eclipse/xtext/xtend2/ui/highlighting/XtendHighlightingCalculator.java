/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.highlighting;

import java.util.List;
import java.util.Queue;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingCalculator;
import org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.DefaultIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.services.Xtend2GrammarAccess;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendAnnotationTarget;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class XtendHighlightingCalculator extends XbaseHighlightingCalculator {

	@Inject
	private RichStringProcessor processor;

	@Inject
	private Provider<DefaultIndentationHandler> indentationHandlerProvider;

	private Keyword createKeyword;

	@Inject
	protected void setXtendGrammarAccess(Xtend2GrammarAccess grammarAccess) {
		this.createKeyword = grammarAccess.getValidIDAccess().getCreateKeyword_1();
	}

	@Override
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		XtendFile file = (XtendFile) resource.getContents().get(0);
		XtendClass xtendClass = file.getXtendClass();
		highlightDeprectedXtendAnnotationTarget(acceptor, xtendClass);
		if (xtendClass != null) {
			for (XtendMember member : xtendClass.getMembers()) {
				if (member.eClass() == Xtend2Package.Literals.XTEND_FUNCTION) {
					XtendFunction function = (XtendFunction) member;
					XExpression rootExpression = function.getExpression();
					highlightRichStrings(rootExpression, acceptor);
				}
				if(member.eClass() == Xtend2Package.Literals.XTEND_FIELD){
					XtendField field = (XtendField) member;
					highlightXtendField(field,acceptor);
				}
				highlightDeprectedXtendAnnotationTarget(acceptor, member);
			}
		}
		super.doProvideHighlightingFor(resource, acceptor);
	}

	@Override
	protected void highlightReferenceJvmType(IHighlightedPositionAcceptor acceptor, EObject referencer,
			EReference reference, EObject resolvedReferencedObject) {
		super.highlightReferenceJvmType(acceptor, referencer, reference, resolvedReferencedObject);
		// Highlight referenced JvmTypes only as deprecated when the eContainer of the referencer is a XtendClass
		// only reference to JvmTypes in extends or implements should be marked as it is in Java.
		if(referencer.eContainer() != null && referencer.eContainer().eClass() == Xtend2Package.Literals.XTEND_CLASS)
			if(resolvedReferencedObject instanceof JvmAnnotationTarget){
				if(DeprecationUtil.isDeprecated((JvmAnnotationTarget) resolvedReferencedObject))
					highlightObjectAtFeature(acceptor, referencer, reference, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
			}
	}
	
	protected void highlightDeprectedXtendAnnotationTarget(IHighlightedPositionAcceptor acceptor, EObject object){
		if(object != null && object instanceof XtendAnnotationTarget)
			for(XAnnotation annotation : ((XtendAnnotationTarget)object).getAnnotations()){
				JvmAnnotationType annotationType = annotation.getAnnotationType();
				if(annotationType != null && !annotationType.eIsProxy() && DeprecationUtil.isDeprecated(annotationType)){
					EStructuralFeature nameFeature = object.eClass().getEStructuralFeature("name");
					highlightObjectAtFeature(acceptor, object, nameFeature, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
				}
			}
	}

	protected void highlightRichStrings(XExpression expression, IHighlightedPositionAcceptor acceptor) {
		if (expression != null) {
			TreeIterator<EObject> iterator = EcoreUtil2.eAll(expression);
			while (iterator.hasNext()) {
				EObject object = iterator.next();
				if (object instanceof RichString) {
					RichStringHighlighter highlighter = createRichStringHighlighter(acceptor);
					processor.process((RichString) object, highlighter, indentationHandlerProvider.get());
					iterator.prune();
				}
			}
		}
	}

	protected RichStringHighlighter createRichStringHighlighter(IHighlightedPositionAcceptor acceptor) {
		return new RichStringHighlighter(acceptor);
	}

	@Override
	protected void highlightSpecialIdentifiers(ILeafNode leafNode, IHighlightedPositionAcceptor acceptor,
			TerminalRule idRule) {
		super.highlightSpecialIdentifiers(leafNode, acceptor, idRule);
		if (leafNode.getGrammarElement() == createKeyword) {
			acceptor.addPosition(leafNode.getOffset(), leafNode.getLength(),
					DefaultHighlightingConfiguration.DEFAULT_ID);
		}
	}
	

	protected void highlightXtendField(XtendField field, IHighlightedPositionAcceptor acceptor) {
		if(field.getName() != null && field.getName().length() > 0){
			List<INode> nodes = NodeModelUtils.findNodesForFeature(field, Xtend2Package.Literals.XTEND_FIELD__NAME);
			if(nodes.size() > 0)
				highlightNode(nodes.get(0), XbaseHighlightingConfiguration.FIELD, acceptor);
		}
	}

	protected class RichStringHighlighter extends AbstractRichStringPartAcceptor.ForLoopOnce {

		private int currentOffset = -1;
		private RichStringLiteral recent = null;
		private final IHighlightedPositionAcceptor acceptor;
		private Queue<IRegion> pendingRegions = Lists.newLinkedList();

		public RichStringHighlighter(IHighlightedPositionAcceptor acceptor) {
			this.acceptor = acceptor;
		}

		@Override
		public void announceNextLiteral(RichStringLiteral object) {
			resetCurrentOffset(object);
		}

		@Override
		public void acceptSemanticText(CharSequence text, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			currentOffset += text.length();
		}

		protected void resetCurrentOffset(RichStringLiteral origin) {
			if (origin != null && origin != recent) {
				INode recentNode = null;
				if (recent != null && currentOffset != -1) {
					List<INode> featureNodes = NodeModelUtils.findNodesForFeature(recent,
							XbasePackage.Literals.XSTRING_LITERAL__VALUE);
					if (featureNodes.size() == 1) {
						recentNode = featureNodes.get(0);
						int closingQuoteLength = 0;
						if (recentNode.getText().endsWith("'''")) {
							closingQuoteLength = 3;
						} else if (recentNode.getText().endsWith("''")) {
							closingQuoteLength = 2;
						} else if (recentNode.getText().endsWith("'") || recentNode.getText().endsWith("\u00AB")) {
							closingQuoteLength = 1;
						}
						int expectedOffset = recentNode.getTotalEndOffset() - closingQuoteLength;
						if (expectedOffset != currentOffset) {
							pendingRegions.add(new Region(currentOffset, expectedOffset - currentOffset));
						}
					}
				}
				List<INode> featureNodes = NodeModelUtils.findNodesForFeature(origin,
						XbasePackage.Literals.XSTRING_LITERAL__VALUE);
				if (featureNodes.size() == 1) {
					INode node = featureNodes.get(0);
					currentOffset = node.getOffset();
					if (node.getText().charAt(0) == '\'') {
						acceptor.addPosition(currentOffset, 3, XtendHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
						highlightClosingQuotes(node);
						currentOffset += 3;
					} else if (node.getText().startsWith("\u00AB\u00AB")) {
						String nodeText = node.getText();
						int length = nodeText.indexOf('\n');
						int start = node.getTotalOffset();
						if (length == -1) {
							length = node.getTotalLength();
						}
						if (recentNode != null && recentNode.getTotalEndOffset() == start) {
							acceptor.addPosition(start - 1, 1, DefaultHighlightingConfiguration.COMMENT_ID);
						}
						acceptor.addPosition(start, length, DefaultHighlightingConfiguration.COMMENT_ID);
						highlightClosingQuotes(node);
						currentOffset = start + length + 1;
					} else {
						highlightClosingQuotes(node);
						currentOffset += 1;
					}
				}
				recent = origin;
			}
		}

		protected void highlightClosingQuotes(INode node) {
			int length = 0;
			if (node.getText().endsWith("'''")) {
				length = 3;
			} else if (node.getText().endsWith("''")) {
				length = 2;
			} else if (node.getText().endsWith("'")) {
				length = 1;
			}
			if (length != 0) {
				acceptor.addPosition(currentOffset + node.getLength() - length, length,
						XtendHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
			}
		}

		@Override
		public void acceptTemplateText(CharSequence text, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			if (text.length() > 0) {
				int length = text.length();
				while (!pendingRegions.isEmpty()) {
					IRegion pending = pendingRegions.poll();
					length -= pending.getLength();
					acceptor.addPosition(pending.getOffset(), pending.getLength(),
							XtendHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
				}
				if (length != 0) {
					acceptor.addPosition(currentOffset, length, XtendHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
					currentOffset += length;
				}
			}
		}

		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			resetCurrentOffset(origin);
			if (controlStructureSeen)
				acceptor.addPosition(currentOffset, charCount, XtendHighlightingConfiguration.POTENTIAL_LINE_BREAK);
			else
				acceptor.addPosition(currentOffset, charCount, XtendHighlightingConfiguration.TEMPLATE_LINE_BREAK);
			currentOffset += charCount;
		}

		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			currentOffset += charCount;
		}

		@Override
		public void acceptIfCondition(XExpression condition) {
			highlightRichStrings(condition, acceptor);
		}

		@Override
		public void acceptElseIfCondition(XExpression condition) {
			highlightRichStrings(condition, acceptor);
		}

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
			highlightRichStrings(expression, acceptor);
			super.acceptForLoop(parameter, expression);
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			highlightRichStrings(expression, acceptor);
		}
	}

}
