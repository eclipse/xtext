package generator.xtend

class Download extends AbstractXtendWebsite {

	override path() {
		"download.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
	def String getLink(String platform) {
		'http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/kepler/R/eclipse-dsl-kepler-'+platform+'.tar.gz&r=1'
	}
	
	public static val OSX_64 = 'macosx-cocoa-x86_64';
	public static val OSX_32 = 'macosx-cocoa';
	public static val LINUX_64 = 'linux-gtk-x86_64';
	public static val LINUX_32 = 'linux-gtk';
	public static val WIN_64 = 'win32-x86_64';
	public static val WIN_32 = 'win32';
	
	override contents() '''
		«headline('Download')»
		<div id="page">
			<div class="inner">
				<div class="container clearfix">
					<h2>Download Options (Current Version is <a href="releasenotes_2_4.html">2.4.2</a>)</h2>
					<hr>
					<!--table one starts-->
					<div class="span1">&nbsp;</div>
				    <div class="span4">
						<div class="pricing">
						    <table>
								<tfoot>
								    <tr>
										<td></td>
								    </tr>
								</tfoot>
								<tbody>
							    <tr>
									<td class="focus">Update Sites <span>Use Update Manager in Eclipse</span></td>
							    </tr>
							    <tr>
							    	<td style="text-align: center;">
							    	<a  
							    	rel="popover" 
							    	data-content="This is an Eclipse update site URL, which you need to paste into the update manager within Eclipse!" 
							    	data-original-title="Right-click and 'Copy Link'"
							    	href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/" 
							    	class="has-popover btn btn-primary btn-large"
							    	style="width: 70%;">Latest Release</a></td>
							    </tr>
							    <tr>
									<td style="text-align: center;">
									<a
									  rel="popover" 
							    	data-content="This is an Eclipse update site URL, which you need to paste into the update manager within Eclipse!" 
							    	data-original-title="Right-click and 'Copy Link'" 
									  href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/milestones/" 
							    	class="has-popover btn btn-primary btn-large"
							    	style="width: 70%;">Latest Milestone</a></td>
							    </tr>
							    <tr>
									<td style="text-align: center;">
									<a
										rel="popover" 
							    	data-content="This is an Eclipse update site URL, which you need to paste into the update manager within Eclipse!" 
							    	data-original-title="Right-click and 'Copy Link'" 
										href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/latest/" 
							    	class="has-popover btn btn-primary btn-large"
							    	style="width: 70%;">Bleeding Edge!</a></td>
							    </tr>
							</tbody>
						    </table>
						</div>
				    </div>
				    <div class="span1">&nbsp;</div>
				    <div class="span4">
						<div class="pricing">
						    <table>
								<tfoot>
								    <tr>
										<td></td>
								    </tr>
								</tfoot>
								<tbody>
								    <tr>
										<td class="focus">Full Eclipse <span>Just Download and Unzip</span></td>
								    </tr>
								    <tr>
								    	<td style="text-align: center; white-space: nowrap;">
								    	<a href="«getLink(OSX_64)»" 
								    	class="btn btn-primary btn-large" style="width: 45%;">OS X 64 Bit</a>&nbsp;
								    	<a href="«getLink(OSX_32)»" 
								    	class="btn btn-primary btn-large"
								    	style="width:20%;">32 Bit</a></td>
								    </tr>
								    <tr>
								    	<td style="text-align: center; white-space: nowrap;">
								    	<a href="«getLink(LINUX_64)»" 
								    	class="btn btn-primary btn-large"
								    	style="width: 45%;">Linux 64 Bit</a>&nbsp;
								    	<a href="«getLink(LINUX_32)»" 
								    	class="btn btn-primary btn-large"
								    	style="width:20%;">32 Bit</a></td>
								    </tr>
								    <tr>
								    	<td style="text-align: center; white-space: nowrap;">
								    	<a href="«getLink(WIN_64)»"
								    	class="btn btn-primary btn-large"
								    	style="width: 45%;">Windows 64 Bit</a>&nbsp;
								    	<a href="«getLink(WIN_32)»" 
								    	class="btn btn-primary btn-large"
								    	style="width:20%;">32 Bit</a></td>
								    </tr>
								</tbody>
						    </table>
						</div>
				    </div>
					<div class="span1">&nbsp;</div>
				</div>
				    <div class="container">
								<div class="container">
				<h2>Installation Instructions</h2>
				<hr>
				<div class="span1">&nbsp;</div>
				  <div class="span9">
				    <p>
				      The Xtend IDE integration requires Eclipse 3.5 or higher and a Java SDK 5 or higher. Use one of the udpate sites from above to install the full SDK
				      into your running Eclipse. If you do not yet have an Eclipse on your machine, you can download one of the pre-packaged distributions on the right.
				    </p>
				    <p>
				      There are various options to compile Xtend sources. The most used way is using <a href="#MavenSupport">the Maven plug-in</a>.
				    </p>
				    <!--  section -->
				    <section id="Update Site" style="padding-top: 68px; margin-top: -68px;">
							<h2 style="padding-top: 15px;">Install From Update Site</h2>
							<p>
								If you already have an Eclipse running you should install the <i>"Xtend SDK"</i>-Feature from one of the update sites listed above. To do so
								within Eclipse choose <i>Help -&gt; Install New Software...</i>. In the upcoming dialog you should paste one of the update site URLS into the 
								field named <i>Work with</i>. Now search for the feature <e>Xtend SDK</e>, select it and click <i>Next</i> and on the next page <i>Finish</i>.
							</p>
							<img src="images/screenshot-installation.png" class="image_between_p"/>
							<p>
								Now the features are being downloaded and installed. Eclipse will ask you for a restart when downloading and installation is done.
							</p>
					</section>
				    <section id="MavenSupport" style="padding-top: 68px; margin-top: -68px;">
							<h2 style="padding-top: 15px;">Maven Plug-In</h2>
							<p>
								The <a href="#library">runtime library</a> as well as a plug-in to run the compiler in a Maven build can be be obtained from
								the Maven Central Repository: <a href="http://repo.maven.apache.org/maven2">http://repo.maven.apache.org/maven2</a>.
							</p>
							<p>
								You can create a readily configured project using 
								<pre class="prettyprint lang-xml linenums">
		mvn archetype:generate -DarchetypeGroupId=org.eclipse.xtend -DarchetypeArtifactId=xtend-archetype
								</pre>
							</p>
							<p>
								If you already have a project with a pom.xml, you need to add the plugin configuration:
								</p>
								<pre class="prettyprint lang-xml linenums">
		&lt;plugin&gt;
		  &lt;groupId&gt;org.eclipse.xtend&lt;/groupId&gt;
		  &lt;artifactId&gt;xtend-maven-plugin&lt;/artifactId&gt;
		  &lt;version&gt;2.4.2&lt;/version&gt;
		  &lt;executions&gt;
		    &lt;execution&gt;
		      &lt;goals&gt;
		        &lt;goal&gt;compile&lt;/goal&gt;
		        &lt;!-- &lt;goal&gt;testCompile&lt;/goal&gt; --&gt;
		      &lt;/goals&gt;
		      &lt;!-- optionally you can configure a different target folder --&gt;
		      &lt;!--
		      &lt;configuration&gt;
		        &lt;outputDirectory&gt;xtend-gen&lt;/outputDirectory&gt;
		      &lt;/configuration&gt;
		      --&gt;
		    &lt;/execution&gt;
		  &lt;/executions&gt;
		&lt;/plugin&gt;</pre>
								<p>
							</p>
							<p>
								As you see the <strong>outputDirectory</strong> can be specified to match the default of the Eclipse plug-in (<strong>xtend-gen</strong>). Of course you can also change the configuration
								in Eclipse to match the Maven default (<strong>generated-sources</strong>). To do so right-click on the project and select <strong>Properties</strong> or if you prefer a global setting choose <strong>Eclipse-&gt;Preferences</strong>.
								In the category <strong>Xtend/Compiler</strong> enter the directory name (see screenshot). It is interpreted as a relative path to the parent of the source folder, which includes the to-be-compiled Xtend file.
							</p>
							<p>
								<div class="thumbnail">
									<img src="images/configure-compiler-in-eclipse.png" alt="Configuring the compiler in Eclipse" width="680" height="330">
								</div>
							</p>
							</section>
							<section>
							<h2 style="padding-top: 15px;">Getting the runtime library via Maven</h2>
							<p>
								The <a href="api/2.4.0/index.html">runtime library</a> is available from Maven Central, too: <a href="http://repo.maven.apache.org/maven2">http://repo.maven.apache.org/maven2</a>.
							</p>
							The XML for the dependency is :
							</p>
							<p>
								</p>
								<pre class="prettyprint lang-xml linenums">
		&lt;dependency&gt;
		  &lt;groupId&gt;org.eclipse.xtend&lt;/groupId&gt;
		  &lt;artifactId&gt;org.eclipse.xtend.lib&lt;/artifactId&gt;
		  &lt;version&gt;2.4.2&lt;/version&gt;
		&lt;/dependency&gt;</pre>
								<p>
							</p>
							<p>
							</section>
							<section id="Hello World" style="padding-top: 68px; margin-top: -68px;">
							<h2 style="padding-top: 15px;">Getting Started</h2>
							<p>
								<img src="images/java-perspective.png" style="float : right; margin-left:10px;"/>
								When you've started Eclipse for the first time, you should see an empty workspace. Switch to the 'Java perspective'
								if you are not already in it. Xtend integrates with Java, so you need to create a Java project to get started. In the menu choose 
								<i>File -> New -> Java Project</i>. In the upcoming dialog choose any project name you want (e.g. <i>my.project</i>).
								After clicking <i>Finish</i> Eclipse will create a fresh project with an empty source folder named <i>'/src'</i>. 
							</p>
							<h3>A first class</h3>
							<img src="images/menu new xtend class.png" class="image_between_p"/>
							<p>
								To create your first Xtend class select the source folder and press the right mouse button. You should find the entry 
								<i>Xtend class</i> in the category <i>New &gt;</i>. If you don't see it you might not be in the Java perspective or you need to reset the perspective. To do so right click
								on the perspective icon on the top right and choose <i>reset</i>.
							</p>
							<img src="images/new class wizard.png" class="image_between_p"/>
							<p>
								In the dialog you should give the class a name, for instance <i>HelloWorld</i>, and put it into some package (we chose <i>my.namespace</i>). Click <i>Finish</i> and
								an empty class will be created for you.
							</p>
							<h3>The missing lib</h3>
							<img src="images/xtend lib missing error.png"  class="image_between_p"/>
							<p>
								The newly created class will have an error marker, saying that you need to put the library on the classpath. There is a "quickfix" which does that for you.
								Put the cursor on the marked location and press <i>CTRL+1</i> (or CMD+1 on a Mac) and select the option "Add Xtend libs to the classpath".
							</p>
							<p>
								The library is also available from maven (see below) or as an OSGi bundle from the p2 update site above.
							</p>
							<h3>Have fun!</h3>
							<p>
								Now you are ready to code. Within the class body (between the curly braces) type <i>main<i> and press <i>CTRL+space</i>. An empty main method will be generated for you.
							</p>
							<p>
								Now type in <code class="prettyprint lang-xtend">println('Hello World')</code>, save and run the application. To do so use the green arrow and choose <i>Run As -&gt; Java Application</i>.
							</p>
							<img src="images/run as java application.png" class="image_between_p"/>
							<p>
								<a href="documentation.html#GettingStarted">Click here for the next steps and more examples.</a> 
							</p>
					</section>
				  </div>
				<div class="span1">&nbsp;</div>
				</div>
			</div>
		</div>
	'''
	
}