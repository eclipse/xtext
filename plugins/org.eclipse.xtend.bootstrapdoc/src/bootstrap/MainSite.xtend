package bootstrap

class MainSite {
	
	def header(String bootstrapPath) '''
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="utf-8">
			<title>Eclipse Xtend</title>
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<meta name="description" content="">
			<meta name="author" content="">

			<!-- Le styles -->
			<link href="«bootstrapPath»/css/bootstrap.min.css" rel="stylesheet">
			<style type="text/css">
			    code.prettyprint {
			        padding: 0px;
			        background-color: white;
					border: none;
			    }
				body {
					padding-top: 20px;
				}
				
				section {
					padding-top: 40px;
				}
				
				div#maincontainer>section {
					padding-top: 90px;
				}
			</style>
			<link href="«bootstrapPath»/css/bootstrap-responsive.min.css" rel="stylesheet">
			<link href="«bootstrapPath»/../google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
			<script type="text/javascript" src="«bootstrapPath»/../google-code-prettify/prettify.js"></script>
			<script type="text/javascript" src="«bootstrapPath»/../google-code-prettify/lang-xtend.js"></script>
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
				
			<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
			<!--[if lt IE 9]>
				<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<![endif]-->

			<!-- Le fav and touch icons -->
			<link rel="shortcut icon" href="«bootstrapPath»/ico/favicon.ico">
			<link rel="apple-touch-icon-precomposed" sizes="144x144" href="«bootstrapPath»/ico/apple-touch-icon-144-precomposed.png">
			<link rel="apple-touch-icon-precomposed" sizes="114x114" href="«bootstrapPath»/ico/apple-touch-icon-114-precomposed.png">
			<link rel="apple-touch-icon-precomposed" sizes="72x72" href="«bootstrapPath»/ico/apple-touch-icon-72-precomposed.png">
			<link rel="apple-touch-icon-precomposed" href="«bootstrapPath»/ico/apple-touch-icon-57-precomposed.png">
		</head>

		<body data-spy="scroll" data-target=".subnav" data-offset="50"  onload="prettyPrint()">
	'''
	
	def footer(String bootstrapPath) 
	'''
				<!-- Le javascript
				================================================== -->
				<!-- Placed at the end of the document so the pages load faster -->
	
				<script src="«bootstrapPath»/js/jquery.min.js"></script>
				<script src="«bootstrapPath»/js/bootstrap.min.js"></script>
			</body>
		</html>
	'''
}