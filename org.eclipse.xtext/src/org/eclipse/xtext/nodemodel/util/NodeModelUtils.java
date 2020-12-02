/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.InternalNodeModelUtils;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.LineAndColumn;

import com.google.common.collect.Lists;

/**
 * The NodeModelUtils are a collection of useful methods when dealing with the node model directly. They encapsulate the
 * default construction semantics of the node model as it is created by the parser.
 * 
 * This API is quite low level and internal functionality of the framework relies on the implemented contracts.
 * Clients should rather use the language specific APIs that provide almost the same functionality, e.g.
 * {@link ILocationInFileProvider} and {@link EObjectAtOffsetHelper} if they want to access the region
 * of a {@link EObject semantic object}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelUtils extends InternalNodeModelUtils {

	/**
	 * Find the leaf node at the given offset. May return <code>null</code> if the given offset is not valid for the
	 * node (sub-)tree.
	 * 
	 * A node matches the <code>leafNodeOffset</code> if it fulfills the following condition:
	 * <pre>
	 *  node.totalOffset &lt;= leafNodeOffset &amp;&amp;
	 *  node.totalEndOffset &gt; leafNodeOffset 
	 * </pre>
	 * 
	 * @param node the container node. May not be <code>null</code>.
	 * @param leafNodeOffset the offset that is covered by the searched node.
	 * @return the leaf node at the given offset or <code>null</code>.
	 */
	/* @Nullable */
	public static ILeafNode findLeafNodeAtOffset(/* @NonNull */ INode node, int leafNodeOffset) {
		INode localNode = node;
		while(!(localNode instanceof AbstractNode)) {
			localNode = localNode.getParent();
		}
		int offset = localNode.getTotalOffset();
		int length = localNode.getTotalLength();
		BidiTreeIterator<AbstractNode> iterator = ((AbstractNode) localNode).basicIterator();
		if (leafNodeOffset > (offset + length) / 2) {
			while (iterator.hasPrevious()) {
				AbstractNode previous = iterator.previous();
				int previousOffset = previous.getTotalOffset();
				int previousLength = previous.getTotalLength();
				if (!intersects(previousOffset, previousLength, leafNodeOffset)) {
					if (previousOffset + previousLength <= leafNodeOffset) {
						return null;
					}
					iterator.prune();
				} else {
					if (previous instanceof ILeafNode)
						return (ILeafNode) previous;
				}
			}
		} else {
			while (iterator.hasNext()) {
				AbstractNode next = iterator.next();
				int nextOffset = next.getTotalOffset();
				int nextLength = next.getTotalLength();
				if (!intersects(nextOffset, nextLength, leafNodeOffset)) {
					if (nextOffset > leafNodeOffset) {
						return null;
					}
					iterator.prune();
				} else {
					if (next instanceof ILeafNode)
						return (ILeafNode) next;
				}
			}
		}
		return null;
	}
	
	/**
	 * Compute the line and column information at the given offset from any node that belongs to the document. The line is one-based, e.g.
	 * the first line has the line number '1'. The line break belongs to the line that it breaks. In other words, the first line break in the
	 * document also has the line number '1'. The column number starts at '1', too. In effect, the document offset '0' will always return
	 * line '1' and column '1'.
	 * 
	 * If the given documentOffset points exactly to {@code anyNode.root.text.length}, it's assumed to be a virtual character thus
	 * the offset is valid and the column and line information is returned as if it was there.
	 * 
	 * This contract is in sync with {@link org.eclipse.emf.ecore.resource.Resource.Diagnostic}.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the document offset does not belong to the document, 
	 *             {@code documentOffset < 0 || documentOffset > anyNode.rootNode.text.length}
	 */
	public static LineAndColumn getLineAndColumn(INode anyNode, int documentOffset) {
		// special treatment for inconsistent nodes such as SyntheticLinkingLeafNode
		if (anyNode.getParent() == null && !(anyNode instanceof RootNode)) {
			return LineAndColumn.from(1,1);
		}
		return InternalNodeModelUtils.getLineAndColumn(anyNode, documentOffset);
	}

	private static boolean intersects(int offset, int length, int lookupOffset) {
		if (offset <= lookupOffset && offset + length > lookupOffset)
			return true;
		return false;
	}

	/**
	 * Returns the node that is directly associated with the given object by means of an EMF-Adapter.
	 * 
	 * @param object the semantic object whose direct node should be provided.
	 * @return the node that is directly associated with the given object.
	 * @see NodeModelUtils#findActualNodeFor(EObject)
	 */
	/* @Nullable */
	public static ICompositeNode getNode(/* @Nullable */ EObject object) {
		if (object == null)
			return null;
		List<Adapter> adapters = object.eAdapters();
		for (int i = 0; i < adapters.size(); i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof ICompositeNode)
				return (ICompositeNode) adapter;
		}
		return null;
	}

	/**
	 * Returns the list of nodes that were used to assign values to the given feature for the given object.
	 * 
	 * @return the list of nodes that were used to assign values to the given feature for the given object.
	 */
	/* @NonNull */
	public static List<INode> findNodesForFeature(EObject semanticObject, EStructuralFeature structuralFeature) {
		ICompositeNode node = findActualNodeFor(semanticObject);
		if (node != null && structuralFeature != null) {
			return findNodesForFeature(semanticObject, node, structuralFeature);
		}
		return Collections.emptyList();
	}

	private static List<INode> findNodesForFeature(EObject semanticElement, INode node,
			EStructuralFeature structuralFeature) {
		List<INode> result = Lists.newArrayList();
		String featureName = structuralFeature.getName();
		BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
		while (iterator.hasNext()) {
			INode child = iterator.next();
			EObject grammarElement = child.getGrammarElement();
			if (grammarElement != null) {
				if (grammarElement instanceof Action) {
					Action action = (Action) grammarElement;
					if (child.getSemanticElement() == semanticElement) {
						child = iterator.next();
						if (featureName.equals(action.getFeature())) {
							result.add(child);
						}
					} else {
						// navigate the action's left side (first child) until we find an assignment (a rule call)
						// the assignment will tell us about the feature to which we assigned
						// the semantic object that has been created by the action
						INode firstChild = ((ICompositeNode) child).getFirstChild();
						while (firstChild.getGrammarElement() instanceof Action) {
							firstChild = ((ICompositeNode) firstChild).getFirstChild();
						}
						EObject firstChildGrammarElement = firstChild.getGrammarElement();
						Assignment assignment = GrammarUtil.containingAssignment(firstChildGrammarElement);
						if (assignment != null && featureName.equals(assignment.getFeature())) {
							result.add(child);
						}
					}
					iterator.prune();
				} else if (child != node) {
					Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
					if (assignment != null) {
						if (featureName.equals(assignment.getFeature())) {
							result.add(child);
						}
						iterator.prune();
					}
				}
			}
		}
		return result;
	}

	/**
	 * <p>Returns the node that covers all assigned values of the given object. It handles the semantics of {@link Action
	 * actions} and {@link RuleCall unassigned rule calls}. The returned node will include unassigned surrounding leafs,
	 * e.g. if you use something like {@code Parenthesized expressions} redundant parentheses will be part of the returned node.</p>
	 * <p>Consider the following simple expression (a number literal): 
	 * <pre>
	 *   ((1))
	 * </pre>
	 * Assuming it was parsed from a grammar like this:
	 * <pre>
	 * Expression: Number | Parentheses;
	 * Parentheses: '(' Expression ')';
	 * Number: value=INT
	 * </pre>
	 * The actual node for the only semantic object that was produced from the input {@code ((1))} is the root node 
	 * even though the minimal node would be the one with the text {@code 1}.
	 * 
	 * @param semanticObject the semantic object whose node should be provided.
	 * @return the node that covers all assigned values of the given object.
	 */
	/* @Nullable */
	public static ICompositeNode findActualNodeFor(/* @Nullable */ EObject semanticObject) {
		ICompositeNode node = getNode(semanticObject);
		if (node != null) {
			while(GrammarUtil.containingAssignment(node.getGrammarElement()) == null) {
				ICompositeNode parent = node.getParent();
				if (parent != null && !parent.hasDirectSemanticElement() && !GrammarUtil.isEObjectFragmentRuleCall(parent.getGrammarElement())) {
					node = parent;
				} else {
					break;
				}
			}
		}
		return node;
	}

	/**
	 * Returns the semantic object that is really associated with the actual container node of the given node. It
	 * handles the structural semantics that results from {@link Action Actions} and {@link RuleCall unassigned rule
	 * calls}.
	 * 
	 * @return the semantic object that is really associated with the actual container node of the given node.
	 */
	/* @Nullable */
	public static EObject findActualSemanticObjectFor(/* @Nullable */ INode node) {
		if (node == null)
			return null;
		if (node.hasDirectSemanticElement())
			return node.getSemanticElement();
		EObject grammarElement = node.getGrammarElement();
		ICompositeNode parent = node.getParent();
		if (grammarElement == null)
			return findActualSemanticObjectFor(parent);
		Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
		if (assignment != null) {
			if (GrammarUtil.isEObjectFragmentRule(GrammarUtil.containingRule(assignment))) {
				EObject result = findActualSemanticObjectInChildren(node, grammarElement);
				if (result != null)
					return result;
			}
			if (parent.hasDirectSemanticElement())
				return findActualSemanticObjectFor(parent);
			INode sibling = parent.getFirstChild();
			while(!sibling.equals(node)) {
				EObject siblingGrammarElement = sibling.getGrammarElement();
				if (siblingGrammarElement != null && GrammarUtil.containingAssignment(siblingGrammarElement) == null) {
					if (GrammarUtil.isEObjectRuleCall(siblingGrammarElement)) {
						return findActualSemanticObjectFor(sibling);
					}
					if (siblingGrammarElement.eClass() == XtextPackage.Literals.ACTION) {
						return findActualSemanticObjectFor(sibling);
					}
				}
				sibling = sibling.getNextSibling();
			}
		} else if (!GrammarUtil.isEObjectFragmentRuleCall(grammarElement)) {
			EObject result = findActualSemanticObjectInChildren(node, grammarElement);
			if (result != null)
				return result;
		}
		return findActualSemanticObjectFor(parent);
	}

	/* @Nullable */
	private static EObject findActualSemanticObjectInChildren(/* @NonNull */ INode node, /* @Nullable */ EObject grammarElement) {
		if (node.hasDirectSemanticElement())
			return node.getSemanticElement();
		AbstractRule rule = null;
		if (grammarElement instanceof RuleCall) {
			rule = ((RuleCall) grammarElement).getRule();
		} else if (grammarElement instanceof AbstractRule) {
			rule = (AbstractRule) grammarElement;
		}
		if (rule instanceof ParserRule && !GrammarUtil.isDatatypeRule(rule)) {
			if (node instanceof ICompositeNode) {
				for (INode child : ((ICompositeNode) node).getChildren()) {
					if (child instanceof ICompositeNode) {
						EObject childGrammarElement = child.getGrammarElement();
						if (childGrammarElement instanceof Action) {
							EObject result = findActualSemanticObjectInChildren(child, childGrammarElement);
							if (result != null)
								return result;
						} else if (childGrammarElement instanceof RuleCall) {
							RuleCall childRuleCall = (RuleCall) childGrammarElement;
							if (childRuleCall.getRule() instanceof ParserRule
									&& !GrammarUtil.isDatatypeRule(childRuleCall.getRule())) {
								EObject result = findActualSemanticObjectInChildren(child, childRuleCall);
								if (result != null)
									return result;
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Creates a string representation of the given node. Useful for debugging.
	 * 
	 * @return a debug string for the given node.
	 */
	public static String compactDump(INode node, boolean showHidden) {
		StringBuilder result = new StringBuilder();
		try {
			compactDump(node, showHidden, "", result);
		} catch (IOException e) {
			return e.getMessage();
		}
		return result.toString();
	}

	private static void compactDump(INode node, boolean showHidden, String prefix, Appendable result)
			throws IOException {
		if (!showHidden && node instanceof ILeafNode && ((ILeafNode) node).isHidden())
			return;
		if (prefix.length() != 0) {
			result.append("\n");
			result.append(prefix);
		}
		if (node instanceof ICompositeNode) {
			if (node.getGrammarElement() != null)
				result.append(new GrammarElementTitleSwitch().showAssignments().doSwitch(node.getGrammarElement()));
			else
				result.append("(unknown)");
			String newPrefix = prefix + "  ";
			result.append(" {");
			BidiIterator<INode> children = ((ICompositeNode) node).getChildren().iterator();
			while (children.hasNext()) {
				INode child = children.next();
				compactDump(child, showHidden, newPrefix, result);
			}
			result.append("\n");
			result.append(prefix);
			result.append("}");
			SyntaxErrorMessage error = node.getSyntaxErrorMessage();
			if (error != null)
				result.append(" SyntaxError: [" + error.getIssueCode() + "] " + error.getMessage());
		} else if (node instanceof ILeafNode) {
			if (((ILeafNode) node).isHidden())
				result.append("hidden ");
			if (node.getGrammarElement() != null)
				result.append(new GrammarElementTitleSwitch().showAssignments().doSwitch(node.getGrammarElement()));
			else
				result.append("(unknown)");
			result.append(" => '");
			result.append(node.getText());
			result.append("'");
			SyntaxErrorMessage error = node.getSyntaxErrorMessage();
			if (error != null)
				result.append(" SyntaxError: [" + error.getIssueCode() + "] " + error.getMessage());
		} else if (node == null) {
			result.append("(null)");
		} else {
			result.append("unknown type ");
			result.append(node.getClass().getName());
		}
	}

	/**
	 * This method converts a node to text.
	 * 
	 * Leading and trailing text from hidden tokens (whitespace/comments) is removed. Text from hidden tokens that is
	 * surrounded by text from non-hidden tokens is summarized to a single whitespace.
	 * 
	 * The preferred use case of this method is to convert the {@link ICompositeNode} that has been created for a data
	 * type rule to text.
	 * 
	 * This is also the recommended way to convert a node to text if you want to invoke
	 * {@link org.eclipse.xtext.conversion.IValueConverterService#toValue(String, String, INode)}
	 * 
	 */
	public static String getTokenText(INode node) {
		if (node instanceof ILeafNode)
			return ((ILeafNode) node).getText();
		else {
			StringBuilder builder = new StringBuilder(Math.max(node.getTotalLength(), 1));
			boolean hiddenSeen = false;
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					if (hiddenSeen && builder.length() > 0)
						builder.append(' ');
					builder.append(leaf.getText());
					hiddenSeen = false;
				} else {
					hiddenSeen = true;
				}
			}
			return builder.toString();
		}
	}
	
	public static ParserRule getEntryParserRule(INode node) {
		ICompositeNode root = node.getRootNode();
		EObject ge1 = root.getGrammarElement();
		if (ge1 instanceof ParserRule) {
			return (ParserRule) ge1;
		} else if (ge1 instanceof Action) {
			INode firstChild = root.getFirstChild();
			while (firstChild.getGrammarElement() instanceof Action && firstChild instanceof CompositeNode) {
				firstChild = ((CompositeNode)firstChild).getFirstChild();
			}
			EObject ge2 = firstChild.getGrammarElement();
			if (ge2 instanceof ParserRule) {
				return (ParserRule) ge2;
			}
		}
		throw new IllegalStateException("No Root Parser Rule found; The Node Model is broken.");
	}

}
