/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.highlighting;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
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
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
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
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XConstructorCall;
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
 * @author Christian Schneider
 * 
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
	private AnonymousClassUtil anonymousClassUtil;

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
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (object.eClass().getEPackage() == XtendPackage.eINSTANCE) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			
			switch (object.eClass().getClassifierID()) {
				case XtendPackage.XTEND_CLASS:
					if (((XtendClass) object).isAbstract()) {
						highlightFeature(acceptor, object, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, ABSTRACT_CLASS);
					} else {
						highlightFeature(acceptor, object, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, CLASS);
					}
					break;
				case XtendPackage.XTEND_ENUM:
					highlightFeature(acceptor, object, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, ENUM);
					break;
				case XtendPackage.XTEND_INTERFACE:
					highlightFeature(acceptor, object, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, INTERFACE);
					break;
				case XtendPackage.XTEND_ANNOTATION_TYPE:
					highlightElement((XtendAnnotationType) object, acceptor, cancelIndicator);
					break;
				case XtendPackage.XTEND_FIELD:
					highlightElement((XtendField) object, acceptor, cancelIndicator);
					break;
				case XtendPackage.XTEND_CONSTRUCTOR:
					highlightElement((XtendConstructor) object, acceptor, cancelIndicator);
					break;
				case XtendPackage.XTEND_FUNCTION:
					highlightElement((XtendFunction) object, acceptor, cancelIndicator);
					break;
				case XtendPackage.XTEND_PARAMETER:
					if (!SPECIAL_FEATURE_NAMES.contains(((XtendParameter) object).getName())) {
						// highlighting of special identifiers is done separately, so it's omitted here 
						highlightFeature(acceptor, object, XtendPackage.Literals.XTEND_PARAMETER__NAME, PARAMETER_VARIABLE);
					}
					break;
				default:
					return super.highlightElement(object, acceptor, cancelIndicator);
			}
			
			highlightAnnotations(acceptor, (XtendAnnotationTarget) object);
			return false;
			
		} else {
			return super.highlightElement(object, acceptor, cancelIndicator);
		}
	}
	
	protected void highlightElement(XtendAnnotationType xtendType, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {		
		for(XAnnotation annotation: xtendType.getAnnotations()) {
			JvmType annotationType = annotation.getAnnotationType();
			if (annotationType != null && !annotationType.eIsProxy() && Active.class.getName().equals(annotationType.getIdentifier())) {
				highlightFeature(acceptor, annotation, XtendPackage.Literals.XTEND_TYPE_DECLARATION__NAME, ACTIVE_ANNOTATION);
				break;
			}
		}
	}
	
	protected void highlightElement(XtendField field, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {		
		highlightFeature(acceptor, field, XtendPackage.Literals.XTEND_FIELD__NAME, FIELD);
		
		if(field.isStatic()) {
			highlightFeature(acceptor, field, XtendPackage.Literals.XTEND_FIELD__NAME, STATIC_FIELD);
			
			if (field.isFinal()) {
				highlightFeature(acceptor, field, XtendPackage.Literals.XTEND_FIELD__NAME, STATIC_FINAL_FIELD);
			}
		}
		
		XExpression initializer = field.getInitialValue();
		highlightRichStrings(initializer, acceptor);
	}
	
	/**
	 * @since 2.12
	 */
	protected void highlightElement(XtendConstructor function, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		XExpression rootExpression = function.getExpression();
		highlightRichStrings(rootExpression, acceptor);
	}
	
	protected void highlightElement(XtendFunction function, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		highlightFeature(acceptor, function, XtendPackage.Literals.XTEND_FUNCTION__NAME, METHOD);
		XExpression rootExpression = function.getExpression();
		highlightRichStrings(rootExpression, acceptor);
		CreateExtensionInfo createExtensionInfo = function.getCreateExtensionInfo();
		if (createExtensionInfo != null) {
			highlightRichStrings(createExtensionInfo.getCreateExpression(), acceptor);
		}
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

	@Override
	protected void highlightConstructorCall(XConstructorCall constructorCall, IHighlightedPositionAcceptor acceptor) {
		if (constructorCall.eContainer() instanceof AnonymousClass) {
			final JvmGenericType superType = anonymousClassUtil.getSuperType((AnonymousClass) constructorCall.eContainer());
			if (superType != null) {
				highlightFeature(acceptor, constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, getStyle(superType));
			}
		} else {
			super.highlightConstructorCall(constructorCall, acceptor);
		}
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
				if (nameFeature!=null) {
					highlightFeature(acceptor, target, nameFeature, XbaseHighlightingStyles.DEPRECATED_MEMBERS);
				}
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
							pendingRegions.add(new TextRegion(currentOffset, Math.max(0, expectedOffset - currentOffset)));
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
				acceptor.addPosition(currentOffset, charCount, SEMANTIC_LINE_BREAK);
			currentOffset += charCount;
		}

		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			acceptor.addPosition(currentOffset, charCount, INSIGNIFICANT_TEMPLATE_TEXT);
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
