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
								    	<a href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/" 
								    	class="btn btn-primary btn-large"
								    	style="width: 70%;">Latest Release</a></td>
								    </tr>
								    <tr>
										<td style="text-align: center;">
										<a href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/milestones/" 
								    	class="btn btn-primary btn-large"
								    	style="width: 70%;">Latest Milestone</a></td>
								    </tr>
								    <tr>
										<td style="text-align: center;">
										<a href="http://download.eclipse.org/modeling/tmf/xtext/updates/composite/stable/" 
								    	class="btn btn-primary btn-large"
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
						    «faqEntry('If Xtext is open-source how can I get professional support?','''
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