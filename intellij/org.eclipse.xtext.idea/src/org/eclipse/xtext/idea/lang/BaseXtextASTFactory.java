/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement;
import org.eclipse.xtext.psi.impl.LeafXtextPsiReferenceElement;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.google.inject.Inject;
import com.intellij.lang.DefaultASTFactoryImpl;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl;
import com.intellij.psi.tree.IElementType;

public class BaseXtextASTFactory extends DefaultASTFactoryImpl {

	@Inject
	private TokenTypeProvider tokenTypeProvider;

	@Override
	public CompositeElement createComposite(IElementType type) {
		if (type instanceof CreateElementType) {
			CreateElementType userDataElementType = (CreateElementType) type;
			CompositeElement composite = createComposite(userDataElementType.getElementType());
			userDataElementType.getCreateCallback().onCreate(composite);
			return composite;
		}
		return super.createComposite(type);
	}

	@Override
	public LeafElement createLeaf(IElementType type, CharSequence text) {
		if (type instanceof CreateElementType) {
			CreateElementType userDataElementType = (CreateElementType) type;
			LeafElement leafElement = createLeaf(userDataElementType.getElementType(), text);
			userDataElementType.getCreateCallback().onCreate(leafElement);
			return leafElement;
		}
		LeafElement leafElement = doCreateLeaf(type, text);
		leafElement.putUserData(IASTNodeAwareNodeModelBuilder.TOKEN_TYPE_KEY, type);
		return leafElement;
	}

	protected LeafElement doCreateLeaf(IElementType type, CharSequence text) {
		if (isWhitespace(type)) {
			return createWhitespace(type, text);
		}
		if (isComment(type)) {
			return createComment(type, text);
		}
		if (isCrossReference(type)) {
			return createCrossReference(type, text);
		}
		return new LeafXtextPsiElement(type, text);
	}

	protected boolean isComment(IElementType type) {
		return tokenTypeProvider.getCommentTokens().contains(type);
	}

	protected boolean isWhitespace(IElementType type) {
		return tokenTypeProvider.getWhitespaceTokens().contains(type);
	}
	
	protected boolean isCrossReference(IElementType type) {
		if (type instanceof IGrammarAwareElementType) {
			IGrammarAwareElementType grammarAwareElementType = (IGrammarAwareElementType) type;
			return grammarAwareElementType.getGrammarElement() instanceof CrossReference;
		}
		return false;
	}

	protected LeafElement createWhitespace(IElementType type, CharSequence text) {
		return new PsiWhiteSpaceImpl(text);
	}

	protected LeafElement createCrossReference(IElementType type, CharSequence text) {
		return new LeafXtextPsiReferenceElement(type, text);
	}

}
