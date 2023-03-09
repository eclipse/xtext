/*******************************************************************************
 * Copyright (c) 2009, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.labeling;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for IEObjectDescriptions and IResourceDescriptions.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class XtextDescriptionLabelProvider extends DefaultDescriptionLabelProvider {
	
	@Override
	public Object image(IEObjectDescription description) {
		return doGetImage(description.getEObjectOrProxy());
	}
	
	public String image(Grammar grammar) {
		return "language.gif"; //$NON-NLS-1$
	}

	public String image(GeneratedMetamodel metamodel) {
		return "export.gif"; //$NON-NLS-1$
	}

	public String image(ReferencedMetamodel metamodel) {
		return "import.gif"; //$NON-NLS-1$
	}

	public String image(AbstractRule rule) {
		return "rule.gif"; //$NON-NLS-1$
	}

	public String image(RuleCall ruleCall) {
		return "rule.gif"; //$NON-NLS-1$
	}

	public String image(Keyword keyword) {
		return "keyword.gif"; //$NON-NLS-1$
	}
}
