/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ITokenDiagnosticProvider;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;

/**
 * A facade for the old and the new serializer. Subclasses can choose strategies to handle name collisions.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @deprecated since 2.4. Use {@link RefactoringCrossReferenceSerializer} instead
 */
@Deprecated
public class CrossReferenceSerializerFacade {

	private static final Logger LOG = Logger.getLogger(CrossReferenceSerializerFacade.class);

	private boolean useNewSerializer;

	@Inject(optional = true)
	private org.eclipse.xtext.parsetree.reconstr.impl.CrossReferenceSerializer oldCrossRefSerializer;

	@Inject(optional = true)
	private org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer newCrossRefSerializer;

	@Inject
	protected void setSerializer(ISerializer serializer) {
		useNewSerializer = serializer instanceof org.eclipse.xtext.serializer.impl.Serializer;
		if (useNewSerializer)
			Assert.isTrue(newCrossRefSerializer != null);
		else
			Assert.isTrue(oldCrossRefSerializer != null);
	}

	public boolean useNewSerializer() {
		return useNewSerializer;
	}
	
	public String serializeCrossRef(EObject owner, CrossReference crossref, EObject target, ITextRegion linkTextRegion,
			StatusWrapper status) {
		try {
			if (useNewSerializer)
				return serializeCrossRefNew(owner, crossref, target, linkTextRegion, status);
			else
				return serializeCrossRefOld(owner, crossref, target, linkTextRegion, status);
		} catch (Exception exc) {
			LOG.error("Error updating cross-reference", exc);
			handleException(exc, owner, linkTextRegion, status);
			return null;
		}
	}

	protected String serializeCrossRefOld(EObject owner, CrossReference crossref, EObject target,
			 ITextRegion linkTextRegion, StatusWrapper status) {
		String linkText = oldCrossRefSerializer.serializeCrossRef(owner, crossref, target, null);
		if (linkText == null)
			handleNameCollision(owner, linkTextRegion, status);
		return linkText;
	}

	protected String serializeCrossRefNew(EObject owner, CrossReference crossref, EObject target,
			ITextRegion linkTextRegion, StatusWrapper status) {
		final boolean[] hasNameCollision = new boolean[] { false };
		String linkText = newCrossRefSerializer.serializeCrossRef(owner, crossref, target, null,
				new ISerializationDiagnostic.ExceptionThrowingAcceptor() {
					@Override
					public void accept(ISerializationDiagnostic diagnostic) {
						if (ITokenDiagnosticProvider.NO_EOBJECT_DESCRIPTION_FOUND.equals(diagnostic.getId())) {
							hasNameCollision[0] = true;
						} else {
							super.accept(diagnostic);
						}
					}
				});
		if (hasNameCollision[0])
			return handleNameCollision(owner, linkTextRegion, status);
		return linkText;
	}

	protected String handleNameCollision(EObject owner, ITextRegion linkTextRegion, StatusWrapper status) {
		return handleError("Renaming element will break existing cross-reference", owner, linkTextRegion, status);
	}

	protected String handleException(Exception exc, EObject owner, ITextRegion linkTextRegion, StatusWrapper status) {
		return handleError(exc.getMessage(), owner, linkTextRegion, status);
	}

	protected String handleError(String message, EObject owner, ITextRegion linkTextRegion, StatusWrapper status) {
		status.add(ERROR, message, owner, linkTextRegion);
		return null;
	}

}
