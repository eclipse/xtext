package generator.xtend

import generator.AbstractWebsite

abstract class AbstractXtendWebsite extends AbstractWebsite {
	
	override websiteDescription() {
		'Xtend is a statically typed programming language sitting on top of Java.'
	}
	
	override websiteTitle() {
		'Xtend - Modernized Java'
	}
	
	override analyticsAccount() {
		'UA-2429174-4'
	}
	
	override headline(String title) {
		''
	}
	
	override plusoneURL() { 
		'http://www.xtend-lang.org' 
	}
	
	override topLevelMenu() {
		newArrayList(
			'news.html' -> 'News',
			'releasenotes.html' -> 'Release Notes',
			'download.html' -> 'Download',
			'documentation.html' -> 'Documentation',
			'community.html' -> 'Community',
			'http://xtext.org' -> 'Xtext',
			'http://www.eclipse.org' -> 'Eclipse.org'
		)
	}
	
	override quickLinksAndTweets() '''
		<div id="extra">
			<div class="inner">
				<div class="container">
					<div class="row">
						<div class="span6">
							<h3 style="padding-top: 0px; margin-top: 0px;">Quick Links</h3>
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
							<h3 style="padding-top: 0px; margin-top: 0px;"><a href="https://twitter.com/xtendlang" style="color : white;">@Xtendlang</a> on Twitter</h3>
							<a class="twitter-timeline" href="https://twitter.com/xtendlang" data-widget-id="346624176666333185"
							data-chrome="noheader nofooter transparent"
							data-theme="dark">Tweets by @Xtendlang</a>
							<script>
							!function(d,s,id) { 
								var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';
								if(!d.getElementById(id)) { 
								  js=d.createElement(s);
								  js.id=id;
								  js.src=p+"://platform.twitter.com/widgets.js";
								  fjs.parentNode.insertBefore(js,fjs);
								}
							}(document,"script","twitter-wjs");</script>
						</div>
					</div>
				</div>
			</div>
		</div>
	'''
	
}