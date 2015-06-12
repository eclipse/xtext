package org.eclipse.xtext.java.resource

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.Constants
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.common.types.xtext.JvmIdentifiableQualifiedNameProvider
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager
import org.eclipse.xtext.validation.IResourceValidator

class JavaRuntimeModule extends AbstractModule {

	override protected configure() {
		bind(Resource.Factory).to(JavaResource.Factory)
		bind(IResourceValidator).toInstance(IResourceValidator.NULL)
		bind(IGenerator).to(IGenerator.NullGenerator)
		bind(IEncodingProvider).to(IEncodingProvider.Runtime)
		bind(IResourceServiceProvider).to(JavaResourceServiceProvider)
		bind(IContainer.Manager).to(SimpleResourceDescriptionsBasedContainerManager)
		bind(IResourceDescription.Manager).to(JavaResourceDescriptionManager)
		bind(IQualifiedNameProvider).to(JvmIdentifiableQualifiedNameProvider)
		bind(String).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("java")
		bind(IJvmTypeProvider.Factory).to(ClasspathTypeProviderFactory)
		bind(ClassLoader).toInstance(JavaRuntimeModule.classLoader)
	}

}