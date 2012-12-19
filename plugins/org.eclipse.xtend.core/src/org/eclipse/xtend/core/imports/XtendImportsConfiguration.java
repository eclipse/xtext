/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

import static com.google.common.collect.Maps.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.scoping.XtendImportedNamespaceScopeProvider;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendImportsConfiguration extends DefaultImportsConfiguration {
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Override
	public XImportSection getImportSection(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		if(xtendFile != null)
			return xtendFile.getImportSection();
		else
			return null;
	}

	@Override
	public String getCommonPackageName(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		return xtendFile == null ? null : xtendFile.getPackage();
	}
	
	@Override
	public Map<String, JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		if(xtendFile == null)
			return emptyMap();
		Map<String, JvmDeclaredType> locallyDefinedTypes = newHashMap();
		for(XtendTypeDeclaration xtendType: xtendFile.getXtendTypes())  {
			for(EObject inferredElement: associations.getJvmElements(xtendType)) {
				if(inferredElement instanceof JvmDeclaredType) {
					JvmDeclaredType declaredType = (JvmDeclaredType) inferredElement;
					locallyDefinedTypes.put(declaredType.getSimpleName(), declaredType);
					addInnerTypes(declaredType, "", locallyDefinedTypes);
				}
			}
		}
		return locallyDefinedTypes;
	}

	protected XtendFile getXtendFile(XtextResource resource) {
		if(resource == null || resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof XtendFile))
			return null;
		else 
			return (XtendFile) resource.getContents().get(0);
	}
	
	@Override
	public Set<String> getImplicitlyImportedPackages(XtextResource resource) {
		Set<String> implicitlyImportedPackages = super.getImplicitlyImportedPackages(resource);
		implicitlyImportedPackages.add(XtendImportedNamespaceScopeProvider.XTEND_LIB.toString("."));
		return implicitlyImportedPackages;
	}
	
	@Override
	public int getImportSectionOffset(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		if(xtendFile != null) {
			if(!isEmpty(xtendFile.getPackage())) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(xtendFile, XtendPackage.Literals.XTEND_FILE__PACKAGE);
				if(!nodes.isEmpty())
					return nodes.get(nodes.size()-1).getTotalEndOffset();
			}
		}
		return 0;
	}
	
	@Override
	public JvmDeclaredType getContextJvmDeclaredType(EObject model) {
		XtendClass xtendClass = EcoreUtil2.getContainerOfType(model, XtendClass.class);
		return associations.getInferredType(xtendClass);
	}
}
