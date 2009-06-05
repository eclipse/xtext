/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.transformer.DefaultSemanticModelTransformer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class XtextSemanticModelTransformer extends DefaultSemanticModelTransformer {

	private static final String UNKNOWN = "<unknown>";

	@Override
	public boolean consumeSemanticNode(EObject semanticNode) {
		if (semanticNode != null) {
			return new XtextSwitch<Boolean>() {
				@Override
				public Boolean caseTypeRef(org.eclipse.xtext.TypeRef object) {
					return false;
				}

				@Override
				public Boolean caseGroup(org.eclipse.xtext.Group object) {
					return false;
				}

				@Override
				public Boolean defaultCase(EObject object) {
					return true;
				}
			}.doSwitch(semanticNode);
		}
		return false;
	}

	@Override
	public boolean consumeSemanticChildNodes(EObject semanticNode) {
		if (semanticNode != null) {
			return new XtextSwitch<Boolean>() {
				@Override
				public Boolean caseGrammar(Grammar object) {
					return true;
				}

				@Override
				public Boolean caseAbstractRule(org.eclipse.xtext.AbstractRule object) {
					if (isFilterActive(ParserRulesOutlineFilter.class)) {
						return false;
					}
					return true;
				}

				@Override
				public Boolean caseAssignment(org.eclipse.xtext.Assignment object) {
					return object.getTerminal() instanceof Alternatives || object.getTerminal() instanceof CrossReference &&
						caseCrossReference((CrossReference) object.getTerminal());
				}

				@Override
				public Boolean caseCrossReference(CrossReference object) {
					return object.getTerminal() instanceof Alternatives;
				}

				@Override
				public Boolean caseAlternatives(org.eclipse.xtext.Alternatives object) {
					return true;
				}

				@Override
				public Boolean caseCharacterRange(CharacterRange object) {
					return false;
				}

				@Override
				public Boolean caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
					return false;
				}
				
				@Override
				public Boolean defaultCase(EObject object) {
					return true;
				}
			}.doSwitch(semanticNode);
		}
		return true;
	}

	@Override
	protected List<EObject> getChildren(EObject semanticNode) {
		return new XtextSwitch<List<EObject>>() {

			@Override
			public List<EObject> caseAssignment(Assignment object) {
				if (object.getTerminal() instanceof Alternatives || object.getTerminal() instanceof CrossReference)
					return getChildren(object.getTerminal());
				return super.caseAssignment(object);
			}

			@Override
			public List<EObject> caseCrossReference(CrossReference object) {
				if (object.getTerminal() instanceof Alternatives)
					return getChildren(object.getTerminal());
				return super.caseCrossReference(object);
			}

			@Override
			public List<EObject> caseEnumRule(EnumRule object) {
				if (object.getAlternatives() instanceof Alternatives)
					return getChildren(object.getAlternatives());
				return super.caseEnumRule(object);
			}

			@Override
			public List<EObject> defaultCase(EObject object) {
				return object.eContents();
			}
		}.doSwitch(semanticNode);

	}

	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		final ContentOutlineNode outlineNode = super.createOutlineNode(semanticNode, outlineParentNode);

		if (semanticNode != null) {
			return new XtextSwitch<ContentOutlineNode>() {
				@Override
				public ContentOutlineNode caseGrammar(Grammar object) {
					outlineNode.setLabel("grammar " + GrammarUtil.getLanguageId(object));
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseGeneratedMetamodel(org.eclipse.xtext.GeneratedMetamodel object) {
					outlineNode.setLabel("generate " + object.getName()
							+ (!Strings.isEmpty(object.getAlias()) ? " as " + object.getAlias() : ""));
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseReferencedMetamodel(org.eclipse.xtext.ReferencedMetamodel object) {
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

				@Override
				public ContentOutlineNode caseAssignment(org.eclipse.xtext.Assignment object) {
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
					} else {
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

				@Override
				public ContentOutlineNode caseCrossReference(CrossReference object) {
					outlineNode.setLabel(getLabel(object));
					return outlineNode;
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
								for (int i = leafs.size() - 1; i >= 0 ; i--) {
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

				@Override
				public ContentOutlineNode caseAbstractRule(org.eclipse.xtext.AbstractRule object) {
					outlineNode.setLabel(object.getName());
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseRuleCall(RuleCall ruleCall) {
					outlineNode.setLabel(getLabel(ruleCall));
					// TODO show another icon, if unresolved
					// TODO how to show text in another color?
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseAlternatives(org.eclipse.xtext.Alternatives object) {
					outlineNode.setLabel("|");
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseAction(Action object) {
					String classifierName = getClassifierName(object.getType());
					outlineNode.setLabel("{" + classifierName +
							(object.getFeature() != null ? ("." + object.getFeature()) : "") + "}");
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseCharacterRange(CharacterRange object) {
					outlineNode.setLabel(object.getLeft().getValue() + " .. " + object.getRight().getValue());
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseNegatedToken(NegatedToken object) {
					outlineNode.setLabel("!");
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseUntilToken(UntilToken object) {
					outlineNode.setLabel("->");
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseWildcard(Wildcard object) {
					outlineNode.setLabel("*");
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseKeyword(Keyword object) {
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

				@Override
				public ContentOutlineNode caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
					String literalName = getLiteralName(object);
					// TODO change color when literal could not be resolved
					Keyword kw = object.getLiteral();
					String kwValue = kw == null ? "" : " = '" + kw.getValue() + "'";
					outlineNode.setLabel(literalName + kwValue);
					return outlineNode;
				}

				@Override
				public ContentOutlineNode defaultCase(EObject object) {
					outlineNode.setLabel(object.eClass().getName());
					return outlineNode;
				}

			}.doSwitch(semanticNode);
		}
		return outlineNode;
	}

}
