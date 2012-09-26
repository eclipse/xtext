/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.scoping.XtendImportedNamespaceScopeProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OrganizeImports {

	@Inject
	private Provider<ReferenceAcceptor> referenceAcceptorProvider;
	
	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private ImplicitlyImportedTypes implicitlyImportedTypes;
	
	public String getOrganizedImportSection(XtextResource state) {
		ReferenceAcceptor acceptor = intitializeReferenceAcceptor(state);
		if(acceptor == null)
			return null;
		String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(state.getURI()).getLineSeparator();
		return serializeImports(acceptor, lineSeparator);
	}

	public ReferenceAcceptor intitializeReferenceAcceptor(XtextResource state) {
		ReferenceAcceptor acceptor = referenceAcceptorProvider.get();
		final XtendFile xtendFile = getXtendFile(state);
		if (xtendFile == null)
			return null;
		acceptor.addImplicitlyImportedPackages(newArrayList(
				XtendImportedNamespaceScopeProvider.JAVA_LANG.toString("."), 
				XtendImportedNamespaceScopeProvider.XTEND_LIB.toString("."), 
				xtendFile.getPackage()));
		acceptor.setImplicitlyImportedTypes(implicitlyImportedTypes.getStaticImportClasses(state), implicitlyImportedTypes.getExtensionClasses(state));
		List<String> simpleNames = Lists.newArrayListWithExpectedSize(2);
		for(XtendTypeDeclaration declaration: xtendFile.getXtendTypes()) {
			simpleNames.add(declaration.getName());
		}
		acceptor.setLocallyDefinedSimpleNames(simpleNames);
		collectAllReferences(state, acceptor);
		return acceptor;
	}

	public String serializeImports(IImportCollection importCollection, String lineSeparator) {
		StringBuilder importsSection = new StringBuilder();
		List<String> listofImportedTypeNames = importCollection.getListofImportedTypeNames();
		if (!listofImportedTypeNames.isEmpty()) {
			importsSection.append(lineSeparator);
			for (String qn : listofImportedTypeNames) {
				importsSection.append(lineSeparator).append("import ").append(qn);
			}
		}
		final List<String> listofStaticImports = importCollection.getListofStaticImports();
		if (!listofStaticImports.isEmpty()) {
			importsSection.append(lineSeparator);
			for (String qn : listofStaticImports) {
				importsSection.append(lineSeparator).append("import static ").append(qn).append(".*");
			}
		}
		final List<String> listofStaticExtensionImports = importCollection.getListofStaticExtensionImports();
		if (!listofStaticExtensionImports.isEmpty()) {
			importsSection.append(lineSeparator);
			for (String qn : listofStaticExtensionImports) {
				importsSection.append(lineSeparator).append("import static extension ").append(qn).append(".*");
			}
		}
		return importsSection.toString();
	}

	public TextRegion computeRegion(XtextResource resource) {
		final XtendFile xtendFile = getXtendFile(resource);
		if (xtendFile == null)
			return null;
		List<INode> packDecl = NodeModelUtils
				.findNodesForFeature(xtendFile, XtendPackage.Literals.XTEND_FILE__PACKAGE);
		int offset = 0;
		if (packDecl.size() >= 1)
			offset = packDecl.get(0).getOffset() + packDecl.get(0).getLength();
		if (xtendFile.getXtendTypes() == null)
			return null;
		if (xtendFile.getXtendTypes().isEmpty()) {
			ICompositeNode node = NodeModelUtils.getNode(xtendFile);
			if (node == null)
				throw new IllegalStateException("Cannot find node for clazz " + xtendFile.getClass().getName());
			return new TextRegion(offset, node.getTotalEndOffset() - offset);
		}
		ICompositeNode node = NodeModelUtils.getNode(xtendFile.getXtendTypes().get(0));
		if (node == null)
			throw new IllegalStateException("Cannot find node for clazz " + xtendFile.getClass().getName());
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
			if (next instanceof XtendTypeDeclaration) {
				Set<EObject> elements = associations.getJvmElements(next);
				if (!elements.isEmpty()) {
					EObject type = elements.iterator().next();
					if (type instanceof JvmDeclaredType) {
						acceptor.setThisType((JvmDeclaredType) type);
					}
				}
			} else if (next instanceof JvmTypeReference) {
				acceptor.acceptType((JvmTypeReference) next);
			} else if (next instanceof XAnnotation) {
				acceptor.acceptPreferredType(next, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE);
			} else if (next instanceof XInstanceOfExpression) {
				acceptor.acceptType(((XInstanceOfExpression) next).getType());
			} else if (next instanceof XConstructorCall) {
				acceptor.acceptPreferredType(next, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
			} else if (next instanceof XTypeLiteral) {
				acceptor.acceptPreferredType(next, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			} else if (next instanceof XFeatureCall) {
				final XFeatureCall featureCall = (XFeatureCall) next;
				if (featureCall.getDeclaringType() == null) {
					final JvmIdentifiableElement member = featureCall.getFeature();
					if (member instanceof JvmOperation) {
						JvmOperation operation = (JvmOperation) member;
						if (operation.isStatic()) {
							if (!operation.isVarArgs() && operation.getParameters().size() > featureCall.getExplicitArguments().size()) {
								acceptor.acceptStaticExtensionImport(operation);
							} else {
								acceptor.acceptStaticImport(operation);
							}
						}
					}
					if (member instanceof JvmField) {
						if (((JvmField) member).isStatic()) {
							acceptor.acceptStaticImport((JvmMember) member);
						}
					}
				} else {
					acceptor.acceptPreferredType(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE);
				}
			} else if (next instanceof XMemberFeatureCall || next instanceof XBinaryOperation || next instanceof XUnaryOperation || next instanceof XAssignment) {
				final XAbstractFeatureCall featureCall = (XAbstractFeatureCall) next;
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

	public static class ReferenceAcceptor implements IImportCollection {

		@Inject
		private SuperTypeCollector superTypeCollector;
		
		public Set<JvmType> types = newLinkedHashSet();
		public Set<JvmType> staticMembers = newLinkedHashSet();
		public Set<JvmType> staticExtensionMembers = newLinkedHashSet();
		private Set<String> implicitPackageImports = newLinkedHashSet();
		private JvmDeclaredType thisType = null;
		
		private Set<JvmType> knownTypesForStaticImports = null;

		private List<JvmType> implicitStaticImportClasses;
		private List<JvmType> implicitExtensionClasses;
		private List<String> locallyDefinedTypes;
		
		public void setThisType(JvmDeclaredType declaredType) {
			this.thisType = declaredType;
			knownTypesForStaticImports = null;
		}

		public void setLocallyDefinedSimpleNames(List<String> simpleNames) {
			this.locallyDefinedTypes = simpleNames;
		}

		public void setImplicitlyImportedTypes(List<JvmType> implicitStaticImportClasses, List<JvmType> implicitExtensionClasses) {
			this.implicitStaticImportClasses = implicitStaticImportClasses;
			this.implicitExtensionClasses = implicitExtensionClasses;
		}

		public void acceptType(JvmTypeReference ref) {
			if (ref instanceof XFunctionTypeRef)
				return;
			if (ref.eContainer() instanceof XFunctionTypeRef && ref.eContainmentFeature() == TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT)
				return;
			acceptPreferredType(ref);
			if (ref instanceof JvmParameterizedTypeReference) {
				List<JvmTypeReference> list = ((JvmParameterizedTypeReference) ref).getArguments();
				for (JvmTypeReference jvmTypeReference : list) {
					acceptPreferredType(jvmTypeReference);
				}
			} else if (ref instanceof JvmWildcardTypeReference) {
				List<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) ref).getConstraints();
				for (JvmTypeConstraint jvmTypeConstraint : constraints) {
					acceptPreferredType(jvmTypeConstraint.getTypeReference());
				}
			}
		}
		
		public void acceptPreferredType(JvmTypeReference ref) {
			if (ref instanceof JvmParameterizedTypeReference) {
				acceptPreferredType(ref, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
			} else {
				acceptType(ref.getType());
			}
		}
		
		/**
		 * Tries to locate the syntax for the type reference that the user used in the original code.
		 * Especially interesting for nested types, where one could prefer the (arguably) more explicit (or verbose)
		 * {@code Resource$Factory} with an import of {@code org.eclipse.emf.core.Resource} over the probably shorter
		 * {@code Factory} with an import of {@code org.eclipse.emf.core.Resource$Factory}.
		 * 
		 * The function relies on a node model to be available. Otherwise the actually referenced type is 
		 * used as the preferred type.
		 * 
		 * @param owner the referrer to the JVM concept.
		 * @param reference a reference to a {@link JvmType} or {@link JvmMember} that is declared in a type.
		 * @return the referenced type or one of its containers.
		 */
		public JvmType findPreferredType(EObject owner, EReference reference) {
			JvmIdentifiableElement referencedThing = (JvmIdentifiableElement) owner.eGet(reference);
			JvmType referencedType = null;
			if (referencedThing instanceof JvmType) {
				referencedType = (JvmType) referencedThing;
			} else if (referencedThing instanceof JvmMember) {
				referencedType = ((JvmMember) referencedThing).getDeclaringType();
			}
			List<INode> nodes = NodeModelUtils.findNodesForFeature(owner, reference);
			if (nodes.size() == 1) {
				String text = NodeModelUtils.getTokenText(nodes.get(0));
				int dollar = text.indexOf('$');
				if (dollar >= 0 && referencedType instanceof JvmDeclaredType) {
					JvmDeclaredType declaredType = (JvmDeclaredType) referencedType;
					while(declaredType.getDeclaringType() != null && dollar >= 0) {
						declaredType = declaredType.getDeclaringType();
						dollar = text.indexOf('$', dollar + 1);
					}
					return declaredType;
				}
			}
			return referencedType;
		}
		
		public void addImplicitlyImportedPackages(Collection<? extends String> implicitlyImportedPackage) {
			implicitPackageImports.addAll(implicitlyImportedPackage);
		}

		public List<String> getListofStaticExtensionImports() {
			List<String> result = newArrayList();
			for (JvmType type : staticExtensionMembers) {
				result.add(type.getIdentifier());
			}
			Collections.sort(result);
			return result;
		}

		public List<String> getListofStaticImports() {
			List<String> result = newArrayList();
			for (JvmType type : staticMembers) {
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

		public void acceptPreferredType(EObject owner, EReference referenceToTypeOrMember) {
			acceptType(findPreferredType(owner, referenceToTypeOrMember));
		}
		
		public void acceptType(JvmType type) {
			if (type != null && !type.equals(this.thisType) && !locallyDefinedTypes.contains(type.getSimpleName())) {
				types.add(type);
			}
		}

		public void acceptStaticImport(JvmMember member) {
			JvmDeclaredType declarator = member.getDeclaringType();
			if (thisType == declarator || implicitStaticImportClasses.contains(declarator))
				return;
			if (knownTypesForStaticImports == null) {
				JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
				reference.setType(thisType);
				knownTypesForStaticImports = superTypeCollector.collectSuperTypesAsRawTypes(reference);
			}
			if (knownTypesForStaticImports.contains(declarator))
				return;
			staticMembers.add(declarator);
		}

		public void acceptStaticExtensionImport(JvmMember member) {
			JvmDeclaredType declarator = member.getDeclaringType();
			if (implicitExtensionClasses.contains(declarator))
				return;
			staticExtensionMembers.add(declarator);
		}
	}

}
