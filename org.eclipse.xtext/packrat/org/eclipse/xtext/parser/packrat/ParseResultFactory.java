/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.packrat.debug.DebugUtil;
import org.eclipse.xtext.parser.packrat.debug.ParsedTokenPrinter;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.tokens.CompoundParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.FakedToken;
import org.eclipse.xtext.parser.packrat.tokens.ParsedAction;
import org.eclipse.xtext.parser.packrat.tokens.ParsedEnumLiteral;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminalWithFeature;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminalWithFeatureInfo;
import org.eclipse.xtext.parser.packrat.tokens.ParsedToken;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParseResultFactory extends AbstractParsedTokenVisitor implements IParseResultFactory {

//	private CompositeNode currentNode;

	private final LinkedList<EObject> currentStack;

	@Inject
	private IAstFactory factory;

	private final LinkedList<ParsedNonTerminal> nonterminalStack;

//	private CharSequence input;

//	private EEnumLiteral lastEnumLiteral;

	public ParseResultFactory() {
		this.currentStack = new LinkedList<EObject>();
		this.nonterminalStack = new LinkedList<ParsedNonTerminal>();
	}

	@Override
	public IParseResult createParseResult(AbstractParsedToken token, CharSequence input) {
//		currentNode = null;
		currentStack.clear();
		nonterminalStack.clear();
//		this.input = input;
		if (DebugUtil.PARSE_RESULT_FACTORY_DEBUG) {
			IParsedTokenVisitor visitor = new CompoundParsedTokenVisitor(new ParsedTokenPrinter(), this);
			token.accept(visitor);
		} else {
			token.accept(this);
		}
		throw new UnsupportedOperationException();
//		this.input = null;
//		return new ParseResult(currentStack.isEmpty() ? null : currentStack.getLast(), null, false);
	}

//	private LeafNode createLeafNode(AbstractParsedToken parsedToken) {
//		LeafNode result = ParsetreeFactory.eINSTANCE.createLeafNode();
//		enhanceNode(parsedToken, result);
//		result.setText(parsedToken.getText(input).toString());
//		((InternalEList<AbstractNode>)currentNode.getChildren()).addUnique(result);
//		return result;
//	}

//	private void enhanceNode(AbstractParsedToken parsedToken, AbstractNode node) {
//		node.setTotalOffset(parsedToken.getOffset());
//		node.setTotalLength(parsedToken.getLength());
//	}

//	protected CompositeNode createCompositeNode(AbstractParsedToken parsedToken) {
//		CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
//		enhanceNode(parsedToken, compositeNode);
//		return compositeNode;
//	}

//	protected void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
//		if (node.getElement() != null && node.getElement() != astElement) {
//			throw new RuntimeException("Reassignment of astElement in parse tree node");
//		}
//		if (node.getElement() != astElement) {
//			node.setElement(astElement);
//			NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(astElement, AbstractNode.class);
//			adapter.setParserNode(node);
//		}
//	}

	@Override
	public void visitAbstractParsedToken(AbstractParsedToken token) {
		// no exception for now
	}

	@Override
	public void visitErrorToken(ErrorToken token) {
		if (token.isSkipped())
			return;
//		LeafNode errorNode = createLeafNode(token);
//		errorNode.setGrammarElement(token.getGrammarElement());
//		SyntaxError syntaxError = ParsetreeFactory.eINSTANCE.createSyntaxError();
//		syntaxError.setMessage(token.getErrorMessage() + "@" + token.getOffset());
//		errorNode.setSyntaxError(syntaxError);
	}

	@Override
	public void visitFakedToken(FakedToken token) {
		if (token.isSkipped())
			return;
		// TODO Auto-generated method stub
		super.visitFakedToken(token);
	}

	@Override
	public void visitParsedNonTerminal(ParsedNonTerminal token) {
		if (token.isSkipped())
			return;
		nonterminalStack.add(token);
		currentStack.add(null);

//		CompositeNode node = createCompositeNode(token);
//		node.setGrammarElement(token.getGrammarElement());
//		if (currentNode != null)
//			((InternalEList<AbstractNode>)currentNode.getChildren()).addUnique(node);
//		currentNode = node;
	}

	@Override
	public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
		if (token.isSkipped())
			return;
//		currentNode.setTotalLength(token.getOffset() - currentNode.getTotalOffset());
//		final ParsedNonTerminal nonTerminal = nonterminalStack.removeLast();
//		EObject created = currentStack.removeLast();
//		if (!token.isDatatype()) {
//			if (lastEnumLiteral == null) {
//				if (created == null) {
//					if (!token.isBoolean()) {
//						created = factory.create(nonTerminal.getType());
//						associateNodeWithAstElement(currentNode, created);
//					}
//				}
//			}
//			if (token.getFeature() == null) {
//				if (lastEnumLiteral != null)
//					throw new IllegalStateException("cannot parse enum literal and discard it");
//				if (currentStack.isEmpty())
//					currentStack.add(created);
//				else if (currentStack.getLast() == null) {
//					currentStack.set(currentStack.size() - 1, created);
//				} else {
//					throw new RuntimeException("Cannot discard created object");
//				}
//			} else {
//				final AbstractRule rule = getAbstractRule(nonTerminal);
//				if (rule == null)
//					throw new IllegalStateException("Unexpected grammar element '" + nonTerminal.getGrammarElement() + "'");
//				if (!token.isBoolean()) {
//					if (lastEnumLiteral == null)
//						setFeatureValue(token, created, rule);
//					else {
//						setFeatureValue(token, lastEnumLiteral.getInstance(), rule);
//						lastEnumLiteral = null;
//					}
//				} else
//					setFeatureValue(token, true, rule);
//			}
//		} else {
//			if (token.getFeature() != null && !(nonTerminal.getGrammarElement() instanceof CrossReference)) {
//				final AbstractRule rule = getAbstractRule(nonTerminal);
//				if (!token.isBoolean()) {
//					final StringBuilder builder = new StringBuilder(token.getLength());
//					final boolean[] wasHidden = new boolean[] {false};
//					readDatatypeValue(currentNode, builder, wasHidden);
//					setFeatureValue(token, builder.toString(), rule);
//				} else {
//					setFeatureValue(token, true, rule);
//				}
//			}
//		}
//		if (currentNode.getParent() != null) {
//			currentNode = currentNode.getParent();
//		}
	}

//	private AbstractRule getAbstractRule(final ParsedNonTerminal nonTerminal) {
//		return nonTerminal.getGrammarElement() instanceof AbstractRule ?
//				(AbstractRule)nonTerminal.getGrammarElement() :
//				((RuleCall)nonTerminal.getGrammarElement()).getRule();
//	}

//	private void setFeatureValue(ParsedNonTerminalEnd token, Object created, AbstractRule rule) {
//		EObject current = null;
//		if (currentStack.isEmpty()) {
//			throw new RuntimeException("Unexpected empty stack");
//		} else if (currentStack.getLast() == null) {
//			current = factory.create(nonterminalStack.getLast().getType());
////			associateNodeWithAstElement(currentNode.getParent(), current);
//			currentStack.set(currentStack.size() - 1, current);
//		} else {
//			current = currentStack.getLast();
//		}
//		try {
//			if (token.isMany()) {
//				factory.add(current, token.getFeature(), created, rule != null ? rule.getName() : null, null);
//			} else {
//				factory.set(current, token.getFeature(), created, rule != null ? rule.getName() : null, null);
//			}
//		} catch(ValueConverterException ex) {
//			handleValueConverterException(ex);
//		}
//	}

//	private void readDatatypeValue(AbstractNode node, final StringBuilder target, boolean[] wasHidden) {
//		 if (node instanceof LeafNode) {
//			 LeafNode leaf = (LeafNode) node;
//			 if (leaf.isHidden()) {
//				 if (!wasHidden[0]) {
//					 wasHidden[0] = true;
//					 if (target.length() != 0)
//						 target.append(' ');
//				 }
//			 } else {
//				 wasHidden[0] = false;
//				 target.append(leaf.getText());
//			 }
//		 } else {
//			 for(AbstractNode child: ((CompositeNode)node).getChildren()) {
//				 readDatatypeValue(child, target, wasHidden);
//			 }
//		 }
//	}

//	private void handleValueConverterException(ValueConverterException ex) {
//		Throwable cause = ex.getCause();
//		if (ex != cause) {
//			SyntaxError error = ParsetreeFactory.eINSTANCE.createSyntaxError();
//			if (ex.getNode() == null) {
//				currentNode.setSyntaxError(error);
//			} 
////			else {
////				ex.getNode().setSyntaxError(error);
////			}
//		} else
//			throw new RuntimeException(ex);
//	}

	@Override
	public void visitParsedEnumLiteral(ParsedEnumLiteral token) {
		if (token.isSkipped())
			return;
//		LeafNode node = createLeafNode(token);
//		node.setGrammarElement(token.getGrammarElement());
//		node.setHidden(false);
//		lastEnumLiteral = token.getGrammarElement().getEnumLiteral();
	}

	@Override
	public void visitParsedTerminal(ParsedTerminal token) {
		if (token.isSkipped())
			return;
//		LeafNode node = createLeafNode(token);
//		node.setGrammarElement(token.getGrammarElement());
//		node.setHidden(token.isHidden());
	}

	@Override
	public void visitParsedTerminalWithFeatureInfo(ParsedTerminalWithFeatureInfo token) {
		if (token.isSkipped())
			return;
//		LeafNode node = createLeafNode(token);
//		node.setGrammarElement(token.getGrammarElement());
//		node.setHidden(token.isHidden());
//		node.setFeature(token.getFeature());
	}

	@Override
	public void visitParsedTerminalWithFeature(ParsedTerminalWithFeature token) {
		if (token.isSkipped())
			return;
//		LeafNode node = createLeafNode(token);
//		node.setGrammarElement(token.getGrammarElement());
//		node.setFeature(token.getFeature());
//		node.setHidden(token.isHidden());
//
//		EObject current = null;
//		if (currentStack.isEmpty()) {
//			throw new RuntimeException("Unexpected empty stack");
//		} else if (currentStack.getLast() == null) {
//			current = factory.create(nonterminalStack.getLast().getType());
//			associateNodeWithAstElement(currentNode, current);
//			currentStack.set(currentStack.size() - 1, current);
//		} else {
//			current = currentStack.getLast();
//		}
//		try {
//			if (token.isMany()) {
//				factory.add(current, token.getFeature(), token.isBoolean() ? true : token.getText(input),
//						token.getGrammarElement() instanceof Keyword ? null : token.getRuleName(), null);
//			} else {
//				factory.set(current, token.getFeature(), token.isBoolean() ? true : token.getText(input),
//						token.getGrammarElement() instanceof Keyword ? null : token.getRuleName(), null);
//			}
//		} catch(ValueConverterException ex) {
//			handleValueConverterException(ex);
//		} catch(Exception ex) {
//			throw new RuntimeException(ex);
//		}
	}

	@Override
	public void visitParsedAction(ParsedAction token) {
		if (token.isSkipped())
			return;
		EObject newCurrent = factory.create(token.getType());
		EObject prevCurrent = currentStack.removeLast();
		currentStack.add(newCurrent);

		if (token.getFeature() != null) {
			try {
				if (token.isMany())
					factory.add(newCurrent, token.getFeature(), prevCurrent, null, null);
				else
					factory.set(newCurrent, token.getFeature(), prevCurrent, null, null);
			} catch(ValueConverterException ex) {
//				handleValueConverterException(ex);
			} catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		} else {
			if (prevCurrent != null)
				throw new IllegalStateException("Cannot throw away created current.");
		}

//		CompositeNode prevCurrentNode = currentNode;
//        currentNode = prevCurrentNode.getParent();
//        CompositeNode newCurrentNode = createCompositeNode(token);
//        prevCurrentNode.setParent(newCurrentNode);
//        if (currentNode != null)
//        	((InternalEList<AbstractNode>)currentNode.getChildren()).addUnique(newCurrentNode);
//	    newCurrentNode.setGrammarElement(token.getGrammarElement());
//	    associateNodeWithAstElement(newCurrentNode, newCurrent);
//        currentNode = newCurrentNode;
	}

	@Override
	public void visitParsedToken(ParsedToken token) {
		if (token.isSkipped())
			return;
		super.visitParsedToken(token);
	}

	public void setFactory(IAstFactory factory) {
		this.factory = factory;
	}

	public IAstFactory getFactory() {
		return factory;
	}

}
