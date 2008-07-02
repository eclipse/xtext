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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.IRegion;
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

	public abstract AbstractNode getParseTreeRootNode();

	public abstract EObject getAstRoot();

	public abstract void addModelListener(IXtextEditorModelListener listener);

	public abstract void removeModelListener(IXtextEditorModelListener listener);

	public abstract void reconcile(IRegion partition);

	public abstract Resource getResource();
}