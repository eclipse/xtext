/**
 * Copyright (c) 2018, 2020 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class SemanticHighlightingCalculatorImpl extends DefaultSemanticHighlightingCalculator {
	private static final String IDENTIFIER_STYLE = "identifier";

	private static final String PRIMITIVE_TYPE_STYLE = "primitiveType";

	private static final String TYPE_STYLE = "type";

	private static final String TYPE_DECLARATION_STYLE = "typeDeclaration";

	private static final String PARAMETER_NAME_STYLE = "parameterName";

	private static final String OP_BODY_STYLE = "opBody";

	public static final Set<String> STYLES = Sets.newHashSet(IDENTIFIER_STYLE, PRIMITIVE_TYPE_STYLE, TYPE_STYLE,
			TYPE_DECLARATION_STYLE, PARAMETER_NAME_STYLE, OP_BODY_STYLE);

	@Override
	protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		if (object instanceof Operation) {
			return doHighlightOperation((Operation) object, acceptor);
		} else if (object instanceof PrimitiveType) {
			return doHighlightPrimitiveType((PrimitiveType) object, acceptor);
		} else if (object instanceof Property) {
			return doHighlightProperty((Property) object, acceptor);
		} else if (object instanceof TypeDeclaration) {
			return doHighlightTypeDeclaration((TypeDeclaration) object, acceptor);
		} else if (object instanceof TypeReference) {
			return doHighlightTypeReference((TypeReference) object, acceptor);
		} else if (object instanceof Parameter) {
			return doHighlightParameter((Parameter) object, acceptor);
		} else {
			return false;
		}
	}

	protected boolean doHighlightProperty(Property it, IHighlightedPositionAcceptor acceptor) {
		return doHighlightNode(acceptor, it, TestLanguagePackage.Literals.MEMBER__NAME, IDENTIFIER_STYLE);
	}

	protected boolean doHighlightOperation(Operation it, IHighlightedPositionAcceptor acceptor) {
		boolean canStop = doHighlightNode(acceptor, it, TestLanguagePackage.Literals.MEMBER__NAME, IDENTIFIER_STYLE);
		ICompositeNode opNode = NodeModelUtils.findActualNodeFor(it);
		if (opNode != null) {
			List<ILeafNode> inverseChildren = Lists.reverse(
					Lists.newArrayList(Iterables.filter(opNode.getLeafNodes(), (ILeafNode n) -> !n.isHidden())));
			int endOffset = -1;
			int startOffset = -1;
			ILeafNode first = Iterables.getFirst(inverseChildren, null);
			String text = null;
			if (first != null) {
				text = first.getText();
			}
			if ("}".equals(text)) {
				endOffset = first.getEndOffset() - 1;
			}
			if (endOffset != -1) {
				ILeafNode opStartNode = IterableExtensions.findFirst(inverseChildren,
						c -> "{".equals(c.getText().trim()));
				if (opStartNode != null) {
					startOffset = opStartNode.getOffset() + 1;
				}
			}
			if (startOffset >= 0 && endOffset >= 0) {
				acceptor.addPosition(startOffset, endOffset - startOffset, OP_BODY_STYLE);
			}
		}
		return canStop;
	}

	protected boolean doHighlightTypeDeclaration(TypeDeclaration it, IHighlightedPositionAcceptor acceptor) {
		return doHighlightNode(acceptor, it, TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME,
				TYPE_DECLARATION_STYLE);
	}

	protected boolean doHighlightPrimitiveType(PrimitiveType it, IHighlightedPositionAcceptor acceptor) {
		return doHighlightNode(acceptor, it, TestLanguagePackage.Literals.PRIMITIVE_TYPE__NAME, PRIMITIVE_TYPE_STYLE);
	}

	protected boolean doHighlightTypeReference(TypeReference it, IHighlightedPositionAcceptor acceptor) {
		return doHighlightNode(acceptor, it, TestLanguagePackage.Literals.TYPE_REFERENCE__TYPE_REF, TYPE_STYLE);
	}

	protected boolean doHighlightParameter(Parameter it, IHighlightedPositionAcceptor acceptor) {
		return doHighlightNode(acceptor, it, TestLanguagePackage.Literals.PARAMETER__NAME, PARAMETER_NAME_STYLE);
	}

	public boolean doHighlightNode(IHighlightedPositionAcceptor acceptor, EObject object, EStructuralFeature feature,
			String style) {
		NodeModelUtils.findNodesForFeature(object, feature).forEach((INode it) -> {
			acceptor.addPosition(it.getOffset(), it.getLength(), style);
		});
		return false;
	}

}
