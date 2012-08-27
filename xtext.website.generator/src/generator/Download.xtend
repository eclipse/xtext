package generator

class Download extends AbstractWebsite {

	override path() {
		"download.html"
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
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-4.2-Xtext-2.3.1-macosx-cocoa-x86_64.tar.gz&r=1" 
								    	class="btn btn-primary btn-large" style="width: 45%;">OS X 64 Bit</a>&nbsp;
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-4.2-Xtext-2.3.1-macosx-cocoa.tar.gz&r=1" 
								    	class="btn btn-primary btn-large"
								    	style="width:20%;">32 Bit</a></td>
								    </tr>
								    <tr>
								    	<td style="text-align: center; white-space: nowrap;">
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-4.2-Xtext-2.3.1-linux-gtk-x86_64.tar.gz&r=1" 
								    	class="btn btn-primary btn-large"
								    	style="width: 45%;">Linux 64 Bit</a>&nbsp;
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-4.2-Xtext-2.3.1-linux-gtk.tar.gz&r=1" 
								    	class="btn btn-primary btn-large"
								    	style="width:20%;">32 Bit</a></td>
								    </tr>
								    <tr>
								    	<td style="text-align: center; white-space: nowrap;">
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-4.2-Xtext-2.3.1-win32-x86_64.zip&r=1"
								    	class="btn btn-primary btn-large"
								    	style="width: 45%;">Windows 64 Bit</a>&nbsp;
								    	<a href="http://www.eclipse.org/modeling/download.php?file=/modeling/tmf/xtext/downloads/distros/eclipse-SDK-4.2-Xtext-2.3.1-win32.zip&r=1" 
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
				      <strong>  Eclipse Xtext is implemented in Java, so you must have a 
				        <a href="http://www.oracle.com/technetwork/java/index.html">Java
				        Runtime Environment</a> installed in order to proceed.
				      </strong>
				    </p>
				    <p>
				      There are two easy ways to get Xtext up and running. A pre-configured Eclipse distribution is available
				      which has already all the necessary plug-ins installed. Alternatively, you can install Xtext into your
				      existing Eclipse by means of the Eclipse update mechanism.
				    </p>
				    <!--  section -->
				    <section id="InstallDistro" style="padding-top: 68px; margin-top: -68px;">
				    <h2>  Install Pre-Configured Eclipse With Xtext
				    </h2>
				      <ol>
				        <li>Download the distribution from above that matches your OS.</li>
				        <li>Unzip the archive into the directory of your choice. 
								<strong>  Windows Users should choose a directory close to the root since the zip contains a 
								deeply nested folder structure. The maximum path length on windows may not exceed 256 characters.
								</strong>
				        </li>
				        <li>Launch Eclipse and select the workspace location. A workspace location is the directory for your user data
								    and project files.
				        </li>
				      </ol>
				    </section>
				    <!--  section -->
				    <section style="padding-top: 68px; margin-top: -68px;">
				    <h2>  Install Xtext From Update Site
				    </h2>
				    <p>
				      If you have an Eclipse running : 
				    </p>
				      <ul>
				        <li>  
								    Choose 
								<strong>  Help -&gt; Install New Software...
								</strong> from the menu bar and
								<strong>  Add...
								</strong> Insert one of the update site URLs from above.
								    This site aggregates all the necessary and optional components and dependencies of Xtext.
				        </li>
				        <li>Select the <i>Xtext SDK</i> from the category <i>Xtext {version}</i> and 
				        complete the wizard by clicking the <i>Next</i> button until you can click <i>Finish</i>.
				        </li>
				        <li>  
								    After a quick download and a restart of Eclipse, Xtext is ready to use.
				        </li>
				      </ul>
				    <p>
				      Note: Xtext relies on the Antlr generator library. Unfortunately, we cannot provide this library on 
				      the official Eclipse release update sites. Instead, Xtext will try to download it on demand. To avoid 
				      this, you can manually install the feature 
				      <strong>  Xtext Antlr-2.0.0
				      </strong> from the itemis update site
				      (
				      <a href="http://download.itemis.de/updates/">http://download.itemis.de/updates/</a>). 
				      The general installation procedures are not affected by this issue.
				    </p>
				    </section>
				  </div>
				<div class="span1">&nbsp;</div>
				</div>
				<div class="container">
					<h2>FAQs</h2>
					<hr />
					<div class="span1">&nbsp;</div>
					<div class="span9" id="faq">
						<div class="accordion" id="accordion2">
						    «faqEntry('What is an update site?','''
								Eclipse comes with a built-in update manager, that understands so called update sites.
								When in Eclipse open the <i>"Help"</i> menu and click on <i>"Install new Software..."</i>.
						    ''')»
						    «faqEntry('What is the license of Xtext?','''
								<p>Xtext is freely available under the <a href="http://www.eclipse.org/legal/epl-v10.html">Eclipse Public License</a>.</p>
								<p>
									The license allows to use Xtext for development and even for developing and selling commercial products based on Xtext.
								</p>
						    ''')»
						    «faqEntry('If Xtext is open-source, how can I get professional support?','''
								  <p>Software systems built from open source components requires manpower that understands the internal dependencies of 
								  these components and can quickly and efficiently eliminate problems, should an error occur. </p>
								  <p><b>itemis</b> is the leading consulting company for Eclipse-based development tools and is the main
								  supporter for the Xtext project. Xtext experts are available for consulting.</p>
								  See <a target="_blank" href="http://xtext.itemis.com">xtext.itemis.com</a> for more details.
						    ''')»
						    «faqEntry('Can I download the update site as a zip?','''
								  <p>If you instead prefer a downloadable updatesite or an SDK zip, 
								  please have a look at the following site : <a href="http://www.eclipse.org/modeling/tmf/downloads/">http://www.eclipse.org/modeling/tmf/downloads/</a></p>
						    ''')»
						</div>
			  		</div>
					<div class="span1">&nbsp;</div>
				</div>
			</div>
		</div>
	'''
	
	def faqEntry(String question, CharSequence answer) '''
		«val key = question.replaceAll('\\W','_')»
		<div class="accordion-group">
		  <div class="accordion-heading">
			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#«key»">
			  «question»
			</a>
		  </div>
		  <div id="«key»" class="accordion-body collapse">
			<div class="accordion-inner">
			  «answer»
			</div>
		  </div>
		</div>
	'''
	
}