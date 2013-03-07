package org.eclipse.xtext.xbase.ui.editor

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.jdt.core.IJavaElement
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.jdt.core.JavaCore
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.ide.ResourceUtil
import org.eclipse.ui.part.FileEditorInput
import org.eclipse.xtext.LanguageInfo
import org.eclipse.xtext.generator.trace.ILocationInResource
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput

class XbaseEditorInputRedirector {

	@Inject
	private ITraceForStorageProvider traceInformation;

	@Inject
	private LanguageInfo languageInfo;

	@Inject
	private FileExtensionProvider fileExtensionProvider

	def IEditorInput findOriginalSource(IEditorInput input) {
		val resource = ResourceUtil::getFile(input)
		if (resource != null) {

			// if the given resource is already pointing to a language file
			if (fileExtensionProvider.isValid(resource.fullPath.fileExtension)) {
				val project = JavaCore::create(resource.project)
				if (project.exists) {

					// if it's sitting in the output dir look for original one
					if (project.outputLocation.isPrefixOf(resource.fullPath)) {
						val relative = resource.fullPath.removeFirstSegments(project.outputLocation.segmentCount)
						for (source : project.packageFragmentRoots.filter[kind == IPackageFragmentRoot::K_SOURCE]) {
							val fullPath = source.correspondingResource.projectRelativePath.append(relative)
							val newFile = resource.project.getFile(fullPath)
							if (newFile.exists) {
								return new FileEditorInput(newFile)
							}
						}
					}
				}
				return input
			}

			val trace = traceInformation.getTraceToSource(resource);
			if (trace == null)
				return input;
			val allLocations = trace.getAllAssociatedLocations().iterator();
			var ILocationInResource sourceInformation = null;
			while (allLocations.hasNext() && sourceInformation == null) {
				val candidate = allLocations.next();
				if (languageInfo.equals(candidate.getLanguage())) {
					sourceInformation = candidate;
				}
			}
			if (sourceInformation == null)
				return input;
			val originalStorage = sourceInformation.getStorage();
			switch originalStorage {
				IFile: return new FileEditorInput(originalStorage)
				default: return new XtextReadonlyEditorInput(originalStorage)
			}
		}
		return input;
	}

	def dispatch IPackageFragmentRoot getPackageFragmentRoot(IJavaElement element) {
		return element.parent.packageFragmentRoot
	}

	def dispatch IPackageFragmentRoot getPackageFragmentRoot(IPackageFragmentRoot element) {
		return element
	}

	def dispatch IPackageFragmentRoot getPackageFragmentRoot(Void element) {
		throw new IllegalStateException("couldn't find source package fragment root.")
	}

}
