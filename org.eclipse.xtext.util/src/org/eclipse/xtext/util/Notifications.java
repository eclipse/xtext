/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class Notifications {

	public boolean isDiagnosticChange(Notification notification) {
		return notification != null && (notification.getOldValue() instanceof Diagnostic || notification.getNewValue() instanceof Diagnostic);
	}
}
