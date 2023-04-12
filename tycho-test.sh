#!/usr/bin/env bash

# Use TARGET_PLATFORM from environment and 'r202203' as default.
# Overridable by 'tp' command-line arg
if [ -z "$TARGET_PLATFORM" ]; then
  TARGET_PLATFORM=r202203
fi

MVN_ARGS=(\
  --fae \
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
)

# args parsing inspired by https://gist.github.com/jehiah/855086
while [ "$1" != "" ]; do
  PARAM=`echo $1 | awk -F= '{print $1}'`
  VALUE=`echo $1 | awk -F= '{print $2}'`
  case $PARAM in
    -h | --help)
      echo "Perform Maven build for xtext-xtend"
      echo ""
      echo "./1-maven-build.sh"
      echo -e "\t-h --help"
      echo -e "\t--no-tests Skip test execution"
      echo -e "\t--local-repository=<PATH> Use local Maven repository"
      echo -e "\t--tp=$TARGET_PLATFORM (valid values: r202203,r202206,...,latest)"
      echo ""
      exit
      ;;
    --no-tests)
      MVN_ARGS+=(-DskipTests=true)
      ;;
    --local-repository)
      MVN_ARGS+=" -Dmaven.repo.local=$VALUE"
      ;;
    --tp)
      MVN_ARGS+=" -Dtarget-platform-classifier=xtext-$VALUE"
      ;;
    *)
      # append any additionally passed arg
      if [ -z "$VALUE" ]; then
        MVN_ARGS+=($PARAM)
      else
        MVN_ARGS+=($PARAM=$VALUE)
      fi
      ;;
  esac
  shift
done

MVN_ARGS+=(-PuseJenkinsSnapshots)

echo mvn -B -f org.eclipse.xtext.p2.releng ${MVN_ARGS[@]} $@

#echo "Using target platform '$TARGET_PLATFORM'"
mvn -B \
  -f org.eclipse.xtext.p2.releng \
  clean verify \
  ${MVN_ARGS[@]} \
  $@
