/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.service.ILanguageDescriptor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IEditorModel {

	public abstract List<SyntaxError> getSyntaxErrors();

	public abstract boolean hasErrors();

	public abstract ILanguageDescriptor getLanguageDescriptor();

	public abstract void reconcile();

	public abstract AbstractNode getParseTreeRootNode();

	public abstract AbstractNode getParseTreeRootNode(boolean doReconcile);

	public abstract EObject getAstRoot();

	public abstract EObject getAstRoot(boolean doReconcile);

	public abstract void install();

	public abstract void uninstall();

	public abstract void addModelListener(IXtextEditorModelListener listener);

	public abstract void removeModelListener(IXtextEditorModelListener listener);
}