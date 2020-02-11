/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchMethodRenameContext extends CombinedJvmJdtRenameContext {

	public DispatchMethodRenameContext(XtendFunction dispatchFunction, Map<URI, IJavaElement> jvm2javaElements,
			XtextEditor editor, ITextSelection selection, XtextResource contextResource) {
		super(dispatchFunction, jvm2javaElements, editor, selection, contextResource);
	}

	
}
