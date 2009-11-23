package org.eclipse.xtext.contentassist;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.Strings;

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
	
}
