/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.ICommentAssociater;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.ICrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IEnumLiteralSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IKeywordSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IValueSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextLocation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * TODO: Extract WsMergerStream to a different class
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractParseTreeConstructor implements IParseTreeConstructor {

	public abstract class AbstractToken {
		protected final IEObjectConsumer eObjectConsumer;
		protected final AbstractToken lastRuleCallOrigin;
		protected final AbstractToken next;
		protected AbstractNode node;
		protected List<AbstractToken> tokensForSemanticChildren = Collections.emptyList();
		protected final int transitionIndex;

		public AbstractToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer currentSemanticElement) {
			this.next = next;
			this.lastRuleCallOrigin = parent;
			this.transitionIndex = no;
			this.eObjectConsumer = currentSemanticElement;
		}

		protected boolean checkForRecursion(Class<?> clazz, IEObjectConsumer curr) {
			AbstractToken token = next;
			while (token != null) {
				if (token.getClass() == clazz)
					return token.getEObjectConsumer() == curr;
				token = token.getNext();
			}
			return false;
		}

		public AbstractToken createFollower(int index, IEObjectConsumer inst) {
			return null;
		}

		public AbstractToken createFollowerAfterReturn(AbstractToken next, int actIndex, int index,
				IEObjectConsumer inst) {
			return null;
		}

		public String dumpTokens(int maxTokenCount, int maxStringLength, boolean appendDots) {
			ArrayList<String> tokensAsStrings = new ArrayList<String>();
			AbstractToken currentToken = this;
			while (currentToken != null && tokensAsStrings.size() <= maxTokenCount + 1) {
				String s = currentToken.serialize(null);
				if (s != null)
					tokensAsStrings.add(s);
				currentToken = currentToken.getNext();
			}
			boolean overdepth = tokensAsStrings.size() > maxTokenCount;
			if (overdepth)
				tokensAsStrings.remove(tokensAsStrings.size() - 1);
			StringBuffer result = new StringBuffer();
			for (int i = 0; i < tokensAsStrings.size(); i++) {
				result.append(tokensAsStrings.get(i));
				if (i != tokensAsStrings.size() - 1)
					result.append(" ");
			}
			boolean overlength = result.length() > maxStringLength;
			if (overlength)
				result.delete(maxStringLength + 1, result.length());
			if (appendDots && (overdepth || overlength))
				result.append("...");
			return result.toString();
		}

		public boolean equalsOrReplacesNode(AbstractNode node) {
			return false;
		}

		public EObject getEObject() {
			return eObjectConsumer.getEObject();
		}

		public IEObjectConsumer getEObjectConsumer() {
			return eObjectConsumer;
		}

		public abstract AbstractElement getGrammarElement();

		public AbstractToken getLastRuleCallOrigin() {
			return lastRuleCallOrigin;
		}

		public AbstractToken getNext() {
			return next;
		}

		public AbstractNode getNode() {
			return node;
		}

		public List<AbstractToken> getTokensForSemanticChildren() {
			return tokensForSemanticChildren;
		}

		public int getTransitionIndex() {
			return transitionIndex;
		}

		public final String serialize(AbstractNode node) {
			String result = serializeInternal(node);
			if (result != ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL)
				return result;
			if (node == null)
				throw new UnsupportedOperationException(
						"Can not keep value from Node Model when there is no Node Model. Context:" + this);
			else
				return tokenUtil.serializeNode(node);
		}

		protected String serializeInternal(AbstractNode node) {
			return null;
		}

		public void setNode(AbstractNode node) {
			this.node = node;
		}

		public IEObjectConsumer tryConsume() {
			return eObjectConsumer;
		}
	}

	public abstract class ActionToken extends AbstractToken {

		public ActionToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}
	}

	public abstract class AlternativesToken extends AbstractToken {
		public AlternativesToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}
	}

	public abstract class AssignmentToken extends AbstractToken {

		protected IEObjectConsumer consumed;

		protected AbstractElement element;

		protected AssignmentType type;

		protected Object value;

		public AssignmentToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}

		@Override
		public boolean equalsOrReplacesNode(AbstractNode node) {
			if (type == null)
				return false;
			switch (type) {
				case CROSS_REFERENCE:
					return crossRefSerializer.equalsOrReplacesNode(eObjectConsumer.getEObject(),
							(CrossReference) element, (EObject) value, node);
				case KEYWORD:
					return keywordSerializer.equalsOrReplacesNode(eObjectConsumer.getEObject(), ((Keyword) element),
							value, node);
				case TERMINAL_RULE_CALL:
					return valueSerializer.equalsOrReplacesNode(eObjectConsumer.getEObject(), (RuleCall) element,
							value, node);
				case ENUM_RULE_CALL:
					return enumLitSerializer.equalsOrReplacesNode(eObjectConsumer.getEObject(), (RuleCall) element,
							value, node);
				case PARSER_RULE_CALL:
					return false;
				case DATATYPE_RULE_CALL:
					return valueSerializer.equalsOrReplacesNode(eObjectConsumer.getEObject(), (RuleCall) element,
							value, node);
				default:
					return false;
			}
		}

		public AbstractElement getAssignmentElement() {
			return element;
		}

		public AssignmentType getType() {
			return type;
		}

		public Object getValue() {
			return value;
		}

		@Override
		protected String serializeInternal(AbstractNode node) {
			if (type == null)
				return null;
			switch (type) {
				case CROSS_REFERENCE:
					String ref = crossRefSerializer.serializeCrossRef(eObjectConsumer.getEObject(),
							(CrossReference) element, (EObject) value, node);
					if (ref == null) {
						Assignment ass = GrammarUtil.containingAssignment(element);
						throw new XtextSerializationException("Could not serialize cross reference from "
								+ EmfFormatter.objPath(eObjectConsumer.getEObject()) + "." + ass.getFeature() + " to "
								+ EmfFormatter.objPath((EObject) value));
					}
					return ref;
				case KEYWORD:
					return keywordSerializer.serializeAssignedKeyword(eObjectConsumer.getEObject(),
							((Keyword) element), value, node);
				case TERMINAL_RULE_CALL:
					return valueSerializer.serializeAssignedValue(eObjectConsumer.getEObject(), (RuleCall) element,
							value, node);
				case ENUM_RULE_CALL:
					return enumLitSerializer.serializeAssignedEnumLiteral(eObjectConsumer.getEObject(),
							(RuleCall) element, value, node);
				case PARSER_RULE_CALL:
					return null;
				case DATATYPE_RULE_CALL:
					return valueSerializer.serializeAssignedValue(eObjectConsumer.getEObject(), (RuleCall) element,
							value, node);
				default:
					return null;
			}
		}
	}

	public enum AssignmentType {
		CROSS_REFERENCE, DATATYPE_RULE_CALL, ENUM_RULE_CALL, KEYWORD, PARSER_RULE_CALL, TERMINAL_RULE_CALL
	}

	protected class CommentToken extends AbstractToken {

		public CommentToken(LeafNode node) {
			super(null, null, 0, null);
			setNode(node);
		}

		@Override
		public AbstractElement getGrammarElement() {
			return null;
		}
	}

	public abstract class GroupToken extends AbstractToken {
		public GroupToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}
	}

	public abstract class KeywordToken extends AbstractToken {

		public KeywordToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}

		@Override
		public boolean equalsOrReplacesNode(AbstractNode node) {
			return keywordSerializer.equalsOrReplacesNode(eObjectConsumer.getEObject(), (Keyword) getGrammarElement(),
					node);
		}

		@Override
		protected String serializeInternal(AbstractNode node) {
			return keywordSerializer.serializeUnassignedKeyword(eObjectConsumer.getEObject(),
					(Keyword) getGrammarElement(), node);
		}
	}

	public class RootToken extends AbstractToken {

		private RootToken(AbstractToken next, IEObjectConsumer inst) {
			super(null, next, 0, inst);
		}

		public RootToken(IEObjectConsumer inst) {
			super(null, null, 0, inst);
		}

		public boolean containsRuleCall() {
			return true;
		}

		@Override
		public AbstractToken createFollowerAfterReturn(AbstractToken next, int actIndex, int index, IEObjectConsumer i) {
			return index != 0 || !i.isConsumed() ? null : new RootToken(next, i);
		}

		@Override
		public AbstractElement getGrammarElement() {
			return null;
		}
	}

	public abstract class RuleCallToken extends AbstractToken {
		public RuleCallToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}
	}

	public abstract class UnassignedTextToken extends AbstractToken {

		public UnassignedTextToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}

		@Override
		public boolean equalsOrReplacesNode(AbstractNode node) {
			return valueSerializer.equalsOrReplacesNode(eObjectConsumer.getEObject(), (RuleCall) getGrammarElement(),
					node);
		}

		@Override
		protected String serializeInternal(AbstractNode node) {
			return valueSerializer.serializeUnassignedValue(eObjectConsumer.getEObject(),
					(RuleCall) getGrammarElement(), node);
		}
	}

	public abstract class UnorderedGroupToken extends AbstractToken {
		public UnorderedGroupToken(AbstractToken parent, AbstractToken next, int no, IEObjectConsumer current) {
			super(parent, next, no, current);
		}
	}

	protected class WsMergerStream {
		protected CompositeNode lastCompositeNode = null;
		protected int lastIndex = 0;

		protected ITokenStream out;

		@Inject
		protected HiddenAndTokenNodeIterator nodeIterator;

		public WsMergerStream(ITokenStream out) {
			super();
			this.out = out;
		}

		public void flush() throws IOException {
			List<LeafNode> whitespaces = Lists.newArrayList();
			if (nodeIterator != null) {
				while (nodeIterator.hasNext()) {
					AbstractNode nextNode = nodeIterator.next();
					if (tokenUtil.isToken(nextNode)) {
						whitespaces.clear();
						break;
					} else if (tokenUtil.isWhitespaceNode(nextNode))
						whitespaces.add((LeafNode) nextNode);
				}
			}
			for (LeafNode l : whitespaces) {
				//				System.out.println("WS: '" + l.getText() + "'");
				out.writeHidden(l.getGrammarElement(), l.getText());
			}
			out.flush();
			return;
		}

		public void writeComment(LeafNode comment) throws IOException {
			writeWhitespacesSince(comment);
			//			System.out.println("CM: '" + comment.getText() + "'");
			out.writeHidden(comment.getGrammarElement(), comment.getText());
		}

		public void writeSemantic(AbstractElement grammarElement, String value, AbstractNode node) throws IOException {
			writeWhitespacesSince(node);
			//			System.out.println("S:  '" + value + "'");
			out.writeSemantic(grammarElement, value);
		}

		protected void writeWhitespacesSince(AbstractNode node) throws IOException {
			if (node == null) {
				nodeIterator = null;
				return;
			}
			if (nodeIterator == null || !nodeIterator.hasNext()) {
				nodeIterator = new HiddenAndTokenNodeIterator(node, tokenUtil);
				return;
			}
			List<LeafNode> whitespaces = Lists.newArrayList();
			while (nodeIterator.hasNext()) {
				AbstractNode nextNode = nodeIterator.next();
				if (tokenUtil.isWhitespaceNode(nextNode)) {
					whitespaces.add((LeafNode) nextNode);
				} else if (nextNode == node) {
					if (whitespaces.isEmpty()) {
						// signal to the formatter not to insert a whitespace
						out.writeHidden(hiddenTokenHelper.getWhitespaceRuleFor(null, ""), "");
						//						System.out.println("WS: -nothing-");
					}
					for (LeafNode whitespace : whitespaces) {
						//						System.out.println("WS: '" + whitespace.getText() + "'");
						out.writeHidden(whitespace.getGrammarElement(), whitespace.getText());
					}
					return;
				} else {
					// unmatched semantic token node
					nodeIterator = new HiddenAndTokenNodeIterator(node, tokenUtil);
					return;
				}
			}
		}
	}

	@Inject
	protected ICommentAssociater commentAssociater;

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

	@Inject
	protected IEnumLiteralSerializer enumLitSerializer;

	@Inject
	protected IHiddenTokenHelper hiddenTokenHelper;

	@Inject
	protected IKeywordSerializer keywordSerializer;

	private final Logger log = Logger.getLogger(AbstractParseTreeConstructor.class);

	@Inject
	protected TokenUtil tokenUtil;

	@Inject
	protected ITransientValueService tvService;

	@Inject
	protected IValueSerializer valueSerializer;

	protected void assignComment(LeafNode comment, Map<EObject, AbstractToken> eObject2Token,
			Map<LeafNode, EObject> comments) {
		EObject container = comments.get(comment);
		if (container == null)
			return;
		AbstractToken token = eObject2Token.get(container);
		if (token != null) {
			for (int i = 0; i < token.getTokensForSemanticChildren().size(); i++) {
				AbstractToken t = token.getTokensForSemanticChildren().get(i);
				if ((t instanceof KeywordToken || t instanceof AssignmentToken) && t.getNode() == null) {
					token.getTokensForSemanticChildren().add(i, new CommentToken(comment));
					return;
				}
			}
			token.getTokensForSemanticChildren().add(new CommentToken(comment));
		}
	}

	protected void assignNodesByMatching(Map<EObject, AbstractToken> eObject2Token, CompositeNode rootNode,
			Map<LeafNode, EObject> comments) throws IOException {
		NodeIterator contents = new NodeIterator(rootNode);
		while (contents.hasNext()) {
			AbstractNode containedNode = contents.next();
			AbstractRule rule = containedNode.getGrammarElement() instanceof AbstractRule ? (AbstractRule) containedNode
					.getGrammarElement()
					: null;
			if (hiddenTokenHelper.isWhitespace(rule))
				continue;
			else if (containedNode instanceof LeafNode && hiddenTokenHelper.isComment(rule))
				assignComment((LeafNode) containedNode, eObject2Token, comments);
			else if (tokenUtil.isToken(containedNode)) {
				Pair<List<LeafNode>, List<LeafNode>> leadingAndTrailingHiddenTokens = tokenUtil
						.getLeadingAndTrailingHiddenTokens(containedNode);
				for (LeafNode leadingHiddenNode : leadingAndTrailingHiddenTokens.getFirst()) {
					if (tokenUtil.isCommentNode(leadingHiddenNode)) {
						assignComment(leadingHiddenNode, eObject2Token, comments);
					}
				}
				assignTokenByMatcher(containedNode, eObject2Token);
				for (LeafNode trailingHiddenNode : leadingAndTrailingHiddenTokens.getSecond()) {
					if (tokenUtil.isCommentNode(trailingHiddenNode)) {
						assignComment(trailingHiddenNode, eObject2Token, comments);
					}
				}
				contents.prune();
				CompositeNode parentNode = containedNode.getParent();
				while (parentNode != null && assignTokenDirect(parentNode, eObject2Token))
					parentNode = parentNode.getParent();
				if (containedNode.getOffset() > rootNode.getOffset() + rootNode.getLength()) {
					break;
				}
			}
		}
	}

	protected void assignTokenByMatcher(AbstractNode node, AbstractToken token, boolean recursive) {
		for (AbstractToken t : token.getTokensForSemanticChildren())
			if (recursive && t instanceof AssignmentToken)
				return;
			else if (t.getNode() == null && t.equalsOrReplacesNode(node)) {
				t.setNode(node);
				return;
			} else if (node.getGrammarElement() instanceof Keyword && t instanceof ActionToken)
				assignTokenByMatcher(node, t, true);
		return;
	}

	protected void assignTokenByMatcher(AbstractNode node, Map<EObject, AbstractToken> eObject2Token) {
		EObject owner = tokenUtil.getTokenOwner(node);
		if (owner == null)
			return;
		AbstractToken token = eObject2Token.get(owner);
		if (token != null)
			assignTokenByMatcher(node, token, false);
	}

	protected boolean assignTokenDirect(AbstractNode node, Map<EObject, AbstractToken> eObject2Token) {
		if (node.getElement() == null)
			return true;
		AbstractToken token = eObject2Token.get(node.getElement());
		if (token != null && token.getNode() == null) {
			token.setNode(node);
			return true;
		}
		return false;
	}

	protected void collectRootsAndEObjects(AbstractToken token, Map<EObject, AbstractToken> obj2token,
			Set<CompositeNode> roots) {
		CompositeNode node = NodeUtil.getNode(token.getEObjectConsumer().getEObject());
		if (node != null && !containsNodeOrAnyParent(roots, node)) {
			while (node.getParent() != null && node.getParent().getElement() == null)
				node = node.getParent();
			roots.add(node);
		}
		if (!token.getTokensForSemanticChildren().isEmpty()) {
			obj2token.put(token.getTokensForSemanticChildren().get(0).getEObjectConsumer().getEObject(), token);
			for (AbstractToken t : token.getTokensForSemanticChildren())
				if (!t.getTokensForSemanticChildren().isEmpty())
					collectRootsAndEObjects(t, obj2token, roots);
		}
	}

	protected boolean containsNodeOrAnyParent(Set<CompositeNode> nodes, AbstractNode node) {
		if (nodes.contains(node))
			return true;
		if (node.getParent() != null)
			return containsNodeOrAnyParent(nodes, node.getParent());
		return false;
	}

	protected IEObjectConsumer createEObjectConsumer(EObject obj) {
		return new EObjectConsumer(tvService, obj);
	}

	protected TreeConstructionReportImpl createReport(EObject root) {
		return new TreeConstructionReportImpl(root);
	}

	protected String debug(AbstractToken t, IEObjectConsumer i) {
		StringBuffer b = new StringBuffer(t.dumpTokens(10, 50, true));
		b.append(t.getClass().getSimpleName() + ":" + t.getTransitionIndex() + " -> " + i);
		return b.toString();
	}

	protected void dump(String indent, AbstractToken token) {
		System.out.println(indent + "begin " + token.getClass().getSimpleName() + " - "
				+ EmfFormatter.objPath(token.getEObjectConsumer().getEObject()) + " node:" + dumpNode(token.getNode()));
		String newIndent = indent + "\t";
		for (AbstractToken child : token.getTokensForSemanticChildren()) {
			if (child.getTokensForSemanticChildren().isEmpty())
				System.out.println(newIndent
						+ " -> "
						+ child.getClass().getSimpleName()
						+ " - "
						+ (child.getEObjectConsumer() == null ? "null" : EmfFormatter.objPath(child
								.getEObjectConsumer().getEObject())) + " node:" + dumpNode(child.getNode()));
			else
				dump(newIndent, child);
		}
		System.out.println(indent + "end");
	}

	protected String dumpNode(AbstractNode node) {
		if (node == null)
			return "null";
		return node.eClass().getName() + "'" + node.serialize().replace("\n", "\\n") + "' "
				+ Integer.toHexString(node.hashCode());
	}

	protected abstract AbstractToken getRootToken(IEObjectConsumer inst);

	protected AbstractToken serialize(EObject object, AbstractToken currentToken, TreeConstructionReportImpl rep) {
		if (object == null)
			throw new NullPointerException("The to-be-serialized EObject is null");
		IEObjectConsumer currentInstance = currentToken.getEObjectConsumer();
		int followerIndex = 0, depth = 0;
		boolean lastSuccess = true;
		while (currentToken != null) {
			AbstractToken nextToken = null;
			IEObjectConsumer nextInstance = null;
			if ((nextToken = currentToken.createFollower(followerIndex, currentInstance)) != null) {
				while (nextToken != null && (nextInstance = nextToken.tryConsume()) == null)
					nextToken = currentToken.createFollower(++followerIndex, currentInstance);
			}
			if (nextToken instanceof RootToken && nextToken.getNext() != null)
				return nextToken.getNext();
			if (nextToken != null && nextInstance != null) {
				if (log.isTraceEnabled())
					log.trace(debug(currentToken, currentInstance) + " -> found -> " + currentToken.serialize(null));
				currentToken = nextToken;
				currentInstance = nextInstance;
				followerIndex = 0;
				lastSuccess = true;
				depth++;
			} else {
				if (log.isTraceEnabled())
					log.trace(debug(currentToken, currentInstance) + " -> fail -> "
							+ (currentToken.getTransitionIndex() + 1));
				if (lastSuccess)
					rep.addDeadEnd(depth, currentToken);
				followerIndex = currentToken.getTransitionIndex() + 1;
				currentInstance = currentToken.getEObjectConsumer();
				currentToken = currentToken.getNext();
				lastSuccess = false;
				depth--;
			}
		}
		throw new XtextSerializationException(rep, "Serialization failed");
	}

	protected AbstractToken serialize(EObject object, TreeConstructionReportImpl rep) {
		if (object == null)
			throw new NullPointerException("The to-be-serialized EObject is null");
		AbstractToken root = getRootToken(createEObjectConsumer(object));
		AbstractToken first = serialize(object, root, rep);
		Map<EObject, List<AbstractToken>> semantic2token = Maps.newHashMap();
		AbstractToken t = first;
		while (t != null) {
			List<AbstractToken> tokens = semantic2token.get(t.getEObjectConsumer().getEObject());
			if (tokens == null)
				semantic2token.put(t.getEObjectConsumer().getEObject(), tokens = Lists.newArrayList());
			if (t.getLastRuleCallOrigin() != null)
				tokens.add(t);
			if (t.getNext() != null) {
				if (t.getNext().getLastRuleCallOrigin() == null)
					root.tokensForSemanticChildren = tokens;
				else if (t.getNext().getEObjectConsumer().getEObject() == t.getEObjectConsumer().getEObject()
						.eContainer())
					t.getNext().tokensForSemanticChildren = tokens;
			}
			t = t.getNext();
		}
		return root;
	}

	public TreeConstructionReport serializeSubtree(EObject object, ITokenStream out) throws IOException {
		TreeConstructionReportImpl report = createReport(object);
		AbstractToken root = serialize(object, report);
		Set<CompositeNode> roots = Sets.newHashSet();
		Map<EObject, AbstractToken> obj2token = Maps.newHashMap();
		collectRootsAndEObjects(root, obj2token, roots);
		//		dump("", root);
		Map<LeafNode, EObject> comments = commentAssociater.associateCommentsWithSemanticEObjects(object, roots);
		for (CompositeNode r : roots)
			assignNodesByMatching(obj2token, r, comments);
		WsMergerStream wsout = new WsMergerStream(out);
		//		dump("", root);
		//		System.out.println(EmfFormatter.objToStr(roots.iterator().next(),
		//				ParsetreePackage.Literals.ABSTRACT_NODE__TOTAL_LENGTH,
		//				ParsetreePackage.Literals.ABSTRACT_NODE__TOTAL_OFFSET,
		//				ParsetreePackage.Literals.ABSTRACT_NODE__TOTAL_LINE, ParsetreePackage.Literals.ABSTRACT_NODE__PARENT));
		TextLocation previousLocation = new TextLocation();
		write(root, wsout, previousLocation);
		wsout.flush();
		report.setPreviousLocation(previousLocation);
		return report;
	}

	protected void write(AbstractToken token, WsMergerStream out, TextLocation location) throws IOException {
		AbstractNode node = token.getNode();
		if (node != null) {
			location.merge(node.getOffset(), node.getLength());
		}
		if (!token.getTokensForSemanticChildren().isEmpty())
			for (AbstractToken t : token.getTokensForSemanticChildren())
				write(t, out, location);
		else {
			if (token instanceof CommentToken)
				out.writeComment((LeafNode) node);
			else {
				String val = token.serialize(node);
				if (val != null) {
					if (token instanceof AssignmentToken)
						out.writeSemantic(((AssignmentToken) token).getAssignmentElement(), val, node);
					else
						out.writeSemantic(token.getGrammarElement(), val, node);
				}
			}
		}
	}

	protected void writeComments(Iterable<LeafNode> comments, WsMergerStream out, Set<AbstractNode> consumedComments)
			throws IOException {
		for (LeafNode c : comments)
			if (consumedComments.add(c))
				out.writeComment(c);
	}
}
