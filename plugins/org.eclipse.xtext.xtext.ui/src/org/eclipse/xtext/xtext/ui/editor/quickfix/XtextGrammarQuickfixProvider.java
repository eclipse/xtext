/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtext.XtextLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xtext.XtextValidator;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextGrammarQuickfixProvider extends DefaultQuickfixProvider {
	private String NULL_QUICKFIX_IMAGE = null;
	
//	see https://bugs.eclipse.org/bugs/show_bug.cgi?id=324566
//	
//	@Fix(XtextValidator.INVALID_METAMODEL_ALIAS)
//	public void fixInvalidMetaModelAlias(final Issue issue, IssueResolutionAcceptor acceptor) {
//		final String alias = issue.getData()[0];
//		acceptor.accept(issue, "Remove '" + alias + "' alias", "Remove '" + alias + "' alias", NULL_QUICKFIX_IMAGE,
//				new ISemanticModification() {
//					public void apply(final EObject element, IModificationContext context) {
//						ReferencedMetamodel referencedMetamodel = (ReferencedMetamodel) element;
//						referencedMetamodel.setAlias(null);
//					}
//				});
//		createLinkingIssueResolutions(issue, acceptor);
//	}

	@Fix(XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE)
	public void fixUnresolvedRule(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String ruleName = issue.getData()[0];
		acceptor.accept(issue, "Create rule '" + ruleName + "'", "Create rule '" + ruleName + "'", NULL_QUICKFIX_IMAGE,
				new ISemanticModification() {
					public void apply(final EObject element, IModificationContext context) throws BadLocationException {
						AbstractRule abstractRule = EcoreUtil2.getContainerOfType(element, ParserRule.class);
						CompositeNode node = NodeUtil.getNode(abstractRule);
						int offset = node.getOffset() + node.getLength();
						StringBuilder builder = new StringBuilder("\n\n");
						if (abstractRule instanceof TerminalRule)
							builder.append("terminal ");
						String newRule = builder.append(ruleName).append(":\n\t\n;\n").toString();
						context.getXtextDocument().replace(offset, 0, newRule);
					}
				});
		createLinkingIssueResolutions(issue, acceptor);
	}

	@Fix(XtextValidator.INVALID_METAMODEL_NAME)
	public void fixInvalidMetaModelName(final Issue issue, IssueResolutionAcceptor acceptor) {
		final String metaModelName = issue.getData()[0];
		acceptor.accept(issue, "Fix metamodel name '" + metaModelName + "'", "Fix metamodel name '" + metaModelName
				+ "'", NULL_QUICKFIX_IMAGE, new ISemanticModification() {
			public void apply(final EObject element, IModificationContext context) {
				GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel) element;
				generatedMetamodel.setName(Strings.toFirstLower(generatedMetamodel.getName()));
			}
		});
	}

	@Fix(XtextValidator.EMPTY_ENUM_LITERAL)
	public void fixEmptyEnumLiteral(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Fix empty enum literal", "Fix empty enum literal", NULL_QUICKFIX_IMAGE,
				new ISemanticModification() {
					public void apply(final EObject element, IModificationContext context) {
						EnumLiteralDeclaration enumLiteralDeclaration = (EnumLiteralDeclaration) element;
						Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
						keyword.setValue(enumLiteralDeclaration.getEnumLiteral().getName().toLowerCase());
						enumLiteralDeclaration.setLiteral(keyword);
					}
				});
	}

	@Fix(XtextValidator.INVALID_ACTION_USAGE)
	public void fixInvalidActionUsage(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Fix invalid action usage", "Fix invalid action usage", NULL_QUICKFIX_IMAGE,
				new IModification() {
					public void apply(IModificationContext context) throws BadLocationException {
						context.getXtextDocument().replace(issue.getOffset(), issue.getLength(), "");
					}
				});
	}

}
