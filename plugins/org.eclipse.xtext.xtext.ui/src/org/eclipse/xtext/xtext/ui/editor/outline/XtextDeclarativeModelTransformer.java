/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;
import org.eclipse.xtext.util.Strings;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class XtextDeclarativeModelTransformer extends AbstractDeclarativeSemanticModelTransformer {

	private static final String UNKNOWN = "<unknown>";

	public ContentOutlineNode createNode(Grammar object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = super.newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel("grammar " + GrammarUtil.getLanguageId(object));
		return outlineNode;
	}

	public ContentOutlineNode createNode(GeneratedMetamodel object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = super.newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel("generate " + object.getName()
				+ (!Strings.isEmpty(object.getAlias()) ? " as " + object.getAlias() : ""));
		return outlineNode;
	}

	public ContentOutlineNode createNode(ReferencedMetamodel object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = super.newOutlineNode(object, outlineParentNode);
		String label = "";
		if (object.getAlias() != null)
			label = " " + object.getAlias();
		if (object.getEPackage() != null) {
			if (label.length() == 0)
				label = " " + object.getEPackage().getName();
			else
				label = " " + object.getEPackage().getName() + " as" + label;
		}
		if (label.length() == 0) {
			label = " " + UNKNOWN;
		}
		outlineNode.setLabel("import" + label);
		return outlineNode;
	}

	public ContentOutlineNode createNode(Assignment object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = super.newOutlineNode(object, outlineParentNode);
		StringBuffer label = new StringBuffer();
		label.append(object.getFeature()).append(" ").append(object.getOperator()).append(" ");

		AbstractElement terminal = object.getTerminal();
		if (terminal instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) terminal;
			String string = NodeUtil.getNodeAdapter(ruleCall).getParserNode().serialize();
			label.append(string);
		}
		else if (terminal instanceof Keyword) {
			Keyword keyword = (Keyword) terminal;
			String value = "'" + keyword.getValue() + "'";
			label.append(value);
		}
		else if (terminal instanceof CrossReference) {
			CrossReference crossReference = (CrossReference) terminal;
			label.append(getLabel(crossReference));
		}
		else {
			label.append("(..)");
		}

		String cardinality = object.getCardinality();
		label.append(cardinality != null ? cardinality : "");
		outlineNode.setLabel(label.toString());
		return outlineNode;
	}

	private String getLabel(RuleCall ruleCall) {
		if (ruleCall.getRule() != null) {
			return ruleCall.getRule().getName();
		}
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(ruleCall);
		String ruleName = UNKNOWN;
		if (nodeAdapter != null) {
			List<LeafNode> leafs = nodeAdapter.getParserNode().getLeafNodes();
			for (LeafNode leaf : leafs) {
				if (!leaf.isHidden()) {
					ruleName = leaf.getText();
					break;
				}
			}
		}
		return ruleName;
	}

	private String getLabel(CrossReference ref) {
		TypeRef type = ref.getType();
		String typeName = getClassifierName(type);
		if (ref.getTerminal() instanceof RuleCall)
			return "[" + typeName + "|" + getLabel((RuleCall) ref.getTerminal()) + "]";
		return "[" + typeName + "|..]";
	}

	private String getClassifierName(TypeRef ref) {
		String classifierName = UNKNOWN;
		if (ref != null) {
			if (ref.getClassifier() != null)
				classifierName = ref.getClassifier().getName();
			else {
				NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(ref);
				if (nodeAdapter != null) {
					List<LeafNode> leafs = nodeAdapter.getParserNode().getLeafNodes();
					for (int i = leafs.size() - 1; i >= 0; i--) {
						if (!leafs.get(i).isHidden()) {
							classifierName = leafs.get(i).getText();
							break;
						}
					}
				}
			}
		}
		return classifierName;
	}

	public ContentOutlineNode createNode(CrossReference object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = super.newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel(getLabel(object));
		return outlineNode;
	}

	public ContentOutlineNode createNode(AbstractRule object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = super.newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel(object.getName());
		return outlineNode;
	}

	public ContentOutlineNode createNode(RuleCall object, ContentOutlineNode outlineParentNode) {
		return HIDDEN_NODE;

		// ContentOutlineNode outlineNode = newOutlineNode(object,
		// outlineParentNode);
		// outlineNode.setLabel(getLabel(object));
		// // TODO show another icon, if unresolved
		// // TODO how to show text in another color?
		// return outlineNode;
	}

	public ContentOutlineNode createNode(Alternatives object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel("|");
		return outlineNode;
	}

	public ContentOutlineNode createNode(Action object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		String classifierName = getClassifierName(object.getType());
		outlineNode.setLabel("{" + classifierName + (object.getFeature() != null ? ("." + object.getFeature()) : "")
				+ "}");
		return outlineNode;
	}

	public ContentOutlineNode createNode(CharacterRange object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel(object.getLeft().getValue() + " .. " + object.getRight().getValue());
		return outlineNode;
	}

	public ContentOutlineNode createNode(NegatedToken object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel("!");
		return outlineNode;
	}

	public ContentOutlineNode createNode(UntilToken object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel("->");
		return outlineNode;
	}

	public ContentOutlineNode createNode(Wildcard object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel("*");
		return outlineNode;
	}

	public ContentOutlineNode createNode(Keyword object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		outlineNode.setLabel("'" + object.getValue() + "'");
		return outlineNode;
	}

	private String getLiteralName(EnumLiteralDeclaration declaration) {
		if (declaration.getEnumLiteral() != null) {
			return declaration.getEnumLiteral().getName();
		}
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(declaration);
		String literalName = UNKNOWN;
		if (nodeAdapter != null) {
			List<LeafNode> leafs = nodeAdapter.getParserNode().getLeafNodes();
			for (LeafNode leaf : leafs) {
				if (!leaf.isHidden()) {
					literalName = leaf.getText();
					break;
				}
			}
		}
		return literalName;
	}

	public ContentOutlineNode createNode(EnumLiteralDeclaration object, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = newOutlineNode(object, outlineParentNode);
		String literalName = getLiteralName(object);
		// TODO change color when literal could not be resolved
		Keyword kw = object.getLiteral();
		String kwValue = kw == null ? "" : " = '" + kw.getValue() + "'";
		outlineNode.setLabel(literalName + kwValue);
		return outlineNode;
	}

	public ContentOutlineNode createNode(Group object, ContentOutlineNode outlineParentNode) {
		return HIDDEN_NODE;
	}

	public ContentOutlineNode createNode(TypeRef object, ContentOutlineNode outlineParentNode) {
		return HIDDEN_NODE;
	}

	public List<EObject> getChildren(Assignment object) {
		if (object.getTerminal() instanceof Alternatives || object.getTerminal() instanceof CrossReference) {
			return getChildren(object.getTerminal());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(CrossReference object) {
		if (object.getTerminal() instanceof Alternatives) {
			return getChildren(object.getTerminal());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(EnumRule object) {
		if (isFilterActive(ParserRulesOutlineFilter.class)) {
			return NO_CHILDREN;
		}
		if (object.getAlternatives() instanceof Alternatives) {
			return getChildren(object.getAlternatives());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(TerminalRule object) {
		if (isFilterActive(ParserRulesOutlineFilter.class)) {
			return NO_CHILDREN;
		}
		return super.getChildren(object);
	}
	
	public List<EObject> getChildren(CharacterRange object) {
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(EnumLiteralDeclaration object) {
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(RuleCall object) {
		return NO_CHILDREN;
	}
	
	public List<EObject> getChildren(ParserRule object) {
		if (isFilterActive(ParserRulesOutlineFilter.class)) {
			return NO_CHILDREN;
		}
		return super.getChildren(object);
	}

}
