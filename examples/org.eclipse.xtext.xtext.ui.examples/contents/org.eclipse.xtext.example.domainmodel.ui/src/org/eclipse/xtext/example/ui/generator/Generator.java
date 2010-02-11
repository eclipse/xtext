package org.eclipse.xtext.example.ui.generator;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xpand2.output.VetoException;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class Generator implements IXtextBuilderParticipant {

	public void build(final IBuildContext context, IProgressMonitor monitor) throws CoreException {
		IJavaProject javaProject = JavaCore.create(context.getBuiltProject());
		if (!javaProject.exists())
			return;
		final IFolder folder = context.getBuiltProject().getFolder("src-gen");
		if (!folder.exists())
			return;
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(folder);
		if (!root.exists())
			return;
		
		OutputImpl output = new OutputImpl();
		Outlet outlet = new Outlet() {
			@Override
			public FileHandle createFileHandle(String qualifiedName) throws VetoException {
				IFile file = createFile(folder, qualifiedName);
				return new EclipseBasedFileHandle(file, this);
			}
		};
		output.addOutlet(outlet);
		JavaImportsTool importsTool = new JavaImportsTool();
		outlet.addPostprocessor(importsTool);
		XpandExecutionContextImpl ctx = new XpandExecutionContextImpl(output, null,Collections.singletonMap(JavaImportsTool.VAR_NAME,  new Variable(JavaImportsTool.VAR_NAME,importsTool)),null,null);
		ctx.registerMetaModel(new JavaBeansMetaModel());
		
		for (IResourceDescription.Delta delta : context.getDeltas()) {
			// handle deletion
			if (delta.getNew() == null) {
				Iterable<IEObjectDescription> iterable = delta.getOld().getExportedObjects(
						DomainmodelPackage.Literals.ENTITY);
				for (IEObjectDescription ieObjectDescription : iterable) {
					String qualifiedName = ieObjectDescription.getQualifiedName();
					IFile file = createFile(folder, qualifiedName);
					if (file.exists()) {
						file.delete(true, monitor);
						context.needRebuild();
					}
				}
			} else {
				Iterable<IEObjectDescription> newOnes = delta.getNew().getExportedObjects(
						DomainmodelPackage.Literals.ENTITY);
				if (delta.getOld() != null) {
					Iterable<IEObjectDescription> oldOnes = delta.getOld().getExportedObjects(
							DomainmodelPackage.Literals.ENTITY);
					Set<String> names = Sets.newHashSet(Iterables.transform(newOnes,
							new Function<IEObjectDescription, String>() {
								public String apply(IEObjectDescription from) {
									return from.getQualifiedName();
								}
							}));

					for (IEObjectDescription descr : oldOnes) {
						if (!names.contains(descr.getQualifiedName())) {
							IFile file = createFile(folder, descr.getQualifiedName());
							if (file.exists()) {
								file.delete(true, monitor);
								context.needRebuild();
							}
						}
					}
				}
				for (IEObjectDescription desc : newOnes) {
					generate(desc, ctx, context);
					context.needRebuild();
				}
			}
		}

	}

	protected void generate(IEObjectDescription desc, XpandExecutionContextImpl ctx, IBuildContext context) {
		EObject eObject = context.getResourceSet().getEObject(desc.getEObjectURI(), true);
		XpandFacade.create(ctx).evaluate("org::eclipse::xtext::example::ui::generator::JavaBean::javaBean", eObject);
	}

	protected IFile createFile(final IFolder folder, String qualifiedName) {
		return folder.getFile(new Path(qualifiedName.replace('.', '/') + ".java"));
	}
}
