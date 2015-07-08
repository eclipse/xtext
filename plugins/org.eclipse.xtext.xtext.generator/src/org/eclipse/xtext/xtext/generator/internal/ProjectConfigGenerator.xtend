/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.internal

import java.io.Closeable
import java.util.ArrayList
import java.io.FileWriter
import java.io.File

/**
 * A utility class for generating XtextProjectConfig. Not intended to be used outside of this project.
 */
class ProjectConfigGenerator {
	
	static val INTERFACE_NAME = 'org.eclipse.xtext.xtext.generator.IXtextProjectConfig'
	static val IMPL_NAME = 'org.eclipse.xtext.xtext.generator.XtextProjectConfig'
	
	static val PROJECTS = #[
		'runtime', 'runtimeTest', 'genericIde', 'genericIdeTest', 'eclipsePlugin', 'eclipsePluginTest',
		'ideaPlugin', 'ideaPluginTest', 'web', 'webTest'
	]
	
	static def void main(String[] args) {
		val closeables = new ArrayList<Closeable>
		try {
			val interfaceWriter = new FileWriter('src' + File.separator + INTERFACE_NAME.replace('.', File.separator) + '.java')
			closeables += interfaceWriter
			val implWriter = new FileWriter('src' + File.separator + IMPL_NAME.replace('.', File.separator) + '.java')
			closeables += implWriter
			
			val generator = new ProjectConfigGenerator
			interfaceWriter.write(generator.generateInterface().toString)
			implWriter.write(generator.generateImpl().toString)
			
		} catch (Throwable t) {
			t.printStackTrace()
		} finally {
			closeables.forEach[close()]
		}
	}
	
	def generateInterface() '''
		/*******************************************************************************
		 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
		 * All rights reserved. This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *******************************************************************************/
		package «INTERFACE_NAME.substring(0, INTERFACE_NAME.lastIndexOf('.'))»;
		
		import org.eclipse.xtext.generator.IFileSystemAccess2;
		import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
		import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
		import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
		
		/**
		 * Inject an instance of this interface in order to generate code in a generator fragment.
		 *
		 * <p>This file has been generated with {@link «ProjectConfigGenerator.name»}.</p>
		 */
		public interface «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» extends IGuiceAwareGeneratorComponent {
			
			«FOR p : PROJECTS»
				IFileSystemAccess2 get«p.toFirstUpper»Src();
				IFileSystemAccess2 get«p.toFirstUpper»SrcGen();
				ManifestAccess get«p.toFirstUpper»Manifest();
				PluginXmlAccess get«p.toFirstUpper»PluginXml();
				
			«ENDFOR»
			IFileSystemAccess2 getOrionJsGen();
			IFileSystemAccess2 getAceJsGen();
			
		}
	'''
	
	def generateImpl() '''
		/*******************************************************************************
		 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
		 * All rights reserved. This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *******************************************************************************/
		package «IMPL_NAME.substring(0, IMPL_NAME.lastIndexOf('.'))»;
		
		import com.google.common.collect.Maps;
		import com.google.inject.Injector;
		import java.util.Map;
		import org.eclipse.emf.mwe.core.issues.Issues;
		import org.eclipse.xtext.generator.IFileSystemAccess2;
		import org.eclipse.xtext.util.Strings;
		import org.eclipse.xtext.xtext.generator.XtextGenerator;
		import org.eclipse.xtext.xtext.generator.model.FileSystemAccess;
		import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
		import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
		
		/**
		 * Use this class to configure output paths in the XtextGenerator.
		 *
		 * <p>This file has been generated with {@link «ProjectConfigGenerator.name»}.</p>
		 */
		public class «IMPL_NAME.substring(IMPL_NAME.lastIndexOf('.') + 1)» implements «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» {
			
			«FOR p : PROJECTS»
				private FileSystemAccess «p»Src;
				private FileSystemAccess «p»SrcGen;
				private ManifestAccess «p»Manifest;
				private PluginXmlAccess «p»PluginXml;
			«ENDFOR»
			private FileSystemAccess orionJsGen;
			private FileSystemAccess aceJsGen;
			
			public void checkConfiguration(XtextGenerator generator, Issues issues) {
				if («PROJECTS.head»Src == null) {
					issues.addError(generator, "The property '«PROJECTS.head»Src' must be set.", this);
				}
				if («PROJECTS.head»SrcGen == null) {
					issues.addError(generator, "The property '«PROJECTS.head»SrcGen' must be set.", this);
				}
				«FOR p : PROJECTS»
					if («p»Manifest != null && Strings.isEmpty(«p»Manifest.getPath())) {
						issues.addError(generator, "The property 'path' must be set.", «p»Manifest);
					}
					if («p»PluginXml != null && Strings.isEmpty(«p»PluginXml.getPath())) {
						issues.addError(generator, "The property 'path' must be set.", «p»PluginXml);
					}
				«ENDFOR»
			}
			
			@Override
			public void initialize(Injector injector) {
				injector.injectMembers(this);
				Map<String, ManifestAccess> manifestPaths = Maps.newHashMapWithExpectedSize(«PROJECTS.size»);
				Map<String, PluginXmlAccess> pluginXmlPaths = Maps.newHashMapWithExpectedSize(«PROJECTS.size»);
				«FOR p : PROJECTS»
					
					// Initialize «p» configuration
					if («p»Src != null) {
						«p»Src.initialize(injector);
					}
					if («p»SrcGen != null) {
						«p»SrcGen.initialize(injector);
					}
					if («p»Manifest != null) {
						ManifestAccess access = manifestPaths.get(«p»Manifest.getPath());
						if (access == null) {
							manifestPaths.put(«p»Manifest.getPath(), «p»Manifest);
						} else if (access != «p»Manifest) {
							set«p.toFirstUpper»Manifest(access);
						}
					}
					if («p»PluginXml != null) {
						PluginXmlAccess access = pluginXmlPaths.get(«p»PluginXml.getPath());
						if (access == null) {
							pluginXmlPaths.put(«p»PluginXml.getPath(), «p»PluginXml);
						} else if (access != «p»PluginXml) {
							set«p.toFirstUpper»PluginXml(access);
						}
					}
				«ENDFOR»
				if (orionJsGen != null) {
					orionJsGen.initialize(injector);
				}
				if (aceJsGen != null) {
					aceJsGen.initialize(injector);
				}
			}
			
			«FOR p : PROJECTS»
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»Src() {
					return «p»Src;
				}
				
				public void set«p.toFirstUpper»Src(String path) {
					this.«p»Src = new FileSystemAccess(path);
				}
				
				@Override
				public IFileSystemAccess2 get«p.toFirstUpper»SrcGen() {
					return «p»SrcGen;
				}
				
				public void set«p.toFirstUpper»SrcGen(String path) {
					this.«p»SrcGen = new FileSystemAccess(path);
				}
				
				@Override
				public ManifestAccess get«p.toFirstUpper»Manifest() {
					return «p»Manifest;
				}
				
				public void set«p.toFirstUpper»Manifest(ManifestAccess manifest) {
					this.«p»Manifest = manifest;
				}
				
				@Override
				public PluginXmlAccess get«p.toFirstUpper»PluginXml() {
					return «p»PluginXml;
				}
				
				public void set«p.toFirstUpper»PluginXml(PluginXmlAccess pluginXml) {
					this.«p»PluginXml = pluginXml;
				}
				
			«ENDFOR»
			@Override
			public IFileSystemAccess2 getOrionJsGen() {
				return orionJsGen;
			}
			
			public void setOrionJsGen(String path) {
				this.orionJsGen = new FileSystemAccess(path);
			}
			
			@Override
			public IFileSystemAccess2 getAceJsGen() {
				return aceJsGen;
			}
			
			public void setAceJsGen(String path) {
				this.aceJsGen = new FileSystemAccess(path);
			}
			
		}
	'''
	
}