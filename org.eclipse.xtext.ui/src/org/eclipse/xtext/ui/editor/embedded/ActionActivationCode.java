/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;

/**
 * Utility to match keystrokes.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ActionActivationCode {

	/** The action id. */
	public String fActionId;
	/** The character. */
	public char fCharacter;
	/** The key code. */
	public int fKeyCode= -1;
	/** The state mask. */
	public int fStateMask= SWT.DEFAULT;

	/**
	 * Creates a new action activation code for the given action id.
	 * @param actionId the action id
	 */
	public ActionActivationCode(String actionId) {
		fActionId= actionId;
	}

	/**
	 * Returns <code>true</code> if this activation code matches the given verify event.
	 * @param event the event to test for matching
	 * @return whether this activation code matches <code>event</code>
	 */
	public boolean matches(VerifyEvent event) {
		return (event.character == fCharacter &&
					(fKeyCode == -1 || event.keyCode == fKeyCode) &&
					(fStateMask == SWT.DEFAULT || event.stateMask == fStateMask));
	}
}