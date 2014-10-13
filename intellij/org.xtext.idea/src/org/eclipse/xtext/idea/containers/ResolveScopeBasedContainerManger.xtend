package org.eclipse.xtext.idea.containers

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IContainer.Manager
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.containers.DescriptionAddingContainer

class ResolveScopeBasedContainerManger implements Manager {

	@Inject
	Provider<ResolveScopeBasedContainer> resolveScopeBasedContainerProvider

	override getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		#[desc.getContainer(resourceDescriptions, true)]
	}

	override getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		desc.getContainer(resourceDescriptions, false)
	}

	protected def getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions,
		boolean withDependencies) {
		if (resourceDescriptions.indexing) {
			return IContainer.NULL_CONTAINER
		}
		val container = desc.getContainer(withDependencies) ?:
			resourceDescriptions.findContainer(desc.URI, withDependencies)
		if (container == null) {
			return IContainer.NULL_CONTAINER
		}
		if (!container.hasResourceDescription(desc.URI)) {
			return new DescriptionAddingContainer(desc, container)
		}
		container
	}

	protected def findContainer(IResourceDescriptions resourceDescriptions, URI uri, boolean withDependencies) {
		if (resourceDescriptions instanceof ProjectScopeBasedResourceDescriptions) {
			val container = resourceDescriptions.getResourceDescription(uri).getContainer(withDependencies)
			if (container != null) {
				return container
			}
			resourceDescriptions.project.findContainer(uri, withDependencies)
		}
	}

	protected def getContainer(IResourceDescription desc, boolean withDependencies) {
		if (desc instanceof PsiFileBasedResourceDescription) {
			if (withDependencies) {
				return resolveScopeBasedContainerProvider.get => [
					scope = desc.xtextFile.resolveScope
				]
			} else {
				desc.xtextFile.project.findContainer(desc.URI, withDependencies)
			}
		}
	}

	protected def findContainer(Project project, URI uri, boolean withDependencies) {
		val module = project.findModule(uri)
		if (module != null) {
			resolveScopeBasedContainerProvider.get => [
				scope = if (withDependencies) {
					module.getModuleWithDependenciesAndLibrariesScope(true)
				} else {
					module.getModuleScope(true)
				}
			]
		}
	}

	protected def Module findModule(Project project, URI uri) {
		if (uri.segmentCount == 0) {
			return null
		}
		val virtualFile = LocalFileSystem.instance.findFileByPath(uri.path)
		if (virtualFile != null) {
			val module = ModuleUtil.findModuleForFile(virtualFile, project)
			if (module != null) {
				return module
			}
		}
		project.findModule(uri.trimSegments(1))
	}

	protected def isIndexing(IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof ProjectScopeBasedResourceDescriptions)
			return resourceDescriptions.indexing
		else
			false
	}

}
