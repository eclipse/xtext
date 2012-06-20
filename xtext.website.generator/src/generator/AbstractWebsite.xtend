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
			<title>Xtext - Language Development Made Easy!</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<meta name="description"
				content="The website of Eclipse Xtext, an open-source framework for development of programming langauges and domain-specific languages">
			<meta name="author" content="Sven Efftinge">
			«stylesheets»
			«javaScriptDocumentStart»
		</head>
		<body onload="prettyPrint()">
			«navBar»
			«contents»
			«quickLinksAndTweets»
			«javaScriptAtTheEnd»
		</body>
		</html>
	'''
	
	def javaScriptDocumentStart() '''
		<script
			src="js/twitter.js"
			type="text/javascript">
		        </script>
		<script type="text/javascript">
		            getTwitters('tweet', { 
		                id: 'xtext', 
		                count: 5,
		                includeRT: true,
		                enableLinks: true, 
		                clearContents: true,
		                template: '"%text%" <a href="http://twitter.com/%user_screen_name%/statuses/%id_str%/">%time%</a><br/><br/>'
		            });
		        </script>
		
		
		<script src="js/jquery-1.7.1.min.js"></script>
		<link rel="stylesheet" media="screen" href="css/prettyPhoto.css" />
		<script src="js/jquery.prettyPhoto.js" type="text/javascript"></script>
		<script type="text/javascript">
		            $(document).ready(function() {
		           
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
		//                     'pp_default', /* light_rounded / dark_rounded / light_square / dark_square / facebook */
		                    overlay_gallery: false,
		                    social_tools: false
		              
		                });
		            });
		            
		        $(function() {      
		    	$('#outline > li > a').live('click', function() {        
		    		$(this).parent().find('ul').slideToggle();      
		    	});    
		        });
		        </script>
		        
		<link href="google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="google-code-prettify/prettify.js"></script>
		<script type="text/javascript" src="google-code-prettify/lang-xtend.js"></script>
		<script type="text/javascript">
			var _gaq = _gaq || [];	
		  	_gaq.push([ '_setAccount', 'UA-2429174-4' ]);
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
							<li «IF path == 'examples.html'»class="active"«ENDIF»><a href="examples.html">Examples</a></li>
							<li «IF path == 'documentation.html'»class="active"«ENDIF»><a href="documentation.html">Documentation</a></li>
							<li «IF path == 'community.html'»class="active"«ENDIF»><a href="community.html">Community</a></li>
							<li><a href="http://www.eclipse.org">Eclipse.org</a></li>
						</ul>
		
					</div>
					<!--/.nav-collapse -->
		
				</div>
			</div>
		</div>
		<!-- Navbar End -->
	'''

	
	def quickLinksAndTweets() '''
		<div id="extra">

			<div class="inner">
		
				<div class="container">
		
					<div class="row">
		
						<div class="span6">
		
							<h3>Quick Links</h3>
		
		
							<ul class="footer-links clearfix">
								<li><a href="#">Support</a></li>
								<li><a href="#">License</a></li>
								<li><a href="#">Terms of Use</a></li>
								<li><a href="#">Privacy Policy</a></li>
							</ul>
							<ul class="footer-links clearfix">
								<li><a href="http://www.eclipse.org">Eclipse.org</a></li>
								<li><a href="http://marketplace.eclipse.org/">Eclipse Market Place</a></li>
								<li><a href="http://live.eclipse.org/">Eclipse Live</a></li>
								<li><a href="http://www.planeteclipse.org/">Eclipse Planet</a></li>
							</ul>
		
						</div>
		
		
						<div class="span6">
		
							<h3><a href="https://twitter.com/#!/xtext" style="color: white;">@Xtext</a> Tweets</h3>
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
		
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/shield-responsive.css">
		
		<link
			href='http://fonts.googleapis.com/css?family=Vollkorn:400italic,400'
			rel='stylesheet' type='text/css'>
		<link
			href='http://fonts.googleapis.com/css?family=Lato:400,400italic,900italic'
			rel='stylesheet' type='text/css'>
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