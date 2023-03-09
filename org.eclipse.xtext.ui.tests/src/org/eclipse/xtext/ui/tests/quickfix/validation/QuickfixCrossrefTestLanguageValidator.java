/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.quickfix.validation;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Main;
import org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class QuickfixCrossrefTestLanguageValidator extends AbstractQuickfixCrossrefTestLanguageValidator {
	
	public static final String TRIGGER_VALIDATION_ISSUE = "triggerValidationIssue";
	public static final String MULTIFIXABLE_ISSUE = "multiFixableIssue";
	public static final String MULTIFIXABLE_ISSUE_2 = "multiFixableIssue2";
	public static final String BAD_NAME_IN_SUBELEMENTS = "badNameInSubelements";
	public static final String FIXABLE = "fixable";
	public static final String LOWERCASE = "lowercase";
		
	public static final String ISSUE_DATA_0 = "data0";
	public static final String ISSUE_DATA_1 = "data1";

	@Check(CheckType.FAST)
	public void checkAndPopulateIssueData(Element element) {
		if(element.getName().equals(TRIGGER_VALIDATION_ISSUE)) {
			error(
					TRIGGER_VALIDATION_ISSUE, 
					element, 
					QuickfixCrossrefPackage.Literals.ELEMENT__NAME,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					TRIGGER_VALIDATION_ISSUE, 
					ISSUE_DATA_0, 
					ISSUE_DATA_1);
		}
	}

	@Check(CheckType.FAST)
	public void checkDocumentation(Element element) {
		if (element.getDoc().equals("no doc")) {
			warning(MULTIFIXABLE_ISSUE, element, QuickfixCrossrefPackage.Literals.ELEMENT__DOC,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MULTIFIXABLE_ISSUE);
		}
	}

	@Check(CheckType.FAST)
	public void checkDocumentation2(Element element) {
		if (element.getDoc().equals("bad doc")) {
			warning(MULTIFIXABLE_ISSUE_2, element, QuickfixCrossrefPackage.Literals.ELEMENT__DOC,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MULTIFIXABLE_ISSUE_2);
		}
	}
	
	@Check(CheckType.FAST)
	public void checkBadNames(Main main) {
		Resource res = main.eResource();
		for (Element root : main.getElements()) {
			List<String> fragments = Lists.newArrayList();
			for (Element ele : EcoreUtil2.getAllContentsOfType(root, Element.class)) {
				if ("badname".equals(ele.getName())) {
					fragments.add(res.getURIFragment(ele));
				}
			}
			if (!fragments.isEmpty()) {
				warning(BAD_NAME_IN_SUBELEMENTS, root, QuickfixCrossrefPackage.Literals.ELEMENT__NAME,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, BAD_NAME_IN_SUBELEMENTS, Joiner.on(";").join(fragments));
			}
		}
	}
	
	@Check(CheckType.FAST)
	public void checkFixable(Element ele) {
		if (ele.getName().startsWith("fixable")) {
			warning(FIXABLE, ele, QuickfixCrossrefPackage.Literals.ELEMENT__NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, FIXABLE);
		}
	}
	
	@Check(CheckType.FAST)
	public void checkNameUppercase(Element ele) {
		if (ele.getName().startsWith("lowercase")) {
			warning(LOWERCASE, ele, QuickfixCrossrefPackage.Literals.ELEMENT__NAME, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, LOWERCASE);
		}
	}
}
