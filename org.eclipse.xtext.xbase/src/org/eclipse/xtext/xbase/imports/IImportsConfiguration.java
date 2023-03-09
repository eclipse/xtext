/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.inject.ImplementedBy;

/**
 * Language dependent configuration for the 'import' related things.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultImportsConfiguration.class)
public interface IImportsConfiguration {

	XImportSection getImportSection(XtextResource resource);

	int getImportSectionOffset(XtextResource resource);

	Set<String> getImplicitlyImportedPackages(XtextResource resource);

	Iterable<JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource);
	
	JvmDeclaredType getContextJvmDeclaredType(EObject model);
	
	/**
	 * Returns the syntax that was used in the import declaration if (and only if) it uses
	 * the legacy notation with a '$' as the delimiter for nested types. Otherwise the result 
	 * is null. Also returns null, if no node model is attached. 
	 */
	String getLegacyImportSyntax(XImportDeclaration importDeclaration);

	String getPackageName(XtextResource xtextResource);
}
