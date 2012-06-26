package generator.xtend

class Download extends AbstractXtendWebsite {

	override path() {
		"download.html"
	}
	
	override protected isPrettyPrint() {
		true
	}
	
	override contents() '''
		«headline('Download')»
		<div id="page">
			<div class="inner">
				<div class="container clearfix">
					<h2>Download Options</h2>
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
										href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/stable/" 
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
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-3.7.1-Xtext-2.2.1-macosx-cocoa-x86_64.tar.gz" 
								    	class="btn btn-primary btn-large" style="width: 45%;">OS X 64 Bit</a>&nbsp;<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-3.7.1-Xtext-2.2.1-macosx-cocoa.tar.gz" 
								    	class="btn btn-primary btn-large"
								    	style="width:20%;">32 Bit</a></td>
								    </tr>
								    <tr>
								    	<td style="text-align: center; white-space: nowrap;">
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-3.7.1-Xtext-2.2.1-linux-gtk-x86_64.tar.gz" 
								    	class="btn btn-primary btn-large"
								    	style="width: 45%;">Linux 64 Bit</a>&nbsp;<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-3.7.1-Xtext-2.2.1-linux-gtk.tar.gz" 
								    	class="btn btn-primary btn-large"
								    	style="width:20%;">32 Bit</a></td>
								    </tr>
								    <tr>
								    	<td style="text-align: center; white-space: nowrap;">
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-3.7.1-Xtext-2.2.1-win32-x86_64.zip" 
								    	class="btn btn-primary btn-large"
								    	style="width: 45%;">Windows 64 Bit</a>&nbsp;<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-3.7.1-Xtext-2.2.1-linux-gtk.tar.gz" 
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
				      Xtend requires Eclipse 3.5 or higher and a Java SDK 5 or higher. Use one of the udpate sites from above to install the full SDK
				      into your running Eclipse. If you do not yet have an Eclipse on your machine, you can download one of the pre-packaged distributions on the right.
				    </p>
				    <p>
				      Standalone compilation is supported as well, the simplest way to do that is using the Maven plug-in.
				    </p>
				    <!--  section -->
				    <section id="MavenSupport" style="padding-top: 68px; margin-top: -68px;">
							<h2 style="padding-top: 15px;">Maven Plug-In</h2>
							<p>
								The <a href="#library">runtime library</a> as well as a plug-in to run the compiler in a Maven build can be be obtained from
								the following Maven repository: <a href="http://build.eclipse.org/common/xtend/maven/">http://build.eclipse.org/common/xtend/maven/</a>.
							</p>
							<p>
								Here is the XML for the repository:
								</p>
								<pre class="prettyprint lang-xml linenums">
&lt;repositories&gt;
  &lt;repository&gt;
    &lt;id&gt;xtend&lt;/id&gt;
    &lt;url&gt;http://build.eclipse.org/common/xtend/maven/&lt;/url&gt;
  &lt;/repository&gt;
&lt;/repositories&gt;
&lt;pluginRepositories&gt;
  &lt;pluginRepository&gt;
    &lt;id&gt;xtend&lt;/id&gt;
    &lt;url&gt;http://build.eclipse.org/common/xtend/maven/&lt;/url&gt;
  &lt;/pluginRepository&gt;
&lt;/pluginRepositories&gt;</pre>
								<p>
							</p>
							<p>
								And this is the XML for the plug-in:
							</p>
							<p>
								</p>
								<pre class="prettyprint lang-xml linenums">
&lt;plugin&gt;
  &lt;groupId&gt;org.eclipse.xtend&lt;/groupId&gt;
  &lt;artifactId&gt;xtend-maven-plugin&lt;/artifactId&gt;
  &lt;version&gt;2.3.0&lt;/version&gt;
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
								The <a href="api/2.3.0/index.html">runtime library</a> is contained in the same Maven repository as the plug-in : <a href="http://build.eclipse.org/common/xtend/maven/">http://build.eclipse.org/common/xtend/maven/</a>.
							</p>
							The XML for the dependency is :
							</p>
							<p>
								</p>
								<pre class="prettyprint lang-xml linenums">
&lt;dependency&gt;
  &lt;groupId&gt;org.eclipse.xtend&lt;/groupId&gt;
  &lt;artifactId&gt;org.eclipse.xtend.lib&lt;/artifactId&gt;
  &lt;version&gt;2.3.0&lt;/version&gt;
&lt;/dependency&gt;</pre>
								<p>
							</p>
							<p>
							</section>
				  </div>
				<div class="span1">&nbsp;</div>
				</div>
			</div>
		</div>
	'''
	
}