/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.validation;

import static com.google.common.collect.Sets.*;
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ModifierValidator {

	private static final Set<String> visibilityModifers = newHashSet("public", "protected", "package", "private");
	
	private final Set<String> allowedModifiers;
	private final XtendValidator validator;

	private final String allowedModifiersAsString;

	
	public ModifierValidator(List<String> allowedModifiers, XtendValidator validator) {
		this.allowedModifiers = newHashSet(allowedModifiers);
		this.validator = validator;
		StringBuffer buffer = new StringBuffer(allowedModifiers.get(0));
		for(int i=1; i<allowedModifiers.size()-1; ++i) 
			buffer.append(", ").append(allowedModifiers.get(i));
		if(allowedModifiers.size() > 1) 
			buffer.append(" & ").append(allowedModifiers.get(allowedModifiers.size()-1));
		allowedModifiersAsString = buffer.toString();
	}
	
	@Check
	protected void checkModifiers(XtendMember member, String memberName) {
		Set<String> seenModifiers = newHashSet();
		boolean visibilitySeen = false;
		boolean abstractSeen = false;
		boolean defSeen = false;
		boolean staticSeen = false;
		boolean finalSeen = false;
		boolean varSeen = false;
		int defKeywordIndex = -1;
		int finalKeywordIndex = -1;

		for(int i=0; i<member.getModifiers().size(); ++i) {
			String modifier = member.getModifiers().get(i);
			if(!allowedModifiers.contains(modifier)) { 
				error("Illegal modifier for the " + memberName + "; only " + allowedModifiersAsString + " are permitted",
						member, i);
			}
			if(seenModifiers.contains(modifier)) 
				error("Duplicate modifier for the " + memberName, 
						member, i);
			else {
				seenModifiers.add(modifier);
				if(visibilityModifers.contains(modifier)) {
					if(visibilitySeen) 
						error("The " + memberName +" can only set one of public / package / protected / private", 
								member, i);
					visibilitySeen = true;
					if("private".equals(modifier) && member instanceof XtendField) {
						redundantModifierWarning("private", memberName, member, i);
					}
					if("public".equals(modifier) && (member instanceof XtendClass || member instanceof XtendFunction)) {
						redundantModifierWarning("public", memberName, member, i);
					}
				}
			} 
			if(equal(modifier, "abstract")) {
				if(finalSeen) {
					error("The " + memberName + " can either be abstract or final, not both",
							member, i);
				}
				if(staticSeen && !(member instanceof XtendTypeDeclaration)) {
					error("The " + memberName + " can either be abstract or static, not both",
							member, i);
				}
				abstractSeen = true;
			} else if(equal(modifier, "static")) {
				if(abstractSeen && !(member instanceof XtendTypeDeclaration)) {
					error("The " + memberName + " can either be abstract or static, not both",
							member, i);
				}
				staticSeen = true;
			} else if(equal(modifier, "final") || equal(modifier, "val")) {
				if(abstractSeen) {
					error("The " + memberName + " can either be abstract or final, not both",
							member, i);
				}
				if(varSeen) {
					error("The " + memberName + " can either be var or val / final, not both",
							member, i);
				}
				if(equal(modifier, "final")) {
					finalKeywordIndex = i;
				}
				if(finalSeen) {
					/*
					 * Independent of the order of the keywords (such as 'final val' or 'val final'), 
					 * the 'final' keyword should be marked with the warning marker
					 */
					redundantModifierWarning("final", memberName, member, finalKeywordIndex);
				}
				finalSeen = true;
			} else if(equal(modifier, "var")) {
				if(finalSeen) {
					error("The " + memberName + " can either be var or val / final, not both",
							member, i);
				}
				varSeen = true;
			} else if ((equal(modifier, "def") || equal(modifier, "override")) && member instanceof XtendFunction) {
				if(equal(modifier, "def")) {
					defKeywordIndex = i;					
				}
				if(defSeen) {
					/*
					 * Independent of the order of the keywords (such as 'override def' or 'def override'), 
					 * the 'def' keyword should be marked with the warning marker
					 */
					redundantModifierWarning("def", memberName, member, defKeywordIndex);
				}
				defSeen = true;
			}
		}
	}

	protected void redundantModifierWarning(String modifier, String memberName, EObject source, int index) {
		issue("The "+ modifier + " modifier is redundant on " + memberName, source, index, IssueCodes.REDUNDANT_MODIFIER, modifier);
	}
	
	protected void issue(String message, EObject source, int index, String code, String... issueData) {
		validator.addIssue(message, source, XTEND_MEMBER__MODIFIERS, index, code, issueData);
	}
	
	protected void error(String message, EObject source, int index) {
		validator.acceptError(message, source, XTEND_MEMBER__MODIFIERS, index, IssueCodes.INVALID_MODIFIER);
	}


}
