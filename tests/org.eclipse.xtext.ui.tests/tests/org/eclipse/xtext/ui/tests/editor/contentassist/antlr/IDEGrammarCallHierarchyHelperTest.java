/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.antlr;

import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.CallHierarchyHelper;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IDEGrammarCallHierarchyHelperTest extends GrammarCallHierarchyHelperTest {

	@Override
	protected Switch<Boolean> createHelper(AbstractElement previous, String previousText, AbstractElement next) {
		return new CallHierarchyHelper(next, previousText, previous);
	}
}
