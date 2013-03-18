package generator.xtend

class Community extends AbstractXtendWebsite {

	override path() {
		'community.html'
	}
	
	override contents() '''
		<div id="page">
			<div id="team" class="container clearfix"> 
				<h2>Resources</h2>
		        <hr>
				«entry('''
						icon-discussions-blue.png
					''','''
						Discussion Group
					''','''
						https://groups.google.com/group/xtend-lang
					''','''
						<p>The <strong>Xtend Google Group</strong> is the first source for getting answers in case you got stuck.
						The community is very friendly. 
						<br>Please ask any questions clearly and with sufficient information attached.</p>
					''')»
				«entry('''
						icon-bug-blue.png
					''','''
						Found a Bug?
					''','''
						https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Xtend
					''','''
						<p>Bug reports and enhancement request are tracked at <strong>bugs.eclipse.org</strong>. Please 
						explain the problem and provide a reduced but reproducable eample.
						Also please explain the concrete use case when requesting enhancements.</p>
					''')»
				«entry('''
						icon-twitter-blue.png
					''','''
						Xtend on Twitter
					''','''
						https://twitter.com/#!/xtendlang
					''','''
						<p>If you are on twitter and want to get notified about all things Xtend, you should consider following <strong>@xtendlang</strong>.</p>
					''')»
				«entry('''
						icon-google-blue.png
					''','''
						Xtend on Google +
					''','''
						https://plus.google.com/108502071045096808067/posts
					''','''
						<p>If you don't like Twitter but are on Google +. You might want to add Xtend to one of your circles.</p>
					''')»
			</div>
			<br/><br/>
			<br/><br/>
			«printArticles»
		</div>
	'''
	def printArticles() '''
		<div id="team" class="container clearfix"> 
				<h2>Articles and Blog Posts</h2>
				<hr>
				<div class="row">
				<div class="span1">&nbsp;</div>
				<div class="span9">
				<table class="table table-striped">
				«articles(
					[
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
		<tr><td>«IF article»Article: «ELSE»Blog: «ENDIF»</td><td><h2><a href="«href»">«title»</a></h2></td></tr>
	'''
	
	def entry(String img, String title, String link, String description) '''
		<div class="row">
			<div class="span1">&nbsp;</div>
			<div class="span9 team">
		    <a href="«link.trim»" class="anchor-in-div"></a>
		    <div class="row">
			  <div class="span4 ">
			    <img src="images/«img.trim»" alt="image" class="image_left">
			    <h3 style="padding-top: 0px; margin-top: 0px;">«title.trim»</h3>
			 	</div>
				<div class="span5 ">
					«description»
				</div>
				</div>
			</div>
		  <div class="span1">&nbsp;</div>
		</div>
	'''
	
	def articles((Article)=>void ... articles) {
		articles.map[ f | new Article => [ f.apply(it) ] ]
	}
}

class Article {
	
	@Property String title
	@Property boolean article
	@Property String href
	@Property String img
	
	def void setArticle(String aTitle) {
		article = true
		title = aTitle
	}
	def void setBlog(String aTitle) {
		article = false
		title = aTitle
	}
	
}