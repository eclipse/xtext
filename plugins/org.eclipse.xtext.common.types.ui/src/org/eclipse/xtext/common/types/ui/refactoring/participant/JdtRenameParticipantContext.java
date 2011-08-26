/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import static org.eclipse.emf.ecore.util.EcoreUtil.*;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JdtRenameParticipantContext extends IRenameElementContext.Impl {

	private IJavaElement renamedJavaElement;
	
	public JdtRenameParticipantContext(JvmMember renamedJvmMember,
			IJavaElement referencedJavaElement) {
		super(getURI(renamedJvmMember), renamedJvmMember.eClass());
		this.renamedJavaElement = referencedJavaElement;
	}

	public JdtRenameParticipantContext(URI renamedJvmMemberURI, EClass renamedJvmMemberEClass,
			IJavaElement referencedJavaElement) {
		super(renamedJvmMemberURI, renamedJvmMemberEClass);
		this.renamedJavaElement = referencedJavaElement;
	}

	public IJavaElement getRenamedJavaElement() {
		return renamedJavaElement;
	}

}
