/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.impl.DefaultSemanticModelTransformer;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xtext.ui.Activator;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class XtextSemanticModelTransformer extends DefaultSemanticModelTransformer {

	@Override
	public boolean consumeSemanticNode(EObject semanticNode) {
		if (semanticNode != null) {
			return new XtextSwitch<Boolean>() {
				@Override
				public Boolean caseTypeRef(org.eclipse.xtext.TypeRef object) {
					return false;
				};

				@Override
				public Boolean defaultCase(EObject object) {
					return true;
				};
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
				};

				@Override
				public Boolean caseAlternatives(org.eclipse.xtext.Alternatives object) {
					return true;
				};

				@Override
				public Boolean defaultCase(EObject object) {
					return true;
				};
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
					// create fully qualified ID string
					Object[] idElements = object.getIdElements().toArray();
					int size = idElements.length;
					StringBuffer stringBuffer = new StringBuffer();
					for (int i = 0; i < size;) {
						stringBuffer.append(String.valueOf(idElements[i]));
						if (++i < size) {
							stringBuffer.append(".");
						}
					}
					outlineNode.setLabel("language " + stringBuffer.toString());
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/language.gif"));
					return outlineNode;
				}

				@Override
				public ContentOutlineNode caseGeneratedMetamodel(org.eclipse.xtext.GeneratedMetamodel object) {
					outlineNode.setLabel("generate " + object.getName());
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/generate.gif"));
					return outlineNode;
				};

				@Override
				public ContentOutlineNode caseReferencedMetamodel(org.eclipse.xtext.ReferencedMetamodel object) {
					outlineNode.setLabel("import " + object.getAlias());
					outlineNode.setImageDescriptor(Activator.getImageDescriptor("icons/import.gif"));
					return outlineNode;
				};

				@Override
				public ContentOutlineNode caseParserRule(org.eclipse.xtext.ParserRule object) {
					outlineNode.setLabel(object.getName());
					return outlineNode;
				};

				@Override
				public ContentOutlineNode caseAlternatives(org.eclipse.xtext.Alternatives object) {
					outlineNode.setLabel("|");
					return outlineNode;
				};

				@Override
				public ContentOutlineNode defaultCase(EObject object) {
					return outlineNode;
				};

			}.doSwitch(semanticNode);
		} else {
			return outlineNode;
		}
	}

}
