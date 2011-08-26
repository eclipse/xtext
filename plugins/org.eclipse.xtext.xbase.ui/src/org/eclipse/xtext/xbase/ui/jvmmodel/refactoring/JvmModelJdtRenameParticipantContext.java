/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenamePartcipant;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * The context of the refactoring of an Xtext source element with an inferred JVM element, triggered by the
 * {@link JdtRenamePartcipant}.
 * 
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmModelJdtRenameParticipantContext extends IRenameElementContext.Impl {

	public JvmModelJdtRenameParticipantContext(URI targetElementURI, EClass targetElementEClass) {
		super(targetElementURI, targetElementEClass);
	}

	public static class ContextFactory extends JdtRenamePartcipant.ContextFactory {
		@Inject
		private IJvmModelAssociations associations;

		@Override
		protected List<? extends IRenameElementContext> createJdtParticipantXtextSourceContext(EObject indexedJvmElement) {
			EObject renameTargetElement = associations.getPrimarySourceElement(indexedJvmElement);
			if (renameTargetElement != null) {
				return singletonList(new JvmModelJdtRenameParticipantContext(
						EcoreUtil2.getNormalizedURI(renameTargetElement), renameTargetElement.eClass()));
			}
			return super.createJdtParticipantXtextSourceContext(indexedJvmElement);
		}
	}
}
