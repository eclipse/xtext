/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.backtracking.formatting2;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.AliasedRequiredCapability;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.Function;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.Model;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.ProvidedCapability;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.RequiredCapability;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.SimpleTypeRef;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.Unit;

public class BeeLangTestLanguageFormatter extends AbstractJavaFormatter {

	protected void format(Model model, IFormattableDocument doc) {
		for (Unit unit : model.getUnits()) {
			doc.format(unit);
		}
		for (Function function : model.getFunctions()) {
			doc.format(function);
		}
	}

	protected void format(Unit unit, IFormattableDocument doc) {
		for (SimpleTypeRef simpleTypeRef : unit.getImplements()) {
			doc.format(simpleTypeRef);
		}
		for (ProvidedCapability providedCapability : unit.getProvidedCapabilities()) {
			doc.format(providedCapability);
		}
		for (AliasedRequiredCapability aliasedRequiredCapability : unit.getRequiredCapabilities()) {
			doc.format(aliasedRequiredCapability);
		}
		for (RequiredCapability requiredCapability : unit.getMetaRequiredCapabilities()) {
			doc.format(requiredCapability);
		}
		for (Function function : unit.getFunctions()) {
			doc.format(function);
		}
	}

}
