/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.ide.hierarchy.call;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;

/**
 * @author kosyakov - Initial contribution and API
 */
public class XtendCallReferenceProcessor extends JvmExecutableCallReferenceProcessor {

	public XtendCallReferenceProcessor() {
		super(XtendLanguage.INSTANCE);
	}

}
