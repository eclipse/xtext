/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import static org.eclipse.emf.ecore.util.EcoreUtil.*;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * Context used to for renaming JVM elements that are not inside an indexed resource, thus only cross-referenced and not
 * generated/inferred from a model element.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JdtRenameParticipantContext extends IRenameElementContext.Impl {

	private IJavaElement renamedJavaElement;
	
	/**
	 * @since 2.4
	 */
	private JdtRenameParticipant participant;

	public JdtRenameParticipantContext(JdtRenameParticipant participant, 
			JvmMember renamedJvmMember, 
			IJavaElement referencedJavaElement) {
		super(getURI(renamedJvmMember), renamedJvmMember.eClass());
		this.participant = participant;
		this.renamedJavaElement = referencedJavaElement;
	}

	public IJavaElement getRenamedJavaElement() {
		return renamedJavaElement;
	}
	
	/**
	 * @since 2.4
	 */
	public JdtRenameParticipant getJdtRenameParticipant() {
		return participant;
	}
}
