package generator.xtend

import org.eclipse.xtend.lib.annotations.Accessors

class Community extends AbstractXtendWebsite {

	override path() {
		'community.html'
	}
	
	override contents() '''
	<!--Container-->
	
		<div id="header_wrapper">
	<div class="container"> 
		<div class="flexslider image-slider">
		  <div class="row">
			<div class="span5 team">
			  <a href="https://groups.google.com/group/xtend-lang" class="anchor-in-div" title="The <strong>Xtend Google Group</strong> is the first source for getting answers in case you got stuck. The community is very friendly. Please ask any questions clearly and with sufficient information attached."></a>
			  <div class="row">
			    <div class="span1">
			      <img src="images/icon-discussions-blue.png" alt="image" class="image_left">
			    </div>
			    <div class="span4">
			      <h3 >Discussion Group</h3>
					<p></p>
				</div>
			  </div>
			</div>
			<div class="span5 team">
				 <a href="https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Xtend" class="anchor-in-div" title="Bug reports and enhancement request are tracked at <strong>bugs.eclipse.org</strong>. Please explain the problem and provide a reduced but reproducable eample. Also please explain the concrete use case when requesting enhancements."></a>
				 <div class="row">
				    <div class="span1">
				      <img src="images/icon-bug-blue.png" alt="image" class="image_left">
					</div>		 
				    <div class="span4">
				      <h3 >Found a Bug?</h3>
					</div>
				</div>
			</div>
		  </div>
		  <div class="row">
			<div class="span5 team">
			  <a href="https://twitter.com/#!/xtendlang" class="anchor-in-div" title="If you are on twitter and want to get notified about all things Xtend, you should consider following @xtendlang."></a>
			  <div class="row">
			    <div class="span1">
			      <img src="images/icon-twitter-blue.png" alt="image" class="image_left">
			    </div>
			    <div class="span4">
			      <h3 >Xtend on Twitter</h3>
				</div>
			  </div>
			</div>
			<div class="span5 team">
				 <a href="https://plus.google.com/108502071045096808067/posts" class="anchor-in-div" title="If you don't like Twitter but are on Google+. You might want to add Xtend to one of your circles."></a>
				 <div class="row">
				    <div class="span1">
				      <img src="images/icon-google-blue.png" alt="image" class="image_left">
					</div>		 
				    <div class="span4">
				      <h3 >Xtend on Google+</h3>
					</div>
				</div>
			</div>
		  </div>
		</div>
	</div>
</div>

		<div>
		  <div class="inner">
			«printVideos»
		  </div>
		</div>
		<div>
		  <div class="inner">
			«printArticles»
		  </div>
		</div>
	'''
	
	def printVideos() '''
		<div id="team" class="container clearfix"> 
				<h2>Videos of Presentations</h2>
				<hr>
				<div class="row">
				<div class="span10">
				<table class="table table-striped">
				«articles(
					[
						video = 'Eclipse Xtend: A Language Made for Java Developers (JDK.IO 2014, Kobenhavn)'
						href = 'http://jdk.io/index.php/program/enterprise-java/20-xtend-in-action'
					],[
						video = 'Xtend in Action (Devoxx 2013)'
						href = 'http://parleys.com/play/5297729ae4b039ad2298c9b5/chapter0/about'
					],[
						video = 'Eclipse Xtend: A Language Made for Java Developers (JavaOne 2012, SF)'
						href = 'https://www.youtube.com/watch?v=EzH5MPd13iI'
					],[
						video = 'Eclipse Xtend: A Language Made for Java Developers (Skills Matter 2012, London)'
						href = 'https://skillsmatter.com/skillscasts/2917-xtend-xtest'
					] ).map[ printArticle ].join»
			</table>
			</div>
			<div class="span1">&nbsp;</div>
			</div>
		</div>
	'''
	
	def printArticles() '''
		<div id="team" class="container clearfix"> 
				<h2>Articles and Blog Posts</h2>
				<hr>
				<div class="row">
				<div class="span10">
				<table class="table table-striped">
				«articles(
					[
						blog = 'Android Development has its own Swift'
						href = 'http://blog.futurice.com/android-development-has-its-own-swift'
					],[
						blog = 'Xtend, the Gentle and Functional Java'
						href = 'http://the-dusty-deck.blogspot.de/2014/06/xtend-gentle-and-functional-java.html'
					],[
						blog = 'Android and Xtend'
						href = 'http://www.infoq.com/articles/unusual-ways-to-create-a-mobile-app'
					],[
						blog = '20 Facts about Xtend'
						href = 'http://jnario.org/org/jnario/jnario/documentation/20FactsAboutXtendSpec.html'
					],[
						blog = '5 things that make Xtend a great language'
						href = 'http://sebastianbenz.de/5-Things-that-make-Xtend-a-great-Language-for-Java-developers'
					],[
						blog = 'Building Vaadin UIs with Xtend'
						href = 'http://www.javacodegeeks.com/2013/02/building-vaadin-ui-with-xtend.html'
					],[
						blog = 'Java 8 vs. Xtend'
						href = 'http://blog.efftinge.de/2012/12/java-8-vs-xtend.html'
					],[
						blog = 'A better Java: Scala or Xtend'
						href = 'http://duncan.mac-vicar.com/2012/09/30/a-better-java-scala-or-xtend/'
					],[
						blog = 'RxJava and Xtend'
						href = 'http://mnmlst-dvlpr.blogspot.de/2014/07/rxjava-and-xtend.html'
					],[
						blog = 'The Software Life: First Impressions of Xtend'
						href = 'http://mnmlst-dvlpr.blogspot.de/2014/07/rxjava-and-xtend.html'
					],[
						article = 'Extending Java - Xtend a New Language for Java Developers'
						href = 'http://pragprog.com/magazines/2011-12/extending-java'
						img = 'http://a.pragprog.com/magazines/2011-12/images/iStock_000016728269Small__lz3rv0__.jpg'
					],[
						blog= 'JavaFX & Xtend - A Perfect Match'
						href= 'http://tomsondev.bestsolution.at/2012/04/11/javafx-xtend-a-perfect-match/'
					],[
						blog= 'JavaFX & Xtend - A Sensational Perfect Match'
						href= 'http://tomsondev.bestsolution.at/2012/04/11/javafx-xtend-a-sensational-perfect-match/'
					],[
						blog= 'JavaFX & Xtend - An Ongoing Love'
						href= 'http://tomsondev.bestsolution.at/2012/05/29/javafx-xtend-an-ongoing-love/'
					],[
						blog= 'Xtend, JavaFX-Properties and Operator Overloading'
						href= 'http://tomsondev.bestsolution.at/2012/06/19/xtend-javafx-properties-and-operator-overloading/'
					],[
						blog= 'Building SWT User Interfaces with Xtend'
						href= 'http://blog.moritz.eysholdt.de/2011/12/building-swt-user-interfaces-with-xtend.html'
					],[
						blog= 'Vert.x & Xtend'
						href= 'http://blog.efftinge.de/2012/06/vertx-and-xtend.html'
					],[
						blog= 'Distance / Time = Speed - A Post on Operator Overloading in Xtend'
						href= 'http://blog.efftinge.de/2012/05/distance-time-speed.html'
					],[
						blog= 'Xtend Example Screencasts'
						href= 'http://blog.efftinge.de/2012/04/xtend-examples-used-at-eclipsecon-2012.html'
					],[
						blog= 'Working With Distances using Xtend (Operator Overloading Applied)'
						href= 'http://blog.efftinge.de/2012/04/xtend-example-working-with-distances.html'
					],[
						blog= 'I Like Free Beer (99 Bottles in Xtend)'
						href= 'http://blog.efftinge.de/2012/01/i-like-free-beer.html'
					],[
						blog= 'Groovy, Scala, Java, Xtend - A Stupid Comparism'
						href= 'http://blog.efftinge.de/2011/12/groovy-scala-java-xtend-stupid.html'
					],[
						blog= 'Groovy, Scala, Java, Xtend - An UPDATED Stupid Comparism'
						href= 'http://blog.efftinge.de/2011/12/groovy-scala-java-xtend-updated-stupid.html'
					],[
						blog= 'Writing Android Apps with Xtend'
						href= 'http://blog.efftinge.de/2011/12/writing-android-uis-with-xtend.html'
					],[
						blog= "What's so special about Xtend's extension methods"
						href= 'http://blog.efftinge.de/2011/11/whats-so-special-about-xtends-extension.html'
					],[
						blog= 'Xtend - Type-safe Groovy-style Builder APIs'
						href= 'http://blog.efftinge.de/2011/10/xtend-21-type-safe-groovy-style-builder.html'
					],[
						article= 'Xtend - eine Sprache für Java Entwickler (German)'
						href= 'http://it-republik.de/jaxenter/artikel/Codegenerierung-mit-Eclipse-Xtend-4186.html'
					]
				).map[ printArticle ].join»
			</table>
			</div>
			<div class="span1">&nbsp;</div>
			</div>
		</div>
	'''
	
	def printArticle(Article it) '''
		<tr><td>«kind»</td><td><h2><a href="«href»">«title»</a></h2></td></tr>
	'''
	
	def articles((Article)=>void ... articles) {
		articles.map[ f | new Article => [ f.apply(it) ] ]
	}
}

class Article {
	
	static enum Kind { Video, Blog, Article }
	
	@Accessors String title
	@Accessors Kind kind
	@Accessors String href
	@Accessors String img
	
	def void setArticle(String aTitle) {
		kind = Kind.Article
		title = aTitle
	}
	
	def void setBlog(String aTitle) {
		kind = Kind.Blog
		title = aTitle
	}
	
	def void setVideo(String aTitle) {
		kind = Kind.Video
		title = aTitle
	}
	
}