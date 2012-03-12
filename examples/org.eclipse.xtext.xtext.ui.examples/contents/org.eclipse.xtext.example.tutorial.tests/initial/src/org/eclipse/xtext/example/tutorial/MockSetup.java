package org.eclipse.xtext.example.tutorial;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MockSetup implements IJvmDeclaredTypeAcceptor {

	private List<JvmDeclaredType> allTypes = Lists.newArrayList();
	
	@Inject
	private JvmModelGenerator generator;
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	private Resource dummyResource;
	
	public void use(IJvmModelInferrer inferrer) {
		createDummyResource();
		EObject dummyObject = EcoreUtil.create(EcorePackage.Literals.EOBJECT);
		dummyResource.getContents().add(dummyObject);
		inferrer.infer(dummyObject, this, false);
		for(JvmDeclaredType type: allTypes) {
			CharSequence javaCode = generator.generateType(type);
			System.out.println(javaCode);
		}
	}

	private void createDummyResource() {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		resourceSet.setClasspathURIContext(getClass());
		dummyResource = resourceSet.createResource(URI.createURI("dummy.xmi"));
	}

	public <T extends JvmDeclaredType> IPostIndexingInitializing<T> accept(final T type) {
		if (type != null) {
			allTypes.add(type);
			dummyResource.getContents().add(type);
		}
		return new IPostIndexingInitializing<T>() {
			public void initializeLater(Procedure1<? super T> lateInitialization) {
				if (lateInitialization != null && type != null) {
					lateInitialization.apply(type);
				}
			}
		};
	}
	
}
