/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.validation;

import static com.google.common.collect.Sets.*;
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.validation.Check;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Stephane Galland - Add the functions "*ByDefault".
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
					if("private".equals(modifier) && isPrivateByDefault(member)) {
						unnecessaryModifierIssue("private", memberName, member, i);
					}
					if("protected".equals(modifier) && isProtectedByDefault(member)) {
						unnecessaryModifierIssue("protected", memberName, member, i);
					}
					if("package".equals(modifier) && isPackageByDefault(member)) {
						unnecessaryModifierIssue("package", memberName, member, i);
					}
					if("public".equals(modifier) && isPublicByDefault(member)) {
						unnecessaryModifierIssue("public", memberName, member, i);
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
					 * the 'final' keyword should be marked with the issue marker
					 */
					unnecessaryModifierIssue("final", memberName, member, finalKeywordIndex);
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
					 * the 'def' keyword should be marked with the issue marker
					 */
					unnecessaryModifierIssue("def", memberName, member, defKeywordIndex);
				}
				defSeen = true;
			}
		}
	}

	protected void unnecessaryModifierIssue(String modifier, String memberName, EObject source, int index) {
		issue("The "+ modifier + " modifier is unnecessary on " + memberName, source, index, IssueCodes.UNNECESSARY_MODIFIER, modifier);
	}
	
	protected void issue(String message, EObject source, int index, String code, String... issueData) {
		validator.addIssue(message, source, XTEND_MEMBER__MODIFIERS, index, code, issueData);
	}
	
	protected void error(String message, EObject source, int index) {
		validator.acceptError(message, source, XTEND_MEMBER__MODIFIERS, index, IssueCodes.INVALID_MODIFIER);
	}

	/** Replies if the default visibility modifier for the given member is "private".
	 * If this function replies {@code true}, the "private" modifier is assumed to be the default one for the given member.
	 * This function may be used for printing out an "unnecessary modifier" warning when the "private" modifier is explicitly
	 * attached to the given member.
	 *
	 * <p>This function is defined for being overridden by subclasses.
	 *
	 * @param member the member to test.
	 * @return {@code true} if the "private" modifier is the modifier by default for the given member.
	 */
	protected boolean isPrivateByDefault(XtendMember member) {
		return member instanceof XtendField;
	}

	/** Replies if the default visibility modifier for the given member is "protected".
	 * If this function replies {@code true}, the "protected" modifier is assumed to be the default one for the given member.
	 * This function may be used for printing out an "unnecessary modifier" warning when the "protected" modifier is explicitly
	 * attached to the given member.
	 *
	 * <p>This function is defined for being overridden by subclasses.
	 *
	 * @param member the member to test.
	 * @return {@code true} if the "protected" modifier is the modifier by default for the given member.
	 */
	protected boolean isProtectedByDefault(XtendMember member) {
		return false;
	}

	/** Replies if the default visibility modifier for the given member is "package".
	 * If this function replies {@code true}, the "package" modifier is assumed to be the default one for the given member.
	 * This function may be used for printing out an "unnecessary modifier" warning when the "package" modifier is explicitly
	 * attached to the given member.
	 *
	 * <p>This function is defined for being overridden by subclasses.
	 *
	 * @param member the member to test.
	 * @return {@code true} if the "package" modifier is the modifier by default for the given member.
	 */
	protected boolean isPackageByDefault(XtendMember member) {
		return false;
	}

	/** Replies if the default visibility modifier for the given member is "public".
	 * If this function replies {@code true}, the "public" modifier is assumed to be the default one for the given member.
	 * This function may be used for printing out an "unnecessary modifier" warning when the "public" modifier is explicitly
	 * attached to the given member.
	 *
	 * <p>This function is defined for being overridden by subclasses.
	 *
	 * @param member the member to test.
	 * @return {@code true} if the "public" modifier is the modifier by default for the given member.
	 */
	protected boolean isPublicByDefault(XtendMember member) {
		return member instanceof XtendAnnotationType ||
			member instanceof XtendClass ||
			member instanceof XtendEnum ||
			member instanceof XtendInterface ||
			member instanceof XtendConstructor ||
			member instanceof XtendFunction;
	}

}
