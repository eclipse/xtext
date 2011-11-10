/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.formatting;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OrganizeImports {

	@Inject
	private Provider<ReferenceAcceptor> referenceAcceptorProvider;
	
	public String getOrganizedImportSection(XtextResource state) {
		ReferenceAcceptor acceptor = referenceAcceptorProvider.get();
		final XtendFile xtendFile = getXtendFile(state);
		if (xtendFile == null)
			return null;
		acceptor.addImplicitlyImportedPackages(newArrayList("java.lang", xtendFile.getPackage()));
		collectAllReferences(state, acceptor);
		StringBuilder importsSection = new StringBuilder();
		List<String> listofImportedTypeNames = acceptor.getListofImportedTypeNames();
		if (!listofImportedTypeNames.isEmpty()) {
			importsSection.append("\n");
			for (String qn : listofImportedTypeNames) {
				importsSection.append("\nimport ").append(qn);
			}
		}
		final List<String> listofStaticImports = acceptor.getListofStaticImports();
		if (!listofStaticImports.isEmpty()) {
			importsSection.append("\n");
			for (String qn : listofStaticImports) {
				importsSection.append("\nimport static ").append(qn).append(".*");
			}
		}
		final List<String> listofStaticExtensionImports = acceptor.getListofStaticExtensionImports();
		if (!listofStaticExtensionImports.isEmpty()) {
			importsSection.append("\n");
			for (String qn : listofStaticExtensionImports) {
				importsSection.append("\nimport static extension ").append(qn).append(".*");
			}
		}
		return importsSection.toString();
	}

	public TextRegion computeRegion(XtextResource resource) {
		final XtendFile xtendFile = getXtendFile(resource);
		if (xtendFile == null)
			return null;
		List<INode> packDecl = NodeModelUtils
				.findNodesForFeature(xtendFile, Xtend2Package.Literals.XTEND_FILE__PACKAGE);
		int offset = 0;
		if (packDecl.size() >= 1)
			offset = packDecl.get(0).getOffset() + packDecl.get(0).getLength();
		if (xtendFile.getXtendClass() == null)
			return null;
		ICompositeNode node = NodeModelUtils.getNode(xtendFile.getXtendClass());
		int length = node.getTotalOffset() - offset;
		return new TextRegion(offset, length);
	}

	protected XtendFile getXtendFile(XtextResource resource) {
		if (resource.getContents().isEmpty())
			return null;
		final EObject eObject = resource.getContents().get(0);
		if (!(eObject instanceof XtendFile))
			return null;
		final XtendFile xtendFile = (XtendFile) eObject;
		return xtendFile;
	}

	/*
	 * TODO traverse generically and use qualified name provider. 
	 */
	public void collectAllReferences(XtextResource resource, ReferenceAcceptor acceptor) {
		XtendFile xtendFile = getXtendFile(resource);
		TreeIterator<EObject> contents = EcoreUtil.getAllContents(xtendFile, true);
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof JvmTypeReference) {
				acceptor.acceptType((JvmTypeReference) next);
			} else if (next instanceof XAnnotation) {
				acceptor.acceptType(((XAnnotation) next).getAnnotationType());
			} else if (next instanceof XInstanceOfExpression) {
				acceptor.acceptType(((XInstanceOfExpression) next).getType());
			} else if (next instanceof XConstructorCall) {
				acceptor.acceptType(((XConstructorCall) next).getConstructor().getDeclaringType());
			} else if (next instanceof XTypeLiteral) {
				acceptor.acceptType(((XTypeLiteral) next).getType());
			} else if (next instanceof XFeatureCall) {
				final XFeatureCall featureCall = (XFeatureCall) next;
				if (featureCall.getDeclaringType() == null) {
					final JvmIdentifiableElement member = featureCall.getFeature();
					if (member instanceof JvmOperation) {
						if (((JvmOperation) member).isStatic())
							acceptor.acceptStaticImport((JvmMember) member);
					}
					if (member instanceof JvmField) {
						if (((JvmField) member).isStatic())
							acceptor.acceptStaticImport((JvmMember) member);
					}
				} else {
					acceptor.acceptType(featureCall.getDeclaringType());
				}
			} else if (next instanceof XMemberFeatureCall) {
				final XMemberFeatureCall featureCall = (XMemberFeatureCall) next;
				final JvmIdentifiableElement member = featureCall.getFeature();
				if (member instanceof JvmOperation) {
					if (((JvmOperation) member).isStatic())
						acceptor.acceptStaticExtensionImport((JvmMember) member);
				}
				if (member instanceof JvmField) {
					if (((JvmField) member).isStatic())
						acceptor.acceptStaticExtensionImport((JvmMember) member);
				}
			}
		}
	}

	public static class ReferenceAcceptor {

		public Set<JvmType> types = newLinkedHashSet();
		public Set<JvmType> staticMembers = newLinkedHashSet();
		public Set<JvmType> staticExtensionMembers = newLinkedHashSet();
		private Set<String> implicitPackageImports = newLinkedHashSet();

		public void acceptType(JvmTypeReference ref) {
			if (ref instanceof XFunctionTypeRef)
				return;
			if (ref.eContainer() instanceof XFunctionTypeRef && ref.eContainmentFeature() == TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT)
				return;
			acceptType(ref.getType());
			if (ref instanceof JvmParameterizedTypeReference) {
				EList<JvmTypeReference> list = ((JvmParameterizedTypeReference) ref).getArguments();
				for (JvmTypeReference jvmTypeReference : list) {
					acceptType(jvmTypeReference);
				}
			} else if (ref instanceof JvmWildcardTypeReference) {
				EList<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) ref).getConstraints();
				for (JvmTypeConstraint jvmTypeConstraint : constraints) {
					acceptType(jvmTypeConstraint.getTypeReference());
				}
			}
		}

		public void addImplicitlyImportedPackages(Collection<? extends String> implicitlyImportedPackage) {
			implicitPackageImports.addAll(implicitlyImportedPackage);
		}

		public List<String> getListofStaticExtensionImports() {
			List<String> result = newArrayList();
			for (JvmType type : staticExtensionMembers) {
				if (isMemberNeedsImport(type))
					result.add(type.getIdentifier());
			}
			Collections.sort(result);
			return result;
		}

		protected boolean isMemberNeedsImport(JvmType type) {
			return type instanceof JvmEnumerationType || type instanceof JvmGenericType
					&& !"org.eclipse.xtext.xbase.lib".equals(((JvmGenericType) type).getPackageName());
		}

		public List<String> getListofStaticImports() {
			List<String> result = newArrayList();
			for (JvmType type : staticMembers) {
				if (isMemberNeedsImport(type))
					result.add(type.getIdentifier());
			}
			// extension imports are static imports, so no need to have them twice.
			List<String> staticExtensionImports = getListofStaticExtensionImports();
			result.removeAll(staticExtensionImports);
			Collections.sort(result);
			return result;
		}

		public List<String> getListofImportedTypeNames() {
			Map<String, String> names = newLinkedHashMap();
			for (JvmType type : types) {
				if (type instanceof JvmDeclaredType) {
					final JvmDeclaredType jvmGenericType = (JvmDeclaredType) type;
					if (isTypeNeedsImport(jvmGenericType))
						addType(names, jvmGenericType);
				}
			}
			final ArrayList<String> result = newArrayList(names.values());
			Collections.sort(result);
			return result;
		}

		protected boolean isTypeNeedsImport(final JvmDeclaredType jvmType) {
			final String packageName = jvmType.getPackageName();
			return !this.implicitPackageImports.contains(packageName);
		}

		protected void addType(Map<String, String> names, JvmDeclaredType type) {
			String packageName = type.getPackageName();
			final String simpleName = packageName != null ? type.getQualifiedName().substring(packageName.length() + 1)
					: type.getQualifiedName();
			if (simpleName == null)
				return;
			if (!names.containsKey(simpleName)) {
				final String identifier = type.getIdentifier();
				if (identifier == null)
					return;
				names.put(simpleName, identifier);
			}
		}

		public void acceptType(JvmType type) {
			types.add(type);
		}

		public void acceptStaticImport(JvmMember member) {
			staticMembers.add(member.getDeclaringType());
		}

		public void acceptStaticExtensionImport(JvmMember member) {
			staticExtensionMembers.add(member.getDeclaringType());
		}
	}

}
