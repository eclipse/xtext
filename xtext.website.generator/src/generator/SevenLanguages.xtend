package generator

class SevenLanguages extends AbstractWebsite {

	override path() {
		'7languages.html'
	}
	
	override contents() '''
		<!--Container-->
		<div id="header_wrapper" class="container" >
		</div>
		<div id="page" class="languages">
			<div class="container">
				<h1>7 Languages <small>- Learn By Example</small></h1>
				<hr />
				<div class="row">
					<div class="span6" style="margin:3px;">
						<p>
							Xtext has special support for languages that run on the Java Virtual Machine.
							This makes it very easy to intergrate fully featured statically typed expressions,
							complete Java type references and Java annotations anywhere in your language.
						</p>
						<p>
							On this page we provide 7 different languages showing how these concepts can be used.
						</p>
					</div>
					«language('Scripting Language','sevenLanguageDoc.html#scripting','images/red-glossy-scripting.png','''
					A simple scripting language that lets you write code into a blank file without any
							structural boilerplate like class or method definitions.<br/>
							Translates to a Java class with a main method.
					''')»
				</div>
				<div class="row">
					«language('Build Language','sevenLanguageDoc.html#build','images/red-glossy-helmet.png','''
							A little language that lets you define tasks and dependencies between them. 
							Much like a nice and concise ANT or a statically typed Gradle.
					''')»
					«language('DSL for MongoDB','sevenLanguageDoc.html#mongoDB','images/red-glossy-database.png','''
							This langauge lets you declare document structures for MongoDB and generates
							a handy Java API to interact with MongoDB in a statically typed and structured manner.
					''')»
				</div>
				<div class="row">
					«language('DSL for Guice','sevenLanguageDoc.html#guice','images/red-glossy-guice.png','''
							This language lets you declare guice modules in a more readable and declarative way, such that many of the runtime checks can
							be done at compile time.
					''')»
					«language('Http Routing Language','sevenLanguageDoc.html#httpRouting','images/red-glossy-web.png','''
							Web.xml on steroids and without the XML: Write a URL pattern and map it to a method call in Java.
							Similar to how the Play! framework does it, but with great Eclipse integration and not limited to static methods.
					''')»
				</div>
				<div class="row">
					«language('Template Language','sevenLanguageDoc.html#template','images/red-glossy-template.png','''
							A straight forward template language which allows for statically-typed expressions and 
							named arguments with default values.
					''')»
					«language('Little Tortoise','sevenLanguageDoc.html#tortoise','images/red-glossy-turtle.png','''
							Remember Logo? A cute little tortoise painting on a canvas what ever you want.
					''')»
				</div>
			</div>
		</div>
	'''
	def language(String title, String href, String img, CharSequence description) '''
		<div class="span6 float language-card">
		<a href="«href»" class="anchor-in-div"></a>
		<table>
			<tr>
				<td >
					<img class="language-icon" src="«img»" alt="Image" />
				</td>
				<td>
					<h2>«title»</h2>
					<p>
						«description»
					</p>
				</td>
			</tr>
		</table>
		</div>
	'''

	
}