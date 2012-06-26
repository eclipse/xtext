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
						icon_forum.png
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
						icon_bugzilla.png
					''','''
						File a Bug
					''','''
						https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Xtend
					''','''
						<p>Bug reports and enhancement request are tracked at <strong>bugs.eclipse.org</strong>. Please 
						explain the problem and provide a reduced but reproducable eample.
						Also please explain the concrete use case when requesting enhancements.</p>
					''')»
				«entry('''
						icon_twitter.png
					''','''
						Xtend on Twitter
					''','''
						https://twitter.com/#!/xtendlang
					''','''
						<p>If you are on twitter and want to get notified about all things Xtend, you should consider following <strong>@xtendlang</strong>.</p>
					''')»
				«entry('''
						icon_prof_support.png
					''','''
						Professional Support
					''','''
						http://xtext.itemis.com
					''','''
						<p>Need training or problem solving? 
						<br><strong>itemis</strong> offers all kinds of consulting around professional software development.</p>
					''')»
			</div>
			<br/><br/>
			<br/><br/>
		</div>
	'''
	
	def entry(String img, String title, String link, String description) '''
		<div class="row">
			<div class="span1">&nbsp;</div>
			<div class="span9 team">
		    <a href="«link.trim»" class="anchor-in-div"></a>
		    <div class="row">
			  <div class="span1 ">
			    <img src="images/«img.trim»" alt="image" class="image_left">
			  </div>
			  <div class="span2 ">
			    <h3>«title.trim»</h3>
			 	</div>
				<div class="span6 ">
					«description»
				</div>
				</div>
			</div>
		  <div class="span1">&nbsp;</div>
		</div>
	'''
	
}