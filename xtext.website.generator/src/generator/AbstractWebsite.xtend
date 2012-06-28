package generator

import java.io.File
import com.google.common.base.Charsets

import static extension com.google.common.io.CharStreams.*
import static extension com.google.common.io.Files.*
import org.eclipse.xtext.xdoc.XdocStandaloneSetup

abstract class AbstractWebsite implements Resource {
	
	protected new() {
		val injector = standaloneSetup.createInjectorAndDoEMFRegistration
		injector.injectMembers(this)
	}
	
	def XdocStandaloneSetup getStandaloneSetup() {
		new XdocStandaloneSetup()
	}
	
	override generateTo(File targetDir) {
		val file = new File(targetDir, path)
		if (file.exists) {
			print("overwriting ")
		}
		website.write(file.newWriterSupplier(Charsets::UTF_8))
		println("generated '"+file+"'")
	}
	
	/*
	 * the path relative the website root
	 */
	def String path()
	
	def CharSequence contents()
	
	def website() '''
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="utf-8">
			<title>«websiteTitle»</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<meta name="description"
				content="«websiteDescription»">
			<meta name="author" content="Sven Efftinge">
			«stylesheets»
			«javaScriptDocumentStart»
		</head>
		<body>
			«navBar»
		«contents»
			«quickLinksAndTweets»
			«javaScriptAtTheEnd»
		</body>
		</html>
	'''
	
	def websiteDescription() { 
		'The website of Eclipse Xtext, an open-source framework for development of programming langauges and domain-specific languages'
	}

	def websiteTitle() {
		'Xtext - Language Development Made Easy!'
	}
	
	def javaScriptDocumentStart() '''
		<script src="js/twitter.js" type="text/javascript"></script>
		<script src="js/jquery-1.7.1.min.js"></script>
		<script src="js/jquery.prettyPhoto.js" type="text/javascript"></script>
			<script type="text/javascript">
		     $(document).ready(function() {
						«IF isPrettyPrint»
										 prettyPrint();
						«ENDIF»
		         
						 $('a[data-rel]').each(function() {
		             $(this).attr('rel', $(this).data('rel'));
		         });
		        
						 $("a[rel^='prettyPhoto']").prettyPhoto({
		             animation_speed: 'fast',
		             slideshow: 5000,
		             autoplay_slideshow: false,
		             opacity: 0.80,
		             show_title: true,
		             theme: 'ligh_square',
		             overlay_gallery: false,
		             social_tools: false
		       
		         });
		         
						«IF isOutline»
											$('#nav-outline > li > a').live('click', function() {        
												$(this).parent().find('ul').slideToggle();      
											});
						«ENDIF»
		         
						«IF isPopover()»
											$('.has-popover').popover();
						«ENDIF»
			 	     
			 	     getTwitters('tweet', { 
				        id: '«twitterID»', 
				        count: 5,
				        includeRT: true,
				        enableLinks: true, 
				        clearContents: true,
				        template : '"%text%" - %time% by <a href="http://twitter.com/%user_screen_name%/statuses/%id_str%/">@%user_screen_name%</a><br/><br/>'
				     });
		         
		         var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
			 	     po.src = 'https://apis.google.com/js/plusone.js';
			 	     var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
		     });
			</script>
		<script type="text/javascript">
			var _gaq = _gaq || [];	
		  	_gaq.push([ '_setAccount', '«analyticsAccount»' ]);
			_gaq.push([ '_trackPageview' ]);
			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl'
						: 'http://www')
						+ '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();
		</script>
	'''
	def analyticsAccount() { 'UA-2429174-3' }

	def twitterID() { 'xtext' }

	def protected boolean isPrettyPrint() { false }
	def protected boolean isOutline() { true }
	def protected boolean isPopover() { true }

	def navBar() '''
		<!-- Navbar -->
		<div class="navbar navbar-fixed-top"
			style="border-bottom: 1px solid #000;">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="index.html"></a>
					<div class="nav-collapse collapse" style="height: 0px;">
						<ul class="nav">
							<li «IF path == 'download.html'»class="active"«ENDIF»><a href="download.html">Download</a></li>
«««							<li «IF path == 'examples.html'»class="active"«ENDIF»><a href="examples.html">Examples</a></li>
							<li «IF path == 'documentation.html'»class="active"«ENDIF»><a href="documentation.html">Documentation</a></li>
							<li «IF path == 'community.html'»class="active"«ENDIF»><a href="community.html">Community</a></li>
							<li><a href="http://www.eclipse.org">Eclipse.org</a></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
			        <div class="btn-group pull-right">
			          <g:plusone href="«plusoneURL»"></g:plusone>
			        </div>
		
				</div>
			</div>
		</div>
		<!-- Navbar End -->
	'''
	def plusoneURL() { 'http://www.xtext.org' }


	
	def quickLinksAndTweets() '''
		<div id="extra">
			<div class="inner">
				<div class="container">
					<div class="row">
						<div class="span6">
							<h3>Quick Links</h3>
							<ul class="footer-links clearfix">
								<li><a href="http://www.eclipse.org/legal/privacy.php">Privacy Policy</a></li>
								<li><a href="http://www.eclipse.org/legal/termsofuse.php">Terms of Use</a></li>
								<li><a href="http://www.eclipse.org/legal/copyright.php">Copyright Agent</a></li>
								<li><a href="http://www.eclipse.org/legal/">Legal</a></li>
							</ul>
							<ul class="footer-links clearfix">
		      			<li><a href="http://www.eclipse.org">Eclipse Home</a></li>
								<li><a href="http://marketplace.eclipse.org/">Market Place</a></li>
								<li><a href="http://live.eclipse.org/">Eclipse Live</a></li>
								<li><a href="http://www.planeteclipse.org/">Eclipse Planet</a></li>
							</ul>
						</div>
						<div class="span6">
							<h3><a href="https://twitter.com/#!/«twitterID»" style="color: white;">«twitterID.toFirstUpper»</a> on Twitter</h3>
							<br />
							<div id="tweet">
								<p>Please wait while my tweets load</p>
								<p>
									<a href="http://twitter.com/rem">If you can't wait - check
										out what I've been twittering</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	'''

	def javaScriptAtTheEnd() '''
		<!-- Le javascript
		    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		
		<script src="js/bootstrap-transition.js"></script>
		<script src="js/bootstrap-alert.js"></script>
		<script src="js/bootstrap-modal.js"></script>
		<script src="js/bootstrap-dropdown.js"></script>
		<script src="js/bootstrap-scrollspy.js"></script>
		<script src="js/bootstrap-tab.js"></script>
		<script src="js/bootstrap-tooltip.js"></script>
		<script src="js/bootstrap-popover.js"></script>
		<script src="js/bootstrap-button.js"></script>
		<script src="js/bootstrap-collapse.js"></script>
		<script src="js/bootstrap-carousel.js"></script>
		<script src="js/bootstrap-typeahead.js"></script>

		«IF prettyPrint»		
			<!-- include pretty-print files -->
			<script type="text/javascript" src="google-code-prettify/prettify.js"></script>
			<script type="text/javascript" src="google-code-prettify/lang-xtend.js"></script>
		«ENDIF»
		
		<!-- Include the plug-in -->
		<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
		<script src="js/custom.js" type="text/javascript"></script>
	'''

	
	
	
	def stylesheets() '''
		<style>
			#header_wrapper {
				padding-top: 10px;
				/* 60px to make the container go all the way to the bottom of the topbar */
			}
			
			code.prettyprint {
		        padding: 0px;
		        background-color: white;
				border: none;
		    }
		</style>
		<!--  styles -->
		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		<!-- Le fav and touch icons -->
		
		<link rel="shortcut icon" href="images/favicon.png">
		
		<link href="css/bootstrap.css" rel="stylesheet" type='text/css'>
		<link href="css/bootstrap-responsive.css" rel="stylesheet" type='text/css'>
		<link href="css/style.css" rel="stylesheet" type='text/css'>
		<link href="css/shield-responsive.css" rel="stylesheet" type='text/css'>
		<link href='css/fonts.css' rel='stylesheet' type='text/css'>
		<link href="css/prettyPhoto.css" rel="stylesheet" media="screen" type='text/css'>
		<link href="google-code-prettify/prettify.css" type="text/css" rel="stylesheet"/>
		<!--[if lt IE 9]>
		<link href="css/iebugs.css" rel="stylesheet" type='text/css'>
		<![endif]-->
	'''

	def headline(String title) '''
		<div id="header_wrapper" class="container" >
			<div class="inner">
				<div class="container">
					<div class="page-heading"><h1>«title»</h1></div>
				</div>
			</div>
		</div>
	'''
}