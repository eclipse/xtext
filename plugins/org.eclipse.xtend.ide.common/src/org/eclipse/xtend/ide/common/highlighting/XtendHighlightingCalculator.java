/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.common.highlighting;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingCalculator;
import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 * @since 2.9
 */
public class XtendHighlightingCalculator extends XbaseHighlightingCalculator implements XtendHighlightingStyles {

	@Inject
	private RichStringProcessor processor;

	@Inject
	private Provider<DefaultIndentationHandler> indentationHandlerProvider;

	private Set<Keyword> contextualKeywords;
	
	@Inject
	private XtendGrammarAccess xtendGrammarAccess;

	@Inject
	protected void setXtendGrammarAccess(IGrammarAccess grammarAccess) {
		ImmutableSet.Builder<Keyword> builder = ImmutableSet.builder();
		collectKeywordsFromRule(grammarAccess, "ValidID", builder);
		collectKeywordsFromRule(grammarAccess, "FeatureCallID", builder);
		collectKeywordsFromRule(grammarAccess, "InnerVarID", builder);
		contextualKeywords = builder.build();
	}

	@Override
	protected TerminalRule getIDRule() {
		return xtendGrammarAccess.getIDRule();
	}
	
	protected void collectKeywordsFromRule(IGrammarAccess grammarAccess, String ruleName, ImmutableSet.Builder<Keyword> builder) {
		AbstractRule rule = GrammarUtil.findRuleForName(grammarAccess.getGrammar(), ruleName);
		if (!(rule instanceof TerminalRule)) { // if someone decides to override ValidID with a terminal rule
			Iterator<EObject> i = rule.eAllContents();
			while (i.hasNext()) {
				EObject o = i.next();
				if (o instanceof Keyword) {
					builder.add((Keyword) o);
				}
			}
		}
	}

	@Override
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		XtendFile file = (XtendFile) resource.getContents().get(0);
		for (XtendTypeDeclaration xtendType : file.getXtendTypes()) {
			highlightAnnotations(acceptor, xtendType);
			highlightMembers(xtendType, acceptor);
		}
		super.doProvideHighlightingFor(resource, acceptor, cancelIndicator);
	}

	protected void highlightMembers(XtendTypeDeclaration xtendType, IHighlightedPositionAcceptor acceptor) {
		for (XtendMember member : xtendType.getMembers()) {
			if (member.eClass() == XtendPackage.Literals.XTEND_FUNCTION) {
				XtendFunction function = (XtendFunction) member;
				XExpression rootExpression = function.getExpression();
				highlightRichStrings(rootExpression, acceptor);
				CreateExtensionInfo createExtensionInfo = function.getCreateExtensionInfo();
				if (createExtensionInfo != null) {
					highlightRichStrings(createExtensionInfo.getCreateExpression(), acceptor);
				}
			}
			if(member.eClass() == XtendPackage.Literals.XTEND_FIELD){
				XtendField field = (XtendField) member;
				highlightXtendField(field,acceptor);
				XExpression initializer = field.getInitialValue();
				highlightRichStrings(initializer, acceptor);
			}
			if (member instanceof XtendTypeDeclaration) {
				highlightMembers((XtendTypeDeclaration) member, acceptor);
			}
			highlightAnnotations(acceptor, member);
		}
		if (xtendType instanceof XtendAnnotationType) {
			for(XAnnotation annotation: xtendType.getAnnotations()) {
				JvmType annotationType = annotation.getAnnotationType();
				if (annotationType != null && !annotationType.eIsProxy() && Active.class.getName().equals(annotationType.getIdentifier())) {
					highlightFeature(acceptor, xtendType, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, ACTIVE_ANNOTATION);
					break;
				}
			}
		}
	}
	
	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (object instanceof AnonymousClass) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			highlightMembers((XtendTypeDeclaration) object, acceptor);
			return false;
		}
		return super.highlightElement(object, acceptor, cancelIndicator);
	}

	protected void highlightAnnotations(IHighlightedPositionAcceptor acceptor, XtendAnnotationTarget target) {
		if(target != null){
			for(XAnnotation annotation: target.getAnnotations()) {
				highlightRichStrings(annotation, acceptor);
				highlightDeprecatedXtendAnnotationTarget(acceptor, target, annotation);
			}
		}
	}

	@Override
	protected void highlightAnnotation(XAnnotation annotation, IHighlightedPositionAcceptor acceptor) {
		JvmType annotationType = annotation.getAnnotationType();
		if (annotationType instanceof JvmAnnotationTarget) {
			for(JvmAnnotationReference annotationReference: ((JvmAnnotationTarget) annotationType).getAnnotations()) {
				JvmAnnotationType otherAnnotation = annotationReference.getAnnotation();
				if (otherAnnotation != null && !otherAnnotation.eIsProxy() && Active.class.getName().equals(otherAnnotation.getIdentifier())) {
					highlightAnnotation(annotation, acceptor, ACTIVE_ANNOTATION);
					return;
				}
			}
		}
		super.highlightAnnotation(annotation, acceptor);
	}

	protected void highlightDeprecatedXtendAnnotationTarget(IHighlightedPositionAcceptor acceptor, XtendAnnotationTarget target, XAnnotation annotation){
		JvmType annotationType = annotation.getAnnotationType();
		if(annotationType instanceof JvmAnnotationType && DeprecationUtil.isDeprecatedAnnotation((JvmAnnotationType) annotationType)){
			if (target instanceof XtendConstructor) {
				ICompositeNode compositeNode = NodeModelUtils.getNode(target);
				for(ILeafNode leaf: compositeNode.getLeafNodes()) {
					if (leaf.getGrammarElement() == xtendGrammarAccess.getMemberAccess().getNewKeyword_2_2_2()) {
						highlightNode(acceptor, leaf, XbaseHighlightingStyles.DEPRECATED_MEMBERS);
						highlightNode(acceptor, leaf, HighlightingStyles.KEYWORD_ID);
						return;
					}
				}
			} else {
				EStructuralFeature nameFeature = target.eClass().getEStructuralFeature("name");
				highlightFeature(acceptor, target, nameFeature, XbaseHighlightingStyles.DEPRECATED_MEMBERS);
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
		if (contextualKeywords != null && contextualKeywords.contains(leafNode.getGrammarElement())) {
			ITextRegion leafRegion = leafNode.getTextRegion();
			acceptor.addPosition(leafRegion.getOffset(), leafRegion.getLength(),
					HighlightingStyles.DEFAULT_ID);
		}
	}
	

	protected void highlightXtendField(XtendField field, IHighlightedPositionAcceptor acceptor) {
		if(field.getName() != null && field.getName().length() > 0){
			List<INode> nodes = NodeModelUtils.findNodesForFeature(field, XtendPackage.Literals.XTEND_FIELD__NAME);
			if(nodes.size() > 0){
				INode node = nodes.get(0);
				if(field.isStatic())
					highlightNode(acceptor, node, XbaseHighlightingStyles.STATIC_FIELD);
				else
					highlightNode(acceptor, node, XbaseHighlightingStyles.FIELD);
			}
		}
	}

	protected class RichStringHighlighter extends AbstractRichStringPartAcceptor.ForLoopOnce {

		private int currentOffset = -1;
		private RichStringLiteral recent = null;
		private final IHighlightedPositionAcceptor acceptor;
		private Queue<ITextRegion> pendingRegions = Lists.newLinkedList();

		public RichStringHighlighter(IHighlightedPositionAcceptor acceptor) {
			this.acceptor = acceptor;
		}

		@Override
		public void announceNextLiteral(RichStringLiteral object) {
			resetCurrentOffset(object);
		}

		@Override
		public void acceptSemanticText(CharSequence text, /* @Nullable */ RichStringLiteral origin) {
			resetCurrentOffset(origin);
			currentOffset += text.length();
		}

		protected void resetCurrentOffset(/* @Nullable */ RichStringLiteral origin) {
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
							pendingRegions.add(new TextRegion(currentOffset, expectedOffset - currentOffset));
						}
					}
				}
				List<INode> featureNodes = NodeModelUtils.findNodesForFeature(origin,
						XbasePackage.Literals.XSTRING_LITERAL__VALUE);
				if (featureNodes.size() == 1) {
					INode node = featureNodes.get(0);
					currentOffset = node.getOffset();
					if (node.getText().charAt(0) == '\'') {
						acceptor.addPosition(currentOffset, 3, INSIGNIFICANT_TEMPLATE_TEXT);
						highlightClosingQuotes(node);
						currentOffset += 3;
					} else if (node.getText().startsWith("\u00AB\u00AB")) {
						String nodeText = node.getText();
						int lineFeed = nodeText.indexOf('\n');
						int length = lineFeed; 
						int carriageReturn = nodeText.indexOf('\r');
						if (carriageReturn != -1) {
							if (length == -1) {
								length = carriageReturn;
							} else {
								length = Math.min(carriageReturn, length);
							}
						}
						int start = node.getTotalOffset();
						if (length == -1) {
							length = node.getTotalLength();
						}
						if (recentNode != null && recentNode.getTotalEndOffset() == start) {
							start = start - 1;
							length = length + 1;
						}
						acceptor.addPosition(start, length, HighlightingStyles.COMMENT_ID);
						highlightClosingQuotes(node);
						currentOffset = start + length + 1;
						if (lineFeed == carriageReturn + 1)
							currentOffset++;
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
						INSIGNIFICANT_TEMPLATE_TEXT);
			}
		}

		@Override
		public void acceptTemplateText(CharSequence text, /* @Nullable */ RichStringLiteral origin) {
			resetCurrentOffset(origin);
			if (text.length() > 0) {
				int length = text.length();
				while (!pendingRegions.isEmpty()) {
					ITextRegion pending = pendingRegions.poll();
					length -= pending.getLength();
					acceptor.addPosition(pending.getOffset(), pending.getLength(),
							INSIGNIFICANT_TEMPLATE_TEXT);
				}
				if (length != 0) {
					acceptor.addPosition(currentOffset, length, INSIGNIFICANT_TEMPLATE_TEXT);
					currentOffset += length;
				}
			}
		}

		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			resetCurrentOffset(origin);
			if (controlStructureSeen)
				acceptor.addPosition(currentOffset, charCount, POTENTIAL_LINE_BREAK);
			else
				acceptor.addPosition(currentOffset, charCount, TEMPLATE_LINE_BREAK);
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
		public void acceptForLoop(JvmFormalParameter parameter, /* @Nullable */ XExpression expression) {
			highlightRichStrings(expression, acceptor);
			super.acceptForLoop(parameter, expression);
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			highlightRichStrings(expression, acceptor);
		}
	}

}
