/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;

/**
 * Resource implementation that instantiates the infered packages as part of the
 * derived state computation.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarResource extends DerivedStateAwareResource {

	/**
	 * Overridden to do only the clean-part of the linking but not
	 * the actual linking. This is deferred until someone wants to access
	 * the content of the resource.
	 */
	@Override
	protected void doLinking() {
		IParseResult parseResult = getParseResult();
		if (parseResult == null || parseResult.getRootASTElement() == null)
			return;

		XtextLinker castedLinker = (XtextLinker) getLinker();
		castedLinker.discardGeneratedPackages(parseResult.getRootASTElement());
	}
	
	/**
	 * Performs the actual linking.
	 */
	protected void superDoLinking() {
		super.doLinking();
	}
	
	/**
	 * Overridden to make sure the errors are up-to-date when someone wants to access them.
	 */
	@Override
	public EList<Diagnostic> getErrors() {
		// trigger derived state computation
		getContents();
		return super.getErrors();
	}
	
	/**
	 * Overridden to make sure the warnings are up-to-date when someone wants to access them.
	 */
	@Override
	public EList<Diagnostic> getWarnings() {
		// trigger derived state computation
		getContents();
		return super.getWarnings();
	}
	
	/**
	 * Triggers the ecore inference as soon as someone wants to access the contents
	 * of a {@link GrammarResource}.
	 */
	public static class LinkingTrigger implements IDerivedStateComputer {

		public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
			if (preLinkingPhase)
				return;
			GrammarResource castedResource = (GrammarResource)resource;
			castedResource.superDoLinking();
		}

		public void discardDerivedState(DerivedStateAwareResource resource) {
		}
		
	}
	
}
