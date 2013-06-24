package org.xpect.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xpect.XjmFactory;
import org.xpect.XjmTest;
import org.xpect.XpectJavaModel;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class XpectJavaModelFactory {

	@Inject
	private TypeReferences typeReferences;

	public XpectJavaModel createJavaModel(Class<?> clazz) {
		XtextResourceSet rs = new XtextResourceSet();
		ClassLoader classLoader = clazz.getClassLoader();
		rs.setClasspathURIContext(classLoader);
		rs.setClasspathUriResolver(new ClassloaderClasspathUriResolver());
		new ClasspathTypeProvider(classLoader, rs, null);
		JvmTypeReference typeReference = typeReferences.getTypeForName(clazz, rs);
		return createJavaModel(rs, (JvmDeclaredType) typeReference.getType());
	}

	private XpectJavaModel createJavaModel(JvmDeclaredType type) {
		XpectJavaModel result = XjmFactory.eINSTANCE.createXpectJavaModel();
		XjmTest test = XjmFactory.eINSTANCE.createXjmTest();
		test.setJvmClass(type);
		result.setTestOrSuite(test);
		return result;
	}

	public XpectJavaModel createJavaModel(ResourceSet resourceSet, JvmDeclaredType type) {
		XpectJavaModel javaModel = createJavaModel(type);
		Resource res = new ResourceImpl(createURI(type.getQualifiedName()));
		res.getContents().add(javaModel);
		resourceSet.getResources().add(res);
		return javaModel;
	}

	public URI createURI(String qualifiedName) {
		return URI.createURI("xpectjavamodel:/" + qualifiedName);
	}

}
