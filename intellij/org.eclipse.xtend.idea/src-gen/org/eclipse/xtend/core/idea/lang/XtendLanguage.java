/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class XtendLanguage extends AbstractXtextLanguage {

	public static final XtendLanguage INSTANCE = new XtendLanguage();

	private XtendLanguage() {
		super("org.eclipse.xtend.core.Xtend");
	}

}
