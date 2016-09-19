set classpath=.;.\jars\mytools.jar;.\classes

javac -d classes *.java
rmic  -d classes ch.scjd.project.AdressDBImpl

start rmiregistry
pause

start java ch.scjd.project.AdressDBReg
pause

java ch.scjd.project.MenueMain
pause