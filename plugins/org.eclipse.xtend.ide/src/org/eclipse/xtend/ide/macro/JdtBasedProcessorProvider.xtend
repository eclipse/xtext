package org.eclipse.xtend.ide.macro

import java.net.URL
import java.net.URLClassLoader
import java.util.ArrayList
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.common.util.URI
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.resource.XtextResourceSet

class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
	
	static val LOG = Logger::getLogger(typeof(JdtBasedProcessorProvider))
	
	override getProcessorInstance(JvmType type) {
		try {
			val project = (type.eResource.resourceSet as XtextResourceSet).classpathURIContext as IJavaProject
			val entries =  project.getResolvedClasspath(true)
			val urls = new ArrayList<URL>
			for (entry : entries) {
				if (entry.entryKind == IClasspathEntry::CPE_PROJECT) {
				}
				urls += entry.path.toFile.toURL
			}
			val classLoader = createClassLoader(project)
			val result = classLoader.loadClass(type.identifier)
			return result.newInstance
		} catch (Exception e) {
			LOG.info(e)
			return null
		}
	}
	
	def protected ClassLoader createClassLoader(IJavaProject javaProject) {
		val resolvedClasspath = javaProject.getResolvedClasspath(true)
		val List<URL> urls = newArrayList()
		urls.addAll(getOutputFolders(javaProject));
		for (entry : resolvedClasspath) {
			var IPath path = null
			var URL url = null
			switch entry.entryKind {
				case IClasspathEntry::CPE_SOURCE: {/* do nothing */}
				case IClasspathEntry::CPE_PROJECT: {
					val IResource project = javaProject.project.workspace.root.findMember(entry.getPath())
					urls.addAll(getOutputFolders(JavaCore::create(project.getProject())))
				}
				default: {
					path = entry.getPath();
					url = path.toFile().toURI().toURL();
				}
			}
			if (url != null) {
				urls.add(url);
			}
		}
		return new URLClassLoader(urls, getClass().getClassLoader());
	}

	def private List<URL> getOutputFolders(IJavaProject javaProject) {
		val List<URL> result = newArrayList;
		var IPath path = javaProject.getOutputLocation().addTrailingSeparator();
		var URL url = new URL(URI::createPlatformResourceURI(path.toString(), true).toString());
		result.add(url);
		for (IClasspathEntry entry : javaProject.getRawClasspath()) {
			switch (entry.getEntryKind()) {
				case IClasspathEntry::CPE_SOURCE: {
					path = entry.getOutputLocation();
					if (path != null) {
						url = new URL(URI::createPlatformResourceURI(path.addTrailingSeparator().toString(), true)
								.toString());
						result.add(url);
					}
				}
			}
		}
		return result;
	}
	
}