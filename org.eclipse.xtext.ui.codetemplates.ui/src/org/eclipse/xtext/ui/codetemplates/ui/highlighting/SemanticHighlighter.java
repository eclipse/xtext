/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatePart;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.codetemplates.ui.evaluator.EvaluatedTemplate;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SemanticHighlighter implements ISemanticHighlightingCalculator {

	@Inject
	private LanguageRegistry registry;
	
	@Inject
	private OperationCanceledManager operationCanceledManager;
	
	@Override
	public void provideHighlightingFor(XtextResource resource, final IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource == null || resource.getContents().isEmpty())
			return;
		Codetemplates templates = (Codetemplates) resource.getContents().get(0);
		Grammar grammar = templates.getLanguage();
		if (grammar != null && !grammar.eIsProxy()) {
			TemplateBodyHighlighter highlighter = getHighlighter(grammar);
			if (highlighter != null) {
				ContextTypeIdHelper helper = registry.getContextTypeIdHelper(grammar);
				ContextTypeRegistry contextTypeRegistry = registry.getContextTypeRegistry(grammar);
				for(Codetemplate template: templates.getTemplates()) {
					operationCanceledManager.checkCanceled(cancelIndicator);
					if (template.getBody() != null) {
						final EvaluatedTemplate evaluatedTemplate = new EvaluatedTemplate(template);
						highlighter.provideHighlightingFor(evaluatedTemplate.getMappedString(), new IHighlightedPositionAcceptor() {
							@Override
							public void addPosition(int offset, int length, String... id) {
								int beginOffset = evaluatedTemplate.getOriginalOffset(offset);
								int endOffset = evaluatedTemplate.getOriginalOffset(offset + length);
								int fixedLength = endOffset - beginOffset;
								acceptor.addPosition(beginOffset, fixedLength, id);
							}
						});
						String id = null;
						TemplateContextType contextType = null;
						if (template.getContext() != null) {
							id = helper.getId(template.getContext());
							if (id != null)
								contextType = contextTypeRegistry.getContextType(id);
						}
						Set<String> defaultResolvers = Sets.newHashSet();
						if (contextType != null) {
							Iterator<TemplateVariableResolver> resolvers = Iterators.filter(contextType.resolvers(), TemplateVariableResolver.class);
							while(resolvers.hasNext()) {
								TemplateVariableResolver resolver = resolvers.next();
								defaultResolvers.add(resolver.getType());
							}
						}
						for(TemplatePart part: template.getBody().getParts()) {
							if (part instanceof Variable) {
								Variable variable = (Variable) part;
								ICompositeNode node = NodeModelUtils.findActualNodeFor(variable);
								if (node != null) {
									for(ILeafNode leafNode: node.getLeafNodes()) {
										if (leafNode.getGrammarElement() instanceof Keyword) {
											acceptor.addPosition(leafNode.getTotalOffset(), leafNode.getTotalLength(), TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE);		
										}
									}
									List<INode> typeNodes = NodeModelUtils.findNodesForFeature(variable, TemplatesPackage.Literals.VARIABLE__TYPE);
									if (typeNodes.isEmpty()) {
										if (defaultResolvers.contains(variable.getName())) {
											List<INode> nameNodes = NodeModelUtils.findNodesForFeature(variable, TemplatesPackage.Literals.VARIABLE__NAME);
											for(INode nameNode: nameNodes) {
												highlightNode(nameNode, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE, acceptor);
											}
										}
									} else {
										for(INode typeNode: typeNodes) {
											highlightNode(typeNode, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE, acceptor);
										}
									}
									List<INode> parameterNodes = NodeModelUtils.findNodesForFeature(variable, TemplatesPackage.Literals.VARIABLE__PARAMETERS);
									for(INode parameterNode: parameterNodes) {
										highlightNode(parameterNode, TemplatesHighlightingConfiguration.TEMPLATE_VARIABLE_ARGUMENT, acceptor);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	protected TemplateBodyHighlighter getHighlighter(Grammar grammar) {
		return registry.getTemplateBodyHighlighter(grammar);
	}

	/**
	 * Highlights the non-hidden parts of {@code node} with the style that is associated with {@code id}.
	 */
	protected void highlightNode(INode node, String id, IHighlightedPositionAcceptor acceptor) {
		if (node == null)
			return;
		if (node instanceof ILeafNode) {
			ITextRegion textRegion = node.getTextRegion();
			acceptor.addPosition(textRegion.getOffset(), textRegion.getLength(), id);
		} else {
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					ITextRegion leafRegion = leaf.getTextRegion();
					acceptor.addPosition(leafRegion.getOffset(), leafRegion.getLength(), id);
				}
			}
		}
	}
}
