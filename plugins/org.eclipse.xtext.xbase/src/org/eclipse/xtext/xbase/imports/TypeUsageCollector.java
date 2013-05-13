/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.common.types.TypesPackage.Literals.*;

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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
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
import org.eclipse.xtext.util.Strings;
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
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
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
	
	@Inject
	private IBatchTypeResolver batchTypeResolver;
	
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
					collectStaticImportsFrom(featureCall);
				} else {
					acceptPreferredType(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE);
				}
			} else if (next instanceof XMemberFeatureCall 
					|| next instanceof XBinaryOperation 
					|| next instanceof XUnaryOperation
					|| (next instanceof XAssignment && !contains(currentThisType.getAllFeatures(), ((XAssignment) next).getFeature()))) {
				collectStaticImportsFrom((XAbstractFeatureCall) next);
			} else {
				Set<EObject> elements = associations.getJvmElements(next);
				if (!elements.isEmpty()) {
					EObject firstJvmElement = elements.iterator().next();
					if (firstJvmElement instanceof JvmMember) {
						JvmDeclaredType declaringType = (firstJvmElement instanceof JvmDeclaredType) 
								? (JvmDeclaredType) firstJvmElement
								: ((JvmMember) firstJvmElement).getDeclaringType();
						if(currentThisType != declaringType) {
							currentThisType = declaringType;
							knownTypesForStaticImports = null;
						}
						currentContext = (JvmMember) firstJvmElement;
					}
				} 
				addJavaDocReferences(next);
			}
		}
	}

	private void collectStaticImportsFrom(final XAbstractFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if((feature instanceof JvmOperation || feature instanceof JvmField) && featureCall.isStatic()) {
			if (featureCall.isExtension()) {
				acceptStaticExtensionImport((JvmMember) feature);
			} else {
				acceptStaticImport((JvmMember) feature);
			}
		}
	}
	
	protected void addJavaDocReferences(EObject element) {
		if(element != null && documentationProvider != null && currentThisType != null) {
			for(INode documentationNode: documentationProvider.getDocumentationNodes(element)) {
				for(ReplaceRegion docTypeReference: javaDocTypeReferenceProvider.computeTypeRefRegions(documentationNode)) {
					String docTypeText = docTypeReference.getText();
					JvmTypeReference typeRef = typeReferences.getTypeForName(docTypeText, currentThisType);
					ITextRegion textRegion = new TextRegion(docTypeReference.getOffset(), docTypeReference.getLength());
					JvmType referencedType = typeRef != null ? typeRef.getType() : null;
					if(referencedType instanceof JvmDeclaredType && !referencedType.eIsProxy()) 
						typeUsages.addTypeUsage((JvmDeclaredType) referencedType, docTypeText, textRegion, currentThisType, false, false);
					else
						typeUsages.addUnresolved(docTypeText, textRegion, currentThisType, false, false);
				}
			}
		}
	}
	
	protected void acceptType(JvmTypeReference ref) {
		if (ref instanceof XFunctionTypeRef 
		 || ref instanceof JvmWildcardTypeReference
		 || (ref.eContainer() instanceof XFunctionTypeRef 
				 && ref.eContainmentFeature() == JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT)
		 || NodeModelUtils.findActualNodeFor(ref) == null) 
			return;
		else 
			acceptPreferredType(ref);
	}
	
	protected void acceptPreferredType(JvmTypeReference ref) {
		if (ref instanceof JvmParameterizedTypeReference) {
			acceptPreferredType(ref, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		} else {
			acceptType(ref.getType(), ref.getIdentifier(), locationInFileProvider.getFullTextRegion(ref), false, false);
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
		if (referencedThing != null && owner instanceof XConstructorCall && referencedThing.eIsProxy()) {
			JvmIdentifiableElement potentiallyLinkedType = batchTypeResolver.resolveTypes(owner).getLinkedFeature((XConstructorCall)owner);
			if (potentiallyLinkedType != null && !potentiallyLinkedType.eIsProxy()) {
				referencedThing = potentiallyLinkedType;
			}
		}
		JvmDeclaredType referencedType = null;
		if (referencedThing instanceof JvmDeclaredType) {
			referencedType = (JvmDeclaredType) referencedThing;
		} else if (referencedThing instanceof JvmMember) {
			referencedType = ((JvmMember) referencedThing).getDeclaringType();
		} else if(referencedThing instanceof JvmType) {
			if (referencedThing.eIsProxy()) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(owner, reference);
				if (nodes.size() == 1) {
					String text = NodeModelUtils.getTokenText(nodes.get(0));
					int dollar = text.indexOf('$');
					if (dollar > 0) {
						String preferredTypeText = text.substring(0, dollar);
						return Tuples.create((JvmType) referencedThing, preferredTypeText);
					}
				}
			}
			return Tuples.create((JvmType)referencedThing, null);
		}
		return findPreferredType(owner, reference, referencedType);
	}

	private Pair<? extends JvmType, String> findPreferredType(EObject owner, EReference reference, JvmDeclaredType referencedType) {
		if (referencedType != null) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(owner, reference);
			if (nodes.size() == 1) {
				String text = NodeModelUtils.getTokenText(nodes.get(0));
				if (!referencedType.eIsProxy()) {
					Pair<JvmDeclaredType, String> result = findPreferredText(referencedType, text, "$");
					if (result != null) {
						return result;
					}
					result = findPreferredText(referencedType, text, ".");
					if (result != null) {
						return result;
					}
					if (text.endsWith("::")) {
						result = findPreferredText(referencedType, text.substring(0, text.length() - 2), "::");
						if (result != null) {
							return result;
						}
					}
				} else {
					int dollar = text.indexOf('$');
					if (dollar > 0) {
						String preferredTypeText = text.substring(0, dollar);
						return Tuples.create(referencedType, preferredTypeText);
					} else {
						return Tuples.create(referencedType, text);
					}
				}
			}
		}
		return Tuples.create(referencedType, null);
	}

	private Pair<JvmDeclaredType,String> findPreferredText(JvmDeclaredType referencedType, String text, String delimiter) {
		int idx = text.lastIndexOf(delimiter);
		if (idx >= 0) {
			JvmDeclaredType declaredType = referencedType;
			while(declaredType.getDeclaringType() != null && idx >= 0) {
				declaredType = declaredType.getDeclaringType();
				text = text.substring(0, idx);
				idx = text.lastIndexOf(delimiter, idx-1);
			}
			return Tuples.create(declaredType, text);
		}
		return null;
	}
	
	protected void acceptPreferredType(EObject owner, EReference referenceToTypeOrMember) {
		ITextRegion refRegion = locationInFileProvider.getFullTextRegion(owner, referenceToTypeOrMember, 0);
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null) {
			String refText = parseResult.getRootNode().getText().substring(
					refRegion.getOffset(), refRegion.getOffset() + refRegion.getLength());
			Pair<? extends JvmType, String> preferredType = findPreferredType(owner, referenceToTypeOrMember);
			boolean noDelimiter = false;
			boolean staticAccess = referenceToTypeOrMember == XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE;
			if (preferredType.getFirst() != null) {
				if (preferredType.getSecond() != null) {
					refRegion = new TextRegion(refRegion.getOffset(), refRegion.getLength() - refText.length() + preferredType.getSecond().length());
					if (staticAccess && !Strings.equal(preferredType.getSecond(), refText)) {
						noDelimiter = true;
					}
					refText = preferredType.getSecond();
				}
			}
			acceptType(preferredType.getFirst(), refText, refRegion, staticAccess, noDelimiter);
		}
	}
	
	protected void acceptType(JvmType type, String refText, ITextRegion refRegion, boolean staticAccess, boolean noDelimiter) {
		if(currentContext != null) {
			if (type == null || type.eIsProxy()) {
				typeUsages.addUnresolved(refText, refRegion, currentContext, staticAccess, noDelimiter);
			} else if (type instanceof JvmDeclaredType) {
				typeUsages.addTypeUsage((JvmDeclaredType) type, refText, refRegion, currentContext, staticAccess, noDelimiter);
			}
		}
	}
	
	protected void acceptStaticImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (!needsStaticImport(declarator) || implicitStaticImports.contains(declarator))
			return;
		typeUsages.addStaticImport(declarator);
	}

	protected void acceptStaticExtensionImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (!needsStaticImport(declarator) || implicitExtensionImports.contains(declarator))
			return;
		typeUsages.addExtensionImport(declarator);
	}

	protected boolean needsStaticImport(JvmDeclaredType declarator) {
		if(currentThisType == declarator)
			return false;
		if (knownTypesForStaticImports == null && currentThisType != null) {
			JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			reference.setType(currentThisType);
			knownTypesForStaticImports = superTypeCollector.collectSuperTypesAsRawTypes(reference);
		}
		if (knownTypesForStaticImports != null && knownTypesForStaticImports.contains(declarator))
			return false;
		else
			return true;
	}
	
}
