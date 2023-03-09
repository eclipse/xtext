/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.imports.ImportedTypesCollector;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider;
import org.eclipse.xtext.xbase.imports.TypeUsages;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelReferenceUpdater;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.inject.Inject;

/**
 * Handles imports while updating references of renamed elements.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * TODO this looks bogus to me  {@link #isStaticExtensionFeatureCall(EObject, EReference, EObject)})
 */
public class XbaseReferenceUpdater extends JvmModelReferenceUpdater {
	
	@Inject
	private IValueConverterService valueConverterService;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	
	@Inject
	private ReplaceConverter replaceConverter;
	
	@Inject
	private ImportedTypesCollector importedTypesCollector;
	
	@Inject
	private StaticallyImportedMemberProvider staticallyImportedMemberProvider;
	
	@Override
	protected void createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference,
			int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		if (referringElement instanceof XImportDeclaration) {
			XImportDeclaration importDeclaration = (XImportDeclaration) referringElement;
			JvmDeclaredType importedType = importDeclaration.getImportedType();
			boolean isStatic = importDeclaration.isStatic();
			boolean isExtension = importDeclaration.isExtension();
			String memberName = importDeclaration.getMemberName();
			
			if (newTargetElement instanceof JvmDeclaredType) {
				JvmDeclaredType type = (JvmDeclaredType) newTargetElement;

				ImportAwareUpdateAcceptor importAwareUpdateAcceptor = (ImportAwareUpdateAcceptor) updateAcceptor;
				importAwareUpdateAcceptor.removeImport(type, isStatic, isExtension, memberName);
				importAwareUpdateAcceptor.acceptImport(type, isStatic, isExtension, memberName);
				return;
			}
			
			if (newTargetElement instanceof JvmFeature) {
				JvmFeature feature = (JvmFeature) newTargetElement;
				String featureName = feature.getSimpleName();
				if (featureName.equals(memberName)) {
					// type rename is handled separately
					return;
				}
				
				ImportAwareUpdateAcceptor importAwareUpdateAcceptor = (ImportAwareUpdateAcceptor) updateAcceptor;
				if (!importAwareUpdateAcceptor.isUsed(importedType, isStatic, isExtension, memberName)) {
					importAwareUpdateAcceptor.removeImport(importedType, isStatic, isExtension, memberName);
				}
				if (importAwareUpdateAcceptor.isConflicted(importedType, isStatic, isExtension, featureName)) {
					JvmDeclaredType parentType = importedType;
					while (parentType != null && 
							!importAwareUpdateAcceptor.getImportSection().hasImportedType(parentType) && 
							!importAwareUpdateAcceptor.acceptImport(parentType, false, false, null)) {
						parentType = parentType.getDeclaringType();		
					}
				} else {
					importAwareUpdateAcceptor.acceptImport(importedType, isStatic, isExtension, featureName);
				}
				return;
			}
		}
		if (referringElement instanceof XAbstractFeatureCall) {
			if(newTargetElement instanceof JvmDeclaredType) {
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) referringElement;
				JvmIdentifiableElement feature = featureCall.getFeature();
				if(isStaticExtensionFeatureCall(referringElement, reference, feature)) {
					return;
				} 
				if(isStaticFeatureCall(referringElement, reference, feature)) {
					return;
				}
			} 
		}
		if (!(referringElement instanceof XFeatureCall && newTargetElement instanceof JvmConstructor)) {
			// skip constructor calls like this() or super()  
			super.createReferenceUpdate(referringElement, referringResourceURI, reference, indexInList,
					newTargetElement, updateAcceptor);				
		}
	}
	
	@Override
	protected String resolveNameConflict(EObject referringElement, EReference reference, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT, reference.getEReferenceType())) {
			if (newTargetElement instanceof JvmType) {
				JvmType type = (JvmType) newTargetElement;
				
				if (canLinkJvmType(referringElement, type)) {
					return toString(qualifiedNameProvider.getFullyQualifiedName(type));
				}
			}
			if (newTargetElement instanceof JvmFeature) {
				JvmFeature feature = (JvmFeature) newTargetElement;
				if (feature.isStatic() && !isStaticExtensionFeatureCall(referringElement, reference, newTargetElement)) {
					JvmDeclaredType declaringType = feature.getDeclaringType();
					
					if (canLinkJvmType(referringElement, declaringType)) {
						JvmDeclaredType parentType = declaringType;
						
						List<String> segments = new LinkedList<String>();
						segments.add(feature.getSimpleName());
						segments.add(0, parentType.getSimpleName());
						while (!hasImportedType(updateAcceptor, parentType)) {
							parentType = parentType.getDeclaringType();
							if (parentType == null) {
								return toString(qualifiedNameProvider.getFullyQualifiedName(feature));
							}
							segments.add(0, parentType.getSimpleName());
						}
						return toString(QualifiedName.create(segments));
					}
				}
			}
		}
		return super.resolveNameConflict(referringElement, reference, newTargetElement, updateAcceptor);
	}

	protected String toString(QualifiedName qualifiedName) {
		String value = qualifiedNameConverter.toString(qualifiedName);
		try {
			return valueConverterService.toString(value, "QualifiedName");
		} catch (ValueConverterException e) {
			return null;
		}
	}

	protected boolean canLinkJvmType(EObject referringElement, JvmType type) {
		if (type == null) {
			return false;
		}
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(type);
		if (qualifiedName == null) {
			return false;
		}
		IScope scope = getLinkingScopeProvider().getScope(referringElement, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		return scope.getSingleElement(qualifiedName) != null;
	}

	protected boolean hasImportedType(IRefactoringUpdateAcceptor updateAcceptor, JvmDeclaredType declaringType) {
		if (updateAcceptor instanceof ImportAwareUpdateAcceptor) {
			ImportAwareUpdateAcceptor importAwareUpdateAcceptor = (ImportAwareUpdateAcceptor) updateAcceptor;
			return importAwareUpdateAcceptor.getImportSection().hasImportedType(declaringType);	
		}
		return false;
	}

	@Override
	protected void processReferringResource(Resource referringResource,
			Iterable<IReferenceDescription> referenceDescriptions, ElementRenameArguments elementRenameArguments,
			IRefactoringUpdateAcceptor updateAcceptor, IProgressMonitor monitor) {
		ImportAwareUpdateAcceptor importAwareUpdateAcceptor = createUpdateAcceptor(referringResource, updateAcceptor);
		
		Iterable<IReferenceDescription> importTypeReferences = getImportTypeReferences(referenceDescriptions);
		super.processReferringResource(referringResource, importTypeReferences, elementRenameArguments, importAwareUpdateAcceptor, monitor);
		
		importAwareUpdateAcceptor.getImportSection().update();
		
		Iterable<IReferenceDescription> notImportTypeReferences = getNotImportTypeReferences(referenceDescriptions);
		super.processReferringResource(referringResource, notImportTypeReferences, elementRenameArguments, importAwareUpdateAcceptor, monitor);
		
		List<ReplaceRegion> importChanges = importAwareUpdateAcceptor.getImportSection().rewrite();
		TextEdit importChangeEdit = replaceConverter.convertToTextEdit(importChanges);
		if(importChangeEdit != null) 
			updateAcceptor.accept(referringResource.getURI(), importChangeEdit);
	}

	protected Iterable<IReferenceDescription> getImportTypeReferences(Iterable<IReferenceDescription> referenceDescriptions) {
		return IterableExtensions.filter(referenceDescriptions, new Functions.Function1<IReferenceDescription, Boolean>() {

			@Override
			public Boolean apply(IReferenceDescription p) {
				return isImportTypeReference(p);
			}
			
		});
	}

	protected Iterable<IReferenceDescription> getNotImportTypeReferences(Iterable<IReferenceDescription> referenceDescriptions) {
		return IterableExtensions.filter(referenceDescriptions, new Functions.Function1<IReferenceDescription, Boolean>() {

			@Override
			public Boolean apply(IReferenceDescription p) {
				return !isImportTypeReference(p);
			}
			
		});
	}

	protected ImportAwareUpdateAcceptor createUpdateAcceptor(Resource referringResource, IRefactoringUpdateAcceptor updateAcceptor) {
		return new ImportAwareUpdateAcceptor((XtextResource) referringResource, updateAcceptor);
	}

	protected boolean isImportTypeReference(IReferenceDescription input) {
		return input.getEReference() == XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE;
	}

	@Override
	protected void createTextChange(ITextRegion referenceTextRegion, String newReferenceText, EObject referringElement,
			EObject newTargetElement, EReference reference, URI referringResourceURI,
			IRefactoringUpdateAcceptor updateAcceptor) {
		if (newReferenceText != null && updateAcceptor instanceof ImportAwareUpdateAcceptor && isReferenceToJvmType(newTargetElement, reference)) {
			JvmType newTargetType = (JvmType) newTargetElement;
			ImportAwareUpdateAcceptor importAwareUpdateAcceptor = (ImportAwareUpdateAcceptor) updateAcceptor;
			
			Pair<JvmDeclaredType, QualifiedName> importedTypeAndRelativeName = getImportedTypeAndRelativeName(newTargetType, importAwareUpdateAcceptor.getImportSection());
			if(importedTypeAndRelativeName != null) {
				JvmDeclaredType importedType = importedTypeAndRelativeName.getFirst();
				QualifiedName importRelativeName = importedTypeAndRelativeName.getSecond();
				
				importAwareUpdateAcceptor.removeImport(importedType, false, false, null);
				if (isReferencedByQualifiedName(referringElement, newTargetType, importRelativeName)) {
					QualifiedName newTypeQualifiedName = qualifiedNameProvider.getFullyQualifiedName(newTargetElement);
					newReferenceText = getLinkText(newTypeQualifiedName, newReferenceText);
				} else {
					if(!isEmpty(importedType.getPackageName())) { 
						importAwareUpdateAcceptor.acceptImport(importedType, false, false, null);
					}
					newReferenceText = getLinkText(importRelativeName, newReferenceText);
				}
			}
		}
		super.createTextChange(referenceTextRegion, newReferenceText, referringElement, newTargetElement, reference,
				referringResourceURI, updateAcceptor);
	}

	protected boolean isReferenceToJvmType(EObject newTargetElement, EReference reference) {
		return newTargetElement instanceof JvmType && EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, reference.getEReferenceType());
	}

	/**
	 * constructor calls and type references are import aware, but only type reference can be disambiguated by using
	 * #getSingleElement
	 */
	protected boolean isReferencedByQualifiedName(EObject referringElement, JvmType newTargetType, QualifiedName importRelativeName) {
		IScope scope = getLinkingScopeProvider().getScope(referringElement, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		IEObjectDescription singleElement = scope.getSingleElement(importRelativeName);
		if (singleElement == null) {
			return false;
		}
		EObject resolvedSingleElement = EcoreUtil.resolve(singleElement.getEObjectOrProxy(), referringElement);
		return resolvedSingleElement != EcoreUtil2.getContainerOfType(newTargetType, JvmDeclaredType.class);
	}

	protected boolean isStaticFeatureCall(EObject referringElement, EReference reference, EObject newTargetElement) {
		return referringElement instanceof XFeatureCall
				&& reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE
				&& newTargetElement instanceof JvmFeature
				&& ((JvmFeature)newTargetElement).isStatic();
	}

	protected boolean isStaticExtensionFeatureCall(EObject referringElement, EReference reference, EObject newTargetElement) {
		return referringElement instanceof XMemberFeatureCall
				&& reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE
				&& newTargetElement instanceof JvmFeature
				&& ((JvmFeature)newTargetElement).isStatic()
				&& !((XMemberFeatureCall)referringElement).isStaticWithDeclaringType(); 
	}

	/**
	 * @return the currently imported type containing the newTargetType and the element's name relative to that import.
	 */
	protected Pair<JvmDeclaredType, QualifiedName> getImportedTypeAndRelativeName(JvmType newTargetType, RewritableImportSection section) {
		if (!(newTargetType instanceof JvmDeclaredType) || !section.isEnabled()) {
			return null;
		}
		JvmDeclaredType importedType = (JvmDeclaredType) newTargetType;
		StringBuffer relativeName = new StringBuffer(importedType.getSimpleName());
		while(importedType.getDeclaringType() != null && !section.hasImportedType(importedType)) {
			importedType = importedType.getDeclaringType();
			relativeName.insert(0, ".");
			relativeName.insert(0, importedType.getSimpleName());
		}
		return Tuples.create(importedType, qualifiedNameConverter.toQualifiedName(relativeName.toString()));
	}

	protected String getLinkText(QualifiedName importRelativeName, String newReferenceText) {
		if(newReferenceText.endsWith("::")) 
			return importRelativeName.toString("::") + "::";
		else 
			return importRelativeName.toString(".");
	}
	
	public class ImportAwareUpdateAcceptor implements IRefactoringUpdateAcceptor {

		private TypeUsages typeUsages;

		private final XtextResource resource;

		private final IRefactoringUpdateAcceptor delegate;

		private final RewritableImportSection importSection;

		public ImportAwareUpdateAcceptor(XtextResource resource, IRefactoringUpdateAcceptor delegate) {
			this.resource = resource;
			this.delegate = delegate;
			this.importSection = importSectionFactory.parse(resource);
		}

		@Override
		public void accept(URI resourceURI, TextEdit textEdit) {
			delegate.accept(resourceURI, textEdit);
		}

		@Override
		public void accept(URI resourceURI, Change change) {
			delegate.accept(resourceURI, change);
		}

		@Override
		public StatusWrapper getRefactoringStatus() {
			return delegate.getRefactoringStatus();
		}

		@Override
		public IRefactoringDocument getDocument(URI resourceURI) {
			return delegate.getDocument(resourceURI);
		}

		@Override
		public Change createCompositeChange(String name, IProgressMonitor monitor) {
			return delegate.createCompositeChange(name, monitor);
		}

		public boolean acceptImport(JvmDeclaredType type, boolean isStatic, boolean isExtension, String memberName) {
			if (isExtension) {
				return importSection.addStaticExtensionImport(type, memberName);
			}
			if (isStatic) {
				return importSection.addStaticImport(type, memberName);
			}
			return importSection.addImport(type);
		}

		public boolean removeImport(JvmDeclaredType type, boolean isStatic, boolean isExtension, String memberName) {
			if (isExtension) {
				return importSection.removeStaticExtensionImport(type, memberName);
			}
			if (isStatic) {
				return importSection.removeStaticImport(type, memberName);
			}
			return importSection.removeImport(type);
		}
		
		public boolean isUsed(JvmDeclaredType type, boolean isStatic, boolean isExtension, String memberName) {
			if (!isStatic) {
				return false;
			}
			Iterator<JvmFeature> allFeatures = staticallyImportedMemberProvider.getAllFeatures(resource, type, isStatic, isExtension, memberName).iterator();
			if (!allFeatures.hasNext()) {
				return false;
			}
			TypeUsages typeUsages = getTypeUsages();
			while (allFeatures.hasNext()) {
				JvmFeature feature = allFeatures.next();
				if (typeUsages.getStaticImports().contains(feature) || typeUsages.getExtensionImports().contains(feature)) {
					return true;
				}
			}
			return false;
		}
		
		public boolean isConflicted(JvmDeclaredType type, boolean isStatic, boolean isExtension, String memberName) {
			if (!isStatic || memberName == null) {
				return false;
			}
			if (importSection.hasStaticImport(memberName, isExtension)) {
				return true;
			}
			TypeUsages typeUsages = getTypeUsages();
			if (isExtension) {
				if (!contains(type, memberName, typeUsages.getStaticImports())) {
					return false;
				}
			}
			return isConflicted(type, memberName, typeUsages.getStaticImports());
		}

		protected boolean isConflicted(JvmDeclaredType type, String memberName, Set<JvmMember> importedMembers) {
			for (JvmMember importedMember : importedMembers) {
				if (importedMember.getDeclaringType() != type && memberName.equals(importedMember.getSimpleName())) {
					return true;
				}
			}
			return false;
		}

		protected boolean contains(JvmDeclaredType type, String memberName, Set<JvmMember> importedMembers) {
			for (JvmMember staticImport : importedMembers) {
				if (staticImport.getDeclaringType() == type && memberName.equals(staticImport.getSimpleName())) {
					return true;
				}
			}
			return false;
		}
		
		public RewritableImportSection getImportSection() {
			return importSection;
		}

		public TypeUsages getTypeUsages() {
			if (typeUsages == null) {
				typeUsages = importedTypesCollector.collectTypeUsages(resource);
			}
			return typeUsages;
		}

	}

}
