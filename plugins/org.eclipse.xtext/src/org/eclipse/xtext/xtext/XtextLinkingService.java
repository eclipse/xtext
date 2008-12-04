/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.crossref.impl.SimpleAttributeResolver;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkingService;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextLinkingService extends XtextBuiltinLinkingService {

	private final SimpleAttributeResolver<String> aliasResolver;
	
	public XtextLinkingService() {
		super();
		aliasResolver = SimpleAttributeResolver.newResolver(String.class, "alias");
	}

	@Override
	public String getLinkText(EObject object, EReference reference, EObject context) {
		if ((object instanceof AbstractMetamodelDeclaration) && 
				reference.getFeatureID() == XtextPackage.TYPE_REF__METAMODEL &&
				(context instanceof TypeRef))
			return aliasResolver.getValue(object);
		return super.getLinkText(object, reference, context);
	}
	
}
