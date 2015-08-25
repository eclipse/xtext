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
 //TODO only generate outlets that make sense (e.g. idea&web have no plugin.xml)
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
		
		import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
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
				IXtextGeneratorFileSystemAccess get«p.toFirstUpper»Root();
				IXtextGeneratorFileSystemAccess get«p.toFirstUpper»MetaInf();
				IXtextGeneratorFileSystemAccess get«p.toFirstUpper»Src();
				IXtextGeneratorFileSystemAccess get«p.toFirstUpper»SrcGen();
				IXtextGeneratorFileSystemAccess get«p.toFirstUpper»WebApp();
				ManifestAccess get«p.toFirstUpper»Manifest();
				PluginXmlAccess get«p.toFirstUpper»PluginXml();
				
			«ENDFOR»
			
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
		
		import com.google.inject.Injector;
		import org.eclipse.xtext.util.Strings;
		import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
		import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;
		import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
		import org.eclipse.xtext.xtext.generator.model.PluginXmlAccess;
		
		/**
		 * Use this class to configure output paths in the XtextGenerator.
		 *
		 * <p>This file has been generated with {@link «ProjectConfigGenerator.name»}.</p>
		 */
		public class «IMPL_NAME.substring(IMPL_NAME.lastIndexOf('.') + 1)» implements «INTERFACE_NAME.substring(INTERFACE_NAME.lastIndexOf('.') + 1)» {
			
			«FOR p : PROJECTS»
				private IXtextGeneratorFileSystemAccess «p»Root;
				private IXtextGeneratorFileSystemAccess «p»MetaInf;
				private IXtextGeneratorFileSystemAccess «p»Src;
				private IXtextGeneratorFileSystemAccess «p»SrcGen;
				private IXtextGeneratorFileSystemAccess «p»WebApp;
				private ManifestAccess «p»Manifest;
				private PluginXmlAccess «p»PluginXml;
			«ENDFOR»
			
			public void checkConfiguration(Issues issues) {
				if («PROJECTS.head»Src == null) {
					issues.addError("The property '«PROJECTS.head»Src' must be set.", this);
				}
				if («PROJECTS.head»SrcGen == null) {
					issues.addError("The property '«PROJECTS.head»SrcGen' must be set.", this);
				}
				«FOR p : PROJECTS»
					if («p»Manifest != null && Strings.isEmpty(«p»Manifest.getPath())) {
						issues.addError("The property 'path' must be set.", «p»Manifest);
					}
					if («p»PluginXml != null && Strings.isEmpty(«p»PluginXml.getPath())) {
						issues.addError("The property 'path' must be set.", «p»PluginXml);
					}
				«ENDFOR»
			}
			
			@Override
			public void initialize(Injector injector) {
				injector.injectMembers(this);
				«FOR p : PROJECTS»
					
					// Initialize «p» configuration
					if («p»Root != null) {
						«p»Root.initialize(injector);
					}
					if («p»MetaInf != null) {
						«p»MetaInf.initialize(injector);
					}
					if («p»Src != null) {
						«p»Src.initialize(injector);
					}
					if («p»SrcGen != null) {
						«p»SrcGen.initialize(injector);
					}
					if («p»WebApp != null) {
						«p»WebApp.initialize(injector);
					}
				«ENDFOR»
			}
			
			«FOR p : PROJECTS»
				@Override
				public IXtextGeneratorFileSystemAccess get«p.toFirstUpper»Root() {
					return «p»Root;
				}
				
				public void set«p.toFirstUpper»Root(String path) {
					this.«p»Root = new XtextGeneratorFileSystemAccess(path, true);
				}
				
				@Override
				public IXtextGeneratorFileSystemAccess get«p.toFirstUpper»MetaInf() {
					return «p»MetaInf;
				}
				
				public void set«p.toFirstUpper»MetaInf(String path) {
					this.«p»MetaInf = new XtextGeneratorFileSystemAccess(path, true);
				}
				
				@Override
				public IXtextGeneratorFileSystemAccess get«p.toFirstUpper»Src() {
					return «p»Src;
				}
				
				public void set«p.toFirstUpper»Src(String path) {
					this.«p»Src = new XtextGeneratorFileSystemAccess(path, false);
				}
				
				@Override
				public IXtextGeneratorFileSystemAccess get«p.toFirstUpper»SrcGen() {
					return «p»SrcGen;
				}
				
				public void set«p.toFirstUpper»SrcGen(String path) {
					this.«p»SrcGen = new XtextGeneratorFileSystemAccess(path, true);
				}
				
				@Override
				public IXtextGeneratorFileSystemAccess get«p.toFirstUpper»WebApp() {
					return «p»WebApp;
				}
				
				public void set«p.toFirstUpper»WebApp(String path) {
					this.«p»WebApp = new XtextGeneratorFileSystemAccess(path, true);
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
		}
	'''
	
}