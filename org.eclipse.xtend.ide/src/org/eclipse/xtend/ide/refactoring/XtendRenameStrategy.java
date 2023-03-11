/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.ui.refactoring.IChangeRedirector;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringException;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy;

import com.google.inject.Inject;

/**
 * Encapsulates the model changes of a rename refactoring.
 */
public class XtendRenameStrategy extends DefaultJvmModelRenameStrategy {

	@Inject
	private XtendGrammarAccess grammarAccess;
	
	@Inject
	private OperatorMapping operatorMapping;
	
	private IRenameElementContext context;
	
	@Override
	public boolean initialize(EObject targetElement, IRenameElementContext context) {
		this.context = context;
		return super.initialize(targetElement, context);
	}
	
	@Override
	public RefactoringStatus validateNewName(String newName) {
		if (grammarAccess.getFunctionIDRule().getName().equals(nameRuleName)) {
			if (operatorMapping.getOperator(QualifiedName.create(newName)) != null) {
				RefactoringStatus status = new RefactoringStatus();
				if(nameRuleName != null) {
					try {
						String value = getNameAsValue(newName, grammarAccess.getValidIDRule().getName());
						String text = getNameAsText(value, grammarAccess.getValidIDRule().getName());
						if(!equal(text, newName)) {
							status.addError("Illegal name: '" + newName + "'. Consider using '" + text + "' instead.");
						}
					} catch(ValueConverterException vce) {
						status.addFatalError("Illegal name: " + notNull(vce.getMessage()));
					}
				}
				return status;
			}
		} 
		return super.validateNewName(newName);
	}
	
	@Override
	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		super.createDeclarationUpdates(newName, resourceSet, updateAcceptor);
		IPath path = getPathToRename(getTargetElementOriginalURI(), resourceSet);
		if (path != null && path.lastSegment().equals(this.getOriginalName()+".xtend"))
			updateAcceptor.accept(getTargetElementOriginalURI().trimFragment(), new RenameResourceChange(path, newName
					+ "." + path.getFileExtension()));
	}

	protected IPath getPathToRename(URI elementURI, ResourceSet resourceSet) {
		EObject targetObject = resourceSet.getEObject(elementURI, false);
		if (targetObject instanceof XtendTypeDeclaration) {
			URI resourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(targetObject).trimFragment();
			if (!resourceURI.isPlatformResource())
				throw new RefactoringException("Renamed type does not reside in the workspace");
			IPath path = new Path(resourceURI.toPlatformString(true));
			if(context instanceof IChangeRedirector.Aware) { 
				if(((IChangeRedirector.Aware) context).getChangeRedirector().getRedirectedPath(path) != path)
					return null;
			}
			return path;
		}
		return null;
	}
}
