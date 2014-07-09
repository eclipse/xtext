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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.RawSuperTypes;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedFeatures;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.util.FeatureCallAsTypeLiteralHelper;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeUsageCollector {
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private ImplicitlyImportedFeatures implicitImports;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

	@Inject
	private TypeUsages typeUsages;
	
	@Inject
	private IBatchTypeResolver batchTypeResolver;
	
	@Inject
	private RawSuperTypes rawSuperTypes;
	
	@Inject
	private FeatureCallAsTypeLiteralHelper typeLiteralHelper;
	
	@Inject
	private IScopeProvider scopeProvider;
	
	private JvmDeclaredType currentThisType;
	
	private JvmMember currentContext;

	private XtextResource resource;

	private List<JvmType> implicitStaticImports;

	private List<JvmType> implicitExtensionImports;

	private Set<JvmType> knownTypesForStaticImports;

	private IEObjectDocumentationProviderExtension documentationProvider;
	
	protected static class PreferredType {
		public final JvmType referencedType;
		public final JvmType usedType;
		public final String unresolvedTypeName;
		public PreferredType(JvmType referencedType, JvmType usedType) {
			if (referencedType.eIsProxy()) {
				throw new IllegalArgumentException();
			}
			this.referencedType = referencedType;
			this.usedType = usedType;
			this.unresolvedTypeName = null;
		}
		public PreferredType(String name) {
			this.unresolvedTypeName = name;
			this.referencedType = null;
			this.usedType = null;
		}
	}
	
	public XtextResource getResource() {
		return resource;
	}
	
	protected JvmMember getCurrentContext() {
		return currentContext;
	}
	
	protected TypeUsages getTypeUsages() {
		return typeUsages;
	}

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
			} else if (next instanceof XConstructorCall) {
				acceptPreferredType(next, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
			} else if (next instanceof XTypeLiteral) {
				acceptPreferredType(next, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			} else if (next instanceof XFeatureCall) {
				XFeatureCall featureCall = (XFeatureCall) next;
				if (featureCall.getFeature() instanceof JvmType && featureCall.isTypeLiteral()) {
					if (isOuterTypeLiteral(featureCall)) {
						contents.prune();
						continue;
					}
					acceptPreferredType(featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
				} else if (featureCall.getFeature().eIsProxy()) {
					acceptPreferredType(featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
				} else {
					collectStaticImportsFrom(featureCall);
				}
			} else if (next instanceof XMemberFeatureCall) {
				XMemberFeatureCall featureCall = (XMemberFeatureCall) next;
				if (featureCall.getFeature() instanceof JvmType && featureCall.isTypeLiteral()) {
					if (isOuterTypeLiteral(featureCall)) {
						contents.prune();
						continue;
					}
					acceptPreferredType(featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
				}
				if (!featureCall.isExplicitStatic()) {
					XExpression target = featureCall.getMemberCallTarget();
					if (!isTypeLiteral(target) || featureCall.isExtension()) {
						collectStaticImportsFrom((XAbstractFeatureCall) next);
					}
				} 
			} else if ((next instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) next).isOperation())
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
	
	private boolean isOuterTypeLiteral(XAbstractFeatureCall featureCall) {
		if (featureCall.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			XMemberFeatureCall container = (XMemberFeatureCall) featureCall.eContainer();
			if (container.isTypeLiteral()) {
				return true;
			}
		}
		return false;
	}

	private boolean isTypeLiteral(XExpression memberCallTarget) {
		if (memberCallTarget instanceof XAbstractFeatureCall) {
			return ((XAbstractFeatureCall) memberCallTarget).isTypeLiteral();
		}
		return false;
	}

	private void collectStaticImportsFrom(final XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate featureLinkingCandidate = batchTypeResolver.resolveTypes(featureCall).getLinkingCandidate(featureCall);
		if (featureLinkingCandidate instanceof IAmbiguousLinkingCandidate) {
			IAmbiguousLinkingCandidate ambiguousLinkingCandidate = (IAmbiguousLinkingCandidate) featureLinkingCandidate;
			for (ILinkingCandidate linkingCandidate : ambiguousLinkingCandidate.getAlternatives()) {
				collectStaticImportsFrom(linkingCandidate);
			}
		} else {
			collectStaticImportsFrom(featureLinkingCandidate);
		}
	}

	protected void collectStaticImportsFrom(ILinkingCandidate linkingCandidate) {
		if (linkingCandidate == null) {
			return;
		}
		XExpression expression = linkingCandidate.getExpression();
		if (expression instanceof XAbstractFeatureCall) {
			JvmIdentifiableElement feature = linkingCandidate.getFeature();
			if (feature instanceof JvmEnumerationLiteral && expression instanceof XFeatureCall) {
				if (isEnumLiteralImplicitelyImported(expression)) {
					return;
				}
			}
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expression;
			if ((feature instanceof JvmOperation || feature instanceof JvmField) && featureCall.isStatic()) {
				if (featureCall.isExtension()) {
					acceptStaticExtensionImport((JvmMember) feature);
				} else {
					acceptStaticImport((JvmMember) feature);
				}
			}
		}
	}
	
	private boolean isEnumLiteralImplicitelyImported(XExpression expression) {
		XCasePart container = EcoreUtil2.getContainerOfType(expression, XCasePart.class);
		if (container != null && EcoreUtil.isAncestor(container.getCase(), expression)) {
			return true;
		}
		if (EcoreUtil2.getContainerOfType(expression, XAnnotation.class) != null) {
			// TODO should check logical container as soon as it is available for annotation values
			return true;
		}
		return false;
	}

	protected void addJavaDocReferences(EObject element) {
		if(element != null && documentationProvider != null && currentThisType != null) {
			for(INode documentationNode: documentationProvider.getDocumentationNodes(element)) {
				for(ReplaceRegion docTypeReference: javaDocTypeReferenceProvider.computeTypeRefRegions(documentationNode)) {
					String docTypeText = docTypeReference.getText();
					IScope scope = scopeProvider.getScope(element, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
					IEObjectDescription singleElement = scope.getSingleElement(QualifiedName.create(docTypeText));
					ITextRegion textRegion = new TextRegion(docTypeReference.getOffset(), docTypeReference.getLength());
					JvmType referencedType = null;
					if (singleElement != null) {
						referencedType = (JvmType) singleElement.getEObjectOrProxy();
					}
					if(referencedType instanceof JvmDeclaredType && !referencedType.eIsProxy()) {
						JvmDeclaredType casted = (JvmDeclaredType) referencedType;
						typeUsages.addTypeUsage(casted, casted, textRegion, currentThisType);
					} else {
						typeUsages.addUnresolved(docTypeText, "", textRegion, currentThisType);
					}
				}
			}
		}
	}
	
	protected void acceptType(JvmTypeReference ref) {
		if (ref instanceof XFunctionTypeRef 
		 || ref instanceof JvmWildcardTypeReference
		 || ref instanceof JvmGenericArrayTypeReference
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
			acceptType(ref.getType(), locationInFileProvider.getFullTextRegion(ref));
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
	protected PreferredType findPreferredType(EObject owner, EReference reference, String text) {
		JvmIdentifiableElement referencedThing = getReferencedElement(owner, reference);
		JvmDeclaredType referencedType = null;
		if (referencedThing instanceof JvmDeclaredType) {
			referencedType = (JvmDeclaredType) referencedThing;
		} else if (referencedThing instanceof JvmMember) {
			referencedType = ((JvmMember) referencedThing).getDeclaringType();
		} else if(referencedThing instanceof JvmType) {
			if (referencedThing.eIsProxy()) {
				String importedName = getFirstNameSegment(owner, reference);
				return new PreferredType(importedName);
			}
			return null;
		}
		return findPreferredType(referencedType, text);
	}

	protected JvmIdentifiableElement getReferencedElement(EObject owner, EReference reference) {
		JvmIdentifiableElement referencedThing = (JvmIdentifiableElement) owner.eGet(reference);
		if (referencedThing != null && owner instanceof XConstructorCall && referencedThing.eIsProxy()) {
			JvmIdentifiableElement potentiallyLinkedType = batchTypeResolver.resolveTypes(owner).getLinkedFeature((XConstructorCall)owner);
			if (potentiallyLinkedType != null && !potentiallyLinkedType.eIsProxy()) {
				referencedThing = potentiallyLinkedType;
			}
		}
		return referencedThing;
	}

	private String getFirstNameSegment(EObject owner, EReference reference) {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(owner, reference);
		if (nodes.size() == 1) {
			String text = NodeModelUtils.getTokenText(nodes.get(0));
			return getFirstNameSegment(text);
		}
		throw new IllegalStateException("Cannot find node for feature");
	}

	protected String getFirstNameSegment(String text) {
		int firstDelimiter = text.indexOf('.');
		if (firstDelimiter == -1) {
			firstDelimiter = text.indexOf('$');
		} else {
			int dollar = text.indexOf('$');
			if (dollar != -1) {
				firstDelimiter = Math.min(firstDelimiter, dollar);
			}
		}
		if (firstDelimiter == -1) {
			firstDelimiter = text.indexOf("::");
			if (firstDelimiter == text.length() - 2 && firstDelimiter >= 0) {
				text = text.substring(0, firstDelimiter);
				firstDelimiter = -1;
			}
		} else {
			int colon = text.indexOf("::");
			if (colon != text.length() - 2 && colon != -1) {
				firstDelimiter = Math.min(firstDelimiter, colon);
			}
		}
		if (firstDelimiter != -1) {
			return text.substring(0, firstDelimiter);
		}
		return text;
	}

	protected PreferredType findPreferredType(JvmDeclaredType referencedType, String text) {
		if (referencedType != null && !referencedType.eIsProxy()) {
			if (referencedType.getDeclaringType() == null) {
				return new PreferredType(referencedType, referencedType);
			}
			String outerSegment = getFirstNameSegment(text);
			JvmType outerType = findDeclaringTypeBySimpleName(referencedType, outerSegment);
			if (outerType == null) {
				throw new IllegalStateException();
			}
			return new PreferredType(outerType, referencedType);
		}
		String name = getFirstNameSegment(text);
		return new PreferredType(name);
	}

	private JvmDeclaredType findDeclaringTypeBySimpleName(JvmDeclaredType referencedType, String outerSegment) {
		if (referencedType.getDeclaringType() == null || outerSegment.equals(referencedType.getSimpleName())) {
			return referencedType;
		}
		return findDeclaringTypeBySimpleName(referencedType.getDeclaringType(), outerSegment);
	}

	protected void acceptPreferredType(EObject owner, EReference referenceToTypeOrMember) {
		ITextRegion refRegion = locationInFileProvider.getFullTextRegion(owner, referenceToTypeOrMember, 0);
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null) {
			String completeText = parseResult.getRootNode().getText();
			String refText = completeText.substring(refRegion.getOffset(), refRegion.getOffset() + refRegion.getLength());
			PreferredType preferredType = findPreferredType(owner, referenceToTypeOrMember, refText);
			if (preferredType != null) {
				if (preferredType.referencedType != null) {
					acceptType(preferredType.referencedType, preferredType.usedType, refRegion);
				} else {
					String suffix = refText.substring(preferredType.unresolvedTypeName.length());
					if (owner instanceof XFeatureCall) {
						XFeatureCall featureCall = (XFeatureCall) owner; 
						if (typeLiteralHelper.isPotentialTypeLiteral(featureCall, null)) {
							XAbstractFeatureCall root = typeLiteralHelper.getRootTypeLiteral(featureCall);
							if (root != null) {
								ITextRegion region = locationInFileProvider.getSignificantTextRegion(root);
								if (region.getOffset() == refRegion.getOffset()) {
									suffix = completeText.substring(region.getOffset(), region.getOffset() + region.getLength());
									suffix = suffix.substring(preferredType.unresolvedTypeName.length());
									refRegion = region;
								}
							}
						}
					}
					acceptUnresolvedType(preferredType.unresolvedTypeName, suffix, refRegion);
				}
			}
		}
	}
	
	protected void acceptType(JvmType type, ITextRegion refRegion) {
		acceptType(type, type, refRegion);
	}
	
	protected void acceptType(JvmType type, JvmType usedType, ITextRegion refRegion) {
		if(currentContext != null) {
			if (type == null || type.eIsProxy()) {
				throw new IllegalArgumentException();
			} else if (type instanceof JvmDeclaredType) {
				typeUsages.addTypeUsage((JvmDeclaredType) type, (JvmDeclaredType) usedType, refRegion, currentContext);
			}
		}
	}
	
	protected void acceptUnresolvedType(String usedTypeName, String suffix, ITextRegion refRegion) {
		if(currentContext != null) {
			typeUsages.addUnresolved(usedTypeName, suffix, refRegion, currentContext);
		}
	}
	
	protected void acceptStaticImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (!needsStaticImport(declarator) || implicitStaticImports.contains(declarator))
			return;
		typeUsages.addStaticImport(member);
	}

	protected void acceptStaticExtensionImport(JvmMember member) {
		JvmDeclaredType declarator = member.getDeclaringType();
		if (!needsStaticImport(declarator) || implicitExtensionImports.contains(declarator))
			return;
		typeUsages.addExtensionImport(member);
	}

	protected boolean needsStaticImport(JvmDeclaredType declarator) {
		if(currentThisType == declarator)
			return false;
		if (knownTypesForStaticImports == null && currentThisType != null) {
			knownTypesForStaticImports = rawSuperTypes.collect(currentThisType);
		}
		if (knownTypesForStaticImports != null && knownTypesForStaticImports.contains(declarator))
			return false;
		else
			return true;
	}
	
}
