/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeSerializationUtil {

	@Inject 
	private XtypeTypeReferenceSerializer serializer;

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private IImportsConfiguration importsConfig;
	
	public String serialize(JvmType type, EObject context) {
		return serialize(typeReferences.createTypeRef(type), context);
	}
	
	@SuppressWarnings("null")
	public String serialize(JvmTypeReference typeRef, EObject context) {
		if(typeRef == null) 
			return "void";
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(getImportManager(context));
		serializer.serialize(typeRef, context, appendable);
		return appendable.toString();
	}

	public ImportManager getImportManager(EObject context) {
		ImportManager importManager = new ImportManager(true);
		XImportSection importSection = importsConfig.getImportSection((XtextResource) context.eResource());
		if(importSection != null) {
			for(XImportDeclaration ximport: importSection.getImportDeclarations()) 
				importManager.addImportFor(ximport.getImportedType());
		}
		return importManager;
	}

}
