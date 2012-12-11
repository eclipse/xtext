/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.scoping.XtendImportedNamespaceScopeProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
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
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ImportCollector {
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private Provider<ImportModel> importModelProvider;

	public ImportModel intitializeReferenceAcceptor(XtendFile xtendFile) {
		if (xtendFile == null)
			return null;
		ImportModel model = importModelProvider.get();
		model.addImplicitlyImportedPackages(newArrayList(
				XtendImportedNamespaceScopeProvider.JAVA_LANG.toString("."), 
				XtendImportedNamespaceScopeProvider.XTEND_LIB.toString("."), 
				xtendFile.getPackage()));
		List<String> simpleNames = Lists.newArrayListWithExpectedSize(2);
		for(XtendTypeDeclaration declaration: xtendFile.getXtendTypes()) {
			simpleNames.add(declaration.getName());
		}
		model.setLocallyDefinedSimpleNames(simpleNames);
		collectAllReferences(xtendFile, model);
		return model;
	}

	/*
	 * TODO traverse generically and use qualified name provider. 
	 */
	public void collectAllReferences(XtendFile xtendFile, ImportModel importModel) {
		TreeIterator<EObject> contents = EcoreUtil.getAllContents(xtendFile, true);
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof XtendTypeDeclaration) {
				Set<EObject> elements = associations.getJvmElements(next);
				if (!elements.isEmpty()) {
					EObject type = elements.iterator().next();
					if (type instanceof JvmDeclaredType) {
						importModel.setThisType((JvmDeclaredType) type);
					}
				}
			} else if (next instanceof JvmTypeReference) {
				acceptType((JvmTypeReference) next, importModel);
			} else if (next instanceof XAnnotation) {
				acceptPreferredType(next, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, importModel);
			} else if (next instanceof XInstanceOfExpression) {
				acceptType(((XInstanceOfExpression) next).getType(), importModel);
			} else if (next instanceof XConstructorCall) {
				acceptPreferredType(next, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, importModel);
			} else if (next instanceof XTypeLiteral) {
				acceptPreferredType(next, XbasePackage.Literals.XTYPE_LITERAL__TYPE, importModel);
			} else if (next instanceof XFeatureCall) {
				final XFeatureCall featureCall = (XFeatureCall) next;
				if (featureCall.getDeclaringType() == null) {
					final JvmIdentifiableElement member = featureCall.getFeature();
					if (member instanceof JvmOperation) {
						JvmOperation operation = (JvmOperation) member;
						if (operation.isStatic()) {
							if (!operation.isVarArgs() && operation.getParameters().size() > featureCall.getExplicitArguments().size()) {
								importModel.acceptStaticExtensionImport(operation);
							} else {
								importModel.acceptStaticImport(operation);
							}
						}
					}
					if (member instanceof JvmField) {
						if (((JvmField) member).isStatic()) {
							importModel.acceptStaticImport((JvmMember) member);
						}
					}
				} else {
					acceptPreferredType(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE, importModel);
				}
			} else if (next instanceof XMemberFeatureCall || next instanceof XBinaryOperation || next instanceof XUnaryOperation || next instanceof XAssignment) {
				final XAbstractFeatureCall featureCall = (XAbstractFeatureCall) next;
				final JvmIdentifiableElement member = featureCall.getFeature();
				if (member instanceof JvmOperation) {
					if (((JvmOperation) member).isStatic())
						importModel.acceptStaticExtensionImport((JvmMember) member);
				}
				if (member instanceof JvmField) {
					if (((JvmField) member).isStatic())
						importModel.acceptStaticExtensionImport((JvmMember) member);
				}
			}
		}
	}
	
	public void acceptType(JvmTypeReference ref, ImportModel importModel) {
		if (ref instanceof XFunctionTypeRef)
			return;
		if (ref.eContainer() instanceof XFunctionTypeRef && ref.eContainmentFeature() == TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT)
			return;
		acceptPreferredType(ref, importModel);
		if (ref instanceof JvmParameterizedTypeReference) {
			List<JvmTypeReference> list = ((JvmParameterizedTypeReference) ref).getArguments();
			for (JvmTypeReference jvmTypeReference : list) {
				acceptPreferredType(jvmTypeReference, importModel);
			}
		} else if (ref instanceof JvmWildcardTypeReference) {
			List<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) ref).getConstraints();
			for (JvmTypeConstraint jvmTypeConstraint : constraints) {
				acceptPreferredType(jvmTypeConstraint.getTypeReference(), importModel);
			}
		}
	}
	
	public void acceptPreferredType(JvmTypeReference ref, ImportModel importModel) {
		if (ref instanceof JvmParameterizedTypeReference) {
			acceptPreferredType(ref, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, importModel);
		} else {
			importModel.acceptType(ref.getType());
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
	public JvmType findPreferredType(EObject owner, EReference reference, ImportModel importModel) {
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
	
	public void acceptPreferredType(EObject owner, EReference referenceToTypeOrMember, ImportModel importModel) {
		importModel.acceptType(findPreferredType(owner, referenceToTypeOrMember, importModel));
	}
	


}