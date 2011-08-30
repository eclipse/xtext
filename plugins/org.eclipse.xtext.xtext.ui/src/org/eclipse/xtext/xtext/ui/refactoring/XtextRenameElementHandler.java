/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextRenameElementHandler extends DefaultRenameElementHandler {
	
	@Inject
	private RuleOverrideUtil ruleOverrideUtil;
	
	@Override
	public IRenameElementContext createRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		if(targetElement instanceof AbstractRule) {
			AbstractRule targetRule = (AbstractRule) targetElement;
			List<IEObjectDescription> overriddenRules = ruleOverrideUtil.getOverriddenRules(targetRule);
			if(!overriddenRules.isEmpty()) {
				IEObjectDescription topMostSuperRule = overriddenRules.get(overriddenRules.size()-1);
				StringBuilder builder = new StringBuilder();
				builder
					.append("Rule '")
					.append(targetRule.getName())
					.append("' overrides a rule from a super grammar.\n")
					.append("Rename super rule instead?");
				boolean isRenameSuperRule = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Overriding Rule", builder.toString());
				if(isRenameSuperRule) {
					EObject newTarget = EcoreUtil.resolve(topMostSuperRule.getEObjectOrProxy(), targetElement.eResource().getResourceSet());
					return super.createRenameElementContext(newTarget, editor, selection, resource);
				}
			} 
		}
		return super.createRenameElementContext(targetElement, editor, selection, resource);
	}
	
}
