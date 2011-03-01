package org.eclipse.xtext.example.domainmodel.ui.generator;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.example.domainmodel.compiler.DomainmodelCompiler;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class Generator implements IXtextBuilderParticipant {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter; 
	
	@Inject 
	private DomainmodelCompiler compiler;
	
	@Inject
	private IEncodingProvider encodingProvider;
	
	public void build(final IBuildContext context, IProgressMonitor monitor) throws CoreException {
		IJavaProject javaProject = JavaCore.create(context.getBuiltProject());
		if (!javaProject.exists())
			return;
		final IFolder srcGenFolder = context.getBuiltProject().getFolder("src-gen");
		if (!srcGenFolder.exists())
			return;
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(srcGenFolder);
		if (!root.exists())
			return;
		for (IResourceDescription.Delta delta : context.getDeltas()) {
			// handle deletion
			if (delta.getNew() == null) {
				Iterable<IEObjectDescription> iterable = delta.getOld().getExportedObjectsByType(DomainmodelPackage.Literals.ENTITY);
				for (IEObjectDescription ieObjectDescription : iterable) {
					IFile file = getFile(srcGenFolder, ieObjectDescription.getQualifiedName());
					if (file.exists()) {
						file.delete(true, monitor);
						context.needRebuild();
					}
				}
			} else {
				Iterable<IEObjectDescription> newOnes = delta.getNew().getExportedObjectsByType(DomainmodelPackage.Literals.ENTITY);
				if (delta.getOld() != null) {
					Iterable<IEObjectDescription> oldOnes = delta.getOld().getExportedObjectsByType(DomainmodelPackage.Literals.ENTITY);
					Set<QualifiedName> newQualifiedNames = Sets.newHashSet(Iterables.transform(newOnes,
							new Function<IEObjectDescription, QualifiedName>() {
								public QualifiedName apply(IEObjectDescription from) {
									return from.getQualifiedName();
								}
							}));

					for (IEObjectDescription descr : oldOnes) {
						if (!newQualifiedNames.contains(descr.getQualifiedName())) {
							IFile file = getFile(srcGenFolder, descr.getQualifiedName());
							if (file.exists()) {
								file.delete(true, monitor);
								context.needRebuild();
							}
						}
					}
				}
				String encoding = encodingProvider.getEncoding(delta.getUri());
				for (IEObjectDescription desc : newOnes) {
					compile(desc, srcGenFolder, encoding, context);
					context.needRebuild();
				}
			}
		}

	}

	protected void compile(IEObjectDescription desc, IFolder srcGenFolder, String encoding, IBuildContext context) {
		try {
			EObject eObject = context.getResourceSet().getEObject(desc.getEObjectURI(), true);
			if (eObject instanceof Entity) {
				Entity entity = (Entity) eObject;
				IFile file = getFile(srcGenFolder, desc.getQualifiedName());
				String javaCode = compiler.compile(entity).toString();
				if(file.exists()) 
					file.setContents(new StringInputStream(javaCode, encoding), true, true, null);
				else 
					file.create(new StringInputStream(javaCode, encoding), true, null);
			}
		} catch (Exception exc) {
			throw new WrappedException(exc);
		}
	}
	
	protected IFile getFile(final IFolder folder, QualifiedName qualifiedName) {
		return folder.getFile(new Path(qualifiedNameConverter.toString(qualifiedName).replace('.', '/') + ".java"));
	}
}
