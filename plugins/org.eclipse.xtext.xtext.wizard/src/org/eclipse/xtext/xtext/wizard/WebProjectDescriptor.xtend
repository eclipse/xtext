package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import static org.eclipse.xtext.xtext.wizard.ExternalDependency.*
@FinalFieldsConstructor
class WebProjectDescriptor extends ProjectDescriptor {
	
	override getUpstreamProjects() {
		#{config.runtimeProject, config.ideProject}
	}
	
	override getNameQualifier() {
		".web"
	}
	
	def baseWebPackagePath() {
		return config.language.basePackagePath + '/' + "web"
	}
	
	override isEclipsePluginProject() {
		false
	}
	
	override getFiles() {
		val files = newArrayList
		files += super.files
		files += file(Outlet.WEBAPP, "index.html", index)
		files += file(Outlet.WEBAPP, "style.css", style)
		files += file(Outlet.MAIN_JAVA, '''«baseWebPackagePath»/ServerLauncher.xtend''', serverLauncher)
		files += file(Outlet.MAIN_JAVA, '''«baseWebPackagePath»/«config.language.simpleName»XtextServlet.xtend''', servlet)
		files += file(Outlet.MAIN_JAVA, '''«baseWebPackagePath»/«config.language.simpleName»WebModule.xtend''', module)
		files
	}
	
	override getExternalDependencies() {
		val deps = newHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.web.servlet")
		deps += createMavenDependency("org.eclipse.xtend:org.eclipse.xtend.lib:${xtextVersion}")
		deps += createMavenDependency("org.eclipse.xtext:org.eclipse.xtext.web.servlet:${xtextVersion}")
		deps += createMavenDependency("org.webjars:requirejs:2.1.17")
		deps += createMavenDependency("org.webjars:requirejs-text:2.0.10-3")
		deps += createMavenDependency("org.webjars:jquery:2.1.4")
		deps += createMavenDependency("org.eclipse.jetty:jetty-annotations:9.2.11.v20150529") => [maven.scope = Scope.PROVIDED]
		deps += createMavenDependency("org.slf4j:slf4j-log4j12:1.7.12") => [maven.scope = Scope.PROVIDED]
		deps
	}
	
	def index() '''
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
		<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<meta http-equiv="Content-Language" content="en-us">
			<title>Example Web Editor</title>
			<link rel="stylesheet" type="text/css" href="xtext/«config.xtextVersion»/xtext-orion.css"/>
			<link rel="stylesheet" type="text/css" href="style.css" />
			<script src="webjars/requirejs/2.1.17/require.min.js"></script>
			<script type="text/javascript">
				require.config({
					paths: {
						"text": "webjars/requirejs-text/2.0.10-3/text",
						"jquery": "webjars/jquery/2.1.4/jquery.min",
						"xtext/xtext-orion": "xtext/«config.xtextVersion»/xtext-orion"
					}
				});
				require(["xtext/xtext-orion"], function(xtext) {
					xtext.createEditor({syntaxDefinition: "xtext/generated/«config.language.fileExtensions.head»-syntax"});
				});
			</script>
		</head>
		<body>

		<div class="container">
			<div class="header">
				<h1>Example «config.language.simpleName» Web Editor</h1>
			</div>
			<div class="content">
				<div id="xtext-editor" data-editor-xtext-lang="«config.language.fileExtensions.head»"></div>
			</div>
		</div>

					</body>
		</html>
	'''
	
	def style() '''
		body {
			width: 100%;
			height: 100%;
			overflow: hidden;
			font: 16px Helvetica,sans-serif;
		}

		a {
			color: #22a;
			text-decoration: none;
		}

		a:hover {
			text-decoration: underline;
		}

		.container {
			display: block;
			position: absolute;
			top: 0;
			bottom: 0;
			left: 0;
			right: 0;
			margin: 20px;
		}

		.header {
			display: block;
			position: absolute;
			background-color: #e8e8e8;
			top: 0;
			left: 0;
			right: 0;
			height: 60px;
			padding: 10px;
		}

		.content {
			display: block;
			position: absolute;
			top: 90px;
			bottom: 0;
			left: 0;
			width: 640px;
		}

		#xtext-editor {
			display: block;
			position: absolute;
			top: 0;
			bottom: 0;
			left: 0;
			right: 0;
			padding: 4px;
			border: 1px solid #aaa;
		}

		.contentassist .proposal-default {
			color: #888;
		}

		.contentassist .proposal-name {
			color: #000;
			padding-right: 12px;
		}

		/************* Examples for custom icons *************/

		/* For all elements of type Greeting or its subtypes */ 
		/*
			.Greeting-icon {
		  		background-image: url('images/Greeting.gif');
		  	}
		 */

		/* Only in hovers */ 
		/*
			.hover .Greeting-icon {
		  		background-image: url('images/Greeting.gif');
		  	}
		 */
	'''
	
	def serverLauncher() '''
		package «config.language.basePackage».web
		
		import java.net.InetSocketAddress
		import org.eclipse.jetty.annotations.AnnotationConfiguration
		import org.eclipse.jetty.server.Server
		import org.eclipse.jetty.util.log.Slf4jLog
		import org.eclipse.jetty.webapp.MetaInfConfiguration
		import org.eclipse.jetty.webapp.WebAppContext
		import org.eclipse.jetty.webapp.WebInfConfiguration
		import org.eclipse.jetty.webapp.WebXmlConfiguration

		class ServerLauncher {
			def static void main(String[] args) {
				val server = new Server(new InetSocketAddress('localhost', 8080))
				server.handler = new WebAppContext => [
					resourceBase = 'src/main/webapp'
					welcomeFiles = #["index.html"]
					contextPath = "/"
					configurations = #[
						new AnnotationConfiguration,
						new WebXmlConfiguration,
						new WebInfConfiguration,
						new MetaInfConfiguration
					]
					setAttribute(WebInfConfiguration.CONTAINER_JAR_PATTERN, ".*org\\.eclipse\\.xtext\\.web.*|.*«name.replaceAll('\\.','\\\\\\\\.')».*|.*requirejs.*|.*jquery.*")
				]
				val log = new Slf4jLog(ServerLauncher.name)
				try {
					server.start
					log.info('Press enter to stop the server...')
					new Thread[
						val key = System.in.read
						server.stop
						if (key == -1)
							log.warn('The standard input stream is empty.')
					].start
					server.join
				} catch (Exception exception) {
					log.warn(exception.message)
					System.exit(1)
				}
			}
		}
	'''
	
	def servlet() '''
		package «config.language.basePackage».web

		import com.google.inject.Guice
		import com.google.inject.util.Modules
		import java.util.concurrent.ExecutorService
		import java.util.concurrent.Executors
		import javax.servlet.annotation.WebServlet
		import «config.language.basePackage».«config.language.simpleName»RuntimeModule
		import «config.language.basePackage».«config.language.simpleName»StandaloneSetup
		import org.eclipse.xtext.web.servlet.XtextServlet
		import com.google.inject.Module

		@WebServlet(name = "Xtext Services", urlPatterns = "/xtext-service/*")
		class «config.language.simpleName»XtextServlet extends XtextServlet {

			ExecutorService executorService

			override init() {
				super.init()
				executorService = Executors.newCachedThreadPool
				new «config.language.simpleName»StandaloneSetup {
					override createInjector() {
						val runtimeModule = new «config.language.simpleName»RuntimeModule as Module
						val webModule = new «config.language.simpleName»WebModule(executorService)
						return Guice.createInjector(Modules.override(runtimeModule).with(webModule))
					}
				}.createInjectorAndDoEMFRegistration
			}

			override destroy() {
				if (executorService !== null)
					executorService.shutdown()
				executorService = null
				super.destroy()
			}

		}
	'''
	
	def module() '''
		package «config.language.basePackage».web

		import com.google.inject.Binder
		import com.google.inject.name.Names
		import java.util.concurrent.ExecutorService
		import org.eclipse.xtend.lib.annotations.Accessors
		import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
		import org.eclipse.xtext.ide.LexerIdeBindings
		import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
		import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer
		import org.eclipse.xtext.web.server.DefaultWebModule
		import «config.language.simpleName».ide.contentassist.antlr.«config.language.simpleName»Parser
		import «config.language.simpleName».ide.contentassist.antlr.internal.Internal«config.language.simpleName»Lexer

		@Accessors
		@FinalFieldsConstructor
		class «config.language.simpleName»WebModule extends DefaultWebModule {

			val ExecutorService executorService

			def configureExecutorService(Binder binder) {
				binder.bind(ExecutorService).toInstance(executorService)
			}

			def configureContentAssistLexer(Binder binder) {
				binder.bind(Lexer).annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST)).to(Internal«config.language.simpleName»Lexer)
			}

			def Class<? extends IContentAssistParser> bindIContentAssistParser() {
				«config.language.simpleName»Parser
			}

		}
	'''
	
	override buildGradle() {
		super.buildGradle => [
			pluginsSection = '''
				plugins {
					id 'war'
				}
			'''
			additionalContent = '''
				task jettyRun(type:JavaExec) {
					dependsOn(sourceSets.main.runtimeClasspath)
					classpath = sourceSets.main.runtimeClasspath.filter{it.exists()}
					main = "«config.language.basePackage».web.ServerLauncher"
					standardInput = System.in
				}
			'''
		]
	}

	override pom() {
		super.pom => [
			packaging = "war"
			buildSection = '''
				<build>
					<plugins>
						<plugin>
							<groupId>org.eclipse.xtend</groupId>
							<artifactId>xtend-maven-plugin</artifactId>
						</plugin>
						<plugin>
							<artifactId>maven-war-plugin</artifactId>
							<version>2.6</version>
							<configuration>
								<warSourceDirectory>«Outlet.WEBAPP.sourceFolder»</warSourceDirectory>
							</configuration>
						</plugin>
					</plugins>
				</build>
			'''
		]
	}	
}