/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.compiler;

import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class XtendCompilerUtil {

	private XtendCompilerUtil() {
		// only static methods
	}

	public static boolean canCompileToJavaAnonymousClass(AnonymousClass anonymousClass) {
		for(XtendMember member: anonymousClass.getMembers()) {
			if(member instanceof XtendField ||	
				(member instanceof XtendFunction && !((XtendFunction) member).isOverride())) 
				return false;
		}
		return true;
	}
}
