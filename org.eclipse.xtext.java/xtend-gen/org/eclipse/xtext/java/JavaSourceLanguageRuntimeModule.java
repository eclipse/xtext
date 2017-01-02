package org.eclipse.xtext.java;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.JvmIdentifiableQualifiedNameProvider;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.java.resource.JavaResource;
import org.eclipse.xtext.java.resource.JavaResourceDescriptionManager;
import org.eclipse.xtext.java.resource.JavaResourceServiceProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;
import org.eclipse.xtext.validation.IResourceValidator;

@SuppressWarnings("all")
public class JavaSourceLanguageRuntimeModule extends AbstractModule {
  @Override
  protected void configure() {
    this.<Resource.Factory>bind(Resource.Factory.class).to(JavaResource.Factory.class);
    this.<IResourceValidator>bind(IResourceValidator.class).toInstance(IResourceValidator.NULL);
    this.<IGenerator>bind(IGenerator.class).to(IGenerator.NullGenerator.class);
    this.<IEncodingProvider>bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);
    this.<IResourceServiceProvider>bind(IResourceServiceProvider.class).to(JavaResourceServiceProvider.class);
    this.<IContainer.Manager>bind(IContainer.Manager.class).to(SimpleResourceDescriptionsBasedContainerManager.class);
    this.<IResourceDescription.Manager>bind(IResourceDescription.Manager.class).to(JavaResourceDescriptionManager.class);
    this.<IQualifiedNameProvider>bind(IQualifiedNameProvider.class).to(JvmIdentifiableQualifiedNameProvider.class);
    this.<String>bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("java");
    this.<String>bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("org.eclipse.xtext.java.Java");
    this.<IJvmTypeProvider.Factory>bind(IJvmTypeProvider.Factory.class).to(ClasspathTypeProviderFactory.class);
    this.<ClassLoader>bind(ClassLoader.class).toInstance(JavaSourceLanguageRuntimeModule.class.getClassLoader());
    this.<IReferableElementsUnloader>bind(IReferableElementsUnloader.class).to(IReferableElementsUnloader.GenericUnloader.class);
    final IResourceDescriptionsProvider _function = (ResourceSet it) -> {
      return ChunkedResourceDescriptions.findInEmfObject(it);
    };
    this.<IResourceDescriptionsProvider>bind(IResourceDescriptionsProvider.class).toInstance(_function);
  }
}
