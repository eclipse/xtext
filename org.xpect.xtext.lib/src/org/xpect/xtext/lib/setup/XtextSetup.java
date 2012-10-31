/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import org.xpect.setup.AbstractXpectSetup;
import org.xpect.setup.IXpectSetup;
import org.xpect.xtext.lib.setup.XtextSetup.ClassCtx;
import org.xpect.xtext.lib.setup.XtextSetup.TestCtx;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx, Object> {

	protected static class ClassCtx {
	}

	protected static class FileCtx extends ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}

	public void add(IXpectSetup<?, ?, ?, ?> delegate) {

	}

}
