/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.editor.syntaxcoloring

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.util.CancelIndicator

import static org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage.Literals.*

class SemanticHighlightingCalculatorImpl extends DefaultSemanticHighlightingCalculator {

	static val IDENTIFIER_STYLE = 'identifier';
	static val PRIMITIVE_TYPE_STYLE = 'primitiveType';
	static val TYPE_STYLE = 'type';
	static val TYPE_DECLARATION_STYLE = 'typeDeclaration';
	static val PARAMETER_NAME_STYLE = 'parameterName';
	static val OP_BODY_STYLE = 'opBody';

	public static val STYLES = #{
		IDENTIFIER_STYLE,
		PRIMITIVE_TYPE_STYLE,
		TYPE_STYLE,
		TYPE_DECLARATION_STYLE,
		PARAMETER_NAME_STYLE,
		OP_BODY_STYLE
	};

	override protected highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
		CancelIndicator cancelIndicator) {

		return object.doHighlightElement(acceptor);
	}

	def dispatch boolean doHighlightElement(EObject it, IHighlightedPositionAcceptor acceptor) {
		return false;
	}

	def dispatch boolean doHighlightElement(Property it, IHighlightedPositionAcceptor acceptor) {
		return acceptor.doHighlightNode(it, MEMBER__NAME, IDENTIFIER_STYLE);
	}

	def dispatch boolean doHighlightElement(Operation it, IHighlightedPositionAcceptor acceptor) {
		val canStop = acceptor.doHighlightNode(it, MEMBER__NAME, IDENTIFIER_STYLE);
		// Besides highlighting the name of the operation, we highlight the body between the braces (exclusive)
		// to ensure, we can map a single multi-line range into several corresponding highlighting tokens.
		val opNode = NodeModelUtils.findActualNodeFor(it)
		if (opNode !== null) {
			val inverseChildren = opNode.leafNodes.filter[!hidden].toList.reverse;
			var endOffset = -1;
			var startOffset = -1;
			if (inverseChildren.head?.text == '}') {
				endOffset = inverseChildren.head.endOffset - 1; // exclusive
			}
			if (endOffset !== -1) {
				val opStartNode = inverseChildren.findFirst[text.trim == '{'];
				if (opStartNode !== null) {
					startOffset = opStartNode.offset + 1; // exclusive
				}
			}
			if (startOffset >= 0 && endOffset >= 0) {
				acceptor.addPosition(startOffset, endOffset - startOffset, OP_BODY_STYLE);
			}
		}
		return canStop;
	}

	def dispatch boolean doHighlightElement(TypeDeclaration it, IHighlightedPositionAcceptor acceptor) {
		return acceptor.doHighlightNode(it, ABSTRACT_ELEMENT__NAME, TYPE_DECLARATION_STYLE);
	}

	def dispatch boolean doHighlightElement(PrimitiveType it, IHighlightedPositionAcceptor acceptor) {
		return acceptor.doHighlightNode(it, PRIMITIVE_TYPE__NAME, PRIMITIVE_TYPE_STYLE);
	}

	def dispatch boolean doHighlightElement(TypeReference it, IHighlightedPositionAcceptor acceptor) {
		return acceptor.doHighlightNode(it, TYPE_REFERENCE__TYPE_REF, TYPE_STYLE);
	}

	def dispatch boolean doHighlightElement(Parameter it, IHighlightedPositionAcceptor acceptor) {
		return acceptor.doHighlightNode(it, PARAMETER__NAME, PARAMETER_NAME_STYLE);
	}

	def doHighlightNode(IHighlightedPositionAcceptor acceptor, EObject object, EStructuralFeature feature,
		String style) {

		NodeModelUtils.findNodesForFeature(object, feature).forEach [
			acceptor.addPosition(offset, length, style)
		];
		return false;
	}

}
