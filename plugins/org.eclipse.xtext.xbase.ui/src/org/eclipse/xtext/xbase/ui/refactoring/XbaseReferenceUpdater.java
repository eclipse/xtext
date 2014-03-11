/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

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
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
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
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelReferenceUpdater;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Handles imports while updating references of renamed elements.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseReferenceUpdater extends JvmModelReferenceUpdater {

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	
	@Inject
	private ReplaceConverter replaceConverter;
	
	@Override
	protected void createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference,
			int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		if (referringElement instanceof XAbstractFeatureCall) {
			if(newTargetElement instanceof JvmDeclaredType) {
				if(isStaticExtensionFeatureCall(referringElement, reference, ((XAbstractFeatureCall) referringElement).getFeature())) {
					((ImportAwareUpdateAcceptor)updateAcceptor).removeImport((JvmDeclaredType) newTargetElement, false, true);
					((ImportAwareUpdateAcceptor)updateAcceptor).acceptImport((JvmDeclaredType) newTargetElement, false, true);
					return;
				} else if(isStaticFeatureCall(referringElement, reference, ((XAbstractFeatureCall) referringElement).getFeature())) { 
					((ImportAwareUpdateAcceptor)updateAcceptor).removeImport((JvmDeclaredType) newTargetElement, true, false);
					((ImportAwareUpdateAcceptor)updateAcceptor).acceptImport((JvmDeclaredType) newTargetElement, true, false);
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
	protected void processReferringResource(Resource referringResource,
			Iterable<IReferenceDescription> referenceDescriptions, ElementRenameArguments elementRenameArguments,
			IRefactoringUpdateAcceptor updateAcceptor) {
		Iterable<IReferenceDescription> nonImportReferences = filter(referenceDescriptions,
				new Predicate<IReferenceDescription>() {
					public boolean apply(IReferenceDescription input) {
						return !isImportTypeReference(input);
					}
				});
		RewritableImportSection importSection = importSectionFactory.parse((XtextResource) referringResource);
		ImportAwareUpdateAcceptor importAwareUpdateAcceptor = createUpdateAcceptor(updateAcceptor, importSection);
		super.processReferringResource(referringResource, nonImportReferences, elementRenameArguments, importAwareUpdateAcceptor);
		List<ReplaceRegion> importChanges = importSection.rewrite();
		TextEdit importChangeEdit = replaceConverter.convertToTextEdit(importChanges);
		if(importChangeEdit != null) 
			updateAcceptor.accept(referringResource.getURI(), importChangeEdit);
	}

	protected ImportAwareUpdateAcceptor createUpdateAcceptor(IRefactoringUpdateAcceptor updateAcceptor, RewritableImportSection importSection) {
		return new ImportAwareUpdateAcceptor(updateAcceptor, importSection);
	}

	protected boolean isImportTypeReference(IReferenceDescription input) {
		return input.getEReference() == XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE;
	}

	@Override
	protected void createTextChange(ITextRegion referenceTextRegion, String newReferenceText, EObject referringElement,
			EObject newTargetElement, EReference reference, URI referringResourceURI,
			IRefactoringUpdateAcceptor updateAcceptor) {
		if (newReferenceText != null
				&& updateAcceptor instanceof ImportAwareUpdateAcceptor 
				&& newTargetElement instanceof JvmMember 
				&& !isImplicitVariable(newTargetElement, reference, newReferenceText)) {
			boolean isStaticFeatureCall = isStaticFeatureCall(referringElement, reference, newTargetElement);
			// do nothing on static feature calls with explicit type as the type reference has a separate reference
			Pair<JvmDeclaredType, QualifiedName> importedTypeAndRelativeName = getImportedTypeAndRelativeName((JvmMember)newTargetElement, ((ImportAwareUpdateAcceptor) updateAcceptor).getImportSection());
			if(importedTypeAndRelativeName != null) {
				JvmDeclaredType importedType = importedTypeAndRelativeName.getFirst();
				QualifiedName importRelativeName = importedTypeAndRelativeName.getSecond();
				boolean isStaticExtensionFeatureCall = isStaticExtensionFeatureCall(referringElement, reference, newTargetElement);
				// constructor calls and type references are import aware, but only type reference can be disambiguated by using
				// #getSingleElement
				IScope scope = getLinkingScopeProvider().getScope(referringElement, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
				if (scope != null) {
					((ImportAwareUpdateAcceptor) updateAcceptor).removeImport(importedType,
							isStaticFeatureCall,
							isStaticExtensionFeatureCall);
					// check for ambiguities if there were an import
					IEObjectDescription singleElement = scope.getSingleElement(importRelativeName);
					EObject resolvedSingleElement = null;
					if(singleElement != null) 
						resolvedSingleElement = EcoreUtil.resolve(singleElement.getEObjectOrProxy(), referringElement);
					if (singleElement == null || resolvedSingleElement == EcoreUtil2.getContainerOfType(newTargetElement, JvmDeclaredType.class)) {
						if(!isEmpty(importedType.getPackageName())) 
							((ImportAwareUpdateAcceptor) updateAcceptor).acceptImport(importedType,
									isStaticFeatureCall,
									isStaticExtensionFeatureCall);
						if (newTargetElement instanceof JvmType) {
							newReferenceText = getLinkText(importRelativeName, newReferenceText);	
						}
					} else if(!isStaticExtensionFeatureCall) {
						QualifiedName newTargetQualifiedName = qualifiedNameProvider.getFullyQualifiedName(newTargetElement);
						// name conflict -> use FQN
						newReferenceText = getLinkText(newTargetQualifiedName, newReferenceText);
					}
				}
			}
			if (isStaticFeatureCall)
				return;
		}
		super.createTextChange(referenceTextRegion, newReferenceText, referringElement, newTargetElement, reference,
				referringResourceURI, updateAcceptor);
	}
	
	protected boolean isImplicitVariable(EObject newTargetElement, EReference reference, String newTargetText) {
		return newTargetElement instanceof JvmDeclaredType && reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
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
	 * @return the currently imported type containing the newTargetElement and the element's name relative to that import.
	 */
	protected Pair<JvmDeclaredType, QualifiedName> getImportedTypeAndRelativeName(JvmMember newTargetElement, RewritableImportSection section) {
		if(newTargetElement instanceof JvmConstructor)
			return getImportedTypeAndRelativeName(newTargetElement.getDeclaringType(), section);
		if(!isStaticallyReferrable(newTargetElement)) 
			return null;
		if (newTargetElement instanceof JvmFeature) {
			return getImportedTypeAndRelativeName(newTargetElement.getDeclaringType(), section);
		}
		StringBuffer relativeName = new StringBuffer(newTargetElement.getSimpleName());
		JvmMember currentMember = newTargetElement; 
		while(currentMember.getDeclaringType() != null 
				&& section.getImportedType(currentMember.getSimpleName()) != currentMember) {
			currentMember = currentMember.getDeclaringType();
			relativeName.insert(0, ".");
			relativeName.insert(0, currentMember.getSimpleName());
		}
		return Tuples.create((JvmDeclaredType) currentMember, qualifiedNameConverter.toQualifiedName(relativeName.toString()));
	}
	
	protected boolean isStaticallyReferrable(JvmMember newTargetElement) {
		if (newTargetElement instanceof JvmDeclaredType) 
			return true;
		else if(newTargetElement instanceof JvmFeature)
			return ((JvmFeature)newTargetElement).isStatic();
		return false;
	}

	protected String getLinkText(QualifiedName importRelativeName, String newReferenceText) {
		if(newReferenceText.endsWith("::")) 
			return importRelativeName.toString("::") + "::";
		else 
			return importRelativeName.toString(".");
	}
	
	public static class ImportAwareUpdateAcceptor implements IRefactoringUpdateAcceptor {

		private IRefactoringUpdateAcceptor delegate;

		private RewritableImportSection importSection;

		public ImportAwareUpdateAcceptor(IRefactoringUpdateAcceptor delegate, RewritableImportSection importSection) {
			this.delegate = delegate;
			this.importSection = importSection;
		}

		public void accept(URI resourceURI, TextEdit textEdit) {
			delegate.accept(resourceURI, textEdit);
		}

		public void accept(URI resourceURI, Change change) {
			delegate.accept(resourceURI, change);
		}

		public StatusWrapper getRefactoringStatus() {
			return delegate.getRefactoringStatus();
		}

		public IRefactoringDocument getDocument(URI resourceURI) {
			return delegate.getDocument(resourceURI);
		}

		public Change createCompositeChange(String name, IProgressMonitor monitor) {
			return delegate.createCompositeChange(name, monitor);
		}

		public boolean acceptImport(JvmDeclaredType type, boolean isStatic, boolean isExtension) {
			if(isExtension)
				return importSection.addStaticExtensionImport(type);
			else if(isStatic) 
				return importSection.addStaticImport(type);
			else 
				return importSection.addImport(type);
		}

		public boolean removeImport(JvmDeclaredType type, boolean isStatic, boolean isExtension) {
			if(isExtension)
				return importSection.removeStaticExtensionImport(type, null);
			else if(isStatic) 
				return importSection.removeStaticImport(type, null);
			else
				return importSection.removeImport(type);
		}
		
		public RewritableImportSection getImportSection() {
			return importSection;
		}
	}

}
