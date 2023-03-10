/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.quickfix.ui.quickfix;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.ICompositeModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.model.edit.ITextualMultiModification;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefFactory;
import org.eclipse.xtext.ui.tests.quickfix.validation.QuickfixCrossrefTestLanguageValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;

public class QuickfixCrossrefTestLanguageQuickfixProvider extends DefaultQuickfixProvider {

	public static final String SEMANTIC_FIX_ID = "Semantic Fix ID";

	@Fix(SEMANTIC_FIX_ID)
	public void rename(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, SEMANTIC_FIX_ID, SEMANTIC_FIX_ID, null, new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) {
				((Element) element).setName("Bor");
			}
		});
	}

	@Fix(QuickfixCrossrefTestLanguageValidator.MULTIFIXABLE_ISSUE)
	public void addDocumentation(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.acceptMulti(issue, "Multi fix", "Multi fix", null, (Element main, ICompositeModificationContext<Element> ctx) -> {
			ctx.setUpdateCrossReferences(false);
			ctx.addModification(main, (obj) -> {
				main.setDoc("Better documentation");
			});
		});
	}

	@Fix(QuickfixCrossrefTestLanguageValidator.MULTIFIXABLE_ISSUE_2)
	public void addDocumentation2(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.acceptMulti(issue, "Multi fix 2", "Multi fix 2", null, (Element eObj) -> {
			eObj.setDoc("not " + eObj.getDoc());
		});
	}

	@SuppressWarnings("unchecked")
	@Fix(QuickfixCrossrefTestLanguageValidator.BAD_NAME_IN_SUBELEMENTS)
	public void fixBadNames(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.acceptMulti(issue, "Fix Bad Names", "Fix Bad Names", null, (Element main, ICompositeModificationContext<Element> ctx) -> {
			ctx.addModification(main.eContainer(), c -> {
				List<Element> siblings = (List<Element>) main.eContainer().eGet(main.eContainmentFeature());
				int index = siblings.indexOf(main);
				Element newEle = QuickfixCrossrefFactory.eINSTANCE.createElement();
				newEle.setName("newElement");
				siblings.add(index, newEle);
			});
			for (String s : issue.getData()[0].split(";")) {
				EObject ele = main.eResource().getEObject(s);
				Assert.assertTrue(ele instanceof Element);
				ctx.addModification((Element) ele, e -> {
					e.setName("goodname");
				});
			}
		});
	}
	
	@Fix(QuickfixCrossrefTestLanguageValidator.FIXABLE)
	public void renameFixable(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.acceptMulti(issue, "rename fixable", "rename fixable", null, (Element main, ICompositeModificationContext<Element> ctx) -> {
			ctx.setUpdateCrossReferences(false);
			ctx.addModification(main, (obj) -> {
				main.setName("fixedName");
			});
		});
	}
	
	@Fix(QuickfixCrossrefTestLanguageValidator.LOWERCASE)
	public void fixLowercase(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "fix lowercase", "fix lowercase", null, new ITextualMultiModification() {
			
			@Override
			public void apply(IModificationContext context) throws Exception {
				if (context instanceof IssueModificationContext) {
					Issue theIssue = ((IssueModificationContext) context).getIssue();
					IXtextDocument document = context.getXtextDocument();
					String upperCase = document.get(theIssue.getOffset(), theIssue.getLength()).toUpperCase();
					// uppercase + duplicate => allows offset change tests
					document.replace(theIssue.getOffset(), theIssue.getLength(), upperCase + "_" +upperCase);
				}
			}
		});
	}
}
