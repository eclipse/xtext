/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.toggleComments;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractNegatedToken;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SLCommentPrefixCalculator extends XtextSwitch<Boolean> {
	private final List<String> result;

	protected SLCommentPrefixCalculator(List<String> result) {
		this.result = result;
	}
 
	@Override
	public Boolean caseAlternatives(Alternatives object) {
		boolean result = true;
		for(AbstractElement elem: object.getElements()) {
			result &= doSwitch(elem);
		}
		return result;
	}

	@Override
	public Boolean caseGroup(Group object) {
		for (AbstractElement elem: object.getElements()) {
			if (!doSwitch(elem))
				return false;
		}
		return true;
	}

	@Override
	public Boolean caseKeyword(Keyword object) {
		result.add(object.getValue());
		return false;
	}

	@Override
	public Boolean caseAbstractNegatedToken(AbstractNegatedToken object) {
		return false;
	}

	@Override
	public Boolean caseUntilToken(UntilToken object) {
		return false;
	}

	@Override
	public Boolean caseCharacterRange(CharacterRange object) {
		return false;
	}
}