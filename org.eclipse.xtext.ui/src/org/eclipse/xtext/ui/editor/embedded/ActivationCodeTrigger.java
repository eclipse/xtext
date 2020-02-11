/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IAction;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.ui.texteditor.IReadOnlyDependent;
import org.eclipse.ui.texteditor.IUpdate;

/**
 * VerifyKeyListener that will trigger a matching action directly instead
 * of using the key binding API.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ActivationCodeTrigger implements VerifyKeyListener {

	private List<ActionActivationCode> activationCodes;
	private Map<String, IAction> actions;
	
	public ActivationCodeTrigger(Map<String, IAction> actions, List<ActionActivationCode> activationCodes) {
		this.actions = actions;
		this.activationCodes = activationCodes;
	}

	@Override
	public void verifyKey(VerifyEvent event) {

		ActionActivationCode code= null;
		int size= activationCodes.size();
		for (int i= 0; i < size; i++) {
			code= activationCodes.get(i);
			if (code.matches(event)) {
				IAction action= actions.get(code.fActionId);
				if (action != null) {

					if (action instanceof IUpdate)
						((IUpdate) action).update();

					if (!action.isEnabled() && action instanceof IReadOnlyDependent) {
						IReadOnlyDependent dependent= (IReadOnlyDependent) action;
						boolean writable= dependent.isEnabled(true);
						if (writable) {
							event.doit= false;
							return;
						}
					} else if (action.isEnabled()) {
						event.doit= false;
						action.run();
						return;
					}
				}
			}
		}
	}
}