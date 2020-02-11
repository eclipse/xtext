/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.navigation;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IMember;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DerivedMemberAwareEditorOpener extends LanguageSpecificURIEditorOpener implements IDerivedMemberAwareEditorOpener{

	@Inject
	private IJvmModelAssociations associations;
	
	@Override
	public IEditorPart open(URI uri, IMember member, boolean select) {
		if (member != null) {
			URI memberURI = new TypeURIHelper().getFullURI(member);
			String identifier = memberURI.fragment();
			// we decode the qualified name into the uri using query, such that it can be read out in #findEObjectByURI again
			URI uriWithQuery = uri.appendQuery(identifier);
			return super.open(uriWithQuery, select);
		}
		return open(uri, select);
	}
	
	@Override
	protected EObject findEObjectByURI(URI uri, XtextResource resource) {
		if (uri.query() != null) {
			String identifier = uri.query();
			TreeIterator<EObject> contents = EcoreUtil.<EObject>getAllContents(resource, true);
			while(contents.hasNext()) {
				EObject content = contents.next();
				if (content instanceof JvmMember) {
					String identifierFromResource = ((JvmIdentifiableElement) content).getIdentifier();
					if (identifier.equals(identifierFromResource)) {
						EObject sourceElement = associations.getPrimarySourceElement(content);
						return sourceElement;
					}
				}
			}
		}
		return super.findEObjectByURI(uri, resource);
	}

}
