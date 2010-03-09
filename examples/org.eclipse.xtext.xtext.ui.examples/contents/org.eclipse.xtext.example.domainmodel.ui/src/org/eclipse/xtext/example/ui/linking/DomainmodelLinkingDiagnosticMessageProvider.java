/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.ui.linking;

import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.DiagnosticSeverity;
import org.eclipse.xtext.example.domainmodel.Attribute;
import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.Reference;
import org.eclipse.xtext.example.domainmodel.TypeRef;
import org.eclipse.xtext.example.domainmodel.util.DomainmodelSwitch;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DomainmodelLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider {

	public static final String MISSING_SUPERTYPE = "org.eclipse.xtext.example.domainmodel.MISSING_SUPERTYPE";
	public static final String MISSING_ATTRIBUTE_TYPE = "org.eclipse.xtext.example.domainmodel.MISSING_ATTRIBUTE_TYPE";
	public static final String MISSING_REFERENCE_TYPE = "org.eclipse.xtext.example.domainmodel.MISSING_REFERENCE_TYPE";

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticContext context) {
		DiagnosticMessage diagnosticMessage = new DomainmodelSwitch<DiagnosticMessage>() {
			@Override
			public DiagnosticMessage caseEntity(Entity entity) {
				return new DiagnosticMessage("Missing supertype " + context.getLinkText(), DiagnosticSeverity.ERROR,
						MISSING_SUPERTYPE, context.getLinkText());
			}

			@Override
			public DiagnosticMessage caseTypeRef(TypeRef typeRef) {
				return doSwitch(typeRef.eContainer());
			}

			@Override
			public DiagnosticMessage caseAttribute(Attribute object) {
				if (context.getReference() == DomainmodelPackage.Literals.TYPE_REF__REFERENCED) {
					return new DiagnosticMessage("Missing attribute type " + context.getLinkText(),
							DiagnosticSeverity.ERROR, MISSING_ATTRIBUTE_TYPE, context.getLinkText());
				}
				return null;
			}

			@Override
			public DiagnosticMessage caseReference(Reference object) {
				if (context.getReference() == DomainmodelPackage.Literals.TYPE_REF__REFERENCED) {
					return new DiagnosticMessage("Missing reference type " + context.getLinkText(),
							DiagnosticSeverity.ERROR, MISSING_REFERENCE_TYPE, context.getLinkText());
				}
				return null;
			}
		}.doSwitch(context.getContext());
		return diagnosticMessage != null ? diagnosticMessage : super.getUnresolvedProxyMessage(context);
	}
}
