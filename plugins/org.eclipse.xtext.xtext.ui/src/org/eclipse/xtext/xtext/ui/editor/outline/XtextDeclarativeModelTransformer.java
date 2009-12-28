/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.ui.common.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Michael Clay
 */
public class XtextDeclarativeModelTransformer extends AbstractDeclarativeSemanticModelTransformer {

	public boolean consumeNode(RuleCall object) {
		return false;
	}

	public boolean consumeNode(Group object) {
		return false;
	}

	public boolean consumeNode(TypeRef object) {
		return false;
	}

	public List<EObject> getChildren(Assignment object) {
		if (object.getTerminal() instanceof Alternatives || object.getTerminal() instanceof CrossReference) {
			return getChildren(object.getTerminal());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(CrossReference object) {
		if (object.getTerminal() instanceof Alternatives) {
			return getChildren(object.getTerminal());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(EnumRule object) {
		if (object.getAlternatives() instanceof Alternatives) {
			return getChildren(object.getAlternatives());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(CharacterRange object) {
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(EnumLiteralDeclaration object) {
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(RuleCall object) {
		return NO_CHILDREN;
	}

}
