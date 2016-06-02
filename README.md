1. Make sure you have antlr-3.3-complete.jar in your CLASSPATH
2. java org.antlr.Tool OSMLexer.g
3. java org.antlr.Tool OSMParser.g
4. java org.antlr.Tool OSMTreeParser.g
5. javac *.java
6. java Main osm/test-file.osm

Note: It's okay to get "internal error: Can't get property indirectDelegates" at 3. or 4., if you want to get rid of it try changing the JDK from 1.8 to 1.7 as described here: https://github.com/ttsiodras/asn1scc/issues/10
