/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import static org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy.*;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.5
 */
public class EObjectDescriptionBasedStubGenerator implements IStubGenerator {
	
	public String getJavaStubSource(IEObjectDescription description) {
		if (!isJvmDeclaredType(description)) {
			return null;
		}
		QualifiedName qualifiedName = description.getQualifiedName();
		
		StringBuilder classSignatureBuilder = new StringBuilder();
		if (qualifiedName.getSegments().size()>1) {
			String string = qualifiedName.toString();
			classSignatureBuilder.append("package " + string.substring(0, string.lastIndexOf('.')) + ";");
			classSignatureBuilder.append("\n");
		}
		classSignatureBuilder.append("public ");
		if(description.getEClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			if (description.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE) != null) {
				classSignatureBuilder.append("interface ");
			} else {
				classSignatureBuilder.append("class ");
			}
		} else if(description.getEClass() == TypesPackage.Literals.JVM_ENUMERATION_TYPE) {
			classSignatureBuilder.append("enum ");
		} else if (description.getEClass() == TypesPackage.Literals.JVM_ANNOTATION_TYPE) {
			classSignatureBuilder.append("@interface ");
		}
		classSignatureBuilder.append(qualifiedName.getLastSegment());
		String typeParameters = description.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS);
		if (typeParameters != null) {
			classSignatureBuilder.append(typeParameters);
		}
		classSignatureBuilder.append("{}");
		return classSignatureBuilder.toString();
	}
	
	public String getJavaFileName(IEObjectDescription description) {
		if (!isJvmDeclaredType(description)) {
			return null;
		}
		QualifiedName typeName = description.getName();
		return Strings.concat("/", typeName.getSegments()) + ".java";
	}

	protected boolean isJvmDeclaredType(IEObjectDescription description) {
		return description.getEObjectOrProxy() instanceof JvmDeclaredType && description.getUserData(IS_NESTED_TYPE) == null;
	}

	public void doGenerateStubs(IFileSystemAccess access, IResourceDescription description) {
		for (IEObjectDescription objectDesc: description.getExportedObjects()) {
			String javaFileName = getJavaFileName(objectDesc);
			if (javaFileName != null) {
				String javaStubSource = getJavaStubSource(objectDesc);
				access.generateFile(javaFileName, javaStubSource);
			}
		}
	}
}
