<?php

# Set the theme for your project's web pages.
# See the Committer Tools "How Do I" for list of themes
# https://dev.eclipse.org/committers/
# Optional: defaults to system theme 
$theme = "Nova";

# Define your project-wide Nav bars here.
# Format is Link text, link URL (can be http://www.someothersite.com/), target (_self, _blank), level (1, 2 or 3)
# these are optional
# $Nav->setLinkList(array());

$pageKeywords	= "xtext, dsl, modeling, domain specific language, textual";
$pageTitle 		= "Xtext Documentation";

$Menu->setMenuItemList(array());
$Menu->addMenuItem("Home", "/Xtext", "_self");
$Menu->addMenuItem("Download", "/Xtext/download", "_self");
$Menu->addMenuItem("Documentation", "/Xtext/documentation", "_self");
$Menu->addMenuItem("Support", "/Xtext/support", "_self");
$Menu->addMenuItem("Community", "/Xtext/community", "_self");
$Menu->addMenuItem("Developers", "/Xtext/developers", "_self");

$App->AddExtraHtmlHeader('<script src="/Xtext/js/jquery-1.4.4.min.js" type="text/javascript"></script>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" href="/Xtext/css/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet" charset="utf-8" />' . "\n\t"); 
$App->AddExtraHtmlHeader('<script src="/Xtext/js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>' . "\n\t"); 
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="/Xtext/style.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="/Xtext/style2.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="code.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="book.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="novaAddon.css"/>' . "\n\t");
$App->AddExtraHtmlHeader('<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
	$("a.gallery[rel^=\'prettyPhoto\']").prettyPhoto({animationSpeed:"slow",theme:"light_square",slideshow:2000,default_width: 640, default_height: 480, opacity: 0.40, slideshow: false});
});
</script>' . "\n\t");

$App->Promotion = TRUE;
?>
