/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.resource.JvmElementAtOffsetHelper;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public abstract class AbstractJvmElementHandler extends AbstractHandler {

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Inject
	private JvmElementAtOffsetHelper jvmElementAtOffsetHelper;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
		if (editor != null) {
			final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
			editor.getDocument().readOnly(new IUnitOfWork<Void, XtextResource>() {
				public java.lang.Void exec(XtextResource resource) throws Exception {
					JvmIdentifiableElement jvmIdentifiable = jvmElementAtOffsetHelper.getJvmIdentifiableElement(resource, selection.getOffset());
					if (jvmIdentifiable != null) {
						IJavaElement javaType = javaElementFinder.findElementFor(jvmIdentifiable);
							if (javaType != null)
								openPresentation(editor, javaType, null);
					}
					return null;
				}
			});
		}
		return null;
	}

	protected abstract void openPresentation(final XtextEditor editor, final IJavaElement javaElement, final EObject selectedElement);

}
