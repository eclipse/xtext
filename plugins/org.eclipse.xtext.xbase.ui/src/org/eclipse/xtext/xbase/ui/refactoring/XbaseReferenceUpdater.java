/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static com.google.common.collect.Iterables.*;

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
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelReferenceUpdater;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseReferenceUpdater extends JvmModelReferenceUpdater {

	@Inject@LinkingScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private RewritableImportSection.Factory importSectionFactory;
	
	@Inject
	private ReplaceConverter replaceConverter;
	
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
		super.processReferringResource(referringResource, nonImportReferences, elementRenameArguments,
				importAwareUpdateAcceptor);
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
		JvmDeclaredType targetContainerType = getTopLevelContainerType(newTargetElement);
		if (targetContainerType != null && updateAcceptor instanceof ImportAwareUpdateAcceptor) {
			boolean isStaticFeatureCall = isStaticFeatureCall(referringElement, reference, newTargetElement);
			boolean isStaticExtensionFeatureCall = isStaticExtensionFeatureCall(referringElement, reference, newTargetElement);
			if(newTargetElement instanceof JvmMember)
				((ImportAwareUpdateAcceptor) updateAcceptor).removeImport(targetContainerType,
						isStaticFeatureCall,
						isStaticExtensionFeatureCall);
			if (targetContainerType.getIdentifier().contains(".")) {
				IScope scope = scopeProvider.getScope(referringElement, reference);
				if (scope != null && newReferenceText != null) {
					String shortName = (newReferenceText.startsWith(targetContainerType.getIdentifier())) 
							? newReferenceText.substring(targetContainerType.getPackageName().length() + 1)
							: newReferenceText;
					// check for ambiguities if there were an import
					IEObjectDescription singleElement = scope.getSingleElement(
							qualifiedNameConverter.toQualifiedName(shortName));
					EObject resolvedSingleElement = null;
					if(singleElement != null) 
						resolvedSingleElement = EcoreUtil.resolve(singleElement.getEObjectOrProxy(), referringElement);
					if (resolvedSingleElement == newTargetElement) {
						((ImportAwareUpdateAcceptor) updateAcceptor).acceptImport(targetContainerType,
								isStaticFeatureCall,
								isStaticExtensionFeatureCall);
						newReferenceText = shortName;
					} else {
						QualifiedName newTargetQualifiedName = qualifiedNameProvider.getFullyQualifiedName(newTargetElement);
						// same element on scope with simple name, so use FQNs
						newReferenceText = qualifiedNameConverter.toString(newTargetQualifiedName);
					}
				}
			}
		}
		super.createTextChange(referenceTextRegion, newReferenceText, referringElement, newTargetElement, reference,
				referringResourceURI, updateAcceptor);
	}
	
	protected boolean isStaticFeatureCall(EObject referringElement, EReference reference, EObject newTargetElement) {
		return referringElement instanceof XAbstractFeatureCall
				&& reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE
				&& newTargetElement instanceof JvmFeature
				&& ((JvmFeature)newTargetElement).isStatic();
	}

	protected boolean isStaticExtensionFeatureCall(EObject referringElement, EReference reference, EObject newTargetElement) {
		return isStaticFeatureCall(referringElement, reference, newTargetElement) 
				&& referringElement instanceof XMemberFeatureCall; 
	}

	protected JvmDeclaredType getTopLevelContainerType(EObject newTargetElement) {
		JvmDeclaredType currentContainerType = EcoreUtil2.getContainerOfType(newTargetElement, JvmDeclaredType.class);
		while(currentContainerType != null && currentContainerType.getDeclaringType() != null)
			currentContainerType = currentContainerType.getDeclaringType();
		return currentContainerType;
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

		public void acceptImport(JvmDeclaredType type, boolean isStatic, boolean isExtension) {
			if(isStatic) {
				if(isExtension)
					importSection.addStaticExtensionImport(type);
				else
					importSection.addStaticImport(type);
			} else {
				importSection.addImport(type);
			}
		}

		public void removeImport(JvmDeclaredType type, boolean isStatic, boolean isExtension) {
			if(isStatic) {
				if(isExtension)
					importSection.removeStaticExtensionImport(type);
				else
					importSection.removeStaticImport(type);
			} else {
				importSection.removeImport(type);
			}
		}
	}

}
