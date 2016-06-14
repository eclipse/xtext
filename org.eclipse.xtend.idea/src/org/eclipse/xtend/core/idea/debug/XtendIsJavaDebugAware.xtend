/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.debug

import com.intellij.debugger.engine.JavaDebugAware
import com.intellij.psi.PsiFile
import org.eclipse.xtend.core.idea.lang.XtendFileType

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendIsJavaDebugAware extends JavaDebugAware {
	
	override isBreakpointAware(PsiFile psiFile) {
		return psiFile.fileType == XtendFileType.INSTANCE
	}
	
}