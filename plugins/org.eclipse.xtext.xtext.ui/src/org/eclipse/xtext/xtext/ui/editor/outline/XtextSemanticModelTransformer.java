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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xtext.ui.Activator;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class XtextSemanticModelTransformer extends DefaultSemanticModelTransformer {

	public XtextSemanticModelTransformer(ILocationInFileProvider locationProvider, ILabelProvider labelProvider) {
		super(locationProvider, labelProvider);
	}

	@Override
	public boolean consumeSemanticNode(EObject semanticNode) {
		if (semanticNode != null) {
			return new XtextSwitch<Boolean>() {
				@Override
				public Boolean caseTypeRef(org.eclipse.xtext.TypeRef object) {
					return false;
				}	
				
				public Boolean caseGroup(org.eclipse.xtext.Group object) {
					return false;
				}

				@Override
				public Boolean defaultCase(EObject object) {
					return true;
				}
			}.doSwitch(semanticNode);
		} else {
			return false;
		}
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
				public Boolean caseParserRule(org.eclipse.xtext.ParserRule object) {
					return true;
				}
				
				public Boolean caseAssignment(org.eclipse.xtext.Assignment object) {
					return false;
				}

				@Override
				public Boolean caseAlternatives(org.eclipse.xtext.Alternatives object) {
					return true;
				}
				
				@Override
				public Boolean defaultCase(EObject object) {
					return true;
				}
			}.doSwitch(semanticNode);
		} else {
			return true;
		}
	}
	
	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		final ContentOutlineNode outlineNode = super.createOutlineNode(semanticNode, outlineParentNode);

		if (semanticNode != null) {
			return new XtextSwitch<ContentOutlineNode>() {
				@Override
				public ContentOutlineNode caseGrammar(Grammar object) {
					outlineNode.setLabel("language " + GrammarUtil.getLanguageId(object));
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/language.gif"));
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseGeneratedMetamodel(org.eclipse.xtext.GeneratedMetamodel object) {
					outlineNode.setLabel("generate " + object.getName() + (!Strings.isEmpty(object.getAlias())? " as " + object.getAlias() :""));
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/export.gif"));
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseReferencedMetamodel(org.eclipse.xtext.ReferencedMetamodel object) {
					outlineNode.setLabel("import " + object.getAlias());
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/import.gif"));
					return outlineNode;
				}
				
				@Override
				public ContentOutlineNode caseAssignment(org.eclipse.xtext.Assignment object) {
					StringBuffer label = new StringBuffer();
					label.append(object.getFeature()).append(" ").append(object.getOperator()).append(" ");
					
					AbstractElement terminal = object.getTerminal();
					if (terminal instanceof RuleCall) {
						RuleCall ruleCall = (RuleCall) terminal;
						String name = ruleCall.getRule().getName();
						label.append(name);
					}
					else if (terminal instanceof Keyword) {
						Keyword keyword = (Keyword) terminal;
						String value = keyword.getValue();
						label.append(value);
					}
					else if (terminal instanceof CrossReference) {
						CrossReference crossReference = (CrossReference) terminal;
						TypeRef type = crossReference.getType();
						String typeName = "<unknown>";
						if (type != null && type.getType() != null) {
							typeName = type.getType().getName();
						}
						label.append("[").append(typeName).append("]");
					}
					
					String cardinality = object.getCardinality();
					label.append(cardinality != null ? cardinality : "");
					outlineNode.setLabel(label.toString());
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseAbstractRule(org.eclipse.xtext.AbstractRule object) {
					outlineNode.setLabel(object.getName());
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/rule.gif"));
					return outlineNode;
				}
				
				@Override
				public ContentOutlineNode caseRuleCall(RuleCall ruleCall) {
					if (ruleCall.getRule() != null) {
						outlineNode.setLabel(ruleCall.getRule().getName());
					}
					else {
						NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(ruleCall);
						String ruleName = "???";
						if (nodeAdapter != null) {
							List<LeafNode> leafs = nodeAdapter.getParserNode().getLeafNodes();
							for (LeafNode leaf: leafs) {
								if (!leaf.isHidden()) {
									ruleName = leaf.getText();
									break;
								}
							}
						}
						outlineNode.setLabel("unresolved call " + ruleName);
					}
					// TODO show another icon, if unresolved
					// TODO how to show text in another color? 
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/rule.gif"));
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseAlternatives(org.eclipse.xtext.Alternatives object) {
					outlineNode.setLabel("|");
					return outlineNode;
				}
				
				public ContentOutlineNode caseKeyword(Keyword object) {
					outlineNode.setLabel("'" + object.getValue() + "'");
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/keyword.gif"));
					return outlineNode;
				}

				@Override
				public ContentOutlineNode defaultCase(EObject object) {
					outlineNode.setLabel(object.eClass().getName());
					return outlineNode;
				}

			}.doSwitch(semanticNode);
		} else {
			return outlineNode;
		}
	}
	
}
