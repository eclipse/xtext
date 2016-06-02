package org.eclipse.xpect.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xpect.XjmTest;
import org.eclipse.xpect.XpectConstants;
import org.eclipse.xpect.XpectJavaModel;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class XpectJavaModelManager {

	public static XpectJavaModel createJavaModel(Class<?> clazz) {
		XtextResourceSet rs = new XtextResourceSet();
		ClassLoader classLoader = clazz.getClassLoader();
		rs.setClasspathURIContext(classLoader);
		new ClasspathTypeProvider(classLoader, rs, null);
		JvmTypeReference typeReference = getTypeReferences().getTypeForName(clazz, rs);
		return createJavaModel(rs, (JvmDeclaredType) typeReference.getType());
	}

	private static XpectJavaModel createJavaModel(JvmDeclaredType type) {
		org.xpect.XpectJavaModelFactory fact = org.eclipse.xpect.XpectJavaModelFactory.eINSTANCE;
		XpectJavaModel result = fact.createXpectJavaModel();
		XjmTest test = fact.createXjmTest();
		test.setJvmClass(type);
		result.setTestOrSuite(test);
		return result;
	}

	private static XpectJavaModel createJavaModel(ResourceSet resourceSet, JvmDeclaredType type) {
		XpectJavaModel javaModel = createJavaModel(type);
		Resource res = new ResourceImpl(createURI(type.getQualifiedName()));
		res.getContents().add(javaModel);
		resourceSet.getResources().add(res);
		return javaModel;
	}

	private static URI createURI(String qualifiedName) {
		return URI.createURI("xpectjavamodel:/" + qualifiedName);
	}

	private static XpectJavaModel find(ResourceSet rs, String qualifiedName) {
		Resource resource = rs.getResource(createURI(qualifiedName), false);
		if (resource != null)
			for (EObject o : resource.getContents())
				if (o instanceof XpectJavaModel)
					return (XpectJavaModel) o;
		return null;
	}

	public static XpectJavaModel getOrCreate(JvmDeclaredType type) {
		ResourceSet resourceSet = type.eResource().getResourceSet();
		XpectJavaModel result = find(resourceSet, type.getQualifiedName());
		if (result != null)
			return result;
		return createJavaModel(resourceSet, type);
	}

	public static XpectJavaModel getOrCreate(ResourceSet rs, Class<?> clazz) {
		XtextResourceSet xtextResourceSet = ResourceSetsByClassloaderContext.get(rs, clazz.getClassLoader());
		XpectJavaModel result = find(xtextResourceSet, clazz.getName());
		if (result != null)
			return result;
		JvmTypeReference type = getTypeReferences().getTypeForName(clazz, xtextResourceSet);
		result = createJavaModel(xtextResourceSet, (JvmDeclaredType) type.getType());
		return result;
	}

	private static TypeReferences getTypeReferences() {
		Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(XpectConstants.XPECT_FILE_EXT).getInjector();
		return injector.getInstance(TypeReferences.class);
	}

}
