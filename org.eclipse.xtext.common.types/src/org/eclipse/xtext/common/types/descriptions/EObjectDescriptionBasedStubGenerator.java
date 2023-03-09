/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import static org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.5
 */
public class EObjectDescriptionBasedStubGenerator implements IStubGenerator {

	public String getJavaStubSource(IEObjectDescription description, IResourceDescription resourceDescription) {
		if(isNestedType(description) || !isJvmDeclaredType(description)) {
			return null;
		}
		Multimap<QualifiedName, IEObjectDescription> owner2nested = LinkedHashMultimap.create();
		for(IEObjectDescription other: resourceDescription.getExportedObjects()) {
			if(isJvmDeclaredType(other) && isNestedType(other))
				owner2nested.put(getOwnerClassName(other.getQualifiedName()), other);
		}
		StringBuilder classSignatureBuilder = new StringBuilder();
		QualifiedName qualifiedName = description.getQualifiedName();
		if (qualifiedName.getSegments().size() > 1) {
			String string = qualifiedName.toString();
			classSignatureBuilder.append("package " + string.substring(0, string.lastIndexOf('.')) + ";");
		}
		appendType(description, owner2nested, classSignatureBuilder);
		return classSignatureBuilder.toString();
	}

	protected void appendType(final IEObjectDescription description, Multimap<QualifiedName, IEObjectDescription> owner2nested,
			StringBuilder classSignatureBuilder) {
		classSignatureBuilder.append("\npublic ");
		if(isNestedType(description))
			classSignatureBuilder.append("static ");
		if (description.getEClass() == TypesPackage.Literals.JVM_GENERIC_TYPE) {
			if (description.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE) != null) {
				classSignatureBuilder.append("interface ");
			} else {
				classSignatureBuilder.append("class ");
			}
		} else if (description.getEClass() == TypesPackage.Literals.JVM_ENUMERATION_TYPE) {
			classSignatureBuilder.append("enum ");
		} else if (description.getEClass() == TypesPackage.Literals.JVM_ANNOTATION_TYPE) {
			classSignatureBuilder.append("@interface ");
		}
		String lastSegment = description.getQualifiedName().getLastSegment();
		int trimIndex = lastSegment.lastIndexOf('$');
		String simpleName = lastSegment.substring(trimIndex + 1);
		classSignatureBuilder.append(simpleName);
		String typeParameters = description.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS);
		if (typeParameters != null) {
			classSignatureBuilder.append(typeParameters);
		}
		classSignatureBuilder.append("{");
		for(IEObjectDescription nested: owner2nested.get(description.getQualifiedName())) {
			appendType(nested, owner2nested, classSignatureBuilder);
		}
		classSignatureBuilder.append("\n}");
	}

	protected QualifiedName getOwnerClassName(QualifiedName nestedClassName) {
		String lastSegment = nestedClassName.getLastSegment();
		int trimIndex = lastSegment.lastIndexOf('$');
		if(trimIndex == -1)
			return nestedClassName.skipLast(1);
		else
			return nestedClassName.skipLast(1).append(lastSegment.substring(0, trimIndex));
	}
	
	public String getJavaFileName(IEObjectDescription description) {
		if (!isJvmDeclaredType(description)) {
			return null;
		}
		QualifiedName typeName = description.getName();
		return Strings.concat("/", typeName.getSegments()) + ".java";
	}

	protected boolean isNestedType(IEObjectDescription description) {
		return description.getUserData(IS_NESTED_TYPE) != null;
	}

	protected boolean isJvmDeclaredType(IEObjectDescription description) {
		EClass eClass = description.getEClass();
		return (eClass == TypesPackage.Literals.JVM_GENERIC_TYPE
				|| eClass == TypesPackage.Literals.JVM_ENUMERATION_TYPE 
				|| eClass == TypesPackage.Literals.JVM_ANNOTATION_TYPE);
	}

	
	@Override
	public void doGenerateStubs(IFileSystemAccess access, IResourceDescription description) {
		for (IEObjectDescription objectDesc : description.getExportedObjects()) {
			String javaStubSource = getJavaStubSource(objectDesc, description);
			if(javaStubSource != null) {
				String javaFileName = getJavaFileName(objectDesc);
				access.generateFile(javaFileName, javaStubSource);
			}
		}
	}
}
