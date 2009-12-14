/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.contentassist;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.common.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow
 */
public class XtextProposalProvider extends org.eclipse.xtext.contentassist.AbstractXtextProposalProvider {
	
	@Override
	public void completeGrammar_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Resource resource = model.eResource();
		URI uri = resource.getURI();
		IPath path = new Path(uri.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		IProject project = file.getProject();
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject != null) {
			try {
				for (IPackageFragmentRoot packageFragmentRoot: javaProject.getPackageFragmentRoots()) {
					IPath packageFragmentRootPath = packageFragmentRoot.getPath();
					if (packageFragmentRootPath.isPrefixOf(path)) {
						IPath relativePath = path.makeRelativeTo(packageFragmentRootPath);
						relativePath = relativePath.removeFileExtension();
						String result = relativePath.toString();
						result = result.replace('/', '.');
						acceptor.accept(createCompletionProposal(result, null, null, context));
						return;
					}
				}
			} catch (JavaModelException ex) {
				// nothing to do
			}
		}
	}
	
	@Override
	protected String getDisplayString(EObject element, String proposal) {
		if (element instanceof AbstractMetamodelDeclaration) {
			AbstractMetamodelDeclaration decl = (AbstractMetamodelDeclaration) element;
			if (!Strings.isEmpty(decl.getAlias()))
				return decl.getAlias();
		}
		return super.getDisplayString(element, proposal);
	}
	
	/**
	 * Not a full featured solution for the computation of available structural features,
	 * but it is sufficient for some interesting 80%.
	 */
	@Override
	public void completeAssignment_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		AbstractRule rule = EcoreUtil2.getContainerOfType(model, AbstractRule.class);
		EClassifier type = rule.getType().getClassifier();
		if (type instanceof EClass) {
			List<EStructuralFeature> features = ((EClass) type).getEAllStructuralFeatures();
			completeStructuralFeatures(context, acceptor, features);
		}
		super.completeAssignment_Feature(model, assignment, context, acceptor);
	}

	private void completeStructuralFeatures(ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			Iterable<? extends EStructuralFeature> features) {
		if (features != null) {
			Function<IEObjectDescription, ICompletionProposal> factory = getProposalFactory("ID", context);
			for(EStructuralFeature feature: features) {
				IEObjectDescription description = EObjectDescription.create(feature.getName(), feature);
				ConfigurableCompletionProposal proposal = (ConfigurableCompletionProposal) factory.apply(description);
				if (proposal != null)
					proposal.setPriority(proposal.getPriority() * 2);
				acceptor.accept(proposal);
			}
		}
	}
	
	@Override
	public void completeAction_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Action action = EcoreUtil2.getContainerOfType(model, Action.class);
		if (action != null && action.getType() != null) {
			EClassifier classifier = action.getType().getClassifier();
			if (classifier instanceof EClass) {
				List<EReference> containments = ((EClass) classifier).getEAllContainments();
				completeStructuralFeatures(context, acceptor, containments);	
			}
		}
		super.completeAction_Feature(model, assignment, context, acceptor);
	}
	
}
