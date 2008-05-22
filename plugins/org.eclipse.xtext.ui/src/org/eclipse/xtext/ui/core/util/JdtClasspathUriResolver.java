package org.eclipse.xtext.ui.core.util;

import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;

public class JdtClasspathUriResolver implements IClasspathUriResolver {

    private IJavaElement javaElement;

    public URI resolve(Object context, URI classpathUri) {
        if (!(context instanceof IJavaElement)) {
            throw new IllegalArgumentException("Context must implement IResource");
        }
        javaElement = (IJavaElement) context;
        try {
            if (ClasspathUriUtil.isClassapthUri(classpathUri)) {
                IJavaProject javaProject = javaElement.getJavaProject();
                return findResourceInWorkspace(javaProject, classpathUri);
            }
        } catch (Exception exc) {
            throw new ClasspathUriResolutionException(exc);
        }
        return classpathUri;
    }

    @SuppressWarnings("restriction")
    protected static URI findResourceInWorkspace(IJavaProject javaProject, URI classpathUri) throws JavaModelException, CoreException {
        Path fullPath = new Path(classpathUri.path());
        String projectRelativePath = fullPath.toString();
        if (javaProject.exists()) {
            IPackageFragmentRoot[] allPackageFragmentRoots = javaProject.getAllPackageFragmentRoots();
            for (IPackageFragmentRoot packageFragmentRoot : allPackageFragmentRoots) {
                IResource correspondingResource = packageFragmentRoot.getCorrespondingResource();
                if (correspondingResource != null) {
                    if (correspondingResource instanceof IFile) {
                        // jar file
                        JarPackageFragmentRoot jarPackageFragmentRoot = (JarPackageFragmentRoot) JavaCore
                                .createJarPackageFragmentRootFrom((IFile) correspondingResource);
                        if (jarPackageFragmentRoot != null) {
                            ZipFile zipFile = jarPackageFragmentRoot.getJar();
                            if (zipFile != null) {
                                ZipEntry zipEntry = zipFile.getEntry(projectRelativePath.substring(1));
                                if (zipEntry != null) {
                                    return URI.createURI("jar:" + "platform:/resource" + correspondingResource.getFullPath() + "!"
                                            + projectRelativePath, true);
                                }
                            }
                        }
                    } else {
                        // plain file
                        IFolder rootFolder = (IFolder) correspondingResource;
                        IResource modelFile = rootFolder.findMember(projectRelativePath);
                        if (modelFile != null && modelFile.exists() && modelFile instanceof IFile) {
                            URI platformResourceUri = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
                            return platformResourceUri;
                        }
                    }
                }
            }
        }
        return classpathUri;
    }

}
