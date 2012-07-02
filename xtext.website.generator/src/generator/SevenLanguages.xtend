package generator

class SevenLanguages extends AbstractWebsite {

	override path() {
		'7languages.html'
	}
	
	override contents() '''
		<!--Container-->
		<div id="header_wrapper" class="container" >
			<div class="inner">
				<div class="container">
					<div class="page-heading"><h1>7 Languages</h1></div>
				</div> <!-- /.container -->
			</div> <!-- /inner -->
		</div>
		<div id="page">  
			<div id="features">
				<div class="container">
					<br /> <br />
					<h1>7 Languages</h1>
					<hr />
					<div class="row">
						<div class="span6">
							<p>
								Building domain-specific languages (DSLs) for the structural parts of an application has always been rather 
								simple with Xtext. Nevertheless, when it came to the behavioral parts, users often fell back to implementing 
								them in the target language, e.g. Java. The reason is that expressions, which are usually the part of a language 
								that describe behavior, are hard to get right and very costly to implement. There are two major drawbacks with
								this apporach: First, information that belongs to a single concept is spread across multiple artifacts in several 
								languages on different layers of abstraction. Second, you need rather complex and error prone patterns such 
								as protected  regions or generation gap to integrate the manually written code with the generated one.
							</p>
						</div>
						«language('Scripting Language','images/red-glossy-scripting.png','''
						A simple scripting language that lets you write code into a blank file without any
								structural boilerplate like class or method definitions.<br/>
								Translates to a Java class with a main method.
						''')»
					</div>
					<div class="row">
						«language('Build Language','images/red-glossy-helmet.png','''
								A little language that lets you define tasks and dependencies between them. 
								Much like a nice and concise ANT or a statically typed Gradle.
						''')»
						«language('DSL for MongoDB','images/red-glossy-database.png','''
								This langauge lets you declare document structures for MongoDB and generates
								a handy Java API to interact with MongoDB in a statically typed and structured manner.
						''')»
					</div>
					<div class="row">
						«language('DSL for Guice','images/red-glossy-guice.png','''
								This language lets you declare guice modules in a more readable and declarative way, such that many of the runtime checks can
								be done at compile time.
						''')»
						«language('Http Routing Language','images/red-glossy-web.png','''
								Web.xml on steroids and without the XML: Write a URL pattern and map it to a method call in Java.
								Similar to how the Play! framework does it, but with great Eclipse integration and not limited to static methods.
						''')»
					</div>
					<div class="row">
						«language('Template Language','images/red-glossy-template.png','''
								A straight forward template language which allows for statically-typed expressions and 
								named arguments with default values.
						''')»
						«language('Little Tortoise','images/red-glossy-turtle.png','''
								Remember Logo? A cute little tortoise painting on a canvas what ever you want.
						''')»
					</div>
				</div>
			</div>
		</div>
	'''
	def language(String title, String img, CharSequence description) '''
		<div class="span6 float language-card">
		<table>
			<tr>
				<td >
					<img class="language-icon" src="«img»" alt="Image" />
				</td>
				<td>
					<h4>«title»</h4>
					<p>
						«description»
					</p>
				</td>
			</tr>
		</table>
		</div>
		<!--<div class="span6 float language-card">
			<div class="thumb">
				<img class="language-icon"
					src="«img»" alt="Image" />
			</div>
			<h4>«title»</h4>
			<p>
				«description»
			</p>
		</div>-->
	'''

	
}