#!/bin/bash 

usage ()
{
  echo "----------------------------------------------------------"
  echo "Usage   : fixVersions.sh -f <from_version> [-t <to_version>]"
  echo "Example : fixVersions.sh -f '2.15.0' -t '2.16.0'"
  echo "Example : fixVersions.sh -f '2.15.0' "
  echo "Note: '-t' is optional, if not given it will be derived from '-f'"
  echo "----------------------------------------------------------"
  exit
}

checkVersionFormat()
{
 re='^[0-9]\.[0-9]+\.[0-9]$'
  if ! [[ $1 =~ $re ]] ; then
     echo "Error: Version is not in proper format" 
     usage
  fi
}

deriveToVersion()
{
  re='^([0-9])\.([0-9]+)\.([0-9])$'
  if [[ $from =~ $re ]]; then
    majorVersion="${BASH_REMATCH[1]}"
    minorVersion="${BASH_REMATCH[2]}"
    bugFixVersion="${BASH_REMATCH[3]}"
    to=$majorVersion.$(($minorVersion + 1)).$bugFixVersion
    echo "# to_version: $to"
  fi
}

#ToDo: not used right now
deriveFromVersion()
{
  MVNVersion=$(mvn -f ./releng/pom.xml -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
  echo "# MVN version from pom $MVNVersion"
  from_version=`echo $MVNVersion | sed -e 's/[^0-9][^0-9]*$//'`
  echo "# Derived from_version from MVN version $from_version"
}

if [ $# -lt 2 ] || [ $# -gt 4 ] ; then
    usage
fi

while [ "$1" != "" ]; do
  case $1 in
        -f ) shift 
             from=$1 ;;
        -t ) shift 
             to=$1 ;;
         *)  echo "unknown: option $1" 
             usage
  esac
shift
done

echo "# from_version: $from"
echo "# to_version: $to" 

checkVersionFormat "$from"

if [ -z "$to" ]; then
    echo "# 'to_version' is unset or set to the empty string"
    echo "# deriving 'to_version' from 'from_verison'"
    deriveToVersion
fi

checkVersionFormat "$to"

xargs_sed_inplace() {
	if [[ "$OSTYPE" == "darwin"* ]]; then
		xargs sed -i '' "$@"
	else
		xargs sed -i "$@" 
	fi	
}

currentPath="`dirname \"$0\"`"

find $currentPath -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/${from}.qualifier/${to}.qualifier/g"
find $currentPath -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/;version=\"${from}\"/;version=\"${to}\"/g"
find $currentPath -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/org.eclipse.xtext.xbase.lib;bundle-version=\"${from}\"/org.eclipse.xtext.xbase.lib;bundle-version=\"${to}\"/g"
find $currentPath -type f -name "MANIFEST.MF" | xargs_sed_inplace -e "s/org.eclipse.xtend.lib;bundle-version=\"${from}\"/org.eclipse.xtend.lib;bundle-version=\"${to}\"/g"
find $currentPath -type f -name "MANIFEST.MF_gen" | xargs_sed_inplace -e "s/${from}.qualifier/${to}.qualifier/g"
find $currentPath -type f -name "pom.xml" | xargs_sed_inplace -e "s/${from}-SNAPSHOT/${to}-SNAPSHOT/g"
find $currentPath -type f -name "maven-pom.xml" | xargs_sed_inplace -e "s/${from}-SNAPSHOT/${to}-SNAPSHOT/g"
find $currentPath -type f -name "tycho-pom.xml" | xargs_sed_inplace -e "s/${from}-SNAPSHOT/${to}-SNAPSHOT/g"
find $currentPath -type f -name "versions.gradle" | xargs_sed_inplace -e "s/version = '${from}-SNAPSHOT'/version = '${to}-SNAPSHOT'/g"
find $currentPath -type f -name "feature.xml" | xargs_sed_inplace -e "s/version=\"${from}.qualifier\"/version=\"${to}.qualifier\"/g"
find $currentPath -type f -name "feature.xml" | xargs_sed_inplace -e "s/version=\"${from}\" match=\"equivalent\"/version=\"${to}\" match=\"equivalent\"/g"
find $currentPath -type f -name "category.xml" | xargs_sed_inplace -e "s/version=\"${from}.qualifier\"/version=\"${to}.qualifier\"/g"
find $currentPath -type f -name "plugin.xml" | xargs_sed_inplace -e "s/<version>${from}-SNAPSHOT<\/version>/<version>${to}-SNAPSHOT<\/version>/g"
