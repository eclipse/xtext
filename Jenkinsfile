pipeline {
  agent {
    kubernetes {
      inheritFrom 'centos-8'
    }
  }
  
  environment {
    DOWNSTREAM_JOBS = 'xtext-xtend'
  }

  parameters {
    choice(name: 'TARGET_PLATFORM', choices: ['r202203', 'r202206', 'r202209', 'r202212', 'latest'], description: 'Which Target Platform should be used?')
    // see https://wiki.eclipse.org/Jenkins#JDK
    choice(name: 'JDK_VERSION', description: 'Which JDK should be used?', choices: [
       'temurin-jdk11-latest', 'temurin-jdk17-latest'
    ])
    booleanParam(
      name: 'TRIGGER_DOWNSTREAM_BUILD', 
      defaultValue: (env.BRANCH_NAME.startsWith('milestone')||env.BRANCH_NAME.startsWith('release')), 
      description: 'Should downstream jobs for the same branch be triggered on successful build?'
    )
  }

  triggers {
    parameterizedCron(env.BRANCH_NAME == 'master' ? '''
      H H(0-1) * * * %TARGET_PLATFORM=r202206;JDK_VERSION=temurin-jdk11-latest;TRIGGER_DOWNSTREAM_BUILD=true
      H H(3-4) * * * %TARGET_PLATFORM=latest;JDK_VERSION=temurin-jdk17-latest;TRIGGER_DOWNSTREAM_BUILD=true
      ''' : '')
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'5'))
    disableConcurrentBuilds()
    timeout(time: 300, unit: 'MINUTES')
  }

  tools {
     maven "apache-maven-3.8.6"
     jdk "${params.JDK_VERSION}"
  }

  stages {
    stage('Initialize') {
      steps {
        checkout scm
        
        script {
          currentBuild.displayName = String.format("#%s(JDK%s,Eclipse%s)", BUILD_NUMBER, javaVersion(), eclipseVersion())
        }
        
        sh '''
            sed_inplace() {
                if [[ "$OSTYPE" == "darwin"* ]]; then
                    sed -i '' "$@"
                else
                    sed -i "$@"
                fi
            }
            
            targetfiles="$(find releng -type f -iname '*.target')"
            for targetfile in $targetfiles
            do
                echo "Redirecting target platforms in $targetfile to $JENKINS_URL"
                sed_inplace "s?<repository location=\\".*/job/\\([^/]*\\)/job/\\([^/]*\\)/?<repository location=\\"$JENKINS_URL/job/\\1/job/\\2/?" $targetfile
            done
        '''
      }
    }

    stage('Build') {
      steps {
          wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
          sh """
            ./1-maven-build.sh -s /home/jenkins/.m2/settings.xml --tp=${selectedTargetPlatform()} --local-repository=/home/jenkins/.m2/repository
          """
          }
      }
    }
  }

  post {
    always {
      junit testResults: '**/target/surefire-reports/*.xml'
      archiveArtifacts artifacts: '**/target/work/data/.metadata/.log, **/hs_err_pid*.log'
    }
    success {
      archiveArtifacts artifacts: 'build/**, **/target/work/data/.metadata/.log'
      script {
        if (params.TRIGGER_DOWNSTREAM_BUILD==true) {
          DOWNSTREAM_JOBS.split(',').each {
            def downstreamUrl = new URL("${env.JENKINS_URL}/job/$it/job/${env.BRANCH_NAME}")
            def boolean downstreamJobExists = sh(script: "curl -L -s -o /dev/null -I -w '%{http_code}' ${downstreamUrl}", returnStdout: true) == "200"
            if (downstreamJobExists) {
              build job: "$it/${env.BRANCH_NAME}", wait: false, parameters: [booleanParam(name: 'TRIGGER_DOWNSTREAM_BUILD', value: "${params.TRIGGER_DOWNSTREAM_BUILD}"), string(name: 'JDK_VERSION', value: "${params.JDK_VERSION}")]
            }
          }
        }
      }
    }
    cleanup {
      script {
        def curResult = currentBuild.currentResult
        def lastResult = 'NEW'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }

        if (curResult != 'SUCCESS' || lastResult != 'SUCCESS') {
          def color = ''
          switch (curResult) {
            case 'SUCCESS':
              color = '#00FF00'
              break
            case 'UNSTABLE':
              color = '#FFFF00'
              break
            case 'FAILURE':
              color = '#FF0000'
              break
            default: // e.g. ABORTED
              color = '#666666'
          }

          slackSend (
            message: "${lastResult} => ${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>",
            botUser: true,
            channel: 'xtext-builds',
            color: "${color}"
          )
        }
      }
    }
  }
}

/** return the Java version as Integer (8, 11, ...) */
def javaVersion() {
  return Integer.parseInt(params.JDK_VERSION.replaceAll(".*-jdk(\\d+).*", "\$1"))
}

/** returns true when this build was triggered by an upstream build */
def isTriggeredByUpstream() {
  return !"[]".equals(currentBuild.getBuildCauses('org.jenkinsci.plugins.workflow.support.steps.build.BuildUpstreamCause').toString())
}

/**
 * Returns the Eclipse version dependent on the selected target platform.
 * Result: '4.XX'
 */
def eclipseVersion() {
  def targetPlatform = selectedTargetPlatform()
  if (targetPlatform == 'latest') {
    return "4.27"
  } else {
    def baseDate = java.time.LocalDate.parse("2018-06-01") // 4.8 Photon
    def df = java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")
    def targetDate = java.time.LocalDate.parse(targetPlatform.substring(1)+"01", df)
    long monthsBetween = java.time.temporal.ChronoUnit.MONTHS.between(baseDate, targetDate);
    return "4."+ (8+(monthsBetween/3))
  } 
}

/**
 * The target platform is primarily defined by the build parameter TARGET_PLATFORM.
 * But when the build is triggered by upstream with at least Java version 11, 'latest'
 * is returned.
 */
def selectedTargetPlatform() {
    def tp = params.TARGET_PLATFORM
    def isUpstream = isTriggeredByUpstream()
    def javaVersion = javaVersion()
    
    if (isTriggeredByUpstream() && javaVersion>=17) {
        println("Choosing 'latest' target since this build was triggered by upstream with Java ${javaVersion}")
        return 'latest'
    } else if (isTriggeredByUpstream() && javaVersion>=11) {
        println("Choosing 'r202203' target since this build was triggered by upstream with Java ${javaVersion}")
        return 'r202203'
    } else {
        return tp
    }
}

