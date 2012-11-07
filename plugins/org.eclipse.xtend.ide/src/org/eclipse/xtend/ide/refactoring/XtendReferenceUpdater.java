/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtend.core.formatting.IImportCollection;
import org.eclipse.xtend.core.formatting.OrganizeImports;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
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
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelReferenceUpdater;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendReferenceUpdater extends JvmModelReferenceUpdater {

	@Inject@LinkingScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private OrganizeImports organizeImports;

	@Inject
	private IWhitespaceInformationProvider whitespaceInformationProvider;

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
		ImportAwareUpdateAcceptor importAwareUpdateAcceptor = createUpdateAcceptor(updateAcceptor);
		super.processReferringResource(referringResource, nonImportReferences, elementRenameArguments,
				importAwareUpdateAcceptor);
		RefactoringImports importCollection = createRefactoringImports(referringResource);
		importCollection.addImportedNames(importAwareUpdateAcceptor.getAdditionalImportedNames());
		TextRegion importRegion = organizeImports.computeRegion((XtextResource) referringResource);
		String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(referringResource.getURI())
				.getLineSeparator();
		String importSection = organizeImports.serializeImports(importCollection, lineSeparator);
		TextEdit importChange = new ReplaceEdit(importRegion.getOffset(), importRegion.getLength(), importSection);
		updateAcceptor.accept(referringResource.getURI(), importChange);
	}

	protected RefactoringImports createRefactoringImports(Resource referringResource) {
		return new RefactoringImports(referringResource);
	}

	protected ImportAwareUpdateAcceptor createUpdateAcceptor(IRefactoringUpdateAcceptor updateAcceptor) {
		return new ImportAwareUpdateAcceptor(updateAcceptor);
	}

	protected boolean isImportTypeReference(IReferenceDescription input) {
		return input.getEReference() == XtendPackage.Literals.XTEND_IMPORT__IMPORTED_TYPE;
	}

	@Override
	protected void createTextChange(ITextRegion referenceTextRegion, String newReferenceText, EObject referringElement,
			EObject newTargetElement, EReference reference, URI referringResourceURI,
			IRefactoringUpdateAcceptor updateAcceptor) {
		JvmDeclaredType targetContainerType = EcoreUtil2.getContainerOfType(newTargetElement, JvmDeclaredType.class);
		if (targetContainerType != null && updateAcceptor instanceof ImportAwareUpdateAcceptor) {
			if (targetContainerType.getIdentifier().contains(".")) {
				IScope scope = scopeProvider.getScope(referringElement, reference);
				if (scope != null) {
					if(newReferenceText != null && newReferenceText.startsWith(targetContainerType.getIdentifier())) {
						// check for ambiguities if there were an import
						String shortName = targetContainerType.getSimpleName() 
								+ newReferenceText.substring(targetContainerType.getIdentifier().length());
						IEObjectDescription singleElement = scope.getSingleElement(
								qualifiedNameConverter.toQualifiedName(shortName));
						if (singleElement == null) {
							newReferenceText = shortName;
							((ImportAwareUpdateAcceptor) updateAcceptor).acceptImport(targetContainerType.getIdentifier());
						} else if(singleElement.getQualifiedName().equals(qualifiedNameProvider.getFullyQualifiedName(newTargetElement))) {
							// same element on scope with simple name
							newReferenceText = shortName;
						}
					}
				}
			}
		}
		super.createTextChange(referenceTextRegion, newReferenceText, referringElement, newTargetElement, reference,
				referringResourceURI, updateAcceptor);
	}
	
	public static class ImportAwareUpdateAcceptor implements IRefactoringUpdateAcceptor {

		private IRefactoringUpdateAcceptor delegate;

		private List<String> additionalImportedNames;

		public ImportAwareUpdateAcceptor(IRefactoringUpdateAcceptor delegate) {
			this.delegate = delegate;
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

		public void acceptImport(String qualifiedName) {
			if (additionalImportedNames == null)
				additionalImportedNames = newArrayList();
			additionalImportedNames.add(qualifiedName);
		}

		public List<String> getAdditionalImportedNames() {
			return additionalImportedNames;
		}

	}

	public static class RefactoringImports implements IImportCollection {

		private Set<String> plainImports = newLinkedHashSet();

		private Set<String> staticImports = newLinkedHashSet();

		private Set<String> staticExtensionImports = newLinkedHashSet();

		public RefactoringImports(Resource xtendResource) {
			XtendFile xtendFile = (XtendFile) xtendResource.getContents().get(0);
			for (XtendImport xtendImport : xtendFile.getImports()) {
				if (xtendImport.getImportedNamespace() == null) {
					JvmType importedType = xtendImport.getImportedType();
					if (importedType != null && !importedType.eIsProxy()) {
						String importedTypeName = xtendImport.getImportedTypeName();
						if (importedType.getIdentifier().equals(importedTypeName))
							getSet(xtendImport).add(importedTypeName);
					}
				} else {
					getSet(xtendImport).add(xtendImport.getImportedNamespace());
				}
			}
		}

		public List<String> getListofImportedTypeNames() {
			return newArrayList(plainImports);
		}

		public List<String> getListofStaticImports() {
			return newArrayList(staticImports);
		}

		public List<String> getListofStaticExtensionImports() {
			return newArrayList(staticExtensionImports);
		}

		public void addImportedNames(List<String> importedNames) {
			if (importedNames != null)
				plainImports.addAll(importedNames);
		}

		public void remove(XtendImport xtendImport) {
			getSet(xtendImport).remove(getImportedName(xtendImport));
		}

		protected Set<String> getSet(XtendImport xtendImport) {
			if (xtendImport.isStatic())
				if (xtendImport.isExtension())
					return staticExtensionImports;
				else
					return staticImports;
			else
				return plainImports;
		}

		protected String getImportedName(XtendImport xtendImport) {
			if (xtendImport.getImportedNamespace() == null)
				return xtendImport.getImportedTypeName();
			else
				return xtendImport.getImportedNamespace();
		}
	}
}
