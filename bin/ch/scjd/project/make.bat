
rem --------------------------------------------
rem make fuer SunCertifiedJavaDevelopper-Project
rem --------------------------------------------

del *.jar

javac -d . *.java

jar -cmf  manifest.mf scjdProject.jar ch\jmildner\scjdProject\*.class 

rd ch /s

set classpath=.\scjdProject.jar;%classpath%
java ch.jmildner.scjdProject.SwingApplicationMain
