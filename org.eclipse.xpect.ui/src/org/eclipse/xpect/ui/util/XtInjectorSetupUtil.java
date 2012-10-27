package org.eclipse.xpect.ui.util;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.Stack;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.XtRuntimeModule;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xpect.setup.XtextInjectorSetup;
import org.eclipse.xpect.ui.XtUIModule;
import org.eclipse.xpect.ui.internal.XpectActivator;
import org.eclipse.xpect.ui.util.ContentTypeUtil.XpectContentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.ui.util.JdtClasspathUriResolver;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Sets;
import com.google.inject.Injector;
import com.google.inject.Module;

public class XtInjectorSetupUtil {
	public static Injector getWorkbenchInjector(ILanguageInfo lang, IFile file) {
		Injector defaultInjector = lang.getInjector();
		Module xtUIModule = defaultInjector.getInstance(XtUIModule.class);
		Module xtRuntimeModule = defaultInjector.getInstance(XtRuntimeModule.class);
		XpectFile xpectFile = XtInjectorSetupUtil.load(file);
		Class<? extends Module> workbenchModule = XtInjectorSetupUtil.getWorkbenchModule(xpectFile);
		if (workbenchModule != null)
			return lang.getInjector(xtRuntimeModule, xtUIModule, defaultInjector.getInstance(workbenchModule));
		else
			return lang.getInjector(xtRuntimeModule, xtUIModule);
	}

	public static Injector getWorkbenchInjector(URI uri, String fileExtension) {
		for (Pair<IStorage, IProject> storage : Access.getIStorage2UriMapper().get().getStorages(uri))
			if (storage.getFirst() instanceof IFile) {
				IFile file = (IFile) storage.getFirst();
				ILanguageInfo info = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(fileExtension);
				if (info != null)
					return XtInjectorSetupUtil.getWorkbenchInjector(info, file);
				else
					return null;
			}
		return null;
	}

	private static Class<? extends Module> getWorkbenchModule(XpectFile xpectFile) {
		if (xpectFile != null && xpectFile.getTest() != null) {
			JvmDeclaredType testType = xpectFile.getTest().getTestClass();
			if (testType != null && !testType.eIsProxy()) {
				Stack<JvmDeclaredType> candidates = new Stack<JvmDeclaredType>();
				candidates.add(testType);
				Set<JvmDeclaredType> visited = Sets.newHashSet(testType);
				while (!candidates.isEmpty()) {
					JvmDeclaredType candidate = candidates.pop();
					Class<?> testClass = TypeUiUtil.getWorkspaceTypeFromHostPlatform(candidate);
					if (testClass != null) {
						XtextInjectorSetup xtextInjectorSetup = testClass.getAnnotation(XtextInjectorSetup.class);
						if (xtextInjectorSetup != null)
							return xtextInjectorSetup.workbenchModule();
					}
					for (JvmTypeReference ref : candidate.getSuperTypes())
						if (ref.getType() instanceof JvmDeclaredType && !ref.getType().eIsProxy()) {
							JvmDeclaredType type = (JvmDeclaredType) ref.getType();
							if (visited.add(type))
								candidates.push(type);
						}
				}
			}
		}
		return null;
	}

	private static XpectFile load(IFile file) {
		Injector injector = XpectActivator.getInstance().getInjector(XpectActivator.ORG_ECLIPSE_XPECT_XPECT);
		XtextResourceSet rs = new XtextResourceSet();
		IJavaProject javaProject = JavaCore.create(file.getProject());
		if (javaProject != null && javaProject.exists()) {
			rs.setClasspathURIContext(javaProject);
			rs.setClasspathUriResolver(new JdtClasspathUriResolver());
		}
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = injector.getInstance(XtextResourceFactory.class).createResource(uri);
		rs.getResources().add(resource);
		try {
			resource.load(Collections.emptyMap());
			for (EObject obj : resource.getContents())
				if (obj instanceof XpectFile)
					return (XpectFile) obj;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
