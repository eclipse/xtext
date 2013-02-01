/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Iterables.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Tuples;
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
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeUsageCollector {
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private ImplicitlyImportedTypes implicitImports;
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private TypeUsages typeUsages;
	
	private JvmDeclaredType currentThisType;
	
	private JvmMember currentContext;

	private XtextResource resource;

	private List<JvmType> implicitStaticImports;

	private List<JvmType> implicitExtensionImports;

	private Set<JvmType> knownTypesForStaticImports;

	private IEObjectDocumentationProviderExtension documentationProvider;

	@Inject
	private void setDocumentationProvider(IEObjectDocumentationProvider documentationProvider) {
		if(documentationProvider instanceof IEObjectDocumentationProviderExtension) 
			this.documentationProvider = (IEObjectDocumentationProviderExtension) documentationProvider;
	}
	
	public TypeUsages collectTypeUsages(XtextResource resource) {
		if(resource != null && !resource.getContents().isEmpty()) {
			this.resource = resource;
			this.implicitStaticImports = implicitImports.getStaticImportClasses(resource);
			this.implicitExtensionImports = implicitImports.getExtensionClasses(resource);
			collectAllReferences(resource.getContents().get(0));
		}
		return typeUsages; 
	}

	protected void collectAllReferences(EObject rootElement) {
		TreeIterator<EObject> contents = EcoreUtil.getAllContents(rootElement, true);
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof JvmTypeReference) {
				acceptType((JvmTypeReference) next);
			} else if (next instanceof XAnnotation) {
				acceptPreferredType(next, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE);
			} else if (next instanceof XInstanceOfExpression) {
				acceptType(((XInstanceOfExpression) next).getType());
			} else if (next instanceof XConstructorCall) {
				acceptPreferredType(next, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
			} else if (next instanceof XTypeLiteral) {
				acceptPreferredType(next, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			} else if (next instanceof XFeatureCall) {
				final XFeatureCall featureCall = (XFeatureCall) next;
				if (featureCall.getDeclaringType() == null) {
					final JvmIdentifiableElement member = featureCall.getFeature();
					if (member instanceof JvmOperation) {
						JvmOperation operation = (JvmOperation) member;
						if (operation.isStatic()) {
							if (!operation.isVarArgs() && operation.getParameters().size() > featureCall.getExplicitArguments().size()) {
								acceptStaticExtensionImport(operation);
							} else {
								acceptStaticImport(operation);
							}
						}
					}
					if (member instanceof JvmField) {
						if (((JvmField) member).isStatic()) {
							acceptStaticImport((JvmMember) member);
						}
					}
				} else {
					acceptPreferredType(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE);
				}
			} else if (next instanceof XMemberFeatureCall 
					|| next instanceof XBinaryOperation 
					|| next instanceof XUnaryOperation
					|| (next instanceof XAssignment && !contains(currentThisType.getAllFeatures(), ((XAssignment) next).getFeature()))) {
				final XAbstractFeatureCall featureCall = (XAbstractFeatureCall) next;
				final JvmIdentifiableElement member = featureCall.getFeature();
				if (member instanceof JvmOperation) {
					if (((JvmOperation) member).isStatic())
						acceptStaticExtensionImport((JvmMember) member);
				}
				if (member instanceof JvmField) {
					if (((JvmField) member).isStatic())
						acceptStaticExtensionImport((JvmMember) member);
				}
			} else {
				Set<EObject> elements = associations.getJvmElements(next);
				if (!elements.isEmpty()) {
					EObject firstJvmElement = elements.iterator().next();
					if (firstJvmElement instanceof JvmDeclaredType) {
						currentThisType = (JvmDeclaredType) firstJvmElement;
						knownTypesForStaticImports = null;
					} 
					if (firstJvmElement instanceof JvmMember) { 
						currentContext = (JvmMember) firstJvmElement;
					}
				} 
				addJavaDocReferences(next);
			}
		}
	}
	
	protected void addJavaDocReferences(EObject element) {
		if(element != null && documentationProvider != null) {
			for(INode documentationNode: documentationProvider.getDocumentationNodes(element)) {
				for(ReplaceRegion docTypeReference: javaDocTypeReferenceProvider.computeTypeRefRegions(documentationNode)) {
					JvmTypeReference typeRef = typeReferences.getTypeForName(docTypeReference.getText(), currentThisType);
					ITextRegion textRegion = new TextRegion(docTypeReference.getOffset(), docTypeReference.getLength());
					if(typeRef == null || !(typeRef.getType() instanceof JvmDeclaredType)) 
						typeUsages.addUnresolved(docTypeReference.getText(), textRegion, currentThisType);
					else
						typeUsages.addTypeUsage((JvmDeclaredType) typeRef.getType(), docTypeReference.getText(), textRegion, currentThisType);
				}
			}
		}
	}
	
	protected void acceptType(JvmTypeReference ref) {
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
	
	protected void acceptPreferredType(JvmTypeReference ref) {
		if (ref instanceof JvmParameterizedTypeReference) {
			acceptPreferredType(ref, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		} else {
			acceptType(ref.getType(), ref.getIdentifier(), locationInFileProvider.getSignificantTextRegion(ref));
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
	protected Pair<? extends JvmType, String> findPreferredType(EObject owner, EReference reference) {
		JvmIdentifiableElement referencedThing = (JvmIdentifiableElement) owner.eGet(reference);
		JvmDeclaredType referencedType = null;
		if (referencedThing instanceof JvmDeclaredType) {
			referencedType = (JvmDeclaredType) referencedThing;
		} else if (referencedThing instanceof JvmMember) {
			referencedType = ((JvmMember) referencedThing).getDeclaringType();
		} else if(referencedThing instanceof JvmType) {
			return Tuples.create((JvmType)referencedThing, null);
		}
		if (referencedType != null) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(owner, reference);
			if (nodes.size() == 1) {
				String text = NodeModelUtils.getTokenText(nodes.get(0));
				int dollar = text.lastIndexOf('$');
				String preferredTypeText = text; 
				if (dollar >= 0) {
					JvmDeclaredType declaredType = referencedType;
					while(declaredType.getDeclaringType() != null && dollar >= 0) {
						declaredType = declaredType.getDeclaringType();
						preferredTypeText = text.substring(0, dollar);
						dollar = text.lastIndexOf('$', dollar-1);
					}
					return Tuples.create(declaredType, preferredTypeText);
				}
			}
		}
		return Tuples.create(referencedType, null);
	}
	
	protected void acceptPreferredType(EObject owner, EReference referenceToTypeOrMember) {
		ITextRegion refRegion = locationInFileProvider.getSignificantTextRegion(owner, referenceToTypeOrMember, 0);
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null) {
			String refText = parseResult.getRootNode().getText().substring(
					refRegion.getOffset(), refRegion.getOffset() + refRegion.getLength());
			Pair<? extends JvmType, String> preferredType = findPreferredType(owner, referenceToTypeOrMember);
			if (preferredType.getFirst() != null) {
				if (preferredType.getSecond() != null) {
					refRegion = new TextRegion(refRegion.getOffset(), refRegion.getLength() - refText.length() + preferredType.getSecond().length());
					refText = preferredType.getSecond();
				}
			}
			acceptType(preferredType.getFirst(), refText, refRegion);
		}
	}
	
	protected void acceptType(JvmType type, String refText, ITextRegion refRegion) {
		if (type == null || type.eIsProxy()) {
			typeUsages.addUnresolved(refText, refRegion, currentContext);
		} else if (type instanceof JvmDeclaredType) {
			typeUsages.addTypeUsage((JvmDeclaredType) type, refText, refRegion, currentContext);
		}
	}
	
	protected void acceptStaticImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (currentThisType == declarator || implicitStaticImports.contains(declarator))
			return;
		if (knownTypesForStaticImports == null) {
			JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			reference.setType(currentThisType);
			knownTypesForStaticImports = superTypeCollector.collectSuperTypesAsRawTypes(reference);
		}
		if (knownTypesForStaticImports.contains(declarator))
			return;
		typeUsages.addStaticImport(declarator);
	}

	protected void acceptStaticExtensionImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (implicitExtensionImports.contains(declarator))
			return;
		typeUsages.addExtensionImport(declarator);
	}
}
